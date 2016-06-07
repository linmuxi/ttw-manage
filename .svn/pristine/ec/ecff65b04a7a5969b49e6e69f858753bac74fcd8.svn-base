;(function($){
	function initEvent(){
		//提交表单
		$("#resourceFormBtn").click(function(){
			$('#resourceForm').submit();
		});
	}
	
	// 初始化表单验证器
	function initFormValidator() {
		$('#resourceForm').formValidation({
			fields : {
				resourceName : {
					validators : {
						notEmpty : {
							message : '资源名称必须填写，不能为空'
						},
						stringLength : {
							min : 2,
							max : 50,
							message : '长度必须大于2小于50'
						}
					}
				},
				resourcePath : {
					validators : {
						notEmpty : {
							message : '资源路径必须填写，不能为空'
						},
						stringLength : {
							min : 2,
							max : 100,
							message : '长度必须大于2小于100'
						},
                        remote: {
                            type: 'POST',
                            url: webRoot+'/page/admin/resource/getResourcePathExists',
                            message: '该资源已经存在',
                            data:{resourceId:resourceId}
                        }
					}
				},
				priority : {
					validators : {
                        regexp: {
                            regexp: /^[0-9]+$/,
                            message: '只能是正整数'
                        }
					}
				}
			}
		}).on('success.form.fv', function(e) {
			submitForm();
		});
	}

	//提交表单
	function submitForm(){
		$("body").mask("处理中..");
		var arr = $("#resourceForm").serializeObject();
		arr.enabled = (arr.enabled == 'on');
		SysResourceAction.formResource(arr,function(data){
			$("body").unmask();
			if(data && data.result){
				lhgdialog.alert("操作成功"); 
				parent.getTargetObject().formResourceHandler();
			}else{
				lhgdialog.alert("操作失败,"+data.remark);
			}
		});
	}
	
	//修改前操作
	function preUpdateResource(){
		if(isNotEmpty(resourceId)){
			SysResourceAction.getResource({resourceId:resourceId},function(data){
        		if(data && data.result){
        			$("#resourceForm").fillFormData(data.result);
        		}
        	});
        }
	}
	
    $(function(){
    	initFormValidator.call(this);
        initEvent.call(this);
        preUpdateResource.call(this);
    });
})(jQuery);