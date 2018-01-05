$(function(){
	/*
	 * 模糊查询日期验证
	 */
	$('#inspectionBeginDate').datebox({
		//required : true,
		editable : false,
		validType : 'checkNow',
		missingMessage : '请选择日期',
	});
	$.extend($.fn.validatebox.defaults.rules, {
		checkNow : {
			validator : function(value, param) {
				var now = new Date();
				var date = $.fn.datebox.defaults.parser(value);
				return now >= date;
			},
			message : '所选时间不能超过当前时间！'
		},
		md : {
			validator : function(value, param) {
				var start = $(param[0]).datetimebox('getValue');
				var now = new Date();
				var start2 = $.fn.datebox.defaults.parser(value);
				return now >= start2 && start <= value;
				// 需要进行两个判断，先判断不能超过当前时间，再判断是否大于开始时间
			},
			message : '选择有误！'
		}
	});
	
	/*
	 * 所有巡检任务
	 */
	$("#executeReceipt_datagrid").datagrid({
		url : "getInspectionPage",
		method : "POST",
		queryParams: {          
	          operate: 'execute'            
	    },
		width : 980,
		/*
		 *  
		 */
		/*height:450,
		fit:true,*/
		fitColumns:true,
		singleSelect:true, //只能选择一行
		rownumbers : true,
		pagination : true,
		pageSize : 5,
		pageList : [ 1, 5, 10, 15, 20 ],
		pageNumber : 1,
		toolbar : '#executeReceipt_tool',
		columns : [ [ {
			field : 'id',
			title : '自动编号',
			width : 50,
			checkbox : true,
		}, {
			field : 'coding',
			title : '任务编号',
			width : 80,
			align:"center",
		}, {
			field : 'name',
			title : '任务名称',
			width : 120,
			align:"center",
		}, {
			field : 'thread',
			title : '巡检线路',
			width : 80,
			align:"center",
		}, {
			field : 'startTower',
			title : '起始杆号',
			width : 75,
			align:"center",
		}, {
			field : 'endTower',
			title : '终止杆号',
			width : 75,
			align:"center",
		}, {
			field : 'creater',
			title : '下发人',
			width : 110,
			align:"center",
		}, {
			field : 'createDate',
			title : '下发时间',
			width : 80,
			align:"center",
		}, {
			field : 'state',
			title : '任务状态',
			width : 55,
			align:"center",
			formatter:function(value,row,index){
				var fontColor='';
				if(value=='已分配'){
					fontColor='#0033FF';
				}else if(value=='执行中'){
					fontColor='#FF33CC'
				}else if(value=='已完成'){
					fontColor='#009900';
				}
				return  '<span style="color:'+fontColor+'">'+value+'</span>';
			 }
		}, {
			field : 'actualDate',
			title : '任务完成时间',
			width : 90,
			align:"center",
		}, {
			field : 'operate',
			title : '操作',
			width : 180,
			align:"center",
			formatter:function(value,row,index){
				var oper='';
				if(row.state=='已分配'){
					oper='<span><a href="javascript:lookInspection('+row.id+')" style="text-decoration:none;">查看</a>｜<a style="color:#CDC5BF">回执录入</a>｜<a href="javascript:executeInspection('+row.id+')" style="text-decoration:none;">执行</a>｜<a style="color:#CDC5BF">修改</a></span>';
				}else if(row.state=='执行中'){
					oper='<span><a href="javascript:lookInspection('+row.id+')" style="text-decoration:none;">查看</a>｜<a href="javascript:receiptInspection('+row.id+')" style="text-decoration:none;">回执录入</a>｜<a style="color:#CDC5BF;">执行</a>｜<a href="javascript:cancelInspection('+row.id+')" style="text-decoration:none;">修改</a></span>';
				}else{ // 已完成
					oper='<span><a href="javascript:lookInspection('+row.id+')" style="text-decoration:none;">查看</a>｜<a style="color:#CDC5BF">回执录入</a>｜<a style="color:#CDC5BF">执行</a>｜<a style="color:#CDC5BF">修改</a></span>';
				}
				return oper;
			 }
		} ] ],
		emptyMsg : '<h2>无数据</h2>',
		loadFilter : function(data) {
			return data;
		}
	});
	
	/*
	 * 模糊查询
	 */
	inspection_onclick={
			search:function(){
				var startDate = $('#inspectionBeginDate').datebox('isValid');
				var endDate = $('#inspectionEndDate').datebox('isValid');
				if(startDate && endDate){
					$("#executeReceipt_datagrid").datagrid('reload', {
						operate:'execute',
						coding : $("#inspectionCoding").val(),
						thread : $("#threadCoding").val(),
						state : $("#inspectionState").combobox('getValue'),
						creater : $("#taskCreater").val(),
						startDate : $("#inspectionBeginDate").val(),
						endDate : $("#inspectionEndDate").val()
					});
				}else{
					console.log('日期验证不通过！');
				}
			}
	}
})

var receipterFlag='';
function checkInspectionReceipter(id){
	
}

/*
 * 执行 巡检任务
 */
function executeInspection(id){
	
	$.ajax({
		url:"checkInspectionReceipter",
		type:"POST",
		data:{
			taskId:id
		},
		success:function(result){
			if(result == true){
				$.messager.confirm('确定','您确定要执行所选的巡检任务吗？',function(f){
					if(f){
						$.ajax({
							url : "executeInspection",
							type : "post",
							data:{
								taskId:id
							},
							success:function(result){
								if(result){
									 $.messager.show({
										title:'提示',
										msg:'执行成功',
										timeout:500,
										showType:"fade",
										style:{
										}
									});
								}else{
									$.messager.alert({
										title:'执行失败',
										msg:'<h3 style="color: red;">未知错误导致失败，请重试！</h3>',
										icon:'warning',
									})
								}
								//刷新数据表格
								$('#executeReceipt_datagrid').datagrid('reload');
							}
						})
					}
				});
			}else{
				$.messager.alert({
					title:'执行失败',
					msg:'<h3 style="color: red;">权限不够，需要权限：负责人！</h3>',
					icon:'warning',
				})
			}
		}
	})
}

/*
 * 点击  回执录入  操作
 */
function receiptInspection(id){
	$.ajax({
		url:"checkInspectionReceipter",
		type:"POST",
		data:{
			taskId:id
		},
		success:function(result){
			if(result == true){
				move('巡检任务回执录入','receiptInspection?taskId='+id);
			}else{
				$.messager.alert({
					title:'回执录入失败',
					msg:'<h3 style="color: red;">权限不够，需要权限：负责人！</h3>',
					icon:'warning',
				})
			}
		},
	})
	
}
