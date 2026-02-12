package com.library.system.controller;

import com.library.system.modules.file.vo.FileVO;
import com.library.system.modules.file.bo.FilePage;
import com.library.system.modules.file.service.FileService;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.library.common.response.Result;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;

import java.util.Objects;


/**
 * @Author makejava
 * @Desc 使用者資料表(File)表控制层
 * @Date 2026-02-12 20:01:39
 */

@RestController
@RequestMapping("file")
public class FileController {

    @Resource
    private FileService fileService;


    /**
     * 分页查询列表
     *
     * @return 数据
     */
    @GetMapping("/list")
    public Result<IPage<FileVO>> queryByPage(@Valid FilePage page) {
        return Result.success(fileService.queryByPage(page));
    }

    /**
     * 根据ID获取数据
     *
     * @return 单个使用者資料表数据
     */
    @PostMapping("/queryById/{id}")
    public Result<FileVO> queryById(@PathVariable("id") Integer id) {
        return Result.success(fileService.queryById(id));
    }


    /**
     * 添加使用者資料表
     *
     * @return 新增使用者資料表数据
     */
    @PostMapping("/insert")
    public Result insert(@Valid @RequestBody FileInsert param) {
        fileService.insert(param);
        return Result.success();
    }


    /**
     * 编辑使用者資料表
     *
     * @return 编辑使用者資料表数据
     */
    @PutMapping("/update")
    public Result update(@Valid @RequestBody FileUpdate param) {
        if (Objects.isNull(param.getId())) {
            return Result.error("ID不能为空");
        }
        fileService.update(param);
        return Result.success();
    }

    /**
     * 删除使用者資料表
     *
     * @return 删除使用者資料表数据
     */
    @DeleteMapping("/delete/{id}")
    public Result deleteById(@PathVariable("id") Integer id) {
        fileService.deleteById(id);
        return Result.success();
    }
}
