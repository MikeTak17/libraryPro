package com.library.admin.modules.user.struct;

import org.mapstruct.*;
import com.library.admin.modules.user.entity.User;
import com.library.admin.modules.user.vo.UserVO;
import com.library.admin.modules.user.bo.UserInsert;
import com.library.admin.modules.user.bo.UserUpdate;

/**
 * 使用者資料表(User)对象映射转换
 *
 * @author makejava
 * @since 2026-02-12
 */
@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UserStructMapper {
  
    User updateToUser(UserUpdate update);
    
    User insertToUser(UserInsert insert);
    
    UserVO userToUserVO(User user);
    
}

