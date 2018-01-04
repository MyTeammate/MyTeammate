function role_tb(){
	$('#role_tb').datagrid({
		url:'roleManage/listSystemRole',
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
              {field:'coding',title:'角编号',width:110,align:'center'},
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
            			  oper = '<span><a href="javaScript:roleUpdate('
								+ row.id
								+ ')">修改</a>｜'
								+ '<a href="javaScript:roleDelete('
								+ row.id
								+ ')">删除</a></sapn>';
            		  }
            		  return oper;
            	  }
              },
		]]
	})

	$("#role_add").bind('click',function(){
		$.ajax({
			url:'userManage/select',
			type:"post",
			success:function(result){
				var $op="";
				for (var int = 0; int < result.length; int++) {
					$op=$op+"<option value='"+result[int].id+"'>"+result[int].name+"</option>";
				}
				$('#role_add_option').html("" +
						"<tr>" +
						"<td style='float:right;'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;角色编号：</td><td><input type='text' id='coding' name='param' /><span id='coding2' style='font-size:8px;color:red'>&nbsp;&nbsp;*</span></td>" +
						"</tr><tr>" +
						"<td style='float:right;'>角色名称：</td><td><input type='text' id='name' name='param' /><span id='name2' style='font-size:8px;color:red'>&nbsp;&nbsp;*</span></td>" +
						"</tr><tr>" +
						"<td style='float:right;'>使用状态：</td><td>正常</td>" +
						"</tr>");
				$('#entryDate').datebox({    
				    editable:false
				});  
			}
		})
		
    		$('#role_add_option').dialog({
    			/*closed:true,*/
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
											var data={coding:coding,name:name}
											$.ajax({
												url:'roleManage/verifyRole',
												type:"post",
												data:data,
												success:function(result){
													if(result=="11"){
														
													}else if(result=="12"){
														$('#name2').html("已存在！");
													}else if(result=="21"){
														$('#coding2').html("已存在！");
													}
												}
											})
									}
								}		
							}
						]
	    	})
    	
	})
}


