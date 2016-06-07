<%--
   Copyright 2015 the original author or phly.
        未经正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 --%>
<%--
   	供应商编辑页面
   @author wanglong
   @since  2015年5月17日 下午3:04:31
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>供应商编辑</title>
<jsp:include page="/page/common/common.jsp"></jsp:include>
<jsp:include page="/page/common/page/bootstrap.jsp"></jsp:include>
<script type="text/javascript" src="${ctx}/page/common/js/uploader/fileuploader.js"></script>
<script src="${ctx}/dwr/interface/SupplierAction.js"></script>


</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-lg-12">  
				<form class="form-horizontal" role="form" id="supplierForm">
					<input type="hidden" name="supplierId" value="${param.supplierId}"/>
					<input type="hidden" name="supNo" id="supNo"/>
					
			      <div class="col-sm-offset-3 col-sm-9">
			         <div class="radio">
			            <label>
			               <input type="radio" name="supType" id="supType2" value="0" onclick="hideDiv(this)"> 个人
			            </label>
			            <label>
			               <input type="radio" name="supType" id="supType1" value="1" onclick="hideDiv(this)"> 公司
			            </label>
			         </div>
			      </div>
			      
			      	<p class="text-left text-info"></p>
	   				<p class="text-left text-info">基本信息</p>
	   				
                     <div class="form-group">
				      <label for="firstname" class="col-xs-2 control-label text-right">合同编码：</label>
				      <div class="col-xs-10"> 
				        <input type="text" class="form-control" id="contractCode" name="contractCode" placeholder="请输入合同编码">
				      </div>
				   </div>
				   
				   <div class="form-group">
				      <label for="firstname" class="col-xs-2 control-label text-right">供应商名称：</label>
				      <div class="col-xs-4"> 
				        <input type="text" class="form-control" id="supName" name="supName" placeholder="请输入供应商名称">
				      </div>
				      
				      <label for="firstname" class="col-xs-2 control-label text-right">供应商邮箱：</label>
				      <div class="col-xs-4"> 
				        <input type="text" class="form-control" id="supEmail" name="supEmail" >
				      </div>
				   </div>
				   
				   <div class="form-group">
				     
				      
				      <label for="firstname" class="col-xs-2 control-label text-right">供应商电话：</label>
				      <div class="col-xs-4"> 
				        <input type="text" class="form-control" id="supPhone" name="supPhone" >
				      </div>
				      
				      <label for="firstname" class="col-xs-2 control-label text-right">供应商传真：</label>
				      <div class="col-xs-4"> 
				        <input type="text" class="form-control" id="supFaxes" name="supFaxes">
				      </div>
				   </div>
				   
				       <div class="form-group">
				      <label for="firstname" class="col-xs-2 control-label text-right">供应商地址：</label>
				      <div class="col-xs-10"> 
				        <input type="text" class="form-control" id="supAddress" name="supAddress" placeholder="请输入供应商地址">
				      </div>
				   </div>
				   
				   <div class="form-group" id="gs_" style="display: none"><!-- style="display: none" -->
				      <label for="firstname" class="col-xs-2 control-label text-right">供应商营业执照：</label>
				      <div class="col-xs-10"> 
				        <input type="hidden" class="form-control" id="busLicense" name="busLicense" > 
				        <div class="label label-required">供应商营业执照</div>
									<table>
										<tr>
											<td>
												<div id="triggers"></div>
											</td>
										</tr>
										<tr>
											<td>
												<div id="uploadmemberpc"></div>
											</td>
										</tr>
									</table>
				      </div>
				   </div>
	   				
	   				 <p class="text-left text-info">银行信息</p>
				  
				   <div class="form-group">
				      <label for="firstname" class="col-xs-2 control-label text-right">开户行：</label>
				      <div class="col-xs-10"> 
				        <input type="text" class="form-control" id="bankAddress" name="bankAddress" placeholder="请输入开户行地址">
				      </div>
				   </div>
				   
				    <div class="form-group">
				      <label for="firstname" class="col-xs-2 control-label text-right">账户名称：</label>
				      <div class="col-xs-4"> 
				        <input type="text" class="form-control" id="bankAccountName" name="bankAccountName"  placeholder="请输入账户名称">
				      </div>
				      
				      <label for="firstname" class="col-xs-2 control-label text-right">账户：</label>
				      <div class="col-xs-4"> 
				        <input type="text" class="form-control" id="bankAccountNo" name="bankAccountNo" placeholder="请输入账户">
				      </div>
				   </div>
				   
				   <p class="text-left text-info">负责人信息</p>
				   
				   <div class="form-group">
				      <label for="firstname" class="col-xs-2 control-label text-right">姓名：</label>
				      <div class="col-xs-4"> 
				        <input type="text" class="form-control" id="headPeopleName" name="headPeopleName"  placeholder="请输入负责人姓名">
				      </div>
				      
				      <label for="firstname" class="col-xs-2 control-label text-right">手机号码：</label>
				      <div class="col-xs-4"> 
				        <input type="text" class="form-control" id="headPeoplePhone" name="headPeoplePhone" placeholder="请输入负责人手机号码">
				      </div>
				   </div>
				   
				   <div class="form-group">
				      <label for="firstname" class="col-xs-2 control-label text-right">QQ：</label>
				      <div class="col-xs-4"> 
				        <input type="text" class="form-control" id="headPeopleQQ" name="headPeopleQQ"  placeholder="请输入负责人QQ">
				      </div>
				      
				      <label for="firstname" class="col-xs-2 control-label text-right">email：</label>
				      <div class="col-xs-4"> 
				        <input type="text" class="form-control" id="headPeopleEmail" name="headPeopleEmail" placeholder="请输入负责人邮箱">
				      </div>
				   </div>
				   
				   
				   <div class="form-group">
				      <label for="firstname" class="col-xs-2 control-label text-right">身份证：</label>
				      <div class="col-xs-10"> 
				        <input type="text" class="form-control" id="headPeopleCardNo" name="headPeopleCardNo" placeholder="请输入负责人身份证">
				      </div>
				   </div>
				   
				   <p class="text-left text-info">联系人信息</p>
				   
				   
				   <div class="form-group">
				      <label for="isHeadPeople" class="col-xs-2 control-label text-right"></label>
				      <div class="col-xs-10"> 
				         <div class="checkbox">
				            <label>
				             	<input type="checkbox" name="isHeadPeople" id="isHeadPeople"  />同负责人
				            </label>
				         </div>
				      </div>
				   </div>
				   
				   
				    <div class="form-group">
				      <label for="firstname" class="col-xs-2 control-label text-right">姓名：</label>
				      <div class="col-xs-4"> 
				        <input type="text" class="form-control" id="linkPeopleName" name="linkPeopleName"  placeholder="请输入联系人姓名">
				      </div>
				      
				      <label for="firstname" class="col-xs-2 control-label text-right">手机号码：</label>
				      <div class="col-xs-4"> 
				        <input type="text" class="form-control" id="linkPeoplePhone" name="linkPeoplePhone" placeholder="请输入联系人手机号码">
				      </div>
				   </div>
				   
				   <div class="form-group">
				      <label for="firstname" class="col-xs-2 control-label text-right">QQ：</label>
				      <div class="col-xs-4"> 
				        <input type="text" class="form-control" id="linkPeopleQQ" name="linkPeopleQQ"  placeholder="请输入联系人QQ">
				      </div>
				      
				      <label for="firstname" class="col-xs-2 control-label text-right">email：</label>
				      <div class="col-xs-4"> 
				        <input type="text" class="form-control" id="linkPeopleEmail" name="linkPeopleEmail" placeholder="请输入联系人邮箱">
				      </div>
				   </div>
				   
				   
				    <div class="form-group">
				      <label for="firstname" class="col-xs-2 control-label text-right">招商负责人：</label>
				      <div class="col-xs-10"> 
				        <input type="text" class="form-control" id="cmbPeopleName" name="cmbPeopleName" placeholder="请输入招商人姓名">
				      </div>
				   </div>
				   
				    <div class="form-group">
				      <label for="firstname" class="col-xs-2 control-label text-right">状态：</label>
				      <div class="col-xs-10">
				      	<label class="radio-inline">
						  <input type="radio" name="supState" id="supState1" value="0" checked="checked">合作
						</label>
						<label class="radio-inline">
						  <input type="radio" name="supState" id="supState2" value="1"> 中止
						</label>
				      </div>
				   </div>
				   
				    <div class="form-group">
				      <label for="firstname" class="col-xs-2 control-label text-right">备注：</label>
				      <div class="col-xs-10">
    						 <textarea class="form-control" rows="3" placeholder="请输入备注" id="remark" name="remark" ></textarea>   
				   	  </div>
				   </div>
				   
				   <div class="form-group text-right">
				      <button class="btn btn-primary" type="button" id="btn_supplier_submit">提交</button>
				   </div>
				</form>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		var supplierId = "${param.supplierId}"; 
		//默认选中单位版
		$(document).ready(function(){  
			$("input[type=radio][name=supType][value=0]").attr("checked",true);  
		});
		
		function hideDiv(val){
			var value = $(val).val();
			//1：单位版   0:个人版   
			if(value == "0"){
				$("div[id^='gs_']").hide();
			}else{
				$("div[id^='gs_']").show();
			}
		}
	</script>
	<script type="text/javascript" src="${ctx}/page/business/js/supplier/supplierForm.js?21=3"></script>
	<script type="text/javascript">
 		function createUploader(){
			var uploader = new qq.FileUploader({
                 element: document.getElementById('uploadmemberpc'),
                 action: '${ctx}'+'/uploadImg',
                 debug: true,
                 minSizeLimit:1024,
                 sizeLimit: 1073741824,
                 allowedExtensions: ['jpg','png'],
                 onComplete: function(id, fileName, responseJSON){
							var pcpath = responseJSON.success;
							var imgPath = '${ctx}'+pcpath;
							var htm = "<img id='imgId' src='"+imgPath+"' class='float-left' border='1' alt='供应商营业执照' width='110' height='130' />";
							$("#imgId").attr("src",'${ctx}'+pcpath);
							$("#busLicense").val(imgPath);
							$("#triggers").append(htm);
						},
			});
		}
		window.onload = createUploader;
	</script>
</body>
</html>