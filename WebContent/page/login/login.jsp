<%--
   Copyright 2015 the original author or phly.
        未经正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 --%>
<%--
   
   @author linyong
   @since  2015年5月22日 下午11:12:33
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>管理平台用户登录</title>
<jsp:include page="/page/common/common.jsp"></jsp:include>
<jsp:include page="/page/common/page/bootstrap.jsp"></jsp:include>
<style type="text/css">
html,body {
	height: 100%;
	background-image: url("../common/images/dark_embroidery.png");
}

table {
	height: 100%;
	width: 100%;
}
</style>
</head>
<body onkeydown="keyDownLogin()">
	<table>
		<tr>
			<td>
				<div class="container">
					<div class="row">
						<div
							class="col-md-offset-4 col-md-4 col-sd-offset-4 col-sd-4 col-xs-offset-2 col-xs-8">
							<div class="alert alert-danger alert-dismissable hide"
								id="login_msg_div_id">
								<button type="button" class="close" data-dismiss="alert"
									aria-hidden="true">&times;</button>
								<span>登录失败</span>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-dm-12">
							<form id="loginForm" class="form-horizontal" role="form">
								<div class="form-group">
									<div
										class="col-md-offset-4 col-md-4 col-sd-offset-4 col-sd-4 col-xs-offset-2 col-xs-8">
										<input type="text" class="form-control" id="account"
											placeholder="帐号">
									</div>
								</div>
								<div class="form-group">
									<div
										class="col-md-offset-4 col-md-4 col-sd-offset-4 col-sd-4 col-xs-offset-2 col-xs-8">
										<input type="password" class="form-control" id="password"
											placeholder="密码">
									</div>
								</div>
								<!-- <div class="form-group">
							      <div class="col-md-5">
							         <div class="checkbox">
							            <label>
							               <input type="checkbox"> 请记住我
							            </label>
							         </div>
							      </div>  
							   </div> -->
								<div class="form-group">
									<div
										class="col-md-offset-4 col-md-4 col-sd-offset-4 col-sd-4 col-xs-offset-2 col-xs-8">
										<button type="button" class="btn btn-primary btn-block"
											id="btn_login">登录</button>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
			</td>
		</tr>
	</table>
	<script type="text/javascript" src="${ctx}/page/login/js/login.js"></script>
</body>
</html>