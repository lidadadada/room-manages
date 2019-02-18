package com.atguigu.crud.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.atguigu.crud.bean.Msg;
import com.atguigu.crud.bean.PeopleInfo;
import com.atguigu.crud.services.PeopleService;

@Controller
public class FLoginController extends BaseController {
	@Autowired
	PeopleService peopleService;

	/*
	 * 用户登陆校验,保存session为currentUser
	 */
	@RequestMapping(value = "/f/people/")
	@ResponseBody
	public Msg checkUser(@RequestParam(value = "loginData", defaultValue = "") String loginData,
			HttpServletRequest request) {
		getLog(this.getClass()).info("登陆:" + loginData);
		if (loginData != "") {
			String[] split = loginData.trim().split("_");
			if (split[0] != null && split[1] != null && split[0] != "" && split[1] != "") {
				System.out.println(split[0] + "+" + split[1]);
				List<PeopleInfo> list = peopleService.selectByPrimaryEmployeeName(split[0]);
				if(list.size()==0) {
					list =peopleService.selectByPrimaryEmployeeId(Integer.parseInt(split[0]));
				}
				if(list.size()==0) {
					list = peopleService.selectByPrimaryEmployeephone(split[0]);
				}
				if (list.size() > 0) {
					PeopleInfo peopleInfo = list.get(0);
					if (peopleInfo != null && peopleInfo.getPeoPassword().equals(split[1])) {
						request.getSession().setAttribute("currentUser", peopleInfo);
						// System.out.println("登陆");
						return Msg.success().add("path", "/f_main.jsp");
					}
				}

			}
		}
		return Msg.fail();
	}
}
