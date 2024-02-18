package com.example.rm.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.rm.common.QueryPageParam;
import com.example.rm.common.Result;
import com.example.rm.entity.User;
import com.example.rm.service.IUserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 杨婧媛
 * @since 2024-01-19
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService iUserService;
    @GetMapping("/list")
    public List<User> getUserList(){
        return iUserService.list();
    }

    //登录
    @PostMapping("/login")
    public Result login(@RequestBody User user) {
        List list = iUserService.lambdaQuery()
                .eq(User::getNo, user.getNo())
                .eq(User::getPassword, user.getPassword()).list();
        return list.size()>0?Result.success(list.get(0)):Result.fail();
    }

    //新增
    @PostMapping ("/save")
    public boolean save(@RequestBody User user){
        return iUserService.save(user);
    }
    //修改
    @PostMapping("/mod")
    public boolean mod(@RequestBody User user){
        return iUserService.updateById(user);
    }
    //新增或修改
    @PostMapping("/saveOrMod")
    public boolean saveOrMod(@RequestBody User user){
        return iUserService.saveOrUpdate(user);
    }
    //删除
    @GetMapping("/delete")
    public boolean delete(Integer id){
        return iUserService.removeById(id);
    }
    //查询(模糊、匹配)
    @PostMapping("/listP")
    public List<User> listP(@RequestBody User user){
        LambdaQueryWrapper<User> lambdaQueryWrapper=new LambdaQueryWrapper();
        if (StringUtils.isNotBlank(user.getName())){
            lambdaQueryWrapper.like(User::getName,user.getName());
        }

        return iUserService.list(lambdaQueryWrapper);
    }

}
