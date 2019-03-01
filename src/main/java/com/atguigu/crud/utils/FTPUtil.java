package com.atguigu.crud.utils;

import java.io.Console;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletOutputStream;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.atguigu.crud.common.FTPConfig;

/**
 * 
 * @author Fanqiang
 * @typeName FtpUtil
 * @date 2017年6月12日;上午8:02:55
 */
public class FTPUtil {
	protected static final Logger logger = LoggerFactory.getLogger(FTPUtil.class);
	private FTPClient ftpClient = null;
	private String server;
	private int port;
	private String userName;
	private String userPassword;

	public FTPUtil() {
		this.server = FTPConfig.serverurl;
		this.port = FTPConfig.port;
		this.userName = FTPConfig.userName;
		this.userPassword = FTPConfig.userPassword;
		open();
	}

	/*
	 * public FTPUtil(String server, int port, String userName, String userPassword)
	 * { this.server = server; this.port = port; this.userName = userName;
	 * this.userPassword = userPassword; }
	 */
	/**
	 * 连接服务器
	 * 
	 * @return 连接成功与否 true:成功， false:失败
	 */
	public boolean open() {
		if (ftpClient != null && ftpClient.isConnected()) {
			return true;
		}
		try {
			ftpClient = new FTPClient();
			// 连接
			ftpClient.connect(this.server, this.port);
			ftpClient.login(this.userName, this.userPassword);
			/*if (FTPReply.isPositiveCompletion(ftpClient.sendCommand("OPTS UTF8", "ON"))) {
				ftpClient.setControlEncoding("UTF-8");
			}
			else{
				ftpClient.setControlEncoding("GBK");
			}
*/
			setFtpClient(ftpClient);
			// 检测连接是否成功
			int reply = ftpClient.getReplyCode();
			if (!FTPReply.isPositiveCompletion(reply)) {
				this.close();
				System.err.println("FTP server refused connection.");
				System.exit(1);
			}
			System.out.println("open FTP success:" + this.server + ";port:" + this.port + ";name:" + this.userName
					+ ";pwd:" + this.userPassword);
			ftpClient.setFileType(FTP.BINARY_FILE_TYPE); // 设置上传模式.binally or ascii
			logger.info("FTP连接成功");
			return true;
		} catch (Exception ex) {
			this.close();
			ex.printStackTrace();
			logger.info("FTP连接失败");
			return false;
		}
	}

