/*
 * Copyright 2015 the original author or phly.
 * 未经正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 */
package com.phly.ttw.manage.finance.order.facade;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.phly.common.util.AppKeys;
import com.phly.common.util.DateUtil;
import com.phly.common.util.ObjectConvertToMap;
import com.phly.common.util.WSUtils;
import com.phly.ttw.manage.finance.order.model.OrderVO;
import com.phly.ttw.manage.finance.order.service.OrderService;
import com.phly.ttw.manage.order.model.OrderModel;
import com.phly.ttw.manage.order.ws.IOrderWS;
import com.phly.ttw.manage.supplier.model.SynRecordVO;
import com.phly.ttw.manage.supplier.service.SynRecordService;
import com.phly.ttw.manage.supplier.service.SynTaskService;

/**
 *
 * @Description: TODO
 * @author Administrator
 * @since 2015年9月9日 下午11:11:18
 */
public class SynOrderTaskFacade  implements SynTaskService{

	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Resource
	private OrderService orderService;
	
	@Resource
	private SynRecordService synRecordService;
	
	@Override
	public void createTask() {
		try {
			logger.info(this.getClass().getName() + " createTask  同步订单信息定时任务Start.........");
			Date now = new Date();
			String dayBefore = DateUtil.getDayBefore(now);//获取当前时间的前一天
			JaxWsProxyFactoryBean  factory = WSUtils.getProxyFactory(AppKeys.SUPPLIER_WS_ADDRESS, IOrderWS.class);
			IOrderWS orderWS = (IOrderWS) factory.create();
			List<OrderModel> resultList = orderWS.getOrderFromWwtByDate(dayBefore);
			int resultCount = null != resultList && resultList.size() > 0 ? resultList.size() : 0;
			for (int i = 0; i < resultCount; i++) {
				OrderModel orderModel = resultList.get(i);
				HashMap<String,Object> orderMap =  ObjectConvertToMap.toMap(orderModel);
				OrderVO orderVO =  (OrderVO) ObjectConvertToMap.toJavaBean(new OrderVO(), orderMap);
				orderService.synOrderAdd(orderVO);
			}
			//记录到同步数据表
			SynRecordVO synRecordVO = new SynRecordVO();
			synRecordVO.setSynTime(new Timestamp(new Date().getTime()));
			synRecordVO.setSynTarget(1);
			synRecordVO.setSynType(2);
			synRecordVO.setSynWay(1);
			synRecordVO.setSynState(1);
			synRecordService.addSynRecord(synRecordVO);
			logger.info(this.getClass().getName() + " createTask  同步供应商信息定时任务end.........");
		} catch (Exception e) {
			logger.error(this.getClass().getName() + "  createTask  同步订单信息定时任务异常：" + e );
			e.printStackTrace();
		}
	}

}
