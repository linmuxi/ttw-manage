/*
 * Copyright 2015 the original author or phly.
 * 未经正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 */
package com.phly.ttw.manage.index;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.directwebremoting.annotations.RemoteProxy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.phly.common.base.facade.SysModuleFacade;

/**
 * @Description TODO
 * @author linyong
 * @since 2015年6月11日 下午11:43:26
 */
@Controller("ttwIndexAction")
@RemoteProxy
public class IndexAction {

	@Resource
	private SysModuleFacade moduleFacade;
	
	/**
	 * 获取指定用户下的模块信息
	 * 
	 * @param moduleVO
	 * @return 模块集合
	 */
	@RequestMapping("/page/manage/index")
	public ModelAndView index(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/page/business/manage/index/index.jsp");
		request.getSession().setAttribute("moduleList", this.moduleFacade.getSysModuleByAccount());
		return mv;
	}
}
