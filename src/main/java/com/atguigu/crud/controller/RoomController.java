package com.atguigu.crud.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.atguigu.crud.bean.Book;
import com.atguigu.crud.bean.BookInputs;
import com.atguigu.crud.bean.ManagePeople;
import com.atguigu.crud.bean.Msg;
import com.atguigu.crud.bean.RoomInfo;
import com.atguigu.crud.common.ManageConfig;
import com.atguigu.crud.services.RoomService;
import com.atguigu.crud.utils.TimeUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
public class RoomController {
	@Autowired
	RoomService roomService;
	private HttpSession session;
	private ManagePeople managePeople;

	/*
	 * 更新
	 */
	@RequestMapping(value = "/room/manage/update/", method = RequestMethod.POST)
	@ResponseBody
	public Msg update(RoomInfo roomInfo) {
		roomService.update(roomInfo);
		return Msg.success();
	}

	/*
	 * 表单里根据序号删除预定记录 ,,,,单个+多个 1-2-3 1
	 */
	@RequestMapping(value = "/room/manage/delete/{deleteNum}")
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
			roomService.deleteBatch(lists);
			return Msg.success();
		} else {
			roomService.deleteByPrimaryKey(Integer.parseInt(deleteNum));
			return Msg.success();
		}

	}

	/*
	 * 编辑模态框数据回显
	 */
	@RequestMapping(value = "/room/manage/reback", method = RequestMethod.GET)
	@ResponseBody
	public Msg getReback(@RequestParam(value = "num", defaultValue = "-1") Integer num) {
		// 引入pagehelper 分页插件 每页条数
		System.out.println(num);
		if (num != -1) {
			RoomInfo roomInfo = roomService.selectByPrimaryKey(num);
			return Msg.success().add("book", roomInfo);
		}
		return Msg.fail();
	}

	/*
	 * 获得所有的会议室信息，，，预定表的模态框
	 */
	@RequestMapping(value = "/room_book_info", method = RequestMethod.GET)
	@ResponseBody
	public Msg getRoomBook() {
		List<RoomInfo> lists = roomService.getRoomBook();
		return Msg.success().add("lists", lists);
	}

	/*
	 * 获取所有的会议室数据
	 */
	@RequestMapping(value = "/room/manage/table", method = RequestMethod.GET)
	@ResponseBody
	public Msg getAllroom(@RequestParam(value = "pn", defaultValue = "1") Integer pn, HttpServletRequest request) {
		session = request.getSession();
		managePeople = (ManagePeople) session.getAttribute("currentAdmin");
		if (managePeople != null) {
			// 引入pagehelper 分页插件 每页条数
			PageHelper.startPage(pn, 9); // 后面跟着的查询，就自动分页查询了
			List<RoomInfo> lists = roomService.getRoomBook();
			// 使用pageinfo包装查询后的结果，获得各种分页 的信息 5:连续显示5页
			PageInfo pageInfo = new PageInfo(lists, 5);
			return Msg.success().add("pageInfos", pageInfo);
		} else {
			return Msg.fail().add("path", "/manage_index.jsp");
		}
	}

	@RequestMapping(value = "/room/manage/save")
	@ResponseBody
	public Msg saveRoomFromModel(RoomInfo roomInfo) {
		System.out.println(roomInfo.toString() + "++++++++++");
		roomService.save(roomInfo);
		return null;

	}
}
