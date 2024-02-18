package com.example.rm.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.rm.entity.Gplan;
import com.example.rm.entity.ShopCar;
import com.example.rm.mapper.ShopCarMapper;
import com.example.rm.service.IShopCarService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 杨婧媛
 * @since 2024-02-01
 */
@Service
public class ShopCarServiceImpl extends ServiceImpl<ShopCarMapper, ShopCar> implements IShopCarService {
    @Autowired
    private ShopCarMapper shopCarMapper;

    @Override
    public boolean add(ShopCar shopCar) {
        return shopCarMapper.add(shopCar);
    }

    @Override
    public int selGid(int gid) {
        return shopCarMapper.selGid(gid);
    }

    @Override
    public boolean updateBuynum(int buynum) {
        return shopCarMapper.updateBuynum(buynum);
    }

    @Override
    public IPage<Gplan> selAll(Page<ShopCar> page, Wrapper<ShopCar> queryWrapper) {
        return shopCarMapper.selAll(page,queryWrapper);
    }

}
