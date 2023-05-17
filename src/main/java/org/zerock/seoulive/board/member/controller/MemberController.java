package org.zerock.seoulive.board.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zerock.seoulive.board.member.domain.tbl_memberVO;
import org.zerock.seoulive.board.member.exception.ControllerException;
import org.zerock.seoulive.board.member.service.MailSendServiceImpl;
import org.zerock.seoulive.board.member.service.MemberBoardSerivce;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor

@RequestMapping("/member/*")
@Controller
public class MemberController {
	@Setter(onMethod_=@Autowired)
	private MemberBoardSerivce serivce;
	
	@Setter(onMethod_=@Autowired)
	private MailSendServiceImpl mailSerivce;
	
	@RequestMapping(path="find_id_copy",params= {"email"})
	public String find_id(@RequestParam("email") String email, Model model) throws ControllerException{
		
		System.out.println("이메일 인증 요청이 들어옴!");
		System.out.println("이메일 인증 이메일 : "+email);
		
		log.trace("\t find_id({}) invoked.",email);
		try {
			tbl_memberVO vo = this.serivce.get(email);
			model.addAttribute("__BOARD__",vo);
		}catch(Exception e) {
			throw new ControllerException(e);
		}
		return "member/find_id_copy";
	}	// end find_id
	
	@GetMapping(path="find_password")
	public String find_password( Model model)throws ControllerException {
		log.trace("\t find_password({},{}) invoked.",model);
		
		try {
			return "member/find_password";
		}catch(Exception e) {
			throw new ControllerException(e);
		}

	}	// end find_id
	
	@GetMapping(path="find_id_complete",params="email")
	public String find_id_complete(@RequestParam("email") String email,Model model) throws ControllerException{
		
		log.trace("find_id_complete({},{}) invoked.",email,model);
		
		try {
			
			System.out.println("이메일 인증 요청이 들어옴!");
			System.out.println("이메일 인증 이메일 : "+email);
			tbl_memberVO vo = this.serivce.get(email);
			
			model.addAttribute("__BOARD__",vo);
			
			return "member/find_id_complete";
		}catch(Exception e) {
			throw new ControllerException(e);
		}
		
	}	// end find_id
	
	// 이메일 인증
	@GetMapping("/mailCheck")
	@ResponseBody
	public String mailCheck(String email) {
		System.out.println("이메일 인증 요청이 들어옴");
		System.out.println("이메일 인증 이메일 : "+email);
		return this.mailSerivce.joinEmail(email);
	}	// end mailCheck
	
	// 회원가입 페이지 이동
	@GetMapping("/userJoin")
	public void userJoin() {}
	
	
}	// end class

