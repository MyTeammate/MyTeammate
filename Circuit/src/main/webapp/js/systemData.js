function data_tb(){
	$('#data_tb').datagrid({
		url:'dateManage/listSystemsetting',
		height : 200,
		pagination : true,
		pageNumber : 1,
		pageSize : 1,
		rownumbers : true,
		pagination : true,
		pageList : [ 1, 2, 3, 4 ],
		columns:[[
		      {field:'id',checkbox:true},
              {field:'coding',title:'配置类型编码',width:140,align:'center'},
              {field:'name',title:'配置类型名称',width:140,align:'center'},
              {field:'remark',title:'描述',width:140,align:'center'},
              {field:'state',title:'是否启用',width:140,align:'center'}   
		]]
	})
	
	//增修查改
    $('#data_add').bind('click', function(){  
    	$('#data_add_option').html("<tr><td style='float:right'>配置类型编码：</td><td><input type='text' id='coding' /><span style='color: red'>*</span></td><td></td></tr><tr><td style='float:right'>配置类型名称：</td><td><input type='text' id='typeName' /><span style='color: red'>*</span></td></tr><tr><td style='float:right'>描述：</td><td><input type='text' id='describe' /><span style='color: red'>*</span></td></tr>");
    	$('#data_add_option').dialog({
    		width:360,
    		height:120,
    		inline:true,
    		left:320,
    		top:210,
			title:'新增',
			buttons:[
						{
							text:'取消',
							width:60,
							handler:function(){	
							    $('#data_add_option').dialog('close')
							}		
						},
						{
							text:'确定',
							width:60,
							handler:function(){	
								if(($('#coding').val()=="")||($('#typeName').val()=="")||($('#describe').val()=="")){
									$.messager.alert({
										title:'提示',
										msg:'请填写必填项！',
										icon:'info'
									});
								}else{
									var data={coding:$('#coding').val(),typeName:$('#typeName').val(),describe:$('#describe').val()};
									$.ajax({
										url:'dateManage/addSystemsetting',
										type:"post",
										data:data,
										success:function(result){
											if(result==1){
												var tab = $('#tabs').tabs('getSelected');  // 获取选择的面板
										    	tab.panel('refresh', 'systemData');
											}
										}
									})
								}
							}		
						}
					]
    	})
    });   
	
	$("#data_delete").bind('click',function(){
		
	})
}