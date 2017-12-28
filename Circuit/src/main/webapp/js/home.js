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
			console.log(data);
			if (data) {
				$(data).each(function(index, value) {	
					 if (this.state == "closed"&&this.nid==0) {
						$("#nav").tree("expandAll");
					} 
				});
			}
		}, 
		onClick : function(node) {
			console.log(node);
			if (node.url) { 
				console.log($("#tabs"))
				if ($("#tabs").tabs('exists', node.text)) {
					$("#tabs").tabs('select', node.text);
				} else {
					$("#tabs").tabs('add', {
						title : node.text,
						closable : true,
						iconCls:node.iconCls,
						href : "http://localhost:8080/Circuit/"+node.url,
						onLoad:function(){
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
							}
							if(node.text=="消缺任务制定与分配"){
								eliminate();
							}
							
						}
					});
				}
			}
		}
	}); 
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

