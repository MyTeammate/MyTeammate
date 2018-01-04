<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>线路管理</title>
</head>
<body>
     <p>电力巡检系统>>   路线管理>>    线路管理</p>
       <div style="margin-left: 120px;margin-top:20px;width:1000px;">
                      
          <table id="thread"  >
	
         </table>
       </div>
       <div id="threadTb" style="height:40px;padding-top: 15px;">
       <input id="threadHidden" type="hidden"  />
       <a href="javascript:onclick=move('路线管理','intoLine')" class="easyui-linkbutton" style="float: right;" data-options="iconCls:'icon-arrow-rotate-clockwise',text:'返回',plain:false"></a>
	                   线路编号：<input id="threadCodingLike" class="easyui-textbox" />&nbsp;&nbsp;&nbsp;&nbsp;
	                 线路状态：<input id="threadStateLike" class="easyui-combobox"   
           data-options="valueField:'settingName',textField:'settingName',url:'getSystemDataState?key=RUN_STATE'" /> &nbsp;&nbsp;&nbsp;&nbsp;
	                   <a href="javascript:onclick=loadThread()" class="easyui-linkbutton" data-options="text:'查   询',plain:false"></a>
			<a href="javascript:onclick=addTherad()" class="easyui-linkbutton" style="float: right;" data-options="iconCls:'icon-add',text:'增加线路',plain:false"></a>
		</div>
	<script type="text/javascript" src="js/thread.js"></script>
</body>
</html>