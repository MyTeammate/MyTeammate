<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>消缺记录统计</title>
</head>
<body>
	<div>
		<div style="height: 25px"></div>
		<div>
			<div style="padding: 0 50px 0 50px">我的工作平台>>消缺记录统计</div>
			<hr />
			<div style="padding: 0 60px 0 230px">
				任务编号：<input type="text" class="easyui-textbox" style="width: 100px" />&nbsp;
				线路编号：<input type="text" class="easyui-textbox" style="width: 100px" />&nbsp;
				 消缺时间：<input type="text" class="easyui-datebox"
					style="width: 100px">&nbsp;-&nbsp; <input type="text"
					class="easyui-datebox" style="width: 100px" />&nbsp;&nbsp; 
					<a type="button" class="easyui-linkbutton" iconCls="icon-magnifier"
					style="width: 60px; height: 25px; background-image: url('image/wx_icps.png');">查询</a>
			</div>
			<div style="padding: 5px 60px 0 820px;">
				<a type="button" class="easyui-linkbutton"
					iconCls="icon-page-white-excel"
					style="width: 100px; height: 25px; background-image: url('image/wx_icps.png')">导出EXCEL</a>
			</div>
			<div
				style="margin-left: 180px; margin-top: 10px; width: 790px; height: 800px">
				<table id="taskE">

				</table>
			</div>
		</div>
	</div>
</body>
</html>