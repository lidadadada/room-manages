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


<link href="${APP_PATH }/static/bootstrap-3.3.7-dist/css/bootstrap.css" rel='stylesheet' type='text/css'/>
		<!-- Custom Theme files -->
		<link href="${APP_PATH }/static/peopleinfo/style.css" rel='stylesheet' type='text/css'/>
		<link href="${APP_PATH }/static/peopleinfo/usercenter.css" rel='stylesheet' type='text/css'/>
		<script src="${APP_PATH }/static/peopleinfo/jquery.min.js"></script>
		<!-- jQuery (necessary JavaScript plugins) -->
		<script src="${APP_PATH }/static/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
		<script src="${APP_PATH }/static/peopleinfo/usercenter.js"></script>
		
<link href="${APP_PATH }/static/peopleinfo/crop.css" rel='stylesheet' type='text/css'/>
			<script src="${APP_PATH }/static/peopleinfo/crop.js"></script>
<link rel="stylesheet" media="screen" href="${APP_PATH }/static/peopleinfo/datepicker.css">
			<script src="${APP_PATH }/static/peopleinfo/datepicker.js"></script>


<link href="${APP_PATH }/static/font-awesome/css/fontawesome.css" rel="stylesheet">
	<link href="${APP_PATH }/static/nav/bootsnav.css" rel="stylesheet">
	<link href="${APP_PATH }/static/nav/overwrite.css" rel="stylesheet">
            <link href="${APP_PATH }/static/nav/style.css" rel="stylesheet">
	<script src="${APP_PATH }/static/nav/bootsnav.js"></script>
	
<style type="text/css">
		.pageheader{	
							background: url("${APP_PATH }/static/img/navbg.jpg");
							background-size:cover;
					}
			#total{
				padding: 0px;
			}
			#total>p{
				margin-bottom: 2px;
			}
			
			#head_img{
				width: auto;
				height: auto;
				max-width: 100%;
				max-height: 100%;
			}
	</style>
</head>
<body>
<!-- Start Navigation -->
    <nav class="navbar navbar-default bootsnav">
        <div class="container">  
            <!-- Start Atribute Navigation -->
            <div class="attr-nav">
                <ul>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" style="padding:15 15 15 15;" >
                            <i class="fa">
                            	<div class="badge" style="width: 50px; height: 50px; border-radius: 50%; border: 3px solid #eee; overflow: hidden;">  
							            <div style="text-align:center;">
							            	<img id="head_img" src="${APP_PATH }/static/images/bg-01.jpg"  /> 
							            </div> 	
							     </div> 
                            </i>	
                            <span class="badge" id="badgeNumSpan">3</span>
                        </a>
                        <ul class="dropdown-menu cart-list" id="nav_list">
                            <li>
 									 <h6><a href="#">申请入会列表</a></h6>
                            </li>
                           
                            <!-- <li class="total">
                               <div>
                               		<p>申请者：<span id="nav_name_span"></span>&nbsp;&nbsp;&nbsp;
                               			员工号：<span id="nav_empid_span"></span>
                               		</p>
                               		<p>
                               			申请信息：<span id="nav_applyinfo_span"></span>
                               			<button>拒绝</button><button>同意</button>
                               		</p>
                               </div>
                            </li> -->
                            		
                          
                        </ul>
                    </li>
                </ul>
            </div>        
            <!-- End Atribute Navigation -->

            <!-- Start Header Navigation -->
            <div>
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-menu">
                    <i class="fa fa-bars"></i>
                </button>
                <a class="navbar-brand" href="#brand"><img src="${APP_PATH }/static/nav/logo-black.png" class="logo" alt=""></a>
            </div>
            
            <!-- End Header Navigation -->

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="navbar-menu">
                
                    <div style="margin-bottom: 10px;margin-left: 40%;width: 100%;margin-top:40px;font-weight: bold;font-size: 17px;	 ">
                    	<a href="${APP_PATH }/f_show.jsp">首页</a>    &nbsp; &nbsp;  &nbsp; &nbsp;             
	           			<a href="${APP_PATH }/f_main.jsp">预定</a>		 &nbsp; &nbsp;  &nbsp; &nbsp; 
	                    <a href="${APP_PATH }/f_userinfo.jsp">我的信息</a>	&nbsp; &nbsp;  &nbsp; &nbsp;
	                    <a href="javascript:void(0);" onclick="exit()">注销</a>
                    </div>
                
            </div><!-- /.navbar-collapse -->
        </div>   
    </nav>
    <!-- End Navigation -->
    <div class="clearfix"></div>
	<div class="container">
		<div class="row">
		    <!-- Start Home -->
		    <div class="pageheader" style="height: 100px" >	
		    	<div class="col-md-offset-1">	
		            <h2 class="title">购物车布局导航菜单</h2>
		            <p>Navigation menu with shopping cart dropdown</p>
		       </div>
		    </div>
	    </div>
 </div>
