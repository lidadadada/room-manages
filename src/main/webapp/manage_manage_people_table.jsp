<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
                <li><a href="${APP_PATH }/manage_book_table.jsp">预定管理 <span class="sr-only">(current)</span></a></li>
                <li><a href="${APP_PATH }/manage_people_table.jsp">人员管理</a></li>
                <li><a href="${APP_PATH }/manage_room_table.jsp">会议室管理</a></li>
                <li class="active"><a href="#">管理员</a></li>
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
							<th>管理员名字</th>
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

</body>
</html>