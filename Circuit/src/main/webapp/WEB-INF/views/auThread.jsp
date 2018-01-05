<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>增加OR修改线路</title>
</head>
<body>
	<p>电力巡检系统>> 路线管理>> 线路管理>> 增加线路</p>
	<div style="margin-left: 300px; margin-top: 100px; font-size: 14px;">
		<form id="threadForm" class="easyui-form" method="post">
			<div style="float: left; margin-right: 110px;">
				<table style="line-height: 50px;">
					<tr>
						<td>线路编号：</td>
						<td colspan="2"><input id="hidThreadCoding"
							value="${threads.coding}" type="hidden" /> <input
							id="threadCoding" name="coding" value="${threads.coding}"
							class="easyui-textbox" data-options="required:true" /><span
							id="threadMsg" style="position: absolute; top: 160px;"></span></td>
					</tr>
					<tr>
						<td>线路名称：</td>
						<td>
						
						         <input name="name" value="${threads.name}"
							class="easyui-textbox" data-options="required:true" />

						</td>
					</tr>
					<tr>
						<td>路线长度：</td>
						<td><input name="length" value="${threads.length}"
							style="width: 100px;" class="easyui-textbox"
							data-options="required:true" /></td>
					</tr>
					<tr>
						<td>回路长度：</td>
						<td><input name="returnWay" value="${threads.returnWay}"
							style="width: 100px;" class="easyui-textbox"
							data-options="required:true" /></td>
					</tr>
					<tr>
						<td>电压等级：</td>
						<td>						
							
					          <input id="threadRank" value="${threads.rank}"
							class="easyui-combobox" name="rank"	 data-options="valueField:'id',required:true,textField:'settingName',editable:false,url:'thread/getSystemData'" />
					     
					     </td>
					</tr>
				</table>
			</div>
			<div>
				<table style="line-height: 50px;">
					<tr>
						<td>所属线路：</td>
						<td>
							<c:choose>
							  <c:when test="${empty thread}">
							  <input name="lineId" type="hidden" value="${threads.lineId}" />
							  <input id="hdThreadId" value="${threads.id}" type="hidden" name="id" />
							        <input name="lineName" class="easyui-textbox"
										value="${threads.lineName}"
										data-options="plain:true,editable:false" /> 
							  </c:when>
							  <c:otherwise>
							  <input name="lineId" type="hidden" value="${thread.lineId}" />
							          <input name="lineName" class="easyui-textbox"
										value="${thread.lineName}"
										data-options="plain:true,editable:false" />
							  </c:otherwise>
							</c:choose>
							</td>
					</tr>
					<tr>
						<td>起始杆号：</td>
						<td><input id="startTowerThread"
							value="${threads.startTower}" class="easyui-combobox"
							name="startTower"
							data-options="valueField:'coding',required:true,textField:'coding',editable:false" />
							<span id="threadTowerMsg"></span></td>
					</tr>
					<tr>
						<td>终止杆号：</td>
						<td><c:choose>
								<c:when test="${empty threads}">
									<input id="endTowerThread" name="endTower"
										class="easyui-textbox" data-options="required:true" />
								</c:when>
								<c:otherwise>
									<input id="endTowerThread" name="endTower"
										value="${threads.endTower}" class="easyui-combobox"
										data-options="valueField:'coding',required:true,textField:'coding',editable:false,url:'thread/getAllTowerData?lineId=${threads.lineId}&coding=${threads.startTower}'" />
								</c:otherwise>
							</c:choose></td>
					</tr>
					<tr>
						<td>塔基数：</td>
						<td><input name="redix" style="width: 100px;"
							value="${threads.redix}" class="easyui-textbox"
							data-options="required:true" /></td>
					</tr>
					<tr>
						<td>备注：</td>
						<td><input name="remark" value="${threads.remark}"
							style="width: 250px; height: 80px;" class="easyui-textbox" /></td>
					</tr>
					<tr>
						<td></td>
						<td><c:if test="${empty threads}">
								启用：<input type="radio" checked="true" value="0" name="state" />&nbsp;&nbsp;&nbsp;&nbsp;禁用：<input
									type="radio" value="1" name="state" />
							</c:if></td>
					</tr>

				</table>
			</div>

			<div style="margin-top: 20px;">
				<a href="javascript:onclick=move('线路管理','thread/intoThread')"
					class="easyui-linkbutton" data-options="iconCls:'icon-cancel'">取
					消</a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<c:choose>
					<c:when test="${empty threads}">
						<a href="javascript:onclick=smtThread('thread/addThread')"
							class="easyui-linkbutton" data-options="iconCls:'icon-ok'">提
							交</a>
					</c:when>
					<c:otherwise>
						<a href="javascript:onclick=smtUpdate('thread/updateThread')"
							class="easyui-linkbutton" data-options="iconCls:'icon-ok'">提
							交</a>
					</c:otherwise>
				</c:choose>
			</div>
		</form>
	</div>
	<script type="text/javascript" src="js/thread.js"></script>
</body>
</html>