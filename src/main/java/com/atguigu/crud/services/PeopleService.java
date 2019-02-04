package com.atguigu.crud.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.crud.bean.BookExample.Criteria;
import com.atguigu.crud.common.UserConfig;
import com.atguigu.crud.bean.PeopleInfo;
import com.atguigu.crud.bean.PeopleInfoExample;
import com.atguigu.crud.dao.PeopleInfoMapper;

/*
 * 处理人员相关的
 */
@Service
public class PeopleService {
	@Autowired
	PeopleInfoMapper peopleInfoMapper;
	/**
	 * 根据员工id查询
	 * @param id
	 * @return List<PeopleInfo>
	 */
	public List<PeopleInfo> getPeopleInfoById(Integer id){
		//return peopleInfoMapper.selectByEmployeeId(id);
		return null;
	}
	/**
	 * 获得所有员工数据
	 * @return
	 */
	public List<PeopleInfo> getAll() {
		return peopleInfoMapper.selectByExample(null);
	}
	/**
	 * 根据主键/序号查询
	 * @param num
	 * @return
	 */
	public PeopleInfo selectByPrimaryKey(Integer num) {
		return peopleInfoMapper.selectByPrimaryKey(num);
	}
	/**
	 * 根据员工号查询
	 */
	public List<PeopleInfo> selectByPrimaryEmployeeId(Integer id) {
		PeopleInfoExample example = new PeopleInfoExample();
		com.atguigu.crud.bean.PeopleInfoExample.Criteria createCriteria = example.createCriteria();
		createCriteria.andPeoEmployeeIdEqualTo(id);
		return peopleInfoMapper.selectByExample(example);
	}
	/**
	 * 自适应更新员工信息
	 * @param peopleInfo
	 */
	public void update(PeopleInfo peopleInfo) {
		peopleInfoMapper.updateByPrimaryKeySelective(peopleInfo);
		System.out.println("++++++"+peopleInfo.toString());
	}
	/**
	 * 根据主键删除员工
	 * @param num
	 */
	public void deleteByPrimaryKey(Integer num) {
		peopleInfoMapper.deleteByPrimaryKey(num);
	}
	/**
	 * 批量删除
	 */
	public void deleteBatch(List<Integer> split) {
		PeopleInfoExample example = new PeopleInfoExample();
		com.atguigu.crud.bean.PeopleInfoExample.Criteria criteria = example.createCriteria();
		//delete form tabel  SerialNumIn in (1,2,3)
		criteria.andPeoSerialNumIn(split);
		peopleInfoMapper.deleteByExample(example);
		
	}
	/**
	 * 根据名字/账户名查找
	 * @param user
	 * @return
	 */
	public List<PeopleInfo> selectByPrimaryEmployeeName(String user) {
		PeopleInfoExample example = new PeopleInfoExample();
		com.atguigu.crud.bean.PeopleInfoExample.Criteria criteria = example.createCriteria();
		criteria.andPeoEmployeeNameEqualTo(user);
		List<PeopleInfo> list = peopleInfoMapper.selectByExample(example);
		return list;
	}

}
