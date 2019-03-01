package com.atguigu.crud.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.atguigu.crud.bean.Book;
import com.atguigu.crud.bean.Msg;
import com.atguigu.crud.bean.PeopleInfo;
import com.atguigu.crud.bean.RoomInfo;
import com.atguigu.crud.common.FTPConfig;
import com.atguigu.crud.common.UserConfig;
import com.atguigu.crud.po.BookPo;
import com.atguigu.crud.services.BookService;
import com.atguigu.crud.services.FMainService;
import com.atguigu.crud.services.RoomService;
import com.atguigu.crud.utils.FTPUtil;
import com.atguigu.crud.utils.MemberUtil;
import com.atguigu.crud.utils.TimeUtil;

@Controller
public class FMainController extends BaseController {
	// private static final String F_MAIN_CONTROLLER = "FMainController";
	@Autowired
	FMainService fMainService;
	@Autowired
	BookService bookService;
	@Autowired
	RoomService roomService;
	private HttpSession session;

	/**
	 * 申请房间信息数据处理
	 * 
	 * @param data
	 * @return
	 */
	@RequestMapping(value = "/f/main/getRoom/", method = RequestMethod.GET)
	@ResponseBody
	public Msg getRoomTable(HttpServletRequest request) {
		// 第一次获取session值
		session = request.getSession();
		PeopleInfo peopleInfo = (PeopleInfo) session.getAttribute("currentUser");
		if (peopleInfo != null) {
			getLog(this.getClass()).info(peopleInfo.getPeoAddress());
			List<RoomInfo> list = roomService.getRoomBook();
			return Msg.success().add("room", list);
		} else {
			return Msg.fail().add("path", "/f_login.jsp");
		}

	}

	/**
	 * 申请预定数据处理
	 * 
	 * @param data
	 * @return
	 */
	@RequestMapping(value = "/f/main/getBook/{date}", method = RequestMethod.GET)
	@ResponseBody
	public Msg getBookTable(@PathVariable("date") String data) {
		if (data != null && data != "") {
			Date date = TimeUtil.stringToDate(data, "yyyy-MM-dd HH:mm:ss");
			List<Book> list = fMainService.selectByDate(date);
			System.out.println(list.size() + "++++++");
			if (list.size() > 0) {

				return Msg.success().add("list", list);
			} else {
				return Msg.fail().add("msg", "未查找到当前日期的预定数据");
			}
		}
		return Msg.fail().add("msg", "输入数据为空");

	}

	/**
	 * 处理用户上传的预定
	 * 
	 * @param data
	 * @return
	 */
	@RequestMapping(value = "/f/main/upBook/", method = RequestMethod.POST)
	@ResponseBody
	public Msg delBook(@Valid BookPo book,HttpServletRequest request) {
		getLog(this.getClass()).info("##################保存订单::接收数据：："+book.getPreDay());
		
		getLog(this.getClass()).info("保存订单::接收数据：："+book.toString());
		PeopleInfo peopleInfo = (PeopleInfo) request.getSession().getAttribute("currentUser");
		if (peopleInfo != null) {
			// @Valid申明在封装的时候需要校验 BindingResult封装娇艳的结果
				FTPUtil ftpUtil = new FTPUtil();
				String tablePath = MemberUtil.createNameTable(book.getPrePeopleId()+UUID.randomUUID().toString().substring(0, 5), book.getPreDay());
				String basePath = tablePath.split("/")[0]+"/"+tablePath.split("/")[1]+"/files";
				ftpUtil.mkDir(basePath);
				String filename = UUID.randomUUID().toString().substring(0, 5);
				System.out.println(book.getBookImage().isEmpty());
				if(!book.getBookImage().isEmpty()) {
					try {
						filename = filename+"."+book.getImagePrefix();
						System.out.println(filename+"-----------------------");
						ftpUtil.upload(book.getBookImage().getInputStream(),FTPConfig.bookImagePath+ filename);
					} catch (IOException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}
					
				}else {
					try {
						filename = filename+".png";
						System.out.println(filename+"---------++++++++++++++++++");
						String defaultImagePath = this.getClass().getClassLoader().getResource("defaultImage/bookDefaultImage.png").getPath();
						FileInputStream fileInputStream = new FileInputStream(new File(defaultImagePath));
						ftpUtil.upload(fileInputStream, FTPConfig.bookImagePath+"/"+filename);
					} catch (FileNotFoundException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}
				ftpUtil.close();
				// bookinput转换为book，并保存
				getLog(this.getClass()).info("开始保存预定数据");
				Book books = new Book();
				books.setSerialNum(book.getSerialNum());
				books.setPrePeopleId(book.getPrePeopleId());
				books.setPreRoomNum(book.getPreRoomNum());
				books.setPreTheme(book.getPreTheme());
				books.setPreJion(1);
				books.setPreDay(TimeUtil.stringToDate(book.getPreDay(), "yyyy-MM-dd HH:mm:ss"));
				books.setPreStartTime(TimeUtil.stringToDate(book.getPreStartTime(), "HH:mm:ss"));
				books.setPreEndTime(TimeUtil.stringToDate(book.getPreEndTime(), "HH:mm:ss"));
				books.setOther(book.getOther());
				getLog(this.getClass()).info("进入createNameTable");
				MemberUtil.jionMemeber(tablePath, book.getPrePeopleId());
				books.setPreMemberPath(tablePath);
				books.setPrePicturePath(UserConfig.bookImageLocalMappingBasePath+filename);
				getLog(this.getClass()).info("保存订单::"+books.toString());
				bookService.saveBook(books);
				return Msg.success();
			}
		} else {
			getLog(this.getClass()).info(peopleInfo.getPeoAddress() + "session中没有peopleInfo用户信息数据");
		}
		return Msg.fail().add("path", "/f_login.jsp");
	}
}
