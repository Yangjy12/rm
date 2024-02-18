package com.example.rm.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
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
public class Goods implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 商品id
     */
    private Integer id;

    /**
     * 商品名
     */
    private String name;

    /**
     * 商品照片
     */
    private String img;

    /**
     * 商品类别
     */
    private String type;

    /**
     * 数量
     */
    private Integer num;

    /**
     * 价格
     */
    private Float prize;

    /**
     * 预警阀值
     */
    private Integer alertNum;


}
