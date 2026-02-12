package com.library.admin.modules.user.service.impl;
 
import com.library.admin.modules.user.entity.User;
import com.library.admin.modules.user.vo.UserVO;
import com.library.admin.modules.user.bo.UserPage;
import com.library.admin.modules.user.bo.UserInsert;
import com.library.admin.modules.user.bo.UserUpdate;
import com.library.admin.modules.user.mapper.UserMapper;
import com.library.admin.modules.user.struct.UserStructMapper;
import com.library.admin.modules.user.service.UserService;
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
 * @Desc 使用者資料表(User)表服务实现类
 * @Date 2026-02-12 17:44:22
 */

@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
 
    @Resource
    private UserStructMapper userStructMapper;
    @Resource
    private UserMapper userMapper;

 
    @Override
    public IPage<UserVO> queryByPage(UserPage page) {
        // 查询条件
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        // 查询分页数据
        Page<User> userPage = new Page<User>(page.getCurrent(), page.getSize());
        IPage<User> pageData = baseMapper.selectPage(userPage, queryWrapper);
        
        //转换成vo
        IPage<UserVO> records = PageCovertUtil.pageVoCovert(pageData, UserVO.class);
        return records;
    }
 
 
    @Override
    public UserVO queryById(Integer id) {
        User user = baseMapper.selectById(id);
        return userStructMapper.userToUserVO(user);
    }
    
    @Override
    public boolean insert(UserInsert userInsert) {
        User user = userStructMapper.insertToUser(userInsert);
        save(user);
        return true;
    }

   
    @Override
    public boolean update(UserUpdate userUpdate) {
        User user = userStructMapper.updateToUser(userUpdate);
        updateById(user);
        return true;
    }
    
    @Override
    public boolean deleteById(Integer id) {
        return removeById(id);
    }
    
}
