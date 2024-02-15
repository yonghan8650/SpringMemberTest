package com.itwillbs.service;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.itwillbs.domain.MemberVO;
import com.itwillbs.persistence.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService{
	
	private static final Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class);
	
	@Inject
	private MemberDAO mdao;
	
	@Override
	public void memberJoin(MemberVO vo) {
		logger.debug(" S : memberJoin(MemberVO vo) 실행 ");
		mdao.insertMember(vo);
		
	}

	@Override
	public MemberVO memberLogin(MemberVO vo) {
		logger.debug(" S : memberLogin(MemberVO vo) 실행 ");
		
		return mdao.loginMember(vo);		
	}

	@Override
	public MemberVO memberInfo(String userid) {
		logger.debug(" S : memberInfo(String userid) 실행 ");
		return mdao.getMember(userid);
	}
	
}
