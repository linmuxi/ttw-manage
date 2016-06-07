/*
 * Copyright 2015 the original author or phly.
 * 未经正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 */
package com.phly.common.activiti.utils;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.phly.common.activiti.facade.ActivitiFacade;
import com.phly.common.activiti.service.FormProcessService;

/**
 * 工作流帮助类
 * 
 * @Description: 提供上下文容器，获取bean对象
 * @author linyong
 * @since 2015年5月17日 下午12:12:54
 */
public class ActivitiUtil implements ApplicationContextAware {

	@Resource
	private ActivitiFacade activitiFacade;
	
	@Resource
	private FormProcessService formProcessService;
	
	/**
	 * 根据业务表单名称启动工作流
	 * @param formName 业务表单名称
	 * @param businessKey 业务key
	 * @param variables 流程变量
	 * @return 流程实例ID
	 */
	public String startWorkFlowByFormName(String formName,String businessKey,Map<String, Object> variables){
		return activitiFacade.startWorkflow(this.formProcessService.getProcessDefinitionIdByFormName(formName),businessKey,variables);
	}
	
	/**
	 * 根据流程定义ID启动工作流
	 * @param formName 业务表单名称
	 * @param businessKey 业务key
	 * @param variables 流程变量
	 * @return 流程实例ID
	 */
	public String startWorkFlowByProcessDefinitionId(String processDefinitionId,String businessKey,Map<String, Object> variables){
		return activitiFacade.startWorkflow(processDefinitionId,businessKey,variables);
	}
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
	}
}
