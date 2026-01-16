package com.library.admin.modules.operationlog.service.impl;
 
import com.library.admin.modules.operationlog.entity.OperationLog;
import com.library.admin.modules.operationlog.vo.OperationLogVO;
import com.library.admin.modules.operationlog.bo.OperationLogPage;
import com.library.admin.modules.operationlog.bo.OperationLogInsert;
import com.library.admin.modules.operationlog.bo.OperationLogUpdate;
import com.library.admin.modules.operationlog.mapper.OperationLogMapper;
import com.library.admin.modules.operationlog.struct.OperationLogStructMapper;
import com.library.admin.modules.operationlog.service.OperationLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import jakarta.annotation.Resource;
import com.library.common.util.PageCovertUtil;

 
/**
 * @Author makejava
 * @Desc 操作日誌資料表(OperationLog)表服务实现类
 * @Date 2026-01-17 00:55:55
 */

@Service("operationLogService")
public class OperationLogServiceImpl extends ServiceImpl<OperationLogMapper, OperationLog> implements OperationLogService {
 
    @Resource
    private OperationLogStructMapper operationLogStructMapper;
    @Resource
    private OperationLogMapper operationLogMapper;

 
    @Override
    public IPage<OperationLogVO> queryByPage(OperationLogPage page) {
        // 查询条件
        LambdaQueryWrapper<OperationLog> queryWrapper = new LambdaQueryWrapper<>();
        // 查询分页数据
        Page<OperationLog> operationLogPage = new Page<OperationLog>(page.getCurrent(), page.getSize());
        IPage<OperationLog> pageData = baseMapper.selectPage(operationLogPage, queryWrapper);
        
        //转换成vo
        IPage<OperationLogVO> records = PageCovertUtil.pageVoCovert(pageData, OperationLogVO.class);
        return records;
    }
 
 
    @Override
    public OperationLogVO queryById(Integer id) {
        OperationLog operationLog = baseMapper.selectById(id);
        return operationLogStructMapper.operationLogToOperationLogVO(operationLog);
    }
    
    @Override
    public boolean insert(OperationLogInsert operationLogInsert) {
        OperationLog operationLog = operationLogStructMapper.insertToOperationLog(operationLogInsert);
        save(operationLog);
        return true;
    }

   
    @Override
    public boolean update(OperationLogUpdate operationLogUpdate) {
        OperationLog operationLog = operationLogStructMapper.updateToOperationLog(operationLogUpdate);
        updateById(operationLog);
        return true;
    }
    
    @Override
    public boolean deleteById(Integer id) {
        return removeById(id);
    }
    
}
