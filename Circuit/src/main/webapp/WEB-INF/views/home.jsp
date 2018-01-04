<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="easyui/themes/default/easyui.css" />
<title>电力巡检</title>
<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css" />
<link rel="stylesheet" type="text/css" href="css/home.css" />
<script type="text/javascript" src="easyui/jquery.min.js"></script>
<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="js/home.js"></script>
<script type="text/javascript" src="js/tower.js"></script>
<script type="text/javascript" src="js/perWork.js"></script>
<script type="text/javascript" src="js/taskP.js"></script>
<script type="text/javascript" src="js/taskE.js"></script>
<script type="text/javascript" src="js/perFile.js"></script>
<script type="text/javascript" src="js/perSave.js"></script>
<script type="text/javascript" src="js/flaw_manager.js"></script>
<script type="text/javascript" src="js/systemData.js"></script>
<script type="text/javascript" src="js/systemParam.js"></script>
<script type="text/javascript" src="js/systemUser.js"></script>
<script type="text/javascript" src="js/systemRole.js"></script>





</head>
<body class="easyui-layout" style="width: 1439px; height: 1000px">
	<div
		data-options="region:'north',split:true,noheader:true,iconCls:'icon-premium'"
		style="height: 60px; background: #ccc;">
		<div class="logo">电力巡检§</div>
		<div class="logout">
			您好,&nbsp;${user.name}&nbsp;|&nbsp; <a href="logout">&nbsp;&nbsp;退出</a>
		</div>
		<div class="logout">当前权限：${user.roleName}</div>
	</div>   

	<div data-options="region:'west',title:'     导             航',split:true,iconCls:'icon-world'"
		style="width: 180px; padding: 10px;">
		<ul id="nav"></ul>
	</div>
	<div data-options="region:'center'" style="overflow: hidden; background: #eee;">
		<div id="tabs" class="easyui-tabs" style="height: 750px">
			<div title="起始页" data-options="closable:true,iconCls:'icon-house'"
				class="iconfont .icon-logistic"
				style="padding: 0 10px; display: block;">
				<p style="color: #00EE00;">欢迎来到电力巡检系统！</p>
			</div>
		</div>
    </div>   
  
</body>
</html>