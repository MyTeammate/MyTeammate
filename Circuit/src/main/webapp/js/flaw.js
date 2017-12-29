$(function() {
	$("#flaw_datagrid").datagrid({
		url : '../getflawpage',
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
		toolbar : "#flaw_tool",
		columns : [ [ {
			field : 'flawname',
			title : '缺陷类型名称',
			width : 200,
			align: "center",
		},{
			field : 'state',
			title : '状态（启用/未启用）',
			width : 100,
			align: "center",
		},{
			field : 'operate',
			title : '操作',
			width : 200,
			align: "center",
		}, ] ],
	});
});