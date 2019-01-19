<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>列表</title>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<!-- 以/开始的，找资源，以服务器的路径为基准 -->
<script type="text/javascript"
	src="${APP_PATH }/static/js/jquery-1.11.3.min.js"></script>
<link href="${APP_PATH }/static/bootstrap-3.3.5-dist/css/bootstrap.min.css"
	rel="stylesheet">
<script type="text/javascript"
	src="${APP_PATH }/static/bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>

</head>
<body>

	<!-- 添加模态框 -->
	<div class="modal fade" id="empAddModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="myModalLabel">员工添加</h4>
	      </div>
	      <!-- 表单体   	name值和bean中一致-->
	      <div class="modal-body">
	        	<form class="form-horizontal">
					  <div class="form-group">
					    <label class="col-sm-2 control-label">empname</label>
					    <div class="col-sm-10">
					      <input type="text" name="empName" class="form-control" id="empName_add_input" placeholder="empName">
					       <span class="help-block"></span>
					    </div>
					  </div>
					  
					   <div class="form-group">
					    <label class="col-sm-2 control-label">empemail</label>
					    <div class="col-sm-10">
					      <input type="text" name="email" class="form-control" id="email_add_input" placeholder="email@atguigu.com">
					      <span class="help-block"></span>
					    </div>
					  </div>
					  
					  <div class="form-group">
					    <label class="col-sm-2 control-label">gender</label>
					    <div class="col-sm-10">
							<label class="radio-inline">
							  <input type="radio" name="gender" id="gender1_add_input" value="M" checked="checked"> 男
							</label>
							<label class="radio-inline">
							  <input type="radio" name="gender" id="gender2_add_input" value="F"> 女
							</label>
					    </div>
					  </div>
					  
					  <div class="form-group">
					    <label class="col-sm-2 control-label">部门</label>
					    <div class="col-sm-4">
					    	<!-- 下拉列表，name直接写did -->
							  <select class="form-control" name="dId" id="dept_add_select">
								</select>
					    </div>
					  </div>
					</form>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
	        <button type="button" class="btn btn-primary" id="emp_add_save_btn">保存</button>
	      </div>
	    </div>
	  </div>
	</div>
	<!-- 修改模态框 -->
	<div class="modal fade" id="empUpdateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="myModalLabel">员工添加</h4>
	      </div>
	      <!-- 表单体   	name值和bean中一致-->
	      <div class="modal-body">
	        	<form class="form-horizontal">
					  <div class="form-group">
					    <label class="col-sm-2 control-label">empname</label>
					    <div class="col-sm-10">
					     <p class="form-control-static" id="empName_update_static"></p>
					    </div>
					  </div>
					  
					   <div class="form-group">
					    <label class="col-sm-2 control-label">empemail</label>
					    <div class="col-sm-10">
					      <input type="text" name="email" class="form-control" id="email_update_input" placeholder="email@atguigu.com">
					      <span class="help-block"></span>
					    </div>
					  </div>
					  
					  <div class="form-group">
					    <label class="col-sm-2 control-label">gender</label>
					    <div class="col-sm-10">
							<label class="radio-inline">
							  <input type="radio" name="gender" id="gender1_update_input" value="M" checked="checked"> 男
							</label>
							<label class="radio-inline">
							  <input type="radio" name="gender" id="gender2_update_input" value="F"> 女
							</label>
					    </div>
					  </div>
					  
					  <div class="form-group">
					    <label class="col-sm-2 control-label">部门</label>
					    <div class="col-sm-4">
					    	<!-- 下拉列表，name直接写did -->
							  <select class="form-control" name="dId" id="dept_add_select">
								</select>
					    </div>
					  </div>
					</form>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
	        <button type="button" class="btn btn-primary" id="emp_update_save_btn">更新</button>
	      </div>
	    </div>
	  </div>
	</div>
	<!-- 搭建显示页面 -->

	<div class="container">
		<!-- 标题 -->
		<div class="row">
			<div class="col-md-12">
				<h1>CRUD</h1>
			</div>
		</div>
		<!-- 按钮 -->
		<div class="row">
			<div class="col-md-4 col-md-offset-8">
				<button class="btn btn-primary btn-sm" id="emp_add_modal_btn">新增</button>
				<button class="btn btn-danger btn-sm">删除</button>
			</div>
		</div>
		<!-- 表格 -->
		<div class="row">
			<div class="col-md-12">
				<table class="table table-hover" id="emps_table">
					<thead>
						<tr>
							<th>#</th>
							<th>empname</th>
							<th>gender</th>
							<th>email</th>
							<th>departname</th>
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
			<div class="col-md-6" id="page_info_area">			</div>
			<!-- 分页条 -->
			<div class="col-md-6" id="page_nav_area">
				
			</div>
		</div>
	</div>

	<script type="text/javascript">
		//页面加载完成，ajax请求，获得数据
		var totalRecord;
		
		to_page(2);
		//ajax 跳转页面的
		function to_page(pn) {
			$(function(){
				$.ajax({
					url:"${APP_PATH}/empsWithJson",
					data:"pn="+pn,
					type:"GET",
					success:function(result){
						//console.log(result);
						//1、解析显示员工数据
						build_emps_table(result);
						//2、解析显示分页信息
						build_page_info(result);
						//3、解析显示分条数据
						build_page_nav(result);
					}
				})
			});
		}
		//表格
		function build_emps_table(result){
			//首先清空数据
			$("#emps_table tbody").empty();
			var emps=result.extend.pageInfo.list;
			$.each(emps,function(index,item){	//遍历员工
				var empTd=$("<td></td>").append(item.empId);
				var empNameTd=$("<td></td>").append(item.empName);
				var genderTd=$("<td></td>").append(item.gender=='M'?"男":"女");
				var emailTd=$("<td></td>").append(item.email);
				var deptNameTd=$("<td></td>").append(item.department.deptName);
				/* <button class="btn btn-primary btn-sm">
								<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
								修改
							</button> */
				var editBtn=$("<button></button>")
					.addClass("btn btn-primary btn-sm edit_btn")
					.append($("<span></span>").addClass("glyphicon glyphicon-pencil"))
					.append("编辑");		
				//为button添加自定义属性保存员工id 	 
				editBtn.attr("edit_id",item.empId);
				var deleteBtn=$("<button></button>")
					.addClass("btn btn-danger btn-sm delete_btn")
					.append($("<span></span>").addClass("glyphicon glyphicon-trash"))
					.append("删除");	 
				var butTd=$("<td></td>").append(editBtn).append(" ").append(deleteBtn);
				$("<tr></tr>").append(empTd).append(empNameTd)
					.append(genderTd).append(emailTd).append(deptNameTd)
					.append(butTd) 
					.appendTo("#emps_table tbody");
				
			});
		}
		//分页信息
		function build_page_info(result){
			$("#page_info_area").empty();
			$("#page_info_area").append("当前第"+result.extend.pageInfo.pageNum+
					"页，总共"+result.extend.pageInfo.pages+
					"，总共"+result.extend.pageInfo.total	+"记录数");
			totalRecord = result.extend.pageInfo.pages;
		}
		//分页条
		function build_page_nav(result){
			$("#page_nav_area").empty();
			
			var ul=$("<ul></ul>").addClass("pagination");
			var firstPageLi =$("<li></li>").append($("<a></a>").append("首页").attr("href","#"));		
			var prePageLi =$("<li></li>").append($("<a></a>").append("&laquo;").attr("href","#"));
			if(result.extend.pageInfo.hasPreviousPage==false){
				firstPageLi.addClass("disabled");
				prePageLi.addClass("disabled");
			}
			else{
				//添加翻页事件
				firstPageLi.click(function () {
					to_page(1);
				});
				prePageLi.click(function () {
					to_page(result.extend.pageInfo.pageNum-1);
				});
			}
			var nextPageLi =$("<li></li>").append($("<a></a>").append("&raquo;").attr("href","#"));
			var lastPageLi =$("<li></li>").append($("<a></a>").append("末页").attr("href","#"));	
			ul.append(firstPageLi).append(prePageLi);
			if(result.extend.pageInfo.hasNextPage==false){
				nextPageLi.addClass("disabled");
				lastPageLi.addClass("disabled");
			}
			else{
				//分页事件
				nextPageLi.click(function () {
					to_page(result.extend.pageInfo.pageNum+1);
				});
				lastPageLi.click(function () {
					to_page(result.extend.pageInfo.pages);
				});
			}
			
			$.each(result.extend.pageInfo.navigatepageNums,function(index,item){
				var numLi=$("<li></li>").append($("<a></a>").append(item));
				if(result.extend.pageInfo.pageNum==item){
						numLi.addClass("active");
				}
				numLi.click(function () {
					to_page(item);
				});
				ul.append(numLi);
			});
			ul.append(nextPageLi).append(lastPageLi);
			var navEle=$("<nav></nav>").append(ul)
						.appendTo("#page_nav_area");
		}
		/* 表单完整重置 */
		function reset_form(ele) {
			//清楚上一次的表数据
			$(ele)[0].reset();
			//清空样式
			$(ele).find("*").removeClass("has-success has-error");
			$(ele).find(".help-block").empty();
			$("#dept_add_select").empty();
		}
		/* 点击新增添加模态框 */
		$("#emp_add_modal_btn").click(function () {
			reset_form("#empAddModal form");
			//ajax请求数据
			getDepts("#dept_add_select");
			//弹出
			$("#empAddModal").modal({
				backdrop:'static'
			});
		});
		//查出所有的部门信息保存到下拉列表中
		function getDepts(ele) {
			$(ele).empty();
			$.ajax({
				url:"${APP_PATH}/depts",
				type:"GET",
				success:function(result){
					//console.log(result);
					$.each(result.extend.depts,function(index,item){
						var optionEle=$("<option></option>").append(item.deptName)
						.attr("value",item.deptId)
						.appendTo(ele);
					});
				}
			});
		}
		//显示输入框的错误信息
		function show_validate_msg(ele,status,msg) {
			//清空元素的以前的class值
			$(ele).parent().removeClass("has-success has-error");
			$(ele).next("span").text("");
			if(status=="success"){
				$(ele).parent().addClass("has-success");
				$(ele).next("span").text(msg);
			}else if(status=="error"){
				$(ele).parent().addClass("has-error");
				$(ele).next("span").text(msg);
			}
		}
		//1、校验数据,,正则表达式
		function validate_add_form() {
			//校验用户名
			var empName=$("#empName_add_input").val();
			var regName=/(^[a-zA-Z0-9_-]{6,16}$)|(^[\u2E80-\u9FFF]{2,5})/;
			if(!regName.test(empName)){
				show_validate_msg("#empName_add_input","error","用户名是2-5位中文或者是6-16的字母数字");
				return false;
			} 
			else{
				show_validate_msg("#empName_add_input","success","");
			}
			 //校验邮箱
			var email=$("#email_add_input").val();
			var regEmail=/^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
			if(!regEmail.test(email)){
				show_validate_msg("#email_add_input","error","邮箱格式不正确");
				return false;
			} 
			else{
				show_validate_msg("#email_add_input","success","");
			}
			return true;
		}
		//校验用户名是否可用, ajax
		$("#empName_add_input").change(function () {
			$.ajax({
				url:"${APP_PATH}/checkUser",
				data:"empName="+this.value,
				type:"POST",
				success:function(result){
					if(result.code==100){
						show_validate_msg("#empName_add_input","success","用户名可用");
						$("#emp_add_save_btn").attr("ajax_va","true");	//给but自定义属性用来保存数据
					}else{
						show_validate_msg("#empName_add_input","error",result.extend.va_msg);
						$("#emp_add_save_btn").attr("ajax_va","error");
					}
				}
			});
		});
		//模态框里保存数据员工
		$("#emp_add_save_btn").click(function () {
			//1、校验数据,,正则表达式
			if(validate_add_form()&&$(this).attr("ajax_va")!="error"){
				//ajax保存	
				$.ajax({
					url:"${APP_PATH}/emps",
					type:"post",
					data:$("#empAddModal form").serialize(),
					success:function(result){
						if(result.code==100){
							//保存成功之后，1、关闭模态框，2、跳到最后一页
							$("#empAddModal").modal('hide');
							//to_page(9999);			//pagehelper参数合理化了，超出页面数字的请求，默认显示最后的页面
							to_page(totalRecord+1);
						}else{
							if(result.extend.errorFields.email!=undefined){
								//有邮箱错误
								show_validate_msg("#email_add_input","error",result.extend.errorFields.email);
							}
							if(result.extend.errorFields.empName!=undefined){
								//有用户名错误
								show_validate_msg("#empName_add_input","error",result.extend.errorFields.empName);
							}
						}
					}
				});
				//jquery方法,自动序列化表单里数据		key=value&key=value&key=value
				//$("#empAddModal form").serialize();
			}
		});
		
		//需要在按钮创建之后绑定事件
		$(document).on("click",".edit_btn",function () {
			getDepts("#empUpdateModal select");
			getEmp($(this).attr("edit_id"));
			//把员工id传递给模态框的更新按钮
			$("emp_update_save_btn").attr("edit_id",$(this).attr("edit_id"));
			$("#empUpdateModal").modal({
				backdrop:"static"
			});
		});
		function getEmp(id) {
			$.ajax({
				url:"${APP_PATH}/emps/"+id,
				type:"GET",
				success:function(result){
					var empData=result.extend.emp;
					$("#empName_update_static").text(empData.empName);
					$("#email_update_input").val(empData.email);
					$("#empUpdateModal input[name=gender]").val([empData.gender]);
					$("#empUpdateModal select").val([empData.dId]);
				}
			});
		}
		$("#emp_update_save_btn").click(function () {
			//验证邮箱
			
			var email=$("#email_update_input").val();
			var regEmail=/^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
			if(!regEmail.test(email)){
				show_validate_msg("#email_update_input","error","邮箱格式不正确");
				return false;
			} 
			else{
				show_validate_msg("#email_update_input","success","");
			}
			//发送ajax	保存
			
			$.ajax({
				url:"${APP_PATH}/empss/"+$(this).attr("edit_id"),
				type:"POST",
				data:$("#empUpdateModal form").serialize()+"&_method=PUT",
				success:function(result){
					alert(result.msg);
				}
			})
		});
	</script>
</body>
</html>