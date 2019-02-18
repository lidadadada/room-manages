package com.atguigu.crud.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;


public class BaseController {
	Logger logger;

	public Logger getLog(Class clazz) {
		if (logger!=null&&logger.getName() == clazz.getName()) {
			return logger;
		} else {
			logger = LoggerFactory.getLogger(clazz);
			return logger;
		}
	}
}
