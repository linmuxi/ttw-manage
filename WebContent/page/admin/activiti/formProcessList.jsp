<%--
   Copyright 2015 the original author or phly.
        未经正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 --%>
<%--
   	业务表单流程配置列表
   @author linyong
   @since  2015年6月11日 下午3:03:41
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>业务表单流程配置列表</title>
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
								<h3>业务表单流程配置</h3>
								<a class="btn btn-sm btn-primary pull-right" style="margin-top:15px;margin-right:10px;" href="#" id="id_add_formProcess">新增</a>
							</div>
							<div class="widget-content">
								<table id="formProcessGrid" class="display" cellspacing="0" width="100%">
									<thead>
										<tr>
											<th>ID</th>
											<th>业务表单名称</th>
											<th>流程定义名称</th>
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
		
		<!-- Modal -->
		<div class="modal fade" id="fpModel" tabindex="-1" 
		   aria-hidden="true" data-backdrop="false">
		   <div class="modal-dialog">  
		      <div class="modal-content">
		         <div class="modal-header">
		            <button type="button" class="close" 
		               data-dismiss="modal" aria-hidden="true">
		                  &times;
		            </button>
		            <h4 class="modal-title" id="fpTitle"></h4>
		         </div> 
		         <div class="modal-body">
		         	<iframe width="100%" height="100%" frameborder="0" id="fpIframe"></iframe>
		         </div>   
		      </div> 
			</div>
		</div>
		
	</div>
	<!-- 底部版权信息 -->
	<jsp:include page="/page/admin/bottom.jsp" />
	
	<script type="text/javascript" src="${ctx}/page/admin/js/activiti/formProcessList.js"></script>
	<script src="${ctx}/dwr/interface/FormProcessAction.js"></script>
</body>
</html>