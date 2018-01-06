$(function() {
	var ts = $("#te").val();
	$('#mEnews').datagrid({
		pageNumber : 1,
		pageSize : 5,
		pagination : true,
		pageList : [5, 10, 15, 20 ],
		rownumbers : true,
		nowrap:false,
		url : "taskElTowerAllPost?tcoding="+ts,
		columns : [ [ {
			field : 'etowerCoding',
			title : '杆塔编号',
			width : 110,
			align : "center",
		},{
			field : 'eisTrouble',
			title : '有无故障',
			width : 110,
			align : "center",
		},{
			field : 'esettingName',
			title : '缺陷级别',
			width : 110,
			align : "center",
		},{
			field : 'eflawTname',
			title : '缺陷类型',
			width : 110,
			align : "center"
		},{
			field : 'eactualDate',
			title : '消缺时间',
			width : 110,
			align : "center",
		},{
			field : 'ediscoverDate',
			title : '发现时间',
			width : 110,
			align : "center",
		},{
			field : 'eflawDesc',
			title : '缺陷描述',
			width : 220,
			align : "center",
		}] ],

	})
})

function testEl() {
	move("消缺记录统计", "taskEliminate");
}

function taskSelt(){	
	$('#mEnews').datagrid('reload',{
		gantTitle:$('#gant').val(),
		quexTitle:$('#quex').val(),
		seTitle:$('#yn').val(),
		staTitle:$('#staetx').val(),
		endTitle:$('#ends').val()
	});
}