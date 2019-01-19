package com.atguigu.crud.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.crud.bean.ManagePeople;
import com.atguigu.crud.bean.ManagePeopleExample;
import com.atguigu.crud.bean.ManagePeopleExample.Criteria;
import com.atguigu.crud.common.ManageConfig;
import com.atguigu.crud.dao.ManagePeopleMapper;

@Service
public class ManagePeopleService {
	@Autowired
	ManagePeopleMapper managePeopleMapper;
	/*
	 * 校验用户名
	 */
	public ManagePeople getPeopleByName(String name) {
	
		return managePeopleMapper.selectByPrimaryKey(name);
	}
	public List<ManagePeople> getLoginPeopleByName(String sid) {
		ManagePeopleExample example = new ManagePeopleExample();
		Criteria criteria = example.createCriteria();
		criteria.andManageNameEqualTo(sid);
		List<ManagePeople> lists = managePeopleMapper.selectByExample(example);
		return lists;
	}
}
