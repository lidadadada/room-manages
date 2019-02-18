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

  <link rel="stylesheet" href="${APP_PATH }/static/login/base.css">
    <link rel="stylesheet" href="${APP_PATH }/static/login/iconfont.css">
    <link rel="stylesheet" href="${APP_PATH }/static/login/reg.css">
	
	<script src="${APP_PATH }/static/login/agree.js"></script>
	<script src="${APP_PATH }/static/login/login.js"></script>
</head>
<body>

<div class="wrap">
    <div class="wpn">
        <div class="form-data pos">
            <a href=""><img src="${APP_PATH }/static/login/logo.png" class="head-logo"></a>
            <div class="change-login">
                <p class="account_number on">账号登录</p>
                <p class="message">短信登录</p>
            </div>
            <div class="form1">
                <p class="p-input pos">
                    <label for="num">手机号/用户名/员工号</label>
                    <input type="text" id="num" >
                    <span id="emp_id_span" class="tel-warn num-err hide"><em>账号或密码错误，请重新输入</em><i id="emp_id_i" class="icon-warn"></i></span>
                </p>
                <p class="p-input pos">
                    <label for="pass">请输入密码</label>
                    <input type="password" style="display:none"/>
                    <input type="password" id="pass" autocomplete="new-password">
                    <span id="emp_pass_span" class="tel-warn pass-err hide"><em>账号或密码错误，请重新输入</em><i id="emp_pass_i" class="icon-warn"></i></span>
                </p>
                <p class="p-input pos code hide">
                    <label for="veri">请输入验证码</label>
                    <input type="text" id="veri">
                    <img src="">
                    <span class="tel-warn img-err hide"><em>账号或密码错误，请重新输入</em><i class="icon-warn"></i></span>
                    <!-- <a href="javascript:;">换一换</a> -->
                </p>
            </div>
            <div class="form2 hide">
                <p class="p-input pos">
                    <label for="num2">手机号</label>
                    <input type="number" id="num2">
                    <span class="tel-warn num2-err hide"><em>账号或密码错误</em><i class="icon-warn"></i></span>
                </p>
                <p class="p-input pos">
                    <label for="veri-code">输入验证码</label>
                    <input type="number" id="veri-code">
                    <a href="javascript:;" class="send">发送验证码</a>
                    <span class="time hide"><em>120</em>s</span>
                    <span class="tel-warn error hide">验证码错误</span>
                </p>
            </div>
            <div class="r-forget cl">
                <a href="${APP_PATH }/f_dreg.jsp" class="z">账号注册</a>
                <a href="./getpass.html" class="y">忘记密码</a>
            </div>
            <button id="login_btn" class="lang-btn off log-btn">登录</button>
            <div class="third-party">
                <a href="#" class="log-qq icon-qq-round"></a>
                <a href="#" class="log-qq icon-weixin"></a>
                <a href="#" class="log-qq icon-sina1"></a>
            </div>
            
        </div>
    </div>
</div>
	
<script type="text/javascript">
	$("#login_btn").click(function () {
		//alert(123456);
		//var emp_id =$("#emp_ids").val;
		var emp_id = document.getElementById("num").value;
		var pass = document.getElementById("pass").value;
		//alert(emp_id+"-"+pass);
		if(emp_id==""){
			yanzheng("emp_id_span","emp_id_i");
			return ;
		}
		if(pass==""){
			yanzheng("emp_pass_span","emp_pass_i");
			return ;
		}
		
		var s=emp_id+"_"+pass;
		//alert(s);
		$.ajax({
			url : "${APP_PATH }/f/people/",
			data : "loginData=" + s,
			success : function(result) {	
				//alert(result.code);
				if(result.code==100){
					 var p= result.extend.path;
					 //alert(p);
					 window.location.href = "${APP_PATH}"+p;
				 }
				 else{
					 yanzheng("emp_id_span","emp_id_i");
					 yanzheng("emp_pass_span","emp_pass_i");
				 }
			}
		});
	});
	/* 逐一验证 */		 
	function yanzheng(span,i){
		$("#"+span).removeClass().addClass("tel-warn tel-err");
		$("#"+i).removeClass().addClass("icon-warn");
		}
</script>
</body>
</html>