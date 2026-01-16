package com.library.admin.modules.operationlog.service;

import com.library.admin.modules.operationlog.entity.OperationLog;
import com.library.admin.modules.operationlog.vo.OperationLogVO;
import com.library.admin.modules.operationlog.bo.OperationLogPage;
import com.library.admin.modules.operationlog.bo.OperationLogInsert;
import com.library.admin.modules.operationlog.bo.OperationLogUpdate;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;
 
/**
 * @Author makejava
 * @Desc 操作日誌資料表(OperationLog)表服务接口
 * @Date 2026-01-17 00:55:54
 */
public interface OperationLogService extends IService<OperationLog> {
 
    /**
     * 分页查询
     */
    IPage<OperationLogVO> queryByPage(OperationLogPage page);
 
    /**
     * 根据ID查详情
     */
    OperationLogVO queryById(Integer id);
    
    /**
     * 新增数据
     */
    boolean insert(OperationLogInsert operationLogInsert);
 
    /**
     * 修改数据
     */
    boolean update(OperationLogUpdate operationLogUpdate);
 
    /**
     * 通过主键删除数据
     */
    boolean deleteById(Integer id);
 
}
