<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<!-- 以/开始的，找资源，以服务器的路径为基准 -->
<script type="text/javascript"
	src="${APP_PATH }/static/js/jquery-1.11.3.min.js"></script>
	
<link href="${APP_PATH }/static/css/show_list.css" rel="stylesheet">
<link href="${APP_PATH }/static/css/my_show_list.css" rel="stylesheet">

<script type="text/javascript"
	src="${APP_PATH }/static/js/util.js"></script>
	
<link
	href="${APP_PATH }/static/bootstrap-3.3.5-dist/css/bootstrap.min.css"
	rel="stylesheet">
<script type="text/javascript"
	src="${APP_PATH }/static/bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>

<link
	href="${APP_PATH }/static/pinglun/index.css"
	rel="stylesheet">
<script src="${APP_PATH }/static/pinglun/jquery.comment.js" ></script>

<link rel="stylesheet" href="${APP_PATH }/static/jquery-ui-1.11.4.custom/jquery-ui.css">
<link rel="stylesheet" href="http://jqueryui.com/resources/demos/style.css">
<script src="${APP_PATH }/static/jquery-ui-1.11.4.custom/jquery-ui.js"></script>

<script src="${APP_PATH }/static/js/util.js" ></script>


 <style>
  #sortable { list-style-type: none; margin: 0; padding: 0; width: 60%; }
  #sortable li { margin: 0 3px 3px 3px; padding: 0.4em; padding-left: 1.5em; font-size: 1.4em; height: 18px; }
  #sortable li span { position: absolute; margin-left: -1.3em; }
  #hd_c_left_btn_li{background: url(../room-manages/static/images/bg.png) no-repeat -370px -155px;}
  </style>
  
 	<script>

  $(function() {
	    $( "#sortable" ).sortable();
	    $( "#sortable" ).disableSelection();
	  });
  
  </script>
  <style type="text/css">
	.ui-accordion .ui-accordion-content{
	    padding: 5px 5px 5px 5px;
	}
	#file_add_modal_btn{
		margin-bottom: 10px;
	}
	#searchlist{
		margin-bottom: 10px;
	}
</style>
</head>
<body style="position:relative;">
<!-- 申请参加会议模态框 -->
	<div class="modal fade" id="bookjoinAddModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">完善信息</h4>
				</div>
				<!-- 表单体   	name值和bean中一致-->
				<div class="modal-body">
					<form class="form-horizontal">
						
						<div class="form-group">
							<label class="col-sm-2 control-label">请输入申请信息</label>
							<div class="col-sm-10">
								<input type="textarea" name="other" class="form-control"
									id="book_join_other" placeholder="当负责人审核时，可看见此信息">
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
					<button type="button" class="btn btn-primary"
						id="book_join_btn">上传</button>
				</div>
			</div>
		</div>
	</div>
<!-- 添加预定记录模态框 -->
	<div class="modal fade" id="bookFileAddModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">添加预定</h4>
				</div>
				<!-- 表单体   	name值和bean中一致-->
				<div class="modal-body">
					<form class="form-horizontal">
						<div class="form-group">
							<label class="col-sm-2 control-label">上传文件</label>
							<div class="col-sm-10">
								<input type = "file" name= 'file'  id=""/>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">输入文件名</label>
							<div class="col-sm-10">
								<input type="textarea" name="other" class="form-control"
									id="book_file_title" placeholder="此项若为空，则使用默认文件名">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">输入文件备注信息</label>
							<div class="col-sm-10">
								<input type="textarea" name="other" class="form-control"
									id="book_file_other" placeholder="在此处填写其它相关说明信息">
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
					<button type="button" class="btn btn-primary"
						id="book_add_save_btn">上传</button>
				</div>
			</div>
		</div>
	</div>
<div class="container">
<div class="rol">
	<div style="height: 50px">dd</div>
