package com.library.system.modules.file.struct;

import org.mapstruct.*;
import com.library.system.modules.file.entity.File;
import com.library.system.modules.file.vo.FileVO;

/**
 * 使用者資料表(File)对象映射转换
 *
 * @author makejava
 * @since 2026-02-12
 */
@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface FileStructMapper {

    File updateToFile(FileUpdate update);

    File insertToFile(FileInsert insert);

    FileVO fileToFileVO(File file);

}

