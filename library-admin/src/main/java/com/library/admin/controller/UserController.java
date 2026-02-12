package com.library.admin.controller;

import com.library.admin.modules.user.vo.UserVO;
import com.library.admin.modules.user.bo.UserPage;
import com.library.admin.modules.user.bo.UserInsert;
import com.library.admin.modules.user.bo.UserUpdate;
import com.library.admin.modules.user.service.UserService;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.library.common.response.Result;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import java.util.Objects;

 
/**
 * @Author makejava
 * @Desc 使用者資料表(User)表控制层
 * @Date 2026-02-12 17:44:22
 */

@RestController
@RequestMapping("user")
public class UserController {
 
    @Resource
    private UserService userService;
 
 
    /**
     * 分页查询列表
     *
     * @return 数据
     */
    @GetMapping("/list")
    public Result<IPage<UserVO>> queryByPage(@Valid UserPage page) {
        return Result.success(userService.queryByPage(page));
    }
    
    /**
     * 根据ID获取数据
     *
     * @return 单个使用者資料表数据
     */
    @PostMapping("/queryById/{id}")
    public Result<UserVO> queryById(@PathVariable("id") Integer id) {
        return Result.success(userService.queryById(id));
    }
 
 
    /**
     * 添加使用者資料表
     *
     * @return 新增使用者資料表数据
     */
    @PostMapping("/insert")
    public Result insert(@Valid @RequestBody UserInsert param) {
        userService.insert(param);
        return Result.success();
    }
 
 
    /**
     * 编辑使用者資料表
     *
     * @return 编辑使用者資料表数据
     */
    @PutMapping("/update")
    public Result update(@Valid @RequestBody UserUpdate param) {
        if(Objects.isNull(param.getId())){
            return Result.error("ID不能为空");
        }
        userService.update(param);
        return Result.success();
    }
 
    /**
     * 删除使用者資料表
     *
     * @return 删除使用者資料表数据
     */
    @DeleteMapping("/delete/{id}")
    public Result deleteById(@PathVariable("id") Integer id) {
        userService.deleteById(id);
        return Result.success();
    }
}
