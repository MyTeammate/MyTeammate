$(function() {
	$("#flawCon_datagrid").datagrid({
		url : 'getFlawConfirmPager',
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
		toolbar : "#flawCon_tool",
		columns : [ [ {
			field : 'id',
			checkbox : true
		}, {
			field : 'taskcoding',
			title : '任务编号',
			width : 75,
			align: "center",
		}, {
			field : 'threadcoding',
			title : '线路编号',
			width : 80,
			align: "center",
		}, {
			field : 'towercoding',
			title : '杆塔编号',
			width : 90,
			align: "center",
		}, {
			field : 'flawname',
			title : '缺陷类型',
			width : 100,
			align: "center",
		}, {
			field : 'serviceAbility',
			title : '完好率',
			width : 75,
			align: "center",
		},{
			field : 'flawDesc',
			title : '缺陷描述',
			width : 100,
			align: "center",
		},{
			field : 'discoverDate',
			title : '发现时间',
			width : 90,
			align: "center",
		},{
			field : 'userId',
			title : '发现人员',
			width : 100,
			align: "center",
		},{
			field : 'flawGrade',
			title : '缺陷级别',
			width : 100,
			align: "center",
		},{
			field : 'operate',
			title : '操作',
			width : 95,
			align: "center",
			//hidden : true,
			formatter : function (value, row){
				 return  '<span><a href="javascript:updateFconfirm('+row.id+')" style="text-decoration:none;">级别确认</a></span>';
			}
		}, ] ],
	});
	
	$("#GradeId").combobox({
		valueField : 'id',
		textField : 'settingName',
		editable : false,// 不可编辑，只能选择
		panelHeight : 'auto',
		required : true,
	    missingMessage : '请选择缺陷级别',
		url : 'getFlawGrade',
	});
	
	$('#updateflawconfirm').dialog({
		width : 300,
		height : 120,
		top : 300,
		title : '缺陷等级确认',
		modal : true,// 后面加一个不可编辑
		closed : true,// 默认情况下是关闭状态
		buttons : [ {
			text : '保存',
			handler : function() {
				if ($('#updateflawconfirm').form('validate')) {
					//alert($('#updateflawconfirm').serialize());
					$.ajax({
						url : 'updatefla',
						type : "POST",
						data :$('#updateflawconfirm').serialize(),
						success:function(result){
							if(result==true){
								 $.messager.show({
										title:'提示',
										msg:'缺陷等级确认成功',
										timeout:100,
										showType:"slide",
										style:{
										}
									});
							}
						}
					});
					// 关闭窗口
					$('#updateflawconfirm').dialog('close').form('reset');
					// 刷新数据表格
					$('#flawCon_datagrid').datagrid('reload');
				}
			}
		}, {
			text : '返回',
			handler : function() {
				$('#updateflawconfirm').dialog('close').form('reset');
			}
		} ]
	})
	
	$('#plasttime').combobox({
		url : 'eliminatequery/selFlawPost',
		valueField : 'id',
		textField : 'name',
		width : 130,
	});
	
});

function lookflawconfirmiid(id){
	//alert(id);
}

//修改缺陷类型
function updateFconfirm(id) {
//	var select = $("#flawCon_datagrid").datagrid("getSelected");
//	alert(select.id);
	//console.log(select)
	
	$.ajax({
				url : "lookflawconfirm",
				type : "post",
				data : {id:id},
				success : function(result) {
					//console.log(result);
				},
				complete : function(XMLHttpRequest, textStatus) {
					if (XMLHttpRequest.readyState == 4
							&& XMLHttpRequest.status == 200) {
						var result = JSON.parse(XMLHttpRequest.responseText);
						$('#updateflawconfirm').form('load', {
							id : result.id,
							flawGrade : result.flawGrade,
						}).dialog('open');
					}
				}
			});
}

//模糊查询
function flawConf(){	
	$('#flawCon_datagrid').datagrid('reload', {
		rencoding : $("#rencoding").val(),
		xlconding : $("#xlconding").val(),
		gtcoding : $("#gtcoding").val(),
		fxperson : $("#fxperson").val(),
		plasttime : $("#plasttime").combobox('getText'),
		discoverDate : $("#discoverDate").val(),
		endtime : $("#endtime").val()		
	});

}