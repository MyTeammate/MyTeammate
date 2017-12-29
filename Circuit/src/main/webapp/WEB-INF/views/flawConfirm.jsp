<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>缺陷等级确认</title>
<link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css" />
<script type="text/javascript" src="easyui/jquery.min.js"></script>
<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
<script type="text/javascript"	src="easyui/locale/easyui-lang-zh_CN.js"></script>

</head>
<body>
<table  id="flawCon_datagrid"></table>
	<div id="flawCon_tool"">
	<h5>缺陷管理>> 缺陷等级确认</h5>
	<p style="padding-left:60px;">任务编号：<input type="text" style="width:80px">&nbsp;&nbsp;&nbsp;
	线路编号：<input type="text" style="width:80px">&nbsp;&nbsp;&nbsp;
	杆塔编号：<input type="text" style="width:80px">&nbsp;&nbsp;&nbsp;
	发现人：<input type="text" style="width:80px">&nbsp;&nbsp;&nbsp;
	</p>
	<p style="padding-left:60px;">
	缺陷类型：<select style="width:84px" id="plasttime">
			 <option value="请选择" selected="selected">--请选择--</option>
			 <option value="叉粱断裂">叉粱断裂</option>
			 <option value="拦河线断裂">拦河线断裂</option>
			 <option value="绝缘子爆破">绝缘子爆破</option>
			 <option value="杆塔倾斜">杆塔倾斜</option>
			 <option value="绝缘子爆破">绝缘子爆破</option>
			 <option value="吊杆变形">吊杆变形</option>
			 <option value="其他">其他</option>
		</select>&nbsp;&nbsp;&nbsp;
	缺陷级别：<select style="width:84px" id="plasttim">
			  <option value="请选择" selected="selected">--请选择--</option>
			  <option value="一般">一般</option>
			  <option value="严重">严重</option>
			  <option value="紧急">紧急</option>
		</select>&nbsp;&nbsp;&nbsp;
		<input type="button" value="查询" onclice=""/>
		<input type="button" value="保存" onclice=""/>
	</p>
	<script type="text/javascript" src="js/flawCon.js"></script>
</body>
</html>