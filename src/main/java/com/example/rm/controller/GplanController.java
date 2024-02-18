package com.example.rm.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.rm.common.QueryPageParam;
import com.example.rm.common.Result;
import com.example.rm.entity.Goods;
import com.example.rm.entity.Gplan;
import com.example.rm.entity.User;
import com.example.rm.service.IGoodsService;
import com.example.rm.service.IGplanService;
import com.example.rm.service.IUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 杨婧媛
 * @since 2024-01-25
 */
@RestController
@RequestMapping("/gplan")
public class GplanController {

    @Autowired
    private IGplanService iGplanService;
    @Autowired
    private IGoodsService iGoodsService;

    @GetMapping("/list")
    @ResponseBody
    public Result getUserList(){

        int count = iGplanService.count();
        return Result.success(iGplanService.list(), (long) count);
    }

//    /**
//     * 分页查询方法
//     */
//    @PostMapping("/listPage")
//    public Result listPage(@RequestBody QueryPageParam queryPageParam){
//        int pageCurrent = queryPageParam.getPageCurrent();
//        int pageSize = queryPageParam.getPageSize();
//        HashMap param=queryPageParam.getParam();
//        String gname=(String) param.get("gname");
//        System.out.println(gname);
//
//        Page<Gplan> page=new Page<>();
//        page.setCurrent(pageCurrent);
//        page.setSize(pageSize);
//
//        IPage result=iGplanService.pageC(page);
////        if (gname!=null){
////            result=iGplanService.selByName(gname);
////        }
////
//        long total = result.getTotal();
//        //System.out.println(iGplanService.page(page).getRecords());
//
//        return Result.success(result.getRecords(),total);
//
//
//    }

    /**
     * 采购计划分页查询方法,自定义
     */
    @PostMapping("/listPageCC")
    public Result listPageC(@RequestBody QueryPageParam queryPageParam){
        int pageCurrent = queryPageParam.getPageCurrent();
        int pageSize = queryPageParam.getPageSize();
        HashMap param=queryPageParam.getParam();
        String gname=(String) param.get("gname");
        String state = (String) param.get("state");
        System.out.println(gname);

        System.out.println(state);

        Page<Gplan> page=new Page<>();
        page.setCurrent(pageCurrent);
        page.setSize(pageSize);

        LambdaQueryWrapper<Gplan> lambdaQueryWrapper=new LambdaQueryWrapper<>();

        if ((StringUtils.isNotBlank(gname) && !"null".equals(gname))){
            int gid = iGoodsService.getbyName(gname);
            System.out.println(gid);
            lambdaQueryWrapper.eq(Gplan::getGid,gid);
        }

        if (StringUtils.isNotBlank(state)){

            lambdaQueryWrapper.eq(Gplan::getState,state);
        }
        //lambdaQueryWrapper.eq(Gplan::getState,state);

        //System.out.println(lambdaQueryWrapper);

        IPage result=iGplanService.selectPageC(page,lambdaQueryWrapper);
        //IPage result=iGplanService.page(page);
        //System.out.println(result.getRecords());
        long total = result.getTotal();
        //System.out.println(iGplanService.page(page).getRecords());

        return Result.success(result.getRecords(),total);


    }

    //新增
    @PostMapping("/save")
    public Result save(@RequestBody Gplan gplan){
        System.out.println(gplan);
        System.out.println(gplan.getGname());
        int gid= Integer.parseInt(gplan.getGname());
        //iGplanService.saveGplan(gplan,gid);
        return iGplanService.saveGplan(gplan,gid)?Result.success():Result.fail();
        //return iGplanService.save(gplan)?Result.success():Result.fail();
    }
    //新增或修改
    @PostMapping("/saveOrMod")
    public Result saveOrMod(@RequestBody Gplan gplan){
        return iGplanService.saveOrUpdate(gplan)?Result.success():Result.fail();
    }
    //修改
    @PostMapping("/update")
    public Result update(@RequestBody Gplan gplan){

        if (iGplanService.updateGplanById(gplan)){
            return Result.success();
        }else {
            return Result.fail();
        }

    }
    //修改2check
    @PostMapping("/update2")
    public Result updateCheck(@RequestBody Gplan gplan){

        if (iGplanService.modState2(gplan.getCheckRemark(),gplan.getCheckState(),gplan.getId())){
            return Result.success();
        }else {
            return Result.fail();
        }

    }
    //删除
    @GetMapping("/del")
    public Result del( String id){
        return iGplanService.removeById(id)?Result.success():Result.fail();
    }
    //关闭
    @GetMapping("/close")
    public Result close( String id){
        int pid= Integer.parseInt(id);
        return iGplanService.close(pid)?Result.success():Result.fail();
    }

    //分页查询
    @PostMapping("/search")
    public Result search(@RequestBody QueryPageParam queryPageParam){
        int pageCurrent = queryPageParam.getPageCurrent();
        int pageSize = queryPageParam.getPageSize();
        HashMap param=queryPageParam.getParam();
        String gname=(String) param.get("gname");

        String state = (String) param.get("state");
        //System.out.println(gname);
        System.out.println(state);

        Page<Gplan> page=new Page<>();
        page.setCurrent(pageCurrent);
        page.setSize(pageSize);

        LambdaQueryWrapper<Gplan> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        if ((StringUtils.isNotBlank(gname) && !"null".equals(gname))){
            int gid = iGoodsService.getbyName(gname);
            System.out.println(gid);
            lambdaQueryWrapper.ne(Gplan::getState, 3).eq(Gplan::getGid,gid);
        }

        if (StringUtils.isNotBlank(state)){

            lambdaQueryWrapper.ne(Gplan::getState, 3).eq(Gplan::getCheckState,state);
        }

        lambdaQueryWrapper.ne(Gplan::getState, 3);
        IPage result=iGplanService.selectPageC(page,lambdaQueryWrapper);
        long total = result.getTotal();
        return Result.success(result.getRecords(),total);


    }
}

