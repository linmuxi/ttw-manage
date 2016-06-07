<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div id="imgList">
	
</div>
<div id="wrapper" style="width: ${empty param.iframeWidth ? '600' : param.iframeWidth }px;">
	<iframe id="uploadIFrame" name="uploadIFrame" src="${pageContext.request.contextPath}/page/common/page/upload/uploadFileIFrame.jsp?businessId=${param.businessId }" width="100%" height="183" scrolling="no" frameborder="0"></iframe>
</div>

<script src="${pageContext.request.contextPath}/dwr/interface/FileStoreAction.js?2=1"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/page/common/js/fileStore.js"></script>

<script>
$(function(){
	var businessId = $('#${param.businessId }').val();
	if(businessId){
		loadFileSotre(businessId,'imgList');
	}
});
</script>