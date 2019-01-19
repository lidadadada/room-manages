package com.atguigu.crud.dao;

import com.atguigu.crud.bean.PeopleInfo;
import com.atguigu.crud.bean.PeopleInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PeopleInfoMapper {
    long countByExample(PeopleInfoExample example);

    int deleteByExample(PeopleInfoExample example);

    int deleteByPrimaryKey(Integer peoSerialNum);

    int insert(PeopleInfo record);

    int insertSelective(PeopleInfo record);

    List<PeopleInfo> selectByExample(PeopleInfoExample example);

    PeopleInfo selectByPrimaryKey(Integer peoSerialNum);

    int updateByExampleSelective(@Param("record") PeopleInfo record, @Param("example") PeopleInfoExample example);

    int updateByExample(@Param("record") PeopleInfo record, @Param("example") PeopleInfoExample example);

    int updateByPrimaryKeySelective(PeopleInfo record);

    int updateByPrimaryKey(PeopleInfo record);
}