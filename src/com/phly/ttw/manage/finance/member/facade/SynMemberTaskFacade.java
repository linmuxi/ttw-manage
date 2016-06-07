/*
 * Copyright 2015 the original author or phly.
 * 未经正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 */
package com.phly.ttw.manage.finance.member.facade;

import java.sql.Timestamp;
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
import com.phly.ttw.manage.finance.member.model.MemberVO;
import com.phly.ttw.manage.finance.member.service.MemberService;
import com.phly.ttw.manage.member.model.MemberModel;
import com.phly.ttw.manage.member.ws.IMemberWS;
import com.phly.ttw.manage.supplier.model.SynRecordVO;
import com.phly.ttw.manage.supplier.service.SynRecordService;
import com.phly.ttw.manage.supplier.service.SynTaskService;

/**
 *会员定时任务同步数据
 * @Description: TODO
 * @author wanglong
 * @since 2015年6月23日 下午12:12:43
 */
public class SynMemberTaskFacade implements SynTaskService {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Resource
	private MemberService memberService;
	
	@Resource
	private SynRecordService synRecordService;

	
	@Override
	public void createTask() {
		try {
			logger.info(this.getClass().getName() + " createTask  同步会员信息定时任务Start.........");
			Date now = new Date();
			String dayBefore = DateUtil.getDayBefore(now);//获取当前时间的前一天
			JaxWsProxyFactoryBean  factory = WSUtils.getProxyFactory(AppKeys.SUPPLIER_WS_ADDRESS, IMemberWS.class);
			IMemberWS memberWS = (IMemberWS) factory.create();
			List<MemberModel> resultList = memberWS.getMemberFromWwtByDate(dayBefore);
			int resultCount = null != resultList && resultList.size() > 0 ? resultList.size() : 0;
			for (int i = 0; i < resultCount; i++) {
				MemberModel memberModel = resultList.get(i);
				HashMap<String,Object> memberMap =  ObjectConvertToMap.toMap(memberModel);
				MemberVO memberVO = (MemberVO) ObjectConvertToMap.toJavaBean(new MemberVO(), memberMap);
				MemberVO oneMember = memberService.queryOneMember(memberVO);
				if(null != oneMember){
					//memberService.updateSynMember(memberVO);
				}else{
					//memberService.addSynMember(memberVO);
				}
				
			}
			//记录到同步数据表
			SynRecordVO synRecordVO = new SynRecordVO();
			synRecordVO.setSynTime(new Timestamp(new Date().getTime()));
			synRecordVO.setSynTarget(1);
			synRecordVO.setSynType(2);
			synRecordVO.setSynWay(1);
			synRecordVO.setSynState(1);
			synRecordService.addSynRecord(synRecordVO);
			logger.info(this.getClass().getName() + " createTask  同步会员信息定时任务end.........");
		} catch (Exception e) {
			logger.error(this.getClass().getName() + " createTask  异常：" + e);
			throw new BaseException(this.getClass().getName() + " createTask  异常：" + e);
		}
	}
	

}
