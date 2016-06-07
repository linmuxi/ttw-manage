/*
 * Copyright 2015 the original author or phly.
 * 未经正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 */
package com.phly.common.base.action;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.phly.common.base.facade.SysUserFacade;
import com.phly.common.base.model.SysUserVO;
import com.phly.common.exceptionhandler.annotation.ExceptionMessage;
import com.phly.common.util.DigestUtil;
import com.phly.common.util.RequestContextUtil;

/**
 * 系统用户控制类
 * 
 * @Description TODO
 * @author orc_lh
 * @since 2015年5月21日 下午11:43:26
 */
@Controller
@RemoteProxy
public class SysUserAction extends BaseAction{

	@Resource
	private SysUserFacade userFacade;
	

	/**
	 * 查询用户列表
	 * 
	 * @param userVO
	 * @return 用户集合
	 */
	@ExceptionMessage("查询用户列表失败，请联系管理员")
	@RequestMapping("/page/admin/user/queryUserList")
	@ResponseBody
	public ModelMap queryUserList(HttpServletRequest request,SysUserVO userVO) {
		wrapDatatableParams(request, userVO);
		return this.userFacade.queryUserList(userVO);
	}
	
	/**
	 * 根据用户名称或id获取用户vo
	 * @param userVO
	 * @return
	 */
	@RequestMapping("/getUser")
	@ResponseBody
	@RemoteMethod
	public ModelMap getUser(SysUserVO userVO) {
		return this.userFacade.getUser(userVO);
	}
	
	/**
	 * 添加用户
	 * @param userVO
	 * @return
	 */
	@RequestMapping("/addUser")
	@ResponseBody
	public ModelMap addUser(SysUserVO userVO) {
		return this.userFacade.addUser(userVO);
	}
	/**
	 * 修改用户
	 * @param userVO
	 * @return
	 */
	 
	@RequestMapping("/updateUser")
	@ResponseBody
	public ModelMap updateUser(SysUserVO userVO) {
		return this.userFacade.updateUser(userVO);
	}
	
	/**
	 * 删除用户
	 * @param userVO
	 * @return
	 */
	@RequestMapping("/delUser")
	@ResponseBody
	@RemoteMethod
	public ModelMap delUser(SysUserVO userVO) {
		return this.userFacade.delUser(userVO);
	}
	
	/**
	 * 编辑用户
	 * @param userVO
	 * @return
	 */
	@RemoteMethod
	public ModelMap formUser(SysUserVO userVO){
		return this.userFacade.formUser(userVO);
	}

	/**
	 * 查询指定帐号是否存在
	 * @param userVO
	 * @return
	 */
	@RequestMapping("/page/admin/user/getAccountExists")
	@ResponseBody
	public ModelMap getAccountExists(HttpServletRequest request, SysUserVO userVO){
		return this.userFacade.getAccountExists(userVO);
	}

	/**
	 * 验证密码
	 * @param userVO
	 * @return
	 */
	@RequestMapping("/page/admin/user/validatePassword")
	@ResponseBody
	public ModelMap validatePassword(HttpServletRequest request, SysUserVO userVO){
		ModelMap map = new ModelMap();
		map.put("valid", false);
		//如果输入密码等于会话用户密码则正确
		if(StringUtils.equals(RequestContextUtil.getCurrentUser().getPassword(), 
				DigestUtil.encodePasswordByMD5(userVO.getPassword(),RequestContextUtil.getCurrentUser().getAccount()))){
			map.put("valid", true);
		}
		return map;
	}

	/**
	 * 修改密码
	 * @param userVO
	 * @return
	 */
	@RequestMapping("/page/admin/user/updatePassword")
	public ModelAndView updatePassword(HttpServletRequest request,HttpServletResponse response,SysUserVO userVO){
		response.setCharacterEncoding("utf-8");
		ModelAndView map = new ModelAndView();
		map.setViewName("redirect:/page/admin/user/userInfo.jsp");
		String message = "";
		//校验当前密码
		if((Boolean) validatePassword(request, userVO).get("valid")){
			if(StringUtils.equals(request.getParameter("newPwd"), request.getParameter("surePwd"))){
				userVO.setPassword(DigestUtil.encodePasswordByMD5(request.getParameter("surePwd"), userVO.getAccount()));
				//修改密码
				message = ((Boolean)this.userFacade.updatePassword(userVO).get("result")?
						"密码修改成功":"密码修改失败");
			}else{
				message = "密码修改失败,密码不一致";				
			}
		}else{
			message = "密码修改失败,当前密码不对";
		}
		try {
			map.addObject("message",URLEncoder.encode(message, "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}	
		return map;
	}
	
	/**
	 * 查看用户拥有的角色
	 * @param userVO
	 * @return
	 */
	@RequestMapping("/page/admin/user/getUserRoleInfo")
	public String getUserRoleInfo(HttpServletRequest request, SysUserVO userVO){
		request.setAttribute("other", new JSONObject().element("type", 1).element("objId", userVO.getUserId())
				.element("objName", userVO.getAccount()));//角色
		request.setAttribute("data", this.userFacade.getUserRoleInfo(userVO));
		return "/page/admin/authorization.jsp";
	}

	/**
	 * 添加用户角色关系数据
	 * @param userVO
	 * @return
	 */
	@RemoteMethod
	public ModelMap addUserRole(SysUserVO userVO){
		return this.userFacade.addUserRole(userVO);
	}
	
}
