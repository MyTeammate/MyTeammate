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
	<table style="margin-left: 200px;margin-top:20px;left:40px;width:630px;">   
	    <tr style="height:30px;float:right">
		   <th>
		    <a id="data_add" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'">新增</a> 
		    <a id="data_delete" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cut'">删除</a>  
		    <a id="data_update" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'">修改</a>  
		    <a id="data_query" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-customers'">配置参数</a>   
	   	   </th>
	    </tr>
	    <tr>
	      <th>
	        <table id="data_tb">
	        	
		    </table>
	      </th>
	    </tr>
	</table>
	<table id="data_add_option">
	</table>
</body>
</html>