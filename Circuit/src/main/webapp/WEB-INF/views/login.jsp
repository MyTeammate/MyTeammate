<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="css/login_style.css">
<body oncontextmenu="return false">

        <div class="page-container">
            <h1 style="color:black;">登录后台管理系统</h1>
            <form action="" method="post">
				<div>
					<input type="text" name="username" style="color:black;" class="username" placeholder="用户名" autocomplete="off"/>
				</div>
                <div>
					<input type="password" name="password" style="color:black;" class="password" placeholder="密码" oncontextmenu="return false" onpaste="return false" />
                </div>
                <button id="submit" style="color:black;" type="button">登录</button>
            </form>
            
        </div>
		<!-- 错误时提示 -->
		<div class="alert" style="display:none">
			<h2>消息</h2>
			<div class="alert_con">
				<p id="ts"></p>
				<p style="line-height:70px"><a class="btn">确定</a></p>
			</div>
		</div>
		<!-- 再加一个弹框，提示登录成功 -->
		

        <!-- Javascript http://apps.bdimg.com/libs/jquery/1.6.4/jquery.min.js-->
		<script src="js/jquery-1.6.4.min.js" type="text/javascript"></script>
        <script src="js/login_base.js"></script>
        <script src="js/login_img_carousel.js"></script>
		<script>
		$(".btn").click(function(){
			is_hide();
		})
		var u = $("input[name=username]");
		var p = $("input[name=password]");
		$("#submit").live('click',function(){
			if(u.val() == '' || p.val() =='')
			{
				$("#ts").html("用户名或密码不能为空~");
				is_show();
				return false;
			}
			else{
				var reg = /^[0-9A-Za-z]+$/;
				if(!reg.exec(u.val()))
				{
					$("#ts").html("用户名不能输入符号，如,");
					is_show();
					return false;
				}else{
					var data={userName:u.val(),passWord:p.val()};
					$.ajax({
						url:"homeController/login",
						type:"post",
						data:data,
						success:function(result){
							if(result==true){
								window.location.href="home";
							}else{
								$("#ts").html("用户名或密码错误！");
								is_show();
							}
						}
					})
				/* 	$("#ts").html("登录成功！");
					is_show(); */
					// 与后台交互
				}
			}
		});
		window.onload = function()
		{
			$(".connect p").eq(0).animate({"left":"0%"}, 600);
			$(".connect p").eq(1).animate({"left":"0%"}, 400);
		}
		function is_hide(){ $(".alert").animate({"top":"-40%"}, 300) }
		function is_show(){ $(".alert").show().animate({"top":"45%"}, 300) }
		</script>
    </body>
</html>