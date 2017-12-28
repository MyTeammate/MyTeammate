<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table style="padding-left: 20px;top:50px;left:40px;width:500px;background-color: red">   
	    <tr style="height:25px;">
	      <th>系统管理 > > 数据字典</th>
	    </tr>
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
</body>
</html>