function eliminatequery() {
	$("#query_manager").datagrid({
		url:"eliminatequery/queryAllPost",
		
		pagination : true,
		pageNumber : 1,
		pageSize : 5,
		width : 1220,		
		rownumbers : true,
		pagination : true,
		nowrap:false,
		pageList : [ 5, 10,15, 20 ],
		columns : [ [ {
			field : 't_coding',
			title : '任务编号',
			width : 100,
			align : "center",
		}, {
			field : 't_type',
			title : '任务状态',
			width : 70,
			align : "center",
		}, {
			field : 't_bills',
			title : '工作单据',
			width : 80,
			align : "center",
		}, {
			field : 't_number',
			title : '线路编号',
			width : 75,
			align : "center",
		}, {
			field : 'tower_coding',
			title : '杆塔编号',
			width : 75,
			align : "center",
		}, {
			field : 'flaw_rank',
			title : '缺陷级别',
			width : 65,
			align : "center",
		}, {
			field : 'flaw_type',
			title : '缺陷类型',
			width : 80,
			align : "center",
		}, {
			field : 'finder',
			title : '发现人',
			width : 80,
			align : "center",
		}, {
			field : 'find_time',
			title : '发现时间',
			width : 90,
			align : "center",
		}, {
			field : 'issue',
			title : '下发人',
			width : 70,
			align : "center",
		}, {
			field : 'issue_time',
			title : '下发时间',
			width : 90,
			align : "center",
		}, {
			field : 'intact_rate',
			title : '完好率',
			width : 50,
			align : "center",
		}, {
			field : 'flaw_describe',
			title : '缺陷描述',
			width : 250,
			align : "center",
		} ] ],
		toolbar : "#div_toolTwo",
	});
	
	$('#query_taskstatus').combobox({
		url : 'eliminate/getAllstatus?coding='+'TASK_STATE',
		valueField : 'id',
		textField : 'settingName',
		width : 80,
	});
	
	$('#query_xiapeople').combobox({
		url : 'eliminate/getAllstatus?coding='+'GRADE_FLAW',
		valueField : 'id',
		textField : 'settingName',
		width : 80,
	});
	
	$('#query_workbills').combobox({
		url : 'eliminatequery/selFlawPost',
		valueField : 'id',
		textField : 'name',
		width : 80,
	});
	
	

}

function elimiates_query() {
	$('#query_manager').datagrid('reload', {
		taskcoding : $("#query_taskcoding").val(),
		workbills : $("#query_workbills").combobox('getText'),
		taskstatus : $("#query_taskstatus").combobox('getText'),
		xiapeople : $("#query_xiapeople").combobox('getText'),
		startdate : $("#query_startdate").val(),
		enddate : $("#query_enddate").val(),
		fxstatus : $("#query_fxstartdate").val(),
		fxend : $("#query_fxenddate").val()
	});
}

function exportExcel(){
	alert(222)
}