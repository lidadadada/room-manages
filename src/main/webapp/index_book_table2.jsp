<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<link
	href="${APP_PATH }/static/font-awesome/css/fontawesome-all.min.css"
	rel="stylesheet">
<link
	href="${APP_PATH }/static/simple-line-icons/css/simple-line-icons.css"
	rel="stylesheet">
<link href="https://cdn.bootcss.com/bootstrap3-dialog/1.34.9/css/bootstrap-dialog.min.css" rel="stylesheet">
<script type="text/javascript"
	src="${APP_PATH }/static/bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap3-dialog/1.34.9/js/bootstrap-dialog.min.js"></script>
<script src="${APP_PATH }/static/js/carbon.js"></script>
</head>
<body class="sidebar-fixed header-fixed">

	<!-- 编辑模态框 -->
	<div class="modal fade" id="bookEditModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">编辑预定</h4>
				</div>
				<!-- 表单体   	name值和bean中一致-->
				<div class="modal-body">
					<form class="form-horizontal">
						<div class="form-group" id="edit_book_people_id_addhelp-block">
							<label class="col-sm-2 control-label" >员工号</label>
							<div class="col-sm-6">
								<input type="number" name="prePeopleId" class="form-control"
									id="book_people_id_edit"> 
									
								<span id="edit_people_name_model_span"></span>&nbsp;&nbsp; 
								<span id="edit_people_post_model_span"></span> 
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-2 control-label">选择会议室</label>
							<div class="col-sm-6">
								<!-- 下拉列表，name直接写preRoomNum -->
								<select class="form-control" name="preRoomNum"
									id="book_room_edit_select">
								</select>
								<!-- 会议室信息 -->
								<span id="edit_book_address_span"></span> <br> <span
									id="edit_book_max_num_span"></span> <br> <span
									id="edit_book_equip_span"></span>
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-2 control-label">主题</label>
							<div class="col-sm-10">
								<input type="text" name="preTheme" class="form-control"
									id="book_theme_edit" placeholder=""> <span
									class="help-block"></span>
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-2 control-label">日期</label>
							<div class="col-sm-10">
								<input type="date" name="preDay" class="form-control"
									id="book_date_edit" placeholder="">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">预定开始时间</label>
							<div class="col-sm-10">
								<input type="text" name="preStartTime" class="form-control"
									id="book_start_time_edit" placeholder="">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">预定结束时间</label>
							<div class="col-sm-10">
								<input type="text" name="preEndTime" class="form-control"
									id="book_end_time_edit" placeholder="">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">备注信息</label>
							<div class="col-sm-10">
								<input type="textarea" name="other" class="form-control"
									id="book_other_edit" hint="在此处填写其它相关说明信息">
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary"
						id="book_edit_save_btn">保存修改</button>
				</div>
			</div>
		</div>
	</div>
	<!-- 添加预定记录模态框 -->
	<div class="modal fade" id="bookAddModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">添加预定</h4>
				</div>
				<!-- 表单体   	name值和bean中一致-->
				<div class="modal-body">
					<form class="form-horizontal">
						<div class="form-group" id="book_people_id_addhelp-block">
							<label class="col-sm-2 control-label" >员工号</label>
							<div class="col-sm-6">
								<input type="number" name="prePeopleId" class="form-control"
									id="book_people_id_add" placeholder="2106010312"> 
									<!-- 会议室信息 -->
								<span id="people_name_model_span"></span>&nbsp;&nbsp; 
								<span id="people_post_model_span"></span> 
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-2 control-label">选择会议室</label>
							<div class="col-sm-6">
								<!-- 下拉列表，name直接写preRoomNum -->
								<select class="form-control" name="preRoomNum"
									id="book_room_add_select">
								</select>
								<!-- 会议室信息 -->
								<span id="book_address_span"></span> <br> <span
									id="book_max_num_span"></span> <br> <span
									id="book_equip_span"></span>
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-2 control-label">主题</label>
							<div class="col-sm-10">
								<input type="text" name="preTheme" class="form-control"
									id="book_theme_add" placeholder=""> <span
									class="help-block"></span>
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-2 control-label">日期</label>
							<div class="col-sm-10">
								<input type="date" name="preDay" class="form-control"
									id="book_date_add" placeholder="2016-02-02">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">预定开始时间</label>
							<div class="col-sm-10">
								<input type="text" name="preStartTime" class="form-control"
									id="book_start_time_add" placeholder="8:30:00">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">预定结束时间</label>
							<div class="col-sm-10">
								<input type="text" name="preEndTime" class="form-control"
									id="book_end_time_add" placeholder="11:30:00">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">备注信息</label>
							<div class="col-sm-10">
								<input type="textarea" name="other" class="form-control"
									id="book_other_add" placeholder="在此处填写其它相关说明信息">
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary"
						id="book_add_save_btn">保存</button>
				</div>
			</div>
		</div>
	</div>

	<!-- 搭建显示页面 -->
	<div class="container">
		<!-- 标题 -->
		<div class="row">
			<div class="col-md-12">
				<h1>会议室预定管理</h1>
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
							<th>序号</th>
							<th>预定会议室</th>
							<th>预定主题</th>
							<th>预定者</th>
							<th>员工号</th>
							<th>职位</th>
							<th>电话</th>
							<th>日期</th>
							<th>预定开始时间</th>
							<th>预定结束时间</th>
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

	<script type="text/javascript">
		//页面加载完成，ajax请求，获得数据
		var totalRecord;
		var pageNum=0;//记录当前页面
		var room_info_result;
		to_page(1);
		//ajax 跳转页面的
		function to_page(pn) {
			pageNum=pn;
			$(function() {
				$.ajax({
					url : "${APP_PATH }/book",
					data : "pn=" + pn,
					type : "GET",
					success : function(result) {
						//1、解析显示员工数据
						build_book_table(result);
						//2、解析显示分页信息
						build_page_info(result);
						//3、解析显示分条数据
						build_page_nav(result);
					}
				})
			});
		}
		/* 1、解析显示员工数据 */
		function build_book_table(result) {
			//首先清空数据
			$("#book_table tbody").empty();
			var books = result.extend.pageInfo.list;
			$.each(books, function(index, item) { 
				var checkBox=$("<td></td>")
					.append("<input type='checkbox' class='check_item' style='margin-right:0px;'/>");
				//遍历预定记录，获取
				var serialNumTd = $("<td id='2'></td>").append(item.serialNum);
				var preRoomNumTd = $("<td></td>").append(item.preRoomNum);
				var preThemeTd = $("<td></td>").append(item.preTheme);
				var peoEmployeeNameTd = $("<td></td>").append(
						item.peopleInfo.peoEmployeeName);
				var prePeopleIdTd = $("<td></td>").append(item.prePeopleId);
				var peoPostTd = $("<td></td>").append(item.peopleInfo.peoPost);
				var peoPhoneTd = $("<td></td>")
						.append(item.peopleInfo.peoPhone);
				var preDayTd = $("<td></td>").append(getMyDate(item.preDay));
				var preStartTimeTd = $("<td></td>").append(
						getMyhours(item.preStartTime));
				var preEndTimeTd = $("<td></td>").append(
						getMyhours(item.preEndTime));
				var otherTd = $("<td></td>").append(item.other);
				/* <button class="btn btn-primary btn-sm">
								<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
								修改
							</button> */
				var editBtn = $("<button></button>").addClass(
						"btn btn-primary btn-sm edit_btn")
						.attr("index",item.serialNum).attr("id","table_edit_btn")
						.append($("<span></span>").addClass("glyphicon glyphicon-pencil")).append("编辑");
							
				//为button添加自定义属性保存员工id 	 
				editBtn.attr("edit_id", item.empId);
				var deleteBtn = $("<button></button>").addClass("btn btn-danger btn-sm delete_btn")
						.attr("index",item.serialNum).attr("id","table_delete_btn")
						.append($("<span></span>").addClass("glyphicon glyphicon-trash")).append("删除");
				var butTd = $("<td></td>").append(editBtn).append(" ").append(
						deleteBtn);
				$("<tr></tr>").append(checkBox).append(serialNumTd).append(preRoomNumTd).append(
						preThemeTd).append(peoEmployeeNameTd).append(
						prePeopleIdTd).append(peoPostTd).append(peoPhoneTd)
						.append(preDayTd).append(preStartTimeTd).append(preEndTimeTd)
						.append(otherTd).append(butTd).appendTo("#book_table tbody");

			});
		}
		/* 2、解析显示分页信息 */
		function build_page_info(result) {
			$("#page_info_area").empty();
			$("#page_info_area").append(
					"当前第" + result.extend.pageInfo.pageNum + "页，总共"
							+ result.extend.pageInfo.pages + "，总共"
							+ result.extend.pageInfo.total + "记录数");
			totalRecord = result.extend.pageInfo.pages;
		}
		/* 3、解析显示分条数据 */
		function build_page_nav(result) {
			$("#page_nav_area").empty();

			var ul = $("<ul></ul>").addClass("pagination");
			var firstPageLi = $("<li></li>").append(
					$("<a></a>").append("首页").attr("href", "#"));
			var prePageLi = $("<li></li>").append(
					$("<a></a>").append("&laquo;").attr("href", "#"));
			if (result.extend.pageInfo.hasPreviousPage == false) {
				firstPageLi.addClass("disabled");
				prePageLi.addClass("disabled");
			} else {
				//添加翻页事件
				firstPageLi.click(function() {
					to_page(1);
				});
				prePageLi.click(function() {
					to_page(result.extend.pageInfo.pageNum - 1);
				});
			}
			var nextPageLi = $("<li></li>").append(
					$("<a></a>").append("&raquo;").attr("href", "#"));
			var lastPageLi = $("<li></li>").append(
					$("<a></a>").append("末页").attr("href", "#"));
			ul.append(firstPageLi).append(prePageLi);
			if (result.extend.pageInfo.hasNextPage == false) {
				nextPageLi.addClass("disabled");
				lastPageLi.addClass("disabled");
			} else {
				//分页事件
				nextPageLi.click(function() {
					to_page(result.extend.pageInfo.pageNum + 1);
				});
				lastPageLi.click(function() {
					to_page(result.extend.pageInfo.pages+1);
				});
			}

			$.each(result.extend.pageInfo.navigatepageNums, function(index,
					item) {
				var numLi = $("<li></li>").append($("<a></a>").append(item));
				if (result.extend.pageInfo.pageNum == item) {
					numLi.addClass("active");
				}
				numLi.click(function() {
					to_page(item);
				});
				ul.append(numLi);
			});
			ul.append(nextPageLi).append(lastPageLi);
			var navEle = $("<nav></nav>").append(ul).appendTo("#page_nav_area");
		}
		//获得年月日  
		function getMyDate(str) {
			var oDate = new Date(str), oYear = oDate.getFullYear(), oMonth = oDate
					.getMonth() + 1, oDay = oDate.getDate(), oTime = oYear
					+ '-' + getzf(oMonth) + '-' + getzf(oDay);//最后拼接时间
			return getzf(oTime);
		};
		//获得时分秒 
		function getMyhours(str) {
			var oDate = new Date(str), oHour = oDate.getHours(), oMin = oDate
					.getMinutes(), oSen = oDate.getSeconds(), oTime = getzf(oHour)
					+ ':' + getzf(oMin) + ':' + getzf(oSen);//最后拼接时间
			return oTime;
		}
		//补0操作
		function getzf(num) {
			if (parseInt(num) < 10) {
				num = '0' + num;
			}
			return num;
		}

		/* 点击新增添加模态框 */
		$("#book_add_modal_btn").click(function() {
			reset_form("#bookAddModal form");
			//ajax请求数据
			getRoomInfo("#book_room_add_select");
			//弹出
			$("#bookAddModal").modal({
				backdrop : 'static'
			});
		});
		/* 清除模态框数据 */
		function reset_form(ele) {
			//清楚上一次的表数据
			$(ele)[0].reset();
			//清空样式
			$(ele).find("*").removeClass("has-success has-error");
			$(ele).find("span").text("");
		}
		/* 获得会议室的列表，及其设备信息 */
		function getRoomInfo(ele) {
			$(ele).empty();
			$.ajax({
				url : "${APP_PATH }/room_book_info",
				type : "GET",
				success : function(result) {
					//console.log(result);
					room_info_result = result;
					var index = 0;
					$.each(result.extend.lists, function(index, item) {
						var optionEle = $("<option></option>").append(
								item.roomName).attr("value", item.roomName)
								.attr("ddd", index).appendTo(ele);
						index = index + 1;
					});
					//alert(item[0].roomAddress);
				}
			});
			//添加选择框失去焦点时显示会议室信息
			$(ele).blur(function() {
				var ind =$("#book_room_add_select").find("option:selected").attr("ddd");
				$.each(room_info_result.extend.lists,function(index, item) {
						if (index == ind) {document.getElementById("book_address_span").innerText = "位置："
							+ item.roomAddress;
						$("#book_max_num_span").text("最多人数："+ item.roomMaxNum);
						// $("#book_max_num_address_span").append("位置："+item.roomAddress+"&emsp;&emsp;"+
						// 	"可容纳人数："+item.roomMaxNum);
						$("#book_equip_span").text("已有设备："+ item.roomEquipment);
					}
				});
			});
			//判断员工号是否存在
			$("#book_people_id_add").blur(function() {
				$.ajax({
					url : "${APP_PATH }/people_save_model",
					type : "get",
					data:"id="+document.getElementById("book_people_id_add").value,
					success : function(result) {
						if(result.code==100){
							//添加员工名字和职位
							var item =result.extend.listPeopleInfo;
							$("#people_name_model_span").text("姓名："+ item[0].peoEmployeeName);
							$("#people_post_model_span").text("职位："+ item[0].peoPost);
						}
						else{
							$("#book_people_id_addhelp-block").addClass("form-group has-error");
							$("#people_name_model_span").text("查无此员工号!!");
						}
					}
				});
			});
		}
		//模态框里保存预定记录
		$("#book_add_save_btn").click(function() {
			//1、校验数据,,正则表达式
			
			//ajax保存	
			$.ajax({
				url : "${APP_PATH }/book_save_model",
				type : "post",
				data : $("#bookAddModal form").serialize(),
				success : function(result) {
					if (result.code == 100) {
						//保存成功之后，1、关闭模态框，2、跳到最后一页
						$("#bookAddModal").modal('hide');
						to_page(totalRecord + 1);
					} else {
						alert("保存失败！");
					}
				}
			});
		});
		
		/* 点击编辑添加模态框 */
		//需要在按钮创建之后绑定事件
		$(document).on("click","#table_edit_btn",function () {
			reset_form("#bookEditModal form");
			getRoomInfo("#book_room_edit_select");
			//把员工id传递给模态框的更新按钮
			$("#book_edit_save_btn").attr("edit_id",$(this).attr("index"));
			$("#bookEditModal").modal({
				backdrop:"static"
			});
			
			//获取数据回显
			
			$.ajax({
				url : "${APP_PATH }/book_reback_edit_model",
				type : "get",
				data:"num="+$(this).attr("index"),
				success:function(results){
					if(results.code==100){
						document.getElementById('book_people_id_edit').value=parseInt(results.extend.book.prePeopleId);
						document.getElementById('book_theme_edit').value=results.extend.book.preTheme;
						document.getElementById('book_date_edit').value=getMyDate(results.extend.book.preDay);
						document.getElementById('book_start_time_edit').value=getMyhours(results.extend.book.preStartTime);
						document.getElementById('book_end_time_edit').value=getMyhours(results.extend.book.preEndTime);
						document.getElementById('book_other_edit').value=results.extend.book.other;
						document.getElementById('book_room_edit_select').value=results.extend.book.preRoomNum;
						
						
						var osel=document.getElementById("book_room_edit_select"); //得到select的ID
						var opts=osel.getElementsByTagName("option");//得到数组option
						var i=0;				
						for(;i<2;i++){
							if(opts[i].text==results.extend.book.preRoomNum){
								alert("ok");
								opts.selected=true;
								break;
							}
						}
					}
					else{
						alert("数据回显失败");
					}
				}
			});
		});
		/* 显示表里的删除按钮事件绑定 */
		$(document).on("click","#table_delete_btn",function () {
			var index=$(this).attr("index");
			BootstrapDialog.show({  
	            title: '警告',  
	            message: '确认删除该条记录？？？',  
	            buttons: [{  
	                label: '取消',  
	                action: function(dialog) {  
	                    
	                    dialog.close();
	                }  
	            }, {  
	                label: '确认',  
	                action: function(dialog) { 
	                	$.ajax({
	                		url:"${APP_PATH }/deleteInTable/"+index,
	                		type: "get" ,
	                		//data:"deleteNum="+index,
	                		success:function(result){
	                			if(result.code==100){
	                				alert("删除成功");
	                				dialog.close();
	                				to_page(pageNum);
	                			}
	                			else{
	                				alert("删除失败");
	                			}
	                		}
	                	}) ;
	                }  
	            }]  
	        });
		});
		
		/* 完成全选/全不选 */
		$("#select_all").click(function () {
			//attr和prop区别
			$(".check_item").prop("checked",$(this).prop("checked"));
			
		});
		/* 单个checkbox绑定事件 */
		$(document).on("click",".check_item",function(){
			//选择checked的个数，，总的check_item个数
			var checkedNum= $(".check_item:checked").length;
			var allnum = $(".check_item").length;
			$("#select_all").prop("checked",checkedNum==allnum);
		});
		/* 点击全部删除 */
		$("#delete_checked_btn").click(function () {
			BootstrapDialog.show({  
	            title: '警告',  
	            message: '确认删除多条记录吗？？？',  
	            buttons: [{  
	                label: '取消',  
	                action: function(dialog) {  
	                    dialog.close();
	                }  
	            }, {  
	                label: '确认',  
	                action: function(dialog) { 
	                	var deleteNum="";
	        			
	        			$.each($(".check_item:checked"),function (index,item){
	        				
	        				deleteNum+=$(this).parents("tr").find("td:eq(1)").text()+"-";
	        			});
	        			deleteNum=deleteNum.substring(0,deleteNum.length-1);
	        			
	        			$.ajax({
	        				url:"${APP_PATH }/deleteInTable/"+deleteNum,
	        				type:"DELETE",
	        				success:function(result){
	        					dialog.close();
	        					alert(result.msg);
	        					//回到当前页面
	        					to_page(pageNum);
	        				}
	        			});
	                }  
	            }]  
	        });
			
		});
	</script>
</body>
</html>