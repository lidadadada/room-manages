package com.atguigu.crud.services;

import static org.hamcrest.CoreMatchers.startsWith;

import java.util.ArrayList;
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
		PeopleInfoExample peopleInfoExample = new PeopleInfoExample();
		com.atguigu.crud.bean.PeopleInfoExample.Criteria criteria = peopleInfoExample.createCriteria();
		criteria.andPeoEmployeeIdEqualTo(id);
		return peopleInfoMapper.selectByExample(peopleInfoExample);
	}
	/**
	 * 获得所有员工数据
	 * @return
	 */
	public List<PeopleInfo> getAll() {
		List<PeopleInfo> selectByExample = peopleInfoMapper.selectByExample(null);
		System.out.println("selectByExample:"+selectByExample.size());
		return selectByExample;
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
		criteria.andPeoEmployeeNameLike("%"+user+"%");
		List<PeopleInfo> list = peopleInfoMapper.selectByExample(example);
		return list;
	}
	/**
	 * 插入员工
	 * @param peopleInfo
	 */
	public void insertEmployeeSerlactive(PeopleInfo peopleInfo) {
		peopleInfoMapper.insertSelective(peopleInfo);
		
	}
	/**
	 * 根据电话
	 * @param phone
	 * @return
	 */
	public List<PeopleInfo> selectByPrimaryEmployeephone(String phone) {
		PeopleInfoExample example = new PeopleInfoExample();
		com.atguigu.crud.bean.PeopleInfoExample.Criteria criteria = example.createCriteria();
		criteria.andPeoPhoneEqualTo(phone);
		return peopleInfoMapper.selectByExample(example);
	}
	
	/**
	 * 有选择性地跟新
	 * @param peopleInfo
	 * @return 
	 */
	public boolean updateByPrimaryKeySelective(PeopleInfo peopleInfo) {
		int i = peopleInfoMapper.updateByPrimaryKeySelective(peopleInfo);
		if(i==1) {
			return true;
		}else {
			return false;
		}
		
	}
	/**
	 * 根据例表的id查询
	 * @param list
	 * @return 
	 */
	public List<PeopleInfo> selectByPrimaryEmployeeId(ArrayList<String> list) {
		PeopleInfoExample example = new PeopleInfoExample();
		com.atguigu.crud.bean.PeopleInfoExample.Criteria criteria = example.createCriteria();
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		if(list.size()>0) {
			for (String string : list) {
				System.out.println("________"+string+"___________");
				if(!string.trim().isEmpty()) {
					System.out.println("________"+string+"___________");
					arrayList.add(Integer.parseInt(string));					
				}
			}
			if(arrayList.size()>0) {
				criteria.andPeoEmployeeIdIn(arrayList);
				return peopleInfoMapper.selectByExample(example);
			}
		}
		return null;
	}
	
	/**
	 * 根据手机号查询
	 * @param mydata
	 * @return 
	 */
	public List<PeopleInfo> selectByPhone(String mydata) {
		PeopleInfoExample example = new PeopleInfoExample();
		com.atguigu.crud.bean.PeopleInfoExample.Criteria criteria = example.createCriteria();
		criteria.andPeoPhoneEqualTo(mydata);
		return peopleInfoMapper.selectByExample(example);
	}
}
