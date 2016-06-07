/*
 * Copyright 2015 the original author or phly.
 * 未经正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 */
package com.phly.common.base.service;

import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.phly.common.base.dao.SysResourceDao;
import com.phly.common.base.model.SysResourceVO;

/**
 *
 * @Description: TODO
 * @author wanglong
 * @since 2015年5月24日 下午2:58:04
 */

@Service
public class SysResourceService extends ServiceBase{

	@Resource
	private SysResourceDao resourceDao;
	
	public ModelMap queryResourceList(SysResourceVO resourceVO){
		int count = this.resourceDao.getResourceCount(resourceVO);
		List<SysResourceVO> list = Collections.emptyList();
		if(count > 0){
			list = this.resourceDao.queryResourceList(resourceVO);
		}
		return wrapDatatableResult(count, list);
	}
	
	
	/**
	 * 添加资源
	 * @param resourceVO
	 * @return
	 */
	public ModelMap addResource(SysResourceVO resourceVO){
		ModelMap map = new ModelMap();
		if(this.resourceDao.getResource(resourceVO) == null){
			map.put("result", this.resourceDao.addResource(resourceVO));
		}else{
			map.put("result", false);
			map.put("remark", "该资源已经存在。");
		}
		return map;
		
	}
	
	/**
	 * 根据资源ID查询资源信息
	 * @param resourceVO
	 * @return
	 */
	public ModelMap getResource(SysResourceVO resourceVO){
		ModelMap map = new ModelMap();
		map.put("result", this.resourceDao.getResource(resourceVO));
		return map;
	}
	
	/**
	 * 修改资源
	 * @param roleVO
	 * @return
	 */
	public ModelMap updateResource(SysResourceVO resourceVO) {
		ModelMap map = new ModelMap();
		SysResourceVO vo = this.resourceDao.getResource(new SysResourceVO(null,resourceVO.getResourcePath()));
		if(vo != null && !StringUtils.equalsIgnoreCase(vo.getResourceId(), resourceVO.getResourceId())){
			map.put("result", false);
			map.put("remark", "该资源已经存在");
		}else{
			map.put("result", this.resourceDao.updateResource(resourceVO));
		}
		return map;
	}
	
	/**
	 * 删除资源
	 * @param roleVO
	 * @return
	 */
	public ModelMap delResource(SysResourceVO resourceVO) {
		ModelMap model = new ModelMap();
		model.put("result", this.resourceDao.delResource(resourceVO));
		return model;
	}

	/**
	 * 编辑资源
	 * @param resourceVO
	 * @return
	 */
	public ModelMap formResource(SysResourceVO resourceVO){
		ModelMap map = new ModelMap();
		
		if(null == resourceVO){
			map.put("result", false);
			map.put("remark", "对象为null");
			return map;
		}
		
		if(StringUtils.isNotEmpty(resourceVO.getResourceId())){
			//修改
			return this.updateResource(resourceVO);
		}else{
			//新增
			return this.addResource(resourceVO);
		}
	}

	/**
	 * 查询指定资源是否存在(根据资源路径)
	 * @param userVO
	 * @return
	 */
	public ModelMap getResourcePathExists(SysResourceVO resourceVO){
		ModelMap map = new ModelMap();
		map.put("valid", true);
		SysResourceVO vo = this.resourceDao.getResource(new SysResourceVO(null,resourceVO.getResourcePath()));
		if(null != vo && !StringUtils.equalsIgnoreCase(resourceVO.getResourceId(),vo.getResourceId())){
			map.put("valid", false);
		}
		return map;
	}
	
}
