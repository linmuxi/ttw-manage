/*
 * Copyright 2015 the original author or phly.
 * 未经正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 */
package com.phly.ttw.manage.supplier.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.phly.common.base.dao.MyBatisDao;
import com.phly.ttw.manage.supplier.model.SynRecordVO;

/**
 *
 * @Description: TODO
 * @author wanglong
 * @since 2015年7月1日 上午9:42:21
 */
@Repository
public class SynRecordDao extends MyBatisDao {

	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	public boolean addSynRecord(SynRecordVO synRecordVO){
		boolean flag = false;
		try {
			this.insert("synRecord.addSynRecord", synRecordVO);
			flag = true;
		} catch (Exception e) {
			logger.error(this.getClass().getName() + "  addSynRecord  异常：" + e);
			
		}
		return flag;
	}
	
	
	
	/**
	 * 查询供应商同步失败数据列表
	 * @param supplierVO
	 * @return
	 */
	public List<SynRecordVO> querySupplierFailList(){
		return this.queryList("synRecord.querySupplierFailList",null);
	}
	
	
}
