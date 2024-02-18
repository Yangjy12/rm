package com.example.rm.mapper;

import com.example.rm.entity.Goods;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 杨婧媛
 * @since 2024-01-25
 */
@Mapper
public interface GoodsMapper extends BaseMapper<Goods> {

    @Select("SELECT id from goods where name=#{gname}")
    int getbyName(String gname);

    @Update("UPDATE goods SET num = num + #{num} WHERE id = #{id};")
    int updateNum(@Param("num") int num, @Param("id") int gid);
}
