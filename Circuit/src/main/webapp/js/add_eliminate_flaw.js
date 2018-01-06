$(function() {
	$("#add_flaw")
			.datagrid(
					{
						url : "",
						height : 380,
						width : 865,
						pagination : true,
						pageNumber : 1,
						pageSize : 5,
						rownumbers : true,
						pagination : true,
						pageList : [ 5, 10, 15, 20 ],
						columns : [ [
								{
									field : 'id',
									title : '自动编号',
									width : 96,
									checkbox : true
								},
								{
									field : 'threadCoding',
									title : '线路编号',
									width : 96,
									align : 'center'
								},
								{
									field : 'towerCoding',
									title : '杆塔编号',
									width : 96,
									align : 'center'
								},
								{
									field : 'flawGrade',
									title : '缺陷等级',
									width : 96,
									align : 'center'
								},
								{
									field : 'flawType',
									title : '缺陷类型',
									width : 96,
									align : 'center'
								},
								{
									field : 'flawDesc',
									title : '缺陷描述',
									width : 96,
									align : 'center'
								},
								{
									field : 'findUser',
									title : '发现人',
									width : 96,
									align : 'center'
								},
								{
									field : 'findDate',
									title : '发现时间',
									width : 96,
									align : 'center'
								},
								{
									field : 'flag',
									title : '操作',
									width : 96,
									align : 'center',
									formatter : function(value, row, index) {
										var oper = '<span><a style="color:#008B00" href="javaScript:lookInspection('
												+ row.id + ')">移除</a>｜'
										return oper;
									}
								} ] ],
						toolbar : "#smalldiv"
					});
	$("#update_wait_manager").datagrid({
		url : "eliminate/update_manager",
		height : 380,
		width : 865,
		pagination : true,
		pageNumber : 1,
		pageSize : 5,
		rownumbers : true,
		pagination : true,
		pageList : [ 5, 10, 15, 20 ],
		columns : [ [
				{field : 'id',title : '自动编号',width : 96,checkbox : true},
				{field : 'threadCoding',title : '线路编号',width : 96,align : 'center'},
				{field : 'towerCoding',title : '杆塔编号',width : 96,align : 'center'},
				{field : 'flawGrade',title : '缺陷等级',width : 96,align : 'center'},
				{field : 'flawType',title : '缺陷类型',width : 96,align : 'center'},
				{field : 'flawDesc',title : '缺陷描述',width : 96,align : 'center'},
				{field : 'findUser',title : '发现人',width : 96,align : 'center'},
				{field : 'findDate',title : '发现时间',width : 96,align : 'center'},
				{field : 'flag',title : '操作',width : 96,align : 'center',
					formatter : function(value, row, index) {
						var oper = '<span><a style="color:#008B00" href="javaScript:delete_yetid('
								+ row.id + ')">移除</a>｜'
						return oper;
					}
				} ] ],
		toolbar : "#smalldivtwo"
	});
	$('#taskMan').combobox({
		url : 'eliminate/getLineUser',
		valueField : 'id',
		textField : 'name',
		width : 154,
	});

	$('#taskbills').combobox({
		url : 'eliminate/getBills',
		valueField : 'id',
		textField : 'settingName',
		width : 154,
	});

	/*
	 * var t = $("#taskbills").val(); $.ajax({ url : "eliminate/getBills", type :
	 * "post", success : function(data) { $("#taskbills").html(""); var str =
	 * ""; if (data) {
	 * 
	 * for (var i = 0; i < data.length; i++) { str += "<option value='" +
	 * data[i].settingName + "' name='options'>" + data[i].settingName + "</option>"
	 * $('#taskbills').combobox('setValues', data[i].settingName); } }
	 * $("#taskbills").append(str); } })
	 */
	
});
//保存修改
function taskSave_update(){
	var update_taskcoding = $("#update_taskcoding").val();
	var update_taskname = $("#update_taskname").val();
	var taskbills = $("#taskbills").val();
	var taskMan = $("#taskMan").val();
	var update_taskDesc = $("#update_taskDesc").val();
	var update_taskRemark = $("#update_taskRemark").val();
	var taskid = $("#taskid").val();
	var eliminateId = $("#eliminateId").val();
	console.log(update_taskcoding,update_taskname,taskbills,taskMan,update_taskDesc,update_taskRemark,eliminateId);
	$.ajax({
		url:"eliminate/update_task_eliminate",
		type:"post",
		data:{
			update_taskcoding:update_taskcoding,
			update_taskname:update_taskname,
			taskbills:taskbills,
			taskMan,taskMan,
			update_taskDesc:update_taskDesc,
			update_taskRemark:update_taskRemark,
			taskid:taskid
		},
		success:function(data){
			if(data=="true"){
				$.messager.show({
					title : '友好提示您',
					msg : '<h3 style="color: #4876FF;">修改成功!</h3>',
					showType : 'show',
					timeout : 3000,
					width : 260,
					height : 120,
					style : {
						right : '',
						top : document.body.scrollTop
								+ document.documentElement.scrollTop,
						bottom : ''
					}
					
				});
				move("消缺任务制定与分配", "http://localhost:8080/Circuit/eliminate/eliminateflaw");
			}
		}
		
	})
}



