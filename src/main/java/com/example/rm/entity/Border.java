package com.example.rm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.sql.Date;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author 杨婧媛
 * @since 2024-02-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Border implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 总费用
     */
    private Double allCost;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 支付时间
     */
    private Date payTime;

    /**
     * 用户id
     */
    private Integer uid;

    /**
     * 商品id
     */
    private Integer gid;

    /**
     * 订单状态0未支付1已支付
     */
    private Integer state;

    /**
     * 订单编号使用DateUtil.format(new Date(),"yyyyMMdd")+System.currentTimeNillis()
     */
    private String number;


}