<!-- 个人信息 -->
		<div class="container">
			<div class="inner-block">
				
				<p id="notice"></p>
				<div class="user-info">
					<div class="info-box">
						<div class="ico-box">
							<img alt="用户中心首页头像" id="navAvatar" class="info-ico" data-id="3">
							<button data-toggle="modal" id="cropfile" class="cropfile">
								<span class="glyphicon glyphicon-pencil">修改</span>
							</button>
						</div>	
						<ul class="fix-ico-right">
							<li class="fix-item">
								<span>用户名：</span>
								<span>小白先生</span>
							</li>
						</ul>
					</div>
					<div class="phone-email info-box">
						<div class="phone">
							
							<ul class="fix-ico-right">
								<li class="fix-item">
									<span>手机已验证</span>
									<span id="phone-info"></span>
									<a id="edit-phone" href="javascript:void(0)" class="state-ture">修改手机号</a>
								</li>
							</ul>
						</div>
						<div class="email">
							
							<ul class="fix-ico-right">
								<li class="fix-item">
									<span>邮箱未验证</span>
									<span id="email-info"></span>
									<a id="valid-email" href="javascript:void(0)" class="state-false">点击验证</a>
								</li>
							</ul>
						</div>
					</div>
				</div>
				<div class="detail-info">
					<ul>
						<li class="info-item">
							<span>员工号</span>
							<div role="info-content">
								<em role="info" data-attr="peoEmployeeId"></em>
								<input type="text-field" name="peoEmployeeId" class="edit" role="edit">
							</div>
							
						</li>
						<li class="info-item">
							<span>姓名</span>
							<div role="info-content">
								<em role="info" data-attr="peoEmployeeName"></em>
								<input type="text-field" name="peoEmployeeName" class="edit" role="edit">
							</div>
							<div class="revise-group" role="revise-group">
								<a href="javascript:void(0)" class="revise" role="revise">修改</a>
								<div class="control-group">
									<a href="javascript:void(0)" class="revise" role="cancel">取消</a>
									<a href="javascript:void(0)" class="revise" role="conform" data-target="usercenter/revise">确定</a>
								</div>
							</div>
						</li>
						<li class="info-item">
							<span>职位</span>
							<div role="info-content">
								<em role="info" name="peoPost" data-attr="peoPost"></em>
								<input type="text-field" name="peoPost" class="edit" role="edit">
							</div>
							<div class="revise-group" role="revise-group">
								<a href="javascript:void(0)" class="revise" role="revise">修改</a>
								<div class="control-group">
									<a href="javascript:void(0)" class="revise" role="cancel">取消</a>
									<a href="javascript:void(0)" class="revise" role="conform" data-target="usercenter/revise">确定</a>
								</div>
							</div>
						</li>
						<li class="info-item">
							<span>地址</span>
							<div role="info-content">
								<em role="info" data-attr="peoAddress"></em>
								<input type="text-field" name="peoAddress" class="edit" role="edit">
							</div>
							<div class="revise-group" role="revise-group">
								<a href="javascript:void(0)" class="revise" role="revise">修改</a>
								<div class="control-group">
									<a href="javascript:void(0)" class="revise" role="cancel">取消</a>
									<a href="javascript:void(0)" class="revise" role="conform" data-target="usercenter/revise">确定</a>
								</div>
							</div>
						</li>
					</ul>
				</div>
				<div class="intro-box detail-info">
					<div class="intro-head">
						<span>自我介绍：</span>
					</div>
					<div class="intro-content info-item">
						<div class="revise-group" role="revise-group">
							<a href="javascript:void(0)" class="revise" role="revise">修改</a>
							<div class="control-group">
								<a href="javascript:void(0)" class="revise" role="cancel">取消</a>
								<a href="javascript:void(0)" class="revise" role="conform" data-target="usercenter/revise">确定</a>
							</div>
						</div>
						<div role="info-content">
							<em role="info" data-attr="peoOther">
								<span></span>
							</em>
							<textarea class="edit" name="peoOther" role="edit"></textarea>
						</div>
					</div>
				</div>
			</div>
						<!-- Modal -->



			<div class="modal fade in" id="cropModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" data-backdrop="static">
				<div class="modal-dialog modal-crop">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">
								<span aria-hidden="true">×</span>
								<span class="sr-only">Close</span>
							</button>
							<p class="modal-title" id="Label">修改图片</p>
						</div>
						<div class="editarea">
							<div class="croparea">
								<span class="file-beautify">
									<form id="cropForm" action="" accept-charset="UTF-8" method="post" enctype="multipart/form-data">
									<input name="utf8" type="hidden" value="✓"><input type="hidden" name="authenticity_token" value="HPbYOuv+WXp9u8lY1DcMDdlesGqy/cyE2dQ5n5wamh+h3iu3VfjHfB+6SYwnRn4PqNN4VGHvd0wRm1CdeCU2pg==">
										<input type="file" name="avatar" class="cropable" id="inputFile">
										<input id="posi_x" type="hidden" name="x">
										<input id="posi_y" type="hidden" name="y">
										<input id="img_width" type="hidden" name="width">
										<input id="img_height" type="hidden" name="height">
										<input id="img_rotate" type="hidden" value="0" name="rotate">
									</form>
								</span>
								<p id="alertType"></p>
								<div class="showpics">
									<img id="imagefile" src="${APP_PATH }/static/peopleinfo/avatar.png" alt="" class="cropper-hidden">
								</div>
								<div class="btn-group">
									<button type="button" class="btn btn-primary" id="lrotate">
										<span class="glyphicon glyphicon-share-alt rotatey"></span>
									</button>
									<button type="button" class="btn btn-primary" id="rrotate">
										<span class="glyphicon glyphicon-share-alt"></span>
									</button>
								</div>
								<button type="button" class="btn btn-primary" id="reset">
									<span class="glyphicon glyphicon-repeat"></span>
								</button>

							</div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
							<button type="button" class="btn btn-primary" data-loading-text="更新中..." id="subcrop">确定</button>
						</div>
					</div>
				</div>
			</div>
			<link href="${APP_PATH }/static/peopleinfo/crop.css" rel='stylesheet' type='text/css'/>
			<script src="${APP_PATH }/static/peopleinfo/crop.js"></script>
			
			<!-- 初始化导航栏 -->
