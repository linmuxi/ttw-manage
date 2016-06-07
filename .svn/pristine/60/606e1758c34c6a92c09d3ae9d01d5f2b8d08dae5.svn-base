;(function($){
	//定义命名空间
	_admin = $.extend({},$.admin);

	var fpModalStatus = function(status){
		$("#fpModel").modal(status);
	};
	
	var fpModelTitle = function(title){
		$("#fpTitle").html(title);
	};
	
	var fpIframe = function(src){
		$("#fpIframe").attr("src",src);
	};
	
	//列表对象
	var dataTable = null;
	
	//初始化表格
	function initTable(){
		dataTable = $('#formProcessGrid').dataTable({
			"processing": true,
			"serverSide": true,
			"search":{
				"regex":true		
			},
			"pagingType":"simple_numbers",
	        "ajax": {
	            "url": webRoot+"/page/admin/activiti/queryFormProcessList",
	            "type": "POST"
	        },
	        "language": datatable_language,
	        "columns": [
	                    { "data": "id" },
	                    { "data": "formName" },
	                    { "data": "prodefName" },
	                    { "data": "commands" }
	                ],
			"columnDefs":[
			              	{
			              		"targets":0,
			              		"visible":false
			              	},
				        	{
				        		"render":function(data,type,row){
				        			return '<a class="btn btn-xs btn-primary" title="修改" href="javascript:formProcess.updateFormProcess(\''+row['id']+'\');"><i class="btn-icon-only icon-edit"> </i></a>'+
				        			'<a class="btn btn-xs btn-primary" title="删除" href="javascript:formProcess.deleteFormProcess(\''+row['id']+'\');"><i class="btn-icon-only icon-remove"> </i></a>&nbsp;';
					        	},
					        	"orderable":false,
					        	"targets":3
				        	}
			        ]
		});
	}
	
	//初始化事件
	function initEvent(){
		$("#id_add_formProcess").click(function(){
			fpModalStatus("show"); 
			fpModelTitle("表单流程配置");
			fpIframe(webRoot+"/page/admin/activiti/formProcessForm.jsp");
		});
		
		$("#fpIframe").resizeIframe({height:50});
	}
	
	//初始化函数
	function init(){
        initTable.call(this);
        initEvent.call(this);
	}
	
	var FormProcess = function(ops){
		this.options = $.extend(true, {}, ops);
		init.call(this);
	};
	
	FormProcess.prototype = {
		constructor:FormProcess,
		formProcessHandler:function(){
			fpModalStatus("hide");
			dataTable.fnDraw();
		},
		deleteFormProcess:function(id){
			lhgdialog.confirm('确定要删除此条数据吗？', function(){
		    	  FormProcessAction.deleteFormProcess({id:id},function(data){
						if(data && data.result){ 
							lhgdialog.alert("删除成功");
							dataTable.fnDraw();
						}else{
							lhgdialog.alert("删除失败");
						}
				  });
			}, function(){
			});
		},
		updateFormProcess:function(id){
			fpModalStatus("show"); 
			fpModelTitle("业务表单流程修改");
			fpIframe(webRoot+"/page/admin/activiti/formProcessForm.jsp?id="+id);
		}
	};
	
	_admin.FormProcess = FormProcess;
	$.admin = _admin;
})(jQuery); 

var formProcess = new $.admin.FormProcess({});

function getTargetObject(){
	return formProcess;
}
