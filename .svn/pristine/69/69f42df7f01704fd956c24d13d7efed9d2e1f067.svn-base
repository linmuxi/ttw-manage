;(function($){
	//定义命名空间
	_admin = $.extend({},$.admin);

	var taskModalStatus = function(status){
		$("#taskModel").modal(status);
	};
	
	var taskModelTitle = function(title){
		$("#taskTitle").html(title);
	};
	
	var taskIframe = function(src){
		$("#taskIframe").attr("src",src);
	};
	
	//列表
	var table = null;
	
	//初始化表格
	function initTable(){
		table = $('#myTaskGrid').dataTable({
			"processing": true,
			"serverSide": true,
			"pagingType":"simple_numbers",
			"ordering":false,
			"searching":false,
			"paging":false,
			"search":{
				"regex":true		
			},
	        "ajax": {
	            "url": webRoot+"/page/admin/activiti/getTaskList",
	            "type": "POST"
	        },
	        "language": datatable_language,
	        "columns": [
	                    { "data": "id" },
	                    { "data": "name" },
	                    { "data": "processDefinitionName" },
	                    { "data": "priority" },
	                    { "data": "createTime" },
	                    { "data": "dueDate" },
	                    { "data": "description" },
	                    { "data": "commands" },
	                    { "data": "businessId" },
	                    { "data": "formKey" },
	                    { "data": "processDefinitionId" }
	                ],
			"columnDefs":[
			              	{
			              		"targets":[5,8,9,10],
			              		"visible":false
			              	},
				        	{
				        		"render":function(data,type,row){
						            return new Date(data).pattern("yyyy/MM/dd HH:mm:ss");
					        	},
					        	"targets":[4]
				        	},
				        	{
				        		"render":function(data,type,row){
				        			return '<a class="btn btn-xs btn-primary" title="查看审批流程" href="javascript:myTask.reviewProcess(\''+row['id']+'\');"><i class="btn-icon-only icon-tasks"> </i></a>&nbsp;'+
				        			'<a class="btn btn-xs btn-primary" title="审批" href="javascript:myTask.approval(\''+row['id']+'\',\''+row['businessId']+'\',\''+row['formKey']+'\');"><i class="btn-icon-only icon-tasks"> </i></a>';
					        	},
					        	"targets":7
				        	}
			        ]
		});
	}
	
	//初始化事件
	function initEvent(){
		var $taskIframe = $("#taskIframe");
		$taskIframe.load(function(){
			//自适应iframe高度
			var doc = $taskIframe[0].contentDocument.documentElement;
			$taskIframe.attr("height",doc.offsetHeight+"px");
			$taskIframe.attr("width",doc.offsetWidth+"px");
			$(".modal-dialog").width(doc.offsetWidth+100);
			$(".modal-dialog").height(doc.offsetHeight+100);
		});
	}
	
	//初始化函数
	function init(){
        initTable.call(this);
        initEvent.call(this);
	}
	
	//定义任务对象
	var Task = function(ops){
		this.options = $.extend(true, {}, ops);
		init.call(this);
	};
	
	Task.prototype = {
		constructor:Task,
		taskHandler:function(){
			taskModalStatus("hide");
			table.fnDraw();
		},
		reviewProcess:function(taskId){
			taskModalStatus("show"); 
			taskModelTitle("流程预览");
			var taskSrc = webRoot+"/page/admin/activiti/reviewNowProcess?taskId="+taskId;
			var taskTitle = encodeURIComponent(encodeURIComponent("流程预览"));
			taskIframe(webRoot+"/page/admin/activiti/reviewProcessDefinition.jsp?pdTitle="+taskTitle+"&pdSrc="+taskSrc);
		},
		approval:function(taskId,businessId,formKey){
			/**
			taskModalStatus("show"); 
			taskModelTitle("流程审批");
			taskIframe(webRoot+"/page/admin/activiti/approvalForm.jsp?src="+src);  
			 **/
			var src = webRoot+formKey+"?id="+businessId+"&taskId="+taskId;
			toPage("/page/admin/activiti/approvalForm.jsp?src="+src);
		}
	};
	
	_admin.Task = Task;
	$.admin = _admin;
})(jQuery); 

var myTask = new $.admin.Task({});

function getTargetObject(){
	return myTask;
}
