function role_tb(){
	$('#role_tb').datagrid({
		url:'roleManage/listSystemRole',
		height : 330,
		pagination : true,
		pageNumber : 1,
		pageSize : 3,
		rownumbers : true,
		pagination : true,
		singleSelect:true,
		pageList : [ 3, 6, 9 ],
		columns:[[
		      {field:'id',checkbox:true},
              {field:'coding',title:'角色编号',width:110,align:'center'},
              {field:'name',title:'角色名称',width:110,align:'center'},
              {field:'createName',title:'创建人',width:80,align:'center'},
              {field:'updatedDate',title:'更新时间',width:170,align:'center'},
              {
            	  field:'state',title:'状态（启用/未启用）',width:130,align:'center',
            	  formatter:function(value,row,index){
	            	  if(row.state=='0'){
	            		  return '启用';
	            	  }else{
	            		  return '未启用';
	            	  }
            	  }
              },
              {
            	  field:'operation',
            	  title:'操作',
            	  width:'200',
            	  align:'center',
            	  formatter:function(value,row,index){
            		  var oper = '';
            		  if(row.state=='0'){
            			  oper = '<span><a href="javaScript:roleState('
								+ row.id+","+0
								+ ')">禁用</a>｜'
								+ '<a href="javaScript:roleUpdate('
								+ row.id
								+ ')">修改</a>｜'
								+ '<a href="javaScript:roleDelete('
								+ row.id+','+row.state
								+ ')">删除</a></sapn>';
            		  }else{
            			  oper = '<span><a href="javaScript:roleState('
								+ row.id+","+1
								+ ')">启用</a>｜'
								+ '<a href="javaScript:roleUpdate('
								+ row.id
								+ ')">修改</a>｜'
								+ '<a href="javaScript:roleDelete('
								+ row.id+','+row.state
								+ ')">删除</a></sapn>';
            		  }
            		  if(row.name=="系统管理员"){
            			  oper = '<span><a href="javaScript:roleUpdate('
								+ row.id
								+ ')">修改</a></sapn>';
            		  }
            		  return oper;
            	  }
              },
		]]
	})


	$("#role_add").bind('click',function(){
		$('#role_add_option').html("" +
				"<tr>" +
				"<td style='float:right;'>角色编号：</td><td style='width:250px'><input type='text' id='coding' name='param' /><span id='coding2' style='font-size:8px;color:red'>&nbsp;&nbsp;*</span></td>" +
				"</tr><tr>" +
				"<td style='float:right;'>角色名称：</td><td><input type='text' id='name' name='param' /><span id='name2' style='font-size:8px;color:red'>&nbsp;&nbsp;*</span></td>" +
				"</tr><tr>" +
				"<td style='float:right;'>使用状态：</td><td>正常</td>" +
				"</tr>"); 
		$('#role_add_option').dialog({
    		width:400,
    		height:120,
    		inline:true,
    		left:320,
    		top:210,
			title:'添加角色',
			buttons:[
						{
							text:'取消',
							width:60,
							handler:function(){	
							    $('#role_add_option').dialog('close');
							}		
						},
						{
							text:'确定',
							width:60,
							handler:function(){	
								var coding=$('#coding').val();
								var name=$('#name').val();
								if(coding==""||name==""){
									$.messager.alert({
										title:'错误',
										msg:'请填写必填项！',
										icon:'info'
									});
								}else{ 
									    var newId=0;
										var data={id:newId,coding:coding,name:name}
										$.ajax({
											url:'roleManage/verifyRole',
											type:"post",
											data:data,
											success:function(result){
												if(result=="11"){
													$('#name2').html("*");
													$('#coding2').html("*");
													$.ajax({
														url:'roleManage/addRole',
														type:"post",
														data:data,
														success:function(result){
															if(result==1){
																var tab = $('#tabs').tabs('getSelected');  // 获取选择的面板
														    	tab.panel('refresh', 'systemRole');
															}else{
																$.messager.alert({
																	title:'错误',
																	msg:'添加出错！',
																	icon:'info'
																});
															}
														}
													})
												}else if(result=="12"){
													$('#name2').html("角色名称已存在！");
													$('#coding2').html("*");
												}else if(result=="21"){
													$('#name2').html("*");
													$('#coding2').html("角色编号已存在！");
												}else if(result=="22"){
													$('#name2').html("角色名称已存在！");
													$('#coding2').html("角色编号已存在！");
												}
											}
										})
								}
							}		
						}
					]
	    	})
    	
	})
	
	
	$('#role_query').bind('click',function(){
		var r_name=$('#role_name').val();
		var r_cc=$('#role_cc').val();
		$('#role_tb').datagrid('reload',{
			name:r_name,
			state:r_cc
		});
	})
}