<script type="text/javascript">
	var aPeople ; //保存全局登陆者
	console.log("初始化导航栏");
	navInit() ;
	function navInit() {
		$.ajax({
			url : "${APP_PATH}/f/nav/getPeople",	
			type : "GET",	
			async:false,
			success : function(result) {
				console.log("导航条数据");
				console.log(result);
				if(result.code==100){
					aPeople =result;
					exNavData(result);
				}else{
					window.location.href = "${APP_PATH}/"+result.extend.path;
				}
			},
			error:function(a){
				alert("error");
			}
			
		});
	}
	function exNavData(result) {
		var peoinfo = result.extend.peopleInfo;
		$("#head_img").attr("src",peoinfo.peoImagePath);
		var eNavList =document.getElementById("nav_list");
		var i= 0;
		//alert(result.extend.joinList.length);	
		if(result.extend.joinList.length>1){
			$.each(result.extend.joinList,function(index,item){
				i++;
				if(item.joinApply.joinDealState==1){
					var eHtml = "<li style='height:130px' class='total'><div><p style='margin-bottom: 2px;'>申请者："+item.peopleInfo.peoEmployeeName
					+"</span>&nbsp;&nbsp;&nbsp;员工号："+ item.peopleInfo.peoEmployeeId+"</span>"
					+"</p><p style='margin-bottom: 2px;'>申请信息：" +item.joinApply.joinOther
					+"</p><p style='margin-bottom: 2px;'><button index='"+item.joinApply.joinId+"' id='navReject' style='margin-left:45px;margin-right:30px;with:15px;font-size:10px;'>拒绝</button>"
					+"<button  index='"+item.joinApply.joinId+"' id='navAgree' style='with:15px;font-size:10px;'>同意</button></p></div></li>";
					eNavList.innerHTML+=eHtml;		
				}		
			});
			$("#badgeNumSpan").attr("style","color:#f00");
		}else{
			eNavList.innerHTML += "<li><span>当前无事件待处理</span></li>";
		}
		document.getElementById("badgeNumSpan").innerHTML=i;   
	}
		/* 拒绝申请按钮事件处理 */
		$(document).on("click","#navReject",function () { 
			var index= $(this).attr("index");
			$.ajax({
				url : "${APP_PATH}/f/nav/reject",
				type : "GET",
				data:"mydata="+index,
				success : function(result) {
						console.log("拒绝");
						console.loh(result);
						if(result.code==100){
							navInit() ;
						}else{
							alert("拒绝失败");
						}
					}		
				});
		});	
		/* 同意申请按钮事件处理 */
		$(document).on("click","#navAgree",function () { 
			var index= $(this).attr("index");
			$.ajax({
				url : "${APP_PATH}/f/nav/agree",
				type : "GET",
				data:"mydata="+index,
				success : function(result) {
						console.log("同意");
						console.loh(result);
						if(result.code==100){
							navInit() ;
						}else{
							alert("同意失败");
						}
					}		
				});
		});
		/* 注销 */
		function exit() {
			$.ajax({
				url : "${APP_PATH}/f/nav/exit",
				type : "GET",
				success : function(result) {
					window.location.href = "${APP_PATH}/" + result.extend.path;
				}
			});
		}				
					
	
