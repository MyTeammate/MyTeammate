<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>缺陷类型设置</title>

<link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css" />
<script type="text/javascript" src="easyui/jquery.min.js"></script>
<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
<script type="text/javascript"	src="easyui/locale/easyui-lang-zh_CN.js"></script>
</head>
<body>
<table id="flaw_datagrid"></table>
<div id="flaw_tool">
<h5>缺陷管理>> 缺陷类型设置</h5>
<p><input type="button" value="添加缺陷类型" onclick="flaw_onclick.add()"/></p>
</div>
<form action="flaw_add" method="post" onsubmit="return flawCreate()" id="fstateadd"></form>
<form id="updateFlaw_form"></form>
<script type="text/javascript" src="js/flaw.js"></script>
</body>
</html>