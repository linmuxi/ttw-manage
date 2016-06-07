<%--
   Copyright 2015 the original author or phly.
        未经正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 --%>
<%--
   	部门列表
   @author wanglong
   @since  2015年5月29日 下午3:03:41
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>部门编辑</title>
<jsp:include page="/page/common/common.jsp"></jsp:include>
<jsp:include page="/page/common/page/bootstrap.jsp"></jsp:include>
<script src="${ctx}/dwr/interface/SysDepartmentAction.js"></script>
</head>
<body>
	<!-- 部门编辑 -->
	<div class="container">
		<div class="row">
			<div class="col-lg-12">  
				<form class="form-horizontal" role="form" id = "departmentForm">
				   <div class="form-group">
				   	<input type="hidden" id="departmentId" name="departmentId"/>
				      <label for="firstname" class="col-sm-3 control-label">部门名称：</label>
				      <div class="col-sm-9">
				         <input type="text" class="form-control" id="orgName" name="orgName" 
				            placeholder="请输入名称">
				      </div>
				   </div>
				   
				   
				
				 <div class="form-group">
				      <label for="lastname" class="col-sm-3 control-label">上级部门：</label>
				      <div class="col-sm-9">
    					 <select id="parent" >
						</select>
				      </div>
				   </div>
				
				   
				   <div class="form-group">
				      <label for="lastname" class="col-sm-3 control-label">备注：</label>
				      <div class="col-sm-9">
    						 <textarea class="form-control" rows="3" placeholder="请输入描述"
    					 id="orgRemark" name="orgRemark" ></textarea>   
				   </div>
				   </div>
			
				   <div class="form-group text-right">
				      <button class="btn btn-primary" type="button" id="departmentFormBtn">提交</button>
				   </div>
				</form>
			</div>
		</div>
	</div>
	
	<!-- <div class="modal fade" id="departmentModel" tabindex="-1" role="dialog" 
	   aria-labelledby="departmentForm" aria-hidden="true" data-backdrop="false">
	   <div class="modal-dialog">  
	      <div class="modal-content">
	         <div class="modal-header">
	            <button type="button" class="close" 
	               data-dismiss="modal" aria-hidden="true">
	                  &times;
	            </button>
	            <h4 class="modal-title" id="departmentFormTitle"></h4>
	         </div>
	         <div class="modal-body">
	         	<form class="form-horizontal" role="form" id = "departmentForm">
				   <div class="form-group">
				   	<input type="hidden" id="departmentId" name="departmentId"/>
				      <label for="firstname" class="col-sm-3 control-label">部门名称：</label>
				      <div class="col-sm-9">
				         <input type="text" class="form-control" id="orgName" name="orgName" 
				            placeholder="请输入名称">
				      </div>
				   </div>
				   
				   
				
				 <div class="form-group">
				      <label for="lastname" class="col-sm-3 control-label">上级部门：</label>
				      <div class="col-sm-9">
    					 <select id="parent" >
						</select>
				      </div>
				   </div>
				
				   
				   <div class="form-group">
				      <label for="lastname" class="col-sm-3 control-label">备注：</label>
				      <div class="col-sm-9">
    						 <textarea class="form-control" rows="3" placeholder="请输入描述"
    					 id="orgRemark" name="orgRemark" ></textarea>   
				   </div>
				   </div>
			
			 	<div class="form-group">
				      <div class="col-sm-offset-3 col-sm-9">
				         <div class="checkbox">
				            <label>
				               <input type="checkbox" name="isDel" id="isDel" checked="checked"> 是否可用
				            </label>
				         </div>
				      </div>
				   </div>
				</form>
	         </div>
	         <div class="modal-footer">
	            <button type="button" class="btn btn-default" 
	               data-dismiss="modal">关闭
	            </button>
	            <button type="button" class="btn btn-primary" id="departmentFormBtn">提交</button>
	         </div>
	      </div>/.modal-content
		</div>/.modal
	</div> -->
	
	<script type="text/javascript">
		var departmentId = "${param.departmentId}"; 
	</script>
	<script type="text/javascript" src="${ctx}/page/admin/js/department/departmentForm.js"></script>
</body>
</html>