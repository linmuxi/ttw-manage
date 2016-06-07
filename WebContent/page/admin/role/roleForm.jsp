<%--
   Copyright 2015 the original author or phly.
        未经正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 --%>
<%--
   	角色编辑页面
   @author linyong
   @since  2015年5月17日 下午3:04:31
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>角色编辑</title>
<jsp:include page="/page/common/common.jsp"></jsp:include>
<jsp:include page="/page/common/page/bootstrap.jsp"></jsp:include>

</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-lg-12">  
				<form class="form-horizontal" role="form" id="roleForm">
				   <div class="form-group">
			         <input type="hidden" id="roleId" name="roleId" >
				      <label for="firstname" class="col-sm-3 control-label">角色名称：</label>
				      <div class="col-sm-9">
				         <input type="text" class="form-control" id="roleName" name="roleName" 
				            placeholder="请输入名字">
				      </div>
				   </div>
				   <div class="form-group">
				      <label for="lastname" class="col-sm-3 control-label">角色描述：</label>
				      <div class="col-sm-9">
    					 <textarea class="form-control" rows="3" placeholder="请输入描述"
    					 id="roleDesc" name="roleDesc" ></textarea>   
				      </div>
				   </div>
				   <div class="form-group">
				      <div class="col-sm-offset-3 col-sm-9">
				         <div class="checkbox">
				            <label>
				               <input type="checkbox" name="enabled" id="enabled" checked="checked"> 是否可用
				            </label>
				         </div>
				      </div>
				   </div>
				   <div class="form-group text-right">
				      <button class="btn btn-primary" type="button" id="roleFormBtn">提交</button>
				   </div>
				</form>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		var roleId = "${param.roleId}"; 
	</script>
	<script type="text/javascript" src="${ctx}/page/admin/js/role/roleForm.js"></script>
<script src="${ctx}/dwr/interface/SysRoleAction.js"></script>
</body>
</html>