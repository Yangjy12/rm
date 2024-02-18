package com.example.rm.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.rm.entity.Gplan;
import com.example.rm.entity.ShopCar;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 杨婧媛
 * @since 2024-02-01
 */
public interface IShopCarService extends IService<ShopCar> {
    boolean add(@Param("shopCar") ShopCar shopCar);
    int selGid(int gid);
    boolean updateBuynum(int buynum);
    IPage<Gplan> selAll(Page<ShopCar> page, Wrapper<ShopCar> queryWrapper);
}
