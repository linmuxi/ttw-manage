/*
 * Copyright 2015 the original author or phly.
 * 未经正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 */
package com.phly.ttw.manage.finance.member.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.directwebremoting.annotations.RemoteProxy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.phly.common.base.action.BaseAction;
import com.phly.common.exceptionhandler.annotation.ExceptionMessage;
import com.phly.ttw.manage.finance.member.facade.MemberFacade;
import com.phly.ttw.manage.finance.member.model.MemberVO;

/**
 * 会员控制类
 * 
 * @Description TODO
 * @author linyong
 * @since 2015年5月21日 下午11:43:26
 */
@Controller
@RemoteProxy
public class MemberAction extends BaseAction{

	@Resource
	private MemberFacade memberFacade;

	/**
	 * 查询会员列表
	 * 
	 * @param memberVO
	 * @return 会员集合
	 */
	@ExceptionMessage("查询会员列表失败，请联系管理员")
	@RequestMapping("/page/business/manage/finance/member/queryMemberList")
	@ResponseBody
	public ModelMap queryMemberList(HttpServletRequest request,MemberVO memberVO){
		wrapDatatableParams(request, memberVO);
		return this.memberFacade.queryMemberList(memberVO);
	}
}
