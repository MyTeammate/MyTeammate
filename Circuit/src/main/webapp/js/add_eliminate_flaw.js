$(function() {
	$("#add_flaw").datagrid({
		url : "",
		height : 380,
		width : 865,
		pagination : true,
		pageNumber : 1,
		pageSize : 5,
		rownumbers : true,
		pagination : true,
		pageList : [ 5, 10, 15, 20 ],
		columns : [ [{field : 'id',title : '自动编号',width : 82,checkbox : true},
			{field : 'taskcoding',title : '线路编号',width : 82,align : 'center'},
			{field : 'taskName',title : '杆塔编号',width : 82,align : 'center'},
			{field : 'workBills',title : '缺陷等级',width : 82,align : 'center'},
			{field : 'xiafaMan',title : '缺陷类型',width : 92,align : 'center'},
			{field : 'xiafaDate',title : '缺陷描述',width : 82,align : 'center'},
			{field : 'taskStatus',title : '发现人',width : 82,align : 'center'},
            {field : 'wancdate',title : '发现时间',width : 82,align : 'center'},
            {field : 'flag',title : '操作',width : 82,align : 'center',
             formatter:function(value,row,index){
				var oper='<span><a style="color:#008B00" href="javaScript:lookInspection('+row.id+')">移除</a>｜'
				return  oper;
			 }}
            ] ],
		toolbar : "#smalldiv"
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
	
	/*var t = $("#taskbills").val();
	$.ajax({
		url : "eliminate/getBills",
		type : "post",
		success : function(data) {
			$("#taskbills").html("");
			var str = "";
			if (data) {

				for (var i = 0; i < data.length; i++) {
					str += "<option value='" + data[i].settingName
							+ "' name='options'>" + data[i].settingName
							+ "</option>"
					$('#taskbills').combobox('setValues', data[i].settingName);
				}
			}
			$("#taskbills").append(str);
		}
	})*/
	
});
$(function(){
	/*$("#data_list").datalist({
		url:"eliminate/getEliminateUser",
		checkbox: true, 
	    lines: true,
	    
	})*/
		 $.ajax({
				url : "eliminate/getEliminateUser",
				type : "post",
				success : function(data) {
					$("#fb_list").html("");
					var str = "";
					if (data) {
						for (var i = 0; i < data.length; i++) {
							str += "<option value='" + data[i].id
									+ "' name='options'>" + data[i].name
									+ "</option>"
						}
					}
					console.log(str);
					$("#fb_list").append(str);
				}
			});
		 $("#add").click(function(){
			  if($("#fb_list option:selected").length>0) {
			   $("#fb_list option:selected").each(function(){
			    $("#select_list").append("<option value='"+$(this).val()+"'>"+$(this).text()+"</option");
			    
			    $(this).remove();
			   })
			  }else {
			   alert("请选择要添加的数据！");
			  }
			 });
			 
			 $("#delete").click(function() {
			   if($("#select_list option:selected").length>0) {
			    $("#select_list option:selected").each(function(){
			     $("#fb_list").append("<option value='"+$(this).val()+"'>"+$(this).text()+"</option");
			      $(this).remove();
			    })
			   }else {
			    alert("请选择要删除的数据！");
			   }
			 });
})
function save_user(){
	 var str = $.map($("#select_list option:not(:selected)"),
             function(ele){return ele.value} 
          ).join(",");
	 console.log(str);
	 $.ajax({
			url : "eliminate/getEliminateUserById?str="+str,
			type : "post",
			success : function(data) {
				$("#select_user").html("");
				var str = "";
				if (data) {
					console.log(data);
					for (var i = 0; i < data.length; i++) {
						str += "<option value='" + data[i].id
								+ "' name='options'>" + data[i].name
								+ "</option>"
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
function add_eliminate(){
	$("#xun_div").show(1000);
	$("#xun_manager").datagrid({
		url : "",
		height : 270,
		width : 500,
		pagination : true,
		pageNumber : 1,
		pageSize : 5,
		rownumbers : true,
		pagination : true,
		pageList : [ 5, 10, 15, 20 ],
		columns : [ [{field : 'id',title : '自动编号',width : 32,checkbox : true},
			{field : 'taskcoding',title : '线路编号',width : 62,align : 'center'},
			{field : 'taskName',title : '杆塔编号',width : 62,align : 'center'},
			{field : 'workBills',title : '缺陷等级',width : 62,align : 'center'},
			{field : 'xiafaMan',title : '缺陷类型',width : 62,align : 'center'},
			{field : 'xiafaDate',title : '缺陷描述',width : 62,align : 'center'},
			{field : 'taskStatus',title : '发现人',width : 62,align : 'center'},
            {field : 'wancdate',title : '发现时间',width : 62,align : 'center'},
            ] ],	
	});
	
}

function xun_hid(){
	$("#xun_div").hide(1000);
}

function taskSave() {
	var taskcoding = $("#taskcoding").val();
	var taskname = $("#taskname").val();
	var taskbills = $("#taskbills").combobox('getText');
	var taskMan = $("#taskMan").combobox('getValue');
	var taskDesc = $("#taskDesc").val();
	var taskRemark = $("#taskRemark").val();
	var str = $.map($("#select_user option:not(:selected)"),
            function(ele){return ele.value} 
         ).join(",");
	console.log(taskcoding, taskname, taskbills, taskMan, taskDesc, taskRemark,str);

}
