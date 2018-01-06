function log_tb(){
	$('#log_tb').datagrid({
		url:'userManage/listSystemLog',
		height : 200,
		pagination : true,
		pageNumber : 1,
		pageSize : 1,
		rownumbers : true,
		pagination : true,
		singleSelect:true,
		pageList : [ 1, 2, 3, 4 ],
		columns:[[
		      /*{field:'id',checkbox:true},*/
              {field:'userName',title:'用户名',width:200,align:'center'},
              {field:'logMessage',title:'操作信息',width:297,align:'center'},
              {field:'createDate',title:'操作时间',width:200,align:'center'},
		]]
	})
	$('#log_query').bind('click',function(){
		var uentryDate=$('#uentryDate').val();
		var uentryDate2=$('#uentryDate2').val();
		$('#log_tb').datagrid('reload',{
			uentryDate:uentryDate,
			uentryDate2:uentryDate2
		});
	})
	
	$('#uentryDate').datebox({    
	    editable:false
	});
	$('#uentryDate2').datebox({    
	    editable:false
	});
}