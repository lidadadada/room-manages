package com.atguigu.crud.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.crud.bean.UnEmpid;
import com.atguigu.crud.bean.UnEmpidExample;
import com.atguigu.crud.bean.UnEmpidExample.Criteria;
import com.atguigu.crud.dao.UnEmpidMapper;

@Service
public class UnEmpidService {
	@Autowired
	UnEmpidMapper unEmpidMapper;
	
	/**
	 * 根据empid查询
	 * @param empid
	 * @return
	 */
	public List<UnEmpid> selectByEmpid(Integer empid) {
		UnEmpidExample unEmpidExample = new UnEmpidExample();
		Criteria createCriteria = unEmpidExample.createCriteria();
		createCriteria.andEmpIdEqualTo(empid);
		return unEmpidMapper.selectByExample(unEmpidExample);
	}
	/**
	 * 删除员工号
	 * @param empid
	 */
	public void subByEmpid(Integer empid) {
		UnEmpidExample unEmpidExample = new UnEmpidExample();
		Criteria createCriteria = unEmpidExample.createCriteria();
		createCriteria.andEmpIdEqualTo(empid);
		unEmpidMapper.deleteByExample(unEmpidExample);
		
	}
}
