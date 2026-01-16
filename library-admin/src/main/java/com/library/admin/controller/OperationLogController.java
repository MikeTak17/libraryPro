package com.library.admin.controller;

import com.library.admin.modules.operationlog.vo.OperationLogVO;
import com.library.admin.modules.operationlog.bo.OperationLogPage;
import com.library.admin.modules.operationlog.bo.OperationLogInsert;
import com.library.admin.modules.operationlog.bo.OperationLogUpdate;
import com.library.admin.modules.operationlog.service.OperationLogService;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.library.common.response.Result;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import java.util.Objects;

 
/**
 * @Author makejava
 * @Desc 操作日誌資料表(OperationLog)表控制层
 * @Date 2026-01-17 00:55:53
 */

@RestController
@RequestMapping("operationlog")
public class OperationLogController {
 
    @Resource
    private OperationLogService operationLogService;
 
 
    /**
     * 分页查询列表
     *
     * @return 数据
     */
    @GetMapping("/list")
    public Result<IPage<OperationLogVO>> queryByPage(@Valid OperationLogPage page) {
        return Result.success(operationLogService.queryByPage(page));
    }
    
    /**
     * 根据ID获取数据
     *
     * @return 单个操作日誌資料表数据
     */
    @PostMapping("/queryById/{id}")
    public Result<OperationLogVO> queryById(@PathVariable("id") Integer id) {
        return Result.success(operationLogService.queryById(id));
    }
 
 
    /**
     * 添加操作日誌資料表
     *
     * @return 新增操作日誌資料表数据
     */
    @PostMapping("/insert")
    public Result insert(@Valid @RequestBody OperationLogInsert param) {
        operationLogService.insert(param);
        return Result.success();
    }
 
 
    /**
     * 编辑操作日誌資料表
     *
     * @return 编辑操作日誌資料表数据
     */
    @PutMapping("/update")
    public Result update(@Valid @RequestBody OperationLogUpdate param) {
        if(Objects.isNull(param.getId())){
            return Result.error("ID不能为空");
        }
        operationLogService.update(param);
        return Result.success();
    }
 
    /**
     * 删除操作日誌資料表
     *
     * @return 删除操作日誌資料表数据
     */
    @DeleteMapping("/delete/{id}")
    public Result deleteById(@PathVariable("id") Integer id) {
        operationLogService.deleteById(id);
        return Result.success();
    }
}
