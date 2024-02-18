package com.example.rm.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.rm.entity.Gplan;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 杨婧媛
 * @since 2024-01-25
 */
@Mapper
public interface GplanMapper extends BaseMapper<Gplan> {

    @Update("UPDATE gplan  SET state = 3  WHERE id =#{id}")
    boolean close(int id);

    @Update("UPDATE gplan  SET input_state = 1  WHERE id =#{id}")
    boolean input(int id);

    @Insert("INSERT INTO gplan  ( gid, suppliers, plan_price, plan_num,   target_date, purchaser,  remark )  " +
            "VALUES  ( #{gid}, #{gplan.suppliers}, #{gplan.planPrice}, #{gplan.planNum}, #{gplan.targetDate},  #{gplan.purchaser}, #{gplan.remark} )")
    boolean saveGplan(@Param("gplan") Gplan gplan,int gid);

    @Update("UPDATE gplan SET suppliers = #{gplan.suppliers}, plan_num = #{gplan.planNum} ," +
            "plan_price=#{gplan.planPrice},state=1,modify_user=#{gplan.modifyUser}," +
            "target_date=#{gplan.targetDate},remark=#{gplan.remark} WHERE id = #{gplan.id}")
    boolean updateGplanById(@Param("gplan") Gplan gplan);

    @Update("UPDATE gplan SET check_remark = #{checkRemark},  check_state = #{checkState} , state = 2  WHERE id =#{id}")
    boolean modState2(@Param("checkRemark") String checkRemark,@Param("checkState") int checkState,@Param("id") int id);

    IPage<Gplan> selectPageC(@Param("page") Page<Gplan> page,@Param("ew") Wrapper<Gplan> queryWrapper);

}
