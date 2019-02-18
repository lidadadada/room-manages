package com.atguigu.crud.dao;

import com.atguigu.crud.bean.BookFile;
import com.atguigu.crud.bean.BookFileExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BookFileMapper {
    long countByExample(BookFileExample example);

    int deleteByExample(BookFileExample example);

    int deleteByPrimaryKey(Integer fileId);

    int insert(BookFile record);

    int insertSelective(BookFile record);

    List<BookFile> selectByExample(BookFileExample example);

    BookFile selectByPrimaryKey(Integer fileId);

    int updateByExampleSelective(@Param("record") BookFile record, @Param("example") BookFileExample example);

    int updateByExample(@Param("record") BookFile record, @Param("example") BookFileExample example);

    int updateByPrimaryKeySelective(BookFile record);

    int updateByPrimaryKey(BookFile record);
}