//移除选择的缺陷
function delete_yetid(id){
	alert(id);
	$.ajax({
		url:"eliminate/removerecord?id="+id,
		type:"post",
		success:function(data){
			if(data=="true"){
				$.messager.show({
				title : '友好提示您',
				msg : '<h3 style="color: #4876FF;">移除成功!</h3>',
				showType : 'show',
				timeout : 3000,
				width : 260,
				height : 120,
				style : {
					right : '',
					top : document.body.scrollTop
							+ document.documentElement.scrollTop,
					bottom : ''
				}
				
			});
				$('#update_wait_manager').datagrid('reload');
		}else{
			$.messager.show({
				title : '友好提示您',
				msg : '<h3 style="color: #4876FF;">移除失败!</h3>',
				showType : 'show',
				timeout : 3000,
				width : 260,
				height : 120,
				style : {
					right : '',
					top : document.body.scrollTop
							+ document.documentElement.scrollTop,
					bottom : ''
				}
			});
		 }
	  }
	})
}

function save_update() {
	var row = $('#xun_manager').datagrid('getSelections');
	console.log(row);
	var str = "";
	for (var i = 0; i < row.length; i++) {
		str += row[i].id + ",";
	}
	
	$.ajax({
		url:"eliminate/insertIntoRecord",
		data:{
			taskId:$("#taskid").val(),
			str:str
		},
		type:"post",
		success:function(data){
			if(data=="true"){alert('成功了');}
		}
	});
	$("#update_wait_manager").datagrid({
						url : "eliminate/flawConfirmById?str=" + str,
						height : 380,
						width : 865,
						pagination : true,
						pageNumber : 1,
						pageSize : 5,
						rownumbers : true,
						pagination : true,
						pageList : [ 5, 10, 15, 20 ],
						columns : [ [
								{field : 'id',title : '自动编号',width : 96,checkbox : true},
								{field : 'threadCoding',title : '线路编号',width : 96,align : 'center'},
								{field : 'towerCoding',title : '杆塔编号',width : 96,align : 'center'},
								{field : 'flawGrade',title : '缺陷等级',width : 96,align : 'center'},
								{field : 'flawType',title : '缺陷类型',width : 96,align : 'center'},
								{field : 'flawDesc',title : '缺陷描述',width : 96,align : 'center'},
								{field : 'findUser',title : '发现人',width : 96,align : 'center'},
								{field : 'findDate',title : '发现时间',width : 96,align : 'center'},
								{field : 'flag',title : '操作',width : 96,align : 'center',
								formatter : function(value, row, index) {
										var oper = '<span><a style="color:#008B00" href="javaScript:delete_yetid('
												+ row.id + ')">移除</a>｜'
										return oper;
									}
								} ] ],
						toolbar : "#smalldiv"
					});
	$("#xun_div").hide(1000);
}




