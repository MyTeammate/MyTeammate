/*
 * 巡检任务管理 >> 巡检任务制定与分配 >> 制定巡检任务
 */

$(function(){
	/*
	 * 巡检线路下拉列表
	 */
	$("#inspectionThread").combobox({
		valueField : 'id',
		textField : 'name',
		editable : false,// 不可编辑，只能选择
		panelHeight : 'auto',
		url : 'getAllThread',
		loadFilter : function(data) {
			var obj = {};
			obj.dataid = '-1';
			obj.datavalue = '--请选择--'
			data.splice(0, 0, obj)// 在数组0位置插入obj,不删除原来的元素
			return data;
		},
		onLoadSuccess : function() {
			var data = $(this).combobox('getData');
			if (data.length > 0) {
				$(this).combobox('select', data[0].datavalue);
			}
		}
	});
});

/*
 * 制定巡检任务 返回按钮操作
 */
function backInspection(){
	var tab = $('#tabs').tabs('getSelected');  // 获取选择的面板
	tab.panel('refresh', 'inspectionMakeAllot');
}