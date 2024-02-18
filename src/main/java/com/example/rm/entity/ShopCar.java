package com.example.rm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author 杨婧媛
 * @since 2024-02-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ShopCar implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer uid;

    private Integer gid;

    private Integer buynum;

    private String gname;
    private String img;
    private Long prize;


}
