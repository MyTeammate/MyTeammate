var towerFlaf ="";
function tower(){
	//closeTower();
	$('#tower').datagrid({    
	    url:'http://192.168.16.250:7070/tower/getTowerData',    
	    columns:[[    
	        {field:'coding',title:'杆塔编号',width:200,align:'center'},    
	        {field:'lineName',title:'所属路线',width:200,align:'center'},    
	        {field:'status',title:'状态（启用/停用）',width:200,align:'center'},    
	        {field:'operation',title:'操作',width:200,align:'center'}
	    ]],
	    pagination:true,
	    pageList:[1,5,10],
	    pageSize:5,
	    fitColumns:true,
	    toolbar:'#towerTb',
	    singleSelect:true



	});  
}

function addTower(){
	$("#towerCodingHd").val("");
	$('#addTower').window('open');  // open a window    
}


function validateTower(node,msg){
	towerFlaf = "";
	$("#towerMsg").empty();
	$("#towerUpdateMsg").empty();
	$.ajax({
		url:"checkTowerCoding",
		type:"post",
		data:{
			"coding":$(node).val()
		},
		cache:false,
		success:function(result){
			if(result=="false"){
				alert($("#towerCodingHd").val())
				if($("#towerCodingHd").val()!=""){
					alert($(node).val())
					if($(node).val()!=$("#towerCodingHd").val()){
						towerFlaf = "false";
						if(msg=="update"){
							$("#towerUpdateMsg").html("杆塔编号已被占用");
							$("#towerUpdateMsg").css("color","red");
						}else{
							$("#towerMsg").html("杆塔编号已被占用");
							$("#towerMsg").css("color","red");
						}
					}
				}else{
					towerFlaf = "false";
					$("#towerMsg").html("杆塔编号已被占用");
					$("#towerMsg").css("color","red");
				}
				
			}
		}
	})
}

function smtUpdateTower(){
	/*$.ajax({
		url:"isLineId",
		type:"get",
		cache:false,
		data:{"id":$("#towerIdHd").val()},
		success:function(result){
			
		}
	});*/
	var tower = $("#tower").datagrid("getSelected");
	if(!tower.lineId){
		$.messager.alert('警告','该杆塔已属于某一条路线，您不能执行此操作！');  
	}else{
		$('#towerUpdateForm').form('submit', {
			url: "updateTower",
			onSubmit: function(){
				var isValid = $(this).form('validate');
				if (!isValid){
					return false;
				}
				if(towerFlaf=="false"){
					return false;
				}
			},
			success: function(){
				move('杆塔管理','intoTower');			
				$.messager.alert('提示','修改成功！');
				closeTowerUpdate();
				
			}
		});
	}
}

function smtTower() {
		
	
	$('#towerForm').form('submit', {
		url: "addTower",
		onSubmit: function(){
			var isValid = $(this).form('validate');
			if (!isValid){
				return false;
			}
			if(towerFlaf=="false"){
				return false;
			}
		},
		success: function(){
			move('杆塔管理','intoTower');			
			$.messager.alert('提示','增加成功！');
			closeTower();
			
		}
	});

}

function closeTower(){
	$('#addTower').window('close');
}

function closeTowerUpdate(){
	$('#updateTower').window('close');
}


function updateTower(){
	var tower = $("#tower").datagrid("getSelected");
	console.log(tower)
	if(tower){
		$.ajax({
			url:"isLineId",
			type:"get",
			cache:false,
			data:{"id":tower.id},
			success:function(result){
				if(result=="false"){
					$.messager.alert('警告','该杆塔已属于某一条路线，您不能执行修改操作！');  
				}else{
					$("#towerUpdateCoding").val(tower.coding);
					$("#towerCodingHd").val(tower.coding);
					$("#towerIdHd").val(tower.id)
					$("#updateTower").dialog('setTitle','修改杆塔');
					$('#updateTower').window('open');
					$(".towerAble").each(function(i,e){
						if(tower.state==$(e).val()){
							e.checked=true;
						}
					})
				}
			}
		});
		
	}
	
}

function isStartOrEndTower($url,msg){
	var tower = $("#tower").datagrid("getSelected");
	$.messager.confirm('确认','要'+msg+'这个杆塔吗?',function(r){    
		   if(r){
				if(tower.lineId){
					$.ajax({
						url:"isStartOrEndTower",
						type:"post",
						cache:false,
						data:{
							"id":tower.id,
							"coding":tower.coding,
							"lineId":tower.lineId,
							"state":tower.state,
						   },
						success:function(result){
							if(result=="false"){
								$.messager.alert(msg+'失败','该杆塔已作为一条路线的起始杆塔或终止杆塔，您暂时不能执行此操作！');  
							}else{
								adTower($url);
							}
						}
						
					})
				}else{
					adTower($url);
				}
		   }
	}); 
	
}

function adTower($url){
	$.ajax({
		url:$url,
		type:"post",
		cache:false,
		success:function(result){
			if(result=="true"){
				$.messager.alert('提示','操作成功！');  
				move('杆塔管理',"intoTower");
			}
		}
		
	})
}




function ableTower(){
	var tower = $("#tower").datagrid("getSelected");
	var flag ="禁用";
	var state = 1;
	if(tower){
		
		if(tower.state==1){
			flag = "启用";
			state = 0;
		}
		isStartOrEndTower("adTower?id="+tower.id+"&state="+state,flag)
	}
}

function deleteTower(){
	var tower = $("#tower").datagrid("getSelected");
	if(tower){
		isStartOrEndTower("adTower?id="+tower.id+"&state="+-1,"删除")
	}
}


function loadTower(){
	$('#tower').datagrid('load',{
		"lineId":$("#towerLineLike").val(),
		"status":$("#towerStateLike").val(),
	})
}
