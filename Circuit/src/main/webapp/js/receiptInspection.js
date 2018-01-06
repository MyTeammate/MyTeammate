$(function(){
	$.ajax({
		url:"getTowerByTaskId",
		type:"post",
		dateType:"json",
		success:function(data){
			$("#threadCoding").text(data.thread.coding);
			var htm='';
			htm+='<li>';   
			htm+='<img alt="" src="image/u125_selected.png" id="onclick_hidden" onClick="hideTower()"><img alt="" src="image/u125.png" id="onclick_show" style="display:none;" onClick="showTower()">&nbsp;'
				+'<span style="font-weight:bold;">'+data.thread.name+'</span>';   
			var towers=data.towers;
			$("#towerCoding").text(towers[0].coding);
			htm+='<ul id="inspection_towers">'
			for(var i=0;i<towers.length;i++){
				htm+='<li><span><a href="javascript:void(0)" onclick="showFlaw(this,'+towers[i].id+')">'+towers[i].coding+'</a></span></li>';
			}     
		    htm+='</ul></li> ';
		    $("#threadTowerTree").append(htm);
		}
	});
	
	initDate(); // 得到系统当前 年 月  日
	
	$("#inspectionFlawType").combobox({
		valueField : 'id',
		textField : 'name',
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
	
	$("#receipt_table").hide(); // 回执录入表单默认隐藏
	
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

var towerId='';

/*
 * 点左边出右边
 */
function showFlaw(e,id){
	towerId = id;
	var a=$("#inspection_towers li a");
	for(var i=0;i<a.length;i++){
		if(a[i].innerText == e.innerText){
			a[i].style.backgroundColor='#D2D2D2';/*点击的*/
		}else{
			a[i].style.backgroundColor='#F7F7F7';/*其他*/
		}
	}
	$("#receipt_table").show();
	$("#towerCoding").text(e.innerText);
	
	// 清空上次点击赋值的数据
	$('.progress_btn').css('left', 0);
    $('.progress_bar').width(0);
    $('.text').html(parseInt((0/300)*100) + '%');
    var date = new Date();
	var value = date.getFullYear()+'-'+(date.getMonth()+1)+'-'+date.getDate();
	$("#receiptInspectionDate").val(value);
    $("textarea[name=description]").val('');
	
	$.ajax({
		url:"getTowerFlaw",
		type:"post",
		data:{
			towerId:id
		},
		success:function(data){
			//console.log("flowId:"+data.flawId+",serviceAbility:"+data.serviceAbility+",flawDesc:"+data.flawDesc);
			$("#inspectionFlawType").combobox('select',data.flawId);
			$("#inspectionFlawGrade").combobox('select',data.flawGrade);
			
			if(data.serviceAbility!=null){
				var ability = data.serviceAbility.replace('%','');
				var left=3*ability;
				$('.progress_btn').css('left', left);
	            $('.progress_bar').width(left);
	            $('.text').html(parseInt((left/300)*100) + '%');
			}
            if(data.discoverDate!=null){
            	$("#receiptInspectionDate").val(data.discoverDate);
            }
            $("textarea[name=description]").val(data.flawDesc);
		}
	});
}

/*
 * 返回
 */
function backExecuteReceipt(){
	move('巡检任务执行与回执','inspectionExecuteReceipt');
}

/*
 * 保存   变颜色  存入数据库
 */
function saveExecuteReceipt(){
	var flag=false;
	var a=$("#inspection_towers li a");
	for(var i=0;i<a.length;i++){
		if(a[i].style.backgroundColor=='rgb(210, 210, 210)'){
			flag=true;
			a[i].style.color='red';
		}
	}
	
	if(flag==false){
		$.messager.alert({
			title:'保存失败',
			msg:'<h3 style="color: red;">请先选择杆塔填写信息！</h3>',
			icon:'warning',
		})
		return false;
	}
	
	// 杆塔id,缺陷类型,缺陷级别,完好率,发现时间，缺陷描述
	var flawType=$("#inspectionFlawType").combobox('getValue');
	var flawGrade=$("#inspectionFlawGrade").combobox('getValue');
	//alert(flawGrade)
	var serviceAbility=$('.text').text();
	var sb=serviceAbility.replace('%','');
	var date=$("#receiptInspectionDate").val();
	var description=$("textarea[name=description]").val();
	
	if(!$('#receipt_form').form('validate') || !parseInt($.trim(sb))>0){
		$.messager.alert({
			title:'保存失败',
			msg:'<h3 style="color: red;">请完善信息！</h3>',
			icon:'warning',
		})
		return false;
	}	
	
	$.ajax({
		url:"saveExecuteReceipt",
		type:"POST",
		data:{
			flawId:flawType,
			towerId:towerId,
			flawGrade:flawGrade,
			serviceAbility:serviceAbility,
			discoverDate:date,
			flawDesc:description,
			//$('#receipt_form').serialize(),
		},
		success:function(result){
			if(result==true){
				 $.messager.show({
					title:'提示',
					msg:'回执录入保存成功',
					timeout:200,
					showType:"slide",
					style:{
					}
				});
			}else{
				$.messager.alert({
					title:'保存失败',
					msg:'<h3 style="color: red;">未知错误导致失败，请重试！</h3>',
					icon:'warning',
				})
			}
		}
	})
}

/*
 * 执行上传回执
 */
function executeReceipt(){
	$.ajax({
		url:"executeReceipt",
		type:"POST",
		success:function(result){
			console.log(result)
			if(result.flag==true){
				if(result.userId){
					websocket.send(result.userId)
				}
				 $.messager.show({
					title:'提示',
					msg:'上传回执成功',
					timeout:200,
					showType:"slide",
					style:{
					}
				});
				move('巡检任务执行与回执','inspectionExecuteReceipt'); 
			}else{
				$.messager.alert({
					title:'上传回执失败',
					msg:'<h3 style="color: red;">未知错误导致失败，请重试！</h3>',
					icon:'warning',
				})
			}
		}
	})
}