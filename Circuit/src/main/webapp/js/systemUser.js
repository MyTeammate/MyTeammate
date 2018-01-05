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
              {field:'userName',title:'用户账号',width:110,align:'center'},
              {field:'name',title:'用户姓名',width:110,align:'center'},
              {field:'roleName',title:'角色',width:80,align:'center'},
              {field:'email',title:'邮箱',width:170,align:'center'},
              {field:'loginDate',title:'最后一次登录时间',width:160,align:'center'},
              {
            	  field:'state',title:'状态（正常/冻结）',width:130,align:'center',
            	  formatter:function(value,row,index){
	            	  if(row.state=='0'){
	            		  return '正常';
	            	  }else{
	            		  return '冻结';
	            	  }
	            	  return '5';
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
            			  oper = '<span><a href="javaScript:userState('
								+ row.id+','+0
								+ ')">冻结</a>｜'
								+ '<a href="javaScript:userUpdate('
								+ row.id
								+ ')">修改</a>｜'
								+ '<a href="javaScript:userDelete('
								+ row.id+','+0
								+ ')">删除</a>｜'
								+ '<a href="javaScript:userLOG('
								+ row.id
								+ ')">LOG日志</a></span>';
            		  }else{
            			  oper = '<span><a href="javaScript:userState('
								+ row.id+','+1
								+ ')">正常</a>｜'
								+ '<a href="javaScript:userUpdate('
								+ row.id
								+ ')">修改</a>｜'
								+ '<a href="javaScript:userDelete('
								+ row.id+','+1
								+ ')">删除</a>｜'
								+ '<a href="javaScript:userLOG('
								+ row.id
								+ ')">LOG日志</a></span>';
            		  }
            		  return oper;
            	  }
              },
		]]
	})
	
	
	/*$('#user_add_option').html("" +
				"<tr>" +
				"<td style='float:right;'>用户账号：</td><td><input type='text' id='0' name='param' /></td>" +
				"</tr><tr>" +
				"<td style='float:right;'>用户名称：</td><td><input type='text' id='0' name='param' /></td>" +
				"</tr><tr>" +
				"<td style='float:right;'>密码：</td><td><input type='text' id='0' name='param' /></td>" +
				"</tr><tr>" +
				"<td style='float:right;'>角色：</td><td><select id='user_cc' class='easyui-combobox' name='dept' style='width:80px;' data-options='panelMaxHeight:'70px',editable:false'><option value='--请选择--'>--请选择--</option><option value='正常'>正常</option><option value='冻结'>冻结</option></select></td>" +
				"</tr><tr>" +
				"<td style='float:right;'>入职时间：</td><td><input type='text' id='entryDate'/></td>" +
				"</tr><tr>" +
				"<td style='float:right;'>离职时间：</td><td><input type='text' id='leaveDate'/></td>" +
				"</tr><tr>" +
				"<td style='float:right;'>使用状态：</td><td><input type='text' id='0' name='param' /></td>" +
				"</tr>");
		$('#entryDate').datebox({    
		    required:true,
		    editable:false
		});  
		$('#leaveDate').datebox({    
		    required:true,
		    editable:false
		});  */

	$("#user_add").bind('click',function(){
		$.ajax({
			url:'userManage/select',
			type:"post",
			success:function(result){
				var $op="";
				for (var int = 0; int < result.length; int++) {
					$op=$op+"<option value='"+result[int].id+"'>"+result[int].name+"</option>";
				}
				$('#user_add_option').html("" +
						"<tr>" +
						"<td style='float:right;'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;用户账号：</td><td><input type='text' id='uuserName' name='param' /><span id='uuserName2' style='font-size:8px;color:red'>&nbsp;&nbsp;*</span></td>" +
						"</tr><tr>" +
						"<td style='float:right;'>用户姓名：</td><td><input type='text' id='uname' name='param' /><span id='uname2' style='font-size:8px;color:red'>&nbsp;&nbsp;*</span></td>" +
						"</tr><tr>" +
						"<td style='float:right;'>密码：</td><td><input type='passWord' id='upassWord' name='param' /><span id='passWord2' style='font-size:8px;'>&nbsp;&nbsp;默认初始密码为123456</span></td>" +
						"</tr><tr>" +
						"<td style='float:right;'>角色：</td>" +
						"<td>" +
						"<select id='uroleId' class='easyui-combobox' name='dept' style='width:90px;' data-options='panelMaxHeight:'120px',editable:false'>" +
						"<option value='0'>--请选择--</option>" +
						$op+
						"</select><span id='roleId2' style='color:red'>&nbsp;&nbsp;*</span>" +
						"</td>" +
						"</tr><tr>" +
						"<td style='float:right;'>入职时间：</td><td><input type='text' id='uentryDate'/><span id='entryDate2' style='color:red'>&nbsp;&nbsp;*</span></td>" +
						"</tr><tr>" +
						"<td style='float:right;'>使用状态：</td><td>正常</td>" +
						"</tr>");
				$('#uentryDate').datebox({    
				    editable:false
				});  
			}
		})
		
    		$('#user_add_option').dialog({
	    		width:400,
	    		height:120,
	    		inline:true,
	    		left:320,
	    		top:210,
				title:'添加用户',
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
									var auserName=$('#uuserName').val();
									var aname=$('#uname').val();
									var apassWord=$('#upassWord').val();
									var aroleId=$('#uroleId').val();
									var aentryDate=$('#uentryDate').val();
									var arUN="";
									var arN="";
									if(auserName==""||aname==""||aroleId==""||aentryDate==""){
										$.messager.alert({
											title:'错误',
											msg:'请填写必填项！',
											icon:'info'
										});
									}else{
										var aregUserName = /^[0-9A-Za-z]{4,12}$/;
										if(!aregUserName.exec(auserName)){
											$('#uuserName2').html("&nbsp;账号限制4-12位英文数字");
											$('#uuserName2').css("color","red");
										}else{
											var adata={userName:auserName}
											$.ajax({
												url:'userManage/queryUserName',
												type:"post",
												data:adata,
												success:function(result){
													if(result=="success"){
														arUN="success";
														$('#uuserName2').html("&nbsp;&nbsp;*");
													}else{
														$('#uuserName2').html("&nbsp;&nbsp;用户账号已存在！");
														$('#uuserName2').css("color","red");
													}
													
													var aregName=/^[A-Za-z\u4e00-\u9fa5]{2,12}$/;
													if(!aregName.exec(aname)){
														$('#uname2').html("&nbsp;2-12个汉字或字母组成");
														$('#uname2').css("color","red");
													}else{
														var data={name:aname};
														$.ajax({
															url:'userManage/queryName',
															type:"post",
															data:data,
															success:function(result){
																if(result=="success"){
																	arN="success";
																	$('#uname2').html("&nbsp;&nbsp;*");
																}else{
																	$('#uname2').html("&nbsp;&nbsp;用户姓名已存在！");
																	$('#uname2').css("color","red");
																}
																if(arUN=="success"&&arN=="success"){
																	var dataUser={userName:auserName,name:aname,passWord:apassWord,roleId:aroleId,entryDate:aentryDate};
																	$.ajax({
																		url:'userManage/add',
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
    	
	})
}


function userState(id,state){
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

function userUpdate(id){ 
	$.ajax({
		url:'userManage/select',
		type:"post",
		success:function(result){
			var $op="";
			for (var int = 0; int < result.length; int++) {
				$op=$op+"<option value='"+result[int].id+"'>"+result[int].name+"</option>";
			}
			$('#user_update_option').html("" +
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
	
		$('#user_update_option').dialog({
			/*closed:true,*/
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
							    $('#user_update_option').dialog('close');
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
									var uregUserName = /^[0-9A-Za-z]{4,12}$/;
									if(!uregUserName.exec(userName)){
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

function userDelete(id,state){
	if(state==1){
		$.messager.confirm('确定','您确定要删除所选的用户吗？',function(f){
			var data={id:id};
			$.ajax({
				url:'userManage/delete',
				type:"post",
				data:data,
				success:function(result){
					var tab = $('#tabs').tabs('getSelected');  // 获取选择的面板
			    	tab.panel('refresh', 'systemUser');
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

function userLOG(id){
	alert("4");
}
 