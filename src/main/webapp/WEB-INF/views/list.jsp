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
	src="${APP_PATH }/static/js/jquery-1.8.3.js"></script>
<script type="text/javascript"
	src="${APP_PATH }/static/bootstrap-3.3.5-dist/js/bootstrap.js"></script>
<link href="${APP_PATH }/static/bootstrap-3.3.5-dist/css/bootstrap.css"
	rel="stylesheet">
</head>
<body>
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
				<button class="btn btn-primary btn-sm">新增</button>
				<button class="btn btn-danger btn-sm">删除</button>
			</div>
		</div>
		<!-- 表格 -->
		<div class="row">
			<div class="col-md-12">
				<table class="table table-hover">
					<tr>
						<th>#</th>
						<th>empname</th>
						<th>gender</th>
						<th>email</th>
						<th>departname</th>
						<th>操作</th>
					</tr>
					<c:forEach items="${pageInfo.list }" var="emp">
					<tr>
						<th>${emp.empId }</th>
						<th>${emp.empName }</th>
						<th>${emp.gender=="M"?"男":"女" }</th>
						<th>${emp.email }</th>
						<th>${emp.department.deptName }</th>
						<th>
							<button class="btn btn-primary btn-sm">
								<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
								修改
							</button>
							<button class="btn btn-danger btn-sm">
								<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
								刪除
							</button>

						</th>
					</tr>
					</c:forEach>
				</table>
			</div>
		</div>
		<!-- 分页信息 -->
		<div class="row">
			<!-- 文字信息 -->
			<div class="col-md-6">
				当前第${pageInfo.pageNum }页，总共${pageInfo.pages }页，总共${pageInfo.total }记录数
			</div>
			<!-- 分页条 -->
			<div class="col-md-6">
				<nav aria-label="Page navigation">
				<ul class="pagination">
					<li><a href="${APP_PATH }/emps?pn=${1 }">首页</a></li>
					
					<c:if test="${pageInfo.hasPreviousPage }">	<!-- 显示上一页 -->
						<li><a href="${APP_PATH }/emps?pn=${pageInfo.pageNum-1 }" aria-label="Previous">
					 		<span aria-hidden="true">&laquo;</span>
							</a>
						</li>
					</c:if>
					
					<!-- 显示页号 	循环显示-->
					<c:forEach items="${pageInfo.navigatepageNums }" var="page_Num">
						<!-- 判断当前页，当前页码强调 -->
						<c:if test="${page_Num==pageInfo.pageNum }">
							<li class="active"><a href="#">${page_Num }</a></li>
						</c:if>
						<c:if test="${page_Num != pageInfo.pageNum }">
							<li><a href="${APP_PATH }/emps?pn=${page_Num }">${page_Num }</a></li>
						</c:if>
						
					</c:forEach>

					<c:if test="${pageInfo.hasNextPage }">
						<li>
							<a href="${APP_PATH }/emps?pn=${pageInfo.pageNum+1 }" aria-label="Next"> 
							<span aria-hidden="true">&raquo;</span>
							</a>
						</li>
					</c:if>
					<li><a href="${APP_PATH }/emps?pn=${pageInfo.pages }">末页</a></li>
				</ul>
				</nav>
			</div>
		</div>
	</div>

</body>
</html>