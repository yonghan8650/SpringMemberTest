package com.itwillbs.service;

import java.util.List;

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

	@Override
	public int memberUpdate(MemberVO vo) {
		logger.debug(" S : memberUpdate(MemberVO vo) 실행 ");
		return mdao.updateMember(vo);
	}
	
	@Override
	public int memberDelete(MemberVO vo) {
		logger.debug(" S : memberDelete(MemberVO vo) 실행 ");
		return mdao.deleteMember(vo);
	}

	@Override
	public List<MemberVO> memberList() {
		logger.debug(" S : memberList(MemberVO vo) 실행 ");
		return mdao.getMemberList();
	}
	
	
}






