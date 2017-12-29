var towerFlaf ="";
function tower(){
	closeTower();
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
	    toolbar:'#towerTb'



	});  
}

function addTower(){
	$('#addTower').window('open');  // open a window    
}


function validateTower(node){
	towerFlaf = "";
	$("#towerMsg").empty();
	$.ajax({
		url:"checkTowerCoding",
		type:"post",
		data:{
			"coding":$(node).val()
		},
		cache:false,
		success:function(result){
			if(result=="false"){
				towerFlaf = "false";
				$("#towerMsg").html("杆塔编号已被占用");
				$("#towerMsg").css("color","red");
			}
		}
	})
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
