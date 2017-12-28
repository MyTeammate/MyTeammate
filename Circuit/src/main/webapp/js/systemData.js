function data_tb(){
	alert("1");
	$('#data_tb').datagrid({
		/*url:'',*/
		columns:[[
		      {field:'id',checkbox:true},
              {field:'name',title:'客户姓名',width:120,align:'center'},
              {field:'sex',title:'性别',width:120,align:'center'},
              {field:'type',title:'类型',width:120,align:'center'},
              {field:'condition',title:'状态',width:120,align:'center'},
              {field:'allot',title:'分配状态',width:120,align:'center'},
              {field:'date',title:'录入时间',width:120,align:'center'},
              {field:'staff_id',title:'录入人',width:120,align:'center'}
		]]
	})
}