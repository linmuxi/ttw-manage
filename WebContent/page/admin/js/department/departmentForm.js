;(function($){
	function initEvent(){
		//提交表单
		$("#departmentFormBtn").click(function(){
			$('#departmentForm').submit();
		});
	}
	
	//初始化表单验证器
	function initFormValidator(){
		$('#departmentForm').formValidation({
            icon: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {
            	orgName: {
                    validators: {
                        notEmpty: {
                            message: '部门名称必须填写，不能为空'
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
		var arr = $("#departmentForm").serializeObject();
		arr.parentId = $("#parent").val();
		SysDepartmentAction.formDepartment(arr,function(data){
			$("body").unmask();
			if(data && data.result){
				lhgdialog.alert("操作成功"); 
				parent.getTargetObject().formDepartmentHandler();
			}else{
				lhgdialog.alert("操作失败,"+data.remark);
			}
		});
	}
	
	//初始化部门下拉框数据 
	function initDepartMentDS(){
		 $('#parent').multiselect('dataprovider', getDepartMentDS());
	}
	
	function getDepartMentDS(){
		var ds = [];
		$.ajaxSetup({   
            async : false  
        });
		$.post(webRoot+"/page/admin/department/queryAllDepartment",{pageNo:1,pageSize:65535},function(data){
			if(data && data.length>0){
				$(data).each(function(i,obj){
					ds.push({label:obj.orgName,value:obj.departmentId});
				});
			}
		});
	    return ds;
	 }
	
    $(function(){
    	initFormValidator.call(this);
        initEvent.call(this);
        initDepartMentDS.call(this);
   
        if(isNotEmpty(departmentId)){
        	SysDepartmentAction.getDepartment({departmentId:departmentId},function(data){
        		if(data && data.sucflag){
        			var vo = data.bean;
        			$("#departmentId").val(departmentId);
        			$("#orgName").val(vo.orgName);
        			$('#parent').multiselect('select', vo.parentId);
        			$("#orgRemark").val(vo.orgRemark);
        		}
        	});
        }
    });
})(jQuery);