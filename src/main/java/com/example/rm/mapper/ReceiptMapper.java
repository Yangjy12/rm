package com.example.rm.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.rm.entity.Gplan;
import com.example.rm.entity.Receipt;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 杨婧媛
 * @since 2024-01-30
 */
@Mapper
public interface ReceiptMapper extends BaseMapper<Receipt> {
    @Insert("INSERT INTO receipt  ( gid, suppliers, plan_num, input_num, input_user,receipt_batch,production_date,expiry_date,remark )  " +
            "VALUES  ( #{gid}, #{receipt.suppliers},  #{receipt.planNum}, #{receipt.inputNum},  #{receipt.inputUser}, #{receipt.receiptBatch}," +
            "  #{receipt.productionDate}, #{receipt.expiryDate}, #{receipt.remark})")
    boolean saveReceipt(@Param("receipt") Receipt receipt, int gid);

    IPage<Receipt> selectRecord(@Param("page") Page<Receipt> page, @Param("ew") Wrapper<Receipt> queryWrapper);

}
