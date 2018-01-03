<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看消缺任务</title>
<style type="text/css">
table.hovertable {
	font-family: verdana, arial, sans-serif;
	/* font-size: 11px; */
	color: #333333;
	border-width: 1px;
	border-color: #999999;
	border-collapse: collapse;
}

table.hovertable th {
	background-color: #c3dde0;
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #a9c6c9;
}

table.hovertable tr {
	background-color: #d4e3e5;
}

table.hovertable td {
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #a9c6c9;
}
.tdstyle{
font-size: 14px;
font-weight: bold;
}
</style>
</head>
<body>
	<div style="padding-left: 20px; padding-top: 15px">消缺任务管理>>消缺任务制度与分配>>查看缺任务</div>
	<hr />
	<!-- <table style="border: 1px solid red;margin-left: 120px;margin-top:20px;width:800px;height:300px;">
	<tr>
	<td>hh</td>
	<td>fff</td>
	<td>fggg</td>
	<td>grtr</td>
	</tr>
	</table> -->
	<!-- CSS goes in the document HEAD or added to your external stylesheet -->


	<!-- Table goes in the document BODY -->
	<table class="hovertable" style="border: 1px solid red;margin-left: 120px;margin-top:20px;width:800px;height:300px;">
		<!-- <tr>
			<th>Info Header 1</th>
			<th>Info Header 2</th>
			<th>Info Header 3</th>
		</tr> -->
		<tr onmouseover="this.style.backgroundColor='#ffff66';"
			onmouseout="this.style.backgroundColor='#d4e3e5';">
			<td class="tdstyle" style="font-size: 14px;font-weight: bold;">任务编码</td>
			<td>Item 1B</td>
			<td class="tdstyle">任务名称</td>
			<td>Item 1C</td>
		</tr>
		<tr onmouseover="this.style.backgroundColor='#ffff66';"
			onmouseout="this.style.backgroundColor='#d4e3e5';">
			<td class="tdstyle">任务状态</td>
			<td>Item 2B</td>
			<td class="tdstyle">工作单据</td>
			<td>Item 1C</td>
		</tr>
		<tr onmouseover="this.style.backgroundColor='#ffff66';"
			onmouseout="this.style.backgroundColor='#d4e3e5';">
			<td class="tdstyle">任务下发人</td>
			<td>Item 3B</td>
			<td class="tdstyle">任务下发时间</td>
			<td>Item 1C</td>
		</tr>
		<tr onmouseover="this.style.backgroundColor='#ffff66';"
			onmouseout="this.style.backgroundColor='#d4e3e5';">
			<td class="tdstyle">任务负责人</td>
			<td>Item 4B</td>
			<td class="tdstyle">任务描述</td>
			<td>Item 1C</td>
		</tr>
		<tr onmouseover="this.style.backgroundColor='#ffff66';"
			onmouseout="this.style.backgroundColor='#d4e3e5';">
			<td class="tdstyle">消缺员</td>
			<td>Item 5B</td>
			<td class="tdstyle">任务完成时间</td>
			<td>Item 1C</td>
		</tr>
		<tr onmouseover="this.style.backgroundColor='#ffff66';"
			onmouseout="this.style.backgroundColor='#d4e3e5';">
			<td class="tdstyle">负责人审查意见</td>
			<td>Item 5B</td>
			<td class="tdstyle">完成情况描述</td>
			<td>Item 1C</td>
		</tr>
		<tr onmouseover="this.style.backgroundColor='#ffff66';"
			onmouseout="this.style.backgroundColor='#d4e3e5';">
			<td class="tdstyle">下发人审查意见</td>
			<td>Item 5B</td>
			<td>Item 5C</td>
			<td>Item 1C</td>
		</tr>
	</table>

	<a href="javascript:onclick=returntoshou()" class="easyui-linkbutton"
		style="margin-left: 120px;">返回</a>
</body>
</html>