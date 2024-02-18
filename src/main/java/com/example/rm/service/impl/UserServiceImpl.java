package com.example.rm.service.impl;

import com.example.rm.entity.User;
import com.example.rm.mapper.UserMapper;
import com.example.rm.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 杨婧媛
 * @since 2024-01-19
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
//    爆红使用resource
    private UserMapper userMapper;

    @Override
    public PageInfo<User> findByPageService(int pageCode, int pageSize) {
        return userMapper.findAllClass();
    }
}
