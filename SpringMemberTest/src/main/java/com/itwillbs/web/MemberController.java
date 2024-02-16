package com.itwillbs.web;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
		logger.debug(" 회원가입 페이지로 이동 ");
	}
	
	
	
	// 회원가입 처리
	@PostMapping(value="/memberjoin")
	public String memberJoinPOST(MemberVO vo) {
		logger.debug(" memberJoinPOST() 실행 ");
		logger.debug("전달 정보 : " + vo );
		mService.memberJoin(vo);
		
		return "redirect:/member/login";		
	}
	
	// 로그인 입력
		//http://localhost:8088/member/login
		@GetMapping(value="/login")
		public void memberLoginGET() {
			logger.debug(" memberLoginGET() 실행 ");
			logger.debug(" 로그인 페이지로 이동 ");
		}
		
		// 로그인 처리
		@PostMapping(value="/login")
		public String memberLoginPOST(MemberVO vo, HttpSession session) {
			logger.debug(" memberLoginPOST() 실행 ");
			logger.debug(" 전달 정보 : " + vo);
			MemberVO resultVO = mService.memberLogin(vo);
			
			String addr ="";
			if(resultVO == null) {
				logger.debug(" 로그인 실패 ");
				addr = "/member/login";
			} else {
				logger.debug(" 로그인 성공 ");
				session.setAttribute("id", resultVO.getUserid());
				addr = "/member/main";
			}
			
			return "redirect:"+addr;
		}
		//http://localhost:8088/member/main
		// 메인 페이지
		@GetMapping(value="/main")
		public String memberMainGET() {
			logger.debug(" memberMainGET() 실행 ");
			logger.debug(" 메인페이지로 이동 ");
			
			return "/member/main";
		}
		
		// 내 정보 보기
		@GetMapping(value="/info")
		public String memberInfoGET(HttpSession session, Model model) {
			logger.debug(" memberInfoGET(MemberVO vo) 실행 ");
			
			String id = (String)session.getAttribute("id");
			
			MemberVO resultVO = mService.memberInfo(id);
			model.addAttribute("resultVO", resultVO);
			
			return "/member/info";
		}
		
		// 내 정보 수정 GET
		@GetMapping(value="/update")
		public void memberUpdateGET() {
			logger.debug(" memberUpdateGET() 실행 ");
			logger.debug(" 수정페이지로 이동 ");			
		}
		
		// 내 정보 수정 POST
		@PostMapping(value="/update")
		public String memberUpdatePOST(HttpSession session, MemberVO vo) {
			logger.debug(" memberUpdatePOST() 실행 ");
			
			session.getAttribute("id");
			int result = mService.memberUpdate(vo);
			String addr = "";
			if(result == 0) {
				logger.debug(" 정보수정 실패");
				addr="/member/update";
			} else {
				logger.debug("정보수정 성공");
				addr="/member/main";
			}
			return "redirect:"+addr;
		}
		
		// 회원탈퇴 입력
		@GetMapping(value="/delete")
		public void memberDeleteGET() {
			logger.debug(" memberDeleteGET() 실행 ");
			logger.debug(" 회원탈퇴페이지로 이동 ");			
		}
		
		
		// 회원탈퇴 처리
		@PostMapping(value="/delete")
		public String memberDeletePOST(HttpSession session, MemberVO vo) {
			logger.debug(" memberDeletePOST() 실행 ");
			session.getAttribute("id");
			int result = mService.memberDelete(vo);
			String addr = "";
			if (result == 1) {
				// 로그인한 사용자의 세션 초기화
				session.invalidate();
				logger.debug(" 세션 초기화 ");
				logger.debug(" 정상 삭제 - 로그인페이지로 이동 ");
				addr="/member/login";
			} else {
				logger.debug(" 삭제 실패 - 회원탈퇴페이지로 이동 ");
				addr="/member/delete";
			}
			return "redirect:"+addr;
		}
		
}
