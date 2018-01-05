<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>增加OR修改路线</title>
</head>
<body>
	<p>电力巡检系统>> 路线管理>> 增加路线</p>
	<div style="margin-left: 300px; margin-top: 100px; font-size: 14px;">
		<form id="lineForm" class="easyui-form" method="post">
			<div style="float: left; margin-right: 110px;">
				<table style="line-height: 50px;">
					<tr>
						<td>路线编号：</td>
						<td colspan="2"><input id="HidlineCoding"
							value="${line.coding}" type="hidden" /> <input name="coding"
							value="${line.coding}" id="lineCoding" class="easyui-textbox"
							data-options="required:true"
							onchange="validateLine('line',this,'checkLineCoding')" /><span
							id="lineMsg" style="position: absolute; top: 160px;"></span></td>
					</tr>
					<tr>
						<td>路线名称：</td>
						<td><input id="HidlineId" name="id" value="${line.id}"
							type="hidden" /> <input name="name" value="${line.name}"
							class="easyui-textbox" data-options="required:true" /></td>
					</tr>
					<tr>
						<td>路线长度：</td>
						<td><input name="length" value="${line.length}"
							style="width: 100px;" class="easyui-textbox"
							data-options="required:true" /></td>
					</tr>
					<tr>
						<td>回路长度：</td>
						<td><input name="returnWay" value="${line.returnWay}"
							style="width: 100px;" class="easyui-textbox"
							data-options="required:true" /></td>
					</tr>

					<tr>
						<td>投运日期：</td>
						<td><input name="date" value="${line.date}"
							style="width: 100px;" class="easyui-datebox"
							data-options="required:true,editable:false" /></td>
					</tr>

				</table>
			</div>
			<div>
				<table style="line-height: 50px;">

					<tr>
						<td>起始杆号：</td>
						<td><c:choose>
								<c:when test="${!empty line}">
									<input id="startTowerLine" value="${line.startTower}"
										class="easyui-combobox" name="startTower"
										data-options="valueField:'coding',required:true,textField:'coding',url:'getAllTowerData?id=${line.id}&coding=${line.startTower}&flag=true'" />
									<span id="lineTowerMsg"></span>
								</c:when>
								<c:otherwise>
									<input id="startTowerLine" class="easyui-combobox"
										name="startTower"
										data-options="valueField:'coding',required:true,textField:'coding',url:'getAllTowerData'" />
									<span id="lineTowerMsg"></span>
								</c:otherwise>
							</c:choose></td>
					</tr>
					<tr>
						<td>终止杆号：</td>
						<td> <c:choose>
								<c:when test="${empty line}">
									<input id="endTowerLine" value="${line.endTower}"
										name="endTower" class="easyui-textbox"
										data-options="required:true,editable:false" /></td>
						</c:when>
						<c:otherwise>
							<input id="endTowerLine" value="${line.endTower}"
								class="easyui-combobox" name="endTower"
								data-options="valueField:'coding',required:true,textField:'coding',url:'getAllTowerData?id=${line.id}&coding=${line.endTower}&endTower=${line.endTower}'" />
							<span id="lineTowerMsg"></span>
						</c:otherwise>
						</c:choose>
					</tr>
					<tr>
						<td>塔基数：</td>
						<td><input name="redix" value="${line.redix}"
							style="width: 100px;" class="easyui-textbox"
							data-options="required:true" /></td>
					</tr>
					<tr>
						<td>备注：</td>
						<td><input name="remark" value="${line.remark}"
							style="width: 300px; height: 80px;" class="easyui-textbox"
							 /></td>
					</tr>
					<tr>
						<td></td>
                       <td>
							<c:if test="${empty line}">
								启用：<input type="radio" value="0" name="state" />&nbsp;&nbsp;&nbsp;&nbsp;禁用：<input
									type="radio" checked="true" value="1" name="state" />
							</c:if>
						</td>
					</tr>

				</table>
			</div>

			<div style="margin-top: 20px;">
				<a href="javascript:onclick=move('路线管理','intoLine')"
					class="easyui-linkbutton" data-options="iconCls:'icon-cancel'">取
					消</a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<c:choose>
					<c:when test="${empty line}">
						<a href="javascript:onclick=smtLine('addLine')"
							class="easyui-linkbutton" data-options="iconCls:'icon-ok'">提
							交</a>
					</c:when>
					<c:otherwise>
						<a href="javascript:onclick=smtLine('updateLine')"
							class="easyui-linkbutton" data-options="iconCls:'icon-ok'">提
							交</a>
					</c:otherwise>
				</c:choose>

			</div>
		</form>
	</div>
</body>
</html>