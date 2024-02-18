package com.example.rm.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.rm.entity.Gplan;
import com.example.rm.entity.Receipt;
import com.example.rm.mapper.GplanMapper;
import com.example.rm.mapper.ReceiptMapper;
import com.example.rm.service.IReceiptService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 杨婧媛
 * @since 2024-01-30
 */
@Service
public class ReceiptServiceImpl extends ServiceImpl<ReceiptMapper, Receipt> implements IReceiptService {

    @Autowired
//    爆红使用resource
    private ReceiptMapper receiptMapper;

    @Override
    public boolean saveReceipt(Receipt receipt, int gid) {
        return receiptMapper.saveReceipt(receipt,gid);
    }

    @Override
    public IPage<Receipt> selectRecord(Page<Receipt> page, Wrapper<Receipt> queryWrapper) {
        return receiptMapper.selectRecord(page,queryWrapper);
    }
}
