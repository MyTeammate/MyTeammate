//任务已拥有的消缺
$(function(){
	$("#see_eliminate").datagrid({
		url : "eliminate/selectEliminateById",
		width:800,
		height:110,
		pagination : true,
		pageNumber : 1,
		pageSize : 5,
		rownumbers : true,
		pagination : true,
		pageList : [ 5, 10, 15, 20 ],
		columns : [ [ {
			field : 'id',
			title : '自动编号',
			width : 88,
			checkbox : true
		}, {
			field : 'threadCoding',
			title : '线路编号',
			width : 95,
			align : 'center'
		}, {
			field : 'towerCoding',
			title : '杆塔编号',
			width : 95,
			align : 'center'
		}, {
			field : 'flawGrade',
			title : '缺陷等级',
			width : 95,
			align : 'center'
		}, {
			field : 'flawType',
			title : '缺陷类型',
			width : 95,
			align : 'center'
		}, {
			field : 'flawDesc',
			title : '缺陷描述',
			width : 140,
			align : 'center'
		}, {
			field : 'findUser',
			title : '发现人',
			width : 120,
			align : 'center'
		}, {
			field : 'findDate',
			title : '发现时间',
			width : 95,
			align : 'center'
		}, ] ],
		emptyMsg : '<h2 style="color:#FF3E96">没有分配缺陷</h2>',
	});
});