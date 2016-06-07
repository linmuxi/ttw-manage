/*
 * Copyright 2015 the original author or phly.
 * 未经正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 */
package com.phly.ttw.manage.finance.member.service;

import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.phly.common.base.service.ServiceBase;
import com.phly.ttw.manage.finance.member.dao.MemberDao;
import com.phly.ttw.manage.finance.member.model.MemberVO;

/**
 * 会员服务类
 * 
 * @Description TODO
 * @author linyong
 * @since 2015年5月21日 下午11:43:26
 */
@Service
public class MemberService extends ServiceBase {

	@Resource
	private MemberDao memberDao;
	
	/**
	 * 查询会员列表
	 * 
	 * @param memberVO
	 * @return 会员集合
	 */
	public ModelMap queryMemberList(MemberVO memberVO){
		int iCount = this.memberDao.getMemberCount(memberVO);
		List<MemberVO> list = Collections.emptyList();
		if(iCount > 0){
			list = this.memberDao.queryMemberList(memberVO);
		}
		return wrapDatatableResult(iCount, list);
	}
	
	
	public MemberVO queryOneMember(MemberVO memberVO){
		return null;
	}
	
}
