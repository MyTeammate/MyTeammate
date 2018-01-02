function user_tb(){
	$('#user_tb').datagrid({
		url:'userManage/listSystemUser',
		height : 200,
		pagination : true,
		pageNumber : 1,
		pageSize : 1,
		rownumbers : true,
		pagination : true,
		singleSelect:true,
		pageList : [ 1, 2, 3, 4 ],
		columns:[[
		      {field:'id',checkbox:true},
              {field:'userName',title:'用户账号',width:160,align:'center'},
              {field:'name',title:'用户姓名',width:160,align:'center'},
              {field:'roleName',title:'角色',width:160,align:'center'},
              {field:'email',title:'用户账号',width:160,align:'center'},
              {field:'loginDate',title:'最后一次登录时间',width:160,align:'center'},
              {field:'state',title:'状态（正常/冻结）',width:160,align:'center'},
		]]
	})
}

 