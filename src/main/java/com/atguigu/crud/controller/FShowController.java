package com.atguigu.crud.controller;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.eclipse.jdt.internal.compiler.lookup.InferenceContext;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.atguigu.crud.bean.Book;
import com.atguigu.crud.bean.BookFile;
import com.atguigu.crud.bean.BookPo;
import com.atguigu.crud.bean.JoinApply;
import com.atguigu.crud.bean.Msg;
import com.atguigu.crud.bean.PeopleInfo;
import com.atguigu.crud.bean.Ply;
import com.atguigu.crud.bean.Reply;
import com.atguigu.crud.services.BookFileService;
import com.atguigu.crud.services.BookService;
import com.atguigu.crud.services.JoinApplyService;
import com.atguigu.crud.services.PeopleService;
import com.atguigu.crud.services.PlyService;
import com.atguigu.crud.services.ReplyService;
import com.atguigu.crud.utils.FTPUtil;
import com.atguigu.crud.utils.MemberUtil;
import com.atguigu.crud.utils.TextUtil;
import com.atguigu.crud.utils.TimeUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 关于显示预定列表
 * 
 * @author lida
 *
 */
@Controller
public class FShowController extends BaseController {
	private String classname = this.getClass().getName();
	private HttpSession session;
	@Autowired
	BookService bookService;
	@Autowired
	PlyService plyService;
	@Autowired
	PeopleService peopleService;
	@Autowired
	ReplyService replyService;
	@Autowired
	BookFileService bookFileService;
	@Autowired
	JoinApplyService joinApplyService;

