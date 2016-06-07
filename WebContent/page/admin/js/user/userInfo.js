;(function($){
	//初始化表单验证器
	function initFormValidator(){
		$('#userInfoForm').formValidation({
            icon: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {
            	password: {
                    validators: {
                        notEmpty: {
                            message: '当前密码必须填写，不能为空'
                        },
                        remote: {
                            type: 'POST',
                            url: webRoot+'/page/admin/user/validatePassword',
                            message: '当前密码不对'
                        },
                    }
                },
                newPwd: {
                    validators: {
                        notEmpty: {
                            message: '新密码必须填写，不能为空'
                        },
                        stringLength: {
                            min: 6,
                            max: 30,
                            message: '长度必须大于6小于30'
                        }
                    }
                },
            	surePwd: {
                    validators: {
                        notEmpty: {
                            message: '确认密码必须填写，不能为空'
                        },
                        stringLength: {
                            min: 6,
                            max: 30,
                            message: '长度必须大于6小于30'
                        }
                    }
                }
            }
        }).on('success.form.fv', function(e) {
            if($("#newPwd").val() != $("#surePwd").val()){
            	lhgdialog.alert("密码不一致");
            	e.preventDefault();
            }
        });
	}
	
	$(function(){
    	initFormValidator.call(this);
    });
})(jQuery);