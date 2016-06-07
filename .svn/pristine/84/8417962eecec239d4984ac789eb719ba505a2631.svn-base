/*
 * Copyright 2015 the original author or phly.
 * 未经正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 */
package com.phly.common.base.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.phly.common.base.facade.SysModuleFacade;
import com.phly.common.base.model.SysModuleVO;
import com.phly.common.exceptionhandler.annotation.ExceptionMessage;

/**
 * 系统模块控制类
 * 
 * @Description TODO
 * @author linyong
 * @since 2015年5月21日 下午11:43:26
 */
@Controller
@RemoteProxy
public class SysModuleAction extends BaseAction{

	@Resource
	private SysModuleFacade moduleFacade;

	/**
	 * 查询模块列表
	 * @param moduleVO
	 * @return 模块集合
	 */
	@ExceptionMessage("查询模块列表失败，请联系管理员")
	@RequestMapping("/page/admin/module/index")
	@ResponseBody
	public ModelMap querySysModules(HttpServletRequest request,SysModuleVO moduleVO){
		wrapDatatableParams(request, moduleVO);
		return this.moduleFacade.querySysModules(moduleVO);
	}
	
	

	/**
	 * 查询所有模块--下拉框
	 * @param request
	 * @return
	 */
	@RequestMapping("/page/admin/module/queryAllModule")
	@ResponseBody
	public List<SysModuleVO> queryAllModule(SysModuleVO moduleVO){
		return this.moduleFacade.queryAllModule(moduleVO);
	}

	/**
	 * 获取模块树，目前只支持二级菜单
	 * @param moduleVO
	 * @return
	 */
	@RemoteMethod
	public ModelMap getModuleTree(SysModuleVO moduleVO){
		return this.moduleFacade.getModuleTree(moduleVO);
	}

	/**
	 * 编辑模块
	 * @param moduleVO
	 * @return
	 */
	@RemoteMethod
	public ModelMap formModule(SysModuleVO moduleVO) {
		return this.moduleFacade.formModule(moduleVO);
	}
	
	/**
	 * 删除模块
	 * @param moduleVO
	 * @return
	 */
	@RemoteMethod
	public ModelMap delModule(SysModuleVO moduleVO) {
		return this.moduleFacade.delModule(moduleVO);
	}

	/**
	 * 根据模块ID获取模块
	 * @param moduleVO
	 * @return
	 */
	@RemoteMethod
	public ModelMap getModule(SysModuleVO moduleVO) {
		return this.moduleFacade.getModule(moduleVO);
	}
}
