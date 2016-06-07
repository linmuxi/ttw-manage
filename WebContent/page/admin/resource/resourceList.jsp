<%--
   Copyright 2015 the original author or phly.
        未经正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 --%>
<%--
   	资源列表
   @author wanglong
   @since  2015年5月24日 下午3:03:41
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>资源管理</title>
<jsp:include page="/page/common/common.jsp"></jsp:include>
<jsp:include page="/page/common/js/thin/common/bootstrap.jsp"></jsp:include>

</head>
<body>

	<!-- 头部内容 -->
	<jsp:include page="/page/admin/top_new.jsp" />
	
	<div class="wrapper">
		<!-- 左边导航 -->
		<jsp:include page="/page/admin/left.jsp" />
		<!-- 左边导航 end -->
		
		<!-- 右边内容区域 -->
		<div class="page-content">
			<div class="content container">
				<div class="row">
					<div class="col-lg-12">
						<div class="widget">
							<div class="widget-header">
								<i class="icon-table"></i>
								<h3>资源信息查询</h3>
								<a class="btn btn-sm btn-primary pull-right" style="margin-top:15px;margin-right:10px;" href="#" id="id_add_resource">新增</a>
							</div>
							<div class="widget-content">
								<table id="resourceList" class="display" cellspacing="0">
									<thead>
										<tr>
											<th>ID</th>
											<th>资源类型</th>
											<th>资源名称</th>
											<th>资源描述</th>
											<th>资源路径</th>
											<th>优先级</th>
											<th>是否可用</th>
											<!-- <th>所属模块</th>
											<th>最后修改时间</th> -->
											<th>操作</th>
										</tr>
									</thead>
									<tbody>
									</tbody>
								</table>
							</div>
						</div>
					</div> 
				</div>
			</div>
		</div>
		<!-- 右边内容区域 end -->	
		
		<!-- 操作 -->
		<div class="modal fade" id="resourceOperation" tabindex="-1" 
		   aria-hidden="true" data-backdrop="false">
		   <div class="modal-dialog">  
		      <div class="modal-content">
		         <div class="modal-header">
		            <button type="button" class="close" 
		               data-dismiss="modal" aria-hidden="true">
		                  &times;
		            </button>
		            <h4 class="modal-title" id="resourceOperationTitle"></h4>
		         </div> 
		         <div class="modal-body">
		         	<iframe width="100%" height="100%" frameborder="0" id="resourceOperationIframe"></iframe>
		         </div>   
		      </div> 
			</div>
		</div>
	
	</div>
	<!-- 底部版权信息 -->
	<jsp:include page="/page/admin/bottom.jsp" />

	<script src="${ctx}/dwr/interface/SysResourceAction.js"></script>	
	<script type="text/javascript" src="${pageContext.request.contextPath}/page/admin/js/resource/resourceList.js"></script>
</body>
</html>