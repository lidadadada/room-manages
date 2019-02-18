package com.atguigu.crud.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.validator.constraints.pl.REGON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.atguigu.crud.bean.Msg;
import com.atguigu.crud.bean.PeopleInfo;
import com.atguigu.crud.bean.RegPo;
import com.atguigu.crud.bean.UnEmpid;
import com.atguigu.crud.services.PeopleService;
import com.atguigu.crud.services.UnEmpidService;
import com.atguigu.crud.utils.RandomValidateCode;

@Controller
public class FRegController extends BaseController{
	@Autowired
	UnEmpidService unEmpidService;
	@Autowired
	PeopleService peopleService;
	/**
	 * 校验员工号
	 * @param mydata
	 * @return
	 */
	@RequestMapping(value = "/f/reg/empid")
	@ResponseBody
	public Msg validateEmpid(@RequestParam(value="empid",defaultValue="")String mydata) {
		getLog(this.getClass()).info("开始校验员工号:"+mydata);
		if(mydata!="") {
			Integer empid = Integer.parseInt(mydata);
			List<UnEmpid> selectByEmpid = unEmpidService.selectByEmpid(empid);
			if(selectByEmpid.size()>0) {
				return Msg.success();
			}
		}
		return Msg.fail();
	}
	
	/**
	 * 注册
	 * @param regPo
	 * @return
	 */
	@RequestMapping(value = "/f/reg/regdata")
	@ResponseBody
	public Msg reg(RegPo regPo) {
		getLog(this.getClass()).info("注册："+regPo.toString());
		PeopleInfo peopleInfo = new PeopleInfo();
		peopleInfo.setPeoPhone(regPo.getPhone());
		peopleInfo.setPeoPassword(regPo.getPass2());
		peopleInfo.setPeoEmployeeName(regPo.getEmpname());
		peopleInfo.setPeoEmployeeId(regPo.getEmpid());
		peopleService.insertEmployeeSerlactive(peopleInfo);
		unEmpidService.subByEmpid(regPo.getEmpid());
		return Msg.success().add("path", "/f_login.jsp");
	}
}