function save_xun() {
	var row = $('#xun_manager').datagrid('getSelections');
	console.log(row);
	var str = "";
	for (var i = 0; i < row.length; i++) {
		str += row[i].id + ",";
	}
	$("#add_flaw")
			.datagrid(
					{
						url : "eliminate/flawConfirmById?str=" + str,
						height : 380,
						width : 865,
						pagination : true,
						pageNumber : 1,
						pageSize : 5,
						rownumbers : true,
						pagination : true,
						pageList : [ 5, 10, 15, 20 ],
						columns : [ [
								{
									field : 'id',
									title : '自动编号',
									width : 96,
									checkbox : true
								},
								{
									field : 'threadCoding',
									title : '线路编号',
									width : 96,
									align : 'center'
								},
								{
									field : 'towerCoding',
									title : '杆塔编号',
									width : 96,
									align : 'center'
								},
								{
									field : 'flawGrade',
									title : '缺陷等级',
									width : 96,
									align : 'center'
								},
								{
									field : 'flawType',
									title : '缺陷类型',
									width : 96,
									align : 'center'
								},
								{
									field : 'flawDesc',
									title : '缺陷描述',
									width : 96,
									align : 'center'
								},
								{
									field : 'findUser',
									title : '发现人',
									width : 96,
									align : 'center'
								},
								{
									field : 'findDate',
									title : '发现时间',
									width : 96,
									align : 'center'
								},
								{
									field : 'flag',
									title : '操作',
									width : 96,
									align : 'center',
									formatter : function(value, row, index) {
										var oper = '<span><a style="color:#008B00" href="javaScript:delete_yetid('
												+ row.id + ')">移除</a>｜'
										return oper;
									}
								} ] ],
						toolbar : "#smalldiv"
					});
	$("#xun_div").hide(1000);
}
$(function() {
	/*
	 * $("#data_list").datalist({ url:"eliminate/getEliminateUser", checkbox:
	 * true, lines: true,
	 *  })
	 */
	$.ajax({
		url : "eliminate/getEliminateUser",
		type : "post",
		success : function(data) {
			$("#fb_list").html("");
			var str = "";
			if (data) {
				for (var i = 0; i < data.length; i++) {
					str += "<option value='" + data[i].id + "' name='options'>"
							+ data[i].name + "</option>"
				}
			}
			console.log(str);
			$("#fb_list").append(str);
		}
	});
	$("#add").click(
			function() {
				if ($("#fb_list option:selected").length > 0) {
					$("#fb_list option:selected").each(
							function() {
								$("#select_list").append(
										"<option value='" + $(this).val()
												+ "'>" + $(this).text()
												+ "</option");

								$(this).remove();
							})
				} else {
					alert("请选择要添加的数据！");
				}
			});

	$("#delete").click(
			function() {
				if ($("#select_list option:selected").length > 0) {
					$("#select_list option:selected").each(
							function() {
								$("#fb_list").append(
										"<option value='" + $(this).val()
												+ "'>" + $(this).text()
												+ "</option");
								$(this).remove();
							});
					$("#select_user").html("");
				} else {
					alert("请选择要删除的数据！");
				}
			});
})
function save_user() {
	var str = $.map($("#select_list option:not(:selected)"), function(ele) {
		return ele.value
	}).join(",");
	console.log(str);
	$.ajax({
		url : "eliminate/getEliminateUserById?str=" + str,
		type : "post",
		success : function(data) {
			$("#select_user").html("");
			var str = "";
			if (data) {
				console.log(data);
				for (var i = 0; i < data.length; i++) {
					str += "<option value='" + data[i].id + "' name='options'>"
							+ data[i].name + "</option>"
				}
			}

			$("#select_user").append(str);
		}
	});
	$("#bigdiv").hide(1000);
}
function flaw_add_staff() {
	alert(1);
}
function hid() {
	$("#bigdiv").hide(1000);
}
function show() {
	$("#bigdiv").show(1000);
	// $("#bigdiv").attr("style","display:block");
}
function returnto() {
	move("制定消缺任务制定与分配", "http://localhost:8080/Circuit/eliminate/eliminateflaw");
}
/*
 * var t = $("#taskbills").val(); $.ajax({ url:"eliminate/getBills",
 * type:"post", success:function(data){
 * 
 * $("#taskbills").html(""); var str=""; if(data){
 * 
 * for (var i = 0; i < data.length; i++) { str += "<option value='" +
 * data[i].settingName + "' name='options'>" + data[i].settingName + "</option>"
 * $('#taskbills').combobox('setValues',data[i].settingName); } }
 * $("#taskbills").append(str); } })
 */
