function data_tb(){
	$('#data_tb').datagrid({
		url:'dateManage/listSystemsetting',
		height : 200,
		pagination : true,
		pageNumber : 1,
		pageSize : 1,
		singleSelect:true,
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
											}else{
												$.messager.alert({
													title:'错误',
													msg:'添加错误,配置类型编码不能重复！',
													icon:'info'
												});
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
		var cost=$('#data_tb').datagrid('getSelected');   //获取当前行数据   
		if(cost==null){
			$.messager.alert({
				title:'提示',
				msg:'请选择一行进行操作！',
				icon:'info'
			});
    	}else{
		$.messager.confirm('确定','您确定要删除所选的数据类型吗？',function(f){
			if(f){
			var data={id:cost.id};
			$.ajax({
				url:"dateManage/deleteSystemsetting",
				type:"post",
				data:data,
				success:function(result){
					if(result==1){
						var tab = $('#tabs').tabs('getSelected');  // 获取选择的面板
				    	tab.panel('refresh', 'systemData');
					}else{
						$.messager.alert({
							title:'错误',
							msg:'删除错误！',
							icon:'info'
						});
					}
				}
			})
			}
		})
    	}
	})
	
	$("#data_update").bind('click',function(){
		var cost=$('#data_tb').datagrid('getSelected');   //获取当前行数据   
		if(cost==null){
			$.messager.alert({
				title:'提示',
				msg:'请选择一行进行操作！',
				icon:'info'
			});
    	}else{
		var data={id:cost.id};
		$.ajax({
			url:"dateManage/updateSystemsetting",
			type:"post",
			data:data,
			success:function(result){
				$('#data_add_option').html("<tr><td style='float:right'>配置类型编码：</td><td><input type='text' id='coding' readonly='readonly' value='"+result.coding+"'/><span style='color: red'>*</span></td><td></td></tr><tr><td style='float:right'>配置类型名称：</td><td><input type='text' id='typeName' value='"+result.name+"'/><span style='color: red'>*</span></td></tr><tr><td style='float:right'>描述：</td><td><input type='text' id='describe' value='"+result.remark+"'/><span style='color: red'>*</span></td></tr>");
		    	$('#data_add_option').dialog({
		    		width:360,
		    		height:120,
		    		inline:true,
		    		left:320,
		    		top:210,
					title:'修改',
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
											var data={id:cost.id,coding:$('#coding').val(),typeName:$('#typeName').val(),describe:$('#describe').val()};
											$.ajax({
												url:'dateManage/updateSystemsetting2',
												type:"post",
												data:data,
												success:function(result){
													if(result==1){
														var tab = $('#tabs').tabs('getSelected');  // 获取选择的面板
												    	tab.panel('refresh', 'systemData');
													}else{
														$.messager.alert({
															title:'错误',
															msg:'修改错误！',
															icon:'info'
														});
													}
												}
											})
										}
									}		
								}
							]
		    	})
			}
		})
    	}
		
    });  
	
	$("#data_state").bind('click',function(){
		var cost=$('#data_tb').datagrid('getSelected');   //获取当前行数据   
		if(cost==null){
			$.messager.alert({
				title:'提示',
				msg:'请选择一行进行操作！',
				icon:'info'
			});
    	}else{
    	var makr='启用'; 
    	if(cost.state=='启用'){
    		makr='禁用';
    	}
		$.messager.confirm('确定','您确定要'+makr+'所选的数据类型吗？',function(f){
			if(f){
			var data={id:cost.id};
			$.ajax({
				url:"dateManage/stateSystemsetting",
				type:"post",
				data:data,
				success:function(result){
					if(result==1){
						var tab = $('#tabs').tabs('getSelected');  // 获取选择的面板
				    	tab.panel('refresh', 'systemData');
					}else{
						$.messager.alert({
							title:'错误',
							msg:'删除错误！',
							icon:'info'
						});
					}
				}
			})
			}
		})
    	}
	})
	
	
	$("#data_query").bind('click',function(){
		var cost=$('#data_tb').datagrid('getSelected');   //获取当前行数据   
		if(cost==null){
			$.messager.alert({
				title:'提示',
				msg:'请选择一行进行操作！',
				icon:'info'
			});
    	}else{
    		var data={id:cost.id};
    		$.ajax({
    			url:"dateManage/querySystemsetting",
    			type:"post",
    			data:data,
    			success:function(result){
    				var tab = $('#tabs').tabs('getSelected');  // 获取选择的面板
    		    	tab.panel('refresh', 'systemParam');
    			}
    		})
    	}
	})
}