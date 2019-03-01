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


	<link href="${APP_PATH }/static/font-awesome/css/fontawesome.css" rel="stylesheet">
	<link href="${APP_PATH }/static/nav/bootsnav.css" rel="stylesheet">
	<link href="${APP_PATH }/static/nav/overwrite.css" rel="stylesheet">
            <link href="${APP_PATH }/static/nav/style.css" rel="stylesheet">
	<script src="${APP_PATH }/static/nav/bootsnav.js"></script>
	
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
	
	
			#total{
				padding: 0px;
			}
			#total>p{
				margin-bottom: 2px;
			}
			
			#head_img{
				width: auto;
				height: auto;
				max-width: 100%;
				max-height: 100%;
			}
</style>
</head>
<body style="position:relative;">

<!-- Start Navigation -->
    <nav class="navbar navbar-default bootsnav">
        <div class="container">  
            <!-- Start Atribute Navigation -->
            <div class="attr-nav">
                <ul>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" style="padding:15 15 15 15;" >
                            <i class="fa">
                            	<div class="badge" style="width: 50px; height: 50px; border-radius: 50%; border: 3px solid #eee; overflow: hidden;">  
							            <div style="text-align:center;">
							            	<img id="head_img" src="${APP_PATH }/static/images/bg-01.jpg"  /> 
							            </div> 	
							     </div> 
                            </i>	
                            <span class="badge" id="badgeNumSpan">3</span>
                        </a>
                        <ul class="dropdown-menu cart-list" id="nav_list">
                            <li>
 									 <h6><a href="#">申请入会列表</a></h6>
                            </li>
                           
                            <!-- <li class="total">
                               <div>
                               		<p>申请者：<span id="nav_name_span"></span>&nbsp;&nbsp;&nbsp;
                               			员工号：<span id="nav_empid_span"></span>
                               		</p>
                               		<p>
                               			申请信息：<span id="nav_applyinfo_span"></span>
                               			<button>拒绝</button><button>同意</button>
                               		</p>
                               </div>
                            </li> -->
                            		
                          
                        </ul>
                    </li>
                </ul>
            </div>        
            <!-- End Atribute Navigation -->

            <!-- Start Header Navigation -->
            <div>
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-menu">
                    <i class="fa fa-bars"></i>
                </button>
                <a class="navbar-brand" href="#brand"><img src="${APP_PATH }/static/nav/logo-black.png" class="logo" alt=""></a>
            </div>
            
            <!-- End Header Navigation -->

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="navbar-menu">
                
                    <div style="margin-bottom: 10px;margin-left: 40%;width: 100%;margin-top:40px;font-weight: bold;font-size: 17px;	 ">
                    	<a href="${APP_PATH }/f_show.jsp">首页</a>    &nbsp; &nbsp;  &nbsp; &nbsp;             
	           			<a href="${APP_PATH }/f_main.jsp">预定</a>		 &nbsp; &nbsp;  &nbsp; &nbsp; 
	                    <a href="${APP_PATH }/f_userinfo.jsp">我的信息</a>	&nbsp; &nbsp;  &nbsp; &nbsp;
	                    <a href="javascript:void(0);" onclick="exit()">注销</a>
                    </div>
                
            </div><!-- /.navbar-collapse -->
        </div>   
    </nav>
    <!-- End Navigation -->
    <div class="clearfix"></div>
	<div class="container">
		<div class="row">
		    <!-- Start Home -->
		    <div class="pageheader" style="height: 100px" >	
		    	<div class="col-md-offset-1">	
		            <h2 class="title">购物车布局导航菜单</h2>
		            <p>Navigation menu with shopping cart dropdown</p>
		       </div>
		    </div>
	    </div>
 </div>
 

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
	<div style="height: 40px"></div>
