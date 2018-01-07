<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改消缺任务</title>

<style type="text/css">
body {
	font-size: 14px;
}

#smalldiv {
	line-height: 50px;
}

#smalldiv {
	padding-top: 30px;
}
</style>
	
</head>
<body>
	<div style="padding-left: 20px; padding-top: 15px">消缺任务管理>>消缺任务制度与分配>>修改消缺任务</div>
	<hr />
	<!-- <div style="margin-left: 120px;margin-top:60px;width:900px;height:600px; background-color: #F7F7F7; border: 1px solid #ccc; margin: auto"> -->
	<input value="${updateWait.taskId}" id="taskid" type="hidden"/>
	<input value="${updateWait.id}" id="eliminateId" type="hidden"/>
	<div id="smalldivtwo">
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 任务编码：&nbsp;&nbsp;&nbsp; <input id="update_taskcoding"
			type="text" class="textbox" style="width: 160px; height: 20px;" value="${updateWait.coding}" />
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		任务名称：<input type="text" class="textbox" id="update_taskname"
			style="width: 160px; height: 20px;" value="${updateWait.name}" />
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		任务单据：<select id="update_taskbills" style="width: 160px; height: 25px;" class="easyui-combobox">
			<option value="${updateWait.workbills}">${updateWait.workbills}</option>
		</select> <br /> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 任务负责人：<select id="update_taskMan"
			class="easyui-combobox" style="width: 168px; height: 25px;">
			<option value="${updateWait.mid}">${updateWait.fuzeName}</option>
		</select>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		下发人：${user.name}
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		下发日期：${date} <br /> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		任务描述：&nbsp;&nbsp;&nbsp;
		<textarea id="update_taskDesc" rows="6" cols="24" style="border: 0; overflow: auto;">${updateWait.description}</textarea>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		备注：&nbsp;&nbsp;&nbsp;
		<textarea id="update_taskRemark" rows="6" cols="24" style="border: 0; overflow: auto;">${updateWait.remark}</textarea>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<!-- 消缺员：&nbsp;&nbsp;&nbsp;
		<select id="select_user" multiple="multiple"
	    style="text-align: center; height:100px;width:150px"></select>
		<textarea rows="6" cols="24" style="border: 0; overflow: auto;"></textarea>
	<a href="#" onclick="show()" class="easyui-linkbutton" iconCls="icon-user"></a>  -->
	<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;缺陷列表：
	<a href="javascript:onclick=add_eliminate()" class="easyui-linkbutton">+添加缺陷</a>
	<a href="javascript:onclick=taskSave_update()" class="easyui-linkbutton">保存</a>
	<a href="javascript:onclick=returnto()" class="easyui-linkbutton">返回</a>
	</div>
	<!-- </div> -->
	<div style="margin-left: 120px;margin-top:60px;width:900px;height:600px;">
		<table id="update_wait_manager">
		</table>
	</div>
	<div  id="xun_div" style="margin-left: 200px;margin-top:-550px;width:160px;height:68px;display: none">
	<table id="xun_manager">
	</table>
	<p style="position: relative;bottom: 10px;left: 340px;">
	<a href="#" onclick="xun_hid()" class="easyui-linkbutton" style="float: right;">返回</a>
	<a href="javascript:onclick=save_update()" class="easyui-linkbutton" style="float: right;">保存</a>
	</p>
	</div>
	
	
	<script type="text/javascript" src="js/add_eliminate_flaw.js"></script>
</body>
</html>