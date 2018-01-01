<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>制定巡检任务</title>
</head>
<body>
	<div id="content" style="width:600px;height:auto;padding-left:25px;">
		<p>巡检任务管理>>巡检任务制定与分配>>制定巡检任务</p>
		<form id="inspection_save_form">
			<table>
				<tr>
					<td class="leftText">任务编码：</td>
					<td><input type="text" id="taskCoding" name="coding"/></td>
				</tr>
				<tr>
					<td class="leftText">任务名称：</td>
					<td><input type="text" id="taskName" name="name"/></td>
				</tr>
				<tr>
					<td class="leftText">巡检线路：</td>
					<td><input type="text" id="inspectionThread" name="thread"/></td>
				</tr>
				<tr>
					<td class="leftText">起始杆号：</td>
					<td><input type="text" id="startTowerCoding" readonly="readonly" /></td>
				</tr>
				<tr>
					<td class="leftText">终止杆号：</td>
					<td><input type="text" id="endTowerCoding" readonly="readonly"/></td>
				</tr>
				<!-- <tr>
					<td class="leftText">巡检员：</td>
					<td><textarea cols="20" rows="3" maxlength="250" readonly="readonly" name="inspectionStaff" placeholder="点击右边头像选择巡检员"/></textarea><a href="#" onclick="show()" class="easyui-linkbutton" iconCls="icon-user"></a></td>
				</tr> -->
				<tr>
					<td class="leftText">下发人：</td>
					<td><input type="text" value="${user.name}" readonly="readonly" style="border:none;color:#A1A1A1;"/></td>
				</tr>
				<tr>
					<td class="leftText">下发日期：</td>
					<td><input type="text" readonly="readonly" style="border:none;color:#A1A1A1;" id="createInspectionDate" name="createDate"/></td>
				</tr>
				<tr>
					<td  class="leftText">备注：</td>
					<td>
						<textarea cols="25" rows="6" maxlength="250" name="remark">无</textarea>
					</td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td class="leftText"><input type="button" value="保存" class="bbb" onclick='javascript:saveInspection()'/></td>
					<td style="padding-left:75px;"><input type="button" value="返回" onclick='javascript:backInspection()' class="bbb"/></td>
				</tr>
			</table>
		</form>
	</div>
	<style type="text/css">
		#content table{
			margin-top:25px;
			margin-left:45px;
			width:500px;
			height:auto;
			line-height: 30px;
			font-size:14px;
		}
		.leftText{
			font-weight: bold;
			text-align: right;
		}
		.bbb{
			width:60px;
			height:25px;
			border:none;
			background-image:url("image/inspection_button.png");
			background-color: #6495ED;
			color:#FFFFFF;
			font-weight: 700;
		}
	</style>
	<script type="text/javascript" src="js/makeInspection.js"></script>
</body>
</html>