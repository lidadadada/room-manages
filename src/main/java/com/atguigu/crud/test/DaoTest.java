package com.atguigu.crud.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.net.ftp.FTP;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.bind.annotation.PathVariable;

import com.atguigu.crud.bean.Book;
import com.atguigu.crud.bean.BookExample;
import com.atguigu.crud.bean.Msg;
import com.atguigu.crud.bean.BookExample.Criteria;
import com.atguigu.crud.common.FTPConfig;
import com.atguigu.crud.controller.HeadController;
import com.atguigu.crud.bean.PeopleInfo;
import com.atguigu.crud.bean.RoomInfo;
import com.atguigu.crud.dao.BookMapper;
import com.atguigu.crud.dao.PeopleInfoMapper;
import com.atguigu.crud.dao.RoomInfoMapper;
import com.atguigu.crud.services.JoinApplyService;
import com.atguigu.crud.services.PeopleService;
import com.atguigu.crud.services.RoomService;
import com.atguigu.crud.utils.FTPUtil;
import com.atguigu.crud.utils.Md5Util;
import com.atguigu.crud.utils.TextUtil;
import com.atguigu.crud.utils.TimeUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class DaoTest {
	@Autowired
	BookMapper bookMapper;
	@Autowired
	PeopleInfoMapper peopleInfo;
	@Autowired
	RoomService roomService;
	@Autowired
	PeopleService peopleService;
	@Autowired
	JoinApplyService joinApplyService;
	public void testBook() {
		System.out.println("fjjjjjjjjjj");
		List<Book> lists = bookMapper.selectByExample(null);
		System.out.println("fjjjjjjjjjjdfs" + lists.size());

	}
	/*
	 * Integer serialNum, Integer prePeopleId, String preRoomNum, String preTheme,
	 * Date preDay, Date preStartTime, Date preEndTime, Integer preJion, String
	 * preMemberPath, String other
	 */

	public void testInsert() throws ParseException {

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String format = "2019-02-24 21:59:06";
		Date day = dateFormat.parse(format);
		System.out.println(day);
		System.out.println(day.toGMTString() + "stringsssssssffffffffffffffffffff");
		DateFormat time = new SimpleDateFormat("hh:mm:ss");
		String times = "12:12:12";
		Date timeda = time.parse(times);
		/*
		 * for (int i = 0; i < 1; i++) { String
		 * name=UUID.randomUUID().toString().substring(0, 5)+i;
		 * roomInfo.insertSelective(new
		 * RoomInfo(i,name+"房间",name+"位置",50,"设备","wubeizhu")); }
		 */
		List<PeopleInfo> list = peopleService.selectByPrimaryEmployeeId(1);
		System.out.println(list.get(0).toString());
		System.out.println(TimeUtil.stringToDate("2019-2-20", "yyyy-mm-dd").toGMTString() + "月");
		/*
		 * Book book =bookMapper.selectByPrimaryKey(3);
		 * System.out.println("jjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj");
		 * System.out.println(book.toString()); List<Book> selectByExampleWithPeople =
		 * bookMapper.selectByExampleWithPeople(null); for (Book book2 :
		 * selectByExampleWithPeople) {
		 * System.out.println(book2.toString()+book2.getPeopleInfo().getPeoPhone()); }
		 */
	}

	/**
	 * 测试log4J
	 */
	
	public void testLog() {

		//FTPUtil ftpUtil = new FTPUtil();
		//File file = new File(this.getClass().getResource("bookDefaultImage.png").getPath());
		//System.out.println(this.getClass().getResource("src/main/resources/defaultImage/bookDefaultImage.jpg").toString());
		try {
			FileInputStream fileInputStream = new FileInputStream(new File("src/main/resources/defaultImage/bookDefaultImage.jpg"));
			System.out.println(this.getClass().getClassLoader().getResource("bookDefaultImage.jpg").getPath());
		} catch (FileNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

		if(new File("src/main/resources/defaultImage/bookDefaultImage.jpg").exists()) {
			System.out.println("lll");
		}
		
	}
	
	/**
	 * 测试ftp下载
	 */
	@Test
	public  void testFtp() {
		/*FTPUtil ftpUtil = new FTPUtil();
		ftpUtil.retrieveFile("people/11join.txt", "D:/room/room-manages/");
		ftpUtil.close();
		joinApplyService.selectByBookId(120, 123);*/
		/*String s = "aa.txt";
		System.out.println(s.substring(0,s.lastIndexOf(".")));*/
		//TimeUtil.stringToDate("", model)
	/*	System.out.println(Md5Util.MD5("123"));
		System.out.println(Md5Util.MD5("123"));*/
	
		
	}
	
	

}
