$(function(){
	$("#flawQuery_datagrid").datagrid({
		url : "getAllInspectionFlaw",
		method : "POST",
		width : 1124,
		fitColumns:true,
		/*border:false,//数据长度超出列宽时将会自动截取。*/
		nowrap: false,
		singleSelect:true, //只能选择一行
		rownumbers : true,
		pagination : true,
		pageSize : 5,
		pageList : [ 1, 5, 10, 15, 20 ],
		pageNumber : 1,
		toolbar : '#flawQuery_tool',
		columns : [ [ {
			field : 'id',
			title : '自动编号',
			width : 50,
			checkbox : true,
		}, {
			field : 'taskCoding',
			title : '任务编号',
			width : 60,
			align:"center",
		}, {
			field : 'threadCoding',
			title : '线路编号',
			width : 60,
			align:"center",
		}, {
			field : 'towerCoding',
			title : '杆塔编号',
			width : 60,
			align:"center",
		}, {
			field : 'flawGrade',
			title : '缺陷等级',
			width : 75,
			align:"center",
		}, {
			field : 'flawType',
			title : '缺陷类型',
			width : 75,
			align:"center",
		}, {
			field : 'receipter',
			title : '发现人',
			width : 110,
			align:"center",
		}, {
			field : 'discoverDate',
			title : '发现时间',
			width : 80,
			align:"center"
		} , {
			field : 'creater',
			title : '下发人',
			width : 80,
			align:"center"
		} , {
			field : 'date',
			title : '下发时间',
			width : 80,
			align:"center"
		} , {
			field : 'serviceAbility',
			title : '完好率',
			width : 50,
			align:"center"
		}, {
			field : 'flawDesc',
			title : '缺陷描述',
			width : 120,
			align:"center"
		} ] ],
		emptyMsg : '<h2>无数据</h2>',
		loadFilter : function(data) {
			return data;
		}
	})
	
	$("#inspectionFlawType").combobox({
		valueField : 'id',
		textField : 'name',
		editable : false,// 不可编辑，只能选择
		panelHeight : 'auto',
		//required : true,
	    missingMessage : '请选择缺陷类型',
		url : 'getAllFlaw',
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
	
	$("#inspectionFlawGrade").combobox({
		valueField : 'id',
		textField : 'settingName',
		editable : false,// 不可编辑，只能选择
		panelHeight : 'auto',
		//required : true,
	    missingMessage : '请选择缺陷级别',
		url : 'getFlawGrade',
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
	 * 模糊查询日期验证
	 */
	$('input[name=flawQueryBegin]').datebox({
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
});