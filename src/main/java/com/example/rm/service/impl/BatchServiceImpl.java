package com.example.rm.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.rm.entity.Batch;
import com.example.rm.mapper.BatchMapper;
import com.example.rm.service.IBatchService;
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
public class BatchServiceImpl extends ServiceImpl<BatchMapper, Batch> implements IBatchService {
    @Autowired
    private BatchMapper batchMapper;

    @Override
    public boolean saveBatchC(Batch batch, int gid) {
        return batchMapper.saveBatchC(batch,gid);
    }

    @Override
    public IPage<Batch> selectPage(Page<Batch> page, Wrapper<Batch> queryWrapper) {
        return batchMapper.selectPage(page,queryWrapper);
    }
}
