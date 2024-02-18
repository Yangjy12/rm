package com.example.rm.entity;

import java.sql.Date;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author 杨婧媛
 * @since 2024-01-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Receipt implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    /**
     * 商品id
     */
    private Integer gid;

    private String gname;

    /**
     * 入库批次
     */
    private String receiptBatch;

    /**
     * 供应商
     */
    private String suppliers;

    /**
     * 计划数量
     */
    private Integer planNum;

    /**
     * 入库数量
     */
    private Integer inputNum;


    /**
     * 入库人
     */
    private String inputUser;

    /**
     * 生产日期
     */
    private Date productionDate;

    /**
     * 过期时间
     */
    private Date expiryDate;

    /**
     * 入库单创建时间
     */
    private Date createDate;

    /**
     * 备注
     */
    private String remark;



}
