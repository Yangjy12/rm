package com.example.rm.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.rm.entity.Batch;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.rm.entity.Gplan;
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
public interface BatchMapper extends BaseMapper<Batch> {
    @Insert("INSERT INTO batch  ( gid, receipt_batch, expiry_date, num )  " +
            "VALUES  ( #{gid}, #{batch.receiptBatch}, #{batch.expiryDate}, #{batch.num} )")
    boolean saveBatchC(@Param("batch") Batch batch,int gid);

    IPage<Batch> selectPage(@Param("page") Page<Batch> page, @Param("ew") Wrapper<Batch> queryWrapper);
}
