/*
 * Copyright 2015 the original author or phly.
 * 未经正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 */
package com.phly.common.base.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;

import org.directwebremoting.annotations.RemoteProxy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.phly.common.base.facade.SysModuleFacade;
import com.phly.common.base.model.SysModuleVO;

/**
 * @Description TODO
 * @author linyong
 * @since 2015年6月11日 下午11:43:26
 */
@Controller
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
	@RequestMapping("/page/admin/index")
	public ModelAndView index(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/page/admin/index.jsp");
		List<SysModuleVO> modules = this.moduleFacade.getSysModuleByAccount();
		request.getSession().setAttribute("moduleList", modules);
		request.getSession().setAttribute("moduleJson", JSONArray.fromObject(modules));
		return mv;
	}
}
