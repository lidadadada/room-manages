<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Carbon - Admin Template</title>
    <%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
	%>
    <link rel="stylesheet" href="${APP_PATH }/static/css/styles.css">
    <script src="${APP_PATH }/static/js/jquery-1.11.3.min.js"></script>
    <script src="${APP_PATH }/static/bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
</head>
<body>
<div class="page-wrapper flex-row align-items-center">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-5">
                <div class="card p-4">
                    <div class="card-header text-center text-uppercase h4 font-weight-light">
                       	管理员登陆
                    </div>

                    <div class="card-body py-5">
                        <div class="form-group">
                            <label class="form-control-label">用户名</label>	 
                            <input id="user" type="text" class="form-control">
                        </div>

                        <div class="form-group">
                            <label class="form-control-label">密码</label>
                            <input id="pass" type="password" class="form-control">
                        </div>

                        <div class="custom-control custom-checkbox mt-4">
                            <input type="checkbox" class="custom-control-input" id="login">
                            <label class="custom-control-label" for="login">记住密码</label>
                        </div>
                    </div>

                    <div class="card-footer">
                        <div class="row"> 
                            <div class="col-md-12">
                                <button id="but" type="submit" class="btn btn-primary px-10">登陆</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
	$("#but").click(function () {
		//alert("ddd");
		 var user=$("#user").val();
		 var pass=$("#pass").val();
		 $.ajax({
			 url:"${APP_PATH}/index/"+user+"-"+pass,
			 type:"get",
			 success:function(result){
				 if(result.code==100){
					 var p= result.extend.path;
					// alert(p);
					 window.location.href = "${APP_PATH}"+p;
				 }
				 else{
					 alert("密码错误")
				 }
			 }
		 })
	});
</script>
</body>
</html>