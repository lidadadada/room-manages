package com.atguigu.crud.services;

import java.util.List;

import org.apache.logging.log4j.core.config.plugins.ResolverUtil.NameEndsWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.crud.bean.BookExample;
import com.atguigu.crud.bean.RoomInfo;
import com.atguigu.crud.bean.RoomInfoExample;
import com.atguigu.crud.bean.BookExample.Criteria;
import com.atguigu.crud.dao.RoomInfoMapper;

@Service
public class RoomService {
	@Autowired
	RoomInfoMapper roomInfoMapper;
	/*
	 * 获得所有的会议室
	 */
	public List<RoomInfo> getRoomBook(){
		return roomInfoMapper.selectByExample(null);
	}
	public void save(RoomInfo roomInfo) {
		roomInfoMapper.insertSelective(roomInfo);
	}
	public RoomInfo selectByPrimaryKey(Integer num) {
		
		return roomInfoMapper.selectByPrimaryKey(num);
	}
	public void update(RoomInfo roomInfo) {
		roomInfoMapper.updateByPrimaryKeySelective(roomInfo);
	}
	/*
	 * 批量删除
	 */
	public void deleteBatch(List<Integer> split) {
		RoomInfoExample example = new RoomInfoExample();
		com.atguigu.crud.bean.RoomInfoExample.Criteria criteria = example.createCriteria();
		//delete form tabel  SerialNumIn in (1,2,3)
		criteria.andRoomNumIn(split);
		roomInfoMapper.deleteByExample(example);
	}
	/*
	 * 根据序号删除单条记录
	 */
	public void deleteByPrimaryKey(Integer num) {
		roomInfoMapper.deleteByPrimaryKey(num);
	}
	
	/**
	 * 根据会议室名字查询
	 * @param string
	 * @return 
	 */
	public List<RoomInfo> selectByRoomName(String name) {
		RoomInfoExample roomInfoExample = new RoomInfoExample();
		com.atguigu.crud.bean.RoomInfoExample.Criteria createCriteria = roomInfoExample.createCriteria();
		System.out.println("根据会议室名字查询:"+name);
		createCriteria.andRoomNameEqualTo(name);
		return roomInfoMapper.selectByExample(roomInfoExample);
	}

}
