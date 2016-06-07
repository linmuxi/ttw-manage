;(function($){
	function initEvent(){
		$("#bussniessIframe").resizeIframe({height:80}); 
		
		//提交表单
		$("#approvalFormBtn").click(function(){
			$('#approvalForm').submit();
		});
		
		$("#goBack").click(goTaskList);
	}
	
	function goTaskList(){
		toPage("/page/admin/activiti/taskList.jsp");
	}
	
	//初始化表单验证器
	function initFormValidator(){
		$('#approvalForm').formValidation({
            icon: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {
            	approved: {
                    validators: {
                        notEmpty: {
                            message: '请选择是否同意'
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
		//任务id、审批信息、业务表单信息
		var param = $.extend({id:taskId},{vars:$.extend($("#approvalForm").serializeObject(),
				bussniessIframe.contentWindow.getFormData())});
		ActivitiAction.completeTask(param,function(data){
			if(data){
				lhgdialog.alert("审批成功");
				goTaskList();
			}else{
				lhgdialog.alert("审批失败");
			}
		});
	}
	
    $(function(){
    	initFormValidator.call(this);
        initEvent.call(this);
    });
})(jQuery);