<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    <div style="padding-left: 20px; padding-top: 15px;line-height:20px">系统管理>>数据字典</div>
    <div style="border:1px solid #c0c0c0;"></div>
	<table style="margin-left: 50px;margin-top:20px;left:40px;width:1026px;">   
	    <tr style="height:30px;">
		   <th>
		    用户姓名：<input style="text" size="15"/>&nbsp;&nbsp;&nbsp;使用状况：
		    <select id="user_cc" class="easyui-combobox" name="dept" style="width:80px;" data-options="panelMaxHeight:'70px',editable:false">   
			    <option value="--请选择--">--请选择--</option>   
			    <option value="正常">正常</option>   
			    <option value="冻结">冻结</option>     
			</select>
			<a id="user_query" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</a>
		    <a style="float:right" id="user_add" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'">添加用户</a>    
	   	   </th>
	    </tr>
	    <tr>
	      <th>
	        <table id="user_tb">
	        	
		    </table>
	      </th>
	    </tr>
	</table>
	<table id="user_add_option">
	</table>
</body>
</html>