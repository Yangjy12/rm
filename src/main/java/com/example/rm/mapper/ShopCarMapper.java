package com.example.rm.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.rm.entity.Gplan;
import com.example.rm.entity.ShopCar;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 杨婧媛
 * @since 2024-02-01
 */
@Mapper
public interface ShopCarMapper extends BaseMapper<ShopCar> {
    @Insert("INSERT INTO shop_car  ( uid, gid, buynum )  " +
            "VALUES  ( #{shopCar.uid}, #{shopCar.gid}, #{shopCar.buynum})")
    boolean add(@Param("shopCar") ShopCar shopCar);

    @Select("SELECT COUNT(*) FROM shop_car WHERE gid=#{gid};")
    int selGid(int gid);

    @Update("UPDATE shop_car SET buynum = buynum + #{buynum};")
    boolean updateBuynum(int buynum);

    IPage<Gplan> selAll(@Param("page") Page<ShopCar> page, @Param("ew") Wrapper<ShopCar> queryWrapper);

}
