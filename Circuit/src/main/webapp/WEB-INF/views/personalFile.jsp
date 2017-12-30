<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人资料管理</title>

</head>
<body onbeforeunload="return CheckUnsave()">
	<div id="pbig_div">
		<div style="height: 25px"></div>
		<div class="div_two">
			<div style="padding: 0 50px 0 50px">我的工作平台>>个人资料管理</div>
			<hr />
			<div style="margin: 20px 200px 0 300px">
				<form id="fr" action="">
					<input id="id" class="easyui-textbox" type="hidden"
						value="${user.id}" />
					<div style="margin: 0 200px 0 50px">
						<table>
							<tr>
								<td><strong>用户名：</strong></td>
								<TD><input id="userName" class="easyui-textbox"
									style="width: 200px; padding-top: 4px; margin: 7px 0px;"
									type="text" name="userName" value="${user.userName }"
									disabled="disabled" /></TD>
							</tr>
							<tr>
								<td>&nbsp;</td>
							</tr>
							<tr>
								<td><strong>用户名称：</strong></td>
								<TD><input id="name" class="easyui-textbox"
									style="width: 200px; padding-top: 4px; margin: 7px 0px;"
									type="text" name="name" value="${user.name }"
									disabled="disabled" /></TD>
							</tr>
							<tr>
								<td><strong>性别：</strong></td>
								<TD><c:if test="${user.sex=='男'}">
										<input id="s" type="hidden" value="${user.sex }" name="ses" />
										<input id="tes" style="margin: 7px 0px" type="radio" value="男"
											name="sex" checked="checked" />男&nbsp;&nbsp;
									<input id="tee" style="margin: 7px 0px" type="radio" name="sex"
											value="女" />女
								  </c:if> <c:if test="${user.sex=='女'}">										
										<input id="tea" style="margin: 7px 0px" type="radio" value="男"
											name="sex" />男&nbsp;&nbsp;
									<input id="teb" style="margin: 7px 0px" type="radio" name="sex"
											value="女" checked="checked" />女
								  </c:if></TD>

							</tr>

							<tr>
								<td><strong>年龄：</strong></td>
								<TD><input id="age" onblur="isAge()"
									style="width: 200px; padding-top: 4px; margin: 7px 0px;"
									type="text" name="age" value="${user.age }" required="true" /><font
									color="red">*</font><span style="color: red" id="agess"></span></TD>
							</tr>
							<tr>
								<td>&nbsp;</td>
							</tr>
							<tr>
								<td><strong>入职日期：</strong></td>
								<TD><input id="entryDate" class="easyui-datebox"
									style="width: 200px; padding-top: 4px; margin: 7px 0px;"
									type="text" name="entryDate" value="${user.entryDate }"
									disabled="disabled"></TD>
							</tr>
							<tr>
								<td>&nbsp;</td>
							</tr>
							<tr>
								<td><strong>离职日期：</strong></td>
								<TD><input id="leaveDate" class="easyui-datebox"
									style="width: 200px; padding-top: 4px; margin: 7px 0px;"
									type="text" value="${user.leaveDate }" name="leaveDate"
									disabled="disabled"></TD>
							</tr>
							<tr>
								<td>&nbsp;</td>
							</tr>
							<tr>
								<td><strong>联系电话：</strong></td>
								<TD><input id="phones" onblur="isPhone()" required="true"
									style="width: 200px; padding-top: 4px; margin: 7px 0px;"
									type="text" name="phone" value="${user.phone }" /><font
									color="red">*</font><span style="color: red" id="Phonenumber"></span></TD>
							</tr>
							<tr>
								<td>&nbsp;</td>
							</tr>
							<tr>
								<td><strong>电子邮箱：</strong></td>
								<TD><input id="emails" onblur="isEmail()" required="true"
									style="width: 200px; padding-top: 4px; margin: 7px 0px;"
									type="text" name="email" value="${user.email }" /><font
									color="red">*</font><span style="color: red" id="emailmsg"></span></TD>
							</tr>
						</table>
						<br />
						<div style="margin: 2px 20px 20px 30px">
							<input id="xiufai" class="easyui-linkbutton" value="保存修改" type="button"
								onclick="perFiles()"
								style="width: 100px; height: 25px; background-image: url('image/wx_icps.png')">
							<input id="pwdup" class="easyui-linkbutton" name="pss" value="修改密码"
								type="button" onclick="perPassword()"
								style="width: 100px; height: 25px; background-image: url('image/wx_icps.png')">
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>


	<div id="updatePass" class="easyui-dialog" title="修改密码"
		style="width: 360px; height: 280px;"
		data-options="resizable:true,modal:true,closed:true">
		<form name="frompas" method="post">
			<input id="pwdsa"
				style="width: 200px; padding-top: 4px; margin: 7px 0px;"
				type="hidden" name="password" value="${user.passWord }" />
			<div style="margin: 30px 20px 0 20px">
				<table>
					<tr>
						<td>旧密码：</td>
						<td><input id="pwd"
							style="width: 200px; padding-top: 4px; margin: 7px 0px;"
							type="password" name="password" onblur="isPas()" required="true"></td>
					</tr>
					<tr>
						<td>新密码：</td>
						<td><input id="repwd" onblur="isReps()"
							style="width: 200px; padding-top: 4px; margin: 7px 0px;"
							type="password" name="Confirm_Password" required="true"></td>
					</tr>
					<tr>
						<td>确认密码：</td>
						<td><input id="repwds" onblur="isRepsT()"
							style="width: 200px; padding-top: 4px; margin: 7px 0px;"
							type="password" name="reposswords" required="true"></td>
					</tr>
				</table>
				<br />
				<div style="margin: 2px 20px 20px 30px">
					&nbsp;&nbsp;&nbsp;&nbsp;<input type="button"  onclick="updatePwd()"
						style="width: 100px; height: 25px; background-image: url('image/wx_icps.png')"
						value="修改"  />
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset"
						style="width: 100px; height: 25px; background-image: url('image/wx_icps.png')"
						value="重置" />
				</div>
			</div>
		</form>
	</div>
</body>

</html>