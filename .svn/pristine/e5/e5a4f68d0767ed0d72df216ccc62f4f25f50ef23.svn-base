<%--
   Copyright 2015 the original author or phly.
        未经正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 --%>
<%--
   	权限列表
   @author wanglong
   @since  2015年6月19日 下午3:03:41
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>权限管理</title>
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
								<h3>权限信息查询</h3>
								<a class="btn btn-sm btn-primary pull-right" style="margin-top:15px;margin-right:10px;" href="#" id="id_add_authority">新增</a>
							</div>
							<div class="widget-content">
								<table id="authorityList" class="display" cellspacing="0" width="100%">
									<thead>
										<tr>
											<th>权限标识</th>
											<th>权限名称</th>
											<th>权限说明</th>
											<th>提示信息</th>
											<th>是否可用</th>
											<th>最后修改时间</th>
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
	</div>


	<!-- <div class="container">
		<div class="row">
			<div class="table-responsive">
				<table id="authorityGrid" class="table table-condensed table-hover table-striped" >
				    <thead>
				        <tr>
				            <th data-column-id="authorityId" style="width: 300px;background-color: red;">权限ID</th>  
				           	<th data-column-id="authorityMark">权限标识</th>
				           	<th data-column-id="authorityName">权限名称</th>
				            <th data-column-id="authorityDesc">权限说明</th>
				            <th data-column-id="message">提示信息</th>
				            <th data-column-id="enable" data-formatter="enable">是否可用</th>
				            <th data-column-id="lastUpdateDate"  data-formatter="dateFormat">最后修改时间</th>
         				    <th data-column-id="commands" data-formatter="commands" data-sortable="false">操作</th>
				        </tr>
				    </thead>     
				</table>
			</div>
		</div>
	</div> -->
	
	<!-- Authority编辑 -->
	<div class="modal fade" id="authorityModel" tabindex="-1" 
	   aria-labelledby="roleForm" aria-hidden="true" data-backdrop="false">
	   <div class="modal-dialog">  
	      <div class="modal-content">
	         <div class="modal-header">
	            <button type="button" class="close" 
	               data-dismiss="modal" aria-hidden="true">
	                  &times;
	            </button>
	            <h4 class="modal-title" id="authorityTitle"></h4>
	         </div> 
	         <div class="modal-body">
	         	<iframe width="100%" height="420px" frameborder="0" id="authorityFormIframe"></iframe>
	         </div>   
	      </div> 
		</div>
	</div>
	
	<!-- 权限资源操作 -->
	<div class="modal fade" id="resourceAuth" tabindex="-1" 
	   aria-hidden="true" data-backdrop="false">
	   <div class="modal-dialog">  
	      <div class="modal-content">
	         <div class="modal-header">
	            <button type="button" class="close" 
	               data-dismiss="modal" aria-hidden="true">
	                  &times;
	            </button>
	            <h4 class="modal-title" id="resourceAuthTitle"></h4>
	         </div> 
	         <div class="modal-body">
	         	<iframe width="100%" height="420px" frameborder="0" id="resourceAuthIframe"></iframe>
	         </div>   
	      </div> 
		</div>
	</div>

<!-- 底部版权信息 -->
<jsp:include page="/page/admin/bottom.jsp" />
	
<!-- 部门列表js文件 -->
<script src="${ctx}/dwr/interface/SysAuthorityAction.js"></script>
<script type="text/javascript" src="${ctx}/page/admin/js/authority/authorityList.js"></script>
</body>
</html>