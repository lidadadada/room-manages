package com.atguigu.crud.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.atguigu.crud.bean.Book;
import com.atguigu.crud.bean.PeopleInfo;
import com.atguigu.crud.bean.RoomInfo;
import com.atguigu.crud.dao.BookMapper;
import com.atguigu.crud.dao.PeopleInfoMapper;
import com.atguigu.crud.dao.RoomInfoMapper;
import com.atguigu.crud.services.PeopleService;
import com.atguigu.crud.utils.TimeUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class DaoTest {
	@Autowired
	BookMapper bookMapper;
	@Autowired
	PeopleInfoMapper peopleInfo;
	@Autowired
	RoomInfoMapper roomInfo;
	@Autowired
	PeopleService peopleService;
	public void testBook() {
		System.out.println("fjjjjjjjjjj");
		List<Book> lists = bookMapper.selectByExample(null);
		System.out.println("fjjjjjjjjjjdfs"+lists.size());
		
		
	}
	/*Integer serialNum, Integer prePeopleId, 
	 * String preRoomNum, String preTheme, Date preDay,
	Date preStartTime, Date preEndTime, Integer preJion,
	 String preMemberPath, String other*/
	@Test
	public void testInsert() throws ParseException {
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String format = "2019-02-24 21:59:06";
		Date day = dateFormat.parse(format);
		System.out.println(day);
		System.out.println(day.toGMTString()+"stringsssssssffffffffffffffffffff");
		DateFormat time = new SimpleDateFormat("hh:mm:ss");
		String times="12:12:12";
		Date timeda=time.parse(times);
		/*
		for (int i = 0; i < 1; i++) {
			String name=UUID.randomUUID().toString().substring(0, 5)+i;
			roomInfo.insertSelective(new RoomInfo(i,name+"房间",name+"位置",50,"设备","wubeizhu"));
		}*/
		List<PeopleInfo> list = peopleService.selectByPrimaryEmployeeId(1);
		System.out.println(list.get(0).toString());
		System.out.println(TimeUtil.stringToDate("2019-2-20", "yyyy-mm-dd").toGMTString()+"月");
		/*Book book =bookMapper.selectByPrimaryKey(3);
		System.out.println("jjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj");
		System.out.println(book.toString());
		List<Book> selectByExampleWithPeople = bookMapper.selectByExampleWithPeople(null);
		for (Book book2 : selectByExampleWithPeople) {
			System.out.println(book2.toString()+book2.getPeopleInfo().getPeoPhone());
		}*/
	}
	
}
