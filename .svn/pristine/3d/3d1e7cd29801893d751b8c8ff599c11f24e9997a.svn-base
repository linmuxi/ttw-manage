/*
 * Copyright 2015 the original author or phly.
 * 未经正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 */
package com.phly.common.base.action;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.phly.common.base.facade.SysAuthorityFacade;
import com.phly.common.base.model.SysAuthorityVO;
import com.phly.common.exceptionhandler.annotation.ExceptionMessage;

/**
 *
 * @Description: TODO
 * @author wanglong
 * @since 2015年6月19日 下午1:05:02
 */

@Controller
@RemoteProxy
public class SysAuthorityAction extends BaseAction{
	
	@Resource
	private SysAuthorityFacade authorityFacade;
	
	@ExceptionMessage("查询权限列表失败，请联系管理员")
	@RequestMapping("/page/admin/authority/queryAuthorityList")
	@ResponseBody
	public ModelMap queryAuthorityList(HttpServletRequest request,SysAuthorityVO authorityVO){
		wrapDatatableParams(request, authorityVO);
		return this.authorityFacade.queryAuthorityList(authorityVO);
	}
	
	
	
	/**
	 * 添加权限
	 * @param authorityVO
	 * @return
	 */
	@RemoteMethod
	public ModelMap addAuthority(SysAuthorityVO authorityVO){
		return this.authorityFacade.addAuthority(authorityVO);
	}

	
	/**
	 * 修改权限
	 * @param authorityVO
	 * @return
	 */
	@RemoteMethod
	public ModelMap updateAuthority(SysAuthorityVO authorityVO) {
		return this.authorityFacade.updateAuthority(authorityVO);
	}
	
	
	/**
	 * 权限编辑
	 * @param authorityVO
	 * @return
	 */
	@RemoteMethod
	public ModelMap formAuthority(SysAuthorityVO authorityVO) {
		return this.authorityFacade.formAuthority(authorityVO);
	}
	
	
	
	
	/**
	 * 根据权限ID查询权限信息
	 * @param authorityVO
	 * @return
	 */
	@RemoteMethod
	public ModelMap getAuthority(SysAuthorityVO authorityVO){
		return this.authorityFacade.getAuthority(authorityVO);
	}
	
	/**
	 * 删除权限
	 * @param delAuthority
	 * @return
	 */
	@RemoteMethod
	public ModelMap delAuthority(SysAuthorityVO authorityVO) {
		return this.authorityFacade.delAuthority(authorityVO);
	}
	
	
	/**
	 * 查看权限可以访问的资源
	 * @param authorityVO
	 * @return
	 */
	@RequestMapping("/page/admin/authority/getAuthorityResourceInfo")
	public String getAuthorityResourceInfo(HttpServletRequest request, SysAuthorityVO authorityVO){
		try {
			request.setAttribute("other", new JSONObject().element("type", 4).
					element("objId",authorityVO.getAuthorityId()).
					element("objName",URLDecoder.decode(authorityVO.getAuthorityName(), "UTF-8")));//权限
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		request.setAttribute("data", this.authorityFacade.getAuthorityResourceInfo(authorityVO));
		return "/page/admin/authorization.jsp";
	}
	
	
	/**
	 * 添加权限对应的资源信息
	 * @param authorityVO
	 * @return
	 */
	@RemoteMethod
	public ModelMap addAuthorityAuth(SysAuthorityVO authorityVO){
		return this.authorityFacade.addAuthorityAuth(authorityVO);
	}
	
	

}
