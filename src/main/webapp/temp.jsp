<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>省级河长制信息统计</title>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<!-- 以/开始的，找资源，以服务器的路径为基准 -->


<link rel="stylesheet" type="text/css" href="${APP_PATH }/static/AlertPlugin/demo.css" />
<link rel="stylesheet" href="${APP_PATH }/static/font/font-awesome-4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="${APP_PATH }/static/AlertPlugin/tooltip-line.css" />
<!--[if IE]>
<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
<![endif]-->
</head>
<body>
	
<!-- 
<link rel="shortcut icon" href="../favicon.ico">
<link rel="stylesheet" type="text/css" href="css/normalize.css" />
<link rel="stylesheet" type="text/css" href="css/demo.css" /> -->

<!--必要样式表-->




<div class="content">

	<div class="dummy dummy-menu">
		<ul>
			<li>
				<a class="tooltip" href="#"><i class="fa fa-fw fa-envelope-o"></i><span class="tooltip-content"><span class="tooltip-text"><span class="tooltip-inner">Howdy, Ben!<br /> There are 13 unread messages in your inbox.</span></span></span></a>
			</li>
		</ul>
	</div>

</div>

</body>
</html>
