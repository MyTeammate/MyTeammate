<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>杆塔信息</title>


</head>
<body>
	<div>
		<div style="height: 25px"></div>
		<div>
			<div style="padding: 0 50px 0 50px;">
				我的工作平台>><a href="javascript:onclick=testPo()">巡检记录统计</a>>>杆塔信息巡检信息
			</div>
			<hr />
			<div style="padding: 0 60px 0 230px">
				杆塔编号：<input type="text" class="easyui-textbox" style="width: 100px" />&nbsp;
				缺陷级别：<input type="text" class="easyui-textbox" style="width: 100px" />&nbsp;
				</select>&nbsp; 发现时间：<input type="text" class="easyui-datebox"
					style="width: 100px">&nbsp;-&nbsp; <input type="text"
					class="easyui-datebox" style="width: 100px" />&nbsp;&nbsp; <a
					type="button" class="easyui-linkbutton" iconCls="icon-magnifier"
					style="width: 60px; height: 25px; background-image: url('image/wx_icps.png');">查询</a>
			</div>
			<div style="padding: 5px 60px 0 830px;">
				<a type="button" class="easyui-linkbutton"
					iconCls="icon-page-white-excel"
					style="width: 100px; height: 25px; background-image: url('image/wx_icps.png');">导出EXCEL</a>
			</div>
			<hr />
			<div
				style="margin-left: 150px; margin-top: 10px; width: 810px; height: 100%">
				巡检任务编号：${task.coding }&nbsp;&nbsp;任务名称：${task.tanem }&nbsp;&nbsp;线路编号：${task.threadCoding }
				<hr />
				<input id="co" type="hidden" value="${task.coding }">
				<table id="taskPnew">

				</table>
			</div>
		</div>
	</div>

	<script type="text/javascript" src="js/taskPnew.js"></script>
</body>

</html>