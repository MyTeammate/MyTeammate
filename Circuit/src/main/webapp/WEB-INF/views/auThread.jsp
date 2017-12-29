<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>增加OR修改线路</title>
</head>
<body>
<p>电力巡检系统>>   路线管理>>  线路管理>>   增加线路</p>
   <div style="margin-left: 300px;margin-top: 100px;height: 800px;font-size: 14px;">
       <form id="threadForm"  class="easyui-form" method="post">
          <div style="float: left;margin-right: 110px;">
	          <table style="line-height: 50px;">
	             <tr>
	                <td>路线编号：</td>
	                <td colspan="2"><input name="coding" id="threadCoding"  class="easyui-textbox" data-options="required:true"  onchange="validateThread(this)"/><span id="threadMsg" style="position: absolute;top:160px;"></span></td>
	             </tr>
	             <tr>
	                  <td>路线名称：</td>
	                  <td><input name="name"  class="easyui-textbox" data-options="required:true"  /></td>  
	             </tr>
	              <tr>
	                  <td>所属路线：</td>
	                  <td><input name="lineName"  class="easyui-datebox" data-options="required:true,editable:false"  /></td>  
	             </tr>
	             <tr>
	                  <td>路线长度：</td>
	                  <td><input name="length" style="width:100px;" class="easyui-textbox" data-options="required:true"  /></td>  
	             </tr>	             
	             <tr>
	                  <td>回路长度：</td>
	                  <td><input name="returnWay" style="width:100px;" class="easyui-textbox" data-options="required:true"  /></td>  
	             </tr>
	              <tr>
	                  <td>电压等级：</td>
	                  <td><input id="threadRedix" class="easyui-combobox" name="redix"   
                              data-options="valueField:'id',required:true,textField:'settingName',url:'#'" /></td>  
	             </tr>
	          </table >
	         </div>
	         <div>
	          <table style="line-height: 50px;">
	            
	             <tr>
	                  <td>起始杆号：</td>
	                  <td>
	                    <input id="startTowerThread" class="easyui-combobox" name="startTower"   
                              data-options="valueField:'coding',required:true,textField:'coding',url:'getAllTowerData'" /> <span id="threadTowerMsg"></span>
	                  </td>  
	             </tr>
	             <tr>
	                  <td>终止杆号：</td>
	                  <td><input id="endTowerThread"  name="endTower"  class="easyui-textbox" data-options="required:true"  /></td>  
	             </tr>
	             <tr>
	                  <td>塔基数：</td>
	                  <td><input name="redix"  style="width:100px;" class="easyui-textbox" data-options="required:true"  /></td>  
	             </tr>
	              <tr>
	                  <td>备注：</td>
	                  <td><textarea name="remark"  style="width:250px;height: 80px;" class="easyui-textbox" data-options="required:true"  /></td>  
	             </tr>
	              <tr>
	                  <td></td>
	                 <td>启用：<input type="radio" checked="true" value="0" name="state"/>&nbsp;&nbsp;&nbsp;&nbsp;禁用：<input type="radio" value="1" name="state"/></td>
	             </tr>
	             
	          </table>
	          </div>
	          
	               <div style="margin-top: 20px;">	               		             
		                <a  href="javascript:onclick=move('线路管理','thread/intoThread')" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'">取 消</a> 
		                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		                 <a  href="javascript:onclick=smtThread()" class="easyui-linkbutton" data-options="iconCls:'icon-ok'">提  交</a> 
	               </div>
          </form>  
   </div>
</body>
</html>