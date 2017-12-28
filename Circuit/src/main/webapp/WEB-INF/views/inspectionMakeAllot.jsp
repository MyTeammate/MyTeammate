<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>巡检任务制定与分配</title>
</head>
<body>
	<div id="makeAllot_Content" style="padding:10px;height:350px;">
		<p>巡检任务管理>>巡检任务制定与分配</p>
		<div id="makeAllot_tool" style="padding-left:25px;">
			<p>
			      任务编号：<input type="text" id="inspectionCoding">&nbsp;&nbsp;
			      线路编号：<input type="text" id="threadCoding">&nbsp;&nbsp;
			      任务状态： <input type="text" id="inspectionState" style="width:120px;"/>&nbsp;&nbsp; 
			</p>
			<p>
				下发人：<input type="text" id="taskCreater">&nbsp;&nbsp;
				<label>下发时间：</label><input class="easyui-datebox" id="inspectionBeginDate" style="width:120px;">
				&nbsp;-&nbsp;<input class="easyui-datebox" required data-options="validType:'md[\'#inspectionBeginDate\']',editable:false" style="width:120px;">
				<a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="serve_onclick.search()">查询</a>
			</p>
			<hr/>
			<p class="makeAllot_listing" style="text-align:right;padding-right:45px;">
				<a href="#" class="easyui-linkbutton" iconCls="icon-serve-add" plain="true" onclick="makeAllot_onclick.add()">制定巡检任务</a>
				<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="makeAllot_onclick.modified()">修改</a>
				<a href="#" class="easyui-linkbutton" iconCls="icon-delete" plain="true" onclick="makeAllot_onclick.remove()">删除</a>
				<a href="#" class="easyui-linkbutton" iconCls="icon-serve-look" plain="true" onclick="makeAllot_onclick.look()">查看</a>
			</p>
			
		</div>
		<!-- <table id="makeAllot_datagrid"></table> -->
	</div>
	<script type="text/javascript" src="js/inspectionMakeAllot.js"></script>
</body>
</html>