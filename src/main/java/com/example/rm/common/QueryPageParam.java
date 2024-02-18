package com.example.rm.common;

import lombok.Data;

import java.util.HashMap;

@Data
public class QueryPageParam {
    //默认
    private static int PAGE_SIZE=5;
    private static int PAGE_Current=1;

    private int pageSize=PAGE_SIZE;
    private int pageCurrent=PAGE_Current;

    private HashMap param=new HashMap<>();

}
