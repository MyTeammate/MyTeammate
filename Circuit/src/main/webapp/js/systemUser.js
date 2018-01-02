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
								+ row.id
								+ ')">冻结</a>｜'
								+ '<a href="javaScript:userUpdate('
								+ row.id
								+ ')">修改</a>｜'
								+ '<a href="javaScript:userDelete('
								+ row.id
								+ ')">删除</a>｜'
								+ '<a href="javaScript:userLOG('
								+ row.id
								+ ')">LOG日志</a></span>';
            		  }else{
            			  oper = '<span><a href="javaScript:userState('
								+ row.id
								+ ')">正常</a>｜'
								+ '<a href="javaScript:userUpdate('
								+ row.id
								+ ')">修改</a>｜'
								+ '<a href="javaScript:userDelete('
								+ row.id
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
						"<td style='float:right;'>用户账号：</td><td><input type='text' id='userName' name='param' /><span id='userName2' style='font-size:9px;'></span></td>" +
						"</tr><tr>" +
						"<td style='float:right;'>用户名称：</td><td><input type='text' id='name' name='param' /><span id='user2'></span></td>" +
						"</tr><tr>" +
						"<td style='float:right;'>密码：</td><td><input type='text' id='passWord' name='param' /><span id='passWord2' style='font-size:8px;'>默认初始密码为123456</span></td>" +
						"</tr><tr>" +
						"<td style='float:right;'>角色：</td>" +
						"<td>" +
						"<select id='roleId' class='easyui-combobox' name='dept' style='width:80px;' data-options='panelMaxHeight:'70px',editable:false'>" +
						"<option value='0'>--请选择--</option>" +
						$op+
						"</select><span id='roleId2'></span>" +
						"</td>" +
						"</tr><tr>" +
						"<td style='float:right;'>入职时间：</td><td><input type='text' id='entryDate'/><span id='entryDate2'></span></td>" +
						"</tr><tr>" +
						"<td style='float:right;'>使用状态：</td><td>正常</td>" +
						"</tr>");
				$('#entryDate').datebox({    
				    editable:false
				});  
				/*$("#passWord2").css("size","5px");*/
			}
		})
		
    		$('#user_add_option').dialog({
    			/*closed:true,*/
	    		width:390,
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
									if(userName!=""&&name!=""&&passWord!=""&&roleId!=""&&entryDate!=""){
										alert("123");
									}else{
										alert("0");
										var reg = /^[0-9A-Za-z]{4,12}$/;
										if(!reg.exec(userName)){
											alert("1");
										}else{
											alert("2");
										}
									}
								}		
							}
						]
	    	})
    	
	})
}


function userState(id){
	alert(id);
}

function userUpdate(id){
	alert("2");
}

function userDelete(id){
	alert("3");
}

function userLOG(id){
	alert("4");
}
 