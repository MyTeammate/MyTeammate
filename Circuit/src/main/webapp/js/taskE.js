function taskE() {//消缺任务查询统计
	$('#taskE').datagrid({
		url:"selectAllEliminPost",
		columns : [ [ {
			field : 'tcoding',
			title : '任务编号',
			width : 120,
			align : "center",
		}, {
			field : 'tename',
			title : '任务名称',
			width : 120,
			align : "center",
		}, {
			field : 'ethreadCoding',
			title : '线路编号',
			width : 120,
			align : "center",
		}, {
			field : 'estartTower',
			title : '起始杆号',
			width : 120,
			align : "center",
		}, {
			field : 'tendTower',
			title : '终止杆号',
			width : 120,
			align : "center",
		}, {
			field : 'edescription',
			title : '操作',
			width : 120,
			align : "center",
		} ] ],
		pageNumber : 1,
		pageSize : 1,
		pagination : true,
		pageList : [ 1, 5, 10, 15, 20 ],
		rownumbers : true,
	});
}


function selElId() {
	var id = $("#taskE").datagrid('getSelected');
	$.ajax({
		url:"taskElTowerPost",
		type:"post",
		data:{
			"tcoding":id.tcoding
		}
	});	
	move("杆塔消缺信息","taskElnews");
}

