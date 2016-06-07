/*
 * Copyright 2015 the original author or phly.
 * 未经正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 */
/**
 * 
 * @Description: TODO
 * @author wanglong
 * @since 2015年6月9日 下午7:46:52
 * 
 */
(function($) {
	// 定义命名空间
	_admin = $.extend({}, $.admin);
	
	//列表对象
	var table = null;
	
	var supplierOperationTitle = function(title){
		$("#supplierOperationTitle").html(title);
	};
	
	var supplierOperationModalStatus = function(status){
		$("#supplierOperation").modal(status);
	};
	
	var supplierOperationIframe = function(src){
		$("#supplierOperationIframe").attr("src",src);
	};

	// 初始化事件
	function initEvent() {
		//添加角色
		$("#id_add_supplier").click(supplier.addSupplier);
		
		$("#export_supplier").click(supplier.exportSupplier);
		
		//iframe自适应高度
		$("#supplierOperationIframe").resizeIframe({height:80});
	}

	// 初始化表格
	function initTable() {
		table = $('#supplierList').dataTable({
			"processing": true,
			"serverSide": true,
			"pagingType":"simple_numbers",  
			"search":{
				"regex":true		
			},
	        "ajax": {
	            "url": webRoot+"/page/business/manage/supplier/index",
	            "type": "POST"
	        },
	        "language": datatable_language,
	        "columns": [
	                    { "data": "supplierId" },
	                    { "data": "supNo" },
	                    { "data": "contractCode" },
	                    { "data": "cmbPeopleName" },
	                    { "data": "supName" },
	                    { "data": "supPhone" },
	                    { "data": "supState" },
	                    { "data": "supSynState" },
	                    { "data": "supType" },
	                    { "data": "commands" }
	                ],
			"columnDefs":[

				        	{
			              		"visible":false,
					        	"targets":0
				        	},
				        	{
//				        		"render":function(data,type,row){
//				        			return '<a class="btn btn-xs btn-primary" title="修改" href="javascript:supplier.updateSupplier(\''+row['supplierId']+'\');"><i class="btn-icon-only icon-edit"> </i></a>'+
//				        			'<a class="btn btn-xs btn-primary" title="删除" href="javascript:supplier.deleteSupplier(\''+row['supplierId']+'\');"><i class="btn-icon-only icon-remove"> </i></a>&nbsp;';
//					        	},
				        		"render":function(data,type,row){
				        			return '<a class="btn btn-xs btn-primary" title="修改" href="javascript:supplier.updateSupplier(\''+row['supplierId']+'\');"><i class="btn-icon-only icon-edit"> </i></a>';
					        	},
					        	"orderable":false,
					        	"targets":9
				        	},
				        	{
				        		"render":function(data,type,row){
				        			return  (data == 0) ? "合作" : "中止";
					        	},
					        	"targets":6
				        	},
				        	{
				        		"render":function(data,type,row){
				        			return  (data == 1) ? "成功" : "失败";
					        	},
					        	"targets":7
				        	},
				        	{
				        		"render":function(data,type,row){
				        			return  (data == 0) ? "个人" : "公司";
					        	},
					        	"targets":8
				        	}
			        ]
		});
	}

	function init() {
		//初始化表格
		initTable.call(this);
	}

	var sysSupplier = function(ops) {
		this.options = $.extend(true, {},  ops);
		init.call(this);
	};
	
	sysSupplier.prototype = {
			constructor:sysSupplier,
			formSupplierHandler : function(){
				supplierOperationModalStatus("hide");
				table.fnDraw(); 
			},
			//供应商详情
//			detailSupplier : function(supplierId){
//				supplierOperationTitle("查看供应商详情");
//				supplierOperationModalStatus('show');
//				supplierOperationIframe(webRoot+"/page/business/manage/supplier/supplierForm.jsp?supplierId="+supplierId);
//			},
			// 添加供应商
			addSupplier : function(e) {
				supplierOperationTitle("新增供应商");
				supplierOperationModalStatus('show');
				supplierOperationIframe(webRoot+"/page/business/manage/supplier/supplierForm.jsp");
			},
			// 修改供应商
			updateSupplier : function(supplierId) {
				supplierOperationTitle("修改供应商");
				supplierOperationModalStatus('show');
				supplierOperationIframe(webRoot+"/page/business/manage/supplier/supplierForm.jsp?supplierId="+supplierId);
			},
			// 删除供应商
//			deleteSupplier : function(supplierId) {
//				lhgdialog.confirm('确定要删除此条数据吗？', function(){
//					$("body").mask("处理中..");
//					SupplierAction.delSupplier({supplierId:supplierId},function(data){
//						$("body").unmask();
//						if(data){
//							lhgdialog.alert("删除成功");
//							table.fnDraw();
//						}else{
//							lhgdialog.alert("删除失败");
//						}
//					});
//				});
//			},
			exportSupplier : function(){
				window.location.href = webRoot+'/page/business/manage/supplier/supplierExportExcel';
			}
	};
	
	$(function(){
        initEvent.call(this);
	});

	_admin.sysSupplier = sysSupplier;
	$.admin = _admin;
})(jQuery);

var supplier = new $.admin.sysSupplier({});

function getTargetObject(){
	return supplier;
}