function eliminate() {
	$("#flaw_manager").datagrid({
						url : "eliminate/getAll",
						queryParams: {          
					          operate: 'flaw'            
					    },
						height : 370,
						width : 850,
						pagination : true,
						pageNumber : 1,
						pageSize : 10,
						rownumbers : true,
						pagination : true,
						pageList : [ 10, 20, 30, 40 ],
						columns : [ [{field : 'id',title : '自动编号',width : 82,checkbox : true},
						{field : 'taskcoding',title : '任务编号',width : 82,align : 'center'},
						{field : 'taskName',title : '任务名称',width : 82,align : 'center'},
						{field : 'workBills',title : '工作单据',width : 82,align : 'center'},
						{field : 'xiafaMan',title : '下发人',width : 92,align : 'center'},
						{field : 'xiafaDate',title : '下发时间',width : 82,align : 'center'},
						{field : 'taskStatus',title : '任务状态',width : 82,align : 'center',
						formatter : function(value, row, index) {
							var fontColor = '';
							if (value == '待分配') {
								fontColor = '#FF9900';
							} else if (value == '已分配') {
								fontColor = '#0033FF';
							} else if (value == '执行中') {
								fontColor = '#FF33CC'
							} else if (value == '已完成') {
								fontColor = '#009900';
							} else if (value == '已取消') {
								fontColor = '#FF3030'
							}else if (value == '待审核'){
								fontColor = '#7D26CD';
							}else if (value == '已驳回') {
								fontColor = '#FF3030'
							}
							return '<span style="color:'
									+ fontColor + '">' + value
									+ '</span>';
						}
						},
						{field : 'wancdate',title : '任务完成时间',width : 82,align : 'center'},
						/*
						 * {field : 'flag',title : '任务是否取消',width :
						 * 82,align : 'center'},
						 */
						{field : 'operation',title : '操作',width : 170,align : 'center',
						formatter : function(value, row, index) {
								var oper = '';
								if (row.taskStatus == '待分配') {
									oper = '<span><a href="javaScript:seeEliminate('
											+ row.id
											+ ')">查看</a>｜'
											+ '<a href="javaScript:fenpeiEliminate('
											+ row.id
											+ ')">分配任务</a>｜'
											+ '<a href="javaScript:update_wait('
											+ row.id
											+ ')">修改</a>｜'
											+ '<a href="javaScript:cancelEminate('
											+ row.id
											+ ')">取消</a></span>';
								} else if (row.taskStatus == '已分配') {
									oper = '<span><a href="javaScript:seeEliminate('
											+ row.id
											+ ')">查看</a>｜'
											+ '<a href="javaScript:fenpeiEliminate('
											+ row.id
											+ ')">分配任务</a>｜<a style="color:#CDC5BF">修改</a>｜'
											+ '<a style="color:#CDC5BF">取消</a></span>';
								} else if (row.taskStatus == '执行中') {
									oper = '<span><a href="javaScript:seeEliminate('
											+ row.id
											+ ')">查看</a>｜'
											+ '<a style="color:#CDC5BF">分配任务</a>｜<a style="color:#CDC5BF">修改</a>｜'
											+ '<a style="color:#CDC5BF">取消</a></span>';
								} else if (row.taskStatus == '已完成') {
									oper = '<span><a href="javaScript:seeEliminate('
											+ row.id
											+ ')">查看</a>｜'
											+ '<a style="color:#CDC5BF">分配任务</a>｜'
											+ '<a href="javaScript:audit_eliminate('
											+ row.id
											+ ')">审查</a>｜'
											+ '<a style="color:#CDC5BF">取消</a></span>';
								} else if (row.taskStatus == '已取消') {
									oper = '<span><a href="javaScript:seeEliminate('
											+ row.id
											+ ')">查看</a>｜'
											+ '<a style="color:#CDC5BF">分配任务</a>｜<a style="color:#CDC5BF">修改</a>｜'
											+ '<a style="color:#CDC5BF">取消</a></span>';
								}else if (row.taskStatus == '待审核') {
									oper = '<span><a href="javaScript:seeEliminate('
										+ row.id
										+ ')">查看</a>｜'
										+ '<a style="color:#CDC5BF">分配任务</a>｜<a href="javaScript:audit_eliminate('
										+ row.id
										+ ')">审核</a>｜'
										+ '<a style="color:#CDC5BF">取消</a></span>';
							} else if (row.taskStatus == '已驳回') {
								oper = '<span><a href="javaScript:seeEliminate('
									+ row.id
									+ ')">查看</a>｜'
									+ '<a style="color:#CDC5BF">回执录入</a>｜<a style="color:#CDC5BF">执行</a>｜'
									+ '<a href="javaScript:update_return_Eliminate_receipte('
									+ row.id
									+ ')">修改</a></span>';
						}
								return oper;
							}
						} ] ],
				toolbar : "#div_toolOne",
				emptyMsg : '<h2 style="color:#FF3E96">没有消缺任务哟</h2>',
				
			});
	$('#flaw_taskstatus').combobox({
		url : 'eliminate/getAllstatus?coding='+'TASK_STATE',
		valueField : 'id',
		textField : 'settingName',
		width : 154,
	});
	$('#update_taskbills').combobox({
		url : 'eliminate/getBills',
		valueField : 'id',
		textField : 'settingName',
		width : 154,
	});
	$('#update_taskMan').combobox({
		url : 'eliminate/getLineUser',
		valueField : 'id',
		textField : 'name',
		width : 154,
	});
	/*$.ajax({
		url:"eliminate/getAllstatus",
		type:"post",
		success:function(data){
			$("#flaw_taskstatus").html("");
			var str = "";
			if (data) {
				for (var i = 0; i < data.length; i++) {
					str += "<option value='" + data[i].id + "' name='options'>"
							+ data[i].settingName + "</option>"
				}
			}
			console.log(str);
			$("#flaw_taskstatus").append(str);
		}
	});*/
}
function update_wait(id){
	
	move("修改任务","http://localhost:8080/Circuit/eliminate/update_wait_eliminate?id="+id);
}

