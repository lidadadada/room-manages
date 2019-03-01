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
<link rel="stylesheet" type="text/css"
	href="${APP_PATH }/static/css/main_table.css">
<script type="text/javascript"
	src="${APP_PATH }/static/js/jquery-1.11.3.min.js"></script>
<link
	href="${APP_PATH }/static/bootstrap-3.3.7-dist/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="${APP_PATH }/static/css/my_f_main.css" rel="stylesheet">
<script type="text/javascript"
	src="${APP_PATH }/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="${APP_PATH }/static/js/util.js"></script>
	
	<link href="${APP_PATH }/static/font-awesome/css/fontawesome.css" rel="stylesheet">
	<link href="${APP_PATH }/static/nav/bootsnav.css" rel="stylesheet">
	<link href="${APP_PATH }/static/nav/overwrite.css" rel="stylesheet">
            <link href="${APP_PATH }/static/nav/style.css" rel="stylesheet">
	<script src="${APP_PATH }/static/nav/bootsnav.js"></script>
	
	<link href="https://cdn.bootcss.com/bootstrap3-dialog/1.34.9/css/bootstrap-dialog.min.css" rel="stylesheet">
<script src="https://cdn.bootcss.com/bootstrap3-dialog/1.34.9/js/bootstrap-dialog.min.js"></script>
	
	<style type="text/css">
		.imglist li{
			display:inline-block;
		}
		.pageheader{	
				background: url("${APP_PATH }/static/img/navbg.jpg");
				background-size:cover;
		}
			tbody tr td:last-child {
			    position: relative;
			}
			
			tbody tr #showTheme:hover:after {
			    position: absolute;
			    left: attr(left);
			    top:attr(top);
			    padding: 5px;
			    background-color: #0095ff;
			    border-radius: 5px;
			    color: #fff;
			    /*这里显示的内容为表格中自定义的labelTooltip属性对应的值*/
			    content: attr(labelTooltip);
			    z-index: 2;
			    width: 120px;
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
<body>
<!-- 编辑模态框 -->
	<div class="modal fade" id="bookEditModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document" >
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">编辑预定</h4>
				</div>
				<!-- 表单体   	name值和bean中一致-->
				<div class="modal-body">
					<form class="form-horizontal" id="bookAddForm">
						<div class="form-group" id="edit_book_people_id_addhelp-block">
							<label class="col-sm-3 control-label" >员工号</label>
							<div class="col-sm-6" id="book_peo_id_edit">
								
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-3 control-label">选择会议室</label>
							<div class="col-sm-6">
								<!-- 下拉列表，name直接写preRoomNum -->
								<select class="form-control" name="preRoomNum"
									id="book_room_edit_select">
								</select>
								<!-- 会议室信息 -->
								<span id="edit_book_address_span"></span> <br> <span
									id="edit_book_max_num_span"></span> <br> <span
									id="edit_book_equip_span"></span>
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-3 control-label">主题</label>
							<div class="col-sm-9">
								<input type="text" name="preTheme" class="form-control"
									id="book_theme_edit" placeholder=""> <span
									class="help-block"></span>
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-3 control-label">日期</label>
							<div class="col-sm-9">
								<input type="date" name="preDay" class="form-control"
									id="book_date_edit" placeholder="">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">预定开始时间</label>
							<div class="col-sm-9">
								<input type="text" name="preStartTime" class="form-control"
									id="book_start_time_edit" placeholder="">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">预定结束时间</label>
							<div class="col-sm-9">
								<input type="text" name="preEndTime" class="form-control"
									id="book_end_time_edit" placeholder="">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">备注信息</label>
							<div class="col-sm-9">
								<input type="textarea" name="other" class="form-control"
									id="book_other_edit" hint="在此处填写其它相关说明信息">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">会议头像</label>
							<div class="col-sm-6">
								<input type="file" name="bookImage" class="form-control" accept="image/*"
									id="book_image_add" placeholder="在此处填写其它相关说明信息">
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary"
						id="book_edit_save_btn">保存修改</button>
				</div>
			</div>
		</div>
	</div>
<!-- 添加预定记录模态框 -->
	<div class="modal fade" id="bookAddModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">完善预定信息</h4>
				</div>
				<!-- 表单体   	name值和bean中一致-->
				<div class="modal-body">
					<form class="form-horizontal" id="bookAddForm">
						<div class="form-group" id="book_people_id_addhelp-block">
							<label class="col-sm-2 control-label" >员工号</label>
							<div class="col-sm-6">
								<input type="number" name="prePeopleId" class="form-control"
									id="book_people_id_add" placeholder="2106010312"> 
									<!-- 会议室信息 -->
								<span id="people_name_model_span"></span>
								<span id="people_post_model_span"></span>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">主题</label>
							<div class="col-sm-6">
								<input type="text" name="preTheme" class="form-control"
									id="book_theme_add" placeholder="填写会议的主题"> <span
									class="help-block"></span>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">公告</label>
							<div class="col-sm-6">
								<input type="textarea" name="other" class="form-control"
									id="book_other_add" placeholder="在此处填写其它相关说明信息">
							</div>
						</div>
						<div class="form-group">
							<div id="book_room_add_select" class="col-sm-6"></div>
							<div id="book_date_add" class="col-sm-6"></div>
							<br>
							<div id="book_time_add" class="col-sm-6"></div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">会议头像</label>
							<div class="col-sm-6">
								<input type="file" name="bookImage" class="form-control" accept="image/*"
									id="book_image_add" placeholder="在此处填写其它相关说明信息">
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary"
						id="book_add_save_btn">保存</button>
				</div>
			</div>
		</div>
	</div>
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
 


