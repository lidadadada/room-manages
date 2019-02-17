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
<script type="text/javascript"
	src="${APP_PATH }/static/js/jquery-1.11.3.min.js"></script>
<link
	href="${APP_PATH }/static/bootstrap-3.3.5-dist/css/bootstrap.min.css"
	rel="stylesheet">
<script type="text/javascript"
	src="${APP_PATH }/static/bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
	
<link rel="stylesheet" href="${APP_PATH }/static/jquery-ui-1.11.4.custom/jquery-ui.css">
  <script src="${APP_PATH }/static/jquery-ui-1.11.4.custom/jquery-ui.js"></script>

 
 <link href="${APP_PATH }/static/css/show_list.css" rel="stylesheet">
<link href="${APP_PATH }/static/css/my_show_list.css" rel="stylesheet">

<script type="text/javascript"
	src="${APP_PATH }/static/js/util.js"></script>

  
  	<script>
  $(function() {
    $( "#accordion" ).accordion({
    	 heightStyle: "content",
    	 collapsible: true
    });
  });
  </script>
</head>
<body>

	
		<div>	
	<ui>
<div id="accordion">
  <div>
  	河（湖）长组织体系建设
  </div>
  <div>
  	河（湖）长组织体系建设
  </div>
  <h2>二、河（湖）长制制度及机制建设情况</h2>
  <div>

  </div>
  <h3>三、河（湖）长履职情况</h3>
  <div>
  		
  </div>
  <h3>四、工作组织推进情况</h3>
  <div>
    	
    </div>
  <h3>五、河湖治理保护及成效</h3>
  <div>
    
  	</div>
  	</div>
  	</ui>
  	</div>
	</body>
	</html>