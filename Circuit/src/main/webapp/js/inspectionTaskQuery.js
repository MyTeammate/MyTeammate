function inspectionBottomLeftDd(node){
	$("#inspectionBottomRight").empty();
	$(node).css('background-color','#D4D4D4');
	$(".inspectionBottomLeftDd").each(function(){
		if($(this).html()!=$(node).html()){
			$(this).css('background-color','white');
		}
	});
	$.ajax({
		url:'onclickTowerFlawInfo',
		type:'get',
		cache:'false',
		data:{towerCoding:$(node).html(),taskId:$("#inspectionTaskHdId").val()},
		success:function(result){
			if(result){
				var element =  '<table id="inspectionBottomRightTable" cellspacing="20"  >'+
					          '<tr>'+
						          '<td><strong>线路编号：</strong>'+$("#inspectionHdThreadCoding").val()+'</td>'+
						          '<td><strong>杆塔编号：</strong>'+$(node).html()+'</td>'+
						      '</tr>'+
						      '<tr>'+
						          '<td colspan="2"><strong>巡检时间：</strong>2013-12-13</td>'+
						          '<td></td>'+
						      '</tr>'+
						      '<tr>'+
						          '<td colspan="2">'+$("#inspectionStaffs").html()+'</td>'+
						          '<td></td>'+
						      '</tr>'+
						     '<tr>'+
						          '<td>'+$("#downMan").html()+'</td>'+
						          '<td>'+$("#downDate").html()+'</td>'+
						      '</tr>'+
						       '<tr>'+
						          '<td><strong>有无故障：</strong>'+result.isTrouble+'</td>'+
						          '<td><strong>完好率：</strong>'+result.serviceAbility+'</td>'+
						      '</tr>'+
						      '<tr>'+
						          '<td><strong>缺陷类型：</strong>'+result.flawType+'</td>'+
						          '<td><strong>缺陷级别：</strong>'+result.flawGrade+'</td>'+
						      '</tr>'+
						      '<tr>'+
						          '<td colspan="2"><strong>缺陷描述：</strong>'+result.flawDesc+'</td>'+
						          '<td></td>'+
						      '</tr>'+
						      '<tr>'+
						          '<td><strong>缺陷发现人：</strong>'+result.receiptMan+'</td>'+
						          '<td><strong>发现时间：</strong>'+result.discoverDate+'</td>'+
						      '</tr>'+
				        '<table>';
				$("#inspectionBottomRight").html(element);
			}
		}
	})
}