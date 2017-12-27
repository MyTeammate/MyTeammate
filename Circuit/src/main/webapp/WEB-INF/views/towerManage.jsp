<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

      <p>电力巡检系统>>   杆塔管理</p>
       <div style="margin-left: 120px;margin-top:20px;width:1000px;height:800px;">
                      
          <table id="tower"  >
	
         </table>
       </div>
       <div id="towerTb">
	                   所属线路：<select></select>&nbsp;&nbsp;&nbsp;&nbsp;
	                   是否启用：<select></select>&nbsp;&nbsp;&nbsp;&nbsp;
	                   <a href="javascript:onclick=find()" class="easyui-linkbutton" data-options="text:'查   询',plain:false"></a>
			<a href="javascript:onclick=addTower()" class="easyui-linkbutton" style="float: right;" data-options="iconCls:'icon-add',text:'增加杆塔',plain:false"></a>
		</div>
       
         
      <div id="addTower" class="easyui-dialog" title="添加杆塔" style="width:300px;height:250px;"   
        data-options="iconCls:'icon-add',resizable:true,modal:true,closed:true">
        <form id="towerForm"  class="easyui-form" method="post">
	          <table style="margin-left: 20px;margin-top: 20px;line-height: 50px;">
	             <tr>
	                <td>杆塔编号：<input name="coding" style="width:100px;" class="easyui-validatebox" data-options="required:true"  onchange="validate(this)"/><span id="towerMsg"></span></td>
	             </tr>
	             <tr>
	                 <td>&nbsp;&nbsp;&nbsp;&nbsp;启用：<input type="radio" checked="true" value="0" name="state"/>&nbsp;&nbsp;&nbsp;&nbsp;禁用：<input type="radio" value="1" name="state"/></td>
	             </tr>
	             <tr>
	                <td>
		                &nbsp;&nbsp;&nbsp;&nbsp;
		                <input type="button" onclick="close()" value="取 消">
		                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		                <input type="button" onclick="smt()" value="提 交">
	                </td>
	             </tr>
	          </table>
          </form>      
     </div> 
         
</body>
</html>