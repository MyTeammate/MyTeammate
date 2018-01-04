<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>杆塔管理</title>
</head>
<body>

      <p>电力巡检系统>>   杆塔管理</p>
       <div style="margin-left: 120px;margin-top:20px;width:1000px;">
                      
          <table id="tower"  >
	
         </table>
       </div>
       <div id="towerTb" style="height:40px;padding-top: 15px;">
	                   所属路线：<input id="towerLineLike" class="easyui-combobox"   
           data-options="valueField:'id',textField:'name',url:'getLines'" />&nbsp;&nbsp;&nbsp;&nbsp;
	                   是否启用：<input id="towerStateLike" class="easyui-combobox"   
           data-options="valueField:'settingName',textField:'settingName',url:'getSystemDataState?key=STATE'" />&nbsp;&nbsp;&nbsp;&nbsp;
	                   <a href="javascript:onclick=loadTower()" class="easyui-linkbutton" data-options="text:'查   询',plain:false"></a>
			<a href="javascript:onclick=addTower()" class="easyui-linkbutton" style="float: right;" data-options="iconCls:'icon-add',text:'增加杆塔',plain:false"></a>
		</div>
       
         
      <div id="addTower" class="easyui-dialog" title="添加杆塔" style="width:300px;height:250px;"   
        data-options="iconCls:'icon-add',resizable:true,modal:true,closed:true">
        <form id="towerForm"  class="easyui-form" method="post">
	          <table style="margin-left: 20px;margin-top: 20px;line-height: 50px;">
	             <tr>
	                <td>
	                杆塔编号：<input name="coding" id="towerCoding"  style="width:100px;" class="easyui-validatebox" data-options="required:true"  onchange="validateTower(this)"/><span id="towerMsg"></span></td>
	             </tr>
	             <tr>
	                 <td>&nbsp;&nbsp;&nbsp;&nbsp;
	                 
	                                               启用：<input type="radio" checked="true"   value="0" name="state"/>&nbsp;&nbsp;&nbsp;&nbsp;禁用：<input type="radio"   value="1" name="state"/>
	                 </td>
	             </tr>
	             <tr>
	                <td>
		                &nbsp;&nbsp;&nbsp;&nbsp;
		                <a  href="javascript:closeTower()" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'">取 消</a> 
		                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		                 <a  id="smtAddTower"  href="javascript:smtTower()" class="easyui-linkbutton" data-options="iconCls:'icon-ok'">提  交</a>
	                </td>
	             </tr>
	          </table>
          </form>      
     </div> 
     
     <div id="updateTower" class="easyui-dialog" title="修改杆塔" style="width:300px;height:250px;"   
        data-options="iconCls:'icon-add',resizable:true,modal:true,closed:true">
        <form id="towerUpdateForm"  class="easyui-form" method="post">
	          <table style="margin-left: 20px;margin-top: 20px;line-height: 50px;">
	             <tr>
	                <td>
	                <input id="towerCodingHd"  type="hidden" />
	                <input id="towerIdHd" name="id" type="hidden" />
	                杆塔编号：<input name="coding" id="towerUpdateCoding"  style="width:100px;" class="easyui-validatebox" data-options="required:true"  onchange="validateTower(this,'update')"/><span id="towerUpdateMsg"></span></td>
	             </tr>
	             <tr>
	                 <td>&nbsp;&nbsp;&nbsp;&nbsp;
	                 
	                                               启用：<input type="radio" checked="true" class="towerAble"  value="0" name="state"/>&nbsp;&nbsp;&nbsp;&nbsp;禁用：<input type="radio" class="towerAble"  value="1" name="state"/>
	                 </td>
	             </tr>
	             <tr>
	                <td>
	                 &nbsp;&nbsp;&nbsp;&nbsp;
		                <a  href="javascript:closeTowerUpdate()" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'">取 消</a>
		                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		                 <a  id="smtUpdateTower" href="javascript:smtUpdateTower()"  class="easyui-linkbutton" data-options="iconCls:'icon-ok'">提  交</a>
	                </td>
	             </tr>
	          </table>
          </form>      
     </div>
         
</body>
</html>