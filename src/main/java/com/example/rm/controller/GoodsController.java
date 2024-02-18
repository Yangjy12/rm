package com.example.rm.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.rm.common.QueryPageParam;
import com.example.rm.common.Result;
import com.example.rm.entity.Goods;
import com.example.rm.entity.Gplan;
import com.example.rm.service.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 杨婧媛
 * @since 2024-01-25
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private IGoodsService iGoodsService;

    @GetMapping("/glist")
    @ResponseBody
    public Result getUserList(){

        return Result.success(iGoodsService.list());
    }

    @PostMapping("/warnList")
    public Result listPageC(@RequestBody QueryPageParam queryPageParam){
        int pageCurrent = queryPageParam.getPageCurrent();
        int pageSize = queryPageParam.getPageSize();
        HashMap param=queryPageParam.getParam();
        String gname=(String) param.get("gname");

        Page<Goods> page=new Page<>();
        page.setCurrent(pageCurrent);
        page.setSize(pageSize);

        LambdaQueryWrapper<Goods> lambdaQueryWrapper=new LambdaQueryWrapper<>();

        if ((StringUtils.isNotBlank(gname) && !"null".equals(gname))){
            lambdaQueryWrapper.like(Goods::getName,gname);
           // return Result.success(iGoodsService.getbyName(gname));
        }

        IPage result=iGoodsService.page(page,lambdaQueryWrapper);
        //IPage result=iGplanService.page(page);
        //System.out.println(result.getRecords());
        long total = result.getTotal();
        //System.out.println(iGplanService.page(page).getRecords());

        return Result.success(result.getRecords(),total);


    }

}
