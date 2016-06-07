<%--
   Copyright 2015 the original author or phly.
        未经正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 --%>
<%--
   	流程定义管理
   @author linyong
   @since  2015年6月11日 下午3:03:41
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>流程定义管理</title>
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
								<h3>流程定义管理</h3>
								<a class="btn btn-sm btn-primary pull-right" style="margin-top:15px;margin-right:10px;" href="#" id="id_add_processDefinition">新增</a>
							</div>
							<div class="widget-content">
								<table id="processDefinitionGrid" class="display" cellspacing="0" width="100%">
									<thead>
										<tr>
											<th>部署ID</th>
											<th>流程定义ID</th>
											<th>版本</th>
											<th>类别</th>
											<th>流程名称</th>
											<th>key</th>
											<th>部署名称</th>
											<th>部署时间</th>
											<th>是否暂停</th>
											<th>描述</th>
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
		<div class="modal fade" id="pdModel" tabindex="-1" 
		   aria-hidden="true" data-backdrop="false">
		   <div class="modal-dialog">  
		      <div class="modal-content">
		         <div class="modal-header">
		            <button type="button" class="close" 
		               data-dismiss="modal" aria-hidden="true">
		                  &times;
		            </button>
		            <h4 class="modal-title" id="pdTitle"></h4>
		         </div> 
		         <div class="modal-body">
		         	<iframe width="100%" height="420px" frameborder="0" id="pdIframe"></iframe>
		         </div>   
		      </div> 
			</div>
		</div>
		
	</div>
	<!-- 底部版权信息 -->
	<jsp:include page="/page/admin/bottom.jsp" />
	
	<script src="${ctx}/dwr/interface/ActivitiAction.js"></script>
	<script type="text/javascript" src="${ctx}/page/admin/js/activiti/processDefinitionList.js"></script>
	
	<script type="text/javascript">
		/* $(function(){
			//处理表格横向滚动条
			var $datatable_wrapper = $("div.dataTables_wrapper");
			$datatable_wrapper.css({"width":$datatable_wrapper.parent().width(),"margin":"0 auto"});
		}); */
	</script>
</body>
</html>