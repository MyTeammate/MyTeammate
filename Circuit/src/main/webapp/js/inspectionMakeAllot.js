/*
 * 巡检管理 >> 巡检任务制定与分配主页
 */

$(function() {

	/*
	 * 模糊查询日期验证
	 */
	$('#inspectionBeginDate').datebox({
		required : true,
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
	 * 工具栏巡检任务状态下拉列表
	 */
	$("#inspectionState").combobox({
		valueField : 'id',
		textField : 'settingName',
		editable : false,// 不可编辑，只能选择
		panelHeight : 'auto',
		url : 'getInspectionParam',
		loadFilter : function(data) {
			var obj = {};
			obj.dataid = '-1';
			obj.datavalue = '--请选择--'
			data.splice(0, 0, obj)// 在数组0位置插入obj,不删除原来的元素
			return data;
		},
		onLoadSuccess : function() {
			var data = $(this).combobox('getData');
			if (data.length > 0) {
				$(this).combobox('select', data[0].datavalue);
			}
		}
	});

	/*
	 * 所有巡检任务
	 */
	$("#makeAllot_datagrid").datagrid({
		url : "getInspectionPage",
		method : "POST",
		width : 980,
		/*
		 *  
		 */
		/*height:450,
		fit:true,
		fitColumns:true,*/
		singleSelect:true, //只能选择一行
		rownumbers : true,
		pagination : true,
		pageSize : 5,
		pageList : [ 1, 5, 10, 15, 20 ],
		pageNumber : 1,
		toolbar : '#makeAllot_tool',
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
			width : 70,
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
				if(value=='待分配'){
					fontColor='#FF9900';
				}else if(value=='已分配'){
					fontColor='#0033FF';
				}else if(value=='执行中'){
					fontColor='#FF33CC'
				}else if(value=='已完成'){
					fontColor='#009900';
				}else if(value=='已取消'){
					fontColor='#EE0000';
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
				if(row.state=='待分配'){
					oper='<span><a href="javascript:lookInspection('+row.id+')" style="text-decoration:none;">查看</a>｜<a href="javascript:allotInspection('+row.id+')" style="text-decoration:none;">分配任务</a>｜<a href="javascript:updateInspection('+row.id+')" style="text-decoration:none;">修改</a>｜<a href="javascript:cancelInspection('+row.id+')" style="text-decoration:none;">取消</a></span>';
				}else if(row.state=='已分配'){
					oper='<span><a href="javascript:lookInspection('+row.id+')" style="text-decoration:none;">查看</a>｜<a style="color:#CDC5BF">分配任务</a>｜<a style="color:#CDC5BF">修改</a>｜<a href="javascript:cancelInspection('+row.id+')" style="text-decoration:none;">取消</a></span>';
				}else{ // if(row.state=='执行中' || row.state=='已完成' || row.state=='已取消')
					oper='<span><a href="javascript:lookInspection('+row.id+')" style="text-decoration:none;">查看</a>｜<a style="color:#CDC5BF">分配任务</a>｜<a style="color:#CDC5BF">修改</a>｜<a style="color:#CDC5BF">取消</a></span>';
				}
				return oper;
			 }
		} ] ],
		emptyMsg : '<h2>无数据</h2>',
		loadFilter : function(data) {
			return data;
		}
	});
});

/*
 * 制定巡检任务
 */
function makeInspection(){
	var tab = $('#tabs').tabs('getSelected');  // 获取选择的面板
	tab.panel('refresh', 'makeInspection');
}

/*
 * 查看巡检任务
 */
function lookInspection(id){
	
}

/*
 * 分配巡检任务
 */
function allotInspection(id){
	
}

/*
 * 修改巡检任务
 */
function updateInspection(id){
	
}

/*
 * 取消巡检任务
 */
function cancelInspection(id){
	
}
