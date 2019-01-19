package com.atguigu.crud.dao;

import com.atguigu.crud.bean.ManagePeople;
import com.atguigu.crud.bean.ManagePeopleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ManagePeopleMapper {
    long countByExample(ManagePeopleExample example);

    int deleteByExample(ManagePeopleExample example);

    int deleteByPrimaryKey(String manageName);

    int insert(ManagePeople record);

    int insertSelective(ManagePeople record);

    List<ManagePeople> selectByExample(ManagePeopleExample example);

    ManagePeople selectByPrimaryKey(String manageName);

    int updateByExampleSelective(@Param("record") ManagePeople record, @Param("example") ManagePeopleExample example);

    int updateByExample(@Param("record") ManagePeople record, @Param("example") ManagePeopleExample example);

    int updateByPrimaryKeySelective(ManagePeople record);

    int updateByPrimaryKey(ManagePeople record);
}