;(function($){
	function initEvent(){
		//提交表单
		$("#roleFormBtn").click(function(){
			$('#roleForm').submit();
		});
	}
	
	//初始化表单验证器
	function initFormValidator(){
		$('#roleForm').formValidation({
            icon: formValidation_icon,
            fields: {
                roleName: {
                    validators: {
                        notEmpty: {
                            message: '角色名称必须填写，不能为空'
                        },
                        stringLength: {
                            min: 2,
                            max: 30,
                            message: '长度必须大于2小于30'
                        },
                        remote: {
                            type: 'POST',
                            url: webRoot+'/page/admin/role/getRoleNameExists',
                            message: '该角色名称已经存在',
                            data:{roleId:roleId}
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
		var arr = $("#roleForm").serializeObject();
		arr.enabled = (arr.enabled == 'on');
		SysRoleAction.formRole(arr,function(data){
			$("body").unmask();
			if(data && data.result){
				lhgdialog.alert("操作成功"); 
				parent.getTargetObject().formRoleHandler();
			}else{
				lhgdialog.alert("操作失败,"+data.remark);
			}
		});
	}
	
	//修改前操作
	function preUpdateRole(){
		if(isNotEmpty(roleId)){
			SysRoleAction.getRole({roleId:roleId},function(data){
        		if(data && data.result){
        			$("#roleForm").fillFormData(data.result);
        		}
        	});
        }
	}
	
    $(function(){
    	initFormValidator.call(this);
        initEvent.call(this);
        preUpdateRole.call(this);
    });
})(jQuery);