</div>
	<div class="row">
		<div class="col-md-8">
			<div class="rol" id="searchlist">
				<div class="col-md-11 input-group input-group-sm">
				  <span class="input-group-addon" id="sizing-addon3">主题</span>
				  <input id="search_theme" type="text" class="form-control" placeholder="" aria-describedby="sizing-addon3">
				 
				 <span class="input-group-addon" id="sizing-addon3" >时间</span>
				  <input id="search_date" type="date" class="form-control" placeholder="" aria-describedby="sizing-addon3">
				  
				  <span class="input-group-addon" id="sizing-addon3">负责人</span>
					<input id="search_people" type="text" class="form-control" placeholder="" aria-describedby="sizing-addon3">
				  	
				 <span class="input-group-addon" id="sizing-addon3">会议室</span>
				  <input id="search_room" type="text" class="form-control" placeholder="" aria-describedby="sizing-addon3">
				</div>	
	
				<div class="col-md-8 col-md-offset-4" style="margin-top: 5px">	
					<div class="btn-group" role="group" aria-label="...">
					  <button id="clear_search_btn" type="button" class="btn btn-default">清除</button>
					  <button type="button" id="search_btn" style="margin-left: 20px" class="btn btn-default">搜索</button>		
					  <button type="button" id="myjoin_btn" style="margin-left: 40px" class="btn btn-default">我参加的会议</button>
					  <button type="button" id="getall_btn" style="margin-left: 20px" class="btn btn-default">查看全部</button>
					</div>	
				 </div>
			</div>
			<div class="row">
				
			</div>
			<div  style="height: 15px;margin: 0px;padding: 0px;">	
				<HR style="border:3 double #987cb9" width="100%" color=#000000 SIZE=100>
			</div>
			<div class="row" style="margin: 0 auto;position: relative;left: 20px">
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
			<div class="containerss" style="position:absolute; height:1400px; overflow:scroll ">
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
<!-- 初始化导航栏 -->
<script type="text/javascript">
	var aPeople ; //保存全局登陆者
	console.log("初始化导航栏");
	navInit() ;
	function navInit() {
		$.ajax({
			url : "${APP_PATH}/f/nav/getPeople",	
			type : "GET",	
			async:false,
			success : function(result) {
				console.log("导航条数据");
				console.log(result);
				if(result.code==100){
					aPeople =result;
					exNavData(result);
				}else{
					window.location.href = "${APP_PATH}/"+result.extend.path;
				}
			},
			error:function(a){
				alert("error");
			}
			
		});
	}
	function exNavData(result) {
		var peoinfo = result.extend.peopleInfo;
		$("#head_img").attr("src",peoinfo.peoImagePath);
		var eNavList =document.getElementById("nav_list");
		var i= 0;
		//alert(result.extend.joinList.length);	
		if(result.extend.joinList.length>1){
			$.each(result.extend.joinList,function(index,item){
				i++;
				if(item.joinApply.joinDealState==1){
					var eHtml = "<li style='height:130px' class='total'><div><p style='margin-bottom: 2px;'>申请者："+item.peopleInfo.peoEmployeeName
					+"</span>&nbsp;&nbsp;&nbsp;员工号："+ item.peopleInfo.peoEmployeeId+"</span>"
					+"</p><p style='margin-bottom: 2px;'>申请信息：" +item.joinApply.joinOther
					+"</p><p style='margin-bottom: 2px;'><button index='"+item.joinApply.joinId+"' id='navReject' style='margin-left:45px;margin-right:30px;with:15px;font-size:10px;'>拒绝</button>"
					+"<button  index='"+item.joinApply.joinId+"' id='navAgree' style='with:15px;font-size:10px;'>同意</button></p></div></li>";
					eNavList.innerHTML+=eHtml;		
				}		
			});
			$("#badgeNumSpan").attr("style","color:#f00");
		}else{
			eNavList.innerHTML += "<li><span>当前无事件待处理</span></li>";
		}
		document.getElementById("badgeNumSpan").innerHTML=i;   
	}
		/* 拒绝申请按钮事件处理 */
		$(document).on("click","#navReject",function () { 
			var index= $(this).attr("index");
			$.ajax({
				url : "${APP_PATH}/f/nav/reject",
				type : "GET",
				data:"mydata="+index,
				success : function(result) {
						console.log("拒绝");
						console.loh(result);
						if(result.code==100){
							navInit() ;
						}else{
							alert("拒绝失败");
						}
					}		
				});
		});	
		/* 同意申请按钮事件处理 */
		$(document).on("click","#navAgree",function () { 
			var index= $(this).attr("index");
			$.ajax({
				url : "${APP_PATH}/f/nav/agree",
				type : "GET",
				data:"mydata="+index,
				success : function(result) {
						console.log("同意");
						console.loh(result);
						if(result.code==100){
							navInit() ;
						}else{
							alert("同意失败");
						}
					}		
				});
		});
		/* 注销 */
		function exit() {
			$.ajax({
				url : "${APP_PATH}/f/nav/exit",
				type : "GET",
				success : function(result) {
					window.location.href = "${APP_PATH}/" + result.extend.path;
				}
			});
		}				
					
	
