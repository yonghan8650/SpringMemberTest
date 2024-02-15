package com.itwillbs.web;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itwillbs.domain.MemberVO;
import com.itwillbs.service.MemberService;

@Controller
@RequestMapping(value="/member/*")
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	// 서비스 객체 주입
	@Inject
	private MemberService mService;
	
	
	// 회원가입 입력
	//http://localhost:8088/member/memberjoin
	@GetMapping(value="/memberjoin")
	public void memberJoinGET() {
		logger.debug(" memberJoinGET() 실행 ");
		logger.debug(" 뷰페이지로 이동 (WEB-INF/views/member/memberjoin) ");
	}
	
	
	
	// 회원가입 처리
	@PostMapping(value="/memberjoin")
	public String memberJoinPOST(MemberVO vo) {
		logger.debug(" memberJoinPOST() 실행 ");
		logger.debug("전달 정보 : " + vo );
		mService.insertMember(vo);
		
		return "redirect:/member/login";		
	}
	
}
