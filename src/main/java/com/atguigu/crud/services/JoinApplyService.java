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
	/**
	 * 通过预定序列号查询
	 * @param serialNum
	 * @param peoEmployeeId
	 * @return
	 */
	public JoinApply selectByBookId(int serialNum, int peoEmployeeId) {
		getLog(this.getClass()).info("selectByBookIdAndEmpId:num:"+serialNum+":::empid:"+peoEmployeeId);
		JoinApplyExample joinApplyExample = new JoinApplyExample();
		Criteria createCriteria = joinApplyExample.createCriteria();
		createCriteria.andJoinBookIdEqualTo(serialNum);
		createCriteria.andJoinPeopleIdEqualTo(peoEmployeeId);
		List<JoinApply> list = joinApplyMapper.selectByExample(joinApplyExample);
		if(list!=null&&list.size()>0) {
			return list.get(0);
		}
		return null;
	}
	/**
	 * 通过创建会议的负责人id查询列表
	 * @param peoEmployeeId
	 * @return 
	 */
	public List<JoinApply> selectByOwerId(Integer peoEmployeeId) {
		JoinApplyExample joinApplyExample = new JoinApplyExample();
		Criteria createCriteria = joinApplyExample.createCriteria();
		createCriteria.andJoinBookOwnerIdEqualTo(peoEmployeeId);
		return  joinApplyMapper.selectByExample(joinApplyExample);
		
	}
	/**
	 * 更新申请状态
	 * @param id
	 * @return 
	 */
	
	public boolean updateApplyState( Integer id,int stateCode) {
		JoinApply apply = joinApplyMapper.selectByPrimaryKey(id);
		if(apply!=null) {
			apply.setJoinDealState(stateCode);			
			joinApplyMapper.updateByPrimaryKey(apply);
			return true;
		}
		return false;
	}
	
	/**
	 * 根据主键查询 
	 * @param joinId
	 * @return
	 */
	public JoinApply selectByPrimaryKey(int joinId) {
		return  joinApplyMapper.selectByPrimaryKey(joinId);
	}
	/**
	 * 根据预定号修改
	 * @param preRoomNum
	 * @param applyJoinDisboard
	 */
	public void updateApplyStateByBookid(Integer seriaNum, int stateCode) {
		JoinApplyExample joinApplyExample = new JoinApplyExample();
		Criteria createCriteria = joinApplyExample.createCriteria();
		createCriteria.andJoinBookIdEqualTo(seriaNum);
		JoinApply joinApply2 = new JoinApply();
		joinApply2.setJoinDealState(stateCode);
		joinApplyMapper.updateByExampleSelective(joinApply2, joinApplyExample);
	}
}
