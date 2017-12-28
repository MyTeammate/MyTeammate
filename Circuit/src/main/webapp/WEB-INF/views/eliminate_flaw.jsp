<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>消缺任务制定与分配</title>
<style type="text/css">
body {
    line-height:30px;
}
</style>
</head>
<body>
	<div style="padding-left: 20px; padding-top: 15px">消缺任务管理>>消缺任务制度与分配</div>
	<div id="div_toolOne"
		style="text-align: left;">
		任务编号：<input type="text" id="flaw_taskcoding" class="textbox" name="votem" style="width: 220px; height: 22px;" />
		线路编号：<input type="text" id="flaw_linecoding" class="textbox" name="votem" style="width: 220px; height: 22px;" />
		任务状态：<select id="flaw_taskstatus" class="easyui-combobox" name="dept"
			style="width: 80px;">
			<option value="请选择">请选择</option>
		</select>
		<br/>
		下发人：&nbsp;&nbsp;&nbsp;<input type="text" id="flaw_xiapeople" class="textbox" name="votem" style="width: 220px; height: 22px;" />
		下发时间：<input id="flaw_startdate" type="text" class="easyui-datebox">-
		<input id="flaw_enddate" type="text" class="easyui-datebox">
		<a href="#" onclick="search_eliminate()	" class="easyui-linkbutton" iconCls="icon-search">查询</a>
		<a href="javascript:onclick=goto()" class="easyui-linkbutton" style="">制定消缺任务</a>
	</div>
	<hr/>
	<div style="margin-left: 120px;margin-top:20px;width:1000px;height:800px;">
	<table id="flaw_manager">
	</table>
	</div>
</body>
</html>