<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>消缺查询</title>
<style type="text/css">
body {
	line-height: 30px;
}
</style>
</head>
<body>
	<div style="padding-left: 20px; padding-top: 15px">消缺任务管理>>消缺查询</div>
	<div id="div_toolTwo" style="text-align: left;">&nbsp;&nbsp;&nbsp;
		任务编号：<input type="text" id="query_taskcoding" class="textbox"
			name="votem" style="width: 220px; height: 22px;" />&nbsp;&nbsp;&nbsp;
		 缺陷类型：<select id="query_workbills" class="easyui-combobox" name="dept"
			style="width: 80px;">
		<option value="">请选择</option>
		</select> &nbsp;&nbsp;&nbsp;
		任务状态：<select id="query_taskstatus" class="easyui-combobox" name="dept"
			style="width: 80px;">
		<option value="">请选择</option>
		</select> &nbsp;&nbsp;&nbsp;
		缺陷级别：<select id="query_xiapeople" class="easyui-combobox" name="dept"
			style="width: 80px;">
		<option value="">请选择</option>
		</select>
		<br/>&nbsp;&nbsp;&nbsp;
		发现时间：<input id="query_fxstartdate" type="text" class="easyui-datebox">-
		<input id="query_fxenddate" type="text" class="easyui-datebox">&nbsp;&nbsp;&nbsp;
		下发时间：<input id="query_startdate" type="text" class="easyui-datebox">-
		<input id="query_enddate" type="text" class="easyui-datebox">
		
		<a href="#" onclick="elimiates_query()" class="easyui-linkbutton"
			iconCls="icon-search">查询</a>&nbsp;&nbsp;&nbsp;
		<a type="button" class="easyui-linkbutton" id="xqexcel"
					iconCls="icon-page-white-excel"  onclick="exportExcel()"
					style="width: 100px; height: 25px; background-image: url('image/wx_icps.png')">导出EXCEL</a>

	</div>
	<hr />
	<div
		style="margin-left: 30px; margin-top: 20px; width: 1100px; height: 500px;">
		<table id="query_manager">
		</table>
	</div>

</body>
</html>