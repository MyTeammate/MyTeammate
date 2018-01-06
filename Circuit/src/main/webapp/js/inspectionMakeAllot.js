/*
 * 巡检管理 >> 巡检任务制定与分配主页
 */

$(function() {

	/*
	 * 模糊查询日期验证
	 */
	$('#inspectionBeginDate').datebox({
		//required : true,
		editable : false,
		validType : 'checkNow',
		missingMessage : '请选择日期',
	});
	$.extend($.fn.validatebox.defaults.rules, {
		checkNow : {
			validator : function(value, param) {
				var now = new Date();
				var date = $.fn.datebox.defaults.parser(value);
				return now >= date;
			},
			message : '所选时间不能超过当前时间！'
		},
		md : {
			validator : function(value, param) {
				var start = $(param[0]).datetimebox('getValue');
				var now = new Date();
				var start2 = $.fn.datebox.defaults.parser(value);
				return now >= start2 && start <= value;
				// 需要进行两个判断，先判断不能超过当前时间，再判断是否大于开始时间
			},
			message : '选择有误！'
		}
	});

	/*
	 * 工具栏巡检任务状态下拉列表
	 */
	$("#inspectionState").combobox({
		valueField : 'id',
		textField : 'settingName',
		editable : false,// 不可编辑，只能选择
		panelHeight : 'auto',
		url : 'getInspectionParam',
		loadFilter : function(data) {
			var obj = {};
			obj.dataid = '-1';
			obj.datavalue = '--请选择--'
			data.splice(0, 0, obj)// 在数组0位置插入obj,不删除原来的元素
			return data;
		},
		onLoadSuccess : function() {
			var data = $(this).combobox('getData');
			if (data.length > 0) {
				$(this).combobox('select', data[0].datavalue);
			}
		}
	});

	/*
	 * 所有巡检任务
	 */
	$("#makeAllot_datagrid").datagrid({
		url : "getInspectionPage",
		method : "POST",
		width : 980,
		/*
		 *  
		 */
		/*height:450,
		fit:true,*/
		fitColumns:true,
		singleSelect:true, //只能选择一行
		rownumbers : true,
		pagination : true,
		pageSize : 5,
		pageList : [ 1, 5, 10, 15, 20 ],
		pageNumber : 1,
		toolbar : '#makeAllot_tool',
		columns : [ [ {
			field : 'id',
			title : '自动编号',
			width : 50,
			checkbox : true,
		}, {
			field : 'coding',
			title : '任务编号',
			width : 80,
			align:"center",
		}, {
			field : 'name',
			title : '任务名称',
			width : 120,
			align:"center",
		}, {
			field : 'thread',
			title : '巡检线路',
			width : 80,
			align:"center",
		}, {
			field : 'startTower',
			title : '起始杆号',
			width : 75,
			align:"center",
		}, {
			field : 'endTower',
			title : '终止杆号',
			width : 75,
			align:"center",
		}, {
			field : 'creater',
			title : '下发人',
			width : 120,
			align:"center",
		}, {
			field : 'createDate',
			title : '下发时间',
			width : 80,
			align:"center",
		}, {
			field : 'state',
			title : '任务状态',
			width : 55,
			align:"center",
			formatter:function(value,row,index){
				var fontColor='';
				if(value=='待分配'){
					fontColor='#FF9900';
				}else if(value=='已分配'){
					fontColor='#0033FF';
				}else if(value=='执行中'){
					fontColor='#FF33CC'
				}else if(value=='已完成'){
					fontColor='#009900';
				}else if(value=='已取消'){
					fontColor='#EE0000';
				}
				return  '<span style="color:'+fontColor+'">'+value+'</span>';
			 }
		}, {
			field : 'actualDate',
			title : '任务完成时间',
			width : 90,
			align:"center",
		}, {
			field : 'operate',
			title : '操作',
			width : 180,
			align:"center",
			formatter:function(value,row,index){
				var oper='';
				if(row.state=='待分配'){
					oper='<span><a href="javascript:lookInspection('+row.id+')" style="text-decoration:none;">查看</a>｜<a href="javascript:showallotInspection('+row.id+')" style="text-decoration:none;">分配任务</a>｜<a href="javascript:updateInspection('+row.id+')" style="text-decoration:none;">修改</a>｜<a href="javascript:cancelInspection('+row.id+')" style="text-decoration:none;">取消</a></span>';
				}else if(row.state=='已分配'){
					oper='<span><a href="javascript:lookInspection('+row.id+')" style="text-decoration:none;">查看</a>｜<a href="javascript:updateallotInspection('+row.id+')" style="text-decoration:none;">修改分配</a>｜<a style="color:#CDC5BF">修改</a>｜<a href="javascript:cancelInspection('+row.id+')" style="text-decoration:none;">取消</a></span>';
				}else{ // if(row.state=='执行中' || row.state=='已完成' || row.state=='已取消')
					oper='<span><a href="javascript:lookInspection('+row.id+')" style="text-decoration:none;">查看</a>｜<a style="color:#CDC5BF">分配任务</a>｜<a style="color:#CDC5BF">修改</a>｜<a style="color:#CDC5BF">取消</a></span>';
				}
				return oper;
			 }
		} ] ],
		emptyMsg : '<h2>无数据</h2>',
		loadFilter : function(data) {
			return data;
		}
	});
	
	/*
	 * 模糊查询
	 */
	inspection_onclick={
			search:function(){
				var startDate = $('#inspectionBeginDate').datebox('isValid');
				var endDate = $('#inspectionEndDate').datebox('isValid');
				if(startDate && endDate){
					$("#makeAllot_datagrid").datagrid('reload', {
						coding : $("#inspectionCoding").val(),
						thread : $("#threadCoding").val(),
						state : $("#inspectionState").combobox('getValue'),
						creater : $("#taskCreater").val(),
						startDate : $("#inspectionBeginDate").val(),
						endDate : $("#inspectionEndDate").val()
					});
				}else{
					console.log('日期验证不通过！');
				}
			}
	}
	
	
	getInspectionStaff(); // 获取所有可用巡检员
	
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

var taskId='';

/*
 * 分配巡检任务
 */
function  allot_staffs(){
	var staffs = $.map($("#select_list option:not(:selected)"),
            function(ele){return ele.value} 
         ).join(",");
	 $("#bigdiv").hide(500);
	 if(staffs==''){
		 $.messager.alert({
				title:'分配失败',
				msg:'<h3 style="color: red;"> 请选择巡检人员 ！</h3>',
				icon:'warning',
				timeout:500,
			})
	 }else{
		 $.ajax({
			 url:'allotInspection',
			 type:"POST",
			 data:{
				 taskId: taskId,
				 users:staffs
			 },
			 success:function(result){
				 if(result==true){
					 $.messager.show({
						title:'提示',
						msg:'巡检任务分配成功',
						timeout:500,
						showType:"slide",
						style:{
						}
					});
				 }else{
					$.messager.alert({
						title:'分配失败',
						msg:'<h3 style="color: red;">未知错误导致失败，请重试！</h3>',
						icon:'warning',
					})
				 }
				 $('#makeAllot_datagrid').datagrid('reload');
			 }
		 });
	 }
}

function hid() {
	$("#bigdiv").hide(600);
}


/*
 * 获取所有可用巡检员
 */
function getInspectionStaff(){
	$.ajax({
		url : "getInspectionStaff",
		type : "post",
		success : function(data) {
			$("#fb_list").html("");
			var str = "";
			if (data) {
				for (var i = 0; i < data.length; i++) {
					str += "<option value='" + data[i].id
							+ "' name='options'>" + data[i].name
							+ "</option>"
				}
			}
			$("#fb_list").append(str);
		}
	});
}

/*
 * 跳转  制定巡检任务页面
 */
function makeInspection(){
	var tab = $('#tabs').tabs('getSelected');  // 获取选择的面板
	tab.panel('refresh', 'makeInspectionTask');
}

/*
 * 跳转  查看巡检任务页面
 */
function lookInspection(id){
	move("查看巡检任务","inspectionTaskQuery?id="+id);
}

/*
 * 显示分配巡检任务的div
 */
function showallotInspection(id){
	$("#bigdiv").show(1000);
	taskId=id;
}

/*
 * 跳转 修改巡检任务页面
 */
function updateInspection(id){
	move("修改巡检任务","updateInspection?id="+id);
}

/*
 * 取消巡检任务
 */
function cancelInspection(id){
	$.messager.confirm('确定','您确定要取消所选的巡检任务吗？',function(f){
		if(f){
			$.ajax({
				url : "cancelInspection",
				type : "post",
				data:{
					taskId:id
				},
				success:function(result){
					if(result){
						 $.messager.show({
							title:'提示',
							msg:'取消成功',
							timeout:500,
							showType:"fade",
							style:{
							}
						});
					}else{
						$.messager.alert({
							title:'取消失败',
							msg:'<h3 style="color: red;">未知错误导致失败，请重试！</h3>',
							icon:'warning',
						})
					}
					//刷新数据表格
					$('#makeAllot_datagrid').datagrid('reload');
				}
			})
		}
	});
}

/*
 * 获取任务被分配人员
 */
function updateallotInspection(id){
	alert('111');
	$.ajax({
		url:"getInspectionTaskStaffs",
		type:"POST",
		data:{
			taskId:id
		},
		success:function(data){
			$("#fb_list").html("");
			var str = "";
			if(data){
				/*for (var i = 0; i < data.length; i++) {
					str += "<option value='" + data[i].id
							+ "' name='options'>" + data[i].name
							+ "</option>"
				}*/
				
				$("#select_list option:not(:selected)").each(
					function() {
						if(data[i].id!=$(this).val()){
							str += "<option value='" + data[i].id + "' name='options'>"
							+ data[i].name + "</option>"
						}
				});
				
				if($("#select_list option:not(:selected)").length>0){
					$("#select_list option:not(:selected)").each(
							function() {
								if(data[i].id!=$(this).val()){
									str += "<option value='" + data[i].id + "' name='options'>"
									+ data[i].name + "</option>"
								}
							});
				}
			}
			$("#fb_list").append(str);
		}
	});
	$("#bigdiv").show(1000);
}

/*
 *  提交 修改分配人员
 */
function update_staffs(){
	var staffs = $.map($("#select_list option:not(:selected)"),
            function(ele){return ele.value} 
         ).join(",");
	 $("#bigdiv").hide(500);
	 if(staffs==''){
		 $.messager.alert({
				title:'修改分配失败',
				msg:'<h3 style="color: red;"> 请选择巡检人员 ！</h3>',
				icon:'warning',
				timeout:500,
			})
	 }else{
		 console.log("taskId:"+taskId);
		/* $.ajax({
			 url:'updateAllotInspection',
			 type:"POST",
			 data:{
				 taskId: taskId,
				 users:staffs
			 },
			 success:function(result){
				 if(result==true){
					 $.messager.show({
						title:'提示',
						msg:'修改分配成功',
						timeout:500,
						showType:"slide",
						style:{
						}
					});
				 }else{
					$.messager.alert({
						title:'修改分配失败',
						msg:'<h3 style="color: red;">未知错误导致失败，请重试！</h3>',
						icon:'warning',
					})
				 }
				 $('#makeAllot_datagrid').datagrid('reload');
			 }
		 });*/
	 }
}
