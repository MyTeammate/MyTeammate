function tower(){
	$('#tower').datagrid({    
	    url:'http://192.168.16.250:7070/tower/getTowerData',    
	    columns:[[    
	        {field:'coding',title:'代码',width:200},    
	        {field:'lineId',title:'所属路线',width:200},    
	        {field:'state',title:'状态（启用/停用）',width:200},    
	        {field:'operation',title:'修改|删除',width:200}
	    ]],
	    pagination:true,
	    pageList:[1,5,10],
	    pageSize:5,
	});  
}

function go(){	
	move("增加",'home');
}
