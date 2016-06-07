<%--
   Copyright 2015 the original author or phly.
        未经正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 --%>
<%--
   	资源编辑页面
   @author linyong
   @since  2015年5月17日 下午3:04:31
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>资源编辑</title>
<jsp:include page="/page/common/common.jsp"></jsp:include>
<jsp:include page="/page/common/page/bootstrap.jsp"></jsp:include>

</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-lg-12">  
				<form class="form-horizontal" role="form" id="resourceForm">
				   <div class="form-group">
			         <input type="hidden" id="resourceId" name="resourceId" >
				      <label for="resourceName" class="col-xs-3 control-label text-right">资源名称：</label>
				      <div class="col-xs-9">
				         <input type="text" class="form-control" id="resourceName" name="resourceName" 
				            placeholder="请输入名称">
				      </div>
				   </div>
				   
				  <div class="form-group">
				      <label for="resourceType" class="col-xs-3 control-label text-right">资源类型：</label>
				      <div class="col-xs-9">
				      	<label class="radio-inline">
						  <input type="radio" name="resourceType" id="resourceType1" value="1" checked="checked">URL
						</label>
						<label class="radio-inline">
						  <input type="radio" name="resourceType" id="resourceType2" value="2">METHOD
						</label>
				      </div>
				   </div>
				   
				  <div class="form-group">
				      <label for="resourcePath" class="col-xs-3 control-label text-right">资源路径：</label>
				      <div class="col-xs-9">
				         <input type="text" class="form-control" id="resourcePath" name="resourcePath" 
				            placeholder="请输入资源路径">
				      </div>
				   </div>
				   
				  <div class="form-group">
				      <label for="priority" class="col-xs-3 control-label text-right">优先级：</label>
				      <div class="col-xs-9">
				         <input type="text" class="form-control" id="priority" name="priority" 
				            placeholder="请输入优先级">
				      </div>
				   </div>
				    <!-- <div class="form-group">
				      <label for="parent" class="col-xs-3 control-label text-right">所属模块：</label>
				      <div class="col-xs-9">
				        <select id="parent" name="parent"></select>
				      </div>
				   </div> -->
				   
				   <div class="form-group">
				      <label for="lastname" class="col-xs-3 control-label text-right">资源描述：</label>
				      <div class="col-xs-9">
    					 <textarea class="form-control" rows="3" placeholder="请输入描述"
    					 id="resourceDesc" name="resourceDesc" ></textarea>   
				      </div>
				   </div>
				   
				   <div class="form-group">
				      <div class="col-xs-3"></div>
				      <div class="col-xs-9">
				         <div class="checkbox">
				            <label>
				               <input type="checkbox" name="enabled" id="enabled" checked="checked"> 是否可用
				            </label>
				         </div>
				      </div>
				   </div>
				   <div class="form-group text-right">
				      <button class="btn btn-primary" type="button" id="resourceFormBtn">提交</button>
				   </div>
				</form>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		var resourceId = "${param.resourceId}"; 
	</script>
	<script type="text/javascript" src="${ctx}/page/admin/js/resource/resourceForm.js"></script>
<script src="${ctx}/dwr/interface/SysResourceAction.js"></script>
</body>
</html>