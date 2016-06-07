/*
 * Copyright 2015 the original author or phly.
 * 未经正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 */
package com.phly.common.base.tag;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.commons.lang.StringUtils;

import com.phly.common.base.model.SysModuleVO;

/**
 * 生成后台管理菜单
 * @Description TODO
 * @author linyong
 * @since 2015年5月23日 上午11:31:40
 */
public class DefaultMenuTag extends SimpleTagSupport {

	private static final String defaultDashboardTitle = "首页";
	
	private static final String defaultDashboardUri = "index.html";
	
	private boolean isShowDashboard;
	
	private String dashboardTitle;
	
	private String dashboardUri;
	
	private String type;
	
	private List<SysModuleVO> moduleList;

	private String markMenu(List<SysModuleVO> moduleList) {
		if (moduleList != null && moduleList.size() > 0) {
			if(StringUtils.isNotEmpty(type) && StringUtils.equalsIgnoreCase(type, "left")){
				return leftMenu(moduleList,isShowDashboard);
			}else{
				return topMenu(moduleList);
			}
		}
		return "";
	}
	
	/**
	 * 生成左边菜单
		<li class="current">
			<a href="index.html"> 
				<i class="icon-dashboard"></i> Dashboard
			</a>
		</li>
		<li>
			<a href="#"> 
				<i class="icon-desktop"></i> UI Features
				<span class="label label-info pull-right">7</span> 
				<i class="arrow icon-angle-left"></i>
			</a>
			<ul class="sub-menu">
				<li>
					<a href="general.html"> 
						<i class="icon-angle-right"></i>General
					</a>
				</li>
				<li>
					<a href="buttons.html"> 
						<i class="icon-angle-right"></i>Buttons
					</a>
				</li>
				<li>
					<a href="tabs.html"> 
						<i class="icon-angle-right"></i>Tabs
					</a>
				</li>
				<li>
					<a href="accordions.html"> 
						<i class="icon-angle-right"></i> Accordions
					</a>
				</li>
			</ul>
		</li>
	 * @param moduleList
	 * @return
	 */
	private String leftMenu(List<SysModuleVO> moduleList,boolean isShowDashboard) {
		StringBuffer menu = new StringBuffer();
		//生成首页菜单
		if(isShowDashboard){
			menu.append(
				"<li class=\"current\">"+
					"<a href=\"javascript:void(0);\" onclick=\"toModule('"+getDashboardUri()+"')\" >" +
						"<i class=\"icon-home\"></i> "+getDashboardTitle()+
					"</a>"+
				"</li>"
			);
		}
		for (SysModuleVO sysModuleVO : moduleList) {
			List<SysModuleVO> childModule = sysModuleVO.getChildModuleList();
			if (childModule != null && childModule.size() > 0) {
				menu.append(
					"<li>"+
						"<a href=\"javascript:void(0);\" onclick=\"toModule('"+sysModuleVO.getModuleUrl()+"')\" >" +
							"<i class=\""+getModuleIcon(sysModuleVO)+"\"></i> "+sysModuleVO.getModuleName()+
							"<span class=\"label label-info pull-right\">"+
								(StringUtils.isNotEmpty(sysModuleVO.getInfoTotal())?sysModuleVO.getInfoTotal():"")+"</span>"+ 
							"<i class=\"arrow icon-angle-left\"></i>"+
						"</a>"+
						"<ul class=\"sub-menu\">"+
							leftMenu(childModule, false)+
						"</ul>"+
					"</li>"
				);
			} else {
				menu.append(
					"<li>"+
						"<a href=\"javascript:void(0);\" onclick=\"toModule('"+sysModuleVO.getModuleUrl()+"')\" >" +
							"<i class=\""+getModuleIcon(sysModuleVO)+"\"></i> "+sysModuleVO.getModuleName()+
							"<span class=\"label label-info pull-right\">"+
								(StringUtils.isNotEmpty(sysModuleVO.getInfoTotal())?sysModuleVO.getInfoTotal():"")+"</span>"+ 
						"</a>"+
					"</li>"
				);
			}
		}
		return menu.toString();
	}
	
	private String getModuleIcon(SysModuleVO vo){
		if(StringUtils.isEmpty(vo.getIcon())){
			if(vo.getLevel() == 1){
				return "icon-table";
			}else{
				return "icon-angle-right";
			}
		}
		return vo.getIcon();
	}
	
	private String topMenu(List<SysModuleVO> moduleList) {
		StringBuffer menu = new StringBuffer();
		for (SysModuleVO sysModuleVO : moduleList) {
			List<SysModuleVO> childModule = sysModuleVO.getChildModuleList();
			if (childModule != null && childModule.size() > 0) {
				menu.append("<li class=\"dropdown\">"
						+ "<a href=\"javascript:void(0);\" onclick=\"toModule('"+sysModuleVO.getModuleUrl()+"')\" class=\"dropdown-toggle\" data-toggle=\"dropdown\">"
						+ sysModuleVO.getModuleName()
						+ " <b class=\"caret\"></b></a>"
						+ "<ul class=\"dropdown-menu\">"
						+ markMenu(childModule) + "</ul></li>");
			} else {
				menu.append("<li><a href=\"javascript:void(0);\" onclick=\"toModule('"+sysModuleVO.getModuleUrl()+"')\" >" + sysModuleVO.getModuleName() + "</a></li>");
			}
		}
		return menu.toString();
	}

	@Override
	public void doTag() throws JspException, IOException {
		getJspContext().getOut().print(markMenu(this.moduleList));
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isShowDashboard() {
		return isShowDashboard;
	}

	public void setShowDashboard(boolean isShowDashboard) {
		this.isShowDashboard = isShowDashboard;
	}
	
	public List<SysModuleVO> getModuleList() {
		return moduleList;
	}

	public void setModuleList(List<SysModuleVO> moduleList) {
		this.moduleList = moduleList;
	}
	
	public String getDashboardTitle(){
		if(StringUtils.isNotEmpty(this.dashboardTitle)){
			return this.dashboardTitle;
		}else{
			return defaultDashboardTitle;
		}
	}
	
	public void setDashboardTitle(String dashboardTitle) {
		this.dashboardTitle = dashboardTitle;
	}

	public String getDashboardUri() {
		if(StringUtils.isNotEmpty(this.dashboardUri)){
			return this.dashboardUri;
		}else{
			return defaultDashboardUri;
		}
	}

	public void setDashboardUri(String dashboardUri) {
		this.dashboardUri = dashboardUri;
	}
}
