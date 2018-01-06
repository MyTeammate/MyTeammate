var checkMenuText = "";
function roleDistribution(){
	$('#roleConfigTree').tree({    
	    url:'power/getNavs',
	    checkbox:true,
	    cascadeCheck:false,
	    onLoadSuccess:function(node, data){
	    		if (data) {
					$(data).each(function(index, value) {	
						 if (this.state == "closed") {
							$("#roleConfigTree").tree("expandAll");
						} 
					});
				}
	    } 
	}); 
	
	$("#powerMenuText").textbox({
		onChange:function(newValue, oldValue){
			validatorMenu($("#parentNodeIdHd").val(),newValue)
		}
	});
	
	$("#powerMenuUpdateText").change(function (){
		validatorMenu($("#powerMenuUpdateNodeNidHd").val(),$("#powerMenuUpdateText").val())
	});
	
	$("#roleConfigCombo").combobox({    
		onChange:function(newValue,oldValue){
			 var checks = $("#roleConfigTree").tree("getChecked");  
			 for(var i=0;i<checks.length;i++){
				 var node = $("#roleConfigTree").tree('find',checks[i].id);
				 $("#roleConfigTree").tree("uncheck", node.target);  
			 }
		        
			$.ajax({
	    		url : "power/getRolePowers",
	    		type : "get",
	    		data : {
	    			"roleId" :newValue
	    		},
	    		cache : false,
	    		success : function(result) {
	    			if(result.length>0){
	    				for(var i=0;i<result.length;i++){
	    					var node = $("#roleConfigTree").tree('find',result[i].id);
	    					$("#roleConfigTree").tree('check',node.target);
	    				}
	    			}
	    			
	    		}
	    	})
		}   
	}); 
}

function addPowerMenu(){
	 cancelUpdateMenu();
	$("#menuForm").form('reset');
	$("#menuTextMsg").empty();
	var checkeds = $('#roleConfigTree').tree('getChecked');
		if(checkeds.length>0){
			if(checkeds.length==1){
				var parent = $('#roleConfigTree').tree('find', checkeds[0].nid);
				if(checkeds[0].text=="系统设置"||parent.text=="系统设置"){
					$.messager.alert("警告","不能对系统设置模块及其子模块进行操作！");
				}else{
					$("#addPowerMenu").show();
					$("#parentNode").html(checkeds[0].text);
					$("#parentNodeIdHd").val(checkeds[0].id);
				}
			}else{
				$.messager.alert("警告","请在勾选一个节点的情况下执行增加节点的操作！");
			}
		}else{
			$("#addPowerMenu").show();
			var roots = $('#roleConfigTree').tree('getRoots');
			$("#parentNode").html(roots[0].text);
			$("#parentNodeIdHd").val(roots[0].id);
			
		}
	
}


function updatePowerMenu(){
	
	 cancelAddMenu();
	$("#menuUpdateForm").form('reset');
	$("#menuTextMsg").empty();
	var checkeds = $('#roleConfigTree').tree('getChecked');
	
	
		if(checkeds.length==1){
			var parent = $('#roleConfigTree').tree('find', checkeds[0].nid);
			if(checkeds[0].text=="系统设置"||parent.text=="系统设置"){
				$.messager.alert("警告","不能对系统设置模块及其子模块进行操作！");
			}else{
				
			$("#updatePowerMenu").show();	
			    $("#powerMenuUpdateNodeIdHd").val(checkeds[0].id);
			    $("#powerMenuUpdateNodeNidHd").val(checkeds[0].nid)
				$("#powerMenuUpdateNode").html(checkeds[0].text);
			    $("#powerMenuUpdateText").val(checkeds[0].text)
				$("#powerMenuUpdateTextHd").val(checkeds[0].text);
			    $("#powerMenuUpdateUrl").val(checkeds[0].url)
				
				$.ajax({
					url : "power/getPowerMenuById",
					type : "get",
					data : {
						"id" : checkeds[0].id,
					},
					cache : false,
					success:function(result){
						if(result){
							$(".openOrClosed").each(function(i,e){
								if(result.state==$(e).val()){
									e.checked=true;
								}
							})
							$(".menuPowerAble").each(function(i,e){
								if(result.status==$(e).val()){
									e.checked=true;
								}
				            })
						}
					}
				})
				
			}
			
		}else{
			$.messager.alert("警告","请在勾选一个节点的情况下执行修改节点的操作！");
		}
	
	
}

