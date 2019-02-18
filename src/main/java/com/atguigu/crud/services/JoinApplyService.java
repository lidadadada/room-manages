package com.atguigu.crud.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.crud.bean.JoinApply;
import com.atguigu.crud.bean.JoinApplyExample;
import com.atguigu.crud.bean.JoinApplyExample.Criteria;
import com.atguigu.crud.dao.JoinApplyMapper;

import net.sf.jsqlparser.statement.insert.Insert;

@Service
public class JoinApplyService extends BaseService{
	@Autowired
	JoinApplyMapper joinApplyMapper;
	/**
	 * 插入
	 */
	public void insertByid(JoinApply joinApply){
		joinApplyMapper.insertSelective(joinApply);
	}
	/**
	 * 检查会议的申请状态
	 * @param serialNum
	 * @param peoSerialNum
	 * @return
	 */
	public int checkDelState(Integer serialNum, Integer peoSerialNum) {
		JoinApplyExample joinApplyExample = new JoinApplyExample();
		Criteria createCriteria = joinApplyExample.createCriteria();
		createCriteria.andJoinBookIdEqualTo(serialNum);
		createCriteria.andJoinPeopleIdEqualTo(peoSerialNum);
		List<JoinApply> list = joinApplyMapper.selectByExample(joinApplyExample);
		if(list!=null&&list.size()>0) {
			return list.get(list.size()-1).getJoinDealState();
		}
		return 0;
	}
}
