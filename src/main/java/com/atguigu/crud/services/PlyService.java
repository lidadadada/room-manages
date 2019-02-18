package com.atguigu.crud.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.crud.bean.Ply;
import com.atguigu.crud.bean.PlyExample;
import com.atguigu.crud.bean.ReplyExample;
import com.atguigu.crud.bean.PlyExample.Criteria;
import com.atguigu.crud.bean.Reply;
import com.atguigu.crud.dao.PlyMapper;
import com.atguigu.crud.dao.ReplyMapper;

@Service
public class PlyService {
	@Autowired
	PlyMapper plyMapper;
	@Autowired
	ReplyMapper replyMapper;
	/**
	 * 根据预定号查询留言
	 */
	public List<Ply> selectPingByNum(Integer num) {
		PlyExample plyExample = new PlyExample();
		Criteria criteria = plyExample.createCriteria();
		criteria.andPlyBookNumEqualTo(num);
		
		ReplyExample replyExample = new ReplyExample();
		com.atguigu.crud.bean.ReplyExample.Criteria criteria2 = replyExample.createCriteria();
		
		List<Ply> list = plyMapper.selectByExample(plyExample);
		for (Ply ply : list) {
			criteria2.andReplyToPlyIdEqualTo(ply.getPlyId());
			ply.setReplys(replyMapper.selectByExample(replyExample));
		}
		return list;
	}
	/**
	 * 选择性地保存ply,并返回主键
	 * @param ply
	 * @return
	 */
	public int insert(Ply ply) {
		ply.setPlyId(null);
		plyMapper.insertSelective(ply);	
		System.out.println(ply.getPlyId()+"主键++++++++++++");
		return 	ply.getPlyId();
	}
}
