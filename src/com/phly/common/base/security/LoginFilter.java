/*
 * Copyright 2015 the original author or phly.
 * 未经正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 */
package com.phly.common.base.security;

import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextImpl;

/**
 * 登录过滤器
 * @Description TODO
 * @author linyong
 * @since 2015年5月23日 下午10:10:56
 */
public class LoginFilter implements Filter {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	//后台管理平台登录uri
	private static final String loginUrl = "/page/login/login_new.jsp";
	//前台管理平台登录uri
	private static final String loginFrontUrl = "/page/login/login_front.jsp";

	//访问不需要拦截的页面
	private static final String IGNORE_PARAM_NAME = "IGNORE_PAGES";
	public final Set<String> IGNORE_PAGES = new HashSet<String>();
	
	/**
	 * 
	 * @see javax.servlet.Filter#destroy()
	 */
	@Override
	public void destroy() {
	}

	/** 
	 * 登录过滤器 过滤匿名登录
	 * @param arg0
	 * @param arg1
	 * @param arg2
	 * @throws IOException
	 * @throws ServletException
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		String uri = request.getRequestURI();
		//判断是否是忽略y页面
		if (!isCanVisit(uri)) {
			Object obj = request.getSession().getAttribute("SPRING_SECURITY_CONTEXT");
			SecurityContextImpl context = obj == null ? null : (SecurityContextImpl)obj;
			if(context == null || context.getAuthentication() == null || 
					StringUtils.equalsIgnoreCase(context.getAuthentication().getPrincipal().toString(), "anonymousUser")){
				anonymousLogin(request, response);
				return;
			}
		}
		chain.doFilter(arg0, arg1);
	}
	
	/**
	 * 处理匿名登录
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void anonymousLogin(HttpServletRequest request,HttpServletResponse response) throws IOException{
		String uri = request.getRequestURI().toUpperCase();
		if(uri.contains("/PAGE/ADMIN") || uri.contains("/PAGE/BUSINESS/MANAGE")){
			//匿名访问后台管理，跳转到后台管理登录页面
			logger.warn("匿名登录后台管理平台,请求地址："+uri+"  来自IP："+request.getRemoteHost());
			response.sendRedirect(request.getContextPath()+loginUrl);
		}else if(uri.contains("/PAGE/BUSINESS/PORTAL")){
			//匿名访问前台管理，跳转到前台管理登录页面
			logger.warn("匿名登录门户平台,请求地址："+uri+"  "+request.getRemoteHost());
			response.sendRedirect(request.getContextPath()+loginFrontUrl);
		}/*else if(uri.contains("/PAGE/BUSINESS/MANAGE")){
			//匿名访问前台管理，跳转到前台管理登录页面
			logger.warn("匿名登录淘桃网后台管理平台,请求地址："+uri+"  "+request.getRemoteHost());
			response.sendRedirect(request.getContextPath()+loginUrl);
		}*/else{
			//注销操作
			if(request.getRequestURI().toUpperCase().contains("/PAGE/LOGOUT")){
				//0为后台管理注销、1为前台管理注销、2为淘桃网后台管理注销
				String type = request.getParameter("type");
				if(StringUtils.isNotEmpty(type) && Integer.valueOf(type) == 0){
					response.sendRedirect(request.getContextPath()+loginUrl);
				}else if(StringUtils.isNotEmpty(type) && Integer.valueOf(type) == 1){
					response.sendRedirect(request.getContextPath()+loginFrontUrl);
				}/*else if(StringUtils.isNotEmpty(type) && Integer.valueOf(type) == 2){
					response.sendRedirect(request.getContextPath()+loginBgUrl);
				}*/
			}
		}
	}


	/**
     * 判断拦截的页面是否运行访问
     * @return
     */
    protected boolean isCanVisit(String url){ 
        boolean flag = false;
        
        //是否直接忽略页面
        if(IGNORE_PAGES.contains(url)) flag = true;
        
        if(!flag){
            Iterator<String> ignorePages = IGNORE_PAGES.iterator();
            while(ignorePages.hasNext()){
                String page = ignorePages.next();
                //用于判断过滤目录
                if(url.startsWith(page) || url.endsWith(page)){
                    flag = true;
                    break;
                }
            }
        }
        
        return flag;
    }
	
	/**
	 * @param arg0
	 * @throws ServletException
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	@Override
	public void init(FilterConfig config) throws ServletException {
		//初始化登陆忽略的页面
		String pageString = config.getInitParameter(IGNORE_PARAM_NAME);

        if (!StringUtils.isEmpty(pageString)) {
            String[] pages = pageString.split(",");
            if (pages != null) {
                for (String page : pages) {
                    IGNORE_PAGES.add(page);
                }
            }
        }
        StringBuilder b = new StringBuilder();
        for (String s : IGNORE_PAGES) {
            b.append(String.format("需要忽略的页面:[%1$s]\n", s));
        }
	}
}