<div class="container">
	<div class="row"  >	
		<div >	
			<ul class="imglist">
				<li ><a>			
					<img id="befor_day" alt="" src="${APP_PATH }/static/img/ZS.png" width="50" style="transform:rotate(-90deg);display:inline-block;">
				</a></li>
				<li style="margin-right: 40px">
					<span>上一天</span>
				</li>
				<li>
					<span id="list_time">当前日期：</span>
				</li>
				<li style="margin-left: 40px">
					<span>下一天</span>
				</li>
				<li ><a>		
					<img id="later_day" alt="" src="${APP_PATH }/static/img/ZS.png" width="50" style="transform:rotate(90deg);display:inline-block;">
				</a></li>
				<li  style="margin-left: 260px">
					空闲：<th> <button class="btn btn-primary" type="button"></button></th>
				</li>
				<li style="margin-left: 20px">
					拟选：<th> <button class="btn btn-warning" type="button"></button></th>
				</li>
				<li style="margin-left: 20px">
					已被占用：<th><button class="btn btn-danger" type="button" disabled="disabled"></button></th>
				</li>
			</ul>
			
		</div>
		
		
	</div>
	<div id="tables"class="row">
		<table class="course_table">
			<tbody id="course_html">
				<tr>
					<th>会议室</th>
					<th id="p1">7:00</th>
					<th id="p2">7:30</th>
					<th id="p3">8:00</th>
					<th id="p4">8:30</th>
					<th id="p5">9:00</th>
					<th id="p6">9:30</th>
					<th id="p7">10:00</th>
					<th id="p8">10:30</th>
					<th id="p9">11:00</th>
					<th id="p10">11:30</th>
					<th id="p11">12:00</th>
					<th id="p12">12:30</th>
					<th id="p13">13:00</th>
					<th id="p14">13:30</th>
					<th id="p15">14:00</th>		
					<th id="p16">14:30</th>
					<th id="p17">15:00</th>
					<th id="p18">15:30</th>
					<th id="p19">16:00</th>
					<th id="p20">16:30</th>
					<th id="p21">17:00</th>
					<th id="p22">17:30</th>
					<th id="p23">18:00</th>
					<th id="p24">18:30</th>
					<th id="p25">19:00</th>
					<th id="p26">19:30</th>
				</tr>

			</tbody>
		</table>
		</div>
		<div class="row">
			<div class="col-md-12" style="height: 8px"></div>	
			<div class="col-md-6 col-md-offset-10" >		
				<button type="button" id="submit" class="btn btn-default" style="margin-right: 15px;">预定</button>
				<button type="button" id="clearBtn" class="btn btn-default">清除</button>
			</div>
		</div>
</div>


