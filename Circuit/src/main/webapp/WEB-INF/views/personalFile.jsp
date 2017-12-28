<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人资料管理</title>
</head>
<body>
	<div id="pbig_div">
		<div style="height: 25px"></div>
		<div class="div_two">
			<div style="padding: 0 50px 0 50px">我的工作平台>>个人资料管理</div>
			<div style="margin: 20px 200px 0 300px">
				<form action="">
					<div style="margin: 0 200px 0 50px">
						<table>
							<tr>
								<td><strong>用户名：</strong></td>
								<TD><input id="userName" class="text"
									style="width: 200px; padding-top: 4px; margin: 7px 0px;"
									type="text" name="userName" value="admin" disabled="disabled" /></TD>
							</tr>
							<tr>
								<td><strong>用户名称：</strong></td>
								<TD><input id="name" class="text"
									style="width: 200px; padding-top: 4px; margin: 7px 0px;"
									type="text" name="name" value="用户管理员" disabled="disabled"/></TD>
							</tr>
							<tr>
								<td><strong>性别：</strong></td>
								<TD><input id="nan" style="margin: 7px 0px" type="radio"
									checked="checked" name="sex" />男&nbsp;&nbsp; <input id="nv"
									style="margin: 7px 0px" type="radio" name="sex" />女</TD>

							</tr>

							<tr>
								<td><strong>年龄：</strong></td>
								<TD><input id="age" class="text"
									style="width: 200px; padding-top: 4px; margin: 7px 0px;"
									type="text" name="age" value="22"></TD>
							</tr>

							<tr>
								<td><strong>入职日期：</strong></td>
								<TD><input id="entryDate" class="text"
									style="width: 200px; padding-top: 4px; margin: 7px 0px;"
									type="text" name="entryDate" value="2017-2-18" disabled="disabled"></TD>
							</tr>
							<tr>
								<td><strong>离职日期：</strong></td>
								<TD><input id="leaveDate" class="text"
									style="width: 200px; padding-top: 4px; margin: 7px 0px;"
									type="text" name="leaveDate" disabled="disabled"></TD>
							</tr>

							<tr>
								<td><strong>联系电话：</strong></td>
								<TD><input id="phone"
									style="width: 200px; padding-top: 4px; margin: 7px 0px;"
									class="text" type="text" name="phone" value="12524521475"></TD>
							</tr>
							<tr>
								<td><strong>电子邮箱：</strong></td>
								<TD><input id="email"
									style="width: 200px; padding-top: 4px; margin: 7px 0px;"
									class="text" type="text" name="email"value="2239568554@qq.com"></TD>
							</tr>
						</table>
						<div style="margin: 5px 20px 20px 70px">
							<input value="保存修改" type="button">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<input value="取消" type="button">
						</div>
					</div>
				</form>
			</div>
		</div>

	</div>
</body>

</html>