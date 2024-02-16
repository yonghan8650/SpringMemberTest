package com.itwillbs.persistence;

import java.util.List;

import com.itwillbs.domain.MemberVO;

public interface MemberDAO {
	
	// 회원가입
	public void insertMember(MemberVO vo);
	
	// 로그인
	public MemberVO loginMember(MemberVO vo);
	
	// 내 정보 보기
	public MemberVO getMember(String userid);
	
	// 내 정보 수정
	public int updateMember(MemberVO vo);
	
	// 회원탈퇴
	public void deleteMember(MemberVO vo);
	
	// 회원 리스트
	public List<MemberVO> getMemberList();

}