<div class="container">
	<div class="row">
		<div style="height: 10px"></div>
		<div style="height: 15px;margin: 0px;padding: 0px;">	
				<hr style="border:3 double #987cb9" width="100%" color="#000000" size="100">
		</div>
	</div>
	<div class="row clearfix">
		<div class="col-sm-12 column">
			<div class="tabbable" id="tabs-853880">
				<ul class="nav nav-tabs" >
					<li>
						 <a href="javascript:void(0);" onclick="jumpPage(1)" >我创建的会议</a>
					</li>
					<li class="active">
						 <a href="javascript:void(0);" onclick="jumpPage(2)" >参会人员信息</a>
					</li>
				</ul>
				<div class="tab-content">
					<div class="tab-pane active"  id="panel-283108">
						
						<table id="down_tables" class="table table-striped table-hover table-condensed">
								
						</table>
					<!-- 分页信息 -->
						<div class="row">
							<!-- 文字信息 -->
							<div class="col-md-6" id="page_info_area1"></div>
							<!-- 分页条 -->
							<div class="col-md-6" id="page_nav_area1"></div>
						</div>
					
					</div>
					<div class="tab-pane " id="panel-370114">
						<table id="tables_peopel" class="table table-striped table-hover table-condensed">
							
						</table>
					<!-- 分页信息 -->
						<div class="row" >
							<!-- 文字信息 -->
							<div class="col-md-6" id="page_info_area2"></div>
							<!-- 分页条 -->
							<div class="col-md-6" id="page_nav_area2"></div>
						</div>
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
	var myDate = new Date();		//本地时间
	var sindexMins=0;
	var sindexMaxs=0;	
	var pre_time=[];		//暂存选择的 时间段
	var pre_room_name="m";	//暂存选择的 会议室
	var roomInfo = [];		//暂存从后台中过来的会议室信息
	//获取系统当前时间
	
	var date_id = getDates(myDate);
	//alert(date_id);		
	var now_date_unit =getDatesToWord(myDate);
	//alert( getDates(myDate)+"        "+date_id);
	//alert(date_id);
	init_book_table();
	/* 页面进入入口 */
	function init_book_table() {
		//alert("init_book_table");
		document.getElementById("list_time").innerHTML="当前日期："+getDatesToWord(myDate);
		init_room();
		init_book(date_id);
		//alert("ddd");
	}
	//获取房间信息
	function init_room() {
		$.ajax({
			url : "${APP_PATH}/f/main/getRoom/",
			type : "GET",
			async : false,
			success : function(result) {
				if (result.code == 100) {
					console.log(result);
					//alert("initroom")
					//解析数据
					ex_room_data(result);
				} else {
					//alert("获取数据失败");
					//alert(result.extend.msg);
					var p = result.extend.path;
					// alert(p);
					window.location.href = "${APP_PATH}" + p;
				}
			}
		})
	}
	//获取预定数据
	function init_book(id) {
		console.log("开始获取预定数据");
		$.ajax({
			url : "${APP_PATH}/f/main/getBook/" + id,
			type : "GET",
			async : false,
			success : function(result) {
				if (result.code == 100) {
					//alert("5555");
					console.log("已经预定数据成功");
					console.log(result);
					//解析数据
					ex_book_data(result);
				} else {
					console.log("已经预定数据失败");
					//alert("获取数据失败");
					//alert(result.extend.msg);
				}
			}
		});
	}
	//解析房间信息数据
	function ex_room_data(result) {
		//清空之前生成的信息/
		//alert("解析房间");
		roomInfo = result.extend.room;
		//alert(roomInfo);
		$.each(roomInfo,function(index, item) {
			//alert(index);
			var td = $("<tr></tr>").attr("index", index).append($("<td></td>").append(item.roomName));
			var i;
			for (i = 0; i < 26; i++) {
					td.append($("<td></td>").append(
							$("<button></button>").addClass("btn btn-primary btn-lg").attr("type","button" )
							.attr("index", i).attr("id","table_btn")));
				}
			td.appendTo($("#course_html"));
		});
		//alert("解析房间111");
	}
	//解析预定数据
	function ex_book_data(result) {
		$.each(result.extend.list, function(index, item) {
			//根据房间名获得行索引
			var rolIndex = getRolByRoomName(item.preRoomNum);
			
			if (rolIndex > -1) {
				var start = getMyhours(item.preStartTime);
				var end = getMyhours(item.preEndTime);
				/* alert("start"+start);
				alert("end"+end); */
				//计算已经预定时间的列
				var startin = getColIndex(start);
				var endin = getColIndex(end);
				/* alert("startin"+startin);
				alert("endin"+endin); */
				var j=startin;
				for(;j<endin;j++){
					$("tbody").children("tr").eq(1+rolIndex).children("td")
						.eq(1+j).children("button").eq(0).removeClass().addClass("btn btn-danger btn-lg").attr("disabled","disabled");
				}
				//alert("endin" + endin + "startin" + startin);
			} else {
				alert("预定数据的会议室名无法查询");
			}
		});
	}
	
	/* 点击方块事件处理 */
	$(document).on("click","#table_btn",function () {
		//所点击方块的列索引号
		var index=$(this).attr("index");
		var time = ColIndexToTime(index);	
		console.log("索引号："+index);
		//判断为原始的未选择的方块
		if($(this).attr("class")=="btn btn-primary btn-lg"){
			
			console.log("time:"+time);
			//获得行房间名
			var name=$(this).parent().siblings()[0].innerHTML;
			//第一次选择？
			if(pre_room_name=="m"){
				pre_room_name=name;
				pre_time.push(time);
				pre_time.push(addHalfhear(time));
				//alert(pre_time[0]);
				$(this).removeClass().addClass("btn btn-warning btn-lg");
			}else{
				//第二次以上的选择是同一行？
				if(pre_room_name==name){
					var flagdd=0;
					var i=0;
					var nowTempTime=addHalfhear(time);
					var max =getTimeMax();
					console.log("++++++++++++++++"+time+getTimeMin());
					if(bijiao(nowTempTime,max)==1){
						var flagdd=1;
						console.log("a1");
						if(bijiao(nowTempTime,addHalfhear(getTimeMax()))==0){
							console.log("a1a");
							pre_time.push(nowTempTime);
							$(this).removeClass().addClass("btn btn-warning btn-lg");
							}else{
								console.log("a1b");
								alert("不允许中间隔着选择");
						}
					}
						else if(bijiao(time,getTimeMin())==-1){
							flagdd=1;
							console.log("a2");
							if(bijiao(addHalfhear(time),getTimeMin())==0){
								console.log("a2a");
								pre_time.push(time);	
								$(this).removeClass().addClass("btn btn-warning btn-lg");
							}else{
								console.log("a2b");
								alert("不允许中间隔着选择");
							}	
						}
				}
					else{
						alert("不允许跨会议室选择，请取消已选择或者提交！");
					}
			}}else{
				/* 取消选择 */
				if(pre_time.length>2){
					console.log("a3a");
					if(bijiao(addHalfhear(time),getTimeMax())==0){
						console.log("a3aa");
						pre_time.pop();
						$(this).removeClass().addClass("btn btn-primary btn-lg");
					}
					else if(bijiao(time,getTimeMin())==0){
						console.log("a3ab");
						pre_time.shift();
						$(this).removeClass().addClass("btn btn-primary btn-lg");
					}
				}else{
					console.log("a3b");
					if(bijiao(time,getTimeMin())==0){
						pre_time=[];
						pre_room_name="m";
						$(this).removeClass().addClass("btn btn-primary btn-lg");
					}
				}
			}
		console.log(pre_time);
	});
	/* 清楚选择 */
	$("#clearBtn").click(function () {
		$("#tables .btn-warning").removeClass().addClass("btn btn-primary btn-lg");
		pre_time=[];
		pre_room_name="m";
	});
	/* 模态框里的保存 */
	$("#submit").click(function () {
		var i=0;
		if(pre_time.length==0){
			alert("您未选择任何时间");
		}else{
			var stime="";
			for(;i<pre_time.length;i++){
				var index= (timeToIndex(pre_time[i]));
				if(index<timeToIndex(pre_time[sindexMins])){
					sindexMins=i;
				}
				if(index>timeToIndex(pre_time[sindexMaxs])){
					sindexMaxs=i;
				}
			}
			/* 提交打开确认模态框 */
			//alert(sindexMins+"-"+sindexMaxs);
			$("#bookAddModal").modal({
				backdrop:"static"
			});
			//重置模态框数据
			reset_dailog();
			document.getElementById('book_room_add_select').innerHTML ="当前拟选会议室：<label class='ontrol-label'>"+pre_room_name+"</label>";
			document.getElementById('book_date_add').innerHTML="选择日期：<label class='ontrol-label'>"+date_id+"</label>";
			//alert(sindexMin);	
			document.getElementById('book_time_add').innerHTML="预定时间：<label class='ontrol-label'>"+pre_time[sindexMins]+"</label>"+"到<label class='ontrol-label'>"+pre_time[sindexMaxs]+"</label>";
			
			//stime = stime.subString(0,pre_time.length-1);
			//alert("stime"+stime);
		}
		
	});
	//模态框里保存预定记录
	$("#book_add_save_btn").click(function() {
		//1、校验数据,,正则表达式
		
		//console.log("sindexMins"+sindexMins+"sindexMaxs"+sindexMaxs);	
		var cons_input="prePeopleId="+document.getElementById("book_people_id_add").value+
			"&preRoomNum="+encodeURI(pre_room_name)+"&preTheme="+encodeURI(document.getElementById("book_theme_add").value)
			+"&preDay="+encodeURI(date_id)+"&preStartTime="+encodeURI(pre_time[sindexMins])+
			"&preEndTime="+encodeURI(pre_time[sindexMaxs])+"&other="+encodeURI(document.getElementById("book_other_add").value)
			//alert(cons_input);
		
		  var fd = new FormData($("#bookAddForm")[0]);
		  fd.append("preRoomNum",pre_room_name);
		  fd.set("preStartTime",pre_time[sindexMins]);
			fd.set("preDay",date_id);		
			fd.set("preEndTime",pre_time[sindexMaxs]);
			fd.set("preTheme",document.getElementById("book_theme_add").value);
			fd.set("other",document.getElementById("book_other_add").value);
			fd.append("prePeopleId",document.getElementById("book_people_id_add").value)
			console.log("date_id：："+date_id);
			var f = document.getElementById("book_image_add").files;  
			//console.log(f);	
			if(f[0]!=null){
				console.log("a");
			var s =f[0].name.split(".")[1];
			fd.append("imagePrefix",s );
			}	else{
			fd.append("imagePrefix","n");
				}
		//ajax保存	
		$.ajax({
			url : "${APP_PATH }/f/main/upBook/",
			type : "post",	
			data : fd,
			 processData: false,
	         contentType: false,
			success : function(result) {
				console.log("保存预定返回值");
				console.log(result);
				if (result.code == 100) {
					//保存成功之后，1、关闭模态框，2、跳到最后一页
					$("#bookAddModal").modal('hide');
					$("[index]").empty();
					$("[index]").remove();
					//还原暂存信息
					pre_time=[];
					pre_room_name="m";
					init_book_table();
					alert("保存成功");	
				} else {
					alert("保存失败！");
				}
			}
		});
	});
	
	//判断员工号是否存在
	$("#book_people_id_add").blur(function() {
		console.log("判断员工号");
		$.ajax({
			url : "${APP_PATH }/people_save_model_select",
			type : "get",
			data:"id="+document.getElementById("book_people_id_add").value,
			success : function(result) {
				if(result.code==100){
					//添加员工名字和职位
					console.log(result);
					var item =result.extend.listPeopleInfo;
					$("#people_name_model_span").text("姓名："+ item[0].peoEmployeeName);
					$("#people_post_model_span").text("职位："+ item[0].peoPost);
				}
				else{
					$("#book_people_id_addhelp-block").addClass("form-group has-error");
					$("#people_name_model_span").text("查无此员工号!!");
				}
			}
		});
	});
	
	
	/* 重置模态框数据 */
	function reset_dailog(){
		document.getElementById('book_room_add_select').innerHTML ="";
		document.getElementById('book_date_add').innerHTML="";
		//alert(sindexMin);	
		document.getElementById('book_time_add').innerHTML="";
		$("#people_name_model_span").text("");
		$("#people_post_model_span").text("");
		$("#book_people_id_addhelp-block").removeClass().addClass("form-group");
		$("#people_name_model_span").text("");
		document.getElementById("book_people_id_add").value="";
		document.getElementById("book_theme_add").value="";
		document.getElementById("book_other_add").value="";
	}
	
	//根据房间名获得行索引
	function getRolByRoomName(name) {
		var j;
		//alert(name+"=======");
		//alert(roomInfo[0].roomName);
		//alert("长度"+roomInfo.length);
		for (j = 0; j < roomInfo.length; j++) {
			//alert(roomInfo[j].roomName + "kkkkkkkkk" + name);
			if (roomInfo[j].roomName == name) {
				//alert("j"+j);
				return j;
				break;
			}
		}
		return -1;
	}
	//计算已经预定时间的列
	function getColIndex(start) {
		//alert(start);
		var sp = start.split(":");
		var h = parseInt(sp) - 7;
		//alert("h"+h);
		h = h * 2;
		if (sp[1] != "00") {
			h += 1;
		}
		return h;
	}
	/* 索引转时间 */
	function ColIndexToTime(i) {
		if(i%2==0){
			i=i/2;
			i+=7;
			/* alert("i:"+i)
			alert(i); */
			
			if(i<10){
				return "0"+i+":00:00";
			}
			return i+":00:00";
		}
		else{
			i=i/2;
			i+=7;
			/* alert("i:"+i)
			alert(i); */
			i=i-0.5;
			//alert("i:"+i)
			if(i<10){
				return "0"+i+":30:00";
			}
			return i+":30:00";	 
		}
	}
	
	/* 获取暂存时间中的最大值 */
	function getTimeMax(){
		var record =0;
		if(pre_time.length>0){
			var temp=pre_time[0];
			if(pre_time.length==1){
				return temp;
			}else{	
				var s;
				for(var i =1;i<pre_time.length;){
				//	console.log("i:"+i+"   per:"+pre_time+"   per:"+pre_time[1]+"   per:"+pre_time[0]);
					s = bijiao(temp,pre_time[i]);
					if(s==-1){
						temp=pre_time[i];
						record=i;
					}
					i++;
					//console.log("i:"+i);
				}
				var temps = pre_time[record];
				pre_time.splice(record,1,pre_time[ pre_time.length-1]);
				 pre_time.splice( pre_time.length-1,1,temps);
			}
		}
		
		return temp;
	}
	/* 获取暂存时间中的最小值 */
	function getTimeMin(){
		var record =0;
		if(pre_time.length>0){
			var temp=pre_time[0];
			if(pre_time.length==1){
				return temp;
			}else{
				var i =1;var s;
				for(;i<pre_time.length;i++){
					s = bijiao(temp,pre_time[i]);
					if(s==1){
						temp=pre_time[i];
						record=i;
					}
				}
				var temps = pre_time[record];
				pre_time.splice(record,1,pre_time[0]);
				pre_time.splice(0,1,temps);
			}
		}
		return temp;
	}
	/* 比较两个时间字符串的大小 */
	function bijiao(a,b) {
	//	console.dir(b);
		console.log("a:"+a+ "b:"+b);
		var bbb = b.split(":");
		var bs=parseInt(bbb[0]);
		var as=parseInt(a.split(":")[0]);
		//console.log("a:"+a+"  b:"+b+"  as:"+as+"  bs:"+bs);
		if(as>bs){
			return 1;
		}else if(as<bs){
			return -1;
		}else{
			if(parseInt(a.split(":")[1])>parseInt(b.split(":")[1])){
				return 1;
			}else if(parseInt(a.split(":")[1])<parseInt(b.split(":")[1])){
				return -1;
			}else{
				return 0;
			}
		}
	}
	/* 增加半个小时 */
	function addHalfhear(a){
		var temp;
		if(parseInt(a.split(":")[1])>0){
			if(parseInt(a.split(":")[1])<9){
				temp = "0"+parseInt(a.split(":")[0])+1+":00:00";
			}else{
				temp = parseInt(a.split(":")[0])+1+":00:00";
			}
		}else{
			temp=a.split(":")[0]+":30:00";
		}
		return temp;
	}
	/* 时间转索引 */
	function timeToIndex(time) {
		var s =time.split(":");
		var h = parseInt(s[0]);
		var index = (h-7)*2;
		if(parseInt(s[1])>0){
			index+=1;
		}
		return index;
	}
	
	/* 切换日期事件 */
	$("#befor_day").click(function () {
		//myDate.set(myDate.getDate()-1);
		
		myDate = myDate.setDate(myDate.getDate()-1); 
		myDate=new Date(myDate);
		date_id = getDates(myDate);	
		now_date_unit =getDatesToWord(myDate);
		$("tr[index]").remove();
		init_book_table();
	});
	$("#later_day").click(function () {
		myDate = myDate.setDate(myDate.getDate()+1);
		myDate=new Date(myDate);
		date_id = getDates(myDate);
		now_date_unit =getDatesToWord(myDate);
		$("tr[index]").remove();
		init_book_table();
	});
	
	
	$("#befor_day").on("mousedown",function () {
		  $(this).attr("src","${APP_PATH }/static/img/ZS1.png");
	});
	$("#befor_day").on("mouseup",function () {
		  $(this).attr("src","${APP_PATH }/static/img/ZS.png");
	});
	$("#later_day").on("mousedown",function () {
		  $(this).attr("src","${APP_PATH }/static/img/ZS1.png");
	});
	$("#later_day").on("mouseup",function () {
		  $(this).attr("src","${APP_PATH }/static/img/ZS.png");
	});
	
	//获得用户本地当前时间
	function getDates(date){
		
		var year = date.getFullYear();
		var month = (date.getMonth() + 1);
		var day = date.getDate();
		if(month<10){
			month= "0"+month;
		}
		if(day<10){
			day="0"+day;
		}
		return year + "-" + month + "-" + day+" 00:00:00";
	}
	function getDatesToWord(date){
			
			var year = date.getFullYear();
			var month = (date.getMonth() + 1);
			var day = date.getDate();
			if(month<10){
				month= "0"+month;
			}
			if(day<10){
				day="0"+day;
			}
			return year+"年"+month+"月"+day+"日";
		}
