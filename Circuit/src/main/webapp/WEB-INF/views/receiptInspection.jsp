<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>回执录入</title>
</head>
<body style="padding-left:145px;margin-top:45px; ">
	<p style="padding-top:35px;padding-left:25px;">巡检任务管理>>巡检任务执行与回执>>巡检任务回执录入</p>
	<div style="padding:25px;margin-left:35px;font-size:14px;">
		<div id="receiptLeft">
			<ul id="threadTowerTree" class="easyui-tree">   
			   <!--  <li>   
			        <span id="headerThread">Folder</span>   
			        <ul>   
			             <li>   
			                 <span><a href="#">File 11</a></span>   
			             </li>    
			        </ul>   
			    </li>     -->
			</ul>  
		</div>
		<div id="receiptCenterImg">
			<img alt="" src="image/u34.png">
		</div>
		<div id="receiptRight" style="display: block;">
		<form id="receipt_form">
			<table id="receipt_table">
				<tr>
					<td class="leftText">线路编号：</td>
					<td id="threadCoding" style="color:#A1A1A1;"></td>
				</tr>
				<tr>
					<td class="leftText" >杆塔编号：</td>
					<td id="towerCoding"></td>
				</tr>
				<tr>
					<td class="leftText">缺陷类型：</td>
					<td><input type="text" id="inspectionFlawType" name="flawId" /></td>
				</tr>
				<tr>
					<td class="leftText">缺陷级别：</td>
					<td><input type="text" id="inspectionFlawGrade" /></td>
				</tr>
				<tr>
					<td class="leftText">完好率：</td>
					<td style="text-align:center;">
						<span class="text">0%</span>
						<div class="progress">
				            <div class="progress_bg">
				                <div class="progress_bar"></div>
				            </div>
				            <div class="progress_btn"></div>
				        </div>
					</td>
				</tr>
				<tr>
					<td class="leftText">发现时间：</td>
					<td><input type="text" readonly="readonly" style="border:none;color:#A1A1A1;" id="receiptInspectionDate" name="createDate"/></td>
				</tr>
				<tr>
					<td class="leftText">发现人员：</td>
					<td><input type="text" value="${user.name}" readonly="readonly" style="border:none;color:#A1A1A1;"/></td>
				</tr>
				<tr>
					<td class="leftText">缺陷描述：</td>
					<td>
						<textarea cols="25" rows="6" maxlength="250" name="description"></textarea>
					</td>
				</tr>
			</table>
			</form>
		</div>
		
		<p style="padding:25px;">
			<c:if test="${updateReceiptFlag == null }">
					<input type="button" value="上传回执" class="bbb" onClick="executeReceipt()"/>&nbsp;&nbsp;&nbsp;&nbsp;
			</c:if>	
			<span style="padding-left:"></span>
			<input type="button" value="保存" class="bbb" onClick="saveExecuteReceipt()"/>&nbsp;&nbsp;&nbsp;&nbsp;
			<span style="width:50px;"></span>
			<input type="button" value="返回" class="bbb" onClick="backExecuteReceipt()"/>
		</p>
	</div>
	<style type="text/css">
		#receiptLeft{
			width:150px;
			height:400px;
			border:1px solid #7A7A7A;
			float:left;
		}
		#threadTowerTree{
			padding:25px;
			text-align:center;
		}
		#threadTowerTree li{
			padding-left:10px;
			line-height:20px;
		}
		#threadTowerTree a{
			color:#121212;
			list-style:none;
			text-decoration: none;
		}
		#receiptCenterImg{
			margin-right:3px;
			width:100px;
			height:400px;
			float:left;
			border:1px solid white;
			border-right:1px solid #7A7A7A;
		}
		#receiptCenterImg img{
			position: relative;
			left: 40px;
			top: 150px;
			width:20px;
			height:100px;
		}
		#receiptRight{
			width:850px;
			height:400px;
			border:1px solid #7A7A7A;
		}
		.bbb{
			width:95px;
			height:25px;
			border:none;
			background-image:url("image/styled_button_u70.png");
			background-color: #6495ED;
			color:#FFFFFF;
			font-weight: 700;
		}
		#receiptRight table{
			padding:25px;
			margin-left:35px;
		}
		#receiptRight table tr{
			line-height:25px;
		}
		.leftText{
			text-align: right;
		}
		 .progress{position: relative; width:300px;}
        .progress_bg{height: 10px; border: 1px solid #ddd; border-radius: 5px; overflow: hidden;background-color:#f2f2f2;}
        .progress_bar{background: #5FB878; width: 0; height: 10px; border-radius: 5px;}
        .progress_btn{width: 20px; height: 20px; border-radius: 5px; position: absolute;background:#fff; 
        left: 0px; margin-left: -10px; top:-5px; cursor: pointer;border:1px #ddd solid;box-sizing:border-box;}
        .progress_btn:hover{border-color:#F7B824;}
	</style>
	<script type="text/javascript" src="js/receiptInspection.js"></script>
</body>
</html>