function add_eliminate() {
	$("#xun_div").show(1000);
	$("#xun_manager").datagrid({
		url : "eliminate/flawConfirm",
		height : 270,
		width : 500,
		pagination : true,
		pageNumber : 1,
		pageSize : 5,
		rownumbers : true,
		pagination : true,
		pageList : [ 5, 10, 15, 20 ],
		columns : [ [ {
			field : 'id',
			title : '自动编号',
			width : 32,
			checkbox : true
		}, {
			field : 'threadCoding',
			title : '线路编号',
			width : 62,
			align : 'center'
		}, {
			field : 'towerCoding',
			title : '杆塔编号',
			width : 62,
			align : 'center'
		}, {
			field : 'flawGrade',
			title : '缺陷等级',
			width : 62,
			align : 'center'
		}, {
			field : 'flawType',
			title : '缺陷类型',
			width : 62,
			align : 'center'
		}, {
			field : 'flawDesc',
			title : '缺陷描述',
			width : 62,
			align : 'center'
		}, {
			field : 'findUser',
			title : '发现人',
			width : 62,
			align : 'center'
		}, {
			field : 'findDate',
			title : '发现时间',
			width : 62,
			align : 'center'
		}, ] ],
	});

}

function xun_hid() {
	$("#xun_div").hide(1000);
}

function taskSave() {
	var taskcoding = $("#taskcoding").val();// 任务编码
	var taskname = $("#taskname").val();// 任务名称
	var taskbills = $("#taskbills").combobox('getText');// 任务单据
	var mid = $("#taskMan").combobox('getValue');// 负责人
	var taskDesc = $("#taskDesc").val();// 任务描述
	var taskRemark = $("#taskRemark").val();// 任务备注
	/*var str = $.map($("#select_user option:not(:selected)"), function(ele) {
		return ele.value
	}).join(",");*/// 已经选择的消缺员id
	var row = $('#add_flaw').datagrid('getSelections');
	var alstr = "";
	for (var i = 0; i < row.length; i++) {
		alstr += row[i].id + ",";
	}
	/*console.log(taskcoding, taskname, taskbills, mid, taskDesc, taskRemark,
			 alstr);*/
	if (taskcoding == "" || taskname == "" || taskbills == ""
			|| taskbills == "请选择" || mid == "请选择" || mid == ""
			|| taskDesc == "" || taskRemark == "" || alstr == "") {
		$.messager.alert({
			title : '警告操作',
			msg : '<h3 style="color: red;">请将资料补充完整!</h3>',
			icon : 'warning',
		})
	} else {
		$.ajax({
			url : "eliminate/insertEliminate",
			type : "post",
			data : {
				taskcoding : taskcoding,
				taskname : taskname,
				taskbills : taskbills,
				mid : mid,
				taskDesc : taskDesc,
				taskRemark : taskRemark,
				/*str : str,*/
				alstr : alstr
			},
			success : function(data) {
				if (data == "true") {
					$.messager.show({
						title : '友好提示您',
						msg : '<h3 style="color: #4876FF;">制定消缺任务成功!</h3>',
						showType : 'show',
						timeout : 3000,
						width : 260,
						height : 120,
						style : {
							right : '',
							top : document.body.scrollTop
									+ document.documentElement.scrollTop,
							bottom : ''
						}
					});
					move("制定消缺任务制定与分配", "http://localhost:8080/Circuit/eliminate/eliminateflaw");
				}
				;

			}
		});
	}
}
