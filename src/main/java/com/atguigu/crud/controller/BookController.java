package com.atguigu.crud.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.accessibility.AccessibleRelation;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
/*
 * 面向关于预定的请求
 */
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.atguigu.crud.bean.Book;
import com.atguigu.crud.bean.BookInput;
import com.atguigu.crud.bean.BookPo;
import com.atguigu.crud.bean.ManagePeople;
import com.atguigu.crud.bean.Msg;
import com.atguigu.crud.bean.PeopleInfo;
import com.atguigu.crud.common.ManageConfig;
import com.atguigu.crud.services.BookService;
import com.atguigu.crud.services.PeopleService;
import com.atguigu.crud.utils.TimeUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
public class BookController extends BaseController{
	@Autowired
	BookService bookService;
	@Autowired
	PeopleService peopleService;
	private ManagePeople managePeople;
	private HttpSession session;

	/*
	 * 更新
	 */
	@RequestMapping(value = "/book/manage/update/", method = RequestMethod.POST)
	@ResponseBody
	public Msg update(BookInput book) {
		Book books = new Book();
		books.setSerialNum(book.getSerialNum());
		books.setPrePeopleId(book.getPrePeopleId());
		books.setPreRoomNum(book.getPreRoomNum());
		books.setPreTheme(book.getPreTheme());
		books.setPreDay(TimeUtil.stringToDate(book.getPreDay(), "yyyy-mm-dd"));
		books.setPreStartTime(TimeUtil.stringToDate(book.getPreStartTime(), "hh:mm:ss"));
		books.setPreEndTime(TimeUtil.stringToDate(book.getPreEndTime(), "hh:mm:ss"));
		books.setOther(book.getOther());
		books.setPreMemberPath("/" + book.getPreTheme() + "/member");
		bookService.update(books);
		return Msg.success();
	}

	/*
	 * 表单里根据序号删除预定记录 ,,,,单个+多个 1-2-3 1
	 */
	@RequestMapping(value = "/deleteInTable/{deleteNum}")
	@ResponseBody
	public Msg deleteByPrimaryKey(@PathVariable("deleteNum") String deleteNum) {
		System.out.println("++++++++" + deleteNum);
		if (deleteNum.contains("-")) {
			List<Integer> lists = new ArrayList<Integer>();
			String[] split = deleteNum.split("-");
			// 组装
			for (String sp : split) {
				lists.add(Integer.parseInt(sp));
			}
			bookService.deleteBatch(lists);
			return Msg.success();
		} else {
			bookService.deleteByPrimaryKey(Integer.parseInt(deleteNum));
			return Msg.success();
		}

	}

	/*
	 * 编辑模态框数据回显
	 */
	@RequestMapping(value = "/book_reback_edit_model", method = RequestMethod.GET)
	@ResponseBody
	public Msg getReback(@RequestParam(value = "num", defaultValue = "-1") Integer num) {
		// 引入pagehelper 分页插件 每页条数
		System.out.println(num);
		if (num != -1) {
			Book book = bookService.selectByPrimaryKey(num);
			return Msg.success().add("book", book);
		}
		return Msg.fail();
	}

	/*
	 * 获取所有的book预定数据
	 */
	@RequestMapping(value = "/books", method = RequestMethod.GET)
	@ResponseBody
	public Msg getAll(@RequestParam(value = "pn", defaultValue = "1") Integer pn, HttpServletRequest request) {
		session = request.getSession();
		managePeople = (ManagePeople) session.getAttribute("currentAdmin");
		if (managePeople != null) {
			PageHelper.startPage(pn, 10); // 后面跟着的查询，就自动分页查询了
			List<Book> lists = bookService.getAll();
			System.out.println("getAll:"+lists.size());
			/*for (BookPo book : lists) {
				System.out.println(book.toString());
				System.out.println(book.getPeopleInfo().toString());
			}*/
			// 使用pageinfo包装查询后的结果，获得各种分页 的信息 5:连续显示5页
			PageInfo pageInfo = new PageInfo(lists, 5);
			System.out.println("获取预定数据成功");
			return Msg.success().add("pageInfo", pageInfo);
		} else {
			return Msg.fail().add("path", "/manage_index.jsp");
		}
	}

	// get 查询 post 提交保存 put 修改 delete删除
	// 保存添加的模态框的数据 定义为post请求
	// JSR303校验 导入Hibernate-Vaildator包
	@RequestMapping(value = "/book_save_model")
	@ResponseBody
	public Msg saveBookFromModel(@Valid BookInput book, BindingResult result) {
		System.out.println("+++++++++++++++++++book.toString()" + book.toString());
		System.out.println("保存预定数据");
		// @Valid申明在封装的时候需要校验 BindingResult封装娇艳的结果
		if (result.hasErrors()) {
			// 校验失败
			List<FieldError> errors = result.getFieldErrors();
			Map<String, Object> map = new HashMap<String, Object>();
			for (FieldError error : errors) {
				map.put(error.getField(), error.getDefaultMessage());
			}
			return Msg.fail().add("errorFieled", map);
		} else {
			// bookinput转换为book，并保存
			Book books = new Book();
			books.setSerialNum(book.getSerialNum());
			books.setPrePeopleId(book.getPrePeopleId());
			books.setPreRoomNum(book.getPreRoomNum());
			books.setPreTheme(book.getPreTheme());
			//System.out.println(book.getPreDay()+"日期");
			//System.out.println(TimeUtil.stringToDate(book.getPreDay()+" 00:00:00", "yyyy-MM-dd HH:mm:ss")+"日期");
			books.setPreDay(TimeUtil.stringToDate(book.getPreDay()+" 00:00:00", "yyyy-MM-dd HH:mm:ss"));
			books.setPreStartTime(TimeUtil.stringToDate(book.getPreStartTime(), "HH:mm:ss"));
			books.setPreEndTime(TimeUtil.stringToDate(book.getPreEndTime(), "HH:mm:ss"));
			books.setOther(book.getOther());
			books.setPreMemberPath("/" + book.getPreTheme() + "/member");
			bookService.saveBook(books);
			return Msg.success();
		}
	}
}
