package com.atguigu.crud.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.crud.bean.BookFile;
import com.atguigu.crud.bean.BookFileExample;
import com.atguigu.crud.bean.BookFileExample.Criteria;
import com.atguigu.crud.bean.PeopleInfo;
import com.atguigu.crud.dao.BookFileMapper;
import com.atguigu.crud.dao.PeopleInfoMapper;

@Service
public class BookFileService {

	@Autowired
	BookFileMapper bookFileMapper;
	@Autowired
	PeopleService peopleService;

	/**
	 * 根据文件路劲保存一条文件记录，
	 * 
	 * @param bookFile
	 * @return
	 */
	public void addNewRecordByFilePath(BookFile bookFile) {
		bookFileMapper.insertSelective(bookFile);

	}

	/**
	 * 根据预定序列号查询会议文件信息
	 * 
	 * @param num
	 * @return
	 */
	public List<BookFile> selectByName(Integer num) {
		BookFileExample bookFileExample = new BookFileExample();
		Criteria createCriteria = bookFileExample.createCriteria();
		createCriteria.andFileBookIdEqualTo(num);
		List<BookFile> list = bookFileMapper.selectByExample(bookFileExample);
		System.out.println("查询会议文件信息:"+list.size());
		if (list.size() > 0) {
			for (BookFile bookFile : list) {
				System.out.println(bookFile.getFileOwnerId());
				Integer id = bookFile.getFileOwnerId();
				PeopleInfo peopleInfo = peopleService.selectByPrimaryEmployeeId(id).get(0);
				System.out.println(peopleInfo.toString()+peopleInfo.getPeoEmployeeName());
				bookFile.setFileOwnerName(peopleInfo.getPeoEmployeeName());
			}
		}
		return list;
	}
	/**
	 * 根据路径查找相对应的文件名字
	 * @param path
	 * @return
	 */
	public String selectTitleByPath(String path) {
		BookFileExample bookFileExample = new BookFileExample();
		Criteria createCriteria = bookFileExample.createCriteria();
		createCriteria.andFileSavaPathEqualTo(path);
		return bookFileMapper.selectByExample(bookFileExample).get(0).getFileTitle();
		
	}

}
