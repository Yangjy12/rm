package com.example.rm.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.rm.entity.Gplan;
import com.example.rm.entity.Receipt;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 杨婧媛
 * @since 2024-01-30
 */
public interface IReceiptService extends IService<Receipt> {

    boolean saveReceipt(Receipt receipt, int gid);

    IPage<Receipt> selectRecord(Page<Receipt> page, Wrapper<Receipt> queryWrapper);

}
