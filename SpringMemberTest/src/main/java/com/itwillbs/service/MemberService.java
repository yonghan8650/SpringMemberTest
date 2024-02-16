package com.itwillbs.service;

import com.itwillbs.domain.MemberVO;

public interface MemberService{
	//회원가입
	public void memberJoin(MemberVO vo);
	
	//로그인
	public MemberVO memberLogin(MemberVO vo);
	
	//내 정보 보기
	public MemberVO memberInfo(String userid);
	
	//내 정보 수정
	public int memberUpdate(MemberVO vo);
	
	//회원탈퇴
	public int memberDelete(MemberVO vo);
}
