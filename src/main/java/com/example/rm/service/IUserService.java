package com.example.rm.service;

import com.example.rm.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 杨婧媛
 * @since 2024-01-19
 */
public interface IUserService extends IService<User> {

    public PageInfo<User> findByPageService(int pageCode, int pageSize);
}
