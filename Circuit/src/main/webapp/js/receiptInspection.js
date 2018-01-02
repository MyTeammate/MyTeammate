$(function(){
	$.ajax({
		url:"getTowerByTaskId",
		type:"post",
		dateType:"json",
		success:function(data){
			var htm='';
			htm+='<li>';   
			htm+='<img alt="" src="image/u125_selected.png" id="onclick_hidden" onClick="hideTower()"><img alt="" src="image/u125.png" id="onclick_show" style="display:none;" onClick="showTower()">&nbsp;'
				+'<span style="font-weight:bold;">'+data.thread.name+'</span>';   
			var towers=data.towers;
			htm+='<ul id="inspection_towers">'
			for(var i=0;i<towers.length;i++){
				htm+='<li><span><a href="#">'+towers[i].coding+'</a></span></li>';
			}     
		    htm+='</ul></li> ';
		    $("#threadTowerTree").append(htm);
		    
		    $("#threadCoding").text(data.thread.coding);
		}
	});
	
	initDate(); // 得到系统当前 年 月  日
	
	$("#inspectionFlawType").combobox({
		valueField : 'id',
		textField : 'flawname',
		editable : false,// 不可编辑，只能选择
		panelHeight : 'auto',
		required : true,
	    missingMessage : '请选择缺陷类型',
		url : 'getAllFlaw',
	});
	
	$("#inspectionFlawGrade").combobox({
		valueField : 'id',
		textField : 'settingName',
		editable : false,// 不可编辑，只能选择
		panelHeight : 'auto',
		required : true,
	    missingMessage : '请选择缺陷级别',
		url : 'getFlawGrade',
	});
	
	$("textarea[name=description]").validatebox({
		required : true,
		missingMessage : '请输入缺陷描述',
	});
	
	  var tag = false,ox = 0,left = 0,bgleft = 0;
      $('.progress_btn').mousedown(function(e) {
          ox = e.pageX - left;
          tag = true;
      });
      $(document).mouseup(function() {
          tag = false;
      });
      $('.progress').mousemove(function(e) {//鼠标移动
          if (tag) {
              left = e.pageX - ox;
              if (left <= 0) {
                  left = 0;
              }else if (left > 300) {
                  left = 300;
              }
              $('.progress_btn').css('left', left);
              $('.progress_bar').width(left);
              $('.text').html(parseInt((left/300)*100) + '%');
          }
      });
      $('.progress_bg').click(function(e) {//鼠标点击
          if (!tag) {
              bgleft = $('.progress_bg').offset().left;
              left = e.pageX - bgleft;
              if (left <= 0) {
                  left = 0;
              }else if (left > 300) {
                  left = 300;
              }
              $('.progress_btn').css('left', left);
              $('.progress_bar').animate({width:left},300);
              $('.text').html(parseInt((left/300)*100) + '%');
          }
      });
});

/*
 * 隐藏杆塔
 */
function hideTower(){
	// 图片隐藏
	 $("#onclick_hidden").hide();
	 // 杆塔隐藏
	 $("#inspection_towers").hide();
	 //图片显示
	 $("#onclick_show").show();
}

/*
 * 显示杆塔
 */
function showTower(){
	// 图片隐藏
	 $("#onclick_hidden").show();
	 // 杆塔隐藏
	 $("#inspection_towers").show();
	 //图片显示
	 $("#onclick_show").hide();
}

/*
 * 获取系统当前 年 月日
 */
function initDate(){
	var date = new Date();
	var value = date.getFullYear()+'-'+(date.getMonth()+1)+'-'+date.getDate();
	$("#receiptInspectionDate").val(value);
}