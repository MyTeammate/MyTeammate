$(function(){
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

