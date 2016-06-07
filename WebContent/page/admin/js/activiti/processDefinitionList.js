;(function($){
	//定义命名空间
	_admin = $.extend({},$.admin);

	var pdModalStatus = function(status){
		$("#pdModel").modal(status);
	};
	
	var pdModelTitle = function(title){
		$("#pdTitle").html(title);
	};
	
	var pdIframe = function(src){
		$("#pdIframe").attr("src",src);
	};
	
	//列表
	var table = null;
	
	//初始化表格
	function initTable(){
		table = $('#processDefinitionGrid').dataTable({
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
	            "url": webRoot+"/page/admin/activiti/getProcessDefinitionList",
	            "type": "POST"
	        },
	        "language": datatable_language,
	        "columns": [
	                    { "data": "deploymentId" },
	                    { "data": "id" },
	                    { "data": "version" },
	                    { "data": "category" },
	                    { "data": "name" },
	                    { "data": "key" },
	                    { "data": "deploymentName" },
	                    { "data": "deploymentTime" },
	                    { "data": "suspensionState" },
	                    { "data": "description" },
	                    { "data": "commands" }
	                ],
			"columnDefs":[
			              	{
			              		"targets":[0,3],
			              		"visible":false
			              	},
				        	{
				        		"render":function(data,type,row){
						            return new Date(data).pattern("yyyy/MM/dd HH:mm:ss");
					        	},
					        	"targets":[7]
				        	},
				        	{
				        		"render":function(data,type,row){
				        			return (data==1?"是":"否");
					        	},
					        	"targets":8,
			              		"visible":false
				        	},
				        	{
				        		"render":function(data,type,row){
				        			return '<a class="btn btn-xs btn-primary" title="流程预览" href="javascript:processDefinition.reviewProcessDefinition(\''+row['id']+'\');"><i class="btn-icon-only icon-tasks"> </i></a>'+
				        			'<a class="btn btn-xs btn-primary" title="删除" href="javascript:processDefinition.deleteDeployment(\''+row['deploymentId']+'\');"><i class="btn-icon-only icon-remove"> </i></a>&nbsp;';
					        	},
					        	"targets":10
				        	}
			        ]
		});
	}
	
	//初始化事件
	function initEvent(){
		$("#id_add_processDefinition").click(function(){
			pdModalStatus("show"); 
			pdModelTitle("流程部署");
			pdIframe(webRoot+"/page/admin/activiti/processDefinitionForm.jsp");
		});
		$("#pdIframe").resizeIframe({height:80}); 
	}
	
	//初始化函数
	function init(){
        initTable.call(this);
        initEvent.call(this);
	}
	
	//定义任务对象
	var ProcessDefinition = function(ops){
		this.options = $.extend(true, {},ops);
		init.call(this);
	};
	
	ProcessDefinition.prototype = {
		constructor:ProcessDefinition,
		deleteDeployment:function(deploymentId){
			lhgdialog.confirm('确定要删除此条数据吗？', function(){
				ActivitiAction.deleteDeployment({id:deploymentId},function(data){
					if(data){
						lhgdialog.alert("删除成功");
						table.fnDraw();
					}else{
						lhgdialog.alert("删除失败");
					}
				});
			}, function(){
				//lhgdialog.tips('执行取消操作');
			});
		},
		reviewProcessDefinition:function(id){
			pdModalStatus("show"); 
			pdModelTitle("流程预览");
			var pdSrc = webRoot+"/page/admin/activiti/reviewProcessDefinition?processDefinitionId="+id;
			var pdTitle = encodeURIComponent(encodeURIComponent("流程预览"));
			pdIframe(webRoot+"/page/admin/activiti/reviewProcessDefinition.jsp?pdTitle="+pdTitle+"&pdSrc="+pdSrc);
		}
	};
	
	_admin.ProcessDefinition = ProcessDefinition;
	$.admin = _admin;
})(jQuery); 

var processDefinition = new $.admin.ProcessDefinition({});

function getTargetObject(){
	return processDefinition;
}
