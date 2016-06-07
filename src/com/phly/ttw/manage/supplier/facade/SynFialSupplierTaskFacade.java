/*
 * Copyright 2015 the original author or phly.
 * 未经正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 */
package com.phly.ttw.manage.supplier.facade;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.phly.common.exceptionhandler.exception.BaseException;
import com.phly.ttw.manage.supplier.model.SupplierVO;
import com.phly.ttw.manage.supplier.service.SupplierService;
import com.phly.ttw.manage.supplier.service.SynTaskService;

/**
 *供应商定时任务同步失败的数据
 * @Description: TODO
 * @author wanglong
 * @since 2015年6月23日 下午12:12:43
 */
public class SynFialSupplierTaskFacade implements SynTaskService {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Resource
	private SupplierService supplierService;
	
	
	@Override
	public void createTask() {
		try {
			logger.info(this.getClass().getName() + " createTask  同步供应商失败数据，定时任务Start.........");
			List<SupplierVO> synFailLst = this.supplierService.querySupplierFailList();
			int count = null != synFailLst && synFailLst.size() > 0 ? synFailLst.size() : 0;
			if(count > 0){
				Iterator<SupplierVO> synSupps = synFailLst.iterator();
				while(synSupps.hasNext()){
					SupplierVO supplier = synSupps.next();
					boolean isUpdateSyn = supplier.getSupSynType() == 1 ? true : false;
					String result = supplierService.synSupplierForm(supplier,isUpdateSyn);
					if(StringUtils.isEmpty(result)){
						supplier.setSupSynCount(supplier.getSupSynCount() + 1);
						supplier.setSupSynState(0);
						supplier.setSupSynRemark("同步失败");
						supplierService.updateSupplierState(supplier);//修改状态为同步失败
					}else{
						String results[] = result.split("&&");
						boolean synSuccess = Boolean.valueOf(results[0]);
						if (synSuccess) {
							supplier.setSupSynCount(supplier.getSupSynCount() + 1);
							supplier.setSupSynState(1);
							supplier.setSupSynRemark("同步成功");
							supplierService.updateSupplierState(supplier);//修改状态为同步
						} else {
							supplier.setSupSynCount(supplier.getSupSynCount() + 1);
							supplier.setSupSynState(0);
							supplier.setSupSynRemark("同步失败");
							supplierService.updateSupplierState(supplier);//修改状态为同步失败
						}
					}
				}
			}
			logger.info(this.getClass().getName() + " createTask  同步供应商失败数据，定时任务end   总更新条数为:"+count+".........");
		} catch (Exception e) {
			logger.error(this.getClass().getName() + " createTask  同步供应商失败数据，定时任务异常：" + e);
			throw new BaseException(this.getClass().getName() + " createTask  异常：" + e);
		}
	}
	

}
