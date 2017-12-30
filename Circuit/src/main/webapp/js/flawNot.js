$(function() {
	$("#flawNot_datagrid").datagrid({
		url : 'getFlawNotarizeAll',
		width : 950,
		height : 500,
		// total:5,
		fitColumns : true,
		striped : true,
		rownumbers : true,
		pagination : true,
		pageSize : 2,
		pageList : [ 2, 5, 10, 15, 20 ],
		pageNumber : 2,
		toolbar : "#flawNot_tool",
		columns : [ [ {
			field : 'fid',
			title : '自动编号',
			width : 80,
			checkbox : true,
		}, {
			field : 'tasknumber',
			title : '任务编号',
			width : 75,
			align: "center",
		}, {
			field : 'threadcoding',
			title : '线路编号',
			width : 80,
			align: "center",
		}, {
			field : 'towercoding',
			title : '杆塔编号',
			width : 90,
			align: "center",
		}, {
			field : 'flawname',
			title : '缺陷类型',
			width : 100,
			align: "center",
		}, {
			field : 'flawConfirmserviceAbility',
			title : '完好率',
			width : 75,
			align: "center",
		},{
			field : 'flawConfirmflawDesc',
			title : '缺陷描述',
			width : 100,
			align: "center",
		},{
			field : 'flawConfirmdiscoverDate',
			title : '发现时间',
			width : 90,
			align: "center",
		},{
			field : 'inspectionstaffuserId',
			title : '发现人员',
			width : 100,
			align: "center",
		},{
			field : 'flawConfirmflowGrade',
			title : '缺陷级别',
			width : 95,
			align: "center",
		}, ] ],
	});
});