</script>	
	 <script type="text/javascript">
	 var flagState =0;	//保存全局状态 1 ：搜索	2：我的参与	3：普通
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
			searchDel(1,3);
		}
		 /* 解析弹框数据 *//* 弹出框初始化 */
		 function built_alert(numa) {
			 console.log("built_alertss:"+numa);
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
			if(result.extend.pageInfo.total>0){
				var list = result.extend.pageInfo.list;

				//alert("d"+list[0].serialNum);
				$.each(list,function(index,item){
					var sub1 = "<div class='hd_c_left_thumb'> "+	
					"<a href='#' onclick='addreply("+item.serialNum+","+index+")' target='_Self'>"+
							"<img src='"+item.prePicturePath+"' />"+
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
			var applyState=$(cont).attr("applyState");
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
			var data = document.getElementById("book_join_other").value+"_"+first;	
			$.ajax({
				url:"${APP_PATH}/f/show/join",
				type:"GET",
				data:"join_data="+data,
				success:function(result){
					console.log("book_join_btn:::"+result.code);
					if(result.code==100){
						$("#bookjoinAddModal").modal('hide');
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
			downloadFile("${APP_PATH}/f/show/down",path);
		/* 	var sp=path.split("/");
			path = sp[0]+"_"+sp[1]+"_"+sp[2]+"_"+sp[3];
			//alert(path);
			$.ajax({
				url:"${APP_PATH}/f/show/down",
				type:"POST",
				data:"path="+path,
				success: function (data) {
					download(data, "text/html", "dlAjaxCallback.html");		
				}
			});	 */
		});

		function downloadFile(actoinURL,filePath){
			var form = $("<form></form>");   
			$('body').append(form);  
		        form.attr('style','display:none');   
		        form.attr('target','');
		        form.attr('method','post');
		        form.attr('action',actoinURL);//下载文件的请求路径
		        
		        
		        var input1 = $('<input></input>'); 
		        input1.attr('type','hidden'); 
		        input1.attr('name','filePath'); 
		        input1.attr('value',filePath);
		        form.append(input1);  
		        
		        
		        form.submit();    
		}
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
									//alert("a");
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
					searchDel(1,flagState);
				});
				prePageLi.click(function() {
					searchDel(result.extend.pageInfo.pageNum - 1,flagState);
					
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
					searchDel(result.extend.pageInfo.pageNum + 1,flagState);
				});
				lastPageLi.click(function() {
					searchDel(result.extend.pageInfo.pages+1,flagState);
				});
			}

			$.each(result.extend.pageInfo.navigatepageNums, function(index,
					item) {
				var numLi = $("<li></li>").append($("<a></a>").append(item));
				if (result.extend.pageInfo.pageNum == item) {
					numLi.addClass("active");
				}
				numLi.click(function() {
					searchDel(item,flagState);
				});
				ul.append(numLi);
			});
			ul.append(nextPageLi).append(lastPageLi);
			var navEle = $("<nav></nav>").append(ul).appendTo("#page_nav_area");
		}
		 /* 查找我参加的会议事件 */
		 $("#myjoin_btn").click(function () {
			 searchDel(1,2);
		 });
		 /* 查看全部按钮 */
		  $("#getall_btn").click(function () {
			 searchDel(1,3);
		 });
		 
	 	/* 搜索栏事件 */
	 	$("#search_btn").click(function () {
	 		searchDel(1,1);
		});
	 	/* 获取预定数据，初始话  页数，操作状态1：搜索状态	2：我参加的状态		3：普通查询状态 */
	 	function searchDel(pn,op) {
	 		var myurl;var data;
	 		if(op==1){
	 			flagState=1;
	 			var theme=document.getElementById("search_theme").value;
		 		var date=document.getElementById("search_date").value;
		 		var people=document.getElementById("search_people").value;
		 		var room=document.getElementById("search_room").value;
		 		if(!(isEmpty(theme)&&isEmpty(date)&&isEmpty(people)&&isEmpty(room))){
		 			data =theme+"_"+date+"_"+people+"_"+room+"_"+pn;
		 		}else{
		 			return ;
		 		}
	 			myurl="${APP_PATH}/f/show/search";
	 		}else if(op==2){
	 			flagState=2;
	 			myurl="${APP_PATH}/f/show/myjoin";
	 			data = pn;
	 		}else{
	 			flagState=3;
	 			myurl= "${APP_PATH}/f/show/getBook",
	 			data = pn;
	 		}
	 		
		 		$.ajax({
						url:myurl,
						type:"GET",
						data:"mydata="+data,
						success : function(result) {
							if (result.code == 100) {
								//alert("5555");
								console.log("获取预定数据成功,book:");
								console.log(result);
								bookdata=result;
								if(result.extend.pageInfo.total>0){
								first=	result.extend.pageInfo.list[0].serialNum;
								//解析数据
								ex_book_data(result);
								//2、解析显示分页信息
								build_page_info(result);
								//3、解析显示分条数据
								build_page_nav(result);
									addreply(first,0);
								}else{
									$("#lists").empty();
									var listsInfohtml = "<p><span>无数据!!!</span></p>";
									var listsInfo=document.getElementById("lists");
									listsInfo.innerHTML = listsInfohtml;
								}
							} else {
								console.log("已经预定数据失败");
								var p = result.extend.path;
								// alert(p);
								if(!(typeof p === 'undefined')){
									window.location.href = "${APP_PATH}" + p;
								}
								//ex_book_data(result);
						}}
		 		});
	 		}
		
	 	/* 清除搜索栏 */
	 	$("#clear_search_btn").click(function(){
	 		document.getElementById("search_theme").value="";
	 		document.getElementById("search_date").value="";
	 		document.getElementById("search_people").value="";
	 		document.getElementById("search_room").value="";
	 		searchDel(1,3);
	 	});
	 	/* 为空判断 */
	 	  function isEmpty(input) { 
			   return input == null || input == ''; 
			  }
	</script> 
</body>
</html>