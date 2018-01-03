$(function() {
	$("#flaw_datagrid").datagrid({
		url : 'getflawpage',
		width : 950,
		height : 500,
		// total:5,
		fitColumns : true,
		striped : true,
		rownumbers : true,
		pagination : true,
		pageSize : 2,
		pageList : [ 2, 5, 10, 15, 20 ],
		pageNumber : 2,
		toolbar : "#flaw_tool",
		columns : [ [ {
			field : 'name',
			title : '缺陷类型名称',
			width : 200,
			align: "center",
		},{
			field : 'state',
			title : '状态（启用/未启用）',
			width : 100,
			align: "center",
			formatter:function(value,row){
				var flawstate='';
				if (value=='0') {
					flawstate="启用";
				} else if(value=='1') {
					flawstate="未启用";
				}
				return flawstate;
			}
		},{
			field : 'operate',
			title : '操作',
			width : 200,
			align: "center",
			formatter:function(value,row){
				var oper='';
				if (row.state==0) {
					oper='<span><a href="javascript:lookFlaw('+row.id+')" style="text-decoration:none;">修改</a>｜<a style="color:#CDC5BF">删除</a></span>';
				} else if (row.state==1) {
					oper='<span><a href="javascript:updateInspection('+row.id+')" style="text-decoration:none;">修改</a>｜<a href="javascript:cancelInspection('+row.id+')" style="text-decoration:none;">删除</a></span>';
				}
				return oper;
			}
		}, ] ],
	});
	
	$('#fstateadd').dialog({
		
		width : 230,
		height : 130,
		top : 300,
		title : '添加缺陷类型',
		href : 'fstateadd',
		modal : true,// 后面加一个不可编辑
		closed : true,// 默认情况下是关闭状态
		buttons : [ {
			text : '保存',
			handler : function() {
				if ($('#fstateadd').form('validate')) {
					$.ajax({
						url:"flawadd",
						type :"post",
						data : $('#fstateadd').serialize(),
					});
					// 关闭窗口
					$('#fstateadd').dialog('close').form('reset');
					// 刷新数据表格
					$('#flaw_datagrid').datagrid('reload');
				}
			}
		}, {
			text : '返回',
			handler : function() {
				$('#fstateadd').dialog('close').form('reset');
			}
		} ]
	});
	
	/*
	 * 点击添加缺陷类型
	 * 
	 * */
	flaw_onclick = {
		add : function(){
			$("#fstateadd").dialog('open')
		},
		
	}
	
});

function fladd(){
	$('#fladd').form('submit', {
		url: "addfl",
		onSubmit: function(){
		
			var isValid = $(this).form('validate');
			if (!isValid){
				return false;
			}
			if(towerFlaf=="false"){
				return false;
			}
		},
	});
}

/*
 * 查看缺陷任务
 * */
function lookFlaw(id){
	alert(id);
}




