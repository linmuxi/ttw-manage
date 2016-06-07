/*
 * Copyright 2015 the original author or phly.
 * 未经正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 */
package com.phly.ttw.manage.finance.member.facade;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;

import com.phly.ttw.manage.finance.member.model.MemberVO;
import com.phly.ttw.manage.finance.member.service.MemberService;

/**
 * 会员代理类
 * 
 * @Description TODO
 * @author linyong
 * @since 2015年5月21日 下午11:43:26
 */
@Component
public class MemberFacade {

	@Resource
	private MemberService memberService;

	/**
	 * 查询会员列表
	 * 
	 * @param memberVO
	 * @return 会员集合
	 */
	public ModelMap queryMemberList(MemberVO memberVO){
		return this.memberService.queryMemberList(memberVO);
	}
}
