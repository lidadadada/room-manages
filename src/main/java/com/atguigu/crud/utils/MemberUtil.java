package com.atguigu.crud.utils;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.atguigu.crud.common.FTPConfig;
import com.atguigu.crud.common.UserConfig;
import com.atguigu.crud.services.BookService;

/**
 * 用于参与会议的成员的相关处理
 * 
 * @author lida
 *
 */
public class MemberUtil {
	static Logger logger = LoggerFactory.getLogger(MemberUtil.class);

	/**
	 * 获得所有参会人员id
	 * @param path
	 * @return
	 * @throws FileNotFoundException
	 */
	public static ArrayList<String> getAllmember(String path) throws FileNotFoundException {
		FTPUtil ftpUtil = new FTPUtil();
		String filepath = path.substring( path.indexOf("/")+1, path.lastIndexOf("/"));
		String pathName = path.substring( path.lastIndexOf("/")+1,path.length());
		ftpUtil.retrieveFile(path, UserConfig.basePath + filepath);
		File file = new File(UserConfig.basePath + filepath+"/"+pathName);
		logger.info("获得所有参会人员id:getAllmember:"+UserConfig.basePath + filepath+"/"+pathName);
		if (file.exists()) {
			try {
				BufferedReader reader;
				reader = new BufferedReader(new FileReader(file));
				String line;
				ArrayList<String> arrayList = new ArrayList<String>();
				while (reader.ready()) {
					logger.info("获得所有参会人员idgetAllmember");
					line = reader.readLine();
					arrayList.add(line);
				}
				ftpUtil.close();
				return arrayList;
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		return null;

	}

	/*
	 * 退出 path:相对路径加文件
	 */
	public static boolean memeberExit(String path, Integer peoEmployeeId) {
		logger.info("退出会议处理");
		boolean flags = false;
		if (path != null && path != "" && peoEmployeeId != null) {
			FTPUtil ftpUtil = new FTPUtil();
			String filepath = path.substring(0, path.lastIndexOf("/"));
			ftpUtil.retrieveFile(path, UserConfig.basePath + filepath);
			logger.info(UserConfig.basePath + filepath);
			File file = new File(UserConfig.basePath + path);
			if (file.exists()) {
				try {
					BufferedReader reader = new BufferedReader(new FileReader(file));
					String line;
					ArrayList<String> arrayList = new ArrayList<String>();
					while (reader.ready()) {
						line = reader.readLine();
						if (Integer.parseInt(line) == peoEmployeeId) {
							flags = true;
						} else {
							arrayList.add(line);
						}
					}
					reader.close();
					if (file.delete()) {
						file = new File(UserConfig.basePath + path);
						file.createNewFile();
					}
					BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
					if (arrayList.size() > 0) {
						for (String string : arrayList) {
							bufferedWriter.write(string);
							bufferedWriter.newLine();
						}
					} else {
						bufferedWriter.write(" ");
					}
					bufferedWriter.close();
					ftpUtil.deleteFile(path);
					ftpUtil.upload(new FileInputStream(file), path);
					ftpUtil.close();
				} catch (Exception e) {
					logger.warn("memeberExit异常" + e.getMessage());
				}
			}
		}
		return flags;
	}

	/**
	 * //判断当前id是否已加入到会议成员中
	 * 
	 * @param path
	 * @param peoEmployeeId
	 * @return
	 */
	public static boolean memeberIsIn(String path, Integer peoEmployeeId) {
		System.out.println(path + "---------" + peoEmployeeId);
		if (path != null && path != "" && peoEmployeeId != null) {
			FTPUtil ftpUtil = new FTPUtil();
			String filepath = path.substring(0, path.lastIndexOf("/"));
			ftpUtil.retrieveFile(path, UserConfig.basePath + filepath);
			File file = new File(UserConfig.basePath + path);
			if (file.exists()) {
				try {
					BufferedReader reader = new BufferedReader(new FileReader(file));
					String line;
					line = reader.readLine();
					while (line != null && line.length() > 0) {
						logger.info("line" + line + "------ID" + peoEmployeeId);
						if (Integer.parseInt(line) == peoEmployeeId) {
							return true;
						}
						line = reader.readLine();
					}

				} catch (Exception e) {
					logger.warn("memeberIsIn异常" + e.getMessage());
				}

			} else {
				logger.error("名单文件不存在");
				System.out.println("名单文件不存在");
			}
		}
		return false;
	}

	/**
	 * 加入成员id到名单表中
	 * 
	 * @param path
	 * @param employeeId
	 * @param booknum
	 * @return
	 */
	public static boolean jionMemeber(String path, Integer employeeId) {
		FTPUtil ftpUtil = new FTPUtil();
		String filepath = path.substring(0, path.lastIndexOf("/"));
		ftpUtil.retrieveFile(path, UserConfig.basePath + filepath);
		if (!TextUtil.isEmpty(path)) {
			File file = new File(UserConfig.basePath + path);
			if (file.exists()) {
				try {
					BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
					String outs = employeeId + "\r\n";
					logger.info("写入人员名单表：" + outs);
					bufferedWriter.write(outs);
					bufferedWriter.close();
					ftpUtil.deleteFile(path);
					ftpUtil.upload(new FileInputStream(file), path);
					return true;
				} catch (IOException e) {
					logger.warn("jionMemeber人员名单表不存在" + e.getMessage());
					e.printStackTrace();
				}
			}
		}
		return false;
	}

	/**
	 * 创建参会人员名单表
	 * 
	 * @param employeeId
	 * @param day
	 * @return
	 */
	public static String createNameTable(String employeeId, String day) {
		FTPUtil ftpUtil = new FTPUtil();
		day = day.split(" ")[0];
		System.out.println(employeeId + "___" + day);
		logger.info("进入createNameTable");
		if (!TextUtil.isEmpty(employeeId) && !TextUtil.isEmpty(day)) {
			System.out.println("createNameTable进入b");
			File file = new File(UserConfig.basePath);
			if (!file.exists()) {
				file.mkdir();
				logger.info("创建1");
			}
			file = new File(UserConfig.basePath + employeeId + day);
			if (!file.exists()) {
				file.mkdir();
				logger.info("创建2");
			}
			ftpUtil.mkDir(FTPConfig.bookPath + employeeId + day);
			file = new File(UserConfig.basePath + "/member.txt");
			if (file.exists()) {
				file.delete();
			}
			try {
				file.createNewFile();/**/
				ftpUtil.upload(new FileInputStream(file), FTPConfig.bookPath + employeeId + day + "/member.txt");
				file.delete();
				logger.info("路径：：：：" + FTPConfig.bookPath + employeeId + day + "/member.txt");
				ftpUtil.close();
				return FTPConfig.bookPath + employeeId + day + "/member.txt";
			} catch (IOException e) {
				ftpUtil.close();
				logger.warn("createNameTable创建会议人员名单表失败" + e.getMessage());
			}
		}
		return "";
	}
}
