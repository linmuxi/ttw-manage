/*
 * Copyright 2015 the original author or phly.
 * 未经正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 */
package com.phly.common.util;

import java.util.Properties;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.phly.common.exceptionhandler.exception.BaseException;

/**
 *邮件发送工具类
 * @Description: TODO
 * @author wanglong
 * @since 2015年6月29日 下午4:47:25
 */
public class EmailUtils {

	private final static Logger logger = LoggerFactory.getLogger(EmailUtils.class);
	private static String EMAIL_HOSTNAME = null;//邮件服务器地址
	private static String EMAIL_USERNAME = null;//邮件服务器用户名
	private static String EMAIL_PASSWORD = null;//邮件服务器密码
	private static String EMAIL_SUBJECT=null;//邮件标题
	public static String EMAIL_MSG=null;//邮件内容
	public static String SUPPLIER_PASSWORD=null;
	
	static{
		Properties properties =  (Properties) ApplicationContextUtil.getApplicationContext().getBean("propertiesFactoryBean");
		EMAIL_HOSTNAME = properties.getProperty("email.host.name");
		EMAIL_USERNAME = properties.getProperty("email.user.name");
		EMAIL_PASSWORD = properties.getProperty("email.user.password");
		EMAIL_SUBJECT = properties.getProperty("email.supplier.text.subject");
		EMAIL_MSG = properties.getProperty("email.supplier.text.msg");
		SUPPLIER_PASSWORD = properties.getProperty("supplier.user.password");
	}
	
	
	/**
	 * 发送邮件
	 * @param supEmailAddress
	 * @return
	 */
	public static boolean multiPartEmail(String supEmailAddress,String message){
		boolean sendFlag = false;
		try {
			HtmlEmail htmlEmail = new HtmlEmail();
			htmlEmail.setHostName(EMAIL_HOSTNAME);// 你的邮件服务器的地址
			htmlEmail.setAuthentication(EMAIL_USERNAME,EMAIL_PASSWORD);
			htmlEmail.setCharset("UTF-8");
			htmlEmail.addTo(supEmailAddress);
			// 设置收件人，如果想添加多个收件人，将此语句多写几次即可。其中参数1，代表收件人邮件地址；
			htmlEmail.setFrom(EMAIL_USERNAME);// 发件人
			htmlEmail.setSubject(EMAIL_SUBJECT);
			htmlEmail.setMsg(message);
			htmlEmail.send();// 发送邮件
			sendFlag = true;
		} catch (EmailException e) {
			logger.error(EmailUtils.class.getName() + " multiPartEmail  发送邮件异常异常：" + e);
			throw new BaseException(EmailUtils.class.getName() + " multiPartEmail  发送邮件异常异常：" + e);
		}
		return sendFlag;
	}
}
