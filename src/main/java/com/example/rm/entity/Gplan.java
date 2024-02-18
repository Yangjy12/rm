package com.example.rm.entity;

import java.sql.Date;
import java.time.LocalDateTime;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author 杨婧媛
 * @since 2024-01-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Gplan implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 采购计划id
     */
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    /**
     * 采购商品id
     */
    private int gid;

    /**
     * 采购商品
     */
    private String gname;

    /**
     * 商品供应商
     */
    private String suppliers;

    /**
     * 计划金额
     */
    private Float planPrice;

    /**
     * 计划采购数量
     */
    private Integer planNum;

    /**
     * 采购订单状态，0创建，1修改，2审核,3关闭
     */
    private Integer state;

    //审核人
    private String checkUser;

    //预计到货日期
    private Date targetDate;

    /**
     * 采购人
     */
    private String purchaser;

    /**
     * 修改人
     */
    private String modifyUser;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 修改时间
     */
    private Date modifyDate;

    /**
     * 关闭时间
     */
    private Date closeDate;

    /**
     * 描述
     */
    private String remark;

    /**
     * 审核语：审核通过或审核不通过
     */
    private String checkRemark;

    /**
     * 审核状态0通过1不通过
     */
    private int checkState;

    /**
     * 0未入库  1已入库  默认0
     */
    private int inputState;


}
