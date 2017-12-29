<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>路线管理</title>

</head>
<body>
    <p>电力巡检系统>>   路线管理</p>
       <div style="margin-left: 120px;margin-top:20px;width:1200px;height:800px;">
                      
          <table id="line"  >
	
         </table>
       </div>
       <div id="lineTb">
	                   路线编号：<input  />&nbsp;&nbsp;&nbsp;&nbsp;
	                   线路状态：<select></select>&nbsp;&nbsp;&nbsp;&nbsp;
	                   <a href="javascript:onclick=find()" class="easyui-linkbutton" data-options="text:'查   询',plain:false"></a>
			<a href="javascript:onclick=move('增加路线','auLine')" class="easyui-linkbutton" style="float: right;" data-options="iconCls:'icon-add',text:'增加路线',plain:false"></a>
		</div>
       
         
      
</body>
</html>