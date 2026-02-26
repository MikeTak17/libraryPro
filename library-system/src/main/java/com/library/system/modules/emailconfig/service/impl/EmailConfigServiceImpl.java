package com.library.system.modules.emailconfig.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.library.common.enums.StatusEnum;
import com.library.common.util.EncryptUtil;
import com.library.system.modules.emailconfig.bo.EmailConfigInsert;
import com.library.system.modules.emailconfig.bo.EmailConfigUpdate;
import com.library.system.modules.emailconfig.entity.EmailConfig;
import com.library.system.modules.emailconfig.mapper.EmailConfigMapper;
import com.library.system.modules.emailconfig.service.EmailConfigService;
import com.library.system.modules.emailconfig.struct.EmailConfigStructMapper;
import com.library.system.modules.emailconfig.vo.EmailConfigVO;
import jakarta.annotation.Resource;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;


/**
 * @Author makejava
 * @Desc 郵件配置(EmailConfig)表服务实现类
 * @Date 2026-02-26 19:18:25
 */

@Log4j2
@Service("emailConfigService")
public class EmailConfigServiceImpl extends ServiceImpl<EmailConfigMapper, EmailConfig> implements EmailConfigService {

    @Resource
    private EmailConfigStructMapper emailConfigStructMapper;
    @Resource
    private EmailConfigMapper emailConfigMapper;


    @Override
    public List<EmailConfigVO> emailConfigList() {
        //SELECT * FROM email_config
        List<EmailConfig> list = list();
        List<EmailConfigVO> emailConfigVOS = emailConfigStructMapper.configListToEmailConfigVO(list);
        if (CollUtil.isNotEmpty(emailConfigVOS)){
            emailConfigVOS.forEach(v-> {
                v.setEmailStatusName(StatusEnum.getValue(v.getEmailStatus()));
                try{
                    v.setPass(EncryptUtil.desDecrypt(v.getPass()));
                } catch (Exception e){
                    log.error("郵件配置密碼還原失敗: id為{}", v.getId());
                }
            });
        }
        return emailConfigVOS;
    }


    @Override
    public EmailConfigVO queryById(Integer id) {
        EmailConfig emailConfig = baseMapper.selectById(id);
        return emailConfigStructMapper.emailConfigToEmailConfigVO(emailConfig);
    }

    @Override
    public boolean insert(EmailConfigInsert emailConfigInsert) {
        EmailConfig emailConfig = emailConfigStructMapper.insertToEmailConfig(emailConfigInsert);
        //加密
        try{
            emailConfig.setPass(EncryptUtil.desEncrypt(emailConfig.getPass()));
        } catch (Exception e){
            e.printStackTrace();
        }
        save(emailConfig);
        return true;
    }

    @Override
    public boolean update(EmailConfigUpdate emailConfigUpdate) {
        EmailConfig emailConfig = emailConfigStructMapper.updateToEmailConfig(emailConfigUpdate);
        updateById(emailConfig);
        return true;
    }

    @Override
    public boolean deleteById(Integer id) {
        return removeById(id);
    }

    @Override
    public EmailConfig getSendEmail(){
        //查詢狀態為正常的配置
        List<EmailConfig> emailConfigs = lambdaQuery().eq(EmailConfig::getEmailStatus, StatusEnum.NORMAL.getCode()).list();
        if (CollUtil.isNotEmpty(emailConfigs)){
            Random random = new Random();
            //生成一個隨機索引
            //隨機是為了做平衡負載
            int randomIndex = random.nextInt(emailConfigs.size());
            EmailConfig emailConfig = emailConfigs.get(randomIndex);
            return emailConfig;
        }
        return null;
    }
}
