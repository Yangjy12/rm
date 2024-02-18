package com.example.rm.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.rm.common.QueryPageParam;
import com.example.rm.common.Result;
import com.example.rm.entity.Goods;
import com.example.rm.entity.Gplan;
import com.example.rm.entity.ShopCar;
import com.example.rm.service.IGoodsService;
import com.example.rm.service.IShopCarService;
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
 * @since 2024-02-01
 */
@RestController
@RequestMapping("/shop-car")
public class ShopCarController {
    @Autowired
    private IShopCarService iShopCarService;
    @Autowired
    private IGoodsService iGoodsService;

    @GetMapping("/save")
    public Result save(String buynum,String id,String userId){
        int num= Integer.parseInt(buynum);
        int gid= Integer.parseInt(id);
        int uId=Integer.parseInt(userId);
        //System.out.println(num+"gid:"+gid);
        Goods goods = iGoodsService.getById(gid);
        ShopCar shopCar=new ShopCar();
        shopCar.setGid(gid);
        shopCar.setBuynum(num);
        shopCar.setUid(uId);
        int i = iShopCarService.selGid(gid);
        if (i==0){
            return iShopCarService.add(shopCar)?Result.success():Result.fail();
        }else {
            return iShopCarService.updateBuynum(num)?Result.success():Result.fail();
        }
    }
    //分页查询
    @PostMapping("/listPage")
    public Result search(@RequestBody QueryPageParam queryPageParam){
        int pageCurrent = queryPageParam.getPageCurrent();
        int pageSize = queryPageParam.getPageSize();
        HashMap param=queryPageParam.getParam();
        String gname=(String) param.get("gname");
        Page<ShopCar> page=new Page<>();
        page.setCurrent(pageCurrent);
        page.setSize(pageSize);
        LambdaQueryWrapper<ShopCar> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        if ((StringUtils.isNotBlank(gname) && !"null".equals(gname))){
            int gid = iGoodsService.getbyName(gname);
            //System.out.println(gid);
            lambdaQueryWrapper.eq(ShopCar::getGid,gid);
        }
        IPage result=iShopCarService.selAll(page,lambdaQueryWrapper);
        long total = result.getTotal();
        return Result.success(result.getRecords(),total);
    }

    //删除
    @GetMapping("/del")
    public Result del( String id){
        return iShopCarService.removeById(id)?Result.success():Result.fail();
    }
}
