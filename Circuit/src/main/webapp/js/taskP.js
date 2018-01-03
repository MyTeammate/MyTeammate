function taskP() {// 巡检记录统计数据查询
	$('#taskP').datagrid({
		url : "taskPollingPost",
		columns : [ [{
			field : 'coding',
			title : '任务编号',
			width : 150,
			align : "center",
		}, {
			field : 'tanem',
			title : '任务名称',
			width : 150,
			align : "center",
		}, {
			field : 'threadCoding',
			title : '线路编号',
			width : 150,
			align : "center",
		}, {
			field : 'startTower',
			title : '起始杆号',
			width : 150,
			align : "center",
		}, {
			field : 'engTower',
			title : '终止杆号',
			width : 150,
			align : "center",
		}, {
			field : 'description',
			title : '操作',
			width : 150,
			align : "center",
		} ] ],
		pageNumber : 1,
		pageSize : 1,
		pagination : true,
		pageList : [ 1, 5, 10, 15, 20 ],
		rownumbers : true,
	});
}

function selId() {
	var id = $("#taskP").datagrid('getSelected');
	$.ajax({
		url:"taskTowerPost",
		type:"post",
		data:{
			"coding":id.coding
		}
	});
	
	move("杆塔信息","taskPonew");
}

