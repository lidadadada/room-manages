package com.atguigu.crud.dao;

import com.atguigu.crud.bean.Ply;
import com.atguigu.crud.bean.PlyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PlyMapper {
    long countByExample(PlyExample example);

    int deleteByExample(PlyExample example);

    int deleteByPrimaryKey(Integer plyId);

    int insert(Ply record);

    int insertSelective(Ply record);

    List<Ply> selectByExample(PlyExample example);

    Ply selectByPrimaryKey(Integer plyId);

    int updateByExampleSelective(@Param("record") Ply record, @Param("example") PlyExample example);

    int updateByExample(@Param("record") Ply record, @Param("example") PlyExample example);

    int updateByPrimaryKeySelective(Ply record);

    int updateByPrimaryKey(Ply record);
}