</script>

<script type="text/javascript">
		var anum ; //保存查看详细人员时候的预定记录号
		var apn; //保存当前页面数
		var aflage = 1; 	//1普通模式		2查看人员列表模式
		var tbodyid="info_root";
		var room_info_result; //保存全局会议室数据
		var bookResult; //保存全局预定数据
		var apeople; //保存全局详细人员数据
		var style =["error","warning","info","success"];	//存放表格样式	class
		init_down_list(1);
		/* 入口 */
		 	function init_down_list(pn){
		 		apn = pn;
		 		tbodyid="info_root";
		 		aflage=1;
		 		$.ajax({
			 		url:"${APP_PATH}/f/my/struct",
			 		type:"POST",
			 		async:false,
			 		success:function(result){
			 			bookResult = result;
			 			console.log("获取房间数据成功");
			 			console.log(result);
			 			if(result.code==100){
			 					exdata(result);
			 					//2、解析显示分页信息
								build_page_info(result);
								//3、解析显示分条数据
								build_page_nav(result);
			 			}else{
			 				window.location.href = "${APP_PATH}"+result.extend.path;
			 			}
			 		}
			 	});
		 	}
		/* 添加表头 */
		function addTableHead() {
			//alert(aflage);
			var addhtml;
			if(aflage==1){
				$("#panel-283108").removeClass().addClass("tab-pane active");
				$("#panel-370114").removeClass().addClass("tab-pane");
				addhtml= "<thead><tr><th>会议头像</th><th>时间</th><th>会议室</th><th>主题</th>"+
				"<th>参加人数</th><th>公告信息</th><th>会议状态</th><th>操作</th></tr></thead>"+
				"<tbody id='info_root'></tbody>";
				document.getElementById("down_tables").innerHTML = addhtml;
			}else{
				$("#panel-370114").removeClass().addClass("tab-pane active");
				$("#panel-283108").removeClass().addClass("tab-pane");
				addhtml= "<thead><tr><th>头像</th><th>名字</th><th>职位</th><th>申请信息</th>"+
				"<th>操作</th></thead>"+
				"<tbody id='info_root_people'></tbody>";
				document.getElementById("tables_peopel").innerHTML = addhtml;
			}
		}
		/* 解析数据 */
		function exdata(result){
			
			addTableHead();
			var lists = result.extend.pageInfo.list;
			var isOut = result.extend.isTimeOut;
			if(lists==""||lists==[]){
				anum = -1;
			}else{
				anum = lists[0].serialNum;	
			}
					
			$.each(lists,function(index,item){
				
				//console.log($("#info_root").find(""))
				var etdImage = $("<td ></td>")
					.append($("<img>").attr("src",item.prePicturePath).attr("style","margin:0px;padding:0px;height:22px;"));
					
				var etdTime =$("<td></td>").append(getMyDate(item.preDay)+"  "+getMyhoursNoSecond(item.preStartTime)
				+"-"+getMyhoursNoSecond(item.preEndTime));
				
				
				var etdT = $("<td></td>").append(item.preRoomNum);
				var etdTheme;
				if(item.preTheme.length<10){	
					etdTheme = $("<td></td>").append(item.preTheme);
				}else{
					var tempStr = item.preTheme;
					var temps = tempStr.substring(0,7)+"...";
					/* <a id="meeting_info" type="button" class="btn btn-default" data-container="body" data-toggle="hover hover" data-placement="bottom" ">
						 会议公告
						</a> */
					etdTheme = $("<td></td>").append($("<a  labelTooltip='主题："+item.preTheme+"'></a>").attr("id","showTheme").attr("type","button")
							.attr("index",index).attr("data-container","body").attr("data-toggle","hover").attr("data-placement","up")
							.append(temps));
					
				}
				
				var etdOther;
				if(item.other.length<10){	
					etdOther = $("<td></td>").append(item.other);
				}else{
					var tempStr = item.other;
					var temps = tempStr.substring(0,7)+"...";
					/* <a id="meeting_info" type="button" class="btn btn-default" data-container="body" data-toggle="hover hover" data-placement="bottom" ">
						 会议公告
						</a> */
						etdOther = $("<td></td>").append($("<a  labelTooltip='公告："+item.other+"'></a>").attr("id","showTheme").attr("type","button")
							.attr("index",index).attr("data-container","body").attr("data-toggle","hover").attr("data-placement","up")
							.append(temps));
				}
				
				var etdJoinNum = $("<td></td>").append(item.preJion).append($("<button id='show_people' class='btn btn-default'  type='button'  >列表</buuton>").attr("index",index));
				var etdState;	
				if(result.extend.isTimeOut[index]==1){
					etdState= $("<td></td>").append("已结束");
				}else if(result.extend.isTimeOut[index]==0){
					etdState= $("<td></td>").append("进行中");
				}else{
					etdState= $("<td></td>").append("未开始");
				}
				
				/* 设置表格行样式 */
				var flag =index%5;
				var etr;
				if(flag>0){
					etr = $("<tr></tr>").attr("class",style[flag-1]).attr("id","down_id"+index);
				}else{
					etr = $("<tr></tr>").attr("id","down_id"+index);
				}
				
				etr.append(etdImage).append(etdTime).append(etdT).append(etdTheme).append(etdJoinNum).append(etdOther)
				.append(etdState).appendTo($("#"+tbodyid));
				
				/* 添加操作按钮 */
				var root = document.getElementById("down_id"+index);
				var optHtml ="<button class='btn btn-primary btn-sm' id='editbtn' index='"+index+"'id='disbrand'><span class='glyphicon glyphicon-pencil'></span>编辑</button>"; 
				optHtml =optHtml +"<button class='btn btn-danger btn-sm' id='disbrand' index='"+index+"'id='disbrand'><span class='glyphicon glyphicon-trash'></span>解散</button>"; 
				root.innerHTML = root.innerHTML+"<td>"+optHtml +"</td>";
			});
		}
		/* 2、解析显示分页信息 */
		function build_page_info(result) {
			$("#page_info_area"+aflage).empty();
			$("#page_info_area"+aflage).append(
					"当前第" + result.extend.pageInfo.pageNum + "页，总共"
							+ result.extend.pageInfo.pages + "，总共"
							+ result.extend.pageInfo.total + "记录数");
			totalRecord = result.extend.pageInfo.pages;
		}
		/* 3、解析显示分条数据 */
		function build_page_nav(result) {
			$("#page_nav_area"+aflage).empty();

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
					to_page(1);
				});
				prePageLi.click(function() {
					to_page(result.extend.pageInfo.pageNum - 1);
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
					to_page(result.extend.pageInfo.pageNum + 1);
				});
				lastPageLi.click(function() {
					to_page(result.extend.pageInfo.pages+1);
				});
			}

			$.each(result.extend.pageInfo.navigatepageNums, function(index,
					item) {
				var numLi = $("<li></li>").append($("<a></a>").append(item));
				if (result.extend.pageInfo.pageNum == item) {
					numLi.addClass("active");
				}
				numLi.click(function() {
					to_page(item);
				});
				ul.append(numLi);
			});
			ul.append(nextPageLi).append(lastPageLi);
			var navEle = $("<nav></nav>").append(ul).appendTo("#page_nav_area"+aflage);
		}	
		/* 下面导航条跳页调度 */
		function to_page(pn){
			if(aflage==1){
				init_down_list(pn);
			}else{
				showAllPeopel(anum,pn);
			}
		}
		/* 编辑按钮点击事件处理 */	
		$(document).on("click","#editbtn",function(){
			var index = $(this).attr("index");
			var state=bookResult.extend.isTimeOut[index];
			if(-1==-1){ 
				$("#bookEditModal").modal({		
					backdrop:"static"
				});
				/* 添加数据回显到model */
				add_to_model(index);
				$("#book_edit_save_btn").attr("index",index);
			}else if(state==0){
				alert("该会议正在进行中，不能修改");
			}else{
				alert("该会议已结束，不能修改");
			}
		});
		/* 保存修改 */
		$(document).on("click","#book_edit_save_btn",function(){
			  var fd = new FormData($("#bookAddForm")[0]);
				
				var f = document.getElementById("book_image_add").files;  
				var index =$(this).attr("index");
				 var num =bookResult.extend.pageInfo.list[index].serialNum;
				fd.append("serialNum",num);
				console.log(f);	
				if(f[0]!=null){
					console.log("a");
				var s =f[0].name.split(".")[1];
				fd.append("imagePrefix",s );
				}	else{
				fd.append("imagePrefix","n");
					}
			//ajax保存	
			$.ajax({
				url : "${APP_PATH }/f/main/alterBook/",
				type : "post",	
				data : fd,
				 processData: false,
		         contentType: false,
				success : function(result) {
					if (result.code == 100) {
						//保存成功之后，1、关闭模态框，2、跳到最后一页
						$("#bookEditModal").modal('hide');
						 
						//$("#info_root").empty();
						//init(1);
						window.location.reload();
					} else {
						alert("保存失败！");
					}
				}
			});
		});
		/* 删除按钮点击事件处理 */	
		$(document).on("click","#disbrand",function(){
			var index =$(this).attr("index");
			var id = bookResult.extend.pageInfo.list[index].serialNum;
			BootstrapDialog.show({  
	            title: '警告',  
	            message: '确认解散会议？？？',  
	            buttons: [{  
	                label: '取消',  
	                action: function(dialog) {  
	                    
	                    dialog.close();
	                }  
	            }, {  
	                label: '确认',  
	                action: function(dialog) { 
	                	$.ajax({
	                		url:"${APP_PATH }/f/my/disboard/"+id,
	                		type: "GET",
	                		//data:"deleteNum="+index,
	                		success:function(result){
	                			if(result.code==100){
	                				dialog.close();
	                				$("#"+tbodyid).empty();
	                				init_down_list(1);
	                			}
	                			else{
	                				alert("删除失败");
	                			}
	                		}
	                	}) ;
	                }  
	            }]  
	        });
			
		});
		/* 添加数据回显到model */
		function add_to_model(index) {
			console.log(bookResult);
			$("#bookEditModal form")[0].reset();
			document.getElementById('book_peo_id_edit').innerHTML=bookResult.extend.pageInfo.list[index].prePeopleId;
			document.getElementById('book_theme_edit').value=bookResult.extend.pageInfo.list[index].preTheme;
			document.getElementById('book_date_edit').value=getMyDate(bookResult.extend.pageInfo.list[index].preDay);
			document.getElementById('book_start_time_edit').value=getMyhours(bookResult.extend.pageInfo.list[index].preStartTime);
			document.getElementById('book_end_time_edit').value=getMyhours(bookResult.extend.pageInfo.list[index].preEndTime);
			document.getElementById('book_other_edit').value=bookResult.extend.pageInfo.list[index].other;
			document.getElementById('book_room_edit_select').value=bookResult.extend.pageInfo.list[index].preRoomNum;
			getRoomInfo("#book_room_edit_select");
			var osel=document.getElementById("book_room_edit_select"); //得到select的ID
			var opts=osel.getElementsByTagName("option");
			var i=0;				
			for(;i<opts.length;i++){
				if(opts[i].text==bookResult.extend.pageInfo.list[index].preRoomNum){
					//alert("ok");
					opts.selected=true;
					break;
				}
			}

		}
		/* 获得会议室的列表，及其设备信息 */
		function getRoomInfo(ele) {
			$(ele).empty();
			$.ajax({
				url : "${APP_PATH }/room_book_info",
				type : "GET",
				async:false,
				success : function(result) {
					console.log("会议室");	
					console.log(result);
					room_info_result = result;
					var index = 0;
					$.each(result.extend.lists, function(index, item) {
						var optionEle = $("<option></option>").append(
								item.roomName).attr("value", item.roomName)
								.attr("ddd", index).appendTo(ele);
						index = index + 1;
					});
					//alert(item[0].roomAddress);
				}
			});
			showRoomInfo(ele);
			//添加选择框失去焦点时显示会议室信息
			$(ele).blur(function() {
				showRoomInfo(ele);
			});	
		}
		/* 展示房间信息 */
		function showRoomInfo(ele) {
			var ind =$(ele).find("option:selected").attr("ddd");
			$.each(room_info_result.extend.lists,function(index, item) {
					if (index == ind) {
						$("#edit_book_address_span").text( "位置："+item.roomAddress);
						$("#edit_book_max_num_span").text("最多人数："+ item.roomMaxNum);
						// $("#book_max_num_address_span").append("位置："+item.roomAddress+"&emsp;&emsp;"+
						// 	"可容纳人数："+item.roomMaxNum);
						$("#edit_book_equip_span").text("已有设备："+ item.roomEquipment);
				}
			});
		}
		/* 弹出主题信息显示框 */
		 $("#showTheme").popover({
			  html : true,    
			   title: "会议主题：",  
			  content: function() {  
				 console.log("aa");
			 return bookResult.extend.pageInfo.list[$(this).attr("index")].preTheme; 
			 			}
			 		  });
		/* 让多余的字显示、、、、 */
		function formateWordNum() {
			 if ($(this).text().length > 20) {
			        $(this).html($(this).text().replace(/\s+/g, "").substr(0, 20) + "...")
			    }
		}
		
		/* 查看详细人员列表按钮点击事件处理 */	
		$(document).on("click","#show_people",function(){
			var index = $(this).attr("index");
			console.log(bookResult);
			console.log(index);	
			console.log("查看详细人员列表按钮点击事件处理");
			var num = bookResult.extend.pageInfo.list[index].serialNum;
			console.log(num);
			showAllPeopel(num,1)
		});
		/* 获得详细人员 */
		function showAllPeopel(num ,pn){
			apn = pn;
			console.log("showAllPeopel");
			anum = num;
			aflage = 2;
			tbodyid = "info_root_people";
			var mydata = num+"_"+pn;
			console.log("mydata:"+mydata);
			$.ajax({
				url : "${APP_PATH }/f/my/showPeople",
				type : "GET",
				data :"mydata="+mydata,
				async:false,
				success : function(result) {
					apeople =result;
					console.log("获得人员列表数据");
					console.log(result);
					if(result.code==100){
						exdata_peopel(result);
	 					//2、解析显示分页信息
						build_page_info(result);
						//3、解析显示分条数据
						build_page_nav(result);
					}else{
						alert("未查找到相关数据");
					}
				}
			});
		}
		/* 解析数据 */
		function exdata_peopel(result){
			addTableHead();
			var lists = result.extend.pageInfo.list;			
			$.each(lists,function(index,item){
				var Htmls = "<td><img src='"+item.peoImagePath+"' style='margin:0px;padding:0px;height:22px;'></td>"
				Htmls+="<td>"+item.peoEmployeeName+"</td><td>"+item.peoPost+"</td><td>"+result.extend.applyInfo[index]+"</td>";
				Htmls+="<td><button class='btn btn-danger btn-sm' id='outBtn' index="+
						index+"><span class='glyphicon glyphicon-pencil'></span>踢出</button></td>";
				document.getElementById(tbodyid).innerHTML=Htmls;
				});
			}
		/* 顶部导航条跳转 */
		function jumpPage(op) {
			if(op==1){
				aflage = 1;
				tbodyid="info_root";
				init_down_list(apn);
			}else{
				//$("#panel-283108").empty();
				showAllPeopel(anum ,apn);
			}
		}
		/* 踢出事件 */
		$(document).on("click","#outBtn",function(){
			console.log("踢出事件");
			var index = $(this).attr("index");
			var lists = apeople.extend.pageInfo.list;
			var mydata = lists[index].peoEmployeeId+"_"+anum;
			console.log(mydata);
			BootstrapDialog.show({  
	            title: '警告',  
	            message: "确认将"+lists[index].peoEmployeeName+"踢出该会议？？？",  
	            buttons: [{  
	                label: '取消',  
	                action: function(dialog) {  
	                    dialog.close();
	                }  
	            }, {  
	                label: '确认',  
	                action: function(dialog) { 
	                	$.ajax({
	                		url:"${APP_PATH }/f/my/deletePeople",
	                		data:"mydata="+mydata,
	                		success:function(result){
	                			if(result.code==100){
	                				dialog.close();
	                				$("#"+tbodyid).empty();
	                				showAllPeopel(anum,apn);
	                			}
	                			else{
	                				alert("删除失败");
	                			}
	                		}
	                	}) ;
	                }  
	            }]  
	        });
		});
			</script>
</body>
</html>