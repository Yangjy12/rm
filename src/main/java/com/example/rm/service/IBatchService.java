package com.example.rm.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.rm.entity.Batch;
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
public interface IBatchService extends IService<Batch> {
    boolean saveBatchC(Batch batch,int gid);

    IPage<Batch> selectPage(Page<Batch> page, Wrapper<Batch> queryWrapper);

}
