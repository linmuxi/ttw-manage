/*
 * Copyright 2015 the original author or phly.
 * 未经正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 */
package com.phly.ttw.manage.supplier.service;

import java.sql.Timestamp;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.phly.common.base.model.SysUserVO;
import com.phly.common.base.service.ServiceBase;
import com.phly.common.base.service.SysUserService;
import com.phly.common.util.AppKeys;
import com.phly.common.util.Constant;
import com.phly.common.util.ObjectConvertToMap;
import com.phly.common.util.RequestContextUtil;
import com.phly.common.util.WSUtils;
import com.phly.ttw.manage.supplier.dao.SupplierDao;
import com.phly.ttw.manage.supplier.model.SupplierModel;
import com.phly.ttw.manage.supplier.model.SupplierVO;
import com.phly.ttw.manage.supplier.util.SupplierNoUtil;
import com.phly.ttw.manage.supplier.ws.ISupplierWS;

/**
 * 
 * @Description: TODO
 * @author wanglong
 * @since 2015年6月9日 下午7:31:33
 */
@Service
public class SupplierService extends ServiceBase {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Resource
	private SupplierDao sysSupplierDao;

	@Resource
	private SysUserService sysUserService;
	
	

	/**
	 * 查询供应商列表
	 * 
	 * @param supplierVO
	 * @return
	 */
	public ModelMap querySupplierList(SupplierVO supplierVO) {
		int count = this.sysSupplierDao.getSupplierCount(supplierVO);
		List<SupplierVO> list = Collections.emptyList();
		if (count > 0) {
			list = this.sysSupplierDao.querySupplierList(supplierVO);
		}
		return wrapDatatableResult(count, list);
	}

	/**
	 * 查询供应商列表
	 * 
	 * @param supplierVO
	 * @return
	 */
	public List<SupplierVO> querySupplierList() {
		return this.sysSupplierDao.querySupplierList();
	}
	
	
	/**
	 * 查询同步失败的供应商列表信息
	 * @return
	 */
	public List<SupplierVO> querySupplierFailList(){
		return this.sysSupplierDao.querySupplierFailList();
	}

	/**
	 * 根据供应商ID查询供应商
	 * 
	 * @param supplierVO
	 * @return
	 */
	public ModelMap getSupplier(SupplierVO supplierVO) {
		ModelMap map = new ModelMap();
		SupplierVO vo = this.sysSupplierDao.getSupplier(supplierVO);
		if (vo != null) {
			map.put("sucflag", true);
			map.put("bean", vo);
		} else {
			map.put("sucflag", false);
		}
		return map;
	}

	/**
	 * 添加供应商信息
	 * 
	 * @param supplierVO
	 * @return
	 */
	public ModelMap addSupplier(SupplierVO supplierVO) {
		ModelMap model = new ModelMap();
		SysUserVO userVO = RequestContextUtil.getCurrentUser();
		if (userVO == null) {
			model.put("result", false);
			model.put("remark", "用户未登录。");
			return model;
		}
		supplierVO.setIsDel(1);
		supplierVO.setCreator(userVO.getAccount());
		supplierVO.setCreateDate(new Timestamp(new Date().getTime()));
		supplierVO.setLastUpdater(userVO.getAccount());
		supplierVO.setLastUpdateDate(new Timestamp(new Date().getTime()));
		model.put("result", this.sysSupplierDao.addSupplier(supplierVO));
		return model;
	}

	/**
	 * 修改供应商
	 * 
	 * @param supplierVO
	 * @return
	 */
	public ModelMap updateSupplier(SupplierVO supplierVO) {
		ModelMap model = new ModelMap();
		SysUserVO userVO = RequestContextUtil.getCurrentUser();
		if (userVO == null) {
			model.put("result", false);
			model.put("remark", "用户未登录。");
			return model;
		}
		supplierVO.setLastUpdater(userVO.getAccount());
		supplierVO.setLastUpdateDate(new Timestamp(new Date().getTime()));
		supplierVO.setIsDel(1);
		supplierVO.setIsLocked(1);
		model.put("result", this.sysSupplierDao.updateSupplier(supplierVO));
		return model;
	}
	
	
	/**
	 * 修改供应商同步状态
	 * 
	 * @param supplierVO
	 * @return
	 */
	public ModelMap updateSupplierState(SupplierVO supplierVO) {
		ModelMap model = new ModelMap();

		//supplierVO.setLastUpdater(userVO.getAccount());
		supplierVO.setLastUpdateDate(new Timestamp(new Date().getTime()));
		supplierVO.setIsDel(1);
		supplierVO.setIsLocked(1);
		model.put("result",  this.sysSupplierDao.updateSupplierState(supplierVO));
		return model;
	}

