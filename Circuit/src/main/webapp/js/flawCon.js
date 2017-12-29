$(function() {
	$("#flawCon_datagrid").datagrid({
		url : '',
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
		toolbar : "#flawCon_tool",
		columns : [ [ {
			field : 'fid',
			title : '自动编号',
			width : 80,
			checkbox : true,
		}, {
			field : 'fname',
			title : '任务编号',
			width : 75,
			align: "center",
		}, {
			field : 'ftype',
			title : '线路编号',
			width : 80,
			align: "center",
		}, {
			field : 'pstate',
			title : '杆塔编号',
			width : 90,
			align: "center",
		}, {
			field : 'plasttime',
			title : '缺陷类型',
			width : 100,
			align: "center",
		}, {
			field : 'ppeople',
			title : '完好率',
			width : 75,
			align: "center",
		},{
			field : 'plast',
			title : '缺陷描述',
			width : 100,
			align: "center",
		},{
			field : 'plastt',
			title : '发现时间',
			width : 90,
			align: "center",
		},{
			field : 'plastti',
			title : '发现人员',
			width : 100,
			align: "center",
		},{
			field : 'plasttim',
			title : '缺陷级别',
			width : 95,
			align: "center",
		}, ] ],
	});
});