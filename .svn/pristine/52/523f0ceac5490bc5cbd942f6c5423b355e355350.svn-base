/*
 * Copyright 2015 the original author or phly.
 * 未经正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 */
package com.phly.ttw.manage.supplier.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.phly.common.base.model.SysUserVO;
import com.phly.common.base.service.ServiceBase;
import com.phly.common.util.RequestContextUtil;
import com.phly.ttw.manage.supplier.dao.SynRecordDao;
import com.phly.ttw.manage.supplier.model.SynRecordVO;

/**
 *数据同步service
 * @Description: TODO
 * @author wanglong
 * @since 2015年7月1日 上午9:39:51
 */
@Service
public class SynRecordService extends ServiceBase {

	
	@Resource
	private SynRecordDao synRecordDao;
	
	public ModelMap addSynRecord(SynRecordVO synRecordVO){
		ModelMap model= new ModelMap();
		SysUserVO userVO = RequestContextUtil.getCurrentUser();
		if(userVO != null){
			synRecordVO.setCreator(userVO.getAccount());
			synRecordVO.setLastUpdater(userVO.getAccount());
		}
		synRecordVO.setCreateDate(new Timestamp(new Date().getTime()));
		synRecordVO.setLastUpdateDate(new Timestamp(new Date().getTime()));
		model.put("result", this.synRecordDao.addSynRecord(synRecordVO));
		return model;
	}
	
	
	/**
	 * 查询供应商同步失败数据列表
	 * 
	 * @param supplierVO
	 * @return
	 */
	public List<SynRecordVO> querySupplierFailList() {
		return this.synRecordDao.querySupplierFailList();
	}
}
