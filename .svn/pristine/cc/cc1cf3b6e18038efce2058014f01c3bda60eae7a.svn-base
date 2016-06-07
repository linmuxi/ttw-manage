/*
 * Copyright 2015 the original author or phly.
 * 未经正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 */
package com.phly.common.base.model;

import java.util.List;

import org.directwebremoting.annotations.DataTransferObject;

/**
 * 系统角色VO
 * 
 * @Description TODO
 * @author linyong
 * @since 2015年5月17日 下午4:46:57
 */
@DataTransferObject
public class SysRoleVO extends BaseVO {
	/**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = 1L;
	private String roleId;
	private String roleName;
	private String roleDesc;
	private boolean enabled;
	private boolean isDel;
	private String userId;
	private List<SysModuleVO> modules;
	private List<SysAuthorityVO> auths;

	public List<SysModuleVO> getModules() {
		return modules;
	}

	public void setModules(List<SysModuleVO> modules) {
		this.modules = modules;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleDesc() {
		return roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public List<SysAuthorityVO> getAuths() {
		return auths;
	}

	public void setAuths(List<SysAuthorityVO> auths) {
		this.auths = auths;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public boolean isDel() {
		return isDel;
	}

	public void setDel(boolean isDel) {
		this.isDel = isDel;
	}

	public SysRoleVO() {
		super();
	}

	public SysRoleVO(String roleName) {
		super();
		this.roleName = roleName;
	}
}
