;(function($){
	function initEvent(){
		//提交表单
		$("#moduleFormBtn").click(function(){
			$('#moduleForm').submit();
		});
	}
	
	//初始化表单验证器
	function initFormValidator(){
		$('#moduleForm').formValidation({
            icon: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {
            	moduleName: {
                    validators: {
                        notEmpty: {
                            message: '模块名称必须填写，不能为空'
                        }
                    }
                },
                priority: {
                    validators: {
                        notEmpty: {
                            message: '优先级必须填写，不能为空'
                        },
                        regexp: {
                            regexp: /^[0-9]+$/,
                            message: '只能是正整数'
                        },
                        stringLength: {
                            min: 1,
                            max: 3,
                            message: '长度必须大于1小于3'
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
		var arr = $("#moduleForm").serializeObject();
		arr.enable = (arr.enable == 'on')?1:0;
		//arr.parent = (arr.moduleType == 1?"-1":arr.parent);
		SysModuleAction.formModule(arr,function(data){
			$("body").unmask();
			if(data && data.result){
				lhgdialog.tips('操作成功');
				parent.getTargetObject().formHandler();
			}else{
				lhgdialog.tips('操作失败'+data.remark);
			}
		});
	}
	
	//初始化模块下拉框数据 
	function initModuleDS(){
		 $('#parent').multiselect('dataprovider', getModuleDS());
	}
	
	function getModuleDS(){ 
		var ds = [];
		$.ajaxSetup({   
            async : false  
        });
		$.post(webRoot+"/page/admin/module/queryAllModule",{pageNo:1,pageSize:65535,moduleType:1,sortFieldName:"priority",sortType:"DESC",parent:"-1"},function(data){
			if(data && data.length>0){
				ds.push({label:"根节点",value:"-1"});
				$(data).each(function(i,obj){
					//ds.push({label:'-'+obj.moduleName.replace(/\s/g,''),value:obj.moduleId});
					ds.push({label:obj.moduleName,value:obj.moduleId});
				});
			}
		});
	    return ds;
	 }
	
	function preUpdate(){
		if(isNotEmpty(moduleId)){
        	SysModuleAction.getModule({moduleId:moduleId},function(data){
        		if(data && data.sucflag){
        			var vo = data.bean;
        			if(vo.enable){
        				$("#enable").attr("checked","");
        			}else{
        				$("#enable").removeAttr("checked");
        			}
        			$("#moduleForm").fillFormData(vo);
        		}
        	});
        }
	}
	
    $(function(){
    	initFormValidator.call(this);
        initEvent.call(this);
        initModuleDS.call(this);
        preUpdate.call(this);
    });
})(jQuery);