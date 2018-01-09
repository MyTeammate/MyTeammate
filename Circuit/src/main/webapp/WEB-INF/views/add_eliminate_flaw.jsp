<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>制定消缺任务</title>

<style type="text/css">
body {
	font-size: 14px;
}

#smalldiv {
	line-height: 50px;
}

#smalldiv {
	padding-top: 30px;
}
</style>
</head>
<body>
	<div style="padding-left: 20px; padding-top: 15px">消缺任务管理>>消缺任务制度与分配>>制定消缺任务</div>
	<hr />
	<!-- <div style="margin-left: 120px;margin-top:60px;width:900px;height:600px; background-color: #F7F7F7; border: 1px solid #ccc; margin: auto"> -->
	<div id="smalldiv">
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 任务编码：&nbsp;&nbsp;&nbsp; <input id="taskcoding"
			type="text" class="textbox" style="width: 160px; height: 20px;" onblur="moveTrigg()"/>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		任务名称：<input type="text" class="textbox" id="taskname"
			style="width: 160px; height: 20px;" />
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		任务单据：<select id="taskbills" style="width: 160px; height: 25px;">
			<option value="请选择">请选择</option>
		</select> <br /> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 任务负责人：<select id="taskMan"
			class="easyui-combobox" style="width: 168px; height: 25px;">
			<option value="请选择">请选择</option>
		</select>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		下发人：${user.name}
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		下发日期：${date} <br /> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		任务描述：&nbsp;&nbsp;&nbsp;
		<textarea id="taskDesc" rows="6" cols="24" style="border: 0; overflow: auto;"></textarea>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		备注：&nbsp;&nbsp;&nbsp;
		<textarea id="taskRemark" rows="6" cols="24" style="border: 0; overflow: auto;"></textarea>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<!-- 消缺员：&nbsp;&nbsp;&nbsp;
		<select id="select_user" multiple="multiple"
	    style="text-align: center; height:100px;width:150px"></select>
		<textarea rows="6" cols="24" style="border: 0; overflow: auto;"></textarea>
	<a href="#" onclick="show()" class="easyui-linkbutton" iconCls="icon-user"></a>  -->
	<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;缺陷列表：
	<a href="javascript:onclick=add_eliminate()" class="easyui-linkbutton">+添加缺陷</a>
	<a href="javascript:onclick=taskSave()" class="easyui-linkbutton">保存</a>
	<a href="javascript:onclick=returnto()" class="easyui-linkbutton">返回</a>
	</div>
	<!-- </div> -->
	<div style="margin-left: 120px;margin-top:60px;width:900px;height:600px;">
		<table id="add_flaw">
		</table>
	</div>
	<div  id="xun_div" style="margin-left: 200px;margin-top:-550px;width:160px;height:68px;display: none">
	<table id="xun_manager">
	</table>
	<p style="position: relative;bottom: 10px;left: 340px;">
	<a href="#" onclick="xun_hid()" class="easyui-linkbutton" style="float: right;">返回</a>
	<a href="javascript:onclick=save_xun()" class="easyui-linkbutton" style="float: right;">保存</a>
	</p>
	</div>
	<div id="bigdiv" style="background-color:#F7F7F7; border: 1px solid #ccc;width: 305px;height: 195px;position: relative;bottom:550px;left: 380px;display: none;">
	<p style="margin: 0px 0px 0px 0px;font-size: 12px;"><strong>选择消缺员</strong></p>
	<p style="margin: 10px 0px 0px 0px;font-size: 12px;">&nbsp;&nbsp;待选消缺员</p>
	
   	<select id="fb_list" multiple="multiple" style="text-align: center; height:120px;width:128px"></select> 
	<p style="margin: 0px 0px 0px 0px;font-size: 12px;position: relative;top: -135px;left: 180px;">&nbsp;&nbsp;已选消缺员</p>
   <div style="position: relative;left: 170px;bottom: 135px;">
   <select id="select_list" multiple="multiple"
	style="text-align: center; height:120px;width:128px"></select>
   </div>
	<br/>
	<p style="position: relative;bottom: 155px;">
	<a href="#" onclick="hid()" class="easyui-linkbutton" style="float: right;">返回</a>
	<a href="javascript:onclick=save_user()" class="easyui-linkbutton" style="float: right;">保存</a>
	</p>
	<p style="position: relative;bottom: 250px;left: 127px;">
	<a href="#" id="add" class="easyui-linkbutton" style="width: 40px;">+</a></p>
	<p style="position: relative;bottom: 245px;left: 127px;">
	<a href="#" id="delete" class="easyui-linkbutton"style="width: 40px;">&nbsp;-&nbsp;</a></p>
	</div>
	
	<script type="text/javascript" src="js/add_eliminate_flaw.js"></script>
</body>
</html>