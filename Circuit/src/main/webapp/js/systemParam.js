function parameter_tb(){
	$('#parameter_tb').datagrid({
		url:'paramManage/listSystemparam',
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
              {field:'settingName',title:'配置参数名称',width:560,align:'center'},
		]]
	})
	
	//增修查改
    $('#parameter_add').bind('click', function(){ 
    	$('#parameter_add_option').html("<tr><td style='float:right;'>配置参数名称1：</td><td><input type='text' id='0' name='param' /><span style='color: red'>*</span></td></tr><tr><td style='float:right'>配置参数名称2：</td><td><input type='text' name='param' id='1' /><span style='color: red'>*</span></td></tr>");
    	var num=1;
    	$('#parameter_add_option').dialog({
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
							    $('#parameter_add_option').dialog('close')
							}		
						},
						{
							text:'取消选项',
							width:60,
							handler:function(){
								$('#parameter_add_option tr:gt(1)').last().remove();
								num=num-1;
							}
						},		
						{
							text:'新增选项',
							width:60,
							handler:function(){
								num=num+1;
								var take=num;
								var add="<tr><td style='float:right'>配置参数名称"+(take+1)+"：</td><td><input type='text' name='param' id='"+num+"' /><span style='color: red'>*</span></td></tr>";
								var $nodeInput=$(add);
								$('#parameter_add_option').append($nodeInput);  
							},	
						},
						{
							text:'确定',
							width:60,
							handler:function(){	
								var obj="";
								var els =document.getElementsByName("param");
								for (var i = 0, j = els.length; i < j; i++){
									obj=obj+els[i].value+",";
								}
								var data={obj:obj};
								$.ajax({
									url:'paramManage/add',
									type:"post",
									data:data,
									success:function(result){
										if(result=="success"){
											var tab = $('#tabs').tabs('getSelected');  // 获取选择的面板
									    	tab.panel('refresh', 'systemParam');
										}else if(result=="error"){
											$.messager.alert({
												title:'错误',
												msg:'参数不能添加重复！',
												icon:'info'
											});
										}else{
											$.messager.alert({
												title:'错误',
												msg:''+result+'添加错误,可能已经存在不能重复创建！',
												icon:'info'
											});
										}
									}
								})
							}		
						}
					]
    	})
    });   
	
	$("#parameter_delete").bind('click',function(){
		var cost=$('#parameter_tb').datagrid('getSelected');   //获取当前行数据   
		if(cost==null){
			$.messager.alert({
				title:'提示',
				msg:'请选择一行进行操作！',
				icon:'info'
			});
    	}else{
		$.messager.confirm('确定','您确定要冻结所选的用户吗？',function(f){
			if(f){
			var data={id:cost.id};
			$.ajax({
				url:"paramManage/delete",
				type:"post",
				data:data,
				success:function(result){
					if(result==1){
						var tab = $('#tabs').tabs('getSelected');  // 获取选择的面板
				    	tab.panel('refresh', 'systemParam');
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
	
	$("#parameter_update").bind('click',function(){
		var cost=$('#parameter_tb').datagrid('getSelected');   //获取当前行数据   
		if(cost==null){
			$.messager.alert({
				title:'提示',
				msg:'请选择一行进行操作！',
				icon:'info'
			});
    	}else{
			$('#parameter_add_option').html("<tr><td style='float:right;'>配置参数原名称：</td><td><input type='text' readonly='readonly' id='settingName' value='"+cost.settingName+"'/><span style='color: red'>*</span></td></tr><tr><td style='float:right'>配置参数新名称：</td><td><input type='text' id='newName' /><span style='color: red'>*</span></td></tr>");
	    	$('#parameter_add_option').dialog({
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
								    $('#parameter_add_option').dialog('close')
								}		
							},
							{
								text:'确定',
								width:60,
								handler:function(){	
									if($('#newName').val()==""){
										$.messager.alert({
											title:'提示',
											msg:'请填写新参数名！',
											icon:'info'
										});
									}else{
										var data={id:cost.id,newName:$('#newName').val()};
										$.ajax({
											url:'paramManage/update',
											type:"post",
											data:data,
											success:function(result){
												if(result=="success"){
													var tab = $('#tabs').tabs('getSelected');  // 获取选择的面板
											    	tab.panel('refresh', 'systemParam');
												}else{
													$.messager.alert({
														title:'错误',
														msg:'修改错误，因为这个新参数已经存在！',
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
		
    });  
	
	$('#parameter_back').bind('click',function(){
		var tab = $('#tabs').tabs('getSelected');  // 获取选择的面板
    	tab.panel('refresh', 'systemData');
	})
}