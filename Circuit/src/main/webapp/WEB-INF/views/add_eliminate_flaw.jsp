<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>制定消缺任务</title>

<style type="text/css">
body {
	font-size: 14px;
}

#smalldiv {
	line-height: 50px;
}

#smalldiv {
	padding-top: 30px;
}
</style>
</head>
<body>
	<div style="padding-left: 20px; padding-top: 15px">消缺任务管理>>消缺任务制度与分配>>制定消缺任务</div>
	<hr />
	<!-- <div style="margin-left: 120px;margin-top:60px;width:900px;height:600px; background-color: #F7F7F7; border: 1px solid #ccc; margin: auto"> -->
	<div id="smalldiv">
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 任务编号：&nbsp;&nbsp;&nbsp; <input
			type="text" class="textbox" style="width: 160px; height: 20px;" />
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		任务编码：<input type="text" class="textbox"
			style="width: 160px; height: 20px;" />
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		任务单据：<select id="taskbills" class="easyui-combobox" style="width: 160px; height: 25px;">
			<option value="请选择">请选择</option>
		</select> <br /> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 任务负责人：<select
			class="easyui-combobox" style="width: 168px; height: 25px;">
			<option value="请选择">请选择</option>
		</select>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		下发人：admin
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		下发日期：2017-12-26 <br /> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		任务描述：&nbsp;&nbsp;&nbsp;
		<textarea rows="6" cols="24" style="border: 0; overflow: auto;"></textarea>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		备注：&nbsp;&nbsp;&nbsp;
		<textarea rows="6" cols="24" style="border: 0; overflow: auto;"></textarea>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		消缺员：&nbsp;&nbsp;&nbsp;
		<textarea rows="6" cols="24" style="border: 0; overflow: auto;"></textarea>
	<a href="#" onclick="show()" class="easyui-linkbutton" iconCls="icon-user"></a> 
	<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;缺陷列表：
	<a href="#" class="easyui-linkbutton">+添加缺陷</a>
	<a href="#" class="easyui-linkbutton">保存</a>
	<a href="javascript:onclick=returnto()" class="easyui-linkbutton">返回</a>
	</div>
	<!-- </div> -->
	<div style="margin-left: 120px;margin-top:60px;width:900px;height:600px;">
		<table id="add_flaw">
		没有数据
		</table>
	</div>
	
	<script type="text/javascript" src="js/add_eliminate_flaw.js"></script>
</body>
</html>