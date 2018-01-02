/*
 * 巡检任务管理 >> 巡检任务制定与分配 >> 制定巡检任务
 */

$(function(){

	$("#taskCoding").validatebox({
		required : true,
		validType : 'checkCoding',
		missingMessage : '请填写任务编号',
	});
	
	$('#taskName').validatebox({
		required : true,
		missingMessage : '请填写任务名称',
	});
	
	$("textarea[name=inspectionStaff]").validatebox({
		required : true,
		missingMessage : '请选择巡检人员',
	});
	
	/*
	 * 巡检线路下拉列表
	 */
	$("#inspectionThread").combobox({
		valueField : 'id',
		textField : 'name',
		editable : false,// 不可编辑，只能选择
		panelHeight : 'auto',
		required : true,
	    missingMessage : '请选择巡检线路',
		url : 'getAllThread',
		onSelect: function(rec){ 
        	$('#startTowerCoding').val('');
        	$('#endTowerCoding').val('');
            $.ajax({
            	url:"getThreadTower",
            	data:{
            		id:rec.id
            	},
            	success:function(data){
            		$('#startTowerCoding').val(data.startTower);
            		$('#endTowerCoding').val(data.endTower);
            	}
            })  
        }
	});
	
	initDate(); // 系统当前时间
	
	$("#add").click(function(){
		  if($("#fb_list option:selected").length>0) {
		   $("#fb_list option:selected").each(function(){
		    $("#select_list").append("<option value='"+$(this).val()+"'>"+$(this).text()+"</option");
		    
		    $(this).remove();
		   })
		  }else {
		   alert("请选择要添加的数据！");
		  }
		 });
		 
		 $("#delete").click(function() {
		   if($("#select_list option:selected").length>0) {
		    $("#select_list option:selected").each(function(){
		     $("#fb_list").append("<option value='"+$(this).val()+"'>"+$(this).text()+"</option");
		      $(this).remove();
		    })
		   }else {
		    alert("请选择要删除的数据！");
		   }
		 });
	
});

/*
 * 显示选择巡检人员div
 */
function show(){
	$("#bigdiv").show(1000);
}

$.extend($.fn.validatebox.defaults.rules, {
	// 巡检任务编号
	checkCoding : {
		validator : function(value) {
			var regphone = /^[0-9A-Za-z]+$/; // 只能为数字和字母
			return regphone.test(value);
		},
		message : '任务编号格式不正确'
	}
});

/*
 * 获取系统当前 年 月日
 */
function initDate(){
	var date = new Date();
	var value = date.getFullYear()+'-'+(date.getMonth()+1)+'-'+date.getDate();
	$("#createInspectionDate").val(value);
}

/*
 * 选择巡检人员点击保存
 */
function save_staffs(){
	var staffs = $.map($("#select_list option:not(:selected)"),
            function(ele){return ele.value} 
         ).join(",");
	$("textarea[name=inspectionStaff]").text(staffs);
}

/*
 * 制定巡检任务 返回按钮操作
 */
function backInspection(){
	var tab = $('#tabs').tabs('getSelected');  // 获取选择的面板
	tab.panel('refresh', 'inspectionMakeAllot');
}

/*
 * 保存前判断是否验证通过
 */
function checkMakeInspection(){
	if($('#inspection_save_form').form('validate')){	
		return true;
	}else{
		return false;
	}
}

function saveInspection(){
	if(checkMakeInspection()){
		var staffs = $.map($("#select_list option:not(:selected)"),
	            function(ele){return ele.value} 
	         ).join(",");
		$.ajax({
			url:'saveInspection',
			type:"POST",
			/*data:{
				coding:$("#taskCoding").val(),
				name:$('#taskName').val(),
				thread:$("#inspectionThread").val(),
				createDate:$("#createInspectionDate").val(),
				remark:$("textarea[name=remark]").val(),
				ids:staffs,
			},*/
			data:$("#inspection_save_form").serialize(),
			success:function(result){
				if(result==true){
					var tab = $('#tabs').tabs('getSelected');  // 获取选择的面板
					tab.panel('refresh', 'inspectionMakeAllot');
				}else{
					$.messager.alert({
						title:'保存失败',
						msg:'<h3 style="color: red;">未知错误导致失败，请重试！</h3>',
						icon:'warning',
					})
				}
				//刷新数据表格
				//$('#serve_datagrid').datagrid('reload');
			}
		})
	}else{
		$.messager.alert({
			title:'警告操作',
			msg:'<h3 style="color: red;">请正确完善信息再提交！</h3>',
			icon:'warning',
		})
	}
}