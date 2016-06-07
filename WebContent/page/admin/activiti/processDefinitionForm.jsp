<%--
   Copyright 2015 the original author or phly.
        未经正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 --%>
<%--
   	流程编辑页面
   @author linyong
   @since  2015年6月11日 下午3:04:31
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>流程编辑页面</title>
<jsp:include page="/page/common/common.jsp"></jsp:include>
<jsp:include page="/page/common/page/bootstrap.jsp"></jsp:include>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<form class="form-horizontal" role="form" id="pdForm" action="${ctx}/page/admin/activiti/deploy" method="post" enctype="multipart/form-data">
				   <div class="form-group">
				      <label for="parent" class="col-xs-3 control-label text-right">部署名称：</label>
				      <div class="col-xs-9">
				      	<input type="text" name="name" id="name" />
				      </div>
				   </div>
				   <div class="form-group">
				      <label for="parent" class="col-xs-3 control-label text-right">流程文件：</label>
				      <div class="col-xs-9">
				      	<input type="file" name="processFile" id="processFile" />
				      </div>
				   </div>
				   <div class="form-group text-right">
				      <button class="btn btn-primary" type="submit" id="pdFormBtn">提交</button>
				   </div>
				</form>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="${ctx}/page/admin/js/activiti/processDefinitionForm.js"></script>
</body>
</html>