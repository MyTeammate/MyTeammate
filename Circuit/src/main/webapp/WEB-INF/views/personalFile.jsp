<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
			<hr />
			<div style="margin: 20px 200px 0 300px">
				<form action="">
					<input id="id" class="easyui-textbox" type="hidden"
						value="${user.id }" />
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
								<TD>									
									<input id="name" class="easyui-textbox"
									style="width: 200px; padding-top: 4px; margin: 7px 0px;"
									type="text" name="name" value="${user.name }"
									disabled="disabled" /></TD>
							</tr>
							<tr>
								<td><strong>性别：</strong></td>
								<TD>
								  <c:if test="${user.sex=='男'}">
								     <input id="s" type="hidden" value="${user.sex }" name="ses"/>
									<input id="nan" style="margin: 7px 0px" type="radio"
									value="男" name="sex" checked="checked"/>男&nbsp;&nbsp;
									<input id="nv" style="margin: 7px 0px" type="radio" name="sex"
									value="女"/>女
								  </c:if>
								  <c:if test="${user.sex=='女'}">
								     <input id="s" type="hidden" value="${user.sex }" name="ses"/>
									<input id="nan" style="margin: 7px 0px" type="radio"
									value="男" name="sex" />男&nbsp;&nbsp;
									<input id="nv" style="margin: 7px 0px" type="radio" name="sex"
									value="女" checked="checked"/>女
								  </c:if>
									</TD>

							</tr>

							<tr>
								<td><strong>年龄：</strong></td>
								<TD><input id="age" class="easyui-textbox"
									style="width: 200px; padding-top: 4px; margin: 7px 0px;"
									type="text" name="age" value="${user.age }"></TD>
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
								<TD><input id="phone"
									style="width: 200px; padding-top: 4px; margin: 7px 0px;"
									class="easyui-textbox" type="text" name="phone"
									value="${user.phone }"></TD>
							</tr>
							<tr>
								<td>&nbsp;</td>
							</tr>
							<tr>
								<td><strong>电子邮箱：</strong></td>
								<TD><input id="email"
									style="width: 200px; padding-top: 4px; margin: 7px 0px;"
									class="easyui-textbox" type="text" name="email"
									value="${user.email }"></TD>
							</tr>
						</table>
						<br />
						<div style="margin: 5px 20px 20px 70px">
							<input class="easyui-linkbutton" value="保存修改" type="button"
								style="width: 100px; height: 25px; background-image: url('image/wx_icps.png')">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<input class="easyui-linkbutton" value="取消" type="button"
								style="width: 60px; height: 25px; background-image: url('image/wx_icps.png')">
						</div>
					</div>
				</form>
			</div>
		</div>

	</div>
</body>

</html>