function validatorMenu(nid,value){
	checkMenuText = "";
	$("#menuTextMsg").empty();
	$("#menuUpdateTextMsg").empty();
	$.ajax({
		url : "power/checkMenuText",
		type : "post",
		data : {
			"text" : value,
			"nid" :nid
		},
		cache : false,
		success : function(result) {
			if (result == "false") {
				var hd =  $("#powerMenuUpdateTextHd").val();
				alert(hd)
				if(hd!=""){
					if(hd!=value){
						checkMenuText = "false";
						$("#menuUpdateTextMsg").html("该功能名称已存在");
						$("#menuUpdateTextMsg").css("color", "red");
					}
				}else{
					checkMenuText = "false";
					$("#menuTextMsg").html("该功能名称已存在");
					$("#menuTextMsg").css("color", "red");
				}
			}
		}
	})
}

function smtAddMenu($url){
	smtMenu($url,$("#menuForm"))
}

function smtUpdateMenu($url){  
	$.messager.confirm('确认','修改后可能会引发系统错误，您确认想要该功能吗？',function(r){    
	    if (r){    
	    	smtMenu($url,$("#menuUpdateForm")); 
	    }    
	});
	
}

function deletePowerMenu(){
	var checkeds = $('#roleConfigTree').tree('getChecked');
		if(checkeds.length==1){
			var parent = $('#roleConfigTree').tree('find', checkeds[0].nid);
			if(checkeds[0].text=="系统设置"||parent.text=="系统设置"){
				$.messager.alert("警告","不能对系统设置模块及其子模块进行操作！");
			}else{
				$.messager.confirm('确认','删除后可能会引发系统错误，您确认想要删除该功能吗？',function(r){    
				    if (r){    
				    	$.ajax({
				    		url : "power/deletePowerManu",
				    		type : "post",
				    		data : {
				    			"id" :checkeds[0].id
				    		},
				    		cache : false,
				    		success : function(result) {
				    			if(result=="true"){
				    				move('角色权限配置', 'power/intoRoleDistribution');
				    				$.messager.alert("提示","操作成功！");
				    			}
				    		}
				    	})
				    }    
				});
			}
		}else{
			$.messager.alert("警告","请在勾选一个节点的情况下执行增加节点的操作！");
		}
	
}

function smtMenu($url,$node){
	$node.form('submit', {
	url : $url,
	onSubmit : function() {
		var isValid = $(this).form('validate');
		var re = /[\u4E00-\u9FA5\uF900-\uFA2D]/; 
		if (!isValid) {
			return false;
		}
		if(checkMenuText=="false"){
			return false;
		}
		if (re.test($("[name='url']").val())) {
			$.messager.alert('警告', "功能URL不合法！");
			return false;
		}
		
	},
	success : function(result) {
		if(result=="true"){
			move('角色权限配置', 'power/intoRoleDistribution');
			$.messager.alert('提示', '操作成功！');
		}
		
	}
});
}

function cancelAddMenu(){
	$("#addPowerMenu").hide();
}

function cancelUpdateMenu(){
	$("#updatePowerMenu").hide();
}


function saveSetting(){
	var checkeds = $('#roleConfigTree').tree('getChecked');
	if(checkeds.length>0){
		var roleId = $("#roleConfigCombo").val();
		if(roleId!='---请选择角色---'){
			var ids = ""; 
			for(var i=0;i<checkeds.length;i++){
				if(i==checkeds.length-1){
					ids+=checkeds[i].id;
				}else{
					ids+=checkeds[i].id+",";
				}
			}
			$.ajax({
				url : "power/authorization",
	    		type : "post",
	    		data : {
	    			"roleId" :roleId,
	    			"ids":ids
	    		},
	    		cache : false,
	    		success : function(result) {
	    			if(result=="true"){
	    				$.messager.alert('提示', '保存成功！');
	    			}
	    		}
			})
		}else{
			$.messager.alert('警告', '请先选择角色！');
		}
	}else{
		$.messager.alert('警告', '您还未勾选任务权限菜单！');
	}
}

