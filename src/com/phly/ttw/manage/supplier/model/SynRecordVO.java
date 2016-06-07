/*
 * Copyright 2015 the original author or phly.
 * 未经正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 */
package com.phly.ttw.manage.supplier.model;

import java.sql.Timestamp;

import org.directwebremoting.annotations.DataTransferObject;

import com.phly.common.base.model.BaseVO;

/**
 *同步记录表
 * @Description: TODO
 * @author wanglong
 * @since 2015年6月30日 下午5:23:05
 */
@DataTransferObject
public class SynRecordVO extends BaseVO {

	/**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = 1L;

	private String id;

	private Timestamp synTime;

	// 1:供应商 2：产品
	private int synTarget;
	
	//同步类型 1：新增 2：修改
	private int synType;

	// 1:程序定时任务 2：手动
	private int synWay;

	// 1：成功 0：失败
	private int synState;

	private String creator;

	private Timestamp createDate;

	private String lastUpdater;

	private Timestamp lastUpdateDate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Timestamp getSynTime() {
		return synTime;
	}

	public void setSynTime(Timestamp synTime) {
		this.synTime = synTime;
	}

	public int getSynTarget() {
		return synTarget;
	}

	public void setSynTarget(int synTarget) {
		this.synTarget = synTarget;
	}
	
	public int getSynType() {
		return synType;
	}

	public void setSynType(int synType) {
		this.synType = synType;
	}

	public int getSynWay() {
		return synWay;
	}

	public void setSynWay(int synWay) {
		this.synWay = synWay;
	}

	public int getSynState() {
		return synState;
	}

	public void setSynState(int synState) {
		this.synState = synState;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public String getLastUpdater() {
		return lastUpdater;
	}

	public void setLastUpdater(String lastUpdater) {
		this.lastUpdater = lastUpdater;
	}

	public Timestamp getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(Timestamp lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

}
