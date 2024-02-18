package com.example.rm.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.rm.common.QueryPageParam;
import com.example.rm.common.Result;
import com.example.rm.entity.Batch;
import com.example.rm.entity.Gplan;
import com.example.rm.entity.Receipt;
import com.example.rm.service.IBatchService;
import com.example.rm.service.IGoodsService;
import com.example.rm.service.IGplanService;
import com.example.rm.service.IReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
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
@RequestMapping("/receipt")
public class ReceiptController {

    @Autowired
    private IReceiptService iReceiptService;
    @Autowired
    private IGoodsService iGoodsService;
    @Autowired
    private IGplanService iGplanService;
    @Autowired
    private IBatchService iBatchService;

    @GetMapping("/glist")
    @ResponseBody
    public Result getUserList(){

        return Result.success(iReceiptService.list());
    }

    @PostMapping("/listPage")
    public Result search(@RequestBody QueryPageParam queryPageParam){
        int pageCurrent = queryPageParam.getPageCurrent();
        int pageSize = queryPageParam.getPageSize();
        HashMap param=queryPageParam.getParam();
        String gname=(String) param.get("gname");

        Page<Gplan> page=new Page<>();
        page.setCurrent(pageCurrent);
        page.setSize(pageSize);

        LambdaQueryWrapper<Gplan> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        if ((StringUtils.isNotBlank(gname) && !"null".equals(gname))){
            int gid = iGoodsService.getbyName(gname);
            System.out.println(gid);
            lambdaQueryWrapper.eq(Gplan::getCheckState, 1).eq(Gplan::getGid,gid).ne(Gplan::getInputState,1);
        }

        lambdaQueryWrapper.eq(Gplan::getCheckState, 1).ne(Gplan::getInputState,1);
        IPage result=iGplanService.selectPageC(page,lambdaQueryWrapper);
        long total = result.getTotal();
        return Result.success(result.getRecords(),total);
    }

    //新增
    @PostMapping("/save")
    public Result save(@RequestBody Receipt receipt){
//        System.out.println(receipt);
//        System.out.println(receipt.getGname());
        int gid = iGoodsService.getbyName(receipt.getGname());
        int num=receipt.getInputNum();
        String receiptBatch = receipt.getReceiptBatch();
        Date expiryDate = receipt.getExpiryDate();
        Batch batch=new Batch();
        batch.setGid(gid);
        batch.setReceiptBatch(receiptBatch);
        batch.setExpiryDate(expiryDate);
        batch.setGname(receipt.getGname());
        batch.setNum(receipt.getInputNum());
        // System.out.println(gid);
        if (iReceiptService.saveReceipt(receipt,gid)){
            iGplanService.input(receipt.getId());
            iGoodsService.updateNum(num,gid);
            iBatchService.saveBatchC(batch,gid);
            return Result.success();
        }else {
            return Result.fail();
        }

    }

    //入库记录
    @PostMapping("/record")
    public Result record(@RequestBody QueryPageParam queryPageParam){
        int pageCurrent = queryPageParam.getPageCurrent();
        int pageSize = queryPageParam.getPageSize();
        HashMap param=queryPageParam.getParam();
        String gname=(String) param.get("gname");

        Page<Receipt> page=new Page<>();
        page.setCurrent(pageCurrent);
        page.setSize(pageSize);

        LambdaQueryWrapper<Receipt> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        if ((StringUtils.isNotBlank(gname) && !"null".equals(gname))){
            int gid = iGoodsService.getbyName(gname);
            System.out.println(gid);
            lambdaQueryWrapper.eq(Receipt::getGid,gid);
        }

        IPage result=iReceiptService.selectRecord(page,lambdaQueryWrapper);
        long total = result.getTotal();
        return Result.success(result.getRecords(),total);
    }
}
