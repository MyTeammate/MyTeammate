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
#smalldiv{
  line-height: 50px;
}
#smalldiv {
	padding-top: 30px;
}
</style>
</head>
<body>
	<div
		style="width: 920px; height: 657px; background-color: #F7F7F7; border: 1px solid #ccc; margin: auto">
		<div id="smalldiv">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			任务编号：&nbsp;&nbsp;&nbsp;
			<input type="text" class="textbox"
				style="width: 160px; height: 20px;" />
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			任务编码：<input type="text" class="textbox" style="width: 160px; height: 20px;" />
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			任务单据：<select class="easyui-combobox"
				style="width: 160px; height: 25px;">
				<option value="请选择">请选择</option>
			</select> <br /> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			任务负责人：<select class="easyui-combobox"
				style="width: 168px; height: 25px;">
				<option value="请选择">请选择</option>
			</select>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			下发人：admin
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			下发日期：2017-12-26
			<br/>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			任务描述：&nbsp;&nbsp;&nbsp;
			<textarea rows="6" cols="24" style="border:0;overflow:auto;"></textarea>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			备注：&nbsp;&nbsp;&nbsp;<textarea rows="6" cols="24" style="border:0;overflow:auto;"></textarea>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			消缺员：&nbsp;&nbsp;&nbsp;<textarea rows="6" cols="24" style="border:0;overflow:auto;"></textarea>
			<a href="#" onclick="show()" class="easyui-linkbutton" iconCls="icon-user"></a>
			<br/>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;缺陷列表：<a href="#" class="easyui-linkbutton">+添加缺陷</a>
		</div>
	<table id="add_flaw_manager">
	</table>
	<div id="bigdiv" style="background-color:#F7F7F7; border: 1px solid #ccc;width: 400px;height: 295px;position: relative;bottom:500px;left: 230px;display: none;">
	<p style="margin: 0px 0px 0px 0px;font-size: 12px;"><strong>选择消缺员</strong></p>
	<p style="margin: 10px 0px 0px 0px;font-size: 12px;">&nbsp;&nbsp;待选消缺员</p>
	<textarea rows="15" cols="24" style="border:0;overflow:auto;">
	</textarea>
	<!-- <div style="border: 1px solid blue;width: 160px;height: 200px;margin: 0px 0px 0px 10px;">
	<p id="stay" style="font-size: 12px;line-height: 5px;">消缺员一</p>
	</div> -->
	<p style="margin: 0px 0px 0px 0px;font-size: 12px;position: relative;top: -235px;left: 210px;">&nbsp;&nbsp;已选消缺员</p>
	<textarea rows="15" cols="24" style="border:0;overflow:auto;position: relative;left: 220px;bottom: 235px;">sss</textarea>
	<!-- <div style="border: 1px solid blue;width: 160px;height: 200px;position: relative;left: 220px;bottom: 216px;">
	<p id="yet" style="font-size: 12px;line-height: 5px;">消缺员二</p>
	</div> -->
	<br/>
	<p style="position: relative;left:-20px;bottom: 230px;">
	<a href="#" onclick="hid()" class="easyui-linkbutton" style="float: right;">返回</a>
	<a href="#" class="easyui-linkbutton" style="float: right;">保存</a>
	</p>
	<p style="position: relative;bottom: 400px;left: 175px;">
	<a href="#" class="easyui-linkbutton" style="width: 40px;">+</a></p>
	<p style="position: relative;bottom: 400px;left: 175px;">
	<a href="#" class="easyui-linkbutton"style="width: 40px;">&nbsp;-&nbsp;</a></p>
	</div>
	<a href="#" class="easyui-linkbutton" style="float: right;position: absolute;top: 640px;right:345px;">保存</a>
	<a href="#" onclick="hid()" class="easyui-linkbutton" style="float: right;position: absolute;top: 640px;right:307px;">返回</a>
</body>
</html>