	/**
	 * 搜索会议处理
	 * 
	 * @param path
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/f/show/search")
	@ResponseBody
	public Msg search(@RequestParam(value = "mydata", defaultValue = "") String data, HttpServletRequest request) {
		getLog(this.getClass()).info("搜索会议:"+data);
		if (data != "") {
			session = request.getSession();
			PeopleInfo peopleInfo = (PeopleInfo) session.getAttribute("currentUser");

			int pn = Integer.parseInt(data.split("_")[4]);
			if (pn < 1) {
				pn = 1;
			}
			PageHelper.startPage(pn, 10); // 后面跟着的查询，就自动分页查询了
			List<Book> lists = bookService.search(data);
			getLog(this.getClass()).info("搜索会议，list:"+lists.size());
			int[] isIn = new int[10];
			int i = 0;
			for (; i < isIn.length; i++) {
				isIn[i] = 0;
			}
			i = 0;

			for (Book book : lists) {
				getLog(this.getClass()).info("获得预定数据:" + book.getPreTheme());
			}
			for (Book book : lists) {
				String path = book.getPreMemberPath();
				// 判断当前id是否已加入到会议成员中
				boolean isin = MemberUtil.memeberIsIn(path, peopleInfo.getPeoEmployeeId());
				int flage = joinApplyService.checkDelState(book.getSerialNum(), peopleInfo.getPeoEmployeeId());

				getLog(this.getClass())
						.info(" 检查会议的申请状态,peoSerialNum:" + peopleInfo.getPeoEmployeeId() + "   状态：" + flage);

				book.setApplyState(flage);
				List<PeopleInfo> sEmployee = peopleService.selectByPrimaryEmployeeId(book.getPrePeopleId());
				getLog(this.getClass()).info("预定者姓名：" + sEmployee.get(0).getPeoEmployeeName());
				book.setPeopleInfo(sEmployee.get(0));
				System.out.println("········"+book.toString());
				if (isin) {
					isIn[i] = 1;
				} else {
					isIn[i] = 0;
				}
				i++;
				
			}
			PageInfo pageInfo = new PageInfo(lists, 5);
			getLog(this.getClass()).info("搜索会议成功");
			return Msg.success().add("pageInfo", pageInfo).add("isIn", isIn);
		}
		return Msg.fail().add("path", "/f_login.jsp");
	}

	/**
	 * 申请退出会议处理
	 * 
	 * @param path
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/f/show/exit")
	@ResponseBody
	public Msg exit(@RequestParam(value = "exit_data", defaultValue = "") String data, HttpServletRequest request) {
		getLog(this.getClass()).info("请求退出会议,获得数据" + data);
		PeopleInfo peopleInfo = (PeopleInfo) request.getSession().getAttribute("currentUser");
		if (peopleInfo != null) {
			Integer employeeId = peopleInfo.getPeoEmployeeId();
			Book book = bookService.selectByPrimaryKey(Integer.parseInt(data));
			if (MemberUtil.memeberExit(book.getPreMemberPath(), employeeId)) {
				bookService.subPeoNum(Integer.parseInt(data));
				return Msg.success();
			}
		}
		return Msg.fail();

	}

	/**
	 * 申请加入会议处理
	 * 
	 * @param path
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/f/show/join")
	@ResponseBody
	public Msg join(@RequestParam(value = "join_data", defaultValue = "") String data, HttpServletRequest request) {
		getLog(this.getClass()).info("请求加入会议,获得数据" + data);
		PeopleInfo peopleInfo = (PeopleInfo) request.getSession().getAttribute("currentUser");
		if (peopleInfo != null) {
			JoinApply joinApply = new JoinApply();
			joinApply.setJoinBookId(Integer.parseInt(data));
			joinApply.setJoinPeopleId(peopleInfo.getPeoEmployeeId());
			joinApply.setJoinOther("");
			joinApply.setJoinDealState(1);
			Book book = bookService.selectByPrimaryKey(Integer.parseInt(data));
			joinApply.setJoinBookOwnerId(book.getPrePeopleId());
			joinApplyService.insertByid(joinApply);
			return Msg.success();
		}
		return Msg.fail();
	}

	/**
	 * 会议文件下载
	 */
	@RequestMapping(value = "/f/show/down",method = RequestMethod.POST)
	@ResponseBody
	public void downFile(@RequestParam(value = "path", defaultValue = "") String path, HttpServletRequest request,
			HttpServletResponse response) {
		FTPUtil ftpUtil = new FTPUtil();
		getLog(this.getClass()).info("downFile开始会议文件下载");
		getLog(this.getClass()).info("path" + path);
		String[] split = path.split("_");
		path = split[0] + "/" + split[1] + "/" + split[2] + "/" + split[3];
		getLog(this.getClass()).info("path" + path);
		try {
			response.setCharacterEncoding("UTF-8");
			// 文件下载头
			response.addHeader("content-disposition", "attachment;filename=" + split[3]);
			// 文件类型
			response.setContentType("multipart/form-data;charset=UTF-8");
			// FileUtils.copyFile(file, response.getOutputStream());
			 OutputStream outputStream = response.getOutputStream();
			boolean b = ftpUtil.retrieveFileToWeb(outputStream, path);
			if (b) {
				getLog(this.getClass()).info("会议文件下载成功");
			}
		} catch (Exception e) {
			getLog(this.getClass()).info("会议文件下载异常");
			e.printStackTrace();
		}

	}

	/**
	 * 获取会议文件信息
	 */
	@RequestMapping(value = "/f/show/getFilelist/{num}", method = RequestMethod.GET)
	@ResponseBody
	public Msg getgetFilelist(@PathVariable(value = "num") Integer num) {
		getLog(this.getClass()).info("获取会议文件信息：" + num);
		List<BookFile> selectByName = bookFileService.selectByName(num);
		if (selectByName.size() > 0) {
			getLog(this.getClass()).info("获取会议文件信息成功");
			return new Msg().success().add("bookFileList", selectByName);

		} else {
			getLog(this.getClass()).info("获取会议文件信息失败");
			return new Msg().fail();
		}
	}

