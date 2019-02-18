(function($){
	function crateCommentInfo(obj){
		/*
		 * <div class="comment-info">
			<header><img src="./images/img.jpg"></header>
			<div class="comment-right">
				<h3>匿名</h3>
				<div class="comment-content-header"><span><i class="glyphicon glyphicon-time"></i> 2017-10-17 11:42:53</span><span><i class="glyphicon glyphicon-map-marker"></i>深圳</span></div>
				<p class="content">mongodb 副本集配置副本集概念：就我的理解就是和主从复制 差不多，就是在主从复制的基础上多加了一个选举的机制。
				复制集 特点：数据一致性 主是唯一的，没有Mysql 那样的双主结构大多数原则，集群存活节点小于二分之一是集群不可写，
				只可读从库无法写入数据自动容灾通过下面的一个图来简单的了解下
				 配置过程：一、安装mongodb安装过程略，不懂得可以看前面的教程二、创建存储目录与配置文件创...</p>
				<div class="comment-content-footer">
					<div class="row">
						<div class="col-md-10">
							<span><i class="glyphicon glyphicon-pushpin"></i> 来自:win10 </span><span><i class="glyphicon glyphicon-globe"></i> chrome 55.0.2883.87</span>
						</div>
						<div class="col-md-2"><span class="reply-btn">回复</span></div>
					</div>
				</div>
				<div class="reply-list">
					<div class="reply">
						<div><a href="javascript:void(0)">匿名</a>:<a href="javascript:void(0)">@匿名</a><span>这写的是什么鬼东西。。。。</span></div>
						<p><span>2017-10-17 11:42:53</span> <span class="reply-list-btn">回复</span></p>
					</div>
				</div>
			</div>
		</div>
		 * */
		
		if(typeof(obj.time) == "undefined" || obj.time == ""){
			obj.time = getNowDateFormat();
		}
		
		var el = "<div class='comment-info'><header><img src='"+obj.img+"'></header><div class='comment-right'><h5 dat='"+obj.numId+"' data='"+obj.replyId+"'>"+obj.replyName+"</h5>"
				+"<div class='comment-content-header'><span><i class='glyphicon glyphicon-time'></i>"+obj.time+"</span>";
		
		if(typeof(obj.address) != "undefined" && obj.browse != ""){
			el =el+"<span><i class='glyphicon glyphicon-map-marker'></i>"+obj.address+"</span>";
		}
		el = el+"</div><p class='content'>"+obj.content+"</p><div class='comment-content-footer'><div class='row'><div class='col-md-8'>";
		
		if(typeof(obj.osname) != "undefined" && obj.osname != ""){
			el =el+"<span><i class='glyphicon glyphicon-pushpin'></i> 来自:"+obj.osname+"</span>";
		}
		
		if(typeof(obj.browse) != "undefined" && obj.browse != ""){
			el = el + "<span><i class='glyphicon glyphicon-globe'></i> "+obj.browse+"</span>";
		}
		
		el = el + "</div><div class='col-md-4'><span class='reply-btn'>回复</span></div></div></div><div class='reply-list'>";
		if(obj.replyBody != "" && obj.replyBody.length > 0){
			var arr = obj.replyBody;
			for(var j=0;j<arr.length;j++){
				var replyObj = arr[j];
				el = el+createReplyComment(replyObj);
			}
		}
		el = el+"</div></div></div>";
		return el;
	}
	
	//返回每个回复体内容
	function createReplyComment(reply){
		
		var replyEl = "<div class='reply'><div><a href='javascript:void(0)' class='replyname' data='"+reply.replyId+"'>"+reply.replyName+"</a>:<a href='javascript:void(0)'>@"+reply.beReplyName+"</a><span>"+reply.content+"</span></div>"
						+ "<p><span>"+reply.time+"</span> <span class='reply-list-btn'>回复</span></p></div>";
		return replyEl;
	}
	//返回每个回复体内容+ajax
	function createReplyComments(reply,user,path,beReplyid,parentEl){
		
		console.log("reply.:${ sessionScope.currentUser}"+user);
		console.log("==="+user.substring(12,user.length-1));
		var auser = user.substring(12,user.length-1).split(", ");
		var id = auser[1].split("=")[1];
		var name = auser[2].split("=")[1];
		console.log("==="+auser.peoPost);
		var mydata = id+"_"+name+"_"+ parentEl.find("h5").attr('dat')+"_"+beReplyid+"_"+reply.beReplyName+"_"+reply.time+"_"+reply.content;
		alert(mydata);
		var replyEl ;
		$.ajax({
			url:"f/show/addreply",
			type:"GET",
			async: false,
			data:"mydata="+mydata,
			success : function(result) {
				if(result.code==100){
					console.log("保存回复成功");
					replyEl = "<div class='reply'><div><a href='javascript:void(0)' class='replyname'  data='"+id+"'>"+reply.replyName+"</a>:<a href='javascript:void(0)'>@"+reply.beReplyName+"</a><span>"+reply.content+"</span></div>"
						+ "<p><span>"+reply.time+"</span> <span class='reply-list-btn'>回复</span></p></div>";
				}else{
						replyEl="";
				}
			}
		});
		return replyEl;
	}
	function getNowDateFormat(){
		var nowDate = new Date();
		var year = nowDate.getFullYear();
		var month = filterNum(nowDate.getMonth()+1);
		var day = filterNum(nowDate.getDate());
		var hours = filterNum(nowDate.getHours());
		var min = filterNum(nowDate.getMinutes());
		var seconds = filterNum(nowDate.getSeconds());
		return year+"-"+month+"-"+day+" "+hours+":"+min+":"+seconds;
	}
	function filterNum(num){
		if(num < 10){
			return "0"+num;
		}else{
			return num;
		}
	}
	function replyClick(el,user,path){
		console.log("replyClick::");
		console.log(el);
		el.parent().parent().append("<div class='replybox'><textarea cols='80' rows='50' placeholder='来说几句吧......' class='mytextarea' ></textarea><span class='send'>发送</span></div>")
		.find(".send").click(function(){
			var content = $(this).prev().val();
			if(content != ""){
				var parentEl = $(this).parent().parent().parent().parent();
				var obj = new Object();
				var beReplyid;
				var numid = parentEl.find("h5").attr('dat');
				obj.replyName=user.split(", ")[2].split("=")[1];
				if(el.parent().parent().hasClass("reply")){
					console.log("1111");
					obj.beReplyName = el.parent().parent().find("a:first").text();
					beReplyid=el.parent().parent().find("a:first").attr('data');
					//alert("a"+el.parent().parent().find("a:first").attr('data'));
				}else{
					console.log("2222");
					obj.beReplyName=parentEl.find("h5").text();
					beReplyid=parentEl.find("h5").attr('data');
					//alert("h"+parentEl.find("h5").attr('data'));
				}
				console.log(content);
				obj.content=content;
				obj.time = getNowDateFormat();
				var replyString = createReplyComments(obj,user,path,beReplyid,parentEl);
				$(".replybox").remove();
				parentEl.find(".reply-list").append(replyString).find(".reply-list-btn:last").click(function(){alert("不能回复自己");});
			}else{
				alert("空内容");
			}
		});
	}
	
	
	$.fn.addCommentList=function(options,user,path){
		console.log(user+"add");	
		var defaults = {
			data:[],
			add:""
		}
		console.log("addCommentList：进入jquery.comment.js");
		var option = $.extend(defaults, options);
		console.log("options:"+options);
		//加载数据
		if(option.data.length > 0){
			var dataList = option.data;
			var totalString = "";
			for(var i=0;i<dataList.length;i++){
				var obj = dataList[i];
				var objString = crateCommentInfo(obj);
				totalString = totalString+objString;
			}
			$(this).append(totalString).find(".reply-btn").click(function(){
				if($(this).parent().parent().find(".replybox").length > 0){
					$(".replybox").remove();
				}else{
					$(".replybox").remove();
					replyClick($(this),user,path);
				}
			});
			$(".reply-list-btn").click(function(){
				console.log("reply-list-btn");
				if($(this).parent().parent().find(".replybox").length > 0){
					$(".replybox").remove();
				}else{
					$(".replybox").remove();
					replyClick($(this),user,path);
				}
			})
		}
		
		//添加新数据
		if(option.add != ""){
			obj = option.add;
			var str = crateCommentInfo(obj);
			$(this).prepend(str).find(".reply-btn").click(function(){
				replyClick($(this),user,path);
			});
		}
	}
	
	
})(jQuery);