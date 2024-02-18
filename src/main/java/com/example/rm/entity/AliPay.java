package com.example.rm.entity;

import lombok.Data;

@Data
public class AliPay {
    private String tradeNo;
    private String totalAmount;
    private String subject;
    private String alipayTraceNo;
}

