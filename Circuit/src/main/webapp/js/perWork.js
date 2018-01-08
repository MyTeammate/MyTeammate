$(function(){
	perWork();
})
function perWork() {
	$('#perWork').datagrid({
		url:"work/getPersonalworkData",
		columns : [ [ {
			field : 'type',
			title : '代办任务类型',
			width : 200,
			align : "center",
		}, {
			field : 'name',
			title : '代办任务名称',
			width : 400,
			align : "center",
		}, {
			field : 'backDate',
			title : '到达时间',
			width : 200,
			align : "center",
		}, {
			field : 'operation',
			title : '操作',
			width : 200,
			align : "center",
		} ] ],
		pagination : true,
		pageList : [ 1, 5, 10 ],
		pageSize : 5,
	});
}

function queryWorkFlaw(){
	addTabs("缺陷等级确认","flawConfirm");
}
function queryWorkEliminating(){
	addTabs("缺陷等级确认","eliminate/execution_receipt");
	
}
function queryWorkInspection(){
	addTabs("巡检任务执行与回执","inspectionExecuteReceipt");
}

