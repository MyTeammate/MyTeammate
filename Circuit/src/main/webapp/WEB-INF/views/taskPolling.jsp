<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>巡检记录统计</title>
</head>
<body>
	<div>
		<div style="height: 25px"></div>
		<div>
			<div style="padding: 0 50px 0 50px;">我的工作平台>>巡检记录统计</div>
			<hr />
			<div style="padding: 0 60px 0 90px">
				任务编号：<input type="text" class="easyui-textbox" style="width: 100px" />&nbsp;
				线路编号：<input type="text" class="easyui-textbox" style="width: 100px" />&nbsp;
				有无故障：<select id="yn" class="easyui-combobox" panelHeight="auto"
					name="dept" style="width: 50px;">
					<option value="3">&nbsp;</option>
					<option value="0">有</option>
					<option value="1">无</option>
				</select>&nbsp; 巡检时间：<input type="text" class="easyui-datebox"
					style="width: 100px">&nbsp;-&nbsp; <input type="text"
					class="easyui-datebox" style="width: 100px" />&nbsp;&nbsp; 
				<a type="button" class="easyui-linkbutton" iconCls="icon-magnifier"
					style="width: 60px; height: 25px; background-image: url('image/wx_icps.png');">查询</a>
			</div>
			<div style="padding: 5px 60px 0 830px;">
				<a type="button" class="easyui-linkbutton"
					iconCls="icon-page-white-excel"
					style="width: 100px; height: 25px; background-image: url('image/wx_icps.png');">导出EXCEL</a>
			</div>
			<div
				style="margin-left: 120px; margin-top: 10px; width: 810px; height: 800px">
				<table id="taskP"></table>
			</div>
		</div>
	</div>
</body>
</html>