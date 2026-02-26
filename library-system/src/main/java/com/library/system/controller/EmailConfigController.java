package com.library.system.controller;

import com.library.common.response.Result;
import com.library.system.modules.emailconfig.bo.EmailConfigInsert;
import com.library.system.modules.emailconfig.bo.EmailConfigUpdate;
import com.library.system.modules.emailconfig.service.EmailConfigService;
import com.library.system.modules.emailconfig.vo.EmailConfigVO;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;


/**
 * @Author makejava
 * @Desc 郵件配置(EmailConfig)表控制层
 * @Date 2026-02-26 19:18:24
 */

@RestController
@RequestMapping("emailconfig")
public class EmailConfigController {

    @Resource
    private EmailConfigService emailConfigService;


    /**
     * 分页查询列表
     *
     * @return 数据
     */
    @GetMapping("/list")
    public Result<List<EmailConfigVO>> list() {
        List<EmailConfigVO> voList = emailConfigService.emailConfigList();
        return Result.success(voList);
    }

    /**
     * 根据ID获取数据
     *
     * @return 单个郵件配置数据
     */
    @PostMapping("/queryById/{id}")
    public Result<EmailConfigVO> queryById(@PathVariable("id") Integer id) {
        return Result.success(emailConfigService.queryById(id));
    }


    /**
     * 添加郵件配置
     *
     * @return 新增郵件配置数据
     */
    @PostMapping("/insert")
    public Result insert(@Valid @RequestBody EmailConfigInsert param) {
        emailConfigService.insert(param);
        return Result.success();
    }


    /**
     * 编辑郵件配置
     *
     * @return 编辑郵件配置数据
     */
    @PutMapping("/update")
    public Result update(@Valid @RequestBody EmailConfigUpdate param) {
        if (Objects.isNull(param.getId())) {
            return Result.error("ID不能为空");
        }
        emailConfigService.update(param);
        return Result.success();
    }

    /**
     * 删除郵件配置
     *
     * @return 删除郵件配置数据
     */
    @DeleteMapping("/delete/{id}")
    public Result deleteById(@PathVariable("id") Integer id) {
        emailConfigService.deleteById(id);
        return Result.success();
    }
}
