package com.atguigu.crud.dao;

import com.atguigu.crud.bean.Book;
import com.atguigu.crud.bean.BookExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BookMapper {
    long countByExample(BookExample example);

    int deleteByExample(BookExample example);

    int deleteByPrimaryKey(Integer serialNum);

    int insert(Book record);

    int insertSelective(Book record);

    List<Book> selectByExample(BookExample example);
    
    List<Book> selectByExampleWithPeople(BookExample example);
    
    Book selectByPrimaryKey(Integer serialNum);

    int updateByExampleSelective(@Param("record") Book record, @Param("example") BookExample example);

    int updateByExample(@Param("record") Book record, @Param("example") BookExample example);

    int updateByPrimaryKeySelective(Book record);

    int updateByPrimaryKey(Book record);
}