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
<script type="text/javascript"
	src="${APP_PATH }/static/js/jquery-1.11.3.min.js"></script>

<script src="${APP_PATH }/static/login/yanzheng/gVerify.js"></script>

<link
	href="${APP_PATH }/static/bootstrap-3.3.5-dist/css/bootstrap.min.css"
	rel="stylesheet">
<script type="text/javascript"
	src="${APP_PATH }/static/bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
	
 <link rel="stylesheet" href="${APP_PATH }/static/bootstrapValidator/bootstrapValidator.css"/>
  <script type="text/javascript" src="${APP_PATH }/static/bootstrapValidator/bootstrapValidator.min.js"></script>
  	
  <link rel="stylesheet" href="${APP_PATH }/static/login/base.css">
    <link rel="stylesheet" href="${APP_PATH }/static/login/iconfont.css">
    <link rel="stylesheet" href="${APP_PATH }/static/login/reg.css">

	 <script src="${APP_PATH }/static/login/agree.js"></script>
	 <style type="text/css">
	 	#img_code{
	 		 position: relative;
			  left: 320px;	
			  top:-70px;
	 	}
	 </style>	
</head>
<body>
<div id="ajax-hook"></div>
    <div class="wrap">
        <div class="wpn">
            <div id="wrap_reg" class="form-data pos">
                <a href=""><img src="${APP_PATH }/static/login/logo.png" class="head-logo"></a>
                <!--<p class="tel-warn hide"><i class="icon-warn"></i></p>-->
                <form>
                    <p class="p-input pos">
                        <label for="tel">员工号</label>
                        <input type="number" id="emp_id" name="empid" autocomplete="off">
                       <!--  <span class="tel-warn tel-err hide"><em></em><i class="icon-warn"></i></span> -->
                       <span id="emp_id_span" class="tel-warn tel-err hide"><em></em><i id="emp_id_i" class="icon-ok-sign"></i></span>
                       
                    </p>
					  <p class="p-input pos">
                        <label for="tel">账户名</label>
                        <input type="text" id="emp_name"  name="empname" autocomplete="off">
                        <span id="emp_name_span" class="tel-warn tel-err hide"><em></em><i id="emp_name_i" class="icon-warn"></i></span>
                    </p>
					 <p class="p-input pos" id="pwd">
                        <label for="passport">输入密码</label>
          
                        <input type="text" id="passport1" name="pass1">	
                        <span id="emp_pass1_span" class="tel-warn pwd-err hide"><em></em><i id="emp_pass1_i" class="icon-warn" style="margin-left: 5px"></i></span>
                    </p>
                    <p class="p-input pos" id="confirmpwd">
                        <label for="passport2">确认密码</label>
                        <input type="password" id="passport2" name="pass2">
                        <span id="emp_pass2_span" class="tel-warn confirmpwd-err hide"><em></em><i id="emp_pass2_i" class="icon-warn" style="margin-left: 5px"></i></span>
                    </p>
                    <p class="p-input pos">
                        <label for="tel">手机号码</label>
                        <input type="tel" id="emp_tel" name="phone" autocomplete="off">
                        <span class="tel-warn tel-err hide"><em></em><i class="icon-warn"></i></span>
                    </p>
                    
                  <!--   <p class="p-input pos" id="sendcode">
                        <label for="veri-code">输入验证码</label>
                        <input type="number" id="veri-code">
                        <a href="javascript:;" class="send">发送验证码</a>
                        <span class="time hide"><em>120</em>s</span>
                        <span class="error hide"><em></em><i class="icon-warn" style="margin-left: 5px"></i></span>
                    </p> -->
                    <p class="p-input pos" id="sendcode">
                        <label for="veri-code"">输入验证码</label>
                         <input type="text" id="image-code" name="vali" width="400px">
                         <div id="img_code">
 								<span id="v_container"></span>
                    	</div>
                    	
                    </p>
                </form>
                <!-- <div class="reg_checkboxline pos">
                    <span class="z"><i class="icon-ok-sign boxcol" nullmsg="请同意!"></i></span>
                    <input type="hidden" name="agree" value="1">
                    <div class="Validform_checktip"></div>
                    <p>我已阅读并接受 <a href="#" target="_brack">《XXXX协议说明》</a></p>
                </div> -->
                <button class="lang-btn">注册</button>
                <div class="bottom-info">已有账号，<a href="${APP_PATH }/f_login.jsp">马上登录</a></div>
                <div class="third-party">
                    <a href="#" class="log-qq icon-qq-round"></a>
                    <a href="#" class="log-qq icon-weixin"></a>
                    <a href="#" class="log-qq icon-sina1"></a>
                </div>
            </div>
        </div>
    </div>

	<script type="text/javascript">
	var flag =-1;
		$("#passport2").blur(function() {
			var pass2 = document.getElementById("passport2").value;
			var pass1 = document.getElementById("passport1").value;
			//alert(123);
			if(pass1!=pass2){
				$("#emp_pass2_span").removeClass().addClass("tel-warn tel-err");
				$("#emp_pass2_i").removeClass().addClass("icon-warn");
			}else{
				$("#emp_pass2_span").removeClass().addClass("tel-warn tel-err");
				$("#emp_pass2_i").removeClass().addClass("icon-ok-sign");
			}
		});
		$("#emp_id").blur(function() {
			var ff= valiEmpid();
			//alert(flag);
				if(flag){
					$("#emp_id_span").removeClass().addClass("tel-warn tel-err");
					$("#emp_id_i").removeClass().addClass("icon-ok-sign");
				}else{
					$("#emp_id_span").removeClass().addClass("tel-warn tel-err");
					$("#emp_id_i").removeClass().addClass("icon-warn");
				}
		});
		 var verifyCode;
			/*图片验证码  */
		    $(function(){
		       verifyCode = new GVerify("v_container");
		        document.getElementById("image-code").onblur = function(){
		            var res = verifyCode.validate(document.getElementById("image-code").value);
		            if(res){
		                alert("验证正确");
		            }else{
		                alert("验证码错误");
		            }
		        }
		    })
		   $(".lang-btn").click(function(){
			   var emp_id = document.getElementById("emp_id").value;
			   var emp_name = document.getElementById("emp_name").value;
			   var passport1 = document.getElementById("passport1").value;
			   var passport2 = document.getElementById("passport2").value;
			   var res = verifyCode.validate(document.getElementById("image-code").value);
			   valiEmpid();
			   if(emp_id==""||flag!=1){
				   yanzheng("emp_id_span","emp_id_i");
				   return ;
			   }
			   if(emp_name==""){
				   yanzheng("emp_name_span","emp_name_i");
				   return ;
			   }
			   if(passport1==""){
				   yanzheng("emp_pass1_span","emp_pass1_i");
				   return ;
			   }
			   if(passport2==""||passport1!=passport2){
				   yanzheng("emp_pass2_span","emp_pass2_i");
				   return ;
			   }
			   if(res){
				   $.ajax({
						url:"${APP_PATH }/f/reg/regdata",
						data:$("form").serialize(),
						success:function(result){
							if(reult.code==100){
								alert("注册成功！！");
								window.location.href="${APP_PATH}"+result.extend.path;
							}else{
								alert("注册失败！！");
							}
							
							}
						});
			   }
		   });
			/* 逐一验证 */		 
		function yanzheng(span,i){
			$("#"+span).removeClass().addClass("tel-warn tel-err");
			$("#"+i).removeClass().addClass("icon-warn");
			}
			/* 教研员工号 */
			function valiEmpid() {
				var empid = document.getElementById("emp_id").value;
				if(empid!=""){
					$.ajax({
						url:"${APP_PATH }/f/reg/empid",
						data:"empid="+empid,
						async:false,
						success:function(result){
							alert("返货："+result.code);
							if(result.code==100){
								flag=1;
							}else{
								flag=0;
							}
						}
					});
				}
			}
		
	</script>
</body>
</html>