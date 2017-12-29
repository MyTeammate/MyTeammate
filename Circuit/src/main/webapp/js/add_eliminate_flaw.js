$(function(){
	$("#add_flaw").datagrid({
		url : "eliminate/getAll",
		height : 370,
		width : 865,
		pagination : true,
		pageNumber : 1,
		pageSize : 5,
		rownumbers : true,
		pagination : true,
		pageList : [ 5, 10, 15, 20 ],
		columns : [ [ 
			{field : 'id',title : '自动编号',width : 82,checkbox : true},
			{field : 'taskcoding',title : '任务编号',width : 82,align : 'center'},
			{field : 'taskName',title : '任务名称',width : 82,align : 'center'},
			{field : 'workBills',title : '工作单据',width : 82,align : 'center'},
			{field : 'xiafaMan',title : '下发人',width : 92,align : 'center'},
			{field : 'xiafaDate',title : '下发时间',width : 82,align : 'center'},
			{field : 'taskStatus',title : '任务状态',width : 82,align : 'center'},
            {field : 'wancdate',title : '任务完成时间',width : 82,align : 'center'},
            {field : 'flag',title : '任务是否取消',width : 82,align : 'center'},
            {field : 'operation',title : '操作',width : 136,align : 'center'}
            ]],
            toolbar:"#smalldiv"
	});
});
function flaw_add_staff(){
	alert(1);
}
function hid(){
	$("#bigdiv").hide(1000);
}
function show(){
	$("#bigdiv").show(1000);
}
function returnto(){
	move("制定消缺任务制定与分配","http://localhost:8080/Circuit/eliminate/eliminateflaw");
}
$(function(){
	var t = $("#taskbills").val();
	$.ajax({
		url:"",
		type:"post",
		success:function(data){
			var str="";
		}
	})
})
