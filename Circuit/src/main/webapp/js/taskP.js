function taskP() {// 巡检记录统计数据查询
	$('#taskP').datagrid({
		url : "taskPollingPost",
		columns : [ [ {
			field : 'coding',
			title : '任务编号',
			width : 150,
			align : "center",
		}, {
			field : 'tanem',
			title : '任务名称',
			width : 150,
			align : "center",
		}, {
			field : 'threadCoding',
			title : '线路编号',
			width : 150,
			align : "center",
		}, {
			field : 'startTower',
			title : '起始杆号',
			width : 150,
			align : "center",
		}, {
			field : 'engTower',
			title : '终止杆号',
			width : 150,
			align : "center",
		}, {
			field : 'description',
			title : '操作',
			width : 150,
			align : "center",
		} ] ],
		pageNumber : 1,
		pageSize : 5,
		pagination : true,
		pageList : [ 5, 10, 15, 20 ],
		rownumbers : true,
		
	});
	
	
}

function selId() {
	var id = $("#taskP").datagrid('getSelected');
	$.ajax({
		url : "taskTowerPost",
		type : "post",
		data : {
			"coding" : id.coding
		}
	});

	move("杆塔信息", "taskPonew");
}

function plListid() {
	$('#taskP').datagrid('reload',{
		renTitle:$('#ren').val(),
		conteTitle:$('#lu').val(),
	});
}

function addxls(){
		$('#poption').html("<tr><td style='float:right'>默认保存路径：</td><td><input type='text' id='pPath' value='C:/' readonly='readonly' /></td></tr><tr><td style='float:right'>保存的文件名：</td><td><input type='text' id='pName' /></td></tr>");
		$('#poption').dialog({
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
								$('#poption').dialog('close')
							}		
						},
						{
							text:'确定',
							width:60,
							handler:function(){	
								var edata={path:$('#pPath').val(),name:$('#pName').val()}
								$.ajax({
									url:'toPExcel',
									type:"post",
									data:edata,
									success:function(result){
									    if(result=="success"){
									    	$('#poption').dialog('close')
									    }	
									}
								})
							}
						}
				    ]
		})
}
