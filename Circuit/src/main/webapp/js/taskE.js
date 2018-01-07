function taskE() {//消缺任务查询统计
	$('#taskE').datagrid({
		url:"selectAllEliminPost",
		columns : [ [ {
			field : 'tcoding',
			title : '任务编号',
			width : 120,
			align : "center",
		}, {
			field : 'tename',
			title : '任务名称',
			width : 120,
			align : "center",
		}, {
			field : 'ethreadCoding',
			title : '线路编号',
			width : 120,
			align : "center",
		}, {
			field : 'estartTower',
			title : '起始杆号',
			width : 120,
			align : "center",
		}, {
			field : 'tendTower',
			title : '终止杆号',
			width : 120,
			align : "center",
		}, {
			field : 'edescription',
			title : '操作',
			width : 120,
			align : "center",
		} ] ],
		pageNumber : 1,
		pageSize : 5,
		pagination : true,
		pageList : [ 5, 10, 15, 20 ],
		rownumbers : true,
	});
	
	$('#toExcel').bind('click',function(){
		$('#option').html("<tr><td style='float:right'>默认保存路径：</td><td><input type='text' id='ePath' value='C:/' readonly='readonly' /></td></tr><tr><td style='float:right'>保存的文件名：</td><td><input type='text' id='eName' /></td></tr>");
		$('#option').dialog({
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
							    $('#option').dialog('close')
							}		
						},
						{
							text:'确定',
							width:60,
							handler:function(){	
								var edata={path:$('#ePath').val(),name:$('#eName').val()}
								$.ajax({
									url:'toEExcel',
									type:"post",
									data:edata,
									success:function(result){
										if(result=="success"){
									    	$('#option').dialog('close')
									    }
									}
								})
							}
						}
				    ]
		})
		
	})
}


function selElId() {
	var id = $("#taskE").datagrid('getSelected');
	$.ajax({
		url:"taskElTowerPost",
		type:"post",
		data:{
			"tcoding":id.tcoding
		}
	});	
	move("杆塔消缺信息","taskElnews");
}


function likeId(){	
	$('#taskE').datagrid('reload',{
		renTitles:$("#a").val(),
		conteTitles:$("#b").val(),
	});
	
}



