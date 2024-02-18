package com.example.rm.entity;

import java.sql.Date;
import java.time.LocalDateTime;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
public class Batch implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer gid;

    private String gname;

    private int num;

    private String receiptBatch;

    private Date expiryDate;


}
