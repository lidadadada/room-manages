package com.atguigu.crud.bean;
/*
 * 通用返回类
 */

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.core.pattern.AbstractStyleNameConverter.Magenta;

public class Msg {
	
	private int code;			//状态码	100成功	200错误
	private String msg;			//提示信息
	
	//要返回给浏览器的数据
	private Map<String, Object>	extend =new HashMap<String, Object>();

	public static Msg success() {
		Msg success=new Msg();
		success.setCode(100);
		success.setMsg("处理成功!");
		return success;
	}
	public static Msg fail() {
		Msg success=new Msg();
		success.setCode(200);
		success.setMsg("处理失败!");
		return success;
	}
	
	//链式操作
	public Msg add(String key,Object value) {
		this.getExtend().put(key, value);
		return this;
	}
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Map<String, Object> getExtend() {
		return extend;
	}

	public void setExtend(Map<String, Object> extend) {
		this.extend = extend;
	}
	
}
