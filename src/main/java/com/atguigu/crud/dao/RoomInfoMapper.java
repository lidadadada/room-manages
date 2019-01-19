package com.atguigu.crud.dao;

import com.atguigu.crud.bean.RoomInfo;
import com.atguigu.crud.bean.RoomInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoomInfoMapper {
    long countByExample(RoomInfoExample example);

    int deleteByExample(RoomInfoExample example);

    int deleteByPrimaryKey(Integer roomNum);

    int insert(RoomInfo record);

    int insertSelective(RoomInfo record);

    List<RoomInfo> selectByExample(RoomInfoExample example);

    RoomInfo selectByPrimaryKey(Integer roomNum);

    int updateByExampleSelective(@Param("record") RoomInfo record, @Param("example") RoomInfoExample example);

    int updateByExample(@Param("record") RoomInfo record, @Param("example") RoomInfoExample example);

    int updateByPrimaryKeySelective(RoomInfo record);

    int updateByPrimaryKey(RoomInfo record);
}