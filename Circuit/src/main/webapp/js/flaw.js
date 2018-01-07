$(function() {
	$("#flaw_datagrid").datagrid({
		url : 'getflawpage',
		width : 950,
		height : 500,
		// total:5,
		fitColumns : true,
		striped : true,
		rownumbers : true,
		pagination : true,
		pageSize : 2,
		pageList : [ 2, 5, 10, 15, 20 ],
		pageNumber : 2,
		toolbar : "#flaw_tool",
		columns : [ [ {
			field : 'name',
			title : '缺陷类型名称',
			width : 200,
			align: "center",
		},{
			field : 'state',
			title : '状态（启用/未启用）',
			width : 100,
			align: "center",
			formatter:function(value,row){
				var flawstate='';
				if (value=='0') {
					flawstate="启用";
				} else if(value=='1') {
					flawstate="未启用";
				}
				return flawstate;
			}
		},{
			field : 'operate',
			title : '操作',
			width : 200,
			align: "center",
			formatter:function(value,row){
				var oper='';
				if (row.state==0) {
					oper='<span><a href="javascript:updateFlaw('+row.id+')" style="text-decoration:none;">修改</a>｜<a style="color:#CDC5BF">删除</a></span>';
				} else if (row.state==1) {
					oper='<span><a href="javascript:updateFlaw('+row.id+')" style="text-decoration:none;">修改</a>｜<a href="javascript:deleteFlawState('+row.id+')" style="text-decoration:none;">删除</a></span>';
				}
				return oper;
			}
		}, ] ],
	});
	
	
	$('#fstateadd').dialog({
		width : 230,
		height : 130,
		top : 300,
		title : '添加缺陷类型',
		href : 'fstateadd',
		modal : true,// 后面加一个不可编辑
		closed : true,// 默认情况下是关闭状态
		buttons : [ {
			text : '保存',
			handler : function() {
				if ($('#fstateadd').form('validate')) {
					$.ajax({
						url:"flawadd",
						type :"post",
						data : $('#fstateadd').serialize(),
					});
					// 关闭窗口
					$('#fstateadd').dialog('close').form('reset');
					// 刷新数据表格
					$('#flaw_datagrid').datagrid('reload');
				}
			}
		}, {
			text : '返回',
			handler : function() {
				$('#fstateadd').dialog('close').form('reset');
			}
		} ]
	});
	
	/*
	 * 点击添加缺陷类型
	 * 
	 * */
	flaw_onclick = {
		add : function(){
			$("#fstateadd").dialog('open')
		},
		
	}
	
});

function fladd(){
	$('#fladd').form('submit', {
		url: "addfl",
		onSubmit: function(){
			var isValid = $(this).form('validate');
			if (!isValid){
				return false;
			}
			if(towerFlaf=="false"){
				return false;
			}
		},
	});
}

/*
 * 查看缺陷任务
 * */
function lookFlaw(id){
	alert(id);
}

/*
 * 修改缺陷
 */
function updateFlaw(id){
	$.ajax({
		url:"lookupdate",
		type:"POST",
		data:{
			id:id
		},
		success:function(data){
			$("#updateFlaw_form").html(""
				+"<input type='hidden' id='flawId' name='id' />"
				+"<tr>"
					+"<td>缺陷类型名称：</td>"
					+"<td><input id='flawname' type='text' name='name'></td>"
				+"</tr>"
				+"<tr>"
					+"<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;启用状态：</td>"
					+"<td>启用<input type='radio' value='0' name='state'/>&nbsp;&nbsp;不启用<input type='radio' value='1' name='state' /></td>"
				+"</tr>"
			);
			$("#flawId").val(data.id);
			$("#flawname").val(data.name);
			$("input[name='state']").each(function(index, element) {
	            if($(this).val()==data.state){
					$(this).prop("checked",true);
					}
		        });
			
			$('#updateFlaw_form').dialog({
	    		width:300,
	    		height:120,
	    		inline:true,
	    		left:320,
	    		top:210,
				title:'修改缺陷',
				buttons:[
							{
								text:'取消',
								width:60,
								handler:function(){	
								    $('#updateFlaw_form').dialog('close');
								}		
							},
							{
								text:'确定',
								width:60,
								handler:function(){	
									if($("#flawname").val()==''){
										$.messager.alert({
											title:'提示',
											msg:'<h3 style="color: red;">请完善信息！</h3>',
											icon:'warning',
										})
									}else{
										$.ajax({
											url:"updatefla",
											type:"POST",
											data:$("#updateFlaw_form").serialize(),
											success:function(result){
												$('#updateFlaw_form').dialog('close').form('reset');
												$('#flaw_datagrid').datagrid('reload');
											}
										});
									}
								}
							}]
			})
			
		}
	})
}

/*
 * 删除缺陷
 */
function deleteFlawState(id){
	$.messager.confirm('确定','您确定要删除所选的缺陷类型吗？',function(f){
		if(f){
			$.ajax({
				url:"deleteFlawState",
				type:"POST",
				data:{
					id:id
				},
				success:function(result){
					if(result){
						 $.messager.show({
							title:'提示',
							msg:'删除成功',
							timeout:500,
							showType:"fade",
							style:{
							}
						});
					}else{
						$.messager.alert({
							title:'删除失败',
							msg:'<h3 style="color: red;">未知错误导致失败，请重试！</h3>',
							icon:'warning',
						})
					}
					$('#flaw_datagrid').datagrid('reload');
				}
			})
		}
	})
}


