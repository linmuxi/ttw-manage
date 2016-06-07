<%--
   Copyright 2015 the original author or phly.
        未经正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 --%>
<%--
      后台登录
   @author linyong
   @since  2015年5月22日 下午11:12:33
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>后台登录</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<jsp:include page="/page/common/common.jsp"></jsp:include>
<jsp:include page="/page/common/js/thin/common/bootstrap.jsp"></jsp:include>
</head>
<body>
	<div class="login-logo">
		<img src="${ctx}/page/common/js/thin/images/logo.png" width="200" height="50">
	</div>
	<div class="widget">
		<div class="login-content">
			<div class="widget-content" style="padding-bottom: 0;">
				<form id="loginForm" class="form-horizontal">
					<h3 class="form-title">欢迎您</h3>
					<fieldset>
						<div class="form-group no-margin">
							<label for="email">帐号</label>
							<div class="input-group input-group-lg">
								<span class="input-group-addon"> <i class="icon-user"></i>
								</span> <input type="text" placeholder="请输入帐号"
									class="form-control input-lg" id="account">
							</div>
						</div>
						<div class="form-group">
							<label for="password">密码</label>
							<div class="input-group input-group-lg">
								<span class="input-group-addon"> <i class="icon-lock"></i>
								</span> <input type="password" placeholder="请输入密码"
									class="form-control input-lg" id="password">
							</div>
						</div>
					</fieldset>
					<div class="form-actions">
						<label class="checkbox">
							<div class="checker">
								<!-- <span><input type="checkbox" value="1" name="remember"></span> -->
							</div> <!-- 记住我 -->
						</label>
						<button class="btn btn-warning pull-right" type="button" id="btn_login">
							登录 <i class="m-icon-swapright m-icon-white"></i>
						</button>
						<!-- <div class="forgot">
							<a href="#" class="forgot">忘记用户名或密码?</a>
						</div> -->
					</div>
				</form>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="${ctx}/page/login/js/login.js"></script>
</body>
</html>
