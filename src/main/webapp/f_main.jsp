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
<link href="https://cdn.bootcss.com/bootstrap3-dialog/1.34.9/css/bootstrap-dialog.min.css" rel="stylesheet">
<link
	href="${APP_PATH }/static/css/my_f_main.css" rel="stylesheet">
<script type="text/javascript"
	src="${APP_PATH }/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap3-dialog/1.34.9/js/bootstrap-dialog.min.js"></script>
<script type="text/javascript"
	src="${APP_PATH }/static/js/util.js"></script>
</head>
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
					<form class="form-horizontal">
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
							<div class="col-sm-10">
								<input type="text" name="preTheme" class="form-control"
									id="book_theme_add" placeholder="填写会议的主题"> <span
									class="help-block"></span>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">备注信息</label>
							<div class="col-sm-10">
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
							<div class="col-sm-10">
								<input type="file" name="other" class="form-control"	 accept="image/*"
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

<div class="container">
	<div id="tables"class="rol">
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
		<button type="button" id="submit" class="btn btn-default btn-lg">提交</button>
		<button type="button" id="clearBtn" class="btn btn-default btn-lg">清除</button>
</div>
<script type="text/javascript">
	var sindexMins=0;
	var sindexMaxs=0;	
	var pre_time=[];		//暂存选择的 时间段
	var pre_room_name="m";	//暂存选择的 会议室
	var roomInfo = [];		//暂存从后台中过来的会议室信息
	//获取系统当前时间
	var date = new Date();
	var year = date.getFullYear();
	var month = (date.getMonth() + 1);
	var day = date.getDate();
	if(month<10){
		month= "0"+month;
	}
	if(day<10){
		day="0"+day;
	}
	var date_id = year + "-" + month + "-" + day+" 00:00:00";
	var now_date_unit = year+"年"+month+"月"+day+"日";
	
	//alert(date_id);
	init();
	/* 页面进入入口 */
	function init() {
		//$("[index]").empty();
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
					alert(result.extend.msg);
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
					alert("获取数据失败");
					alert(result.extend.msg);
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
			td.appendTo($("tbody"));
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
								alert("不允许中间隔着选择a");
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
								alert("不允许中间隔着选择b");
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
			alert(sindexMins+"-"+sindexMaxs);
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
		alert("DDD");
		console.log("sindexMins"+sindexMins+"sindexMaxs"+sindexMaxs);	
		var cons_input="prePeopleId="+document.getElementById("book_people_id_add").value+
			"&preRoomNum="+encodeURI(pre_room_name)+"&preTheme="+encodeURI(document.getElementById("book_theme_add").value)
			+"&preDay="+date_id+"&preStartTime="+encodeURI(pre_time[sindexMins])+
			"&preEndTime="+encodeURI(pre_time[sindexMaxs])+"&other="+encodeURI(document.getElementById("book_other_add").value)
			alert(cons_input);
		//ajax保存	
		$.ajax({
			url : "${APP_PATH }/f/main/upBook/",
			type : "post",	
			data : cons_input,
			success : function(result) {
				if (result.code == 100) {
					//保存成功之后，1、关闭模态框，2、跳到最后一页
					$("#bookAddModal").modal('hide');
					$("[index]").empty();
					$("[index]").remove();
					//还原暂存信息
					pre_time=[];
					pre_room_name="m";
					init();
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
	// var data="";
	/* $(function() {
		$(".add").eq(0).addClass("on");
		var $iosActionsheet = $('#iosActionsheet');
		var $iosMask = $('#iosMask');
		$iosMask.on('click', hideActionSheet);
		$('#iosActionsheetCancel').on('click', hideActionSheet);
		$(".add").on("click", function() {
			$(this).addClass("on");
		});

		//加号
		$(".course_table td").click(function() {
			$(".add").hide();
			if ($(this).find(".add")) {
				$(this).children(".add").show();
			}
		})

	})
	var week = '';
	var num = '';
	//添加课程
	function add_course(i, n) {
		week = i;
		num = n;
		$('#iosActionsheet').addClass('weui-actionsheet_toggle');
		$('#iosMask').fadeIn(200);

	}
	//隐藏课程
	function hideActionSheet() {
		$('#iosActionsheet').removeClass('weui-actionsheet_toggle');
		$('#iosMask').fadeOut(200);
	}

	//选择课程
	function choice(i) {
		var subject = $("#" + i).html();
		var tdclass = $("#" + i).attr('class');
		var html = $("#" + i).clone().removeAttr('onclick');
		$("#" + week + "_" + num).html(html);
		hideActionSheet();
	} */
</script>
</body>
</html>