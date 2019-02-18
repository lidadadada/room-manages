package com.atguigu.crud.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseService {
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
