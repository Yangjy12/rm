package com.example.rm.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.rm.common.QueryPageParam;
import com.example.rm.common.Result;
import com.example.rm.entity.Batch;
import com.example.rm.entity.Gplan;
import com.example.rm.service.IBatchService;
import com.example.rm.service.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 杨婧媛
 * @since 2024-01-30
 */
@RestController
@RequestMapping("/batch")
public class BatchController {
    @Autowired
    private IBatchService iBatchService;
    @Autowired
    private IGoodsService iGoodsService;


    @PostMapping("/listBatch")
    public Result listPageC(@RequestBody QueryPageParam queryPageParam){
        int pageCurrent = queryPageParam.getPageCurrent();
        int pageSize = queryPageParam.getPageSize();
        HashMap param=queryPageParam.getParam();
        String gname=(String) param.get("gname");

        Page<Batch> page=new Page<>();
        page.setCurrent(pageCurrent);
        page.setSize(pageSize);

        LambdaQueryWrapper<Batch> lambdaQueryWrapper=new LambdaQueryWrapper<>();

        if ((StringUtils.isNotBlank(gname) && !"null".equals(gname))){
            int gid = iGoodsService.getbyName(gname);
            System.out.println(gid);
            lambdaQueryWrapper.eq(Batch::getGid,gid);
        }

        IPage result=iBatchService.selectPage(page,lambdaQueryWrapper);
        long total = result.getTotal();
        return Result.success(result.getRecords(),total);


    }

}
