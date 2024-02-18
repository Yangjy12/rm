package com.example.rm.mapper;

import com.example.rm.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 杨婧媛
 * @since 2024-01-19
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    @Select("select * from user")
    public PageInfo<User> findAllClass();
}
