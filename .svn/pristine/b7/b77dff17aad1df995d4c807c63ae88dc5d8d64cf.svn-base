/*
 * Copyright 2015 the original author or phly.
 * 未经正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 */
package com.phly.ttw.manage.supplier.facade;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;

import com.phly.common.util.EmailUtils;
import com.phly.ttw.manage.supplier.model.SupplierVO;
import com.phly.ttw.manage.supplier.service.SupplierService;
import com.phly.ttw.manage.supplier.service.SynRecordService;
import com.sun.jmx.snmp.Timestamp;

/**
 *
 * @Description: TODO
 * @author wanglong
 * @since 2015年6月9日 下午7:39:49
 */
@Component
public class SupplierFacade {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Resource
	private SupplierService sysSupplierService;
	
	@Resource
	private SynRecordService synRecordService;

	/**
	 * 查询供应商列表
	 * 
	 * @param supplierVO
	 * @return
	 */
	public ModelMap querySupplieList(SupplierVO supplierVO) {
		return this.sysSupplierService.querySupplierList(supplierVO);
	}

	/**
	 * 查询供应商列表
	 * 
	 * @param supplierVO
	 * @return
	 */
	public List<SupplierVO> querySupplieList() {
		return this.sysSupplierService.querySupplierList();
	}

	/**
	 * 根据供应商ID查询供应商
	 * 
	 * @param supplierVO
	 * @return
	 */
	public ModelMap getSupplier(SupplierVO supplierVO) {
		return this.sysSupplierService.getSupplier(supplierVO);
	}

	/**
	 * 添加供应商
	 * 
	 * @param supplierVO
	 * @return
	 */
	public ModelMap addSupplier(SupplierVO supplierVO) {
		return this.sysSupplierService.addSupplier(supplierVO);
	}
	
	
	/**
	 * 修改供应商同步状态
	 * @param supplierVO
	 * @param isSynUpdate是否为修改同步
	 * @param supSynState
	 */
	public void updateSupplierSynState(SupplierVO supplierVO,boolean isSynUpdate,int supSynState,String remark){
		if(isSynUpdate){//修改同步
			supplierVO.setSupSynType(1);
			supplierVO.setSupSynCount(supplierVO.getSupSynCount() + 1);
		}else{//添加同步
			supplierVO.setSupSynType(0);
			supplierVO.setSupSynCount(1);
		}
		supplierVO.setSupSynState(supSynState);
		supplierVO.setSupSynRemark(remark);
		sysSupplierService.updateSupplierState(supplierVO);
	}

	/**
	 * 修改供应商
	 * 
	 * @param supplierVO
	 * @return
	 */
	public ModelMap updateSupplier(SupplierVO supplierVO) {
		return this.sysSupplierService.updateSupplier(supplierVO);
	}

	/**
	 * 删除供应商
	 * 
	 * @param supplierVO
	 * @return
	 */
	public ModelMap delSupplier(SupplierVO supplierVO) {
		return this.sysSupplierService.delSupplier(supplierVO);
	}

	/**
	 * 编辑供应商
	 * 
	 * @param supplierVO
	 * @return
	 */
	public ModelMap formSupplier(SupplierVO supplierVO) {
		ModelMap model = new ModelMap();
		boolean synSuccess = false;
		String remark = null;
		int supSynType = 0;
		try {
			boolean isUpdateSyn = StringUtils.isNotEmpty(supplierVO.getSupplierId()) ? true : false;
			supSynType = true == isUpdateSyn ? 1 : 0;
			supplierVO.setSupSynType(supSynType);
			
			ModelMap addResult = this.sysSupplierService.formSupplier(supplierVO);
			boolean isSuccess = (Boolean) addResult.get("result");
			// 调用TTW后台接口
			String account = null;
			String password = null;
			if (isSuccess) {//内部管理编辑成功
				String result = this.sysSupplierService.synSupplierForm(supplierVO , isUpdateSyn);
				if(StringUtils.isEmpty(result)){
					logger.error(this.getClass().getName() + " formSupplier 同步供应商信息到TTW后台异常 result is null");
					remark = "同步供应商返回null" + new Timestamp(new Date().getTime());
					updateSupplierSynState(supplierVO,isUpdateSyn,0,remark);//修改状态为同步失败
					model.put("result", false);
					model.put("remark", remark);
					return model;
				}
				String results[] = result.split("&&");
				synSuccess = Boolean.valueOf(results[0]);
				if (synSuccess) {
					logger.info(this.getClass().getName() + " formSupplier 同步供应商信息到TTW后台成功");
					account = results[1];
					password = results[2];
				} else {
					remark = results[1];
					logger.error(this.getClass().getName() + " formSupplier 同步供应商信息到TTW后台异常,原因：" + remark);
					updateSupplierSynState(supplierVO,isUpdateSyn,0,remark);//修改状态为同步失败
					
					model.put("result", false);
					model.put("remark", remark);
					return model;
				}
			}else{//内部管理编辑失败
				logger.error(this.getClass().getName() + " formSupplier 编辑供应商信息到manages异常");
				model.put("result", false);
				model.put("remark", addResult.get("remark"));
				return model;
			}

			if (synSuccess && !isUpdateSyn) {// 同步成功，发邮件
				logger.info(this.getClass().getName() + " addSupplier 同步供应商信息到TTW后台,开始发送邮件。");
				String message = EmailUtils.EMAIL_MSG;
				String m = message.replace("#user#", supplierVO.getSupName());
				String me = m.replace("#account#", account);
				String mess = me.replace("#password#", password);
				boolean isSendSuccess = EmailUtils.multiPartEmail(supplierVO.getSupEmail(), mess);
				if (!isSendSuccess) {// 如果发送不成功,记录到发送失败表
					logger.error(this.getClass().getName() + " addSupplier    新增供应商，邮件发送失败。");
					remark = "同步供应商发送邮件失败！"  + new Timestamp(new Date().getTime());
					updateSupplierSynState(supplierVO,isUpdateSyn,0,remark);//修改状态为同步失败
					model.put("result", false);
					model.put("remark", remark);
					return model;
				} else {
					logger.info(this.getClass().getName() + " addSupplier     新增供应商，邮件发送成功。");
					remark = "新增供应商成功！" + new Timestamp(new Date().getTime()) ;
					updateSupplierSynState(supplierVO,isUpdateSyn,1,remark);//修改状态为同步失败
				}
			} 
		} catch (Exception e) {
			logger.error(this.getClass().getName() + "   addSupplier 同步供应商信息到TTW后台异常: " + e);
			e.printStackTrace();
		}
		model.put("result", synSuccess);
		model.put("remark", remark);
		return model;
	
	}

}