	/**
	 * 定时任务修改供应商
	 * 
	 * @param supplierVO
	 * @return
	 */
	public ModelMap updateSynSupplier(SupplierVO supplierVO) {
		ModelMap model = new ModelMap();
		supplierVO.setLastUpdater(null);
		supplierVO.setLastUpdateDate(new Timestamp(new Date().getTime()));
		model.put("result", this.sysSupplierDao.updateSupplier(supplierVO));
		return model;
	}

	/**
	 * 删除供应商
	 * 
	 * @param supplierVO
	 * @return
	 */
	public ModelMap delSupplier(SupplierVO supplierVO) {
		ModelMap model = new ModelMap();
		boolean isSucc = this.sysSupplierDao.delSupplier(supplierVO);
		if (isSucc) {
			synSupplierUpdate(supplierVO);
		}
		model.put("result", isSucc);
		return model;
	}

	/**
	 * 编辑供应商
	 * 
	 * @param supplierVO
	 * @return
	 */
	public ModelMap formSupplier(SupplierVO supplierVO) {
		ModelMap map = new ModelMap();

		if (null == supplierVO) {
			map.put("result", false);
			map.put("remark", "对象为null");
			return map;
		}

		if (StringUtils.isNotEmpty(supplierVO.getSupplierId())) {
			// 修改
			return this.updateSupplier(supplierVO);
		} else {
			// 新增
			if (Constant.SUPTYPE_PERSON == supplierVO.getSupType()) {
				supplierVO.setSupNo(SupplierNoUtil.getSupplier_P());
			} else {
				supplierVO.setSupNo(SupplierNoUtil.getSupplier_C());
			}
			return this.addSupplier(supplierVO);
		}
	}
	
	
	/**
	 * 供应商编辑同步
	 * @param supplierVO
	 * @param isUpdateSyn  是否修改同步
	 * @return
	 */
	public String synSupplierForm(SupplierVO supplierVO,boolean isUpdateSyn){
		if (isUpdateSyn) {
			// 修改
			boolean flag = this.synSupplierUpdate(supplierVO);
			StringBuffer sb = new StringBuffer();
			sb.append(flag);
			sb.append("&&");
			String remark = flag == true ? "修改同步成功" : "修改同步失败";
			sb.append(remark);
			sb.append("&&");
			sb.append(new Timestamp(new Date().getTime()));
			return sb.toString();
		} else {//新增
			return this.synSupplierAdd(supplierVO);
		}
	}
	

	/**
	 * 同步供应商添加
	 * 
	 * @param supplier
	 * @return
	 */
	public String synSupplierAdd(SupplierVO supplierVO) {
		logger.info(this.getClass().getName() + "  synSupplierAdd  添加供应商同步到TTW后台调用开始");
		String result = null;
		try {
			JaxWsProxyFactoryBean factory = WSUtils.getProxyFactory(AppKeys.SUPPLIER_WS_ADDRESS, ISupplierWS.class);
			ISupplierWS supplierWS = (ISupplierWS) factory.create();
			HashMap<String, Object> supplierMap = ObjectConvertToMap.toMap(supplierVO);
			SupplierModel supplierModel = (SupplierModel) ObjectConvertToMap.toJavaBean(new SupplierModel(), supplierMap);
			result = supplierWS.insertSupplierToWwt(supplierModel);
			logger.info(this.getClass().getName() + "  synSupplierAdd 添加供应商同步到TTW后台返回结果：" + result);
		} catch (Exception e) {
			logger.info(this.getClass().getName() + " synSupplierAdd 添加供应商同步到TTW后台异常：", e);
			e.printStackTrace();
		}
		logger.info(this.getClass().getName() + "  synSupplierAdd  添加供应商同步到TTW后台调用结束");
		return result;
	}

	/**
	 * 同步供应商修改
	 * 
	 * @param supplier
	 * @return
	 */
	public boolean synSupplierUpdate(SupplierVO supplierVO) {
		logger.info(this.getClass().getName() + "  synSupplierUpdate  修改供应商同步到TTW后台调用开始");
		boolean flag = false;
		try {
			JaxWsProxyFactoryBean factory = WSUtils.getProxyFactory(AppKeys.SUPPLIER_WS_ADDRESS, ISupplierWS.class);
			ISupplierWS supplierWS = (ISupplierWS) factory.create();
			HashMap<String, Object> supplierMap = ObjectConvertToMap.toMap(supplierVO);
			SupplierModel supplierModel = (SupplierModel) ObjectConvertToMap.toJavaBean(new SupplierModel(), supplierMap);
			flag = supplierWS.updateSupplierToWwt(supplierModel);
			logger.info(this.getClass().getName() + "  synSupplierUpdate 添加供应商同步到TTW后台返回结果：" + flag);
		} catch (Exception e) {
			logger.error(this.getClass().getName() + " synSupplierUpdate 同步供应商到TTW后台异常：");
			e.printStackTrace();
		}
		logger.info(this.getClass().getName() + "  synSupplierUpdate  修改供应商同步到TTW后台调用结束");
		return flag;
	}

}
