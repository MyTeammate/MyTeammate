 var websocket = null;
    //判断当前浏览器是否支持WebSocket
   
     if ('WebSocket' in window) {
          websocket = new WebSocket("ws://localhost:8080/Circuit/perWork");
     }
     else {
         alert('当前浏览器 Not support websocket')
     } 
 
     //连接发生错误的回调方法
     websocket.onerror = function () {
         setMessageInnerHTML("WebSocket连接发生错误");
     };
 
     //连接成功建立的回调方法
     websocket.onopen = function () {
         
     }
     
     //接收到消息的回调方法
     websocket.onmessage = function (event) {
    	 $.messager.confirm('提示','您有新的代办任务,是否查看？',function(r){    
     	    if (r){  
     	    	addTabs('待办列表','personalWork');
     	    }    
     	});
     }
 
 
     //连接关闭的回调方法
     websocket.onclose = function () {
         setMessageInnerHTML("WebSocket连接关闭");
     }
 
     //监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。
     window.onbeforeunload = function () {
         closeWebSocket();
     }
 
     //将消息显示在网页上
     function setMessageInnerHTML(innerHTML) {
        // document.getElementById('message').innerHTML += innerHTML + '<br/>';
     }
 
     //关闭WebSocket连接
     function closeWebSocket() {
         websocket.close();
     }
 
     //发送消息
     function send() {
         var message = document.getElementById('username').value;
         websocket.send(message);
     }
$(function(){
	/*$('#sy').tabs('add', {
		options: {
			title: 待办列表,
			href: personalWork  // 新内容的URL
		}
	});*/
	$("#nav").tree({
		url : 'homeController/homeNav',
		animate:true,
		lines : true,
		cascadeCheck:false,
		onlyLeafCheck:true,
		onLoadSuccess : function(node, data) {
			if (data) {
				$(data).each(function(index, value) {	
					 if (this.state == "closed"&&this.nid==0) {
						$("#nav").tree("expandAll");
					} 
				});
			}
		}, 
		onClick : function(node) {
			if (node.url) { 
				//console.log($("#tabs"))
				if ($("#tabs").tabs('exists', node.text)) {
					$("#tabs").tabs('select', node.text);
				} else {
					$("#tabs").tabs('add', {
						title : node.text,
						closable : true,
						iconCls:node.iconCls,
						href : "http://localhost:8080/Circuit/"+node.url,
						onLoad:function(){
							var data={logId:node.id};
							$.ajax({
								url:'userManage/addLog',
								type:"post",
								data:data,
								success:function(result){
								}
							})
							//orderInquiry();
							if(node.text=="杆塔管理"){
								tower();
							}else if(node.text=="待办列表"){
								perWork();
							}else if(node.text=="巡检记录统计"){
								taskP();
							}else if(node.text=="消缺记录统计"){
								taskE();
							}else if(node.text=="数据字典"){
								data_tb();
								parameter_tb();
							}else if(node.text=="用户管理"){
								user_tb();
								log_tb();
							}else if(node.text=="角色管理"){
								role_tb();
							}
							if(node.text=="消缺任务制定与分配"){
								eliminate();
							}
							
							if(node.text=="路线管理"){
								line();
							}
							if(node.text=="角色权限配置"){
								roleDistribution();
							}
							
							if(node.text=="消缺查询"){
								eliminatequery();
							}
							
						}
					});
				}
			}
		}
	}); 
	var logId=10000;
	var dataOut={logId:logId};
	$('#logout').bind('click',function(){
		$.ajax({
			url:'prepareLogout',
			type:"post",
			data:dataOut,
			success:function(result){
				window.location.href=""+result+""; 
			}
		})
	})
})

//更改一个面板（跳面板）
function move($text,$url){
	// 更新选择的面板的新标题和内容
	var tab = $('#tabs').tabs('getSelected');  // 获取选择的面板
	$('#tabs').tabs('update', {
		tab: tab,
		options: {
			title: $text,
			href: $url  // 新内容的URL
		}
	});
	// 调用 'refresh' 方法更新选项卡面板的内容
	var tab = $('#tabs').tabs('getSelected');  // 获取选择的面板
	tab.panel('refresh',$url);
}

function addTabs($text,$url){
	if ($("#tabs").tabs('exists', $text)) {
		$("#tabs").tabs('select', $text);
		var tab = $('#tabs').tabs('getSelected');  // 获取选择的面板
		tab.panel('refresh',$url);
	}else{
		// 添加一个未选中状态的选项卡面板
		$('#tabs').tabs('add',{
			title: $text,
			href: $url,
			closable:true, 
		});
	}
}

function showtime()  
{  
	var today,hour,second,minute,year,month,date;  
	var strDate ;  
	today=new Date();  
	var n_day = today.getDay();  
	switch (n_day)  
	{  
	    case 0:{  
	      strDate = "星期日";  
	    }break;  
	    case 1:{  
	      strDate = "星期一";  
	    }break;  
	    case 2:{  
	      strDate ="星期二";  
	    }break;  
	    case 3:{  
	      strDate = "星期三";  
	    }break;  
	    case 4:{  
	      strDate = "星期四";  
	    }break;  
	    case 5:{  
	      strDate = "星期五";  
	    }break;  
	    case 6:{  
	      strDate = "星期六";  
	    }break;  
	    case 7:{  
	      strDate = "星期日";  
	    }break;  
	}  
	year = today.getYear()+1900;  
	month = today.getMonth()+1;  
	date = today.getDate();  
	hour = today.getHours();  
	minute =today.getMinutes();  
	second = today.getSeconds();  
	if(minute<10&&second<10){
		document.getElementById('time').innerHTML = "<span style='color:white'>"+year + "年" + month + "月" + date + "日  " + strDate +"   " + hour + ":0" + minute + ":0" + second+"</span>"; //显示时间  
	}else if(minute<10){
		document.getElementById('time').innerHTML = "<span style='color:white'>"+year + "年" + month + "月" + date + "日  " + strDate +"   " + hour + ":0" + minute + ":" + second+"</span>"; //显示时间
	}else if(second<10){
		document.getElementById('time').innerHTML = "<span style='color:white'>"+year + "年" + month + "月" + date + "日  " + strDate +"   " + hour + ":" + minute + ":0" + second+"</span>"; //显示时间
	}else{
		document.getElementById('time').innerHTML = "<span style='color:white'>"+year + "年" + month + "月" + date + "日  " + strDate +"   " + hour + ":" + minute + ":" + second+"</span>"; //显示时间
	}
	
	setTimeout("showtime();", 1000); //设定函数自动执行时间为 1000 ms(1 s)  
}  
