<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>消缺任务执行与回执</title>

</head>
<body>
	<div style="padding-left: 20px; padding-top: 15px">消缺任务管理>>消缺任务执行与回执</div>
	<div id="div_toolbar" style="text-align: left;">
		任务编号：<input type="text" id="receipt_taskcoding" class="textbox"
			name="votem" style="width: 220px; height: 22px;" />
			 工作单据：<select id="receipt_bills" class="easyui-combobox" name="dept"
			style="width: 80px;"> 
			
		</select><br />
			下发人：&nbsp;&nbsp;&nbsp;<input type="text" id="receipt_xiapeople"
			class="textbox" name="votem" style="width: 220px; height: 22px;" />
		下发时间：<input id="receipt_startdate" type="text" class="easyui-datebox">-
		<input id="receipt_enddate" type="text" class="easyui-datebox"> 
		<a href="#" onclick="search_receipt()" class="easyui-linkbutton"
			iconCls="icon-search">查询</a>
	</div>
	<hr />
	<div
		style="margin-left: 120px; margin-top: 20px; width: 800px; height: 600px;">
		<table id="eliminate_execution_receipt">
		</table>
	</div>
<script type="text/javascript" src="js/eliminate_execution_receipt.js"></script>
</body>
</html>