<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta charset="UTF-8">
<title>新用户注册</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
<script src="${APP_PATH }/static/js/bootstrap.min.js"></script>
<script src="//cdn.bootcss.com/bootstrap-validator/0.5.3/js/bootstrapValidator.min.js"></script>

<link href="${APP_PATH }/static/css/register.css" rel="stylesheet">
<link href="${APP_PATH }/static/css/bootstrap.min.css" rel="stylesheet">
<link href="//cdn.bootcss.com/bootstrap-validator/0.5.3/css/bootstrapValidator.min.css" rel="stylesheet">

<style>
#box1, #box2, #box3, #box4, #box5, #box6 {
	margin-top: 3%;
}

input {
	border-left: none;
}
</style>
</head>
<body>
	<div class="container col-lg-3 col-lg-offset-3">
		<div style="text-align: center; color: white; padding-top: 3%; padding-bottom: 3%; font-size: 30px; text-shadow: black 5px 3px 3px;">新用户注册</div>
		<div>
			<form id="registerForm" method="POST" class="form-horizontal"
				action="/user/regist">
							
				<div class="form-group" id="box1">
					<span class="control-label">工号:</span> <input type="text"
						class="form-control" placeholder="请输入工号" name="peo_employee_id"
						id="peo_employee_id">
				</div>
				<div class="form-group" id="box2">
					<!--注册的用户名-->
					<span class="control-label">用户名:</span> <input type="text"
						class="form-control" placeholder="请输入注册用户名"
						name="peo_employee_name" id="peo_employee_name">
				</div>
				<div class="form-group" id="box3">
					<!--注册密码-->
					<span class="control-label">密码:</span> <input type="password"
						class="form-control" placeholder="请输入注册密码" name="peo_password"
						id="peo_password">
				</div>
				<div class="form-group" id="box4">
					<!--确认密码-->
					<span class="control-label">确认密码:</span> <input type="password"
						class="form-control" placeholder="请输入确认密码" name="repassword"
						id="repassword">
				</div>
				<div class="form-group" id="box5">
					<span class="control-label">手机号码:</span> <input type="text"
						class="form-control" placeholder="请输入手机号码" name="peo_phone"
						id="peo_phone">
				</div>
				<div class="form-group" id="box6">
					<span class="control-label">电子邮箱:</span> <input type="text"
						class="form-control" placeholder="请输入电子邮箱" name="peo_email"
						id="peo_email">
				</div>
				<br>
				<!--下面是登陆按钮,包括颜色控制-->
				<button type="button" style="width: 50px;" class="btn btn-default" >注册</button>
			</form>
		</div>
	</div>
	<script>
		$(function() {
			<!--数据验证-->
			$("#registerForm").bootstrapValidator({
				message : 'This value is not valid',
				//            定义未通过验证的状态图标
				feedbackIcons : {/*输入框不同状态，显示图片的样式*/
					valid : 'glyphicon glyphicon-ok',
					invalid : 'glyphicon glyphicon-remove',
					validating : 'glyphicon glyphicon-refresh'
				},
				//            字段验证
				fields : {
					//                用户名
					peo_employee_name : {
						message : '用户名非法',
						validators : {
							//                        非空
							notEmpty : {
								message : '用户名不能为空'
							},
							//                        限制字符串长度
							stringLength : {
								min : 3,
								max : 20,
								message : '用户名长度必须位于3到20之间'
							},
							//                        基于正则表达是的验证
							regexp : {
								regexp : /^[a-zA-Z0-9_\.]+$/,
								message : '用户名由数字字母下划线和.组成'
							}
						}
					},

					//                密码
					peo_password : {
						message : '密码非法',
						validators : {
							notEmpty : {
								message : '密码不能为空'
							},
							//                        限制字符串长度
							stringLength : {
								min : 3,
								max : 20,
								message : '密码长度必须位于3到20之间'
							},
							//                        相同性检测
							identical : {
								//                            需要验证的field
								field : 'password',
								message : '两次密码输入不一致'
							},
							//                        基于正则表达是的验证
							regexp : {
								regexp : /^[a-zA-Z0-9_\.]+$/,
								message : '密码由数字字母下划线和.组成'
							}
						}
					},

					//                确认密码
					repassword : {
						message : '密码非法',
						validators : {
							notEmpty : {
								message : ' 密码不能为空'
							},
							//                        限制字符串长度
							stringLength : {
								min : 3,
								max : 20,
								message : ' 密码长度必须位于3到20之间'
							},
							//                        相同性检测
							identical : {
								//                            需要验证的field
								field : 'password',
								message : '两次密码输入不一致'
							},
							//                        基于正则表达是的验证
							regexp : {
								regexp : /^[a-zA-Z0-9_\.]+$/,
								message : ' 密码由数字字母下划线和.组成'
							}
						}
					},

					//                电子邮箱
					peo_email : {
						validators : {
							notEmpty : {
								message : '邮箱地址不能为空'
							},
							emailAddress : {
								message : '请输入正确的邮箱地址'
							}
						}
					},

					//                手机号码
					peo_phone : {
						validators : {
							notEmpty : {
								message : '手机号码不能为空'
							},
							stringlength : {
								min : 11,
								max : 11,
								message : '请输入11位手机号码'
							},
							regexp : {
								regexp : /^1[3|5|8]{1}[0-9]{9}$/,
								message : '请输入正确的手机号码'
							}
						}
					},
					//工号  
					peo_employee_id : {
						validators : {
							notEmpty : {
								message : '工号不能为空'
							},
							stringlength : {
								min : 9,
								max : 9,
								message : '请输入9位工号'
							},
							regexp : {
								regexp : /^1[3|5|8]{1}[0-9]{9}$/,
								message : '工号必须是9位数字'
							}
						}
					}
				}
			})
		})
	</script>
</body>
</html>