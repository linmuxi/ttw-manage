<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>后台管理首页</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
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
			
		</div>
		<!-- 右边内容区域 end -->	
	</div>
	
	<!-- 底部版权信息 -->
	<jsp:include page="/page/admin/bottom.jsp" />
</body>
</html>
