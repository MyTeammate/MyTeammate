function taskE() {
	$('#taskE').datagrid({
		// url:"",
		columns : [ [ {
			field : 'coding',
			title : '任务编号',
			width : 200,
			align : "center",
		}, {
			field : 'name',
			title : '任务名称',
			width : 200,
			align : "center",
		}, {
			field : 'codstartend',
			title : '线路编号(起始杆号-终止杆号)',
			width : 200,
			align : "center",
		}, {
			field : 'description',
			title : '操作',
			width : 200,
			align : "center",
		} ] ],
		pagination : true,
		pageList : [ 1, 5, 10 ],
		pageSize : 5,
	});
}