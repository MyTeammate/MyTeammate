<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>等级确认</title>
</head>
<body>
<table id="flawCon_datagrid"></table>
	<div id="flawCon_tool"">
		<h5>缺陷管理>> 缺陷等级确认</h5>
		<p style="padding-left: 60px;">
			任务编号：<input type="text" style="width: 105px">&nbsp;&nbsp;&nbsp;
			线路编号：<input type="text" style="width: 105px">&nbsp;&nbsp;&nbsp;
			杆塔编号：<input type="text" style="width: 105px">&nbsp;&nbsp;&nbsp;
			发现人：<input type="text" style="width: 107px">&nbsp;&nbsp;&nbsp;
		</p>
		<p style="padding-left: 60px;">
			缺陷类型：<select style="width: 109px" id="plasttime">
				<option value="请选择" selected="selected">--请选择--</option>
				<option value="叉粱断裂">叉粱断裂</option>
				<option value="拦河线断裂">拦河线断裂</option>
				<option value="绝缘子爆破">绝缘子爆破</option>
				<option value="杆塔倾斜">杆塔倾斜</option>
				<option value="绝缘子爆破">绝缘子爆破</option>
				<option value="吊杆变形">吊杆变形</option>
				<option value="其他">其他</option>
			</select>&nbsp;&nbsp;&nbsp; 
			发现时间：<input class="easyui-datebox" id="discoverDate" style="width: 110px;">
			&nbsp;to&nbsp;
			<input class="easyui-datebox" data-options="validType:'md[\'#discoverDate\']',editable:false"
				style="width: 110px;"> 
				<input type="button" value="查询" style="width:70px;" onclice="" /> 
				<input type="button" value="保存" style="width:70px;" onclice="" />
		</p>
		</div>
		<!-- 缺陷等级确认的等级确认弹出框 -->
		<form id="updateflawconfirm">
			<table>
				<tr>
					<td>缺陷等级：</td>
					<td><select style="width:84px" id="GradeId" name="flawGrade">
					  <option value="14">一般</option>
					  <option value="15">严重</option>
					  <option value="16">紧急</option>
				</select></td>
				</tr>
			</table>
			<!-- <input type="hidden" name="id" /> -->
		</form>
<script type="text/javascript" src="js/flawCon.js"></script>
</body>
</html>