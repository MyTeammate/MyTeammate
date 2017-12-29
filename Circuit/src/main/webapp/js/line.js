var lineFlagTower = "";
var lineFlagLine = "";
function line(){

	$('#line').datagrid({    
	    url:'getLineData',    
	    columns:[[    
	        {field:'coding',title:'路线编号',width:200,align:'center'},    
	        {field:'name',title:'路线名称',width:200,align:'center'},    
	        {field:'startTower',title:'起始杆号',width:200,align:'center'},    
	        {field:'endTower',title:'结束杆号',width:200,align:'center'},
	        {field:'redix',title:'塔基数',width:200,align:'center'},
	        {field:'stateString',title:'启用状态',width:200,align:'center'},
	        {field:'operation',title:'操作',width:300,align:'center'}
	        
	        
	    ]],
	    pagination:true,
	    pageList:[1,5,10],
	    pageSize:5,
	    fitColumns:true,
	    toolbar:'#lineTb'



	}); 
	
	$('#lineCoding').textbox({    
		onChange:function(){
		   validateLine("line",this,"checkLineCoding");
	   }       
	})
	
	$('#startTowerLine').combobox({    
		onChange:function(){
				if($('#startTowerLine').val()!=""){
					  validateLine("tower",this,"lineCheckTowerCoding");
					  $('#endTowerLine').combobox({    
						    url:'getTowerDataByCoding?coding='+$('#startTowerLine').val(),    
						    valueField:'coding',    
						    textField:'coding'   
						});
				}
				
			}       
	})
}

function validateLine(msg,node,url){
	lineFlagTower = "";
	lineFlagLine = "";
	if(msg=="line"){
		$("#lineMsg").empty();
	}else{
		$("#lineTowerMsg").empty();
	}
	$.ajax({
		url:url,
		type:"post",
		data:{
			"coding":$(node).val()
		},
		cache:false,
		success:function(result){
			if(result=="false"){
				if(msg=="line"){
					lineFlagLine = result;
					$("#lineMsg").html("路线编号已被占用");
					$("#lineMsg").css("color","red");
				}else{
					lineFlagTower = result;
					$("#lineTowerMsg").html("杆塔编号不存在");
					$("#lineTowerMsg").css("color","red");
				}
				
			}
		}
	})
}
function smtLine(){
	$('#lineForm').form('submit', {
		url: "addLine",
		onSubmit: function(){
			var isValid = $(this).form('validate');
			var reg = new RegExp('^[0-9]+(.[0-9]{1,5})?$'); 
			if (!isValid){
				return false;
			}
			if(lineFlagLine=="false"){
				return false;
			}
			if(lineFlagTower=="false"){
				return false;
			}
			
		    if(!reg.test($("[name='redix']").val())){  
		    	alert($("[name='redix']").val());
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
		success: function(){
			move('路线管理','intoLine');
			
			$.messager.alert('提示','增加成功！');
		}
	});
}

function intoThread (){
	var $line = $('#line').datagrid('getSelected');
	addTabs("线路管理","thread/intoThread")
	thread($line.id);
}

