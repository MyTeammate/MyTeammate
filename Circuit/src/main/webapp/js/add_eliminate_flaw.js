function add_eliminate(){
	$("#add_flaw_manager").datagrid({
		url:"",
		height : 370,
		width:850,
		pagination : true,
		pageNumber : 1,
		pageSize : 5,
		rownumbers : true,
		pagination : true,
		pageList : [ 5, 10, 15, 20 ],
		columns : [ [ 
			{field : 'baseid',title : '自动编号',width : 95,checkbox : true},
			{field : 'id',title : '线路编号',width : 95,align : 'center'},
			{field : 'bd',title : '杆塔编号',width : 95,align : 'center'},
			{field : 'bd',title : '缺陷等级',width : 95,align : 'center'},
			{field : 'bd',title : '缺陷类型',width : 95,align : 'center'},
			{field : 'bd',title : '缺陷描述',width : 95,align : 'center'},
			{field : 'bd',title : '发现人',width : 95,align : 'center'},
            {field : 'bd',title : '发现时间',width : 95,align : 'center'},
            {field : 'bd',title : '操作',width : 95,align : 'center'}
            ]],
            
	})
}
function flaw_add_staff(){
	alert(1);
}
function hid(){
	$("#bigdiv").hide(1000);
}
function show(){
	$("#bigdiv").show(1000);
}
