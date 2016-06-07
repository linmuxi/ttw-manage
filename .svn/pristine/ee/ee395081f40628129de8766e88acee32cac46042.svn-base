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

import com.phly.common.base.dao.SysRoleDao;
import com.phly.common.base.model.AuthorizationKV;
import com.phly.common.base.model.SysAuthorityVO;
import com.phly.common.base.model.SysModuleVO;
import com.phly.common.base.model.SysRoleVO;

/**
 * 系统角色服务类
 * 
 * @Description TODO
 * @author linyong
 * @since 2015年5月21日 下午11:43:26
 */
@Service
public class SysRoleService extends ServiceBase{
	//private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Resource
	private SysRoleDao roleDao;

	/**
	 * 查询角色列表
	 * 
	 * @param roleVO
	 * @return 角色集合
	 */
	public ModelMap queryRoleList(SysRoleVO roleVO) {
		int count = this.roleDao.getRoleCount(roleVO);
		List<SysRoleVO> list = Collections.emptyList();
		if(count > 0){
			list = this.roleDao.queryRoleList(roleVO);
		}
		return wrapDatatableResult(count, list);
	}

	/**
	 * 获取角色对象
	 * @param userVO
	 * @return
	 */
	public ModelMap getRole(SysRoleVO roleVO) {
		ModelMap map = new ModelMap();
		map.put("result", this.roleDao.getRole(roleVO));
		return map;
	}

	/**
	 * 添加角色
	 * @param roleVO
	 * @return
	 */
	public ModelMap addRole(SysRoleVO roleVO) {
		ModelMap map = new ModelMap();
		if(this.roleDao.getRole(roleVO) == null){
			map.put("result", this.roleDao.addRole(roleVO));
		}else{
			map.put("result", false);
			map.put("remark", "该角色已经存在。");
		}
		return map;
	}
	
	/**
	 * 修改角色
	 * @param roleVO
	 * @return
	 */
	public ModelMap updateRole(SysRoleVO roleVO) {
		ModelMap map = new ModelMap();
		SysRoleVO vo = this.roleDao.getRole(new SysRoleVO(roleVO.getRoleName()));
		if(vo != null && !StringUtils.equalsIgnoreCase(vo.getRoleId(), roleVO.getRoleId())){
			map.put("result", false);
			map.put("remark", "该角色已经存在");
		}else{
			map.put("result", this.roleDao.updateRole(roleVO));
		}
		return map;
	}
	
	/**
	 * 删除角色
	 * @param roleVO
	 * @return
	 */
	public ModelMap delRole(SysRoleVO roleVO) {
		ModelMap map = new ModelMap();
		map.put("result", this.roleDao.delRole(roleVO));
		return map;
	}

	/**
	 * 编辑角色
	 * @param roleVO
	 * @return
	 */
	public ModelMap formRole(SysRoleVO roleVO){
		ModelMap map = new ModelMap();
		
		if(null == roleVO){
			map.put("result", false);
			map.put("remark", "对象为null");
			return map;
		}
		
		if(StringUtils.isNotEmpty(roleVO.getRoleId())){
			//修改
			return this.updateRole(roleVO);
		}else{
			//新增
			return this.addRole(roleVO);
		}
	}

	/**
	 * 查询指定角色名称是否存在
	 * @param userVO
	 * @return
	 */
	public ModelMap getRoleNameExists(SysRoleVO roleVO){
		ModelMap map = new ModelMap();
		map.put("valid", true);
		SysRoleVO vo = this.roleDao.getRole(new SysRoleVO(roleVO.getRoleName()));
		if(null != vo && !StringUtils.equalsIgnoreCase(vo.getRoleId(), roleVO.getRoleId())){
			map.put("valid", false);
		}
		return map;
	}

	/**
	 * 查看角色可以访问的模块
	 * @param roleVO
	 * @return
	 */
	public ModelMap getRoleModuleInfo(SysRoleVO roleVO) {
		ModelMap map = new ModelMap();
		map.put("selfAuth", transModuleKV(this.roleDao.getSelfModule(roleVO)));
		map.put("noSelfAuth", transModuleKV(this.roleDao.getNoSelfModule(roleVO)));
		return map;
	}

	/**
	 * 添加角色模块关系数据
	 * @param roleVO
	 * @return
	 */
	public ModelMap addRoleModule(SysRoleVO roleVO){
		ModelMap map = new ModelMap();
		map.put("result", this.roleDao.addRoleModule(roleVO));
		return map;
	}
	
	/**
	 * 查看角色可以访问的权限
	 * @param roleVO
	 * @return
	 */
	public ModelMap getRoleAuthInfo(SysRoleVO roleVO) {
		ModelMap map = new ModelMap();
		map.put("selfAuth", transAuthKV(this.roleDao.getSelfAuth(roleVO)));
		map.put("noSelfAuth", transAuthKV(this.roleDao.getNoSelfAuth(roleVO)));
		return map;
	}

	/**
	 * 添加角色权限关系数据
	 * @param roleVO
	 * @return
	 */
	public ModelMap addRoleAuth(SysRoleVO roleVO){
		ModelMap map = new ModelMap();
		map.put("result", this.roleDao.addRoleAuth(roleVO));
		return map;
	}
	
	/**
	 * 转换模块kv
	 * @param modules
	 * @return
	 */
	private List<AuthorizationKV> transModuleKV(List<SysModuleVO> modules){
		List<AuthorizationKV> auths = new ArrayList<AuthorizationKV>();
		if(null != modules && modules.size() > 0){
			for (SysModuleVO module : modules) {
				auths.add(new AuthorizationKV(module.getModuleId(), module.getModuleName()));
			}
		}
		return auths;
	}

	/**
	 * 转换权限kv
	 * @param sysAuths
	 * @return
	 */
	private List<AuthorizationKV> transAuthKV(List<SysAuthorityVO> sysAuths){
		List<AuthorizationKV> auths = new ArrayList<AuthorizationKV>();
		if(null != sysAuths && sysAuths.size() > 0){
			for (SysAuthorityVO authVO : sysAuths) {
				auths.add(new AuthorizationKV(authVO.getAuthorityId(),authVO.getAuthorityName()));
			}
		}
		return auths;
	}
}
