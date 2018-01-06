
var $lineId;
var $lineName;
var threadFlagThread = "";
function thread(lineId,lineName){
       $lineId = lineId;
       $lineName = lineName;
}
$(function(){
	$("#threadHidden").val($lineName);
	$('#thread').datagrid({    
	    url:'thread/getThreadData?lineId='+$lineId, 
	    singleSelect:true,
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
	$("#threadCoding").textbox({
		onChange:function(){
			validateThread('thread',this,'thread/checkThreadCoding');
		}
	});
	
	$("#startTowerThread").combobox({
		url:'thread/getAllTowerData?lineId='+$lineId,
		onChange:function(){
			if($(this).val()!=""){
				$("#endTowerThread").combobox({
					value:'',
					valueField:'coding',
					required:true,
					textField:'coding',
					editable:false,
					url:'thread/getAllTowerData?lineId='+$lineId+'&coding='+$(this).val()
				})
			}
		}
	});
	

	
})

function addTherad(){
	websocket.send("asdas")
	move('增加线路','thread/auThread?lineId='+$lineId+'&lineName='+$lineName);

}



function validateThread(msg,node,url){
	threadFlagThread = "";
		$("#threadMsg").empty();
	$.ajax({
		url:url,
		type:"post",
		data:{
			"coding":$(node).val(),
			"lineId":$lineId
		},
		cache:false,
		success:function(result){
			if(result=="false"){
					var hc = $("#hidThreadCoding").val();
					if (hc!="") {
						if (hc != $("#threadCoding").val()) {
							lineFlagLine = result;
							$("#threadMsg").html("线路编号已被占用");
							$("#threadMsg").css("color", "red");
						}
					}else{
						threadFlagThread = "false";
						$("#threadMsg").html("线路编号已被占用");
						$("#threadMsg").css("color","red");
					}
					
				}
				
		}
	})
}

function smtUpdate($url){
		$.ajax({
			url:"thread/isInspectionTask",
			type:"get",
			cache:false,
			data:{"id":$("#hdThreadId").val()},
			success:function(result){
				if(result=="true"){
					$.messager.confirm('确认','该线路下可能存在正在执行中的巡检任务，强行修改可能引发错误，您确认想要修改该条线路信息吗？',function(r){    
					   if(r){
						   smtThread($url);
					   }
					});  
				}else{
					smtThread($url);
				}
			}
		})
}

function smtThread($url){
	
	$('#threadForm').form('submit', {
		url: $url,
		onSubmit: function(){
			var isValid = $(this).form('validate');
			var reg = new RegExp('^[0-9]+(.[0-9]{1,5})?$'); 
			
				if (!isValid){
					return false;
				}
				if(threadFlagThread=="false"){
					return false;
				}
			    if(!reg.test($("[name='redix']").val())){  
			    	$.messager.alert('提示',"塔基数只能输入1-5位数字!"); 
			    	return false;
			    } 
			    if(!reg.test($("[name='length']").val())){  
			    	$.messager.alert('提示',"路线长度只能输入1-5位数字!"); 
			    	return false;
			    } 
			    if(!reg.test($("[name='returnWay']").val())){  
			    	$.messager.alert('提示',"回路长度只能输入1-5位数字!"); 
			    	return false;
			    } 
			
		},
		success: function(result){
			if(result=="true"){
				move('线路管理','thread/intoThread');
				$.messager.alert('提示','操作成功！');
			}
			
		}
	});
	
}

function updateThread(){
	var thread = $('#thread').datagrid('getSelected');
	if(thread){
		move("修改路线","thread/intoUpdateThread?id="+thread.id);
	}
	
}

function loadThread(){
	$('#thread').datagrid('load',{
		"coding":$("#threadCodingLike").val(),
		"runState":$("#threadStateLike").val(),
		"lineId":$lineId
	})
}


function ableThread(){
	var thread = $('#thread').datagrid('getSelected');
	var flag = "启用";
	if(thread){
		if(thread.stateString=="启用"){
			flag = "禁用";
		}
		temporaryThread('thread/daThread?id='+thread.id+"&state="+thread.state,flag);
	}
    
}


function deleteThread(){
	var thread = $('#thread').datagrid('getSelected');
	temporaryThread('thread/daThread?id='+thread.id+"&state="+-1,'删除');
}

function temporaryThread($url,msg){
	var thread = $('#thread').datagrid('getSelected');
	if(thread){
		$.messager.confirm('确认','要'+msg+'这条线路吗?',function(r){    
			   if(r){
				   useAjax($url,thread.id);
			   }
			}); 
		
	}
}


function useAjax($url,$id){
	$.ajax({
		url:"thread/isInspectionTask",
		type:"get",
		cache:false,
		data:{"id":$id},
		success:function(result){
			if(result=="true"){
				$.messager.alert('警告','该线路下已存在正在执行中的巡检任务，您不能执行此操作！');  
			}else{
				$.ajax({
					url:$url,
					type:"post",
					cache:false,
					success:function(result){
                          if(result=="true"){
                        	  move('线路管理','thread/intoThread');
                        	  $.messager.alert("提示","操作成功！");
                          }
					}
				})
			}
		}
	})
}





