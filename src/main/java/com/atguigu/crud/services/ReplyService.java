package com.atguigu.crud.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.crud.bean.Reply;
import com.atguigu.crud.dao.ReplyMapper;

@Service
public class ReplyService {
	
	@Autowired
	ReplyMapper replyMapper;
	/**
	 * 选择性地保存reply
	 * @param reply
	 * @return
	 */
	public void insert(Reply reply) {
		replyMapper.insertSelective(reply);
	}

}
