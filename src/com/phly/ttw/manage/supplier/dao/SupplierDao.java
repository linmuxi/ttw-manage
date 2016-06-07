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
import com.phly.ttw.manage.supplier.model.SupplierVO;

/**
 *
 * @Description: TODO
 * @author Administrator
 * @since 2015年6月9日 下午7:02:17
 */
@Repository
public class SupplierDao extends MyBatisDao {

	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	/**
	 * 查询供应商列表
	 * @param supplierVO
	 * @return
	 */
	public List<SupplierVO> querySupplierList(SupplierVO supplierVO){
		return this.queryList("sysSupplier.querySysSupplierList", supplierVO,supplierVO.getPageNo(),supplierVO.getPageSize());
	}
	
	
	/**
	 * 查询供应商列表
	 * @param supplierVO
	 * @return
	 */
	public List<SupplierVO> querySupplierList(){
		return this.queryList("sysSupplier.querySysSupplierList",null);
	}
	
	
	
	/**
	 * 查询同步失败的供应商列表信息
	 * @return
	 */
	public List<SupplierVO> querySupplierFailList(){
		return this.queryList("sysSupplier.querySupplierFailList",null);
	}
	
	
	/**
	 * 查询供应商总数
	 * @param supplierVO
	 * @return
	 */
	public int getSupplierCount (SupplierVO supplierVO){
		return (Integer) this.getObject("sysSupplier.getSupplierCount", supplierVO);
	}
	
	
	/**
	 * 根据供应商ID或者供应商名称查询供应商信息
	 * @param supplierVO
	 * @return
	 */
	public SupplierVO getSupplier(SupplierVO supplierVO){
		return (SupplierVO) this.getObject("sysSupplier.getSupplier", supplierVO);
	}
	
	
	/**
	 * 添加供应商信息
	 * @param supplierVO
	 * @return
	 */
	public boolean addSupplier(SupplierVO supplierVO){
		boolean flag = false;
		try {
			this.insert("sysSupplier.addSupplier",supplierVO);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(this.getClass().getName() + "addSupplier  添加供应商失败,"+e);
		}
		return flag;
	}
	
	
	/**
	 * 修改供应商信息
	 * @param supplierVO
	 * @return
	 */
	public boolean updateSupplier(SupplierVO supplierVO) {
		boolean flag = false;
		try {
			this.update("sysSupplier.updateSupplier",supplierVO);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(this.getClass().getName() + "updateSupplier  修改供应商信息失败,"+e);
		}
		return flag;
	}
	
	
	/**
	 * 修改供应商状态
	 * @param supplierVO
	 * @return
	 */
	public boolean updateSupplierState(SupplierVO supplierVO) {
		boolean flag = false;
		try {
			this.update("sysSupplier.updateSupplierState",supplierVO);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(this.getClass().getName() + "updateSupplierState  修改供应商状态失败,"+e);
		}
		return flag;
	}
	
	
	
	
	/**
	 * 删除供应商
	 * @param supplierVO
	 * @return
	 */
	public boolean delSupplier(SupplierVO supplierVO) {
		boolean flag = false;
		try {
			this.delete("sysSupplier.delSupplier",supplierVO);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(this.getClass().getName() + "delSupplier  删除供应商信息失败,"+e);
		}
		return flag;
	}
}
