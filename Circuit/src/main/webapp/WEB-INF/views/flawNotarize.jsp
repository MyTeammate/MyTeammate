<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>等级确认</title>
</head>
<body>
	<div>缺陷管理>> 缺陷等级确认>> 等级确认</div>
	<table border="2" >
		<tr>
			<td>任务编号：</td>
			<td><input id="userName" class="text"
				style="width: 200px; padding-top: 4px; margin: 7px 0px;" type="text"
				name="taskId" disabled="disabled" /></td>
		</tr>
		<tr>
			<td>线路编号：</td>
			<td><input id="userName" class="text"
				style="width: 200px; padding-top: 4px; margin: 7px 0px;" type="text"
				name="threadId" disabled="disabled" /></td>
		</tr>
		<tr>
			<td>杆塔编号：</td>
			<td><input id="userName" class="text"
				style="width: 200px; padding-top: 4px; margin: 7px 0px;" type="text"
				name="towerId" disabled="disabled" /></td>
		</tr>
		<tr>
			<td>缺陷类型：</td>
			<td><input id="userName" class="text"
				style="width: 200px; padding-top: 4px; margin: 7px 0px;" type="text"
				name="flawId" disabled="disabled" /></td>
		</tr>
		<tr>
			<td>完好率：</td>
			<td><input id="userName" class="text"
				style="width: 200px; padding-top: 4px; margin: 7px 0px;" type="text"
				name="serviceAbility" disabled="disabled" /></td>
		</tr>
		<tr>
			<td>缺陷描述：</td>
			<td><input id="userName" class="text"
				style="width: 200px; padding-top: 4px; margin: 7px 0px;" type="text"
				name="flawDesc" disabled="disabled" /></td>
		</tr>
		<tr>
			<td>发现时间：</td>
			<td><input id="userName" class="text"
				style="width: 200px; padding-top: 4px; margin: 7px 0px;" type="text"
				name="discoverDate" disabled="disabled" /></td>
		</tr>
		<tr>
			<td>发现人：</td>
			<td><input id="userName" class="text"
				style="width: 200px; padding-top: 4px; margin: 7px 0px;" type="text"
				name="userId" disabled="disabled" /></td>
		</tr>
		<tr>
			<td>缺陷等级：</td>
			<td><select style="width:84px" id="plasttim">
			  <option value="请选择" selected="selected">--请选择--</option>
			  <option value="一般">一般</option>
			  <option value="严重">严重</option>
			  <option value="紧急">紧急</option>
		</select></td>
		</tr>
		<tr>
			<td><input value="保存" type="button"></td>
			<td><input value="取消" type="button"></td>
		</tr>
	</table>
</body>
</html>