;(function($){
	function initEvent(){
		//提交表单
		$("#authorityFormBtn").click(function(){
			$('#authorityForm').submit();
		});
	}
	
	//初始化表单验证器
	function initFormValidator(){
		$('#authorityForm').formValidation({
            icon: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {
            	authorityName: {
                    validators: {
                        notEmpty: {
                            message: '用户名必须填写，不能为空'
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
		var arr = $("#authorityForm").serializeObject();
		arr.enable = arr.enable == 'on';
		SysAuthorityAction.formAuthority(arr,function(data){
			$("body").unmask();
			if(data && data.result){
				lhgdialog.alert("操作成功"); 
				parent.getTargetObject().formAuthorityHandler();
			}else{
				lhgdialog.alert("操作失败,"+data.remark);
			}
		});
	}
	

	
    $(function(){
    	initFormValidator.call(this);
        initEvent.call(this);
     /*   if(isNotEmpty(authorityId)){
        	SysUserAction.getUser({userId:userId},function(data){
        		if(data && data.sucflag){
        			var vo = data.bean;
        			$('#orgId').multiselect('select', vo.orgId);
        			$("#userName").val(vo.username);
        			$("#account").val(vo.account);
        			$("#enabled").attr("checked",vo.enabled);
        			$("#accountNonExpired").attr("checked",vo.accountNonExpired);
        			$("#accountNonLocked").attr("checked",vo.accountNonLocked);
        			$("#credentialsNonExpired").attr("checked",vo.credentialsNonExpired);
        		}
        	});
        }*/
    });
})(jQuery);