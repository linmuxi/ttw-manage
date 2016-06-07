<%--
   Copyright 2015 the original author or phly.
        未经正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 --%>
<%--
   	用户信息
   @author linyong
   @since  2015年5月17日 下午3:04:31
--%>
<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户信息</title>
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
				<div class="col-xs-2">
					<ul id="departMentTree" class="ztree"></ul>
				</div>
					<div class="col-lg-12">
						<div class="widget">
							<div class="widget-header">
								<i class="icon-table"></i>
								<h3>个人信息</h3>
							</div>
							<div class="widget-content">
								<div class="body">
					                <form action="${ctx}/page/admin/user/updatePassword" method="post" novalidate class="form-horizontal label-left" id="userInfoForm">
					                  <input type="hidden" name="userId" value="${SPRING_SECURITY_CONTEXT.authentication.principal.userId}"/>
					                  <input type="hidden" name="account" value="${SPRING_SECURITY_CONTEXT.authentication.principal.account}"/>
					                  <div class="row">
					                    <div class="col-md-4">
					                      <div class="text-align-center"> 
					                      	<img style="height: 112px;" alt="64x64" src="${ctx}/page/common/js/thin/images/default_header.jpg" class="img-circle"> 
					                      </div>
					                    </div>
					                    <div class="col-md-8">
					                      <h3 class="no-margin">${SPRING_SECURITY_CONTEXT.authentication.principal.username}</h3>
					                      <address>
						                      <strong>${SPRING_SECURITY_CONTEXT.authentication.principal.account}</strong><br>
						                      <abbr title="工作邮箱">邮箱:</abbr> <a href="mailto:#">ttw@phly.com</a><br>
						                      <abbr title="工作电话">电话:</abbr> 18646445754
					                      </address>
					                    </div>
					                  </div>
					                  
					                  <fieldset>
					                    <legend class="section">密码修改</legend>
					                    <div class="control-group">
					                    	<div class="col-md-9 col-md-offset-3">
					                    		<%=URLDecoder.decode((request.getParameter("message") != null ?request.getParameter("message") : ""), "UTF-8") %>
					                    	</div>
					                    </div>
					                    <div class="control-group">
					                    <div class="col-md-3">
					                      <label for="currentPwd" class="control-label">当前密码</label>
					                     </div>
					                      <div class="col-md-9">
					                      <div class="form-group">
					                        <input type="password" class="col-sm-6 col-xs-12" name="password" id="password">
					                      </div>
					                      </div>
					                    </div>
					                    <div class="control-group">
					                    <div class="col-md-3">
					                      <label for="newPwd" class="control-label">新密码</label>
					                      </div>
					                      <div class="col-md-9">
					                      <div class="form-group">
					                        <input type="password" class="col-sm-6 col-xs-12" name="newPwd" id="newPwd">
					                      </div>
					                      </div>
					                    </div>
					                    <div class="control-group">
					                    <div class="col-md-3">
					                      <label for="password" class="control-label">确认密码</label>
					                      </div>
					                      <div class="col-md-9">
					                      <div class="form-group">
					                        <input type="password" class="col-sm-6 col-xs-12" name="surePwd" id="surePwd">
					                      </div>
					                      </div>
					                    </div>
					                  </fieldset>
					                  <div class="form-actions">
					                    <button class="btn btn-primary" type="submit">提交</button>
					                  </div>	
					                  <%--
					                  <fieldset>
					                    <legend class="section">联系信息</legend>
					                    <div class="control-group">
					                    <div class="col-md-3">
					                      <label class="control-label" for="email" id="email-label">Email <span class="required">*</span></label>
					                      </div>
					                      <div class="col-md-9">
					                      <div class="form-group">
					                        <div class="col-xs-12 col-sm-8">
					                          <div class="input-group">
					                            <input type="email" name="email" class="form-control parsley-validated" required data-trigger="change" id="email">
					                            <span class="input-group-btn">
					                            <button type="button" class="btn btn-success">Write an email</button>
					                            </span> 
					                            </div>
					                            </div>
					                        </div>
					                      </div>
					                    </div>
					                    <div class="control-group">
					                    <div class="col-md-3">
					                      <label class="control-label" for="phone">Phone <span class="required">*</span></label>
					                      </div>
					                      <div class="col-md-9">
					                      <div class="form-group">
					                        <div class="col-xs-12 col-sm-8">
					                          <div class="input-group">
					                            <input type="text" maxlength="28" name="phone" required class="form-control  mask parsley-validated" id="phone">
					                            <span class="input-group-btn">
					                            <select data-style="btn-default" class="selectpicker" id="phone-type" style="display: none;">
					                              <option>Mobile</option>
					                              <option>Home</option>
					                              <option>Work</option>
					                            </select>
					                            <div class="btn-group bootstrap-select">
					                              <button data-toggle="dropdown" class="btn dropdown-toggle clearfix btn-default" id="phone-type"><span class="filter-option">Mobile</span>&nbsp;<i class="icon-caret-down"></i></button>
					                              <ul role="menu" class="dropdown-menu" style="overflow-y: auto; min-height: 60px; max-height: 14.75px;">
					                                <li rel="0"><a class="" href="#" tabindex="-1">Mobile</a></li>
					                                <li rel="1"><a class="" href="#" tabindex="-1">Home</a></li>
					                                <li rel="2"><a class="" href="#" tabindex="-1">Work</a></li>
					                              </ul>
					                            </div>
					                            </span> </div>
					                        </div>
					                      </div>
					                      </div>
					                    </div>
					                    <div class="control-group">
					                    <div class="col-md-3">
					                      <label class="control-label" for="fax">Fax</label>
					                      </div>
					                      <div class="col-md-9">
					                      <div class="form-group">
					                        <div class="col-xs-12 col-sm-8">
					                          <div class="input-group">
					                            <input type="text" maxlength="28" name="phone" class="form-control" id="fax">
					                            <span class="input-group-btn">
					                            <select data-style="btn-default" class="selectpicker" id="fax-type" style="display: none;">
					                              <option>Mobile</option>
					                              <option>Home</option>
					                              <option>Work</option>
					                            </select>
					                            <div class="btn-group bootstrap-select">
					                              <button data-toggle="dropdown" class="btn dropdown-toggle clearfix btn-default" id="fax-type"><span class="filter-option">Mobile</span>&nbsp;<i class="icon-caret-down"></i></button>
					                              <ul role="menu" class="dropdown-menu" style="overflow-y: auto; min-height: 60px; max-height: 48.75px;">
					                                <li rel="0"><a class="" href="#" tabindex="-1">Mobile</a></li>
					                                <li rel="1"><a class="" href="#" tabindex="-1">Home</a></li>
					                                <li rel="2"><a class="" href="#" tabindex="-1">Work</a></li>
					                              </ul>
					                            </div>
					                            </span> </div>
					                            </div>
					                        </div>
					                      </div>
					                    </div>
					                  </fieldset>
					                  <div class="form-actions">
					                    <button class="btn btn-primary" type="submit">Validate &amp; Submit</button>
					                    <button class="btn btn-default" type="button">Cancel</button>
					                  </div>	
					              	 --%>
					               
					                </form>
					              </div>							
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
	
	<script type="text/javascript" src="${ctx}/page/admin/js/user/userInfo.js"></script>
	<script src="${ctx}/dwr/interface/SysUserAction.js"></script>
</body>
</html>