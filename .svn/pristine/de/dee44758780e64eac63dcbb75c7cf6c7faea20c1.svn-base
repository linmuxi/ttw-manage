<%--
   Copyright 2015 the original author or phly.
        未经正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 --%>
<%--
   	部门列表
   @author wanglong
   @since  2015年5月29日 下午3:03:41
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>部门管理</title>
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
								<h3>部门信息查询</h3>
								<a class="btn btn-sm btn-primary pull-right" style="margin-top:15px;margin-right:10px;" href="#" id="id_add_department">新增</a>
							</div>
							<div class="widget-content">
								<table id="departmentList" class="display" cellspacing="0" width="100%">
									<thead>
										<tr>
											<!-- <th>ID</th> -->
											<th>部门名称</th>
											<th>上级部门</th>
											<th>备注</th>
											<!-- <th>是否删除</th> -->
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
	<!-- 底部版权信息 -->
	<jsp:include page="/page/admin/bottom.jsp" />
	
	
	<!-- Modal -->
	<div class="modal fade" id="departmentModel" tabindex="-1" 
	   aria-labelledby="roleForm" aria-hidden="true" data-backdrop="false">
	   <div class="modal-dialog">  
	      <div class="modal-content">
	         <div class="modal-header">
	            <button type="button" class="close" 
	               data-dismiss="modal" aria-hidden="true">
	                  &times;
	            </button>
	            <h4 class="modal-title" id="departmentFormTitle"></h4>
	         </div> 
	         <div class="modal-body">
	         	<iframe width="100%" height="420px" frameborder="0" id="departmentFormIframe"></iframe>
	         </div>   
	      </div> 
		</div>
	</div>
<script src="${ctx}/dwr/interface/SysDepartmentAction.js"></script>
<!-- 部门列表js文件 -->
<script type="text/javascript" src="${ctx}/page/admin/js/department/departmentList.js"></script>
	
	
	
	
	 <!-- 部门编辑 -->
	<!-- <div class="modal fade" id="myModal" tabindex="-1" role="dialog" 
	   aria-labelledby="departmentForm" aria-hidden="true" data-backdrop="false">
	   <div class="modal-dialog">  
	      <div class="modal-content">
	         <div class="modal-header">
	            <button type="button" class="close" 
	               data-dismiss="modal" aria-hidden="true">
	                  &times;
	            </button>
	            <h4 class="modal-title" id="departmentForm"></h4>
	         </div>
	         <div class="modal-body">
	         	<form class="form-horizontal" role="form">
				   <div class="form-group">
				   	<input type="hidden" id="departmentId" name="departmentId"/>
				      <label for="firstname" class="col-sm-3 control-label">部门名称：</label>
				      <div class="col-sm-9">
				         <input type="text" class="form-control" id="orgName" name="orgName" 
				            placeholder="请输入名称">
				      </div>
				   </div>
				   
				   
				
				 <div class="form-group">
				      <label for="lastname" class="col-sm-3 control-label">上级部门：</label>
				      <div class="col-sm-9">
    					 <select id="parent" >
						</select>
				      </div>
				   </div>
				
				   
				   <div class="form-group">
				      <label for="lastname" class="col-sm-3 control-label">备注：</label>
				      <div class="col-sm-9">
    						 <textarea class="form-control" rows="3" placeholder="请输入描述"
    					 id="orgRemark" name="orgRemark" ></textarea>   
				   </div>
				   </div>
			
			 	<div class="form-group">
				      <div class="col-sm-offset-3 col-sm-9">
				         <div class="checkbox">
				            <label>
				               <input type="checkbox" name="isDel" id="isDel" checked="checked"> 是否可用
				            </label>
				         </div>
				      </div>
				   </div>
				</form>
	         </div>
	         <div class="modal-footer">
	            <button type="button" class="btn btn-default" 
	               data-dismiss="modal">关闭
	            </button>
	            <button type="button" class="btn btn-primary" id="btn_department_submit">提交</button>
	         </div>
	      </div>/.modal-content
		</div>/.modal
	</div> -->
</body>
</html>