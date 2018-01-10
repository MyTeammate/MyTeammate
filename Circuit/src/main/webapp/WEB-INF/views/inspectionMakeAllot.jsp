<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>巡检任务制定与分配</title>
<style type="text/css">
	.noline{
		text-decoration: none;
		list-style: none;
	}
	#temp{
	   background-color: #000;
	   opacity: 0.3;
	   width: 100%;
	   height: 100%;
	   z-index: 2;
	}
	#bigdiv{
	  background-color: rgb(255,255,255);
	  width: 400px;
	  height: 250px;
	  z-index: 3;
	}
	#main{
	  background-color: rgb(255,255,255);
	  width: 100%;
	  height: 100%;
	  z-index: 1;
	}
</style>
</head>
<body>
	<div id="makeAllot_Content" style="padding:10px;height:450px;">
		<p>巡检任务管理>>巡检任务制定与分配</p>
		<div id="makeAllot_tool" style="padding-left:25px;">
			<p>
			      任务编号：<input type="text" class="textbox" style="height:22px;" id="inspectionCoding">&nbsp;&nbsp;
			      线路编号：<input type="text" class="textbox" style="height:22px;" id="threadCoding">&nbsp;&nbsp;
			      任务状态： <input type="text" id="inspectionState" style="width:120px;"/>&nbsp;&nbsp; 
			</p>
			<p>
				下发人：<input type="text" class="textbox" style="height:22px;" id="taskCreater">&nbsp;&nbsp;
				<label>下发时间：</label><input class="easyui-datebox" id="inspectionBeginDate" style="width:120px;">
				&nbsp;-&nbsp;<input class="easyui-datebox" data-options="validType:'md[\'#inspectionBeginDate\']',editable:false" id="inspectionEndDate" style="width:120px;">
				<a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="inspection_onclick.search()">查询</a>
			</p>
			<hr/>
			<p class="makeAllot_listing" style="text-align:right;padding-right:45px;">
				<a href="javascript:makeInspection()" class="easyui-linkbutton" iconCls="icon-serve-add" plain="true">制定巡检任务</a>
			</p>
		</div>
		<table id="makeAllot_datagrid" style="height:auto;width:900px;"></table>
	</div>
	<div id="temp"></div>
	<div id="main"></div>
	<div id="bigdiv" style="background-color:#F7F7F7; border: 1px solid #ccc;width: 305px;height: 195px;position: relative;bottom:350px;left: 440px;display: none;">
	<p style="margin: 0px 0px 0px 0px;font-size: 12px;"><strong>选择巡检员</strong></p>
	<p style="margin: 10px 0px 0px 0px;font-size: 12px;">&nbsp;&nbsp;待选巡检员</p>
	
   	<select id="fb_list" multiple="multiple" style="text-align: center; height:120px;width:128px"></select> 
	<p style="margin: 0px 0px 0px 0px;font-size: 12px;position: relative;top: -135px;left: 180px;">&nbsp;&nbsp;已选巡检员</p>
   <div style="position: relative;left: 170px;bottom: 135px;">
   <select id="select_list" multiple="multiple"
	style="text-align: center; height:120px;width:128px"></select>
   </div>
	<br/>
	<p style="position: relative;bottom: 155px;">
	<a href="#" onclick="hid()" class="easyui-linkbutton" style="float: right;">返回</a>
	<a href="javascript:onclick=allot_staffs()" class="easyui-linkbutton" style="float: right;">保存</a>
	</p>
	<p style="position: relative;bottom: 250px;left: 127px;">
	<a href="#" id="add" class="easyui-linkbutton" style="width: 40px;">+</a></p>
	<p style="position: relative;bottom: 245px;left: 127px;">
	<a href="#" id="delete" class="easyui-linkbutton"style="width: 40px;">&nbsp;-&nbsp;</a></p>
	</div>
	<script type="text/javascript" src="js/inspectionMakeAllot.js"></script>
</body>
</html>