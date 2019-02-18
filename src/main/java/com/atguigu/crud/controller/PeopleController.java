package com.atguigu.crud.controller;
/*
 * 处理人员相关的
 */
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.atguigu.crud.bean.Book;
import com.atguigu.crud.bean.BookInput;
import com.atguigu.crud.bean.ManagePeople;
import com.atguigu.crud.bean.Msg;
import com.atguigu.crud.bean.PeopleInfo;
import com.atguigu.crud.common.ManageConfig;
import com.atguigu.crud.services.PeopleService;
import com.atguigu.crud.utils.TimeUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
public class PeopleController extends BaseController{
	@Autowired
	PeopleService peopleService;
	private HttpSession session;
	private ManagePeople managePeople;
	/*
	 * 更新
	 */
	@RequestMapping(value = "/people/manage/update/", method = RequestMethod.POST)
	@ResponseBody
	public Msg update(PeopleInfo peopleInfo) {
		peopleService.update(peopleInfo);
		return Msg.success();
	}
	/*
	 * 表单里根据序号删除预定记录 ,,,,单个+多个 1-2-3 1
	 */
	@RequestMapping(value = "/people/manage/delete/{deleteNum}")
	@ResponseBody
	public Msg deleteByPrimaryKey(@PathVariable("deleteNum") String deleteNum) {
		System.out.println(deleteNum + "+++++++++22++");
		if (deleteNum.contains("-")) {
			List<Integer> lists = new ArrayList<Integer>();
			String[] split = deleteNum.split("-");
			// 组装
			for (String sp : split) {
				lists.add(Integer.parseInt(sp));
			}
			peopleService.deleteBatch(lists);
			return Msg.success();
		} else {
			peopleService.deleteByPrimaryKey(Integer.parseInt(deleteNum));
			return Msg.success();
		}
	}
	/*
	 * 编辑模态框数据回显
	 */
	@RequestMapping(value = "/people/manage/reback", method = RequestMethod.GET)
	@ResponseBody
	public Msg getReback(@RequestParam(value = "num", defaultValue = "-1") Integer num) {
		// 引入pagehelper 分页插件 每页条数
		// System.out.println(num);
		if (num != -1) {
			PeopleInfo peopleInfo = peopleService.selectByPrimaryKey(num);
			return Msg.success().add("peopleInfo", peopleInfo);
		}
		return Msg.fail();
	}
	/*
	 * 根据页数 获取所有的people数据
	 */
	@RequestMapping(value = "/people/manage/tabel", method = RequestMethod.GET)
	@ResponseBody
	public Msg getAll(@RequestParam(value = "pn", defaultValue = "1") Integer pn, HttpServletRequest request) {
		// 引入pagehelper 分页插件 每页条数
		session = request.getSession();
		managePeople = (ManagePeople) session.getAttribute("currentAdmin");
		if (managePeople != null) {
			PageHelper.startPage(pn, 10); // 后面跟着的查询，就自动分页查询了
			List<PeopleInfo> lists = peopleService.getAll();
			System.out.println("getAll,list:"+lists.size());
			// 使用pageinfo包装查询后的结果，获得各种分页 的信息 5:连续显示5页
			PageInfo pageInfo = new PageInfo(lists, 5);
			return Msg.success().add("pageInfo", pageInfo);
		}
		else {
			return Msg.fail().add("path", "/manage_index.jsp");
		}
	}

	/*
	 * 添加模态框中，根据员工号查找该员工信息，并判断是否存在
	 */
	@RequestMapping(value = "/people_save_model_select", method = RequestMethod.GET)
	@ResponseBody
	public Msg getPeopleInfoById(@RequestParam(value = "id", defaultValue = "-1") Integer id) {
		if (id != -1) {
			System.out.println("ajax检查员工号是否存在");
			getLog(this.getClass()).info("ajax检查员工号是否存在:"+id);
			List<PeopleInfo> lists = peopleService.getPeopleInfoById(id);
			if (lists.size() > 0) {
				return Msg.success().add("listPeopleInfo", lists);
			}
			System.out.println(lists.get(0).toString());
		}
		return Msg.fail();
	}
}
