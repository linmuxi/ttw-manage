;(function($){
	function initEvent(){
		//提交表单
		$("#btn_supplier_submit").click(function(){
			$('#supplierForm').submit();
		});
		
		$("#isHeadPeople").change(function(){
			if($("#isHeadPeople").is(':checked')){
				$("#linkPeopleName").val($("#headPeopleName").val());
				$("#linkPeoplePhone").val($("#headPeoplePhone").val());
				$("#linkPeopleQQ").val($("#headPeopleQQ").val());
				$("#linkPeopleEmail").val($("#headPeopleEmail").val());
			}else{
				$("#linkPeopleName").val('');
				$("#linkPeoplePhone").val('');
				$("#linkPeopleQQ").val('');
				$("#linkPeopleEmail").val('');
			}
		});
		
	}

	// 初始化表单验证器
	function initFormValidator() {
		/*$('#supplierForm').formValidation({
            icon: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {
            	contractCode: {
                    validators: {
                        notEmpty: {
                            message: '合同编号必须填写，不能为空'
                        }
                    }
                }
            }
        }).on('success.form.fv', function(e) {
            submitForm();
        });*/
	
	
		$('#supplierForm').formValidation({
			 icon: {
	                valid: 'glyphicon glyphicon-ok',
	                invalid: 'glyphicon glyphicon-remove',
	                validating: 'glyphicon glyphicon-refresh'
	            },
			fields : {
				contractCode : {
					validators : {
						notEmpty : {
							message : '合同编号必须填写，不能为空'
						},
						stringLength : {
							min : 2,
							max : 50,
							message : '长度必须大于2小于50'
						}
					}
				},
				supName : {
					validators : {
						notEmpty : {
							message : '供应商名称必须填写，不能为空'
						},
						stringLength : {
							min : 2,
							max : 100,
							message : '长度必须大于2小于100'
						}
					}
				},
				supEmail : {
					validators : {
						notEmpty : {
							message : '供应商邮箱必须填写，不能为空'
						},
						stringLength : {
							min : 2,
							max : 50,
							message : '长度必须大于2小于50'
						},
						emailAddress : {
							 	message: '请输入有效的邮箱地址',
					            multiple: 'false'
						}
					}
				},
				supPhone : {
					validators : {
						notEmpty : {
							message : '供应商电话必须填写，不能为空'
						},
						stringLength : {
							min : 2,
							max : 20,
							message : '长度必须大于2小于20'
						}
					}
				},
				supFaxes : {
					validators : {
						stringLength : {
							max : 30,
							message : '长度必须小于30'
						}
					}
				},
				supAddress : {
					validators : {
						notEmpty : {
							message : '供应商地址必须填写，不能为空'
						},
						stringLength : {
							min : 2,
							max : 100,
							message : '长度必须大于2小于100'
						}
					}
				},
				busLicense: {
					validators : {
						notEmpty : {
							message : '供应商营业执照必须填写，不能为空'
						},
						stringLength : {
							min : 2,
							max : 100,
							message : '长度必须大于2小于100'
						}
					}
				},
				bankAddress : {
					validators : {
						notEmpty : {
							message : '银行账户地址必须填写，不能为空'
						},
						stringLength : {
							min : 2,
							max : 100,
							message : '长度必须大于2小于100'
						}
					}
				},
				bankAccountName : {
					validators : {
						notEmpty : {
							message : '银行账户名称必须填写，不能为空'
						},
						stringLength : {
							min : 2,
							max : 50,
							message : '长度必须大于2小于50'
						}
					}
				},
				bankAccountNo : {
					validators : {
						notEmpty : {
							message : '银行账户必须填写，不能为空'
						},
						numeric : {
							message : '银行账户必须为数字'
						},
						stringLength : {
							min : 2,
							max : 25,
							message : '长度必须大于2小于25'
						}
					}
				},
				headPeopleName : {
					validators : {
						notEmpty : {
							message : '负责人姓名必须填写，不能为空'
						},
						stringLength : {
							min : 2,
							max : 30,
							message : '长度必须大于2小于30'
						}
					}
				},
				headPeoplePhone : {
					validators : {
						notEmpty : {
							message : '负责人电话必须填写，不能为空'
						},
						stringLength : {
							min : 2,
							max : 20,
							message : '长度必须大于2小于20'
						},
						phone : {
							 	message: '请填写正确的手机号码',
					            country: 'CN'
						}
					}
				},
				headPeopleQQ : {
					validators : {
						notEmpty : {
							message : '负责人QQ必须填写，不能为空'
						},
						stringLength : {
							min : 2,
							max : 12,
							message : '长度必须大于2小于12'
						}
					}
				},
				headPeopleEmail : {
					validators : {
						notEmpty : {
							message : '负责人邮箱必须填写，不能为空'
						},
						stringLength : {
							min : 2,
							max : 30,
							message : '长度必须大于2小于30'
						}
					}
				},
				headPeopleCardNo : {
					validators : {
						notEmpty : {
							message : '负责人身份证号必须填写，不能为空'
						},
						stringLength : {
							min : 15,
							max : 18,
							message : '长度必须大于等于15小于等于18'
						}/*,
						id : {
							message: '请输入正确的身份证号码',
				            country: 'CN'
						}*/
					}
				},
				linkPeopleName : {
					validators : {
						stringLength : {
							max : 30,
							message : '长度必须小于30'
						}
					}
				},
				linkPeoplePhone : {
					validators : {
						stringLength : {
							max : 20,
							message : '长度必须小于20'
						}
					}
				},
				linkPeopleQQ : {
					validators : {
						stringLength : {
							max : 12,
							message : '长度必须小于12'
						}
					}
				},
				linkPeopleEmail : {
					validators : {
						stringLength : {
							max : 30,
							message : '长度必须小于30'
						}
					}
				},
				cmbPeopleName :  {
					validators : {
						notEmpty : {
							message : '招商负责人必须填写，不能为空'
						},
						stringLength : {
							min : 2,
							max : 30,
							message : '长度必须大于2小于30'
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
		var arr = $("#supplierForm").serializeObject();
		SupplierAction.formSupplier(arr,function(data){
			$("body").unmask();
			if(data && data.result){
				lhgdialog.alert("操作成功"); 
				parent.getTargetObject().formSupplierHandler();
			}else{
				lhgdialog.alert("操作失败,"+data.remark);
			}
		});
	}
	
	function preUpdateSupplier(){
		if(isNotEmpty(supplierId)){
			SupplierAction.getSupplier({supplierId:supplierId},function(data){
	        		if(data && data.sucflag){
	        			var vo = data.bean;
	        			$("#supplierForm").fillFormData(vo);
	        			var htm = "<img id='imgId' src='"+vo.busLicense+"' class='float-left' border='1' alt='供应商营业执照' width='110' height='130' />";
	        			$("#busLicense").val(vo.busLicense);
	        			$("#triggers").append(htm);
	        			
	        			if(vo.supType == 0){
	        				$("input[type=radio][name=supType][value=0]").attr("checked",true);  
	        				$("div[id^='gs_']").hide();
	        			}else{
	        				$("input[type=radio][name=supType][value=1]").attr("checked",true);  
	        			    $("div[id^='gs_']").show();
	        			}
	        			
	        			if(vo.supState == 0){
	        				$("input[type=radio][name=supState][value=0]").attr("checked",true);  
	        			}else{
	        				$("input[type=radio][name=supState][value=1]").attr("checked",true); 
	        			}
	        		}
	        });
	    }
	}
	
    $(function(){
    	initFormValidator.call(this);
        initEvent.call(this);
        preUpdateSupplier.call(this);
    });
    
})(jQuery);