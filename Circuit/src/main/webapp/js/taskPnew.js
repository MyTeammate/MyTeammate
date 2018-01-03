$(function() {
	var t = $("#co").val();
	$('#taskPnew').datagrid({
		url : "towerTask?coding="+t,
		columns : [ [ {
			field : 'towerCoding',
			title : '杆塔编号',
			width : 150,
			align : "center",
		}, {
			field : 'settingName',
			title : '缺陷级别',
			width : 150,
			align : "center",
		}, {
			field : 'flawtype',
			title : '缺陷类型',
			width : 150,
			align : "center",
		}, {
			field : 'discoverDate',
			title : '发现时间',
			width : 150,
			align : "center",
		}, {
			field : 'flawDesc',
			title : '缺陷描述',
			width : 150,
			align : "center",
		} ] ],
		pageNumber : 1,
		pageSize : 5,
		pagination : true,
		pageList : [ 5, 10, 15, 20 ],
		rownumbers : true
	})
})


function testPo(){
	move("巡检记录统计","taskPolling");
}


function plListidTwo() {
	
	$('#taskPnew').datagrid('reload',{
		ganTitle:$('#gan').val(),
		queTitle:$('#que').val(),
		sTitle:$('#staterDate').val(),
		eTitle:$('#endDate').val(),
	});
}