</div>
	<div class="rol">
		<div class="col-md-8">
			<div class="rol" id="searchlist">
				<div class="col-md-11 input-group input-group-sm">
				  <span class="input-group-addon" id="sizing-addon3">主题</span>
				  <input id="search_theme" type="text" class="form-control" placeholder="Username" aria-describedby="sizing-addon3">
				 
				 <span class="input-group-addon" id="sizing-addon3" >时间</span>
				  <input id="search_date" type="date" class="form-control" placeholder="Username" aria-describedby="sizing-addon3">
				  
				  <span class="input-group-addon" id="sizing-addon3">负责人</span>
					<input id="search_people" type="text" class="form-control" placeholder="Username" aria-describedby="sizing-addon3">
				  	
				 <span class="input-group-addon" id="sizing-addon3">会议室</span>
				  <input id="search_room" type="text" class="form-control" placeholder="Username" aria-describedby="sizing-addon3">
				</div>	
				<div class="col-md-1 col-md-offset-10">	
				 	<button id="search_btn" type="button" class="btn btn-default" style="margin-bottom: 10px">搜索</button>
				 </div>
			</div>
		
			<div class="rol" style="height: 15px;">
				<HR style="border:3 double #987cb9" width="100%" color=#000000 SIZE=100>
			</div>
			<div class="rol">
				<div id="list">
					<ul id="lists">
						
					</ul>
				</div>
				<!-- 分页信息 -->
				<div class="row">
					<!-- 文字信息 -->
					<div class="col-md-6" id="page_info_area"></div>
					<!-- 分页条 -->
					<div class="col-md-6" id="page_nav_area"></div>
				</div>
			</div>
		</div>
		<div class="col-md-4" id="ping">
		<div>
			<div class="row">
				<div id="menu_right_up" class="col-md-6">
				</div>
				<div class="col-md-6">
					<a id="meeting_info" type="button" class="btn btn-default" data-container="body" data-toggle="hover hover" data-placement="bottom" ">
					 会议公告
					</a>		
				</div>
			</div>
			<div id="accordion_parent">
					
				
			</div>
			<div class="containerss" style="position:absolute; height:700px; overflow:scroll ">
				<div class="commentbox">
					<textarea cols="80" rows="50" placeholder="来说几句吧......" class="mytextarea" id="content"></textarea>
					<div class="btn btn-info pull-right" id="comment">评论</div>
				</div>
				<div class="comment-list">
				</div>
			</div>
		</div>
	</div>
	</div>
