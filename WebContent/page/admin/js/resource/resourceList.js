/*
 * Copyright 2015 the original author or phly.
 * 未经正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 */
/**
 * 
 * @Description: TODO
 * @author wanglong
 * @since 2015年6月8日 下午6:27:52
 * 
 */
(function($) {
	// 定义命名空间
	_admin = $.extend({}, $.admin);

	//列表对象
	var table = null;
	
	var resourceOperationTitle = function(title){
		$("#resourceOperationTitle").html(title);
	};
	
	var resourceOperationModalStatus = function(status){
		$("#resourceOperation").modal(status);
	};
	
	var resourceOperationIframe = function(src){
		$("#resourceOperationIframe").attr("src",src);
	};

	// 初始化事件
	function initEvent() {
		// 添加角色
		$("#id_add_resource").click(resource.addResource);
		
		//iframe自适应高度
		$("#resourceOperationIframe").resizeIframe({height:80});
	}
	
	// 初始化表格
	function initTable() {
		table = $('#resourceList').dataTable({
			"processing": true,
			"serverSide": true,
			"pagingType":"simple_numbers",  
			"search":{
				"regex":true		
			},
	        "ajax": {
	            "url": webRoot+"/page/admin/resource/index",
	            "type": "POST"
	        },
	        "language": datatable_language,
	        "columns": [
	                    { "data": "resourceId" },
	                    { "data": "resourceType" },
	                    { "data": "resourceName" },
	                    { "data": "resourceDesc" },
	                    { "data": "resourcePath" },
	                    { "data": "priority" },
	                    { "data": "enabled" },
	                    { "data": "commands" }
	                ],
			"columnDefs":[
				        	{
			              		"visible":false,
					        	"targets":0
				        	},
				        	{
					        	"targets":1,
				        		"render":function(data,type,row){
				        			return (data==1?"URL":"Method");
					        	}
				        	},
				        	{
				        		"render":function(data,type,row){
				        			return '<a class="btn btn-xs btn-primary" title="修改" href="javascript:resource.updateResource(\''+row['resourceId']+'\');"><i class="btn-icon-only icon-edit"> </i></a>'+
				        			'<a class="btn btn-xs btn-primary" title="删除" href="javascript:resource.deleteResource(\''+row['resourceId']+'\');"><i class="btn-icon-only icon-remove"> </i></a>&nbsp;';
					        	},
					        	"orderable":false,
					        	"targets":7
				        	},
				        	{
				        		"render":function(data,type,row){
				        			return (data?"是":"否");
					        	},
					        	"targets":6
				        	}
			        ]
		});
	}

	function init() {
		//初始化表格
		initTable.call(this);
	}

	var Resource = function(ops) {
		this.options = $.extend(true, {}, ops);
		init.call(this);
	};
	
	Resource.prototype = {
			constructor:Resource,
			formResourceHandler : function(){
				resourceOperationModalStatus("hide");
				table.fnDraw(); 
			},
			//资源添加
			addResource : function(){
				resourceOperationTitle("添加资源");
				resourceOperationModalStatus('show');
				resourceOperationIframe(webRoot+"/page/admin/resource/resourceForm.jsp");
			},
			// 修改资源
			updateResource : function(resourceId) {
				resourceOperationTitle("修改资源");
				resourceOperationModalStatus('show');
				resourceOperationIframe(webRoot+"/page/admin/resource/resourceForm.jsp?resourceId="+resourceId);
			},
			// 删除资源
			deleteResource : function(resourceId){
				lhgdialog.confirm('确定要删除此条数据吗？', function(){
					$("body").mask("处理中..");
					SysResourceAction.delResource({resourceId:resourceId},function(data){
						$("body").unmask();
						if(data){
							lhgdialog.alert("删除成功");
							table.fnDraw();
						}else{
							lhgdialog.alert("删除失败");
						}
					});
				});
			}
	};
	
	$(function(){
		initEvent.call(this);
	});

	_admin.Resource = Resource;
	$.admin = _admin;
	
})(jQuery);

var resource = new $.admin.Resource({});

function getTargetObject(){
	return resource;
}