	/**
	 * 上传文件
	 */
	@RequestMapping(value = "/f/show/upload2/{proname}", produces = "text/html;charset=utf-8")
	@ResponseBody
	public String upload2(@RequestParam("file") CommonsMultipartFile partFile, @PathVariable("proname") String mydata,
			HttpServletRequest request) {

		getLog(this.getClass()).info("开始上传会议文件：" + mydata);
		// System.out.println("开始上传会议文件：" + mydata);

		FTPUtil ftpUtil = new FTPUtil();
		if (ftpUtil.open()) {
			getLog(this.getClass()).info("已连接FTP");
		}

		try {
			String[] split = mydata.split("_");
			String proname = split[0];

			Book book = bookService.selectByPrimaryKey(Integer.parseInt(split[1]));
			String path = book.getPreMemberPath();
			path = path.substring(0, path.lastIndexOf("/"));

			path = path + "/files";
			if (!ftpUtil.checkFile(path)) {
				ftpUtil.mkDir(path + "/");
			}
			path = path + "/";

			getLog(this.getClass()).info("会议文件保存路径：" + path);

			// 文件的原始名字
			String fileName = partFile.getOriginalFilename();
			int index = fileName.lastIndexOf(".");
			// 后缀扩展名
			String subfux = "." + fileName.substring(index + 1);
			getLog(this.getClass()).info("文件的原始名字：" + fileName + "HHHHHH" + subfux);

			String tempname = "";
			if (!TextUtil.isEmpty(proname)) {
				tempname = proname + subfux;
			} else {
				tempname = fileName;
			}
			// 保存
			InputStream inputStream = partFile.getInputStream();
			boolean upload = ftpUtil.upload(inputStream, path + tempname);
			if (upload) {
				// 插入会议文件数据记录
				BookFile bookFile = new BookFile();
				bookFile.setFileSavaPath(path + tempname);
				bookFile.setFileBookId(Integer.parseInt(split[1]));
				bookFile.setFileTitle(tempname);
				if(!TextUtil.isEmpty(split[2])) {
					bookFile.setFileOther(split[2]);
				}else {
					bookFile.setFileOther("");
				}
				
				PeopleInfo peopleInfo = (PeopleInfo) request.getSession().getAttribute("currentUser");
				bookFile.setFileOwnerId(peopleInfo.getPeoEmployeeId());
				bookFileService.addNewRecordByFilePath(bookFile);

				if (inputStream != null) {
					inputStream.close();
				}
				getLog(this.getClass()).info("文件上传成功");
				return "文件上传成功";
			}
		} catch (Exception e) {
			e.printStackTrace();
			getLog(this.getClass()).info("文件上传失败");
			return "文件上传失败！";
		}
		return "文件上传失败！";
	}

