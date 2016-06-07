<%--
   Copyright 2015 the original author or phly.
        未经正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 --%>
<%--
   	权限编辑
   @author wanglong
   @since  2015年7月7日 下午3:03:41
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>权限编辑</title>
<jsp:include page="/page/common/common.jsp"></jsp:include>
<jsp:include page="/page/common/page/bootstrap.jsp"></jsp:include>
<script src="${ctx}/dwr/interface/SysAuthorityAction.js"></script>
</head>
<body>
	<!-- 权限编辑 -->
	<div class="container">
		<div class="row">
			<div class="col-lg-12">  
				<form class="form-horizontal" role="form" id = "authorityForm">
				   <div class="form-group">
				   	<input type="hidden" id="authorityId" name="authorityId"/>
				      <label for="firstname" class="col-sm-3 control-label">权限标识：</label>
				      <div class="col-sm-9">
				         <input type="text" class="form-control" id="authorityMark" name="authorityMark" 
				            placeholder="请输入权限标识">
				      </div>
				   </div>
				   
				   
				
				   <div class="form-group">
				      <label for="lastname" class="col-sm-3 control-label">权限名称：</label>
				      <div class="col-sm-9">
    						 <input type="text" class="form-control"  placeholder="请输入权限名称"
    					 id="authorityName" name="authorityName" ></input>   
				   	</div>
				   </div>
				   
				   <div class="form-group">
				      <label for="lastname" class="col-sm-3 control-label">提示信息：</label>
				      <div class="col-sm-9">
    						 <input type="text" class="form-control"  placeholder="请输入提示信息"
    					 id="message" name="message" ></input>   
				   	</div>
				   </div>
				
				   
				   <div class="form-group">
				      <label for="lastname" class="col-sm-3 control-label">权限说明：</label>
				      <div class="col-sm-9">
    						 <textarea class="form-control" rows="3" placeholder="请输入权限说明"
    					 id="authorityDesc" name="authorityDesc" ></textarea>   
				   	</div>
				   </div>
			
			 	<div class="form-group">
				      <div class="col-sm-offset-3 col-sm-9">
				         <div class="checkbox">
				            <label>
				               <input type="checkbox" name="enable" id="enable" checked="checked"> 是否可用
				            </label>
				         </div>
				      </div>
				   </div>
				    <div class="form-group text-right">
				      <button class="btn btn-primary" type="button" id="authorityFormBtn">提交</button>
				   </div>
				</form>
			</div>
		</div>
	</div>
	
	<script type="text/javascript">
		var authorityId = "${param.authorityId}"; 
	</script>
	<script type="text/javascript" src="${ctx}/page/admin/js/authority/authorityForm.js"></script>
</body>
</html>