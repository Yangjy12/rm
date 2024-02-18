package com.example.rm.service;

import com.example.rm.entity.Goods;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 杨婧媛
 * @since 2024-01-25
 */
public interface IGoodsService extends IService<Goods> {

    int getbyName(String gname);
    int updateNum(int num,int gid);
}
