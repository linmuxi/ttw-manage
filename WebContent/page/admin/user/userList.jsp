<%--
   Copyright 2015 the original author or phly.
        未经正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 --%>
<%--
   	用户列表
   @author linyong
   @since  2015年5月17日 下午3:03:41
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户管理</title>
<jsp:include page="/page/common/common.jsp"></jsp:include>
<jsp:include page="/page/common/js/thin/common/bootstrap.jsp"></jsp:include>
<style type="text/css">
	div.dataTables_wrapper {
        width: 900px;        
        margin: 0 auto; 
    }
</style>
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
				<div class="col-xs-2">
					<ul id="departMentTree" class="ztree"></ul>
				</div>
					<div class="col-lg-12">
						<div class="widget">
							<div class="widget-header">
								<i class="icon-table"></i>
								<h3>用户信息查询</h3>
								<a class="btn btn-sm btn-primary pull-right" style="margin-top:15px;margin-right:10px;" href="#" id="id_add_user">新增</a>
							</div>
							<div class="widget-content">
								<table id="userList" class="display" cellspacing="0" width="100%">
									<thead>
										<tr>
											<th>用户名称</th>
											<th>帐号</th>
											<th>最后登录IP</th>
											<th>最后登录日期</th>
											<th>所属部门名称</th>
											<th>可用</th>
											<th>未过期</th>
											<th>未锁定</th>
											<th>未失效</th>
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
	<!-- 底部版权信息 -->
	<jsp:include page="/page/admin/bottom.jsp" />
	
	<!-- Modal -->
	<div class="modal fade" id="userModel" tabindex="-1" 
	   aria-labelledby="roleForm" aria-hidden="true" data-backdrop="false">
	   <div class="modal-dialog">  
	      <div class="modal-content">
	         <div class="modal-header">
	            <button type="button" class="close" 
	               data-dismiss="modal" aria-hidden="true">
	                  &times;
	            </button>
	            <h4 class="modal-title" id="userFormTitle"></h4>
	         </div> 
	         <div class="modal-body">
	         	<iframe width="100%" height="420px" frameborder="0" id="userFormIframe"></iframe>
	         </div>   
	      </div> 
		</div>
	</div>
	<script src="${ctx}/dwr/interface/SysUserAction.js"></script>
	<script type="text/javascript" src="${ctx}/page/admin/js/user/userList.js?1=233"></script>
</body>
</html>