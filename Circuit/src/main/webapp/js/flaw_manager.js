function eliminate() {
	$("#flaw_manager").datagrid({
						url : "eliminate/getAll",
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
									oper = '<span><a href="javaScript:lookInspection('
											+ row.id
											+ ')">查看</a>｜'
											+ '<a href="javaScript:allotInspection('
											+ row.id
											+ ')">分配任务</a>｜'
											+ '<a href="javaScript:updateInspection('
											+ row.id
											+ ')">修改</a>｜'
											+ '<a href="javaScript:cancelEminate('
											+ row.id
											+ ')">取消</a></span>';
								} else if (row.taskStatus == '已分配') {
									oper = '<span><a href="javaScript:seeEliminate('
											+ row.id
											+ ')">查看</a>｜'
											+ '<a href="javaScript:seeEliminate('
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
											+ '<a href="javaScript:updateInspection('
											+ row.id
											+ ')">审查</a>｜'
											+ '<a style="color:#CDC5BF">取消</a></span>';
								} else if (row.taskStatus == '已取消') {
									oper = '<span><a href="javaScript:seeEliminate('
											+ row.id
											+ ')">查看</a>｜'
											+ '<a style="color:#CDC5BF">分配任务</a>｜<a style="color:#CDC5BF">修改</a>｜'
											+ '<a style="color:#CDC5BF">取消</a></span>';
								}
								return oper;
							}
						} ] ],
				toolbar : "#div_toolOne",
				emptyMsg : '<h2 style="color:#FF3E96">您还未发布任何消缺任务</h2>',
				
			});
	$('#flaw_taskstatus').combobox({
		url : 'eliminate/getAllstatus',
		valueField : 'id',
		textField : 'settingName',
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
//分配任务
function fenpeiEliminate(id){
	$("#fenpeidiv").show(1000);
	$.ajax({
		url : "eliminate/getEliminateUser?id="+id,
		type : "post",
		success : function(data) {
			$("#fb_list").html("");
			var str = "";
			if (data) {
				for (var i = 0; i < data.length; i++) {
					str += "<option value='" + data[i].id + "' name='options'>"
							+ data[i].name + "</option>"
				}
			}
			$("#fb_list").append(str);
		}
	});
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
							})
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
							});
					$("#select_user").html("");
				} else {
					alert("请选择要删除的数据！");
				}
			});
};
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
	})
}

function search_eliminate() {

	/*var taskcoding = $("#flaw_taskcoding").val();
	var linecoding = $("#flaw_linecoding").val();
	var taskbills = $("#flaw_taskstatus").combobox('getText');
	var xiapeople = $("#flaw_xiapeople").val();
	var startdate = $("#flaw_startdate").val();
	var enddate = $("#flaw_enddate").val();*/
	$("#flaw_manager").datagrid('reload', {
		taskcoding : $("#flaw_taskcoding").val(),
		workbills : $("#flaw_workbills").val(),
		taskstatus : $("#flaw_taskstatus").combobox('getText'),
		xiapeople : $("#flaw_xiapeople").val(),
		startdate : $("#flaw_startdate").val(),
		enddate : $("#flaw_enddate").val()
	});
	console.log(taskcoding, linecoding, taskstatus, xiapeople, startdate,
			enddate);

}
function gotoanthor() {
	move("制定消缺任务", "http://localhost:8080/Circuit/eliminate/addeliminateflaw");
}

function seeEliminate(id){
	alert(id);
	move("查看消缺任务", "http://localhost:8080/Circuit/eliminate/lookeliminateflaw?id="+id);
}
function returntoshou() {
	move("制定消缺任务制定与分配", "http://localhost:8080/Circuit/eliminate/eliminateflaw");
}
