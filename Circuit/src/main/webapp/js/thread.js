var $lineId;
function thread($line){
      
       $lineId = $line;
       alert($lineId)
}
$(function(){
	$('#thread').datagrid({    
	    url:'thread/getThreadData?lineId='+$lineId,    
	    columns:[[    
	        {field:'coding',title:'线路编号',width:200,align:'center'},    
	        {field:'name',title:'线路名称',width:200,align:'center'},
	        {field:'lineName',title:'所属路线名称',width:200,align:'center'},    
	        {field:'startTower',title:'起始杆号',width:200,align:'center'},    
	        {field:'endTower',title:'结束杆号',width:200,align:'center'},
	        {field:'redix',title:'塔基数',width:200,align:'center'},
	        {field:'runningStateString',title:'运行状态',width:200,align:'center'},
	        {field:'stateString',title:'启用状态',width:200,align:'center'},
	        {field:'operation',title:'操作',width:300,align:'center'}
	        
	    ]],
	    pagination:true,
	    pageList:[1,5,10],
	    pageSize:5,
	    fitColumns:true,
	    toolbar:'#threadTb'



	}); 
})