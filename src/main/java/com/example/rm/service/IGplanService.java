package com.example.rm.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.rm.entity.Gplan;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 杨婧媛
 * @since 2024-01-25
 */
public interface IGplanService extends IService<Gplan> {
    

    boolean close(int id);
    boolean input(int id);
    boolean updateGplanById(Gplan gplan);
    boolean saveGplan(Gplan gplan,int gid);

    boolean modState2(String checkRemark, int checkState,int pid);

    IPage<Gplan> selectPageC(Page<Gplan> page,Wrapper<Gplan> queryWrapper);
}
