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
<!-- 编辑模态框 -->
	<div class="modal fade" id="bookEditModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">编辑信息</h4>
				</div>
				<!-- 表单体   	name值和bean中一致-->
				<div class="modal-body">
					<form class="form-horizontal">
						<div class="form-group" id="edit_book_people_id_addhelp-block">
							<label class="col-sm-2 control-label" >员工号</label>
							<div class="col-sm-6">
								<input type="number" name="peoEmployeeId" class="form-control"
									id="people_people_id_edit"> 
									
								<span id="edit_people_name_model_span"></span>
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-2 control-label">姓名</label>
							<div class="col-sm-6">
								<input type="text" name="peoEmployeeName" class="form-control"
									id="people_name_edit" placeholder=""> <span
									class="help-block"></span>
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-2 control-label">电话</label>
							<div class="col-sm-10">
								<input type="text" name="peoPhone" class="form-control"
									id="people_phone_edit" placeholder=""> <span
									class="help-block"></span>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">职位</label>
							<div class="col-sm-10">
								<input type="text" name="peoPost" class="form-control"
									id="people_post_edit" placeholder=""> <span
									class="help-block"></span>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">住址</label>
							<div class="col-sm-10">
								<input type="text" name="peoAddress" class="form-control"
									id="people_address_edit" placeholder=""> <span
									class="help-block"></span>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">邮箱</label>
							<div class="col-sm-10">
								<input type="text" name="peoEmail" class="form-control"
									id="people_email_edit" placeholder=""> <span
									class="help-block"></span>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">备注</label>
							<div class="col-sm-10">
								<input type="text" name="peoOther" class="form-control"
									id="people_other_edit" placeholder=""> <span
									class="help-block"></span>
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
					<h4 class="modal-title" id="myModalLabel">添加人员</h4>
				</div>
				<!-- 表单体   	name值和bean中一致-->
				<div class="modal-body">
					<form class="form-horizontal">
						<div class="form-group" id="book_people_id_addhelp-block">
							<label class="col-sm-2 control-label" >员工号</label>
							<div class="col-sm-6">
								<input type="number" name="peoEmployeeId" class="form-control"
									id="book_people_id_add" placeholder="2106010312"> 
									
								<span id="people_name_model_span"></span>&nbsp;
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-2 control-label">姓名</label>
							<div class="col-sm-6">
								<input type="text" name="peoEmployeeName" class="form-control"
									id="book_theme_add" placeholder=""> <span
									class="help-block"></span>
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-2 control-label">电话</label>
							<div class="col-sm-10">
								<input type="text" name="peoPhone" class="form-control"
									id="book_theme_add" placeholder=""> <span
									class="help-block"></span>
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-2 control-label">职位</label>
							<div class="col-sm-10">
								<input type="text" name="peoPost" class="form-control"
									id="book_date_add" placeholder="">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">家庭住址</label>
							<div class="col-sm-10">
								<input type="text" name="peoAddress" class="form-control"
									id="book_start_time_add" placeholder="">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">邮箱</label>
							<div class="col-sm-10">
								<input type="text" name="peoEmail" class="form-control"
									id="book_end_time_add" placeholder="">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">备注信息</label>
							<div class="col-sm-10">
								<input type="textarea" name="peoOther" class="form-control"
									id="book_other_add" placeholder="在此处填写其它相关说明信息">
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
                <li ><a href="${APP_PATH }/manage_book_table.jsp">预定管理 <span class="sr-only">(current)</span></a></li>
                <li class="active"><a href="#">人员管理</a></li>
                <li><a href="${APP_PATH }/manage_room_table.jsp">会议室管理</a></li>
                <li><a href="${APP_PATH }/manage_manage_peopel_table.jsp">管理员</a></li>


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
<!-- 搭建显示页面 -->
	<div class="container">
		<!-- 标题 -->
		<div class="row">
			<div class="col-md-8">
				<h3>注册人员管理</h3>
			</div>
			<div class="col-md-4">
				<h3>注册人员管理</h3>
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
							<th>员工号</th>
							<th>姓名</th>
							<th>电话</th>
							<th>职位</th>
							<th>家庭住址</th>
							<th>邮箱</th>
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
	<script type="text/javascript">
	//页面加载完成，ajax请求，获得数据
	var totalRecord;
	var pageNum=0;//记录当前页面
	to_page(1);
	function to_page(pn) {
		pageNum=pn;
		$(function() {
			$.ajax({
				url : "${APP_PATH }/people/manage/tabel",
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
		var books = result.extend.pageInfo.list;
		$.each(books, function(index, item) { 
			var checkBoxin=$("<input type='checkbox' class='check_item' style='margin-right:0px;'/>");
			checkBoxin.attr("index",item.peoSerialNum);
			var checkBox=$("<td></td>")
				.append(checkBoxin);	
			//遍历预定记录，获取
			var empidTd = $("<td></td>").append(item.peoEmployeeId);
			var empnameTd = $("<td></td>").append(item.peoEmployeeName);
			var phoneTd = $("<td></td>").append(item.peoPhone);
			var postTd = $("<td></td>").append(item.peoPost);
			var addressTd = $("<td></td>").append(item.peoAddress);
			var emailTd = $("<td></td>").append(item.peoEmail);
			var otherTd = $("<td></td>").append(item.peoOther);
			/* <button class="btn btn-primary btn-sm">
							<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
							修改
						</button> */
			var editBtn = $("<button></button>").addClass(
					"btn btn-primary btn-sm edit_btn")
					.attr("index",item.peoSerialNum).attr("id","table_edit_btn")
					.append($("<span></span>").addClass("glyphicon glyphicon-pencil")).append("编辑");
						
			//为button添加自定义属性保存员工id 	 
			editBtn.attr("edit_id", item.empId);
			var deleteBtn = $("<button></button>").addClass("btn btn-danger btn-sm delete_btn")
					.attr("index",item.peoSerialNum).attr("id","table_delete_btn")
					.append($("<span></span>").addClass("glyphicon glyphicon-trash")).append("删除");
			var butTd = $("<td></td>").append(editBtn).append(" ").append(
					deleteBtn);
			$("<tr></tr>").append(checkBox).append(empidTd).append(empnameTd).append(
					phoneTd).append(postTd).append(addressTd)
					.append(emailTd).append(otherTd)
					.append(butTd).appendTo("#book_table tbody");

		});
	}
	/* 2、解析显示分页信息 */
	function build_page_info(result) {
		$("#page_info_area").empty();
		$("#page_info_area").append(
				"当前第" + result.extend.pageInfo.pageNum + "页，总共"
						+ result.extend.pageInfo.pages + "，总共"
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
		var navEle = $("<nav></nav>").append(ul).appendTo("#page_nav_area");
	}
	/* 点击新增添加模态框 */
	$("#book_add_modal_btn").click(function() {
		//reset_form("#bookAddModal form");
		//ajax请求数据
		//getRoomInfo("#book_room_add_select");
		//弹出
		
		$("#bookAddModal").modal({
			backdrop : 'static'
		});
	});
	
	/* 点击编辑添加模态框 */
	//需要在按钮创建之后绑定事件
	$(document).on("click","#table_edit_btn",function () {
		//reset_form("#bookEditModal form");
		//getRoomInfo("#book_room_edit_select");
		//把员工id传递给模态框的更新按钮
		$("#book_edit_save_btn").attr("edit_id",$(this).attr("index"));
		$("#bookEditModal").modal({
			backdrop:"static"
		});
		//获取数据回显
		$.ajax({
			url : "${APP_PATH }/people/manage/reback",
			type : "get",
			data:"num="+$(this).attr("index"),
			success:function(results){
				var item= results.extend.peopleInfo;
				 if(results.code==100){
					document.getElementById('people_people_id_edit').value=item.peoEmployeeId;
					document.getElementById('people_name_edit').value=item.peoEmployeeName;
					document.getElementById('people_phone_edit').value=item.peoPhone;
					document.getElementById('people_post_edit').value=item.peoPost;
					document.getElementById('people_address_edit').value=item.peoAddress;
					document.getElementById('people_email_edit').value=item.peoEmail;
					document.getElementById('people_other_edit').value=item.peoOther;
				 }
					else{
						alert("数据回显失败");
					}	
				}
		});
		/* 保存跟新 */
		$("#book_edit_save_btn").click(function () {
			$.ajax({
				url:"${APP_PATH}/people/manage/update/",
				type:"POST",
				data:"peoSerialNum="+$(this).attr("edit_id")+"&"+$("#bookEditModal form").serialize(),
				success:function(results){
					alert(results.msg);
					$("#bookEditModal").modal('hide');
					to_page(pageNum);
				},
			});
		});
	});
	/* 显示表里的删除按钮事件绑定 */
	$(document).on("click","#table_delete_btn",function () {
		var index=$(this).attr("index");
		alert(index);
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
                		url:"${APP_PATH }/people/manage/delete/"+index,
                		type: "DELETE",
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
        				deleteNum+=$(this).attr("index")+"-";
        			});
        			deleteNum=deleteNum.substring(0,deleteNum.length-1);
        			alert(deleteNum);
        			$.ajax({
        				url:"${APP_PATH }/people/manage/delete/"+deleteNum,
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
</body>
</html>