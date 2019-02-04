package com.atguigu.crud.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.crud.bean.Book;
import com.atguigu.crud.bean.BookExample;
import com.atguigu.crud.bean.BookExample.Criteria;
import com.atguigu.crud.dao.BookMapper;

@Service
public class FMainService {
	@Autowired
	BookMapper bookMapper;
	public List<Book> selectByDate(Date date){
		BookExample example = new BookExample();
		Criteria criteria = example.createCriteria();
		criteria.andPreDayEqualTo(date);
		return bookMapper.selectByExample(example);
	}
}
