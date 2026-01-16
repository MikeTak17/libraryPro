package com.library.admin.modules.operationlog.struct;

import org.mapstruct.*;
import com.library.admin.modules.operationlog.entity.OperationLog;
import com.library.admin.modules.operationlog.vo.OperationLogVO;
import com.library.admin.modules.operationlog.bo.OperationLogInsert;
import com.library.admin.modules.operationlog.bo.OperationLogUpdate;

/**
 * 操作日誌資料表(OperationLog)对象映射转换
 *
 * @author makejava
 * @since 2026-01-17
 */
@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface OperationLogStructMapper {
  
    OperationLog updateToOperationLog(OperationLogUpdate update);
    
    OperationLog insertToOperationLog(OperationLogInsert insert);
    
    OperationLogVO operationLogToOperationLogVO(OperationLog operationLog);
    
}