</div>
	 <script type="text/javascript">
	//获取系统当前时间
	var first =0;	//保存第一条预定的序列号-->右边功能显示对应的预定序列号
	var aindexlist=-1; //保存进入右边菜单的左边的序号
	var bookdata; //保存预定数据
		//获得用户本地当前时间
		function getDate(){
			var nowDate = new Date();
			var year = nowDate.getFullYear();
			var month = filterNum(nowDate.getMonth()+1);
			var day = filterNum(nowDate.getDate());
			var hours = filterNum(nowDate.getHours());
			var min = filterNum(nowDate.getMinutes());
			var seconds = filterNum(nowDate.getSeconds());
			return year+"-"+month+"-"+day+" "+hours+":"+min+":"+seconds;
		}
		function filterNum(num){
			if(num < 10){
				return "0"+num;
			}else{
				return num;
			}
		}
		
		var date_id=getDate();
		init_book(1);
		//获取预定数据
		function init_book(pn) {
			console.log("开始获取预定数据");
			$.ajax({
				url : "${APP_PATH}/f/show/getBook",
				data : "pn=" + pn,
				async: false,
				type : "GET",
				success : function(result) {
					if (result.code == 100) {
						//alert("5555");
						console.log("获取预定数据成功,book:");
						console.log(result);
						bookdata=result;
						first=	result.extend.pageInfo.list[0].serialNum;
						//解析数据
						ex_book_data(result);
						//2、解析显示分页信息
						build_page_info(result);
						//3、解析显示分条数据
						build_page_nav(result);
								
						if(result.extend.pageInfo.pageSize>0){
							addreply(first,1);
						}
					} else {
						console.log("已经预定数据失败");
						var p = result.extend.path;
						// alert(p);
						window.location.href = "${APP_PATH}" + p;
						ex_book_data(result);
					}
				}
			});
		}
		
		 /* 解析弹框数据 *//* 弹出框初始化 */
		 function built_alert(numa) {
			 console.log("built_alert:"+numa);
			 console.log(bookdata);		
			 var other =bookdata.extend.pageInfo.list[numa].other;
			 $("#meeting_info").popover({
	 			  html : true,    
	 			        title: "公告："+other,  
	 			        content: function() { 	 
	 			          return "内容："+other; 
	 			}
	 		  });
		 }
		//解析数据
		function ex_book_data(result) {	
			//首先清空数据
			$("#lists").empty();
			var ui = document.getElementById("lists");
			if(result.extend.pageInfo.pageSize>0){
				var list = result.extend.pageInfo.list;

				//alert("d"+list[0].serialNum);
				$.each(list,function(index,item){
					var sub1 = "<div class='hd_c_left_thumb'> "+	
					"<a href='#' onclick='addreply("+item.serialNum+","+index+")' target='_Self'>"+
							"<img src='/myimg/people/1.png' />"+
					"</a> </div>";
					var sub21 ="<div class='hd_c_left_title b'>"+
					"<a href='#' onclick='addreply("+item.serialNum+","+index+")' target='_Self'>会议主题："+
							item.preTheme+"</a></div>";
					var sub22="<div class='hd_c_left_time'>"+
					"<span class='black'>会议时间：</span>"+getMyDate(item.preDay)+" "+getMyhoursNoSecond(item.preStartTime)+" 至"+
					getMyDate(item.preDay)+" "+getMyhoursNoSecond(item.preEndTime)+"</div>";
					var sub23="<div class='hd_c_left_author'>"+
					"<span class='black'>负责人："+item.peopleInfo.peoEmployeeName+"</span></div>";
					var sub24="<div class='hd_c_left_count'>会议室："+item.preRoomNum+"&nbsp;&nbsp;&nbsp;"+
					"参加人数（"+item.preJion+"）"+"</div>";
					var sub2 = "<div class='hd_c_left_infor'>"+sub21+sub22+sub23+sub24+"<div class='hd_c_left_school'></div></div>";
					if(result.extend.isIn[index]==1){
						var sub3 = "<div class='hd_c_left_btn' id='indexlist"+index+"' isin='1' applyState='"+item.applyState+"'><ul>"+
						"<li><a class='i4' href='#'>已参加</a></li></ul></div>";
					}else{
						var sub3 = "<div class='hd_c_left_btn' id='indexlist"+index+"' isin='0' applyState='"+item.applyState+"'><ul>"+
						"<li id='hd_c_left_btn_li'><a class='i4' href='#'>参加会议</a></li></ul></div>";
					}
					var inhtml = "<li>"+sub1+sub2+sub3+"</li>";
					ui.innerHTML =ui.innerHTML+inhtml;
				});
			}else{
				var ss = "<span>暂无预定会议室数据</span>";
				ui.innerHTML =ui.innerHTML+ss;
			}
			
		}
		/* init二级列表 */
		function initaccordion() {
			var inti_html ="<div id='accordion'><button id='menu_file_manage'  type='button'  class='btn' style='width: 100%'>会议文件管理</button>"+
			"<div id='menu_file_manage_list'><button id=file_add_modal_btn type='button' class='btn btn-primary'>上传会议文件</button>"+
			"<div id='downlist'><div id='list-group-id' class='list-group'></div></div></div></div></div>";
			var indd = document.getElementById("accordion_parent");
			indd.innerHTML=inti_html;
			 $( "#accordion" ).accordion({
		    	 heightStyle: "content",
		    	 collapsible: true,
		    	 active:999
		    });
		}
		//右面功能页面处理
		function addreply(num,indexlist) {
			built_alert(indexlist);
			console.log(num+"::::::::"+indexlist);
			aindexlist =indexlist;
			/* 根据是否加入，决定布局 */
			var cont="#indexlist"+indexlist;
			var isinv=$(cont).attr("isin");
			var applyState=$(".hd_c_left_btn").attr("applyState");
			var menu_right_to=document.getElementById("menu_right_up");
			var menu_file_manage=document.getElementById("menu_file_manage");
			console.log(isinv+":::"+applyState);
			
			if(isinv==1||applyState==2){
				menu_right_to.innerHTML = "<button type='button' id='jion_btn' state='3' class='btn btn-info'>退出会议</button>";
			}
			else if(isinv==0&&applyState==1){
				menu_right_to.innerHTML = "<button type='button' id='jion_btn' state='2' class='btn btn-warning' disabled='disabled'>审核中</button>";
			}else{
				menu_right_to.innerHTML = "<button type='button' id='jion_btn' state='1' class='btn btn-primary'>参加会议</button>";
			}
			initaccordion();
			if(isinv==0){
				console.log("aaaaa");
				$("#menu_file_manage").attr("disabled","disabled");
			}else{
				console.log("aaaab");
				$("#menu_file_manage").removeAttr("disabled");
				/* 加载会议文件 */
			/* 会议文件list */
			$("#list-group-id").empty();
			$.ajax({
				url:"${APP_PATH}/f/show/getFilelist/"+num,
				type:"GET",
				success : function(result) {
					if(result.code==100){
						console.log("会议文件信息成功：");
						console.log(result);
						/* 解析会议文件数据 */
						ex_file_list_data(result);
					}else{
						console.log("会议文件信息失败：");
						var el = document.getElementById("list-group-id");
						var html = "<span>当前会议无文件</span>"
						el.innerHTML = el.innerHTML +html;
					}
					}
				});
			
			
			}
			
			$(".comment-list").empty();
			first = num;
			/* 评论处理 */
			$.ajax({
				url:"${APP_PATH}/f/show/replylist/"+num,
				type:"GET",
				async: false,
				success : function(result) {
					if (result.code == 100) {
						//alert("5555");
						console.log("评论列表数据成功");
						console.log(result);
						//解析数据
						var arr =ex_list_data(result);
						/* var arr = [
							{id:1,img:"./images/img.jpg",replyName:"帅大叔",beReplyName:"匿名",content:"同学聚会，看到当年追我的屌丝开着宝马车带着他老婆来了，他老婆是我隔壁宿舍的同班同学，心里后悔极了。",time:"2017-10-17 11:42:53",address:"深圳",osname:"",browse:"谷歌",replyBody:[]},
							{id:2,img:"./images/img.jpg",replyName:"匿名",beReplyName:"",content:"到菜市场买菜，看到一个孩子在看摊，我问：“一只鸡多少钱？” 那孩子回答：“23。” 我又问：“两只鸡多少钱？” 孩子愣了一下，一时间没算过来，急中生智大吼一声：“一次只能买一只！”",time:"2017-10-17 11:42:53",address:"深圳",osname:"",browse:"谷歌",replyBody:[{id:3,img:"",replyName:"帅大叔",beReplyName:"匿名",content:"来啊，我们一起吃鸡",time:"2017-10-17 11:42:53",address:"",osname:"",browse:"谷歌"}]},
							{id:3,img:"./images/img.jpg",replyName:"帅大叔",beReplyName:"匿名",content:"同学聚会，看到当年追我的屌丝开着宝马车带着他老婆来了，他老婆是我隔壁宿舍的同班同学，心里后悔极了。",time:"2017-10-17 11:42:53",address:"深圳",osname:"win10",browse:"谷歌",replyBody:[]}
						]; */
						loadData(arr,num);
					} else {
						console.log("评论列表数据失败");
						loadData("",num);
					}
				}
			});
			
				
		}
		/* 申请参见会议处理 */
		$(document).on("click","#jion_btn",function(){
			var state=$(this).attr("state");
			if(state==1)
			{
				$("#bookjoinAddModal form")[0].reset();
				$("#bookjoinAddModal").modal({
					backdrop : 'static'
				});
				$("#book_join_btn").attr("first",first);
			}else if(state==3){
				if(confirm("确认退出会议？")){
					$.ajax({
						url:"${APP_PATH}/f/show/exit",
						type:"GET",
						data:"exit_data="+first,
						success:function(result){
							if(result.code==100){
								alert("删除成功");
							}else {
								alert("删除失败");
							}
							}
						});
				}
				
			}
		});
		/* 申请参见会议模态框按钮 */
		$("#book_join_btn").click(function() {
			$.ajax({
				url:"${APP_PATH}/f/show/join",
				type:"GET",
				data:"join_data="+first,
				success:function(result){
					if(result.code==100){
						$("#bookFileAddModal").modal('hide');
						var menu_right_to=document.getElementById("menu_right_up");
						menu_right_to.innerHTML = "<button type='button' id='jion_btn' class='btn btn-warning' disabled='disabled'>审核中</button>";
					}else {
						alert("申请错误");
					}
				}
			});	
		});
		/* 解析会议文件数据 */
		function ex_file_list_data(result){
			var el = document.getElementById("list-group-id");
			var list = result.extend.bookFileList;
			$.each(list,function(index,item){
				var temppath = item.fileSavaPath+"";
				temppath =temppath.substring(21,temppath.length);
				var html ="<a href='#' class='list-group-item'><p class='list-group-item-text'>上传者："
				+item.fileOwnerName+"<br>文件名："+item.fileTitle+"<button type='button' datapath = "+item.fileSavaPath+" id='downbtn' class='btn btn-default'"+
				" data-toggle='tooltip' data-placement='top title='"+item.fileOther+"'>"+
				"<span class='glyphicon glyphicon-download-alt'>下载</span></button></p></a>";
				el.innerHTML = el.innerHTML +html;
				});
			/* <p class="list-group-item-text">
			您将通过网页进行免费域名注册。<button type="button" class="btn btn-default" data-toggle="tooltip" data-placement="top" title="Tooltip on left"><span class="glyphicon glyphicon-download-alt">下载</span></button>
		</p> */
					
		}
		
		/* 下载文件 */
		$(document).on("click","#downbtn",function() {
			var path =$(this).attr("datapath");/* D:\room\room-manages\ */
			var sp=path.split("/");
			path = sp[0]+"_"+sp[1]+"_"+sp[2]+"_"+sp[3];
			alert(path);
			$.ajax({
				url:"${APP_PATH}/f/show/down",
				type:"POST",
				data:"path="+path,
			});	
		});
	
		/* 解析评论数据 */
		function ex_list_data(result){
			var arrs = [];
			var plys = result.extend.plys;
			$.each(plys,function(index,item){
				var aply= new Array();
				aply["id"]=index;
				aply["img"]=item.plyPeoPicturePath;
				aply["replyId"]=item.plyPeoId;
				aply["numId"]=item.plyId;
				aply["replyName"]=item.plyPeoName;
				aply["beReplyName"]="";
				aply["content"]=item.plyMessage;
				aply["time"]=getMyDateAndHours(item.plyTime);
				aply["address"]="";
				aply["osname"]="";
				aply["browse"]="";
				if(item.replys.length!=0){
					var replya=[];
					$.each(item.replys,function(indexs,items){
						var replys ={id:indexs,img:"",replyId:items.replyPeoId,replyName:items.replyPeoIdName,beReplyName:items.replyToPlyPeoName,content:items.replyMessage,time:getMyDateAndHours(items.replytTime),address:"",osname:"",browse:""};
						replya[indexs]=replys;
					});
					aply["replyBody"]=replya;
				}else{
					aply["replyBody"]="";
				}
				arrs[index*1]=aply;
			});
			//alert(arrs.toString);
			console.log(arrs);
			return arrs;
		}
	
		//调用留言表装载器
		function loadData(arr,booknum){
			
			console.log("user:"+  "${ sessionScope.currentUser}");
			$(".comment-list").addCommentList({data:arr,add:""},"${ sessionScope.currentUser}","${APP_PATH}");
			$("#comment").click(function(){
				if($("#content").val()!=null&&$("#content").val()!=""){
					var temp ="${ sessionScope.currentUser.peoEmployeeId}";
					var mydata = temp+"_"+"${ sessionScope.currentUser.peoEmployeeName}_"+booknum+"_"+
							$("#content").val()+"_"+getDate()+"_${ sessionScope.currentUser.peoImagePath} ";
							
					//alert(temp+mydata); 
						$.ajax({
							url:"${APP_PATH}/f/show/addply",
							type:"GET",
							data:"mydata="+mydata,
							success : function(result) {
								console.log("保存留言"+result);
								if(result.code==100){
									var obj = new Object();
									obj.img="${ sessionScope.currentUser.peoImagePath}";
									obj.replyName="${ sessionScope.currentUser.peoEmployeeName}";
									obj.content=$("#content").val();
									obj.browse="";
									obj.osname="";
									obj.numId=result.extend.numid;
									obj.replyBody="";
									console.log(obj.content);
									//var user =${ sessionScope.currentUser};
									$(".comment-list").addCommentList({data:[],add:obj},"${ sessionScope.currentUser}","${APP_PATH}"); 
								}else{
									
									window.location.href="${APP_PATH}/f_login.jsp";
								}
							}
						}); 
			}
		});
	}
		
		
		/* 点击弹出文件上传模态框 */
		$(document).on("click","#file_add_modal_btn",function() {
			//reset_form("#bookFileAddModal form");
			$("#bookFileAddModal form")[0].reset();
			//ajax请求数据
			//getRoomInfo("#book_room_add_select");
			$("#book_add_save_btn").attr("book_id",first);
			//alert(first);
			//弹出
			$("#bookFileAddModal").modal({
				backdrop : 'static'
			});
		});
		/* 文件提交 */
		$("#book_add_save_btn").click(function() {
			var getpro=document.getElementById("book_file_title").value;
			var book_other=document.getElementById("book_file_other").value;
			var book_id = $(this).attr("book_id");
			var formData = new FormData($("#bookFileAddModal form")[0]);
			 $.ajax({
		            url:'${APP_PATH }/f/show/upload2/'+getpro+"_"+book_id+"_"+book_other,
		            type:'post',
		            data:formData,
		            //必须false才会自动加上正确的Content-Type
		            contentType: false,
		            //必须false才会避开jQuery对 formdata 的默认处理
		            //XMLHttpRequest会对 formdata 进行正确的处理
		            processData: false,
		            success:function(data){
		                console.log("上传会议文件成功："+data);
		                $("#bookFileAddModal").modal('hide');
		                $("#list-group-id").empty();
		                addreply(first,aindexlist);
		            },
		            error:function(data){
		            	console.log("上传会议文件,后台发生异常："+data);
		               alert("上传会议文件,后台发生异常");
		            },
		            cache:false,
		            async:true
		        }); 
		});
		
		/* 2、解析显示分页信息 */
		function build_page_info(result) {
			$("#page_info_area").empty();
			$("#page_info_area").append(
					"当前第" + result.extend.pageInfo.pageNum + "页，总共"
							+ result.extend.pageInfo.pages + "页，总共"
							+ result.extend.pageInfo.total + "记录数");
			totalRecord = result.extend.pageInfo.pages;
		}
		/* 3、解析显示分条数据 */
		function build_page_nav(result) {
			$("#page_nav_area").empty();

			var ul = $("<ul></ul>").addClass("pagination");
			var firstPageLi = $("<li></li>").append(
					$("<a></a>").append("首页").attr("href", "#"));
			var prePageLi = $("<li></li>").append(
					$("<a></a>").append("&laquo;").attr("href", "#"));
			if (result.extend.pageInfo.hasPreviousPage == false) {
				firstPageLi.addClass("disabled");
				prePageLi.addClass("disabled");
			} else {
				//添加翻页事件
				firstPageLi.click(function() {
					init_book(1);
				});
				prePageLi.click(function() {
					init_book(result.extend.pageInfo.pageNum - 1);
				});
			}
			var nextPageLi = $("<li></li>").append(
					$("<a></a>").append("&raquo;").attr("href", "#"));
			var lastPageLi = $("<li></li>").append(
					$("<a></a>").append("末页").attr("href", "#"));
			ul.append(firstPageLi).append(prePageLi);
			if (result.extend.pageInfo.hasNextPage == false) {
				nextPageLi.addClass("disabled");
				lastPageLi.addClass("disabled");
			} else {
				//分页事件
				nextPageLi.click(function() {
					init_book(result.extend.pageInfo.pageNum + 1);
				});
				lastPageLi.click(function() {
					init_book(result.extend.pageInfo.pages+1);
				});
			}

			$.each(result.extend.pageInfo.navigatepageNums, function(index,
					item) {
				var numLi = $("<li></li>").append($("<a></a>").append(item));
				if (result.extend.pageInfo.pageNum == item) {
					numLi.addClass("active");
				}
				numLi.click(function() {
					init_book(item);
				});
				ul.append(numLi);
			});
			ul.append(nextPageLi).append(lastPageLi);
			var navEle = $("<nav></nav>").append(ul).appendTo("#page_nav_area");
		}
		 
	 	/* 搜索栏事件 */
	 	$("#search_btn").click(function () {
	 		var theme=document.getElementById("search_theme").value;
	 		var date=document.getElementById("search_date").value;
	 		var people=document.getElementById("search_people").value;
	 		var room=document.getElementById("search_room").value;
	 		if(!(isEmpty(theme)&&isEmpty(date)&&isEmpty(people)&&isEmpty(room))){
	 			var data =theme+"_"+date+"_"+people+"_"+room+"_"+1;
		 		$.ajax({
						url:"${APP_PATH}/f/show/search",
						type:"GET",
						data:"mydata="+data,
						success : function(result) {
							if (result.code == 100) {
								//alert("5555");
								console.log("获取预定数据成功,book:");
								console.log(result);
								bookdata=result;
								first=	result.extend.pageInfo.list[0].serialNum;
								//解析数据
								ex_book_data(result);
								//2、解析显示分页信息
								build_page_info(result);
								//3、解析显示分条数据
								build_page_nav(result);
										
								if(result.extend.pageInfo.pageSize>0){
									addreply(first,1);
								}
							} else {
								console.log("已经预定数据失败");
								var p = result.extend.path;
								// alert(p);
								//window.location.href = "${APP_PATH}" + p;
								//ex_book_data(result);
						}}
		 		});
	 		}
		});
	 	/* 为空判断 */
	 	  function isEmpty(input) { 
			   return input == null || input == ''; 
			  }
	</script> 
</body>
</html>