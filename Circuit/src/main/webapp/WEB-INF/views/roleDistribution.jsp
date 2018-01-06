<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>角色权限分配</title>
</head>
<body>
	<p>系统配置>> 角色权限配置</p>
	<div id="roleConfigParent">
		<div id="roleConfigLeft">
		<a href="javascript:onclick=addPowerMenu()"  class="easyui-linkbutton"  data-options="iconCls:'icon-add',text:'增加菜单',plain:true"></a>
		<a href="javascript:onclick=updatePowerMenu()"   class="easyui-linkbutton"  data-options="iconCls:'icon-edit',text:'修改菜单',plain:true"></a>
		<a href="javascript:onclick=deletePowerMenu()"   class="easyui-linkbutton"  data-options="iconCls:'icon-delete',text:'删除菜单',plain:true"></a>
			<p id="roleConfigLeftP">
				<input id="roleConfigCombo" class="easyui-combobox"
					data-options="valueField:'id',textField:'name',value:'---请选择角色---',editable:false,url:'power/getRoles'" />
			</p>
			
			<div id="roleConfigLeftNav">
				<ul id="roleConfigTree">
				      
				</ul>  
			</div>
			
		</div>
		<div id="roleConfigRight">
			<div id="addPowerMenu">
			  <div>
			        <strong>新建菜单节点：</strong><br><hr>
			  </div>
				<form id="menuForm" method="post" class="easyui-form">
					<table cellspacing="20">
						<tr>
							<td>父节点：<input id="parentNodeIdHd" name="nid" type="hidden" /></td>
							<td id="parentNode"></td>
						</tr>
						<tr>
							<td>功能名称： </td>
								<td><input id="powerMenuText" name="text"  class="easyui-textbox"
								data-options="required:true,width:150" /><span id="menuTextMsg"></span></td>
						</tr>
						<tr>
							<td>功能URL：</td>
								<td><input name="url" 
								class="easyui-textbox" data-options="required:true,width:150" /></td>
						</tr>
						<tr>
							<td>打开：<input checked="true" type="radio" value="closed" name="state" /></td>
							<td>关闭：<input
								type="radio"  value="open" name="state" /></td>
						</tr>
						<tr>
							<td>启用：<input checked="true" type="radio" value="0" name="status" /></td>
							<td>禁用：<input
								type="radio"  value="1" name="status" /></td>
						</tr>
					</table>
				</form>
			
				<div style="margin-left: 120px;margin-top: 20px;">
					<a href="javascript:onclick=cancelAddMenu()" class="easyui-linkbutton"
						data-options="iconCls:'icon-cancel'">取 消</a>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a
						href="javascript:onclick=smtAddMenu('power/addMenuNode')" class="easyui-linkbutton"
						data-options="iconCls:'icon-ok'">提 交</a>
				</div>
			</div>
			<div id="updatePowerMenu">
			  <div>
			        <strong>修改菜单节点：</strong><br><hr>
			  </div>
				<form id="menuUpdateForm" method="post" class="easyui-form">
					<table cellspacing="20">
						<tr>
							<td>当前修改节点：
							<input id="powerMenuUpdateNodeIdHd" name="id" type="hidden" />
							<input id="powerMenuUpdateNodeNidHd" name="nid" type="hidden" />
							</td>
							<td id="powerMenuUpdateNode"></td>
						</tr>
						<tr>
							<td>功能名称： </td>
								<td>
								<input id="powerMenuUpdateTextHd" type="hidden" />
								<input id="powerMenuUpdateText" name="text"  style="width:150px;" /><span id="menuUpdateTextMsg"></span></td>
						</tr>
						<tr>
							<td>功能URL：</td>
								<td><input name="url" id="powerMenuUpdateUrl" style="width:150px;" /></td>
						</tr>
						<tr>
							<td>打开：<input class="openOrClosed" checked="true" type="radio" value="closed" name="state" /></td>
							<td>关闭：<input  class="openOrClosed"
								type="radio"  value="open" name="state" /></td>
						</tr>
						<tr>
							<td>启用：<input class="menuPowerAble" checked="true" type="radio" value="0" name="status" /></td>
							<td>禁用：<input class="menuPowerAble"
								type="radio"  value="1" name="status" /></td>
						</tr>
					</table>
				</form>
			
				<div style="margin-left: 120px;margin-top: 20px;">
					<a href="javascript:onclick=cancelUpdateMenu()" class="easyui-linkbutton"
						data-options="iconCls:'icon-cancel'">取 消</a>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a
						href="javascript:onclick=smtUpdateMenu('power/updateMenuNode')" class="easyui-linkbutton"
						data-options="iconCls:'icon-ok'">提 交</a>
				</div>
			</div>
		</div>
	</div>
	<div style="margin-left: 60px;margin-top: 30px;">
	  <a href="javascript:onclick=saveSetting()"  class="easyui-linkbutton"  data-options="iconCls:'icon-save',text:'保存配置',plain:false"></a>
	</div>
	
</body>
</html>