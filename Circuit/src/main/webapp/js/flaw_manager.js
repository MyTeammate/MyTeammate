function eliminate() {
	$("#flaw_manager")
			.datagrid(
					{
						url : "eliminate/getAll",
						height : 370,
						width : 900,
						pagination : true,
						pageNumber : 1,
						pageSize : 5,
						rownumbers : true,
						pagination : true,
						pageList : [ 5, 10, 15, 20 ],
						columns : [ [
								{
									field : 'id',
									title : '自动编号',
									width : 82,
									checkbox : true
								},
								{
									field : 'taskcoding',
									title : '任务编号',
									width : 82,
									align : 'center'
								},
								{
									field : 'taskName',
									title : '任务名称',
									width : 82,
									align : 'center'
								},
								{
									field : 'workBills',
									title : '工作单据',
									width : 82,
									align : 'center'
								},
								{
									field : 'xiafaMan',
									title : '下发人',
									width : 92,
									align : 'center'
								},
								{
									field : 'xiafaDate',
									title : '下发时间',
									width : 82,
									align : 'center'
								},
								{
									field : 'taskStatus',
									title : '任务状态',
									width : 82,
									align : 'center',
									formatter : function(value, row, index) {
										var fontColor = '';
										if (value == '待分配') {
											fontColor = '#FF9900';
										} else if (value == '已分配') {
											fontColor = '#0033FF';
										} else if (value == '执行中') {
											fontColor = '#FF33CC'
										} else if (value == '已完成') {
											fontColor = '#009900';
										} else if (value == '已取消') {
											fontColor = '#FF3030'
										}
										return '<span style="color:'
												+ fontColor + '">' + value
												+ '</span>';
									}
								},
								{
									field : 'wancdate',
									title : '任务完成时间',
									width : 82,
									align : 'center'
								},
								/*
								 * {field : 'flag',title : '任务是否取消',width :
								 * 82,align : 'center'},
								 */
								{
									field : 'operation',
									title : '操作',
									width : 170,
									align : 'center',
									formatter : function(value, row, index) {
										var oper = '';
										if (row.taskStatus == '待分配') {
											oper = '<span><a href="javaScript:lookInspection('
													+ row.id
													+ ')">查看</a>｜'
													+ '<a href="javaScript:allotInspection('
													+ row.id
													+ ')">分配任务</a>｜'
													+ '<a href="javaScript:updateInspection('
													+ row.id
													+ ')">修改</a>｜'
													+ '<a href="javaScript:cancelEminate('
													+ row.id
													+ ')">取消</a></span>';
										} else if (row.taskStatus == '已分配') {
											oper = '<span><a href="javaScript:lookInspection('
													+ row.id
													+ ')">查看</a>｜'
													+ '<a style="color:#CDC5BF">分配任务</a>｜<a style="color:#CDC5BF">修改</a>｜'
													+ '<a style="color:#CDC5BF">取消</a></span>';
										} else if (row.taskStatus == '执行中') {
											oper = '<span><a href="javaScript:lookInspection('
													+ row.id
													+ ')">查看</a>｜'
													+ '<a style="color:#CDC5BF">分配任务</a>｜<a style="color:#CDC5BF">修改</a>｜'
													+ '<a style="color:#CDC5BF">取消</a></span>';
										} else if (row.taskStatus == '已完成') {
											oper = '<span><a href="javaScript:lookInspection('
													+ row.id
													+ ')">查看</a>｜'
													+ '<a style="color:#CDC5BF">分配任务</a>｜'
													+ '<a href="javaScript:updateInspection('
													+ row.id
													+ ')">审查</a>｜'
													+ '<a style="color:#CDC5BF">取消</a></span>';
										} else if (row.taskStatus == '已取消') {
											oper = '<span><a href="javaScript:lookInspection('
													+ row.id
													+ ')">查看</a>｜'
													+ '<a style="color:#CDC5BF">分配任务</a>｜<a style="color:#CDC5BF">修改</a>｜'
													+ '<a style="color:#CDC5BF">取消</a></span>';
										}
										return oper;
									}
								} ] ],
						toolbar : "#div_toolOne"
					});
}

// 取消
function cancelEminate(id) {
	alert(id);
	$.ajax({
		url : "eliminate/updateTaskStatusById?id=" + id,
		type : "post",
		success : function(data) {
			if (data) {
				$('#flaw_manager').datagrid('reload');
			}
		}
	})
}

function search_eliminate() {

	var taskcoding = $("#flaw_taskcoding").val();
	var linecoding = $("#flaw_linecoding").val();
	var taskstatus = $("#flaw_taskstatus").val();
	var xiapeople = $("#flaw_xiapeople").val();
	var startdate = $("#flaw_startdate").val();
	var enddate = $("#flaw_enddate").val();
	console.log(taskcoding, linecoding, taskstatus, xiapeople, startdate,
			enddate);

}
function gotoanthor() {
	move("制定消缺任务", "http://localhost:8080/Circuit/eliminate/addeliminateflaw");
}