</script>

			<script type="text/javascript">

			$(function () {
				console.log("上传");
				//文件上传
				$('#subcrop').on("click", function () {
					var f = document.getElementById("inputFile").files;  
					var s =f[0].name.split(".")[1];
					 var data=uploadCrop("avatar", "/room-manages/f/user/upimage/"+s, "/accounts/");
					 console.log(data);
					 console.log("aad");	
					 if(data!=null&&data!=""){
						 console.log("aa");
						 $("#navAvatar").attr("src",data.extend.peoImagePath);
					 }
				}); 

				});
			</script>
			
		<script type="text/javascript">
		  $(function() {
				  var $peoEmployeeId = $("em[data-attr=peoEmployeeId]");
				  var $peoEmployeeName = $("em[data-attr=peoEmployeeName]");
				  var $peoPost = $("em[data-attr=peoPost]");
				  var $peoAddress = $("em[data-attr=peoAddress]");
				  var $peoOther = $("em[data-attr=peoOther]");
/* 				  var $avatar = $("#navAvatar");
				  var $phone = $("#phone-info");
				  var $mail = $("#email-info"); */
					
				  
				  $.ajax({
					   url:"${APP_PATH}/f/user/info",
					  type: "post",
					  success: function(result) {
						  console.log("会显示用户信息：");
						  console.log(result);
						  
						  var res = result.extend.peopelinfo;
						  if(result.code==100){
							 $peoEmployeeId.text(res.peoEmployeeId);
							$peoEmployeeName.text(res.peoEmployeeName);
							$peoPost.text(res.peoPost);
							$peoAddress.text(res.peoAddress);
							$peoOther.text(res.peoOther);
							$("#navAvatar").attr("src",res.peoImagePath);
							/* $birth.text("");
							$addr.text("");
							$intro.text(res.introduce);
							$avatar.attr("src", ROOT + res.face); */
						  }else if(result.extend.path==0){
							  alert("获取用户信息错误");
						  }else{
							  window.location.href = "${APP_PATH}/"+result.extend.path;
						  }
						
					  }
				  })
			  })
			  
			  /* 注意：usercenter中的ajax	url写死了，注意修改 */
			</script>
		
		</body>
		</html>				 
