package com.example.rm.controller;


import com.example.rm.common.QueryPageParam;
import com.example.rm.common.Result;
import com.example.rm.entity.Border;
import com.example.rm.service.IGoodsService;
import com.example.rm.service.IOrderService;
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
 * @since 2024-02-02
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private IOrderService iOrderService;
    @Autowired
    private IGoodsService iGoodsService;

    @PostMapping("/save")
    public Result save(@RequestBody QueryPageParam queryPageParam){
        HashMap param = queryPageParam.getParam();
        String gname=(String) param.get("gname");
        Double prize= (Double) param.get("prize");
        int buynum= (int) param.get("buynum");
        int uid=(int)param.get("uid");
        int gid = iGoodsService.getbyName(gname);
       // System.out.println(gname+" prize:"+prize+"buynum"+buynum);
        Border border =new Border();
        border.setAllCost(prize);
        border.setId(gid);
        border.setUid(uid);
        border.setGid(gid);
        border.setNumber(String.valueOf(System.currentTimeMillis()));
        iOrderService.save(border);
        return Result.success(border);
    }

}
