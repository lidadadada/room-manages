package com.atguigu.crud.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.crud.bean.Book;
import com.atguigu.crud.bean.BookExample;
import com.atguigu.crud.bean.BookExample.Criteria;
import com.atguigu.crud.dao.BookMapper;

/**
 * 处理关于预定的业务
 */
@Service
public class BookService {
	@Autowired
	BookMapper bookMapper;
	public List<Book> getAll(){
		System.out.println("books+++++++++++++++++");
		BookExample example = new BookExample();
		Criteria criteria = example.createCriteria();
		criteria.andPrePeopleIdEqualTo(1);
		return bookMapper.selectByExampleWithPeople(example);
		
	}
	public void saveBook(Book book) {
		bookMapper.insertSelective(book);
	}
	/**
	 * 根据主键/序号查询
	 */
	public Book selectByPrimaryKey(Integer num) {
		return bookMapper.selectByPrimaryKey(num);
	}
	/**
	 * 根据序号删除单条记录
	 */
	public void deleteByPrimaryKey(Integer num) {
		bookMapper.deleteByPrimaryKey(num);
	}
	/**
	 * 批量删除
	 */
	public void deleteBatch(List<Integer> split) {
		BookExample example = new BookExample();
		Criteria criteria = example.createCriteria();
		//delete form tabel  SerialNumIn in (1,2,3)
		criteria.andSerialNumIn(split);
		bookMapper.deleteByExample(example);
		
	}
	/**
	 * 更新
	 * 
	 */
	public void update(Book book) {
		bookMapper.updateByPrimaryKeySelective(book);
	}
}
