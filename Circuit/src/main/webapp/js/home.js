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
				if ($("#tabs").tabs('exists', node.text)) {
					$("#tabs").tabs('select', node.text);
				} else {
					$("#tabs").tabs('add', {
						title : node.text,
						closable : true,
						iconCls:node.iconCls,
						href : "http://localhost:8080/crm/"+node.url,
						onLoad:function(){
							orderInquiry();
						}
					});
				}
			}
		}
	}); 
})