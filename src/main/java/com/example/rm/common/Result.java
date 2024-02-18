package com.example.rm.common;

import lombok.Data;

@Data
public class Result {
    private int code;//编码
    private String msg;//成功或失败
    private Long total;//总记录数
    private Object data;//数据

    private static Result result(int code,String msg,Long total,Object data){
        Result res=new Result();
        res.setCode(code);
        res.setMsg(msg);
        res.setTotal(total);
        res.setData(data);
        return res;
    }
    //失败
    public static Result fail(){
        return result(400,"失败",0L,null);
    }
    //成功
    public static Result success(){
        return result(200,"成功",0L,null);
    }
    //成功
    public static Result success(Object data){
        return result(200,"成功",0L,data);
    }
    //成功
    public static Result success(Object data,Long total){
        return result(200,"成功",total,data);
    }
}
