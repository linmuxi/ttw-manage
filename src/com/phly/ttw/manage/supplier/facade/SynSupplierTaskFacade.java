/*
 * Copyright 2015 the original author or phly.
 * 未经正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 */
package com.phly.ttw.manage.supplier.facade;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.phly.common.exceptionhandler.exception.BaseException;
import com.phly.common.util.AppKeys;
import com.phly.common.util.DateUtil;
import com.phly.common.util.ObjectConvertToMap;
import com.phly.common.util.WSUtils;
import com.phly.ttw.manage.supplier.model.SupplierModel;
import com.phly.ttw.manage.supplier.model.SupplierVO;
import com.phly.ttw.manage.supplier.service.SupplierService;
import com.phly.ttw.manage.supplier.service.SynRecordService;
import com.phly.ttw.manage.supplier.service.SynTaskService;
import com.phly.ttw.manage.supplier.ws.ISupplierWS;

/**
 *供应商定时任务同步数据
 * @Description: TODO
 * @author wanglong
 * @since 2015年6月23日 下午12:12:43
 */
public class SynSupplierTaskFacade implements SynTaskService {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Resource
	private SupplierService supplierService;
	
	@Resource
	private SynRecordService synRecordService;

	
	@Override
	public void createTask() {
		try {
			logger.info(this.getClass().getName() + " createTask  同步供应商信息获取前一天数据定时任务Start.........");
			Date now = new Date();
			String dayBefore = DateUtil.getDayBefore(now);//获取当前时间的前一天
			JaxWsProxyFactoryBean  factory = WSUtils.getProxyFactory(AppKeys.SUPPLIER_WS_ADDRESS, ISupplierWS.class);
			ISupplierWS supplierWS = (ISupplierWS) factory.create();
			List<SupplierModel> resultList = supplierWS.getSupplierFromWwtByDate(dayBefore);
			int resultCount = null != resultList && resultList.size() > 0 ? resultList.size() : 0;
			logger.info(this.getClass().getName() + " createTask  同步供应商信息获取前一天数据定时任务条数：" + resultCount);
			for (int i = 0; i < resultCount; i++) {
				SupplierModel supplierModel = resultList.get(i);
				HashMap<String,Object> supplierMap =  ObjectConvertToMap.toMap(supplierModel);
				SupplierVO supplierVo = (SupplierVO) ObjectConvertToMap.toJavaBean(new SupplierVO(), supplierMap);
				supplierService.updateSynSupplier(supplierVo);
			}
			logger.info(this.getClass().getName() + " createTask  同步供应商信息获取前一天数据定时任务end.........");
		} catch (Exception e) {
			logger.error(this.getClass().getName() + " createTask  同步供应商信息获取前一天数据定时任务,异常：" + e);
			throw new BaseException(this.getClass().getName() + " createTask  异常：" + e);
		}
	}
	

}
