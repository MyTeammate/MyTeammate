$(function(){
	$("#eliminate_execution_receipt").datagrid({
		url : "eliminate/execution_task",
		queryParams: {          
	          operate: 'eliminate'            
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
			 if (value == '已分配') {
				fontColor = '#0033FF';
			} else if (value == '执行中') {
				fontColor = '#FF33CC'
			} else if (value == '已完成') {
				fontColor = '#009900';
			} else if (value == '已驳回') {
				fontColor = '#FF3030'
			}else if (value='待审核'){
				fontColor = '#7D26CD';
			}
			return '<span style="color:'
					+ fontColor + '">' + value
					+ '</span>';
		}
		},
		{field : 'wancdate',title : '任务完成时间',width : 82,align : 'center'},
		{field : 'operation',title : '操作',width : 170,align : 'center',
		formatter : function(value, row, index) {
				var oper = '';
				 if (row.taskStatus == '已分配') {
					oper = '<span><a href="javaScript:seeEliminate_receipte('
							+ row.id
							+ ')">查看</a>｜'
							+ '<a style="color:#CDC5BF">回执录入</a>｜<a href="javaScript:execuEminate_receipt('
							+ row.id
							+ ')">执行</a>｜'
							+ '<a style="color:#CDC5BF">修改</a></span>';
				} else if (row.taskStatus == '执行中') {
					oper = '<span><a href="javaScript:seeEliminate_receipte('
							+ row.id
							+ ')">查看</a>｜'
							+ '<a href="javaScript:return_receipt_entry('
							+ row.id
							+ ')">回执录入</a>｜<a style="color:#CDC5BF">执行</a>｜'
							+ '<a style="color:#CDC5BF">修改</a></span>';
				} else if (row.taskStatus == '已完成') {
					oper = '<span><a href="javaScript:seeEliminate_receipte('
							+ row.id
							+ ')">查看</a>｜'
							+ '<a style="color:#CDC5BF">回执录入</a>｜'
							+ '<a style="color:#CDC5BF">执行</a>｜'
							+ '<a style="color:#CDC5BF">修改</a></span>';
				} else if (row.taskStatus == '已驳回') {
					oper = '<span><a href="javaScript:seeEliminate_receipte('
							+ row.id
							+ ')">查看</a>｜'
							+ '<a style="color:#CDC5BF">回执录入</a>｜<a style="color:#CDC5BF">执行</a>｜'
							+ '<a href="javaScript:seeEliminate_receipte('
							+ row.id
							+ ')">修改</a></span>';
				}else if (row.taskStatus == '待审核') {
					oper = '<span><a href="javaScript:seeEliminate_receipte('
						+ row.id
						+ ')">查看</a>｜'
						+ '<a style="color:#CDC5BF">回执录入</a>｜<a style="color:#CDC5BF">执行</a>｜'
						+ '<a style="color:#CDC5BF">修改</a></span>';
			}
				return oper;
			}
		} ] ],
			toolbar : "#div_toolbar",
			emptyMsg : '<h2 style="color:#FF3E96">没有消缺任务哟</h2>',
			
			});
			$('#receipt_bills').combobox({
			url : 'eliminate/getAllstatus?coding='+'bills',
			valueField : 'id',
			textField : 'settingName',
			width : 154,
			});
});
function search_receipt(){
	$("#eliminate_execution_receipt").datagrid('reload', {
		operate: 'eliminate',
		receipt_taskcoding : $("#receipt_taskcoding").val(),
		receipt_bills : $("#receipt_bills").combobox('getText'),
		receipt_xiapeople : $("#receipt_xiapeople").val(),
		receipt_startdate : $("#receipt_startdate").val(),
		receipt_enddate : $("#receipt_enddate").val()
	});
}
function return_receipt_entry(id){
	$.ajax({
		url : "eliminate/execu_updateTaskStatusById?id=" + id,
		type : "post",
		success : function(data) {
			if (data=="true") {
				/*$('#eliminate_execution_receipt').datagrid('reload');*/
				move("回执录入", "http://localhost:8080/Circuit/eliminate/save_eliminateflaw_receipte?eliminateId="+id);
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

//下发人审查意见
function save_receipte_xiafa(){
	var xiafa_save_eliminateId = $("#xiafa_save_eliminateId").val();
	var xiafa_receipte = $("#xiafa_receipte").val();
	console.log(xiafa_save_eliminateId,xiafa_receipte);
	$.ajax({
		url:"eliminate/update_eliminate_receipte_xiafa",
		data:{
			xiafa_save_eliminateId:xiafa_save_eliminateId,
			xiafa_receipte:xiafa_receipte,
		},
		type : "post",
		success:function(data){
			if(data=="true"){
				alert(111);
				$.messager.show({
					title : '友好提示您',
					msg : '<h3 style="color: red;">审查成功!</h3>',
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
			});
}

//两者都是
function save_receipte_all(){
	var all_fuze_receipte = $("#all_fuze_receipte").val();
	var all_xiafa_receipte = $("#all_xiafa_receipte").val();
	var all_pass_select = $("#all_pass_select").val();
	var all_save_eliminateId = $("#all_save_eliminateId").val();
	$.ajax({
		url:"eliminate/update_eliminate_receipte_all",
		data:{
			all_fuze_receipte:all_fuze_receipte,
			all_xiafa_receipte:all_xiafa_receipte,
			all_pass_select:all_pass_select,
			all_save_eliminateId:all_save_eliminateId,
		},
		type : "post",
		success:function(data){
			if(data=="true"){
				$.messager.show({
					title : '友好提示您',
					msg : '<h3 style="color: red;">审查成功!</h3>',
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
			});
}

//负责人审查意见
function save_receipte_fuze(){
	var fuze_receipte= $("#fuze_receipte").val();
	var pass_select = $("#pass_select").val();
	var fuze_save_eliminateId = $("#fuze_save_eliminateId").val();
	$.ajax({
		url:"eliminate/update_eliminate_receipte_fuze",
		data:{
			fuze_receipte:fuze_receipte,
			pass_select:pass_select,
			fuze_save_eliminateId:fuze_save_eliminateId,
		},
		type : "post",
		success:function(data){
			if(data=="true"){
				$.messager.show({
					title : '友好提示您',
					msg : '<h3 style="color: red;">审查成功!</h3>',
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
			});
}

//保存回执信息
function save_receipte(){
	var save_eliminateId = $("#save_eliminateId").val();
	var success_desc = $("#success_desc").val();
	var work_record = $("#work_record").val();
	var final_report = $("#final_report").val();
	console.log(save_eliminateId,success_desc,work_record,final_report);
	$.ajax({
		url:"eliminate/update_eliminate_receipte",
		data:{
			save_eliminateId:save_eliminateId,
			success_desc:success_desc,
			work_record:work_record,
			final_report:final_report
		},
		type : "post",
		success:function(data){
			if(data=="true"){
				$.messager.show({
					title : '友好提示您',
					msg : '<h3 style="color: red;">回执成功!</h3>',
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
				move("消缺任务执行与回执","http://localhost:8080/Circuit/eliminate/execution_receipt");
			}else if(data=="false"){
				$.messager.show({
					title : '友好提示您',
					msg : '<h3 style="color: red;">回执失败!请认真检查原因!</h3>',
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
