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
	<div style="padding-left: 20px; padding-top: 15px">消缺任务管理>>消缺任务制定与分配</div>
	<div id="div_toolOne"
		style="text-align: left;">
		任务编号：<input type="text" id="flaw_taskcoding" class="textbox" name="votem" style="width: 220px; height: 22px;" />
		工作单据：<input type="text" id="flaw_workbills" class="textbox" name="votem" style="width: 220px; height: 22px;" />
		任务状态：<select id="flaw_taskstatus" class="easyui-combobox" name="dept"
			style="width: 80px;"> 
			<option value="请选择">请选择</option>
		</select>
		<br/>
		下发人：&nbsp;&nbsp;&nbsp;<input type="text" id="flaw_xiapeople" class="textbox" name="votem" style="width: 220px; height: 22px;" />
		下发时间：<input id="flaw_startdate" type="text" class="easyui-datebox">-
		<input id="flaw_enddate" type="text" class="easyui-datebox">
		
		<a href="#" onclick="search_eliminate()	" class="easyui-linkbutton" iconCls="icon-search">查询</a>
		<a href="javascript:onclick=gotoanthor()" class="easyui-linkbutton" style="">制定消缺任务</a>
	</div>
	<hr/>
	<div style="margin-left: 120px;margin-top:20px;width:800px;height:600px;">
	<table id="flaw_manager">
	</table>
	</div>
	<div id="fenpeidiv" style="background-color:#F7F7F7; border: 1px solid #ccc;width: 305px;height: 195px;position: relative;bottom:550px;left: 380px;display: none;">
	<p style="margin: 0px 0px 0px 0px;font-size: 12px;"><strong>选择消缺员</strong></p>
	<p style="margin: 10px 0px 0px 0px;font-size: 12px;">&nbsp;&nbsp;待选消缺员</p>
	
	<select id="fb_list" multiple="multiple" style="text-align: center; height:120px;width:128px"></select> 
	<p style="margin: 0px 0px 0px 0px;font-size: 12px;position: relative;top: -135px;left: 180px;">&nbsp;&nbsp;已选消缺员</p>
   <div style="position: relative;left: 170px;bottom: 135px;">
   <select id="select_list" multiple="multiple"
	style="text-align: center; height:120px;width:128px"></select>
   </div>
	<br/>
	<p style="position: relative;bottom: 155px;">
	<a href="#" onclick="fenpeiHid()" class="easyui-linkbutton" style="float: right;">返回</a>
	<a href="javascript:onclick=fenpei_save_user()" class="easyui-linkbutton" style="float: right;">保存</a>
	</p>
	<p style="position: relative;bottom: 250px;left: 127px;">
	<a href="#" id="add" class="easyui-linkbutton" style="width: 40px;">+</a></p>
	<p style="position: relative;bottom: 245px;left: 127px;">
	<a href="#" id="delete" class="easyui-linkbutton"style="width: 40px;">&nbsp;-&nbsp;</a></p>
	</div>
	<script type="text/javascript" src="js/eliminate_execution_receipt.js"></script>
</body>
</html>