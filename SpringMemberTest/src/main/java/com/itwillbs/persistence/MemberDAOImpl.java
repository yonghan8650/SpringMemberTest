package com.itwillbs.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.itwillbs.domain.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberDAOImpl.class);
	@Inject
	private SqlSession sqlSession;
	
	private static final String NAMESPACE = "com.itwillbs.mapper.memberMapper";

	// 회원가입
	@Override
	public void insertMember(MemberVO vo) {
		logger.debug(" insertMember(MemberVO vo) 실행 ");
		logger.debug(" sqlSession -> mapper 호출 ");
		
		sqlSession.insert(NAMESPACE + ".insertMember", vo);
		
		logger.debug(" insertMember 호출 완료 ");				
	}
	
	// 로그인
	@Override
	public MemberVO loginMember(MemberVO vo) {
		logger.debug(" loginMember(MemberVO vo) 실행 ");
		logger.debug(" sqlSession -> mapper 호출 ");
		
		MemberVO resultVO= sqlSession.selectOne(NAMESPACE + ".loginMember", vo);
		
		logger.debug(" loginMember 호출 완료 ");
		
		return resultVO;
	}
	
	// 내 정보 보기
	@Override
	public MemberVO getMember(String userid) {
		logger.debug(" getMember(String userid) 실행 ");
		
		return sqlSession.selectOne(NAMESPACE + ".getMember", userid);
	}
	
	// 내 정보 수정
	@Override
	public int updateMember(MemberVO uvo) {
		logger.debug(" updateMember(MemberVO uvo) 실행 ");
		logger.debug(" sqlSession -> mapper 호출 ");
		
		logger.debug(" updateMember 호출 완료");
		
		return sqlSession.update(NAMESPACE + ".updateMember", uvo);
		
	}
	
	// 회원탈퇴
	@Override
	public int deleteMember(MemberVO vo) {
		logger.debug(" deleteMember(MemberVO dvo) 실행 ");
		logger.debug(" sqlSession -> mapper 호출 ");
		
		logger.debug(" deleteMember 호출 완료 ");
		
		return sqlSession.delete(NAMESPACE + ".deleteMember", vo);
				
	}
	
	// 회원리스트
	@Override
	public List<MemberVO> getMemberList(){
		logger.debug(" getMemberList(MemberVO vo) 실행 ");
		
		return sqlSession.selectList(NAMESPACE + ".getMemberList");
	}
	
}
