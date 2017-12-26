$(function(){
	$('#cc').layout('add',{    
	    region: 'west',    
	    width: 180,    
	    title: 'West Title',    
	    split: true,    
	    tools: [{    
	        iconCls:'icon-add',    
	        handler:function(){alert('add')}    
	    },{    
	        iconCls:'icon-remove',    
	        handler:function(){alert('remove')}    
	    }]    
	}); 
})