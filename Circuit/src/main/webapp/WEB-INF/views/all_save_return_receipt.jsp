<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>回执录入</title>
<style type="text/css">
table.hovertable {
	font-family: verdana, arial, sans-serif;
	/* font-size: 11px; */
	color: #d4e3e5;
	border-width: 1px;
	border-color: #d4e3e5;
	border-collapse: collapse;
}

table.hovertable th {
	background-color: #d4e3e5;
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #d4e3e5;
}

table.hovertable tr {
	background-color: #d4e3e5;
}

table.hovertable td {
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #d4e3e5;
}
</style>

</head>
<body>
	<div style="padding-left: 20px; padding-top: 15px">消缺任务管理>>消缺任务执行与回执>>审核</div>
	<hr />
	<!-- <table style="border: 1px solid red;margin-left: 120px;margin-top:20px;width:800px;height:300px;">
	<tr>
	<td>hh</td>
	<td>fff</td>
	<td>fggg</td>
	<td>grtr</td>
	</tr>
	</table> -->
	<!-- CSS goes in the document HEAD or added to your external stylesheet -->


	<!-- Table goes in the document BODY -->
	<input value="${save_eliminateId}" id="all_save_eliminateId" type="hidden"/>
	<table class="hovertable" style="border: 1px solid #ccc;margin-left: 120px;margin-top:20px;width:800px;height:300px;">
		<!-- <tr>
			<th>Info Header 1</th>
			<th>Info Header 2</th>
			<th>Info Header 3</th>
		</tr> -->
		<tr  >
			<td class="tdstyle" style="font-size: 14px;font-weight: bold;border: 1px solid #ccc;">任务编码</td>
			<td style="border: 1px solid #ccc;">${seeEliminate.taskCoding}</td>
			<td style="border: 1px solid #ccc;font-size: 14px;font-weight: bold;" class="tdstyle">任务名称</td>
			<td style="border: 1px solid #ccc;">${seeEliminate.taskName}</td>
		</tr>
		<tr  >
			<td class="tdstyle" style="border: 1px solid #ccc;font-size: 14px;font-weight: bold;">任务状态</td>
			<td style="border: 1px solid #ccc;">${seeEliminate.taskStatus}</td>
			<td class="tdstyle" style="border: 1px solid #ccc;font-size: 14px;font-weight: bold;">工作单据</td>
			<td style="border: 1px solid #ccc;">${seeEliminate.taskBills}</td>
		</tr>
		<tr  >
			<td class="tdstyle" style="border: 1px solid #ccc;font-size: 14px;font-weight: bold;">任务下发人</td>
			<td style="border: 1px solid #ccc;">${seeEliminate.taskxiafaUser}</td>
			<td style="border: 1px solid #ccc;font-size: 14px;font-weight: bold;" class="tdstyle">任务下发时间</td>
			<td style="border: 1px solid #ccc;">${seeEliminate.taskxiafaDate}</td>
		</tr>
		<tr  >
			<td style="border: 1px solid #ccc;font-size: 14px;font-weight: bold;" class="tdstyle">任务负责人</td>
			<td style="border: 1px solid #ccc;">${seeEliminate.taskfuzeUser}</td>
			<td style="border: 1px solid #ccc;font-size: 14px;font-weight: bold;" class="tdstyle">任务描述</td>
			<td style="border: 1px solid #ccc;">${seeEliminate.taskDesc}</td>
		</tr>
		<tr  >
			<td style="border: 1px solid #ccc;font-size: 14px;font-weight: bold;" class="tdstyle">消缺员</td>
			<td style="border: 1px solid #ccc;">
	   <c:forEach items="${userList}" var="l">
	    ${l.name},
	    </c:forEach>
	   </td>
			<td style="border: 1px solid #ccc;font-size: 14px;font-weight: bold;" class="tdstyle">任务完成时间</td>
			<td style="border: 1px solid #ccc;">${seeEliminate.taskfinishDate}</td>
		</tr>
		<tr  >
			<td style="border: 1px solid #ccc;font-size: 14px;font-weight: bold;" class="tdstyle">负责人审查意见</td>
			<td style="border: 1px solid #ccc;">
			<textarea cols="30" rows="5" id="all_fuze_receipte">${seeEliminate.taskfuzeUserIdea}</textarea></td>
			<td style="border: 1px solid #ccc;font-size: 14px;font-weight: bold;" class="tdstyle">完成情况描述</td>
			<td style="border: 1px solid #ccc;">
			<textarea cols="30" rows="5" id="success_desc" readonly="readonly">${seeEliminate.taskCompletionDesc}</textarea></td>
		</tr>
		<tr  >
			<td style="border: 1px solid #ccc;font-size: 14px;font-weight: bold;" class="tdstyle">下发人审查意见</td>
			<td style="border: 1px solid #ccc;">
			<textarea cols="30" rows="5" id="all_xiafa_receipte">${seeEliminate.taskxiafaUserIdea}</textarea></td>
			<td style="border: 1px solid #ccc;font-size: 14px;font-weight: bold;" class="tdstyle" >审核是否通过</td>
			<td style="border: 1px solid #ccc;"><select id="all_pass_select">	
			<option value="0">通过</option>
			<option value="1">不通过</option>

			
			</select></td>;
		</tr>
	</table>
	<p style="font-size: 14px;font-weight: bold;margin-left: 120px;">缺陷信息列表
	<a href="javascript:onclick=save_receipte_all()" class="easyui-linkbutton"
		style="margin-left: 2px;">保存</a>
		<a href="javascript:onclick=returntoshou()" class="easyui-linkbutton"
		style="margin-left: 2px;">返回</a>
	</p>

	<div style="border: 1px solid #ccc;margin-left: 120px;width:800px;height:110px;">
	
	<table id="see_eliminate"></table>
	</div>
	<div style="border: 0px solid red;margin-left: 120px;margin-top:20px;width:800px;height:160px;">
	<p style="font-weight: bold;">工作间断延期记载</p>
	<p><textarea cols="123" rows="5" id="work_record">${seeEliminate.extensionRecord}</textarea></p>
	<p style="font-weight: bold;">工作终结报告</p>
	<p><textarea cols="123" rows="5" id="final_report">${seeEliminate.finalReport}</textarea></p>
	</div>
	<script type="text/javascript" src="js/eliminate_execution_receipt.js"></script>
	<script type="text/javascript" src="js/seeEliminate_details.js"></script>
</body>
</html>