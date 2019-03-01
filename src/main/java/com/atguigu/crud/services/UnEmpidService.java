package com.atguigu.crud.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.crud.bean.UnEmpid;
import com.atguigu.crud.bean.UnEmpidExample;
import com.atguigu.crud.bean.UnEmpidExample.Criteria;
import com.atguigu.crud.common.UserConfig;
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
	
	/**
	 * 修改使用状态
	 * @param id
	 * @param stateCode
	 * @return
	 */
	public void updateEmpIdState(Integer empid,Integer stateCode) {
		UnEmpid unEmpid2 = selectByEmpid(empid).get(0);
		unEmpid2.setUseState(stateCode);
		int i = unEmpidMapper.updateByPrimaryKeySelective(unEmpid2);
		
	}
	/**
	 * 注册账号
	 * @param empid
	 * @return
	 */
	public boolean useAEmpid(Integer empid) {
		UnEmpid unEmpid = selectByEmpid(empid).get(0);
		if(unEmpid.getUseState()==UserConfig.empIdUnUseState) {
			updateEmpIdState(empid,UserConfig.empIdUsedState);
			return true;
		}
		System.out.println("注册账号失败");
		return false;
		
	}
}