	/**
	 * 获得预定数据并判断该session用户是否已加入
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/f/show/getBook", method = RequestMethod.GET)
	@ResponseBody
	public Msg getBook(@RequestParam(value = "pn", defaultValue = "1") Integer pn, HttpServletRequest request) {
		session = request.getSession();

		PeopleInfo peopleInfo = (PeopleInfo) session.getAttribute("currentUser");
		if (peopleInfo != null) {
			PageHelper.startPage(pn, 10); // 后面跟着的查询，就自动分页查询了
			List<Book> lists = bookService.getAll();
			int[] isIn = new int[10];
			int i = 0;
			for (; i < isIn.length; i++) {
				isIn[i] = 0;
			}
			i = 0;

			for (Book book : lists) {
				getLog(this.getClass()).info("获得预定数据:" + book.getPreTheme());
			}
			for (Book book : lists) {
				String path = book.getPreMemberPath();
				// 判断当前id是否已加入到会议成员中
				boolean isin = MemberUtil.memeberIsIn(path, peopleInfo.getPeoEmployeeId());
				int flage = joinApplyService.checkDelState(book.getSerialNum(), peopleInfo.getPeoEmployeeId());

				getLog(this.getClass())
						.info(" 检查会议的申请状态,peoSerialNum:" + peopleInfo.getPeoEmployeeId() + "   状态：" + flage);

				book.setApplyState(flage);
				List<PeopleInfo> sEmployee = peopleService.selectByPrimaryEmployeeId(book.getPrePeopleId());
				getLog(this.getClass()).info("预定者姓名：" + sEmployee.get(0).getPeoEmployeeName());
				book.setPeopleInfo(sEmployee.get(0));
				if (isin) {
					isIn[i] = 1;
				} else {
					isIn[i] = 0;
				}
				i++;
			}
			getLog(this.getClass()).info(
					"获得预定数据并判断该session用户是否已加入:user:" + peopleInfo.getPeoEmployeeName() + "isin:" + isIn.toString());
			// 使用pageinfo包装查询后的结果，获得各种分页 的信息 5:连续显示5页
			PageInfo pageInfo = new PageInfo(lists, 5);
			// logger.info("getBook方法,获取预定数据成功");
			return Msg.success().add("pageInfo", pageInfo).add("isIn", isIn);
		} else {
			// logger.info("getBook方法,获取预定数据误");
			return Msg.fail().add("path", "/f_login.jsp");
		}
	}

	/**
	 * ajax请求评论列表
	 * 
	 * @return
	 */
	@RequestMapping(value = "/f/show/replylist/{num}", method = RequestMethod.GET)
	@ResponseBody
	public Msg getxiangxi(@PathVariable(value = "num") Integer num, HttpServletRequest request) {

		getLog(this.getClass()).info("进入ajax请求评论列表" + num);
		if (num != null) {
			List<Ply> list = plyService.selectPingByNum(num);
			if (list.size() == 0) {
				return new Msg().fail();
			} else {

				getLog(this.getClass()).info("ajax请求评论列表成功" + list.get(0).toString());
				return new Msg().success().add("plys", list);
			}
		}
		return new Msg().fail();
	}

	/**
	 * 保存留言评论
	 */
	@RequestMapping(value = "/f/show/addply", method = RequestMethod.GET)
	@ResponseBody
	public Msg addply(@RequestParam(value = "mydata", defaultValue = " ") String mydata) {
		if (mydata != " ") {
			getLog(this.getClass()).info("保存留言评论:" + mydata);
			String[] split = mydata.split("_");
			Ply ply = new Ply();
			ply.setPlyPeoId(Integer.parseInt(split[0]));
			ply.setPlyPeoName(split[1]);
			ply.setPlyBookNum(Integer.parseInt(split[2]));
			ply.setPlyMessage(split[3]);
			ply.setPlyTime(TimeUtil.stringToDate(split[4], "yyyy-MM-dd HH:mm:ss"));
			List<PeopleInfo> peopleInfo = peopleService.selectByPrimaryEmployeeId(ply.getPlyPeoId());
			if (peopleInfo.size() < 3) {
				ply.setPlyPeoPicturePath(peopleInfo.get(0).getPeoImagePath());
			} else {
				getLog(this.getClass()).warn("保存留言评论,查到多个同名EmployeeId的peopel");
			}
			getLog(this.getClass()).info("保存留言评论:" + ply.toString());
			int i = plyService.insert(ply);

			return new Msg().success().add("numid", i);

		}
		return new Msg().fail();
	}

	/**
	 * 保存回复评论
	 */
	@RequestMapping(value = "/f/show/addreply", method = RequestMethod.GET)
	@ResponseBody
	public Msg addreply(@RequestParam(value = "mydata", defaultValue = " ") String mydata) {
		if (mydata != " ") {
			getLog(this.getClass()).info("保存回复评论:" + mydata);
			String[] split = mydata.split("_");
			Reply reply = new Reply();
			reply.setReplyPeoId(Integer.parseInt(split[0]));
			reply.setReplyPeoIdName(split[1]);
			reply.setReplyToPlyId(Integer.parseInt(split[2]));
			reply.setReplyToPlyPeoId(Integer.parseInt(split[3]));
			reply.setReplyToPlyPeoName(split[4]);
			reply.setReplytTime(TimeUtil.stringToDate(split[5], "yyyy-MM-dd HH:mm:ss"));
			reply.setReplyMessage(split[6]);
			replyService.insert(reply);
			return new Msg().success();
		}
		return new Msg().fail();
	}

}