function roleState(id,state){
	var data={id:id,state:state};
	if(state==0){
		$.messager.confirm('确定','您确定要冻结所选的用户吗？',function(f){
			if(f){
				$.ajax({
					url:'userManage/freezeUser',
					type:"post",
					data:data,
					success:function(result){
						if(result==1){
							var tab = $('#tabs').tabs('getSelected');  // 获取选择的面板
					    	tab.panel('refresh', 'systemUser');
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
					url:'userManage/freezeUser',
					type:"post",
					data:data,
					success:function(result){
						if(result==1){
							var tab = $('#tabs').tabs('getSelected');  // 获取选择的面板
					    	tab.panel('refresh', 'systemUser');
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
	$.ajax({
		url:'userManage/select',
		type:"post",
		success:function(result){
			var $op="";
			for (var int = 0; int < result.length; int++) {
				$op=$op+"<option value='"+result[int].id+"'>"+result[int].name+"</option>";
			}
			$('#role_update_option').html("" +
					"<tr>" +
					"<td style='float:right;'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;用户账号：</td><td><input type='text' id='userName' name='param' /><span id='userName2' style='font-size:8px;color:red'>&nbsp;&nbsp;*</span></td>" +
					"</tr><tr>" +
					"<td style='float:right;'>用户姓名：</td><td><input type='text' id='name' name='param' /><span id='name2' style='font-size:8px;color:red'>&nbsp;&nbsp;*</span></td>" +
					"</tr><tr>" +
					"<td style='float:right;'>密码：</td><td><input type='passWord' id='passWord' name='param' /><span id='passWord2' style='font-size:8px;'>&nbsp;&nbsp;默认初始密码为123456</span></td>" +
					"</tr><tr>" +
					"<td style='float:right;'>角色：</td>" +
					"<td>" +
					"<select id='roleId' class='easyui-combobox' name='dept' style='width:90px;' data-options='panelMaxHeight:'120px',editable:false'>" +
					"<option value='0'>--请选择--</option>" +
					$op+
					"</select><span id='roleId2' style='color:red'>&nbsp;&nbsp;*</span>" +
					"</td>" +
					"</tr><tr>" +
					"<td style='float:right;'>入职时间：</td><td><input type='text' id='entryDate'/><span id='entryDate2' style='color:red'>&nbsp;&nbsp;*</span></td>" +
					"</tr><tr>" +
					"<td style='float:right;'>离职时间：</td><td><input type='text' id='leaveDate'/><span id='leaveDate2' style='color:red'>&nbsp;&nbsp;*</span></td>" +
					"</tr><tr>" +
					"<td style='float:right;'>使用状态：</td><td id='state'>正常</td>" +
					"</tr>");
			$('#entryDate').datebox({    
			    editable:false
			});
			$('#leaveDate').datebox({    
			    editable:false
			});
			var dataId={id:id};
			$.ajax({
				url:'userManage/userId',
				type:"post",
				data:dataId,
				success:function(result){
					alert("231423");
					$('#userName').val(result.userName);
					$('#name').val(result.name);
					$('#passWord').val(result.passWord);
					$('#roleId').val(result.roleId);
					$('#entryDate').datebox('setValue', result.entryDate);
					if(result.state==0){
						$('#state').html("正常");
					}else{
						$('#state').html("冻结");
					}
					
				}
			})
		}
	})
	
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
							    $('#user_add_option').dialog('close');
							}		
						},
						{
							text:'确定',
							width:60,
							handler:function(){	
								var userName=$('#userName').val();
								var name=$('#name').val();
								var passWord=$('#passWord').val();
								var roleId=$('#roleId').val();
								var entryDate=$('#entryDate').val();
								var leaveDate=$('#leaveDate').val();
								var rUN="";
								var rN="";
								if(userName==""||name==""||roleId==""||entryDate==""){
									$.messager.alert({
										title:'错误',
										msg:'请填写必填项！',
										icon:'info'
									});
								}else{
									var regUserName = /^[0-9A-Za-z]{4,12}$/;
									if(!regUserName.exec(userName)){
										$('#userName2').html("&nbsp;&nbsp;账号的长度为4-12位英文数字");
										$('#userName2').css("color","red");
									}else{
										var data={id:id,userName:userName}
										$.ajax({
											url:'userManage/queryUserName2',
											type:"post",
											data:data,
											success:function(result){
												if(result=="success"){
													rUN="success";
													$('#userName2').html("&nbsp;&nbsp;*");
												}else{
													$('#userName2').html("&nbsp;&nbsp;用户账号已存在！");
													$('#userName2').css("color","red");
												}
												
												var regName=/^[A-Za-z\u4e00-\u9fa5]{2,12}$/;
												if(!regName.exec(name)){
													$('#name2').html("&nbsp;&nbsp;2-12个汉字或字母组成");
													$('#name2').css("color","red");
												}else{
													var data={id:id,name:name};
													$.ajax({
														url:'userManage/queryName2',
														type:"post",
														data:data,
														success:function(result){
															if(result=="success"){
																rN="success";
																$('#name2').html("&nbsp;&nbsp;*");
															}else{
																$('#name2').html("&nbsp;&nbsp;用户姓名已存在！");
																$('#name2').css("color","red");
															}
															if(rUN=="success"&&rN=="success"){
																$.messager.confirm('确定','您确定要修改所选的用户吗？',function(f){
																	var dataUser={id:id,userName:userName,name:name,passWord:passWord,roleId:roleId,entryDate:entryDate,leaveDate:leaveDate};
																	$.ajax({
																		url:'userManage/update',
																		type:"post",
																		data:dataUser,
																		success:function(result){
																			if(result==0){
																				$.messager.alert({
																					title:'错误',
																					msg:'添加错误',
																					icon:'info'
																				});
																			}else{
																				var tab = $('#tabs').tabs('getSelected');  // 获取选择的面板
																		    	tab.panel('refresh', 'systemUser');
																			}
																		}
																	})
																})
															}else{
															}
															
														}
													})
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

function roleDelete(id,state){
	if(state==1){
		$.messager.confirm('确定','您确定要删除所选的用户吗？',function(f){
			var data={id:id};
			$.ajax({
				url:'userManage/delete',
				type:"post",
				data:data,
				success:function(result){
					
				}
			})
		})
	}else{
		$.messager.alert({
			title:'提示',
			msg:'不能删除未离职的用户',
			icon:'info'
		});
	}
}

 