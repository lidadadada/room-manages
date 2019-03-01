package com.atguigu.crud.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.crud.bean.Book;
import com.atguigu.crud.bean.BookExample;
import com.atguigu.crud.bean.BookExample.Criteria;
import com.atguigu.crud.bean.PeopleInfo;
import com.atguigu.crud.dao.BookMapper;
import com.atguigu.crud.utils.TextUtil;
import com.atguigu.crud.utils.TimeUtil;

/**
 * 处理关于预定的业务
 */
@Service
public class BookService extends BaseService {
	@Autowired
	BookMapper bookMapper;
	@Autowired
	PeopleService peopleService;

	public List<Book> getAll() {
		BookExample bookExample = new BookExample();
		bookExample.setOrderByClause("pre_day desc");
		List<Book> list = bookMapper.selectByExample(bookExample);
		System.out.println("BookService:" + list.size());
		/*
		 * List<BookPo> bookPos = new ArrayList<BookPo>(); BookPo bookPo=null; for (Book
		 * book : list) { bookPo = new BookPo(); BeanUtils.copyProperties(book, bookPo);
		 * bookPos.add(bookPo); }
		 */
		return list;

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
		// delete form tabel SerialNumIn in (1,2,3)
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

	/**
	 * 参与会议人数+1
	 */
	public void addPeoNum(Integer booknum) {
		Book book = bookMapper.selectByPrimaryKey(booknum);
		Integer jion = book.getPreJion();
		if (jion == null || jion == 0) {
			book.setPreJion(1);
		} else {
			book.setPreJion(jion + 1);
		}
		update(book);
		getLog(this.getClass()).info("book表prejion人数+1");
	}

	/**
	 * 参与会议人数-1
	 */
	public void subPeoNum(Integer booknum) {
		Book book = bookMapper.selectByPrimaryKey(booknum);
		Integer jion = book.getPreJion();
		if (jion > 0) {
			book.setPreJion(jion - 1);
			update(book);
		} else {
			getLog(this.getClass()).info("book表prejion人数为负");
		}
		getLog(this.getClass()).info("book表prejion人数+1");
	}

	/**
	 * 处理页面多条件搜索
	 * 
	 * @param data
	 * @return
	 */
	public List<Book> search(String data) {
		String[] split = data.split("_");
		for (String string : split) {
			getLog(this.getClass()).info(string);
		}
		BookExample bookExample = new BookExample();
		bookExample.setOrderByClause("pre_day desc");
		Criteria createCriteria = bookExample.createCriteria();
		if (!TextUtil.isEmpty(split[0])) {
			createCriteria.andPreThemeLike("%" + split[0] + "%");
		}
		if (!TextUtil.isEmpty(split[1])) {
			Date date = TimeUtil.stringToDate(split[1] + " 00:00:00", "yyyy-MM-dd HH:mm:ss");
			createCriteria.andPreDayEqualTo(date);
		}
		if (!TextUtil.isEmpty(split[2])) {
			List<PeopleInfo> list = peopleService.selectByPrimaryEmployeeName(split[2]);
			ArrayList<Integer> arrayList = new ArrayList<Integer>();
			for (PeopleInfo peopleInfo : list) {
				arrayList.add(peopleInfo.getPeoEmployeeId());
			}
			createCriteria.andPrePeopleIdIn(arrayList);
		}
		if (!TextUtil.isEmpty(split[3])) {
			createCriteria.andPreRoomNumLike("%" + split[2] + "%");
		}
		return bookMapper.selectByExample(bookExample);
	}

	/**
	 * 根据员工号查找会议信息
	 * @param peoEmployeeId
	 * @return 
	 */
	public List<Book> selectByEmployeeId(Integer peoEmployeeId) {
		BookExample bookExample = new BookExample();
		bookExample.setOrderByClause("pre_day");
		Criteria createCriteria = bookExample.createCriteria();
		createCriteria.andPrePeopleIdEqualTo(peoEmployeeId);
		return bookMapper.selectByExample(bookExample);
	}
	/**
	 * 根据预定序列号集合查找
	 * @param list1
	 * @return
	 */
	public List<Book> searchMyJoin(List<Integer> list1) {
		BookExample bookExample = new BookExample();
		bookExample.setOrderByClause("pre_day");
		Criteria createCriteria = bookExample.createCriteria();
		createCriteria.andSerialNumIn(list1);
		return bookMapper.selectByExample(bookExample);
	}

	/**
	 * 根据日期和会议室名字查询
	 * @param date
	 * @param string
	 * @return 
	 */
	public List<Book> selectByDateAndRoomNum(Date date, String roomname) {
		BookExample bookExample = new BookExample();
		bookExample.setOrderByClause("pre_start_time");
		Criteria createCriteria = bookExample.createCriteria();
		//System.out.println(roomname+"   "+date.toString());
		
		createCriteria.andPreRoomNumEqualTo(roomname);
		createCriteria.andPreDayEqualTo(date);
		return bookMapper.selectByExample(bookExample);
	}
}
