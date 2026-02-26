package com.library.system.modules.emailconfig.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.library.system.modules.emailconfig.bo.EmailConfigInsert;
import com.library.system.modules.emailconfig.bo.EmailConfigUpdate;
import com.library.system.modules.emailconfig.entity.EmailConfig;
import com.library.system.modules.emailconfig.vo.EmailConfigVO;

import java.util.List;

/**
 * @Author makejava
 * @Desc 郵件配置(EmailConfig)表服务接口
 * @Date 2026-02-26 19:18:25
 */
public interface EmailConfigService extends IService<EmailConfig> {
    /**
     * 分页查询
     */
    List<EmailConfigVO> emailConfigList();
    /**
     * 根据ID查详情
     */
    EmailConfigVO queryById(Integer id);

    /**
     * 新增数据
     */
    boolean insert(EmailConfigInsert emailConfigInsert);

    /**
     * 修改数据
     */
    boolean update(EmailConfigUpdate emailConfigUpdate);

    /**
     * 通过主键删除数据
     */
    boolean deleteById(Integer id);

    EmailConfig getSendEmail();

}
