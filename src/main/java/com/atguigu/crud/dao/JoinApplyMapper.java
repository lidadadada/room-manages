package com.atguigu.crud.dao;

import com.atguigu.crud.bean.JoinApply;
import com.atguigu.crud.bean.JoinApplyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JoinApplyMapper {
    long countByExample(JoinApplyExample example);

    int deleteByExample(JoinApplyExample example);

    int deleteByPrimaryKey(Integer joinId);

    int insert(JoinApply record);

    int insertSelective(JoinApply record);

    List<JoinApply> selectByExample(JoinApplyExample example);

    JoinApply selectByPrimaryKey(Integer joinId);

    int updateByExampleSelective(@Param("record") JoinApply record, @Param("example") JoinApplyExample example);

    int updateByExample(@Param("record") JoinApply record, @Param("example") JoinApplyExample example);

    int updateByPrimaryKeySelective(JoinApply record);

    int updateByPrimaryKey(JoinApply record);
}