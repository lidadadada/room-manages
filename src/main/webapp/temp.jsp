<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title>开始使用layui</title>
  <%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
  <link rel="stylesheet" href="${APP_PATH }/static/layui/css/layui.css">
</head>
<body>
 
<!-- 你的HTML代码 -->
 
<%-- <script src="${APP_PATH }/static/layui/layui.js"></script> --%> 
<script src="${APP_PATH }/static/lay/modules/layer.js"></script>
<script>
//一般直接写在一个js文件中
 	   
layer.open({
	  content: '测试回调',
	  yes: function(index, layero){
	    //do something
	    layer.close(index); //如果设定了yes回调，需进行手工关闭
	  }
	});  
</script> 
</body>
</html>