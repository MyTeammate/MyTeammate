<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>巡检任务执行与回执</title>
</head>
<body>
	<div id="executeReceipt_Content" style="padding:10px;height:450px;">
		<p>巡检任务管理>>巡检任务执行与回执</p>
		<div id="executeReceipt_tool" style="padding-left:25px;">
			<p>
			      任务编号：<input type="text" id="inspectionCoding">&nbsp;&nbsp;
			      线路编号：<input type="text" id="threadCoding">&nbsp;&nbsp;
			      任务状态： <input type="text" id="inspectionState" style="width:120px;"/>&nbsp;&nbsp; 
			</p>
			<p>
				下发人：<input type="text" id="taskCreater">&nbsp;&nbsp;
				<label>下发时间：</label><input class="easyui-datebox" id="inspectionBeginDate" style="width:120px;">
				&nbsp;-&nbsp;<input class="easyui-datebox" data-options="validType:'md[\'#inspectionBeginDate\']',editable:false" style="width:120px;" id="inspectionEndDate">
				<a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="inspection_onclick.search()">查询</a>
			</p>
			<hr/>
		</div>
		<table id="executeReceipt_datagrid" style="height:auto;width:900px;"></table>
	</div>
	<script type="text/javascript" src="js/inspectionMakeAllot.js"></script>
	<script type="text/javascript" src="js/inspectionExecuteReceipt.js"></script>
</body>
</html>