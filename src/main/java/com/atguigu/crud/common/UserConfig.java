package com.atguigu.crud.common;
/*
 * 用户端配置
 */
public class UserConfig {
	public static boolean login=false;	//是否登陆
	public static int employeeId;   //登陆者id
	public static String basePath = "D:/room/room-manages/";
	public static String userImageLocalMappingBasePath="/myimg/people/";		//在本地图片位置
	public static String bookImageLocalMappingBasePath="/myimg/book/";
	/*	//在tomcat的服务器映射下，人员头像
	public static String peopleInfoMappingBasePath = "/myimg/people/";
	public static String bookpeopleInfoMappingBasePath = "/myimg/people/";*/
	
	
	public static int applyJoinDisboard =4 ;			//申请状态  会议被解散
	public static int applyJoinReject =3 ;			//申请状态拒绝
	public static int applyJoinAgree =2 ;			//申请状态同意
	public static int applyJoinUnDeal =1 ;			//申请状态默认，未处理
	
	public static int  joinRejuet = 4 ;				//被拒绝
	public static int  joinExit =3 ;				//退出
	public static int joinAgreed =2 ;				//被同意
	public static int joinApplying=1 ;					//个人  申请中
	
	public static int empIdUnUseState = 1;				//员工表未使用 
	public static int empIdUsedState  = 2;				//员工已使用（注册）
	
	
	public static String defaultPeopleAvatarPath = "/myimg/people/default/defaultAvatar.png"; 
}