/*//保存修改
function taskSave_update(){
	alert(1);
	var update_taskcoding = $("#update_taskcoding").val();
	var update_taskname = $("#update_taskname").val();
	alert($("#update_taskbills").combobox('getText'));
	var taskbills = $("#update_taskbills").combobox('getText');
	
	var taskMan = $("#update_taskMan").combobox('getValue');
	var update_taskDesc = $("#update_taskDesc").val();
	var update_taskRemark = $("#update_taskRemark").val();
	var taskid = $("#taskid").val();
	var eliminateId = $("#eliminateId").val();
	console.log(taskbills,taskMan);
	$.ajax({
		url:"eliminate/update_task_eliminate",
		type:"post",
		data:{
			update_taskcoding:update_taskcoding,
			update_taskname:update_taskname,
			taskbills:taskbills,
			taskMan,taskMan,
			update_taskDesc:update_taskDesc,
			update_taskRemark:update_taskRemark,
			taskid:taskid
		},
		success:function(data){
			if(data=="true"){
				$.messager.show({
					title : '友好提示您',
					msg : '<h3 style="color: #4876FF;">修改成功!</h3>',
					showType : 'show',
					timeout : 3000,
					width : 260,
					height : 120,
					style : {
						right : '',
						top : document.body.scrollTop
								+ document.documentElement.scrollTop,
						bottom : ''
					}
					
				});
				move("消缺任务制定与分配", "http://localhost:8080/Circuit/eliminate/eliminateflaw");
			}
		}
		
	})
}*/
//已驳回的状态下修改
function update_return_Eliminate_receipte(id){
	$.ajax({
		url : "eliminate/execu_updateTaskStatusReturnById?id=" + id,
		type : "post",
		success : function(data) {
			if (data=="true") {
				/*$('#eliminate_execution_receipt').datagrid('reload');*/
				move("修改回执", "http://localhost:8080/Circuit/eliminate/execu_updateTaskStatusReturn?id="+id);
			}else if (data=="false"){
				$.messager.show({
					title : '友好提示您',
					msg : '<h3 style="color: red;">你没有权限执行!</h3>',
					showType : 'show',
					timeout : 3000,
					width : 260,
					height : 120,
					style : {
						right : '',
						top : document.body.scrollTop
								+ document.documentElement.scrollTop,
						bottom : ''
					}
				});
			}
		}
	});
}


//审核任务
function audit_eliminate(eliminateId){
	$.ajax({
		url : "eliminate/audit_eliminate_user?eliminateId="+eliminateId,
		type : "post",
		success : function(data) {
				if(data=="taskmid"){
					//都是
					move("审核", "http://localhost:8080/Circuit/eliminate/all_details?eliminateId="+eliminateId);
				}else if (data=="eliminate"){
					//负责人
					//alert(2);
					move("审核", "http://localhost:8080/Circuit/eliminate/fuze_details?eliminateId="+eliminateId);
					
				}else if(data=="task"){
					//下发人
					move("审核", "http://localhost:8080/Circuit/eliminate/xiafa_details?eliminateId="+eliminateId);
				}else{
					$.messager.show({
						title : '友好提示您',
						msg : '<h3 style="color: red;">你没有权限执行!</h3>',
						showType : 'show',
						timeout : 3000,
						width : 260,
						height : 120,
						style : {
							right : '',
							top : document.body.scrollTop
									+ document.documentElement.scrollTop,
							bottom : ''
						}
					});
				}
			}
	});
}

