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
		url:"getInspectionPage",
		method:"POST",
		width:950,
		height:450,
		straiped:true,
		rownumbers:true,
		pagination:true,
		pageSize:5,
		pageList:[1,5,10,15,20],
		pageNumber:1, 
		toolbar:'#makeAllot_tool',
		columns:[[
			    {
			    	field:'sid',
			    	title:'自动编号',
			    	width:50,
			    	checkbox:true,
			    },
			    {
			    	field:'sname',
			    	title:'任务编号',
			    	width:70,
			    },
			    {
			    	field:'stype',
			    	title:'任务名称',
			    	width:120,
			    },	
			    {
			    	field:'sstatus',
			    	title:'巡检线路',
			    	width:80,
			    },
			    {
			    	field:'slastTime',
			    	title:'起始杆号',
			    	width:75,
			    },
			    {
			    	field:'screater',
			    	title:'终止杆号',
			    	width:75,
			    },
			    {
			    	field:'shandler',
			    	title:'下发人',
			    	width:70,
			    },
			    {
			    	field:'sallot',
			    	title:'下发时间',
			    	width:70,
			    },
			    {
			    	field:'sallot',
			    	title:'任务状态',
			    	width:50,
			    },
			    {
			    	field:'sallot',
			    	title:'任务完成时间',
			    	width:70,
			    },
			    {
			    	field:'sallot',
			    	title:'任务是否取消',
			    	width:30,
			    },
			    {
			    	field:'sallot',
			    	title:'操作',
			    	width:150,
			    }
		]],
		emptyMsg:'<h2>无数据</h2>',
		loadFilter:function(data){
			return data;
		} 
		});
	
});