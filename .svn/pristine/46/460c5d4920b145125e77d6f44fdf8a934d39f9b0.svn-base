<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String excelChName = new String(("供应商列表").getBytes("gbk"),"iso8859-1");
	//导出到Excel表格中
	response.reset();
	response.setHeader("Content-Disposition","attachment;filename="+excelChName+".xls");//指定下载的文件名
	
	response.setContentType("application/vnd.ms-excel;charset=GBK");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	</head>
	<body>
		<div>
			<form>
				<table id="allLenderDatagridtable"  rownumbers="true" fitColumns="true" singleSelect="true" border="1">
				<thead>
					<tr style="font-size: 16px;font-weight:bold">
						<td style="text-align:center">供应商编号 </td>
						<td style="text-align:center">合同编码</td>
						<td style="text-align:center">招商人姓名 </td>
						<td style="text-align:center">供应商名称 </td>
						<td style="text-align:center">供应商邮箱 </td>
						<td style="text-align:center">供应商电话 </td>
						<td style="text-align:center">供应商传真 </td>
						<td style="text-align:center">供应商地址 </td>
						<td style="text-align:center">供应商营业执照 </td>
						<td style="text-align:center">银行账户名称 </td>
						<td style="text-align:center">银行账号 </td>
						<td style="text-align:center">银行账户地址 </td>
						<td style="text-align:center">联系人姓名 </td>
						<td style="text-align:center">联系人电话 </td>
						<td style="text-align:center">联系人QQ </td>
						<td style="text-align:center">联系人邮箱 </td>
						<td style="text-align:center">联系人地址 </td>
						<td style="text-align:center">负责人身份证号 </td>
						<td style="text-align:center">负责人姓名 </td>
						<td style="text-align:center">负责人电话 </td>
						<td style="text-align:center">负责人QQ </td>
						<td style="text-align:center">负责人邮箱 </td>
						<td style="text-align:center">供应商类型 </td>
						<td style="text-align:center">是否删除 </td>
						<td style="text-align:center">是否锁定 </td>
						<td style="text-align:center">状态 </td>
						<!-- <td style="text-align:center">备注信息 </td> -->
					</tr>
				</thead>
				<c:forEach var="su" items="${supplier}">
					<tr>
						<td style="text-align:center">${su.supNo}</td>
						<td style="text-align:center">${su.contractCode}</td>
						<td style="text-align:center">${su.cmbPeopleName}</td>
						<td style="text-align:center">${su.supName}</td>
						<td style="text-align:center">${su.supEmail}</td>
						<td style="text-align:center">${su.supPhone}</td>
						<td style="text-align:center">${su.supFaxes}</td>
						<td style="text-align:center">${su.supAddress}</td>
						<td style="text-align:center">${su.busLicense}</td>
						<td style="text-align:center">${su.bankAccountName}</td>
						<td style="text-align:center">${su.bankAccountNo}</td>
						<td style="text-align:center">${su.bankAddress}</td>
						<td style="text-align:center">${su.linkPeopleName}</td>
						<td style="text-align:center">${su.linkPeoplePhone}</td>
						<td style="text-align:center">${su.linkPeopleQQ}</td>
						<td style="text-align:center">${su.linkPeopleEmail}</td>
						<td style="text-align:center">${su.linkPeopleAddress}</td>
						<td style="text-align:center">${su.headPeopleCardNo}</td>
						<td style="text-align:center">${su.headPeopleName}</td>
						<td style="text-align:center">${su.headPeoplePhone}</td>
						<td style="text-align:center">${su.headPeopleQQ}</td>
						<td style="text-align:center">${su.headPeopleEmail}</td>
						<td style="text-align:center">
							<c:if test="${empty su.supType}"></c:if>
                    	 	<c:if test="${su.supType == 0}">个人</c:if>
                    	 	<c:if test="${su.supType == 1}">公司</c:if>
						</td>
						<td style="text-align:center">
							<c:if test="${empty su.isDel}"></c:if>
                    	 	<c:if test="${su.isDel == 0}">已删除</c:if>
                    	 	<c:if test="${su.isDel == 1}">未删除</c:if>
						</td>
						
						<td style="text-align:center">
							<c:if test="${empty su.isLocked}"></c:if>
                    	 	<c:if test="${su.isLocked == 0}">已锁定</c:if>
                    	 	<c:if test="${su.isLocked == 1}">未锁定</c:if>
						</td>
						
						<td style="text-align:center">
							<c:if test="${empty su.supState}"></c:if>
                    	 	<c:if test="${su.supState == 0}">审核中</c:if>
                    	 	<c:if test="${su.supState == 1}">审核通过</c:if>
                    	 	<c:if test="${su.supState == 2}">审核不通过</c:if>
                    	 	<c:if test="${su.supState == 3}">合作</c:if>
                    	 	<c:if test="${su.supState == 4}">终止</c:if>
						</td>
						
					</tr>
				</c:forEach>
				</table>
			</form>
		</div>
	</body>
</html>