//分配任务
function fenpeiEliminate(id){
	$.ajax({
		url:"eliminate/existUser?id="+id,
		type : "post",
		success:function(data){
			$("#select_list").html("");
			var ss="";
			if(data!=""||data!=null){
			
					for (var i = 0; i < data.length; i++) {
						ss+="<option class='options' value='" + data[i].id + "' name='options'>"
						+ data[i].name + "</option>";
					}
				
				$("#select_list").append(ss);
			}
			me(id);
		}
	});
	
	$("#fenpeidiv").show(1000);
	$("#add").click(
			function() {
				if ($("#fb_list option:selected").length > 0) {
					$("#fb_list option:selected").each(
							function() {
								$("#select_list").append(
										"<option value='" + $(this).val()
												+ "'>" + $(this).text()
												+ "</option");

								$(this).remove();
							});
				} else {
					alert("请选择要添加的数据！");
				}
			});
		
	$("#delete").click(
			function() {
				if ($("#select_list option:selected").length > 0) {
					$("#select_list option:selected").each(
							function() {
								$("#fb_list").append(
										"<option value='" + $(this).val()
												+ "'>" + $(this).text()
												+ "</option");
								$(this).remove();
								$.ajax({
									url:"eliminate/removethis?userId="+$(this).val(),
									type:"post",
									success:function(){
										
									}
								});
							});
					$("#select_user").html("");
				} else {
					alert("请选择要删除的数据！");
				}
			});
};

function me(id){
	$.ajax({
		url : "eliminate/getEliminateUser?id="+id,
		type : "post",
		success : function(data) {
			
			var str = "";
			if (data) {
				$("#fb_list").html("");
				for (var i = 0; i < data.length; i++) {
					if($("#select_list").html() == ""){
						str += "<option value='" + data[i].id + "' name='options'>"
						+ data[i].name + "</option>"
					}else{
						var flag = true;
						$(".options").each(
								function() {
									if(data[i].id==$(this).val()){
										flag = false;									
									}
									
						});
						if(flag==true){
							str += "<option value='" + data[i].id + "' name='options'>"
							+ data[i].name + "</option>"
						}
					}
				}
				$("#fb_list").append(str);
			}
			
		}
			
			
	});
}
//开始分配消缺员
function fenpei_save_user(){
	var str = $.map($("#select_list option:not(:selected)"), function(ele) {
		return ele.value
	}).join(",");
	$.ajax({
		url : "eliminate/updateEliminateUserById?str=" + str,
		type : "post",
		success : function(data) {
			if(data=="true"){
				$.messager.show({
					title : '友好提示您',
					msg : '<h3 style="color: #4876FF;">分配成功!</h3>',
					showType : 'show',
					timeout : 3000,
					width : 260,
					height : 120,
					style : {
						right : '',
						top : document.body.scrollTop
								+ document.documentElement.scrollTop,
						bottom : ''
					}
				});
				$('#flaw_manager').datagrid('reload');
			}
		}
	});
	$("#fenpeidiv").hide(1000);
}
function fenpeiHid(){
	$("#fenpeidiv").hide(1000);
}
// 取消
function cancelEminate(id) {
	$.ajax({
		url : "eliminate/updateTaskStatusById?id=" + id,
		type : "post",
		success : function(data) {
			if (data) {
				$('#flaw_manager').datagrid('reload');
			}
		}
	});
}
//执行
function execuEminate_receipt(id){
	$.ajax({
		url : "eliminate/execu_updateTaskStatusById?id=" + id,
		type : "post",
		success : function(data) {
			if (data=="true") {
				$('#eliminate_execution_receipt').datagrid('reload');
			}else if (data=="false"){
				$.messager.show({
					title : '友好提示您',
					msg : '<h3 style="color: red;">你没有权限执行!</h3>',
					showType : 'show',
					timeout : 3000,
					width : 260,
					height : 120,
					style : {
						right : '',
						top : document.body.scrollTop
								+ document.documentElement.scrollTop,
						bottom : ''
					}
				});
			}
		}
	})
};
//模糊查询
function search_eliminate() {

	/*var taskcoding = $("#flaw_taskcoding").val();
	var linecoding = $("#flaw_linecoding").val();
	var taskbills = $("#flaw_taskstatus").combobox('getText');
	var xiapeople = $("#flaw_xiapeople").val();
	var startdate = $("#flaw_startdate").val();
	var enddate = $("#flaw_enddate").val();*/
	$("#flaw_manager").datagrid('reload', {
		operate: 'flaw',
		taskcoding : $("#flaw_taskcoding").val(),
		workbills : $("#flaw_workbills").val(),
		taskstatus : $("#flaw_taskstatus").combobox('getText'),
		xiapeople : $("#flaw_xiapeople").val(),
		startdate : $("#flaw_startdate").val(),
		enddate : $("#flaw_enddate").val()
	});
	/*console.log(taskcoding, linecoding, taskstatus, xiapeople, startdate,
			enddate);*/

}


function gotoanthor() {
	move("制定消缺任务", "http://localhost:8080/Circuit/eliminate/addeliminateflaw");
}

function seeEliminate(eliminateId){
	move("查看消缺任务", "http://localhost:8080/Circuit/eliminate/lookeliminateflaw?eliminateId="+eliminateId);
}
//回执的查看
function seeEliminate_receipte(eliminateId){
	move("查看消缺任务", "http://localhost:8080/Circuit/eliminate/lookeliminateflaw_receipte?eliminateId="+eliminateId);
}
function returntoshou() {
	move("消缺任务制定与分配", "http://localhost:8080/Circuit/eliminate/eliminateflaw");
}
function returntoReceipt(){
	move("消缺任务执行与回执","http://localhost:8080/Circuit/eliminate/execution_receipt")
}

