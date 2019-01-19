package com.atguigu.crud.controller;

import java.io.IOException;
import java.util.List;

import javax.accessibility.AccessibleRelation;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.atguigu.crud.bean.ManagePeople;
import com.atguigu.crud.bean.ManagePeopleExample;
import com.atguigu.crud.bean.Msg;
import com.atguigu.crud.bean.ManagePeopleExample.Criteria;
import com.atguigu.crud.common.ManageConfig;
import com.atguigu.crud.services.ManagePeopleService;

@Controller
public class ManagePeopleController {
	@Autowired
	ManagePeopleService managePeopleService;
	String user;
	/*
	 * 验证密码
	 */
	@RequestMapping("/index/{pass}")
	@ResponseBody
	public Msg checkPass(@PathVariable("pass")String pass,HttpServletRequest req
			,HttpServletResponse response) {
		if(pass.contains("-")) {
			String[] split = pass.split("-");
			if(split[0]!=""&&split[1]!=""&&split[0]!=null&&split[1]!=null) {
				List<ManagePeople> list = managePeopleService.getLoginPeopleByName(split[0].trim());
				if(list.size()==1) {
					ManagePeople managePeople = list.get(0);
					if(managePeople.getManageEmpid()!=null
							&&managePeople.getManageName().equals(split[0].trim())
							&&managePeople.getManagePassword().equals(split[1].trim()))
					{
						req.getSession().setAttribute("currentAdmin", managePeople);
						return Msg.success().add("path", "/manage_book_table.jsp");
					}
				}
				
			}
		}
		return Msg.fail();
	}
	
}

