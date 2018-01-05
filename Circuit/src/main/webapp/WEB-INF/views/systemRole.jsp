<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    <div style="padding-left: 20px; padding-top: 15px;line-height:20px">系统管理>>角色管理</div>
    <div style="border:1px solid #c0c0c0;"></div>
	<table style="margin-left: 170px;margin-top:20px;left:40px;width:867px;">   
	    <tr style="height:30px;">
		   <th>
		    用户姓名：<input style="text" size="15"/>&nbsp;&nbsp;&nbsp;使用状况：
		    <select id="role_cc" class="easyui-combobox" name="dept" style="width:80px;" data-options="panelMaxHeight:'70px',editable:false">   
			    <option value="--请选择--">--请选择--</option>   
			    <option value="启用">正常</option>   
			    <option value="未启用">冻结</option>     
			</select>
			<a id="role_query" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</a>
		    <a style="float:right" id="role_add" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'">添加角色</a>    
	   	   </th>
	    </tr>
	    <tr>
	      <th>
	        <table id="role_tb">
	        	
		    </table>
	      </th>
	    </tr>
	</table>
	<!-- <div style="display:none"> -->
		<table id="role_add_option">
		
		   <!-- <tr>
		     <td style='float:right;'>用户账号：</td>
		     <td><input type='text' id='0' name='param' /></td>
		   </tr>
		   <tr>
		     <td style='float:right;'>用户名称：</td>
		     <td><input type='text' id='0' name='param' /></td>
		   </tr>
		   <tr>
		     <td style='float:right;'>密码：</td>
		     <td><input type='text' id='0' name='param' /></td>
		   </tr>
		   <tr>
		     <td style='float:right;'>角色：</td>
		     <td><input type='text' id='0' name='param' /></td>
		   </tr>
		   <tr>
		     <td style='float:right;'>入职时间：</td>
		     <td><input type='text' id='0' name='param' /></td>
		   </tr>
		   <tr>
		     <td style='float:right;'>离职时间：</td>
		     <td><input type='text' id='0' name='param' /></td>
		   </tr>
		   <tr>
		     <td style='float:right;'>使用状态：</td>
		     <td><input type='text' id='0' name='param' /></td>
		   </tr> -->
		</table>
		<table id="role_update_option"></table>
	<!-- </div> -->
</body>
</html>