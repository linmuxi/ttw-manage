//页面跳转方法
function forward(url){
	window.location.href = url;
}

//datatable默认文本
var datatable_language = {
    "lengthMenu": "每页显示&nbsp;&nbsp;_MENU_&nbsp;&nbsp;条",
    "zeroRecords": "没有结果",
    "info": "总条数：_TOTAL_条&nbsp;&nbsp;本页显示 _START_ 至 _END_ 条",
    "infoEmpty": "无记录",
    "infoFiltered": "(搜索到 _MAX_ 条记录)",
    "paginate": {
		"first": "首页",
		"last": "尾页",
		"next": "下一页",
		"previous": "上一页"
	}, 
	"loadingRecords": "请稍等，加载中...", 
	"processing": "请稍等，加载中...",
	"search": "搜索："
};

//表单验证默认图标样式
var formValidation_icon = {
    valid: 'glyphicon glyphicon-ok',
    invalid: 'glyphicon glyphicon-remove',
    validating: 'glyphicon glyphicon-refresh'
}
