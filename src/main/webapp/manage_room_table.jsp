<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>列表</title>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<!-- 以/开始的，找资源，以服务器的路径为基准 -->
<script type="text/javascript"
	src="${APP_PATH }/static/js/jquery-1.11.3.min.js"></script>
<link
	href="${APP_PATH }/static/bootstrap-3.3.5-dist/css/bootstrap.min.css"
	rel="stylesheet">

<link href="https://cdn.bootcss.com/bootstrap3-dialog/1.34.9/css/bootstrap-dialog.min.css" rel="stylesheet">
<script type="text/javascript"
	src="${APP_PATH }/static/bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap3-dialog/1.34.9/js/bootstrap-dialog.min.js"></script>

</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">会议室预定</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li><a href="${APP_PATH }/manage_people_table.jsp">预定管理 <span class="sr-only">(current)</span></a></li>
                <li><a href="${APP_PATH }/manage_people_table.jsp">人员管理</a></li>
                <li class="active"><a href="#">会议室管理</a></li>
                <li><a href="${APP_PATH }/manage_manage_people_table.jsp">管理员</a></li>


            </ul>

            <ul class="nav navbar-nav navbar-right">
                <li><a href="#">Link</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">登陆者<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">管理员</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="#">其他信息</a></li>
                    </ul>
                </li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
	<!-- 编辑模态框 -->
	<div class="modal fade" id="roomEditModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
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
					<form class="form-horizontal">
						<div class="form-group" id="book_people_id_addhelp-block">
							<label class="col-sm-2 control-label" >会议室</label>
							<div class="col-sm-6">
								<input type="text" name="roomName" class="form-control"
									id="room_name_add" placeholder="2106010312"> 
								<span id="people_name_model_span"></span>
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-2 control-label">会议室地址</label>
							<div class="col-sm-6">
								<input type="text" name="roomAddress" class="form-control"
									id="roomAddress" placeholder="2106010312"> 
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-2 control-label">最大人数</label>
							<div class="col-sm-10">
								<input type="number" name="roomMaxNum" class="form-control"
									id="roomMaxNum" placeholder=""> <span
									class="help-block"></span>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">设备信息</label>
							<div class="col-sm-10">
								<input type="text" name="roomEquipment" class="form-control"
									id="roomEquipment" placeholder="2016-02-02">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">备注信息</label>
							<div class="col-sm-10">
								<input type="textarea" name="roomOther" class="form-control"
									id="roomOther" placeholder="在此处填写其它相关说明信息">
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
	<div class="modal fade" id="roomAddModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">会议室添加</h4>
				</div>
				<!-- 表单体   	name值和bean中一致-->
				<div class="modal-body">
					<form class="form-horizontal">
						<div class="form-group" id="book_people_id_addhelp-block">
							<label class="col-sm-2 control-label" >会议室</label>
							<div class="col-sm-6">
								<input type="text" name="roomName" class="form-control"
									id="room_name_add" placeholder="2106010312"> 
								<span id="people_name_model_span"></span>
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-2 control-label">会议室地址</label>
							<div class="col-sm-6">
								<input type="text" name="roomAddress" class="form-control"
									id="roomAddress" placeholder="2106010312"> 
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-2 control-label">最大人数</label>
							<div class="col-sm-10">
								<input type="number" name="roomMaxNum" class="form-control"
									id="roomMaxNum" placeholder=""> <span
									class="help-block"></span>
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-2 control-label">设备信息</label>
							<div class="col-sm-10">
								<input type="text" name="roomEquipment" class="form-control"
									id="roomEquipment" placeholder="2016-02-02">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">备注信息</label>
							<div class="col-sm-10">
								<input type="textarea" name="roomOther" class="form-control"
									id="roomOther" placeholder="在此处填写其它相关说明信息">
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
	
	<!-- 搭建显示页面 -->
	<div class="container">
		<!-- 标题 -->
		<div class="row">
			<div class="col-md-8">
				<h3>会议室管理</h3>
			</div>
			<div class="col-md-4">
				<h3>会议室管理</h3>
			</div>
		</div>
		<!-- 按钮 -->
		<div class="row">
			<div class="col-md-4 col-md-offset-8">
				<button class="btn btn-primary btn-sm" id="book_add_modal_btn">新增</button>
				<button class="btn btn-danger btn-sm" id="delete_checked_btn">删除</button>
			</div>
		</div>
		<!-- 表格 -->
		<div class="row">
			<div class="col-md-12">
				<table class="table table-hover" id="book_table">
					<thead>
						<tr>
							<th><input type="checkbox" id="select_all"/></th>
							<th>序号</th>
							<th>会议室</th>
							<th>会议室地址</th>
							<th>最大人数</th>
							<th>设备</th>
							<th>其它</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>

					</tbody>
				</table>
			</div>
		</div>
		<!-- 分页信息 -->
		<div class="row">
			<!-- 文字信息 -->
			<div class="col-md-6" id="page_info_area"></div>
			<!-- 分页条 -->
			<div class="col-md-6" id="page_nav_area"></div>
		</div>
	</div>
