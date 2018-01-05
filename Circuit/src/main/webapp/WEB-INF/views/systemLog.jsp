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
    <div style="padding-left: 20px; padding-top: 15px;line-height:20px">系统设置 >> 用户管理 >> log日志</div>
    <div style="border:1px solid #c0c0c0;"></div>
	<table style="margin-left: 220px;margin-top:20px;left:40px;width:735px;">   
	    <tr style="height:30px;">
		   <th>
		    操作时间：<input type='text' id='uentryDate'/>&nbsp;--&nbsp;
		    <input type='text' id='uentryDate2'/>
			<a id="log_query" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</a>
	   	   </th>
	    </tr>
	    <tr>
	      <th>
	        <table id="log_tb">
	        	
		    </table>
	      </th>
	    </tr>
	</table>
		<table id="log_add_option">
		</table>
		<table id="log_update_option"></table>
</body>
</html>