function roleState(id,state){
	var data={id:id,state:state};
	if(state==0){
		$.messager.confirm('确定','您确定要禁用所选的用户吗？',function(f){
			if(f){
				$.ajax({
					url:'roleManage/stateRole',
					type:"post",
					data:data,
					success:function(result){
						if(result==1){
							var tab = $('#tabs').tabs('getSelected');  // 获取选择的面板
					    	tab.panel('refresh', 'systemRole');
						}else{
							$.messager.alert({
								title:'错误',
								msg:'错误',
								icon:'info'
							});
						}
					}
				})
			}
		})
	}else{
		$.messager.confirm('确定','您确定要恢复所选的用户吗？',function(f){
			if(f){
				$.ajax({
					url:'roleManage/stateRole',
					type:"post",
					data:data,
					success:function(result){
						if(result==1){
							var tab = $('#tabs').tabs('getSelected');  // 获取选择的面板
					    	tab.panel('refresh', 'systemRole');
						}else{
							$.messager.alert({
								title:'错误',
								msg:'错误',
								icon:'info'
							});
						}
					}
				})
			}
		})
	}
	
}


function roleUpdate(id){
		var dataId={id:id}
		$.ajax({
			url:'roleManage/queryRole',
			type:"post",
			data:dataId,
			success:function(result){
			$('#role_update_option').html("" +
					"<tr>" +
					"<td style='float:right;'>角色编号：</td><td style='width:250px'><input type='text' id='newCoding' name='param' /><span id='newCoding2' style='font-size:8px;color:red'>&nbsp;&nbsp;*</span></td>" +
					"</tr><tr>" +
					"<td style='float:right;'>角色名称：</td><td><input type='text' id='newName' name='param' /><span id='newName2' style='font-size:8px;color:red'>&nbsp;&nbsp;*</span></td>" +
					"</tr><tr>" +
					"<td style='float:right;'>使用状态：</td><td id='newState'></td>" +
					"</tr>"); 
			
			if(result.name=="系统管理员"){
				$('#newCoding').val(result.coding);
				$('#newName').val(result.name);
				$('#newState').val(result.state);
				$('#newCoding').attr("readonly","readonly");
				$('#newName').attr("readonly","readonly");
			}else{
				$('#newCoding').val(result.coding);
				$('#newName').val(result.name);
				$('#newState').val(result.state);
			}
			if(result.state==0){
				$('#newState').html("启用");
			}else{
				$('#newState').html("未启用");
			}
	
		$('#role_update_option').dialog({
    		width:400,
    		height:120,
    		inline:true,
    		left:320,
    		top:210,
			title:'修改用户',
			buttons:[
						{
							text:'取消',
							width:60,
							handler:function(){	
							    $('#role_update_option').dialog('close');
							}		
						},
						{
							text:'确定',
							width:60,
							handler:function(){	
								if($('#newName').val()=="系统管理员"){
									$('#role_update_option').dialog('close');
								}else{
								var newCoding=$('#newCoding').val();
								var newName=$('#newName').val();
								var rUN="";
								var rN="";
								if(newCoding==""||newName==""){
									$.messager.alert({
										title:'错误',
										msg:'请填写必填项！',
										icon:'info'
									});
								}else{
										var data={id:id,coding:newCoding,name:newName}
										$.ajax({
											url:'roleManage/verifyRole',
											type:"post",
											data:data,
											success:function(result){
												if(result=="11"){
													$('#newName2').html("*");
													$('#newCoding2').html("*");
													var newData={id:id,coding:newCoding,name:newName}
													$.ajax({
														url:'roleManage/updateRole',
														type:"post",
														data:newData,
														success:function(result){
															if(result==1){
																var tab = $('#tabs').tabs('getSelected');  // 获取选择的面板
														    	tab.panel('refresh', 'systemRole');
															}else{
																$.messager.alert({
																	title:'错误',
																	msg:'修改出错！',
																	icon:'info'
																});
															}
														}
													})
												}else if(result=="12"){
													$('#newName2').html("角色名称已存在！");
													$('#newCoding2').html("*");
												}else if(result=="21"){
													$('#newName2').html("*");
													$('#newCoding2').html("角色编号已存在！");
												}else if(result=="22"){
													$('#newName2').html("角色名称已存在！");
													$('#newCoding2').html("角色编号已存在！");
												}
											}
										})
								}
									
								}
							}		
						}
					]
    	})
		}
	})
}


function roleDelete(id,state){
	if(state==1){
		$.messager.confirm('确定','您确定要删除所选的角色吗？',function(f){
			if(f){
				var data={id:id};
				$.ajax({
					url:'roleManage/deleteRole',
					type:"post",
					data:data,
					success:function(result){
						var tab = $('#tabs').tabs('getSelected');  // 获取选择的面板
				    	tab.panel('refresh', 'systemRole');
					}
				})
			}
		})
	}else{
		$.messager.alert({
			title:'提示',
			msg:'不能删除未禁用的角色',
			icon:'info'
		});
	}
}