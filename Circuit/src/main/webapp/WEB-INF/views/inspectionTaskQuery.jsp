<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>
   巡检任务管理    >>  巡检任务查看
</p>

    
    <div id="inspectionParent">
    	
    	<div id="inspectionTop">
    		<table id="inspectionTable" cellspacing="20"  >
    		      <tr>
    		          <td><input id="inspectionTaskHdId" type="hidden" value="${inspection.task.id}" /><strong>任务编号：</strong>${inspection.task.coding}</td>
    		          <td><strong>任务名称：</strong>${inspection.task.name}</td>
    		          <td><input id="inspectionHdThreadCoding" type="hidden" value="${threads.coding}" /><strong>巡检线路：</strong>${threads.name}</td>
    		          <td><strong>起始杆号：</strong>${threads.startTower}</td>
    		          <td><strong>结束杆号：</strong>${threads.endTower}</td>
    		      </tr>
    		       <tr>
    		          <td id="downMan"><strong>下发人：</strong>${inspection.task.user.name}</td>
    		          <td id="downDate"><strong>下发时间：</strong>${inspection.task.createdDate}</td>
    		          <td><strong>任务状态：</strong>${inspection.task.state}</td>
    		          <td colspan="2"><strong>任务完成时间：</strong>${inspection.task.actualDate}</td>
    		      </tr>
    		      <tr>
    		          <td colspan="3"><strong>备注：</strong>${inspection.task.remark}</td>
    		          <td colspan="3" id="inspectionStaffs"><strong>巡检员：</strong>
    		           <c:choose>
    		             <c:when test="${staffs!='无'}">
    		                <c:forEach items="${staffs}" var="user">
    		                      ${user.name}、
    		                </c:forEach>
    		             </c:when>
    		             <c:otherwise>
    		                      ${staffs}
    		             </c:otherwise>
    		           </c:choose>
    		          </td>
    		      </tr>
    		</table>
    	</div>
    	<div id="inspectionBottom">
    		
    		<div id="inspectionBottomLeft">
    		  <dl id="inspectionBottomLeftDl">
    		      <dt>${threads.name}</dt>
    		       	<c:if test="${!empty towers}">
    		       	     <c:forEach items="${towers}" var="tower">
    		       	            <dd onclick="inspectionBottomLeftDd(this)" class="inspectionBottomLeftDd">${tower.coding}</dd> 
    		       	     </c:forEach>
    		       	</c:if>	   
    		  </dl>
    		</div>
    		<div id="inspectionU34"><img src="image/u34.png" /></div>
    		<div id="inspectionBottomRight">
    		     <!--<table id="inspectionBottomRightTable" cellspacing="20"  >
    		      <tr>
    		          <td><strong>线路编号：</strong>xw001</td>
    		          <td><strong>杆塔编号：</strong>西尾一号线巡检</td>
    		          
    		      </tr>
    		      <tr>
    		          <td colspan="2"><strong>巡检时间：</strong>2013-12-13</td>
    		          <td></td>
    		      </tr>
    		      <tr>
    		          <td colspan="2"><strong>巡检员：</strong>巡检测试员1、巡检测试员2、巡检测试员3</td>
    		          <td></td>
    		      </tr>
    		      <tr>
    		          <td><strong>下发人员：</strong>线路管理员测试用户01</td>
    		          <td><strong>下发时间：</strong>2013-12-11</td>
    		      </tr>
    		       <tr>
    		          <td><strong>有无故障：</strong>有</td>
    		          <td><strong>完好率：</strong>80%</td>
    		      </tr>
    		      <tr>
    		          <td><strong>缺陷类型：</strong>拦河线断裂</td>
    		          <td><strong>缺陷级别：</strong>一般</td>
    		      </tr>
    		      
    		      <tr>
    		          <td colspan="2"><strong>缺陷描述：</strong>拦河线断裂裂痕不太明显，但需尽快维修</td>
    		          <td></td>
    		      </tr>
    		      <tr>
    		          <td><strong>缺陷发现人：</strong>巡检测试员02</td>
    		          <td><strong>发现时间：</strong>2013-12-11</td>
    		      </tr> 
    		</table>-->
    		</div>
    	</div>
    	
    </div>
    <p id="inspectionP">
   <a href="javascript:onclick=move('巡检任务管理','${lookInspection }')" class="easyui-linkbutton" data-options="iconCls:'icon-arrow-rotate-clockwise',text:'返回',plain:false">返回</a>
</p>
</body>
</html>