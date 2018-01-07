<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>缺陷查询</title>
</head>
<body>
	<div id="flawQuery_Content" style="padding:10px;height:450px;">
		<p>巡检任务管理>>缺陷查询</p>
		<div id="flawQuery_tool" style="padding-left:25px;">
			<p>
			      任务编号：<input type="text" class="textbox" style="height:22px;" id="taskCoding">&nbsp;&nbsp;
			      线路编号：<input type="text" class="textbox" style="height:22px;" id="threadCoding">&nbsp;&nbsp;
			      缺陷类型： <input type="text" id="inspectionFlawType" name="flawId" />&nbsp;&nbsp;
			      缺陷级别 ： <input type="text" id="inspectionFlawGrade" />
			</p>
			<p>
				<label>下发时间：</label><input class="easyui-datebox" id="inspectionBeginDate1" style="width:120px;">
				&nbsp;-&nbsp;<input class="easyui-datebox" data-options="validType:'md[\'#inspectionBeginDate1\']',editable:false" style="width:120px;" id="flawQueryEnd1">&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;
				<label>发现时间：</label><input class="easyui-datebox" id="inspectionBeginDate2" style="width:120px;">
				&nbsp;-&nbsp;<input class="easyui-datebox" data-options="validType:'md[\'#inspectionBeginDate2\']',editable:false" style="width:120px;" id="flawQueryEnd2">
				&nbsp;&nbsp;&nbsp;
				<a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="flawQuery_onclick.search()">查询</a>
			</p>
			<hr/>
		</div>
		<table id="flawQuery_datagrid" style="height:auto;width:900px;"></table>
	</div>
	<script type="text/javascript" src="js/flawQuery.js"></script>
</body>
</html>