	/**
	 * 选择上传的目录，没有创建目录
	 * 
	 * @param ftpPath
	 *            需要上传、创建的目录
	 * @return
	 */
	public boolean mkDir(String ftpPath) {
		if (!ftpClient.isConnected()) {
			return false;
		}
		try {
			// 将路径中的斜杠统一
			char[] chars = ftpPath.toCharArray();
			StringBuffer sbStr = new StringBuffer(256);
			for (int i = 0; i < chars.length; i++) {
				if ('\\' == chars[i]) {
					sbStr.append('/');
				} else {
					sbStr.append(chars[i]);
				}
			}
			ftpPath = sbStr.toString();
			System.out.println("ftpPath:" + ftpPath);
			if (ftpPath.indexOf('/') == -1) {
				// 只有一层目录
				ftpClient.makeDirectory(new String(ftpPath.getBytes(), "iso-8859-1"));
				ftpClient.changeWorkingDirectory(new String(ftpPath.getBytes(), "iso-8859-1"));
			} else {
				// 多层目录循环创建
				String[] paths = ftpPath.split("/");
				for (int i = 0; i < paths.length; i++) {
					ftpClient.makeDirectory(new String(paths[i].getBytes(), "iso-8859-1"));
					ftpClient.changeWorkingDirectory(new String(paths[i].getBytes(), "iso-8859-1"));
				}
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 上传文件到FTP服务器 文件字节流
	 * 
	 * @param fis
	 *            上传的文件字节流
	 * @param ftpFileName
	 *            上传到服务器的文件名      eg:people/a.txt    FTPConfig.peopleImagePath+"a.txt"
	 * @param ftpDirectory
	 *            上传到FTP的目录
	 * @return
	 */
	public boolean upload(InputStream fis, String ftpFileName) {
		if (!ftpClient.isConnected()) {
			return false;
		}
		boolean flag = false;
		if (ftpClient != null) {
			try {
				String path = ftpFileName.substring(0, ftpFileName.lastIndexOf("/"));
				String filename = ftpFileName.substring(ftpFileName.lastIndexOf("/")+1, ftpFileName.length());
				logger.info("分割路径：path：/" + path + "filename：" + filename);
				ftpClient.changeWorkingDirectory("/" + path);
				String[] doCommandAsStrings = ftpClient.doCommandAsStrings("pwd", "");
				for (String strings : doCommandAsStrings) {
					System.out.println(strings);
				}
				ftpClient.enterLocalPassiveMode();
				// ftpClient.doCommand("touch", "aa.txt");
				ftpClient.setBufferSize(100000);
				//ftpClient.setControlEncoding("UTF-8");
				// 设置文件类型（二进制）
				ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
				// 上传
				flag = ftpClient.storeFile(filename, fis);
				if(flag) {
					logger.info("上传成功！！！！！！");
				}
			} catch (Exception e) {
				this.close();
				e.printStackTrace();
				return false;
			} finally {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println("上传文件成功，本地文件名： " + ftpFileName + "，上传到目录：/" + ftpFileName);
		return flag;
	}

	/**
	 * 关闭链接
	 */
	public void close() {
		try {
			if (ftpClient != null && ftpClient.isConnected()) {
				ftpClient.disconnect();
			}
			System.out.println("成功关闭连接，服务器ip:" + this.server + ", 端口:" + this.port);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public FTPClient getFtpClient() {
		return ftpClient;
	}

	public void setFtpClient(FTPClient ftpClient) {
		this.ftpClient = ftpClient;
	}

	/**
	 * 删除FTP服务器文件
	 * 
	 * @param serverName
	 *            服务器名称
	 * @param remotePath
	 *            当前访问目录
	 * @param fileName
	 *            文件存储名称
	 * @return <b>true</b>：删除成功 <br/>
	 *         <b>false</b>：删除失败
	 */
	public boolean deleteFile(String pathFileName) {
		String path = pathFileName.substring(0, pathFileName.lastIndexOf("/"));
		String filename = pathFileName.substring(pathFileName.lastIndexOf("/") + 1, pathFileName.length());

		boolean result = false;
		try {
			ftpClient.changeWorkingDirectory("/" + path);
			// 删除文件
			result = ftpClient.deleteFile(filename);
			logger.info("删除文件成功");
		} catch (IOException e) {
			logger.error("删除FTP服务器上的 文件异常" + e.getMessage());
			throw new RuntimeException("删除FTP服务器上的 文件异常", e);
		}
		return result;
	}

	/**
	 * Description: 从FTP服务器下载文件
	 * 
	 * @Version1.0 Jul 27, 2008 5:32:36 PM by 崔红保（cuihongbao@d-heaven.com）创建
	 * 
	 * @param remotePath
	 *            FTP服务器上的相对路径
	 * @param fileName
	 *            要下载的文件名
	 * @param localPath
	 *            下载后保存到本地的路径
	 * @return		people/11join.txt", "D:/room/room-manages
	 */
	public boolean retrieveFile(String pathFileName, String localPath) {
		String path = pathFileName.substring(0, pathFileName.lastIndexOf("/"));
		String filename = pathFileName.substring(pathFileName.lastIndexOf("/") + 1, pathFileName.length());
		// 初始表示下载失败
		boolean success = false;
		File file = new File(localPath);
		if (!file.exists()) {
			file.mkdirs();
		}
		try {
			System.out.println("工作路径：："+path );
			ftpClient.changeWorkingDirectory("/" + path);
			// 列出该目录下所有文件
			FTPFile[] fs = ftpClient.listFiles();
			// 遍历所有文件，找到指定的文件
			for (FTPFile ff : fs) {
				System.out.println("遍历文件" + ff.getName() + "------" + filename);
				if (ff.getName().trim().equals(filename.trim())) {
					System.out.println("成功进入localPath ：" + localPath + "/" + ff.getName());
					// 根据绝对路径初始化文件
					File localFile = new File(localPath + "/" + ff.getName());
					//System.out.println(1);
					// 输出流
					OutputStream is = new FileOutputStream(localFile);
					// 下载文件
					success = ftpClient.retrieveFile(ff.getName(), is);
					//System.out.println(2);
					if (success) {
						logger.info("从FTP服务器下载文件状态成功");
					} else {
						logger.info("从FTP服务器下载文件状态失败");
					}
					is.close();
				}
			}

		} catch (IOException e) {
			logger.error("从FTP服务器下载文件异常"+e.getMessage());
		}
		return success;
	}

	/**
	 * 下载FTP服务器文件至本地<br/>
	 * 操作完成后需调用logout方法与服务器断开连接
	 * 
	 * @param serverName
	 *            服务器名称
	 * @param remotePath
	 *            下载文件存储路径
	 * @param fileName
	 *            下载文件存储名称
	 * @return <b>InputStream</b>：文件输入流
	 */
	public InputStream retrieveFileForStream(String fileName) {
		InputStream is = null;
		try {
			boolean result = false;
			// 判断服务器是否连接成功
			if (result) {
				// 获取文件输入流
				is = ftpClient.retrieveFileStream(fileName);
			}
		} catch (IOException e) {
			logger.error("从FTP下载文件到本地异常" + e.getMessage());
			throw new RuntimeException("从FTP下载文件到本地异常", e);
		}
		return is;
	}

	/**
	 * 检测FTP服务器文件是否存在
	 * 
	 * @param serverName
	 *            服务器名称
	 * @param remotePath
	 *            检测文件存储路径
	 * @param fileName
	 *            检测文件存储名称
	 * @return <b>true</b>：文件存在 <br/>
	 *         <b>false</b>：文件不存在
	 */
	public boolean checkFile(String pathFileName) {
		boolean result = false;
		try {
			// 默认文件不存在
			result = false;
			String path = pathFileName.substring(0, pathFileName.lastIndexOf("/"));
			String filename = pathFileName.substring(pathFileName.lastIndexOf("/") + 1, pathFileName.length());
			ftpClient.changeWorkingDirectory(path);// 切换ftp目录
			// 获取文件操作目录下所有文件名称
			String[] remoteNames = ftpClient.listNames();
			// 循环比对文件名称，判断是否含有当前要下载的文件名
			for (String remoteName : remoteNames) {
				System.out.println(remoteName);
				if (filename.equals(remoteName)) {
					result = true;
				}
			}
		} catch (IOException e) {
			logger.error("检查FTP文件是否存在异常" + e.getMessage());
			throw new RuntimeException("检查FTP文件是否存在异常", e);
		}
		return result;
	}

	public boolean retrieveFileToWeb(OutputStream outputStream, String pathFileName) {
		try {
		/*	if (FTPReply.isPositiveCompletion(ftpClient.sendCommand("OPTS UTF8", "ON"))) {
				ftpClient.setControlEncoding("UTF-8");// 设置字符编码;
			}*/
			String path = pathFileName.substring(0, pathFileName.lastIndexOf("/"));
			String filename = pathFileName.substring(pathFileName.lastIndexOf("/") + 1, pathFileName.length());

			 ftpClient.setControlEncoding("UTF-8");//设置字符编码
	            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);//设置传输方式为二进制
	            ftpClient.enterLocalPassiveMode();//开启被动模式，服务器开放端口给客户端用
		
			ftpClient.changeWorkingDirectory(path);// 切换ftp目录
			
			FTPFile[] ftpFiles = ftpClient.listFiles();// 列出目录及文件
			for (FTPFile f : ftpFiles) {// 遍历文件
				if (filename.equalsIgnoreCase(f.getName())) {// 把文件写到本地
					// File localFile = new File(localPath+File.separator+f.getName());
					// OutputStream output=new FileOutputStream(localFile);
					String[] doCommandAsStrings = ftpClient.doCommandAsStrings("pwd", "");
					for (String strings : doCommandAsStrings) {
						System.out.println("路径："+strings);
					}
					logger.info("开始传输会议文件");
					if(ftpClient.retrieveFile(f.getName(), outputStream)) {
						System.out.println("成功！");
						outputStream.close();
						return true;
					}
					outputStream.close();
					
				}
			}
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} // 设置传输方式为二进制
		return false;
	}

}
