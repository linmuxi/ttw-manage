<%--
   Copyright 2015 the original author or phly.
        未经正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 --%>
<%--
   	我的待办任务列表
   @author linyong
   @since  2015年6月11日 下午3:03:41
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我的待办任务列表</title>
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
								<h3>我的待办列表</h3>
							</div>
							<div class="widget-content">
								<table id="myTaskGrid" class="display" cellspacing="0" width="100%">
									<thead> 
										<tr>
											<th>任务ID</th>
											<th>任务名称</th>
											<th>流程名称</th>
											<th>优先级</th>
											<th>创建时间</th>
											<th>失效日期</th>
											<th>描述</th>
											<th>操作</th>
											<th>业务表单主键ID</th>
											<th>业务表单URL</th>
											<th>流程定义id</th>
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
		<div class="modal fade" id="taskModel" tabindex="-1" 
		   aria-hidden="true" data-backdrop="false">
		   <div class="modal-dialog">  
		      <div class="modal-content">
		         <div class="modal-header">
		            <button type="button" class="close" 
		               data-dismiss="modal" aria-hidden="true">
		                  &times;
		            </button>
		            <h4 class="modal-title" id="taskTitle"></h4>
		         </div> 
		         <div class="modal-body">
		         	<iframe width="100%" height="100%" frameborder="0" id="taskIframe"></iframe>
		         </div>   
		      </div> 
			</div>
		</div>
		
	</div>
	<!-- 底部版权信息 -->
	<jsp:include page="/page/admin/bottom.jsp" />
	
	<script type="text/javascript" src="${ctx}/page/admin/js/activiti/taskList.js"></script>
</body>
</html>