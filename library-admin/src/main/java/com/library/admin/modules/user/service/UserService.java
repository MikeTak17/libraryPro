package com.library.admin.modules.user.service;

import com.library.admin.modules.user.entity.User;
import com.library.admin.modules.user.vo.UserVO;
import com.library.admin.modules.user.bo.UserPage;
import com.library.admin.modules.user.bo.UserInsert;
import com.library.admin.modules.user.bo.UserUpdate;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;
 
/**
 * @Author makejava
 * @Desc 使用者資料表(User)表服务接口
 * @Date 2026-02-12 17:44:22
 */
public interface UserService extends IService<User> {
 
    /**
     * 分页查询
     */
    IPage<UserVO> queryByPage(UserPage page);
 
    /**
     * 根据ID查详情
     */
    UserVO queryById(Integer id);
    
    /**
     * 新增数据
     */
    boolean insert(UserInsert userInsert);
 
    /**
     * 修改数据
     */
    boolean update(UserUpdate userUpdate);
 
    /**
     * 通过主键删除数据
     */
    boolean deleteById(Integer id);
 
}
