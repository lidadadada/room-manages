package com.atguigu.crud.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/page")
public class PageJumpController {

	@RequestMapping("/pagelist")
	public String pagelist(String num,Map<String, Object> map) {
		System.out.println("ddddddddddddfj==================="+num);
		map.put("num", num);
		return "f_xi_list";
	}
}
