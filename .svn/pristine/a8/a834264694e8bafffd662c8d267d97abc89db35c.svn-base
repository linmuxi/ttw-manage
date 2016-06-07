<%--
   Copyright 2015 the original author or phly.
        未经正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 --%>
<%--
   	业务表单审批
   @author linyong
   @since  2015年6月11日 下午3:04:31
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>业务表单审批</title>
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
				
					<div class="col-md-12 col-xs-12 col-sm-12">
			              <div class="stats-heading"><h4>业务审批</h4></div>
			              <div class="stats-body-alt"> 
							<iframe width="100%" height="100%" frameborder="0" id="bussniessIframe" src="${param.src}"></iframe>
			              </div>
			              <div class="stats-footer">
			              	<form id="approvalForm">
			              		<table border="0" style="margin: 0 auto;color: #FFF;" cellpadding="8">
			              			<tr>
			              				<td>审批结果：</td>
			              				<td>
											<input type="radio" name="approved" id="approved_yes" value="1"> <span>同意</span>
											&nbsp;&nbsp;&nbsp;&nbsp;
						  					<input type="radio" name="approved" id="approved_no" value="0"> <span>不同意</span>
			              				</td>
			              			</tr>
			              			<tr>
			              				<td>审批意见：</td>
			              				<td><textarea rows="2" cols="40" id="opinion" name="opinion"></textarea></td>
			              			</tr>
			              			<tr>
			              				<td></td>
			              				<td>
			              					<button class="btn btn-primary" type="button" id="approvalFormBtn">提交</button>
			              					<button class="btn btn-primary" type="button" id="goBack" title="返回我的任务列表">返回</button>
			              				</td>
			              			</tr>
			              		</table>
			              	</form>
			              </div>
			        </div>
				</div>
			</div>
		</div>
		<!-- 右边内容区域 end -->	
	</div>
	<!-- 底部版权信息 -->
	<jsp:include page="/page/admin/bottom.jsp" />
	
	<script type="text/javascript">
		//任务id
		var taskId = "${param.taskId}";
		$("input[name='approved'] + span").each(function(i,object){
        	var $this = $(this);
        	$this.addClass("cursor");
    		$this.click(function(obj){
    			if($this.text() == '同意'){
    				$("#approved_yes").prop("checked","true");
    			}else{
    				$("#approved_no").prop("checked","true");    				
    			}
    		});
        });
	</script>
	<script type="text/javascript" src="${ctx}/page/admin/js/activiti/approvalForm.js"></script>
	<script src="${ctx}/dwr/interface/ActivitiAction.js"></script>
</body>
</html>