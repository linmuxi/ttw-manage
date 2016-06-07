<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="menu" uri="/WEB-INF/tld/menu.tld" %>
<div class="left-nav">
	<div id="side-nav">
		<ul id="nav">
			<%-- <menu:markMenu moduleList="${moduleList}" type="left" showDashboard="true" 
				dashboardUri="http://baidu.com" dashboardTitle="首页"/> --%>
		</ul>
	</div>
</div>
<script>
	$(function(){
		//首页uri
		var homeUri = "/page/admin/index.jsp";
		var homeTitle = "首页";
		var homeId = "-1";
		
		function markMenu(menuList,isShowDashboard){
			var menuBuffer = "";
			if(isShowDashboard){
				menuBuffer = menuBuffer + 
					"<li id='"+homeId+"' class=\"current\">"+
						"<a href=\"javascript:void(0);\" onclick=\"toPage('"+homeUri+"','"+homeId+"')\" >" +
							"<i class=\"icon-home\"></i> "+homeTitle+
						"</a>"+
					"</li>";
			}
			
			for (var i = 0,j = menuList.length;i<j;i++) {
				var menu = menuList[i];
				var childMenuList = menu.childModuleList;
				if (childMenuList != null && childMenuList != undefined && childMenuList.length > 0) {
					menuBuffer = menuBuffer+
						"<li id='"+menu.moduleId+"'>"+
							"<a href=\"javascript:void(0);\" onclick=\"toPage('"+menu.moduleUrl+"','"+menu.moduleId+"')\" >" +
								"<i class=\""+getModuleIcon(menu)+"\"></i> "+menu.moduleName+
								"<span class=\"label label-info pull-right\">"+
									(isNotEmpty(menu.infoTotal)?menu.infoTotal:"")+
								"</span>"+ 
								"<i class=\"arrow icon-angle-left\"></i>"+
							"</a>"+
							"<ul class=\"sub-menu\">"+
								markMenu(childMenuList, false)+
							"</ul>"+
						"</li>";
				} else {
					menuBuffer = menuBuffer+
						"<li id='"+menu.moduleId+"'>"+
							"<a href=\"javascript:void(0);\" onclick=\"toPage('"+menu.moduleUrl+"','"+menu.moduleId+"')\" >" +
								"<i class=\""+getModuleIcon(menu)+"\"></i> "+menu.moduleName+
								"<span class=\"label label-info pull-right\">"+
									(isNotEmpty(menu.infoTotal)?menu.infoTotal:"")+
								"</span>"+ 
							"</a>"+
						"</li>";
				}
			}
			return menuBuffer;
		}
		
		function getModuleIcon(menu){
			if(isNotEmpty(menu.icon)){
				return menu.icon;
			}
			if(menu.level == 1){
				return "icon-table";
			}else{
				return "icon-angle-right";
			}
		}
		//生成菜单
		$("#nav").append(markMenu($.parseJSON('${moduleJson}'),true));
		selectMenu("${param.currentMenuId}");
	});
	
	//选中菜单
	function selectMenu(id){
		if(isNotEmpty(id)){
			$('#nav li.current').removeClass("current");
			var _menu = $("#"+id);
			_menu.addClass("current");
			_menu.parent().addClass("opened");
		}
	}
	
	//页面跳转
	function toPage(url,id){
		if(url == undefined || url == null || url.toUpperCase() == 'NULL' || url.trim() == ''){
			return;
		}
		var cmi = "currentMenuId="+id;
		forward(webRoot+url+((url.indexOf("?") == -1)?"?"+cmi:"&"+cmi));
	}
</script>
<script type="text/javascript" src="${ctx}/page/common/js/thin/js/smooth-sliding-menu.js"></script>