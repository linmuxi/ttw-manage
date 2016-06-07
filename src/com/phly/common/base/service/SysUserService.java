/*
 * Copyright 2015 the original author or phly.
 * 未经正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 */
package com.phly.common.base.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.phly.common.base.dao.SysUserDao;
import com.phly.common.base.model.AuthorizationKV;
import com.phly.common.base.model.SysRoleVO;
import com.phly.common.base.model.SysUserVO;
import com.phly.common.util.DigestUtil;

/**
 * 系统用户服务类
 * 
 * @Description TODO
 * @author lihui
 * @author linyong
 * @since 2015年5月21日 下午11:43:26
 */
@Service
public class SysUserService extends ServiceBase {

	@Resource
	private SysUserDao userDao;
	
	/**
	 * 查询用户列表
	 * 
	 * @param userVO
	 * @return 用户集合
	 */
	public ModelMap queryUserList(SysUserVO userVO) {
		int iCount = this.userDao.getUserCount(userVO);
		List<SysUserVO> list = Collections.emptyList();
		if(iCount > 0){
			list = this.userDao.queryUserList(userVO);
		}
		return wrapDatatableResult(iCount, list);
	}
	
	/**
	 * 根据用户名称或id获取用户vo
	 * @param userVO
	 * @return
	 */
	public ModelMap getUser(SysUserVO userVO) {
		ModelMap map = new ModelMap();
		SysUserVO vo = this.userDao.getUser(userVO);
		if(vo != null){
			map.put("sucflag", true);
			map.put("bean", vo);
		}else{
			map.put("sucflag", false);
		}
		return map;
	}

	/**
	 * 添加用户
	 * @param userVO
	 * @return
	 */
	public ModelMap addUser(SysUserVO userVO) {
		ModelMap map = new ModelMap();
		if(this.userDao.getUser(userVO) == null){
			userVO.setPassword(DigestUtil.encodePasswordByMD5(userVO.getPassword(),userVO.getAccount()));
			map.put("result", this.userDao.addUser(userVO));
		}else{
			map.put("result", false);
			map.put("remark", "该用户已经存在。");
		}
		return map;
	}

	/**
	 * 修改用户
	 * @param userVO
	 * @return
	 */
	public ModelMap updateUser(SysUserVO userVO) {
		ModelMap map = new ModelMap();
		SysUserVO paramVO = new SysUserVO();
		paramVO.setUserId(userVO.getUserId());
		SysUserVO vo = this.userDao.getUser(paramVO);
		if(vo != null && !StringUtils.equalsIgnoreCase(vo.getUserId(), userVO.getUserId())){
			map.put("result", false);
			map.put("remark", "该用户已经存在");
		}else{
			map.put("result", this.userDao.updateUser(userVO));
		}
		return map;
	}
	 
	/**
	 * 删除用户
	 * @param userVO
	 * @return
	 */
	public ModelMap delUser(SysUserVO userVO) {
		ModelMap map = new ModelMap();
		map.put("result", this.userDao.delUser(userVO));
		return map;
	}
	
	/**
	 * 编辑用户
	 * @param userVO
	 * @return
	 */
	public ModelMap formUser(SysUserVO userVO){
		ModelMap map = new ModelMap();
		
		if(null == userVO){
			map.put("result", false);
			map.put("remark", "对象为null");
			return map;
		}
		
		if(StringUtils.isNotEmpty(userVO.getUserId())){
			//修改
			return this.updateUser(userVO);
		}else{
			//新增
			return this.addUser(userVO);
		}
	}

	/**
	 * 查询指定帐号是否存在
	 * @param userVO
	 * @return
	 */
	public ModelMap getAccountExists(SysUserVO userVO){
		ModelMap map = new ModelMap();
		map.put("valid", true);
		SysUserVO vo = this.userDao.getUserByAccount(userVO);
		if(null != vo && !StringUtils.equalsIgnoreCase(vo.getUserId(), userVO.getUserId())){
			map.put("valid", false);
		}
		return map;
	}

	/**
	 * 密码验证
	 * @param userVO
	 * @return
	 */
	public ModelMap validatePassword(SysUserVO userVO){
		ModelMap map = new ModelMap();
		map.put("valid", false);
		SysUserVO vo = this.userDao.getUserByAccount(userVO);
		if(null != vo){
			map.put("valid", true);
		}
		return map;
	}

	/**
	 * 修改密码
	 * @param userVO
	 * @return
	 */
	public ModelMap updatePassword(SysUserVO userVO){
		ModelMap map = new ModelMap();
		map.put("result", this.userDao.updatePassword(userVO));
		return map;
	}
	
	/**
	 * 查看用户拥有的角色
	 * @param userVO
	 * @return
	 */
	public ModelMap getUserRoleInfo(SysUserVO userVO){
		ModelMap map = new ModelMap();
		map.put("selfAuth", transKV(this.userDao.getSelfRole(userVO)));
		map.put("noSelfAuth", transKV(this.userDao.getNoSelfRole(userVO)));
		return map;
	}

	/**
	 * 添加用户角色关系数据
	 * @param userVO
	 * @return
	 */
	public ModelMap addUserRole(SysUserVO userVO){
		ModelMap map = new ModelMap();
		map.put("result", this.userDao.addUserRole(userVO));
		return map;
	}

	/**
	 * 转换权限kv
	 * @param roles
	 * @return
	 */
	private List<AuthorizationKV> transKV(List<SysRoleVO> roles){
		List<AuthorizationKV> auths = new ArrayList<AuthorizationKV>();
		if(null != roles && roles.size() > 0){
			for (SysRoleVO role : roles) {
				auths.add(new AuthorizationKV(role.getRoleId(),role.getRoleName()));
			}
		}
		return auths;
	}
}