</body>
<script type="text/javascript">
//页面加载完成，ajax请求，获得数据
var totalRecord;
var pageNum=0;//记录当前页面
var room_info_result;
to_page(1);
//ajax 跳转页面的
function to_page(pn) {
	pageNum=pn;
	$(function() {
		$.ajax({
			url : "${APP_PATH }/room/manage/table",
			data : "pn=" + pn,
			type : "GET",
			success : function(result) {
				if(result.code==100){
					//1、解析显示员工数据
					build_book_table(result);
					//2、解析显示分页信息
					build_page_info(result);
					//3、解析显示分条数据
					build_page_nav(result);
				}
				else{
					 var p= result.extend.path;
						// alert(p);
					 window.location.href = "${APP_PATH}"+p;
				}
			}
		})
	});
}
/* 1、解析显示员工数据 */
function build_book_table(result) {
	//首先清空数据
	$("#book_table tbody").empty();
	var books = result.extend.pageInfos.list;
	$.each(books, function(index, item) { 
		var checkBox=$("<td></td>")
			.append("<input type='checkbox' class='check_item' style='margin-right:0px;'/>");
		//遍历预定记录，获取
		var roomNumTd = $("<td id='2'></td>").append(item.roomNum);
		var roomNameTd = $("<td></td>").append(item.roomName);
		var roomAddressTd = $("<td></td>").append(item.roomAddress);
		var roomMaxNumTd = $("<td></td>").append(
				item.roomMaxNum);
		var roomEquipmentTd = $("<td></td>").append(item.roomEquipment);
		var roomOtherTd = $("<td></td>").append(item.roomOther);
		/* <button class="btn btn-primary btn-sm">
						<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
						修改
					</button> */
		var editBtn = $("<button></button>").addClass(
				"btn btn-primary btn-sm edit_btn")
				.attr("index",item.roomNum).attr("id","table_edit_btn")
				.append($("<span></span>").addClass("glyphicon glyphicon-pencil")).append("编辑");
					
		//为button添加自定义属性保存员工id 	 
		editBtn.attr("edit_id", item.empId);
		var deleteBtn = $("<button></button>").addClass("btn btn-danger btn-sm delete_btn")
				.attr("index",item.roomNum).attr("id","table_delete_btn")
				.append($("<span></span>").addClass("glyphicon glyphicon-trash")).append("删除");
		var butTd = $("<td></td>").append(editBtn).append(" ").append(
				deleteBtn);
		$("<tr></tr>").append(checkBox).append(roomNumTd).append(roomNameTd).append(
				roomAddressTd).append(roomMaxNumTd).append(roomEquipmentTd)
				.append(roomOtherTd).append(butTd).appendTo("#book_table tbody");

	});
}
/* 2、解析显示分页信息 */
function build_page_info(result) {
	$("#page_info_area").empty();
	$("#page_info_area").append(
			"当前第" + result.extend.pageInfos.pageNum + "页，总共"
					+ result.extend.pageInfos.pages + "，总共"
					+ result.extend.pageInfos.total + "记录数");
	totalRecord = result.extend.pageInfos.pages;
}
/* 3、解析显示分条数据 */
function build_page_nav(result) {
	$("#page_nav_area").empty();

	var ul = $("<ul></ul>").addClass("pagination");
	var firstPageLi = $("<li></li>").append(
			$("<a></a>").append("首页").attr("href", "#"));
	var prePageLi = $("<li></li>").append(
			$("<a></a>").append("&laquo;").attr("href", "#"));
	if (result.extend.pageInfos.hasPreviousPage == false) {
		firstPageLi.addClass("disabled");
		prePageLi.addClass("disabled");
	} else {
		//添加翻页事件
		firstPageLi.click(function() {
			to_page(1);
		});
		prePageLi.click(function() {
			to_page(result.extend.pageInfos.pageNum - 1);
		});
	}
	var nextPageLi = $("<li></li>").append(
			$("<a></a>").append("&raquo;").attr("href", "#"));
	var lastPageLi = $("<li></li>").append(
			$("<a></a>").append("末页").attr("href", "#"));
	ul.append(firstPageLi).append(prePageLi);
	if (result.extend.pageInfos.hasNextPage == false) {
		nextPageLi.addClass("disabled");
		lastPageLi.addClass("disabled");
	} else {
		//分页事件
		nextPageLi.click(function() {
			to_page(result.extend.pageInfos.pageNum + 1);
		});
		lastPageLi.click(function() {
			to_page(result.extend.pageInfos.pages+1);
		});
	}

	$.each(result.extend.pageInfos.navigatepageNums, function(index,
			item) {
		var numLi = $("<li></li>").append($("<a></a>").append(item));
		if (result.extend.pageInfos.pageNum == item) {
			numLi.addClass("active");
		}
		numLi.click(function() {
			to_page(item);
		});
		ul.append(numLi);
	});
	ul.append(nextPageLi).append(lastPageLi);
	var navEle = $("<nav></nav>").append(ul).appendTo("#page_nav_area");
	}
	/* 点击新增添加模态框 */
	$("#book_add_modal_btn").click(function() {
		reset_form("#roomAddModal form");
		//ajax请求数据
		//getRoomInfo("#book_room_add_select");
		//弹出
		$("#roomAddModal").modal({
			backdrop : 'static'
		});
	});
	/* 清除模态框数据 */
	function reset_form(ele) {
		//清楚上一次的表数据
		//$(ele).reset();
		//清空样式
		$(ele).find("*").removeClass("has-success has-error");
		$(ele).find("span").text("");
	}
	//模态框里保存预定记录
	$("#book_add_save_btn").click(function() {
		//1、校验数据,,正则表达式
		
		//ajax保存	
		$.ajax({
			url : "${APP_PATH }/room/manage/save",
			type : "post",
			data : $("#roomAddModal form").serialize(),
			success : function(result) {
				if (result.code == 100) {
					//保存成功之后，1、关闭模态框，2、跳到最后一页
					$("#roomAddModal").modal('hide');
					to_page(totalRecord + 1);
				} else {
					alert("保存失败！");
				}
			}
		});
	});
	/* 点击编辑添加模态框 */
	//需要在按钮创建之后绑定事件
	$(document).on("click","#table_edit_btn",function () {
		reset_form("#roomEditModal form");
		//getRoomInfo("#book_room_edit_select");
		//把员工id传递给模态框的更新按钮
		
		$("#book_edit_save_btn").attr("edit_id",$(this).attr("index"));
		$("#roomEditModal").modal({
			backdrop:"static"
		});
		//获取数据回显
		$.ajax({
			url : "${APP_PATH }/room/manage/reback",
			type : "get",
			data:"num="+$(this).attr("index"),
			success:function(results){
				if(results.code==100){
					  document.getElementById('room_name_add').value=parseInt(results.extend.book.roomName);
					document.getElementById('roomAddress').value=results.extend.book.roomAddress;
					document.getElementById('roomMaxNum').value=parseInt(results.extend.book.roomMaxNum);
					document.getElementById('roomEquipment').value=results.extend.book.roomEquipment;
					document.getElementById('roomOther').value=results.extend.book.roomOther;
				 
					 
				}
				else{
					alert("数据回显失败");
				}
			}
		});
		/* 保存跟新 */
		$("#book_edit_save_btn").click(function () {
			$.ajax({
				url:"${APP_PATH}/room/manage/update/",
				type:"POST",
				data:"roomNum="+$(this).attr("edit_id")+"&"+$("#roomEditModal form").serialize(),
				success:function(results){
					alert(results.msg);
					$("#roomEditModal").modal('hide');
					to_page(pageNum);
				},
			});
		});
	});
	/* 显示表里的删除按钮事件绑定 */
	$(document).on("click","#table_delete_btn",function () {
		var index=$(this).attr("index");
		BootstrapDialog.show({  
            title: '警告',  
            message: '确认删除该条记录？？？',  
            buttons: [{  
                label: '取消',  
                action: function(dialog) {  
                    
                    dialog.close();
                }  
            }, {  
                label: '确认',  
                action: function(dialog) { 
                	$.ajax({
                		url:"${APP_PATH }/room/manage/delete/"+index,
                		type: "get" ,
                		//data:"deleteNum="+index,
                		success:function(result){
                			if(result.code==100){
                				alert("删除成功");
                				dialog.close();
                				to_page(pageNum);
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
	/* 完成全选/全不选 */
	$("#select_all").click(function () {
		//attr和prop区别
		$(".check_item").prop("checked",$(this).prop("checked"));
		
	});
	/* 单个checkbox绑定事件 */
	$(document).on("click",".check_item",function(){
		//选择checked的个数，，总的check_item个数
		var checkedNum= $(".check_item:checked").length;
		var allnum = $(".check_item").length;
		$("#select_all").prop("checked",checkedNum==allnum);
	});
	/* 点击全部删除 */
	$("#delete_checked_btn").click(function () {
		BootstrapDialog.show({  
            title: '警告',  
            message: '确认删除多条记录吗？？？',  
            buttons: [{  
                label: '取消',  
                action: function(dialog) {  
                    dialog.close();
                }  
            }, {  
                label: '确认',  
                action: function(dialog) { 
                	var deleteNum="";
        			
        			$.each($(".check_item:checked"),function (index,item){
        				
        				deleteNum+=$(this).parents("tr").find("td:eq(1)").text()+"-";
        			});
        			deleteNum=deleteNum.substring(0,deleteNum.length-1);
        			
        			$.ajax({
        				url:"${APP_PATH }/room/manage/delete/"+deleteNum,
        				type:"DELETE",
        				success:function(result){
        					dialog.close();
        					alert(result.msg);
        					//回到当前页面
        					to_page(pageNum);
        				}
        			});
                }  
            }]  
        });
		
	});
	
</script>
</html>