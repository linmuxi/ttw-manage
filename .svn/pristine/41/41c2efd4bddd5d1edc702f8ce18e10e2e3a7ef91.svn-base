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

	var departmentFormValidation;

	var departmentFormModalStatus = function(status) {
		$("#departmentModel").modal(status);
	}
	
	
	//设置部门编辑title
	var departmentFormModelTitle = function(title){
		$("#departmentFormTitle").html(title);
	}

	//设置部门编辑URL
	var departmentFormIframe = function(src){
		$("#departmentFormIframe").attr("src",src);
	}
	
	var table;
	//初始化表格
	function initTable(){
		table = $('#departmentList').dataTable({
			"processing": true,
			"serverSide": true,
			"pagingType":"simple_numbers",  
			"search":{
				"regex":true		
			},
	        "ajax": {
	            "url": webRoot+"/page/admin/department/queryDepartmentList",
	            "type": "POST"
	        },
	        "language": datatable_language,
	        "columns": [
	                    /*{ "data": "departmentId" },*/
	                    { "data": "orgName" },
	                    { "data": "parentId" },
	                    { "data": "orgRemark" },
	                    /*{ "data": "isDel" },*/
	                    { "data": "lastUpdateDate" },
	                    { "data": "commands" }
	                ],
			"columnDefs":[
							/*{
								"render":function(data,type,row){
									return (data == 1? "已删除" : "未删除");
								},
								"targets":3
							},*/
				        	{
				        		"render":function(data,type,row){
						            return new Date(data).pattern("yyyy/MM/dd");
					        	},
					        	"targets":3
				        	},
				        	{
				        		"render":function(data,type,row){
				        			return '<a class="btn btn-xs btn-primary" title="修改" href="javascript:department.updateDepartment(\''+row['departmentId']+'\');"><i class="btn-icon-only icon-edit"> </i></a>&nbsp;' +
				        			        '<a class="btn btn-xs btn-primary" title="删除" href="javascript:department.deleteDepartment(\''+row['departmentId']+'\');"><i class="btn-icon-only icon-remove"> </i></a>&nbsp;'
					        	},
					        	"targets":4
				        	}
			        ]
		});
	}
	
	var Department = function(ops) {
		this.options = $.extend(true, {}, Department.defaults, ops);
		init.call(this);
	}
	
	Department.prototype = {
			constructor:Department,
			//编辑完部门后回调方法：隐藏弹出层、刷新列表
			formDepartmentHandler:function(){
				departmentFormModalStatus("hide");
				table.fnDraw(); 
			},
		
			//修改部门 
			updateDepartment:function(departmentId){
				departmentFormModalStatus("show"); 
				departmentFormModelTitle("修改部门");
				departmentFormIframe(webRoot+"/page/admin/department/departmentForm.jsp?departmentId="+departmentId);
			},
			//删除部门
			deleteDepartment:function(departmentId){
				lhgdialog.confirm('确定要删除此条数据吗？', function(){
					$("body").mask("处理中..");
					SysDepartmentAction.delDepartment({departmentId:departmentId},function(data){
						$("body").unmask();
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
			}
		}
	

	// 清空表单信息
	var clearForm = function() {
		$("#orgName").val("");
		$("#orgRemark").val("");
		$("#isDel").val("");
	}

	// 重置表单验证器
	/*var resetFormValidation = function() {
		departmentFormValidation.updateStatus("orgName", "NOT_VALIDATED");
	}*/
	
	

	

	// 转换请求参数
	/*function convertParam(request) {
		var paramObj = request;
		paramObj.pageNo = request.current;
		paramObj.pageSize = (request.rowCount == -1) ? 99999999
				: request.rowCount;
		if (request.sort) {
			for ( var key in request.sort) {
				if (key) {
					paramObj.sortFieldName = key;
					paramObj.sortType = request.sort[key];
					break;
				}
			}
		}
		return paramObj;
	}*/

	// 初始化事件
	function initEvent() {
		// 添加部门
		$("#id_add_department").click(function(){
			departmentFormModalStatus("show"); 
			departmentFormModelTitle("新增部门");
			departmentFormIframe(webRoot+"/page/admin/department/departmentForm.jsp");
		});
		$("#departmentFormIframe").resizeIframe({height:80}); 
	

	
	}

	// 初始化表单验证器
	/*function initFormValidator() {
		$('#departmentForm').formValidation({
			message : 'This value is not valid',
			icon : {
				valid : 'glyphicon glyphicon-ok',
				invalid : 'glyphicon glyphicon-remove',
				validating : 'glyphicon glyphicon-refresh'
			},
			fields : {
				departmentName : {
					message : 'The departmentname is not valid',
					validators : {
						notEmpty : {
							message : '部门名称必须填写，不能为空'
						},
						stringLength : {
							min : 1,
							max : 100,
							message : '长度必须大于1小于100'
						}
					}
				}
			}
		}).on('success.form.fv', function(e) {
			submitForm();
			resetFormValidation();
		});
		departmentFormValidation = $("#departmentForm").data("formValidation");
	}*/

	
	
	//初始化部门下拉框数据 
	/*	function initDepartMentDS(){
		 $('#parent').multiselect('dataprovider', getDepartMentDS());
	}
	
	function getDepartMentDS(){ 
		var ds = [];
		$.ajaxSetup({   
            async : false  
        });
		$.post(webRoot+"/page/admin/department/queryDepartmentList",{pageNo:1,pageSize:65535},function(data){
			if(data && data.rows.length>0){
				$(data.rows).each(function(i,obj){
					ds.push({label:obj.orgName,value:obj.departmentId});
				});
			}
		});
	    return ds;
	 }*/

	function init() {
		//初始化表格
		initTable.call(this);
		//initDepartMentDS.call(this);
		//初始化表单验证器
		//initFormValidator.call(this);
		//初始化事件
		initEvent.call(this);
	}




	_admin.Department = Department;
	$.admin = _admin;
})(jQuery);

var department = new $.admin.Department({});

function getTargetObject(){
	return department;
}