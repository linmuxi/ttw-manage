/*
 * Copyright 2015 the original author or phly.
 * 未经正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 */
package com.phly.ttw.manage.finance.member.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.phly.common.base.dao.MyBatisDao;
import com.phly.ttw.manage.finance.member.model.MemberVO;

/**
 * 会员dao类
 * 
 * @Description TODO
 * @author linyong
 * @since 2015年5月17日 下午4:51:46
 */
@Repository
public class MemberDao extends MyBatisDao {

	//private final Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * 查询会员列表
	 * 
	 * @param memberVO
	 * @return 会员集合
	 */
	public List<MemberVO> queryMemberList(MemberVO memberVO){
		return this.queryList("member.queryMemberList", memberVO,
				memberVO.getPageNo(), memberVO.getPageSize());
	}

	/**
	 * 获取会员总数
	 * @param memberVO
	 * @return
	 */
	public int getMemberCount(MemberVO memberVO){
		return (Integer) this.getObject("member.getMemberCount", memberVO);
	}
}
