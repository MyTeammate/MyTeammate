function eliminate() {
	$("#flaw_manager").datagrid({
		url : "",
		height : 370,
		width : 825,
		pagination : true,
		pageNumber : 1,
		pageSize : 5,
		rownumbers : true,
		pagination : true,
		pageList : [ 5, 10, 15, 20 ],
		columns : [ [ 
			{field : 'baseid',title : '自动编号',width : 82,checkbox : true},
			{field : 'id',title : '任务编号',width : 82,align : 'center'},
			{field : 'bd',title : '任务名称',width : 82,align : 'center'},
			{field : 'bd',title : '工作单据',width : 82,align : 'center'},
			{field : 'bd',title : '下发人',width : 62,align : 'center'},
			{field : 'bd',title : '下发时间',width : 82,align : 'center'},
			{field : 'bd',title : '任务状态',width : 82,align : 'center'},
            {field : 'bd',title : '任务完成时间',width : 82,align : 'center'},
            {field : 'bd',title : '任务是否取消',width : 82,align : 'center'},
            {field : 'bd',title : '操作',width : 102,align : 'center'}
            ]],
            toolbar:"#div_toolOne"
	});
}

function search_eliminate() {
	alert(333);
	/*
	 * var taskcoding = $("#flaw_taskcoding").val(); var linecoding =
	 * $("#flaw_linecoding").val(); var taskstatus =
	 * $("#flaw_taskstatus").val(); var xiapeople = $("#flaw_xiapeople").val();
	 * var startdate = $("#flaw_startdate").val(); var enddate =
	 * $("#flaw_enddate").val();
	 * console.log(taskcoding,linecoding,taskstatus,xiapeople,startdate,enddate);
	 */

}
function goto(){
	move("增加","http://localhost:8080/Circuit/eliminate/addeliminateflaw");
}
