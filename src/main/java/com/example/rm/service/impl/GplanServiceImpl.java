package com.example.rm.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.rm.entity.Gplan;
import com.example.rm.mapper.GplanMapper;
import com.example.rm.service.IGplanService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 杨婧媛
 * @since 2024-01-25
 */
@Service
public class GplanServiceImpl extends ServiceImpl<GplanMapper, Gplan> implements IGplanService {

    @Autowired
//    爆红使用resource
    private GplanMapper gplanMapper;



    @Override
    public boolean close(int id) {
        return gplanMapper.close(id);
    }

    @Override
    public boolean input(int id) {
        return gplanMapper.input(id);
    }

    @Override
    public boolean updateGplanById(Gplan gplan) {
        return gplanMapper.updateGplanById(gplan);
    }

    @Override
    public boolean saveGplan(Gplan gplan,int gid) {
        return gplanMapper.saveGplan(gplan,gid);
    }


    @Override
    public boolean modState2(String checkRemark, int checkState, int pid) {
        return gplanMapper.modState2(checkRemark,checkState,pid);
    }

    @Override
    public IPage<Gplan> selectPageC(Page<Gplan> page, Wrapper<Gplan> queryWrapper) {
        return gplanMapper.selectPageC(page,queryWrapper);
    }


}
