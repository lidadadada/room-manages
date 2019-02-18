package com.atguigu.crud.dao;

import com.atguigu.crud.bean.UnEmpid;
import com.atguigu.crud.bean.UnEmpidExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UnEmpidMapper {
    long countByExample(UnEmpidExample example);

    int deleteByExample(UnEmpidExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UnEmpid record);

    int insertSelective(UnEmpid record);

    List<UnEmpid> selectByExample(UnEmpidExample example);

    UnEmpid selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UnEmpid record, @Param("example") UnEmpidExample example);

    int updateByExample(@Param("record") UnEmpid record, @Param("example") UnEmpidExample example);

    int updateByPrimaryKeySelective(UnEmpid record);

    int updateByPrimaryKey(UnEmpid record);
}