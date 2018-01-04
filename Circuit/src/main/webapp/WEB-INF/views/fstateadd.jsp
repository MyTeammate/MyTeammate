<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加缺陷类型设置</title>
</head>
<body>
	<table>
		<tr>
			<td>缺陷类型名称：</td>
			<td><input id="name" type="text" name="name" style="width:110px"></td>
		</tr>
		<tr>
			<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;启用状态：</td>
			<td>启用<input type="radio" value="0" name="state"/>&nbsp;&nbsp;不启用<input type="radio" value="1" name="state" /></td>
		</tr>
	</table>
</body>
</html>