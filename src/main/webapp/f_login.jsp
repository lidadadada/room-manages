<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆</title>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<!-- 以/开始的，找资源，以服务器的路径为基准 -->
<script type="text/javascript"
	src="${APP_PATH }/static/js/jquery-1.11.3.min.js"></script>
<link rel="stylesheet" type="text/css" href="${APP_PATH }/static/bootstrap-3.3.7-dist/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="${APP_PATH }/static/font/font-awesome-4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="${APP_PATH }/static/font/iconic/css/material-design-iconic-font.min.css">
<link rel="stylesheet" type="text/css" href="${APP_PATH }/static/css/util.css">
<link rel="stylesheet" type="text/css" href="${APP_PATH }/static/css/main.css">


</head>
<body>
<div > 
		<div class="container-login100" style="background-image: url('${APP_PATH }/static/images/bg-01.jpg');">
			<div class="wrap-login100 p-l-55 p-r-55 p-t-65 p-b-54">
				<form class="login100-form validate-form">
					<span class="login100-form-title p-b-49">登录</span>

					<div class="wrap-input100 validate-input m-b-23" data-validate="请输入用户名">
						<span class="label-input100">员工号</span>
						<input id="emp_id" class="input100" type="text"  placeholder="请输入员工号" >
						<span class="focus-input100" data-symbol="&#xf206;"></span>
					</div>

					<div class="wrap-input100 validate-input" data-validate="请输入密码">
						<span class="label-input100">密码</span>
						<input id="password" class="input100" type="password"  placeholder="请输入密码">
						
					</div>
					<div class="text-right p-t-8 p-b-31">
						<a href="javascript:">忘记密码？</a>
					</div>

					<div class="container-login100-form-btn">
						<div class="wrap-login100-form-btn">
							<div class="login100-form-bgbtn"></div>
							<button id="login" class="login100-form-btn">登 录</button>
						</div>
					</div>
					<div class="txt1 text-center p-t-54 p-b-20">
						<span>第三方登录</span>
					</div>
					<div class="flex-c-m">
						<a href="#" class="login100-social-item bg1">
							<i class="fa fa-wechat"></i>
						</a>
						<a href="#" class="login100-social-item bg2">
							<i class="fa fa-qq"></i>
						</a>
						<a href="#" class="login100-social-item bg3">
							<i class="fa fa-weibo"></i>
						</a>
					</div>
					<div class="flex-col-c p-t-25">
						<a href="javascript:" class="txt2">立即注册</a>
					</div>
				</form>
			</div>
		</div>
	</div>
	
<script type="text/javascript">
	$("#login").click(function () {
		var emp_id=$("#emp_id").val();
		var pass=$("#password").val();
		var s=emp_id+"-"+pass;
		alert(s);
		$.ajax({
			url : "${APP_PATH }/f/people/",
			data : "loginData=" + s,
			type : "POST",
			success : function(result) {
				alert("ddd");
				alert(result); 
				if(result.code==100){
					 var p= result.extend.path;
					// alert(p);
					 window.location.href = "${APP_PATH}"+p;
				 }
				 else{
					 alert("密码错误")
				 }
			}
		});
	});
</script>
</body>
</html>