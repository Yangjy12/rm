package com.example.rm.service.impl;

import com.example.rm.entity.Goods;
import com.example.rm.mapper.GoodsMapper;
import com.example.rm.mapper.GplanMapper;
import com.example.rm.service.IGoodsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 杨婧媛
 * @since 2024-01-25
 */
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements IGoodsService {

    @Autowired
//    爆红使用resource
    private GoodsMapper goodsMapper;

    @Override
    public int getbyName(String gname) {
        return goodsMapper.getbyName(gname) ;
    }

    @Override
    public int updateNum(int num, int gid) {
        return goodsMapper.updateNum(num,gid);
    }
}
