var lineFlagTower = "";
var lineFlagLine = "";
function line() {

	$('#line').datagrid({
		url : 'getLineData',
		columns : [ [ {
			field : 'coding',
			title : '路线编号',
			width : 200,
			align : 'center'
		}, {
			field : 'name',
			title : '路线名称',
			width : 200,
			align : 'center'
		}, {
			field : 'startTower',
			title : '起始杆号',
			width : 200,
			align : 'center'
		}, {
			field : 'endTower',
			title : '结束杆号',
			width : 200,
			align : 'center'
		}, {
			field : 'redix',
			title : '塔基数',
			width : 200,
			align : 'center'
		}, {
			field : 'stateString',
			title : '启用状态',
			width : 200,
			align : 'center'
		}, {
			field : 'operation',
			title : '操作',
			width : 300,
			align : 'center'
		}

		] ],
		pagination : true,
		pageList : [ 1, 5, 10 ],
		pageSize : 5,
		fitColumns : true,
		singleSelect:true,
		toolbar : '#lineTb'

	});

	$('#lineCoding').textbox({
		onChange : function() {
			validateLine("line", this, "checkLineCoding");
		}
	})

	$('#startTowerLine').combobox(
			{
				onChange : function() {
					if ($(this).val() != "") {
						validateLine("tower", this, "lineCheckTowerCoding");
						$('#endTowerLine').combobox(
								{
									value:'',
									url : 'getAllTowerData?coding='
											+ $('#startTowerLine').val(),
									valueField : 'coding',
									textField : 'coding'
								});

					}

				}
			})
}

function validateLine(msg, node, url) {
	lineFlagTower = "";
	lineFlagLine = "";
	if (msg == "line") {
		$("#lineMsg").empty();
	} else {
		$("#lineTowerMsg").empty();
	}
	$.ajax({
		url : url,
		type : "post",
		data : {
			"coding" : $(node).val()
		},
		cache : false,
		success : function(result) {
			if (result == "false") {
				if (msg == "line") {
					var hc = $("#HidlineCoding").val();
					if (hc!="") {
						if (hc != $("#lineCoding").val()) {
							lineFlagLine = result;
							$("#lineMsg").html("路线编号已被占用");
							$("#lineMsg").css("color", "red");
						}
					}else{
						lineFlagLine = result;
						$("#lineMsg").html("路线编号已被占用");
						$("#lineMsg").css("color", "red");
					}
				} else {
					lineFlagTower = result;
					$("#lineTowerMsg").html("杆塔编号不存在");
					$("#lineTowerMsg").css("color", "red");
				}

			}
		}
	})
}
function smtLine($url) {
	$('#lineForm').form('submit', {
		url : $url,
		onSubmit : function() {
			var isValid = $(this).form('validate');
			var reg = new RegExp('^[0-9]+(.[0-9]{1,5})?$');
			if (!isValid) {
				return false;
			}
			if (lineFlagLine == "false") {
				return false;
			}
			if (lineFlagTower == "false") {
				return false;
			}
			var $startTower = $("#startTowerLine").val();
			var $endTower = $("#endTowerLine").val();
			if($startTower==$endTower){
				$.messager.alert('警告', "起始杆塔不能和终止杆塔一致！");
				return false;
			}

			if (!reg.test($("[name='redix']").val())) {
				$.messager.alert('警告', "塔基数只能输入1-5位数字!");
				return false;
			}
			if (!reg.test($("[name='length']").val())) {
				$.messager.alert('警告', "路线长度只能输入1-5位数字!");
				return false;
			}
			if (!reg.test($("[name='returnWay']").val())) {
				$.messager.alert('警告', "回路长度只能输入1-5位数字!");
				return false;
			}
		},
		success : function(result) {
			if(result=="true"){
				move('路线管理', 'intoLine');

				$.messager.alert('提示', '操作成功！');
			}
			
		}
	});
}

function intoThread() {
	var $line = $('#line').datagrid('getSelected');
	move("线路管理", "thread/intoThread")
	console.log($line)
	thread($line.id, $line.name);
}

function updateLine() {
	var line = $('#line').datagrid('getSelected');
	if (line) {
		move('修改路线', 'intoUpdateLine?id=' + line.id);
	}

}

function loadLine(){
	$('#line').datagrid('load',{
		"status":$("#lineStateLike").val()
	})
}


function ableLine(){
	var line = $('#line').datagrid('getSelected');
	var flag = "禁用";
	if(line){
		if(line.stateString=="禁用"){
			flag = "启用";
		}
		temporaryLine("adLine?id="+line.id+"&state="+line.state,line.id,flag)
	}
}

function deleteLine(){
	var line = $('#line').datagrid('getSelected');
	if(line){
		temporaryLine("adLine?id="+line.id+"&state="+-1,line.id,'删除')
	}
	
}


function temporaryLine($url,$id,msg){
		$.messager.confirm('确认','要'+msg+'这条线路吗?',function(r){    
			   if(r){
				   useAjaxLine($url,$id);
			   }
			}); 
}


function useAjaxLine($url,$id){
	$.ajax({
		url:"isThread",
		type:"get",
		cache:false,
		data:{"lineId":$id},
		success:function(result){
			if(result=="true"){
				$.messager.alert('警告','检测到该路线下还存在线路，您不能执行此操作！');  
			}else{
				$.ajax({
					url:$url,
					type:"post",
					cache:false,
					success:function(result){
                          if(result=="true"){
                        	  move('路线管理','intoLine');
                        	  $.messager.alert("提示","操作成功！");
                          }
					}
				})
			}
		}
	})
}

