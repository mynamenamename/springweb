package com.javassem.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.javassem.dao.MemberDAO;
import com.javassem.domain.MemberVO;
import com.javassem.service.MemberService;

@Controller
@RequestMapping("user")
public class MemberController {

	@Autowired
	private MemberService memberService; //이렇게만 하면 null값이니까 auto 붙여주기
	
	
//	//회원가입 눌렀을때 들어갈 수 있게끔
//	@RequestMapping("userJoin.do")
//	public void userJoin() {
//		System.out.println("userJoin 확인");
//		
//	}	
	
//DB 안 거치고 화면만 띄우는 것들 >> 매번매번 MAPPING 하지 않고 여기 거치도록
		@RequestMapping("/{url}.do")
		public String userJoin(@PathVariable String url) {
		System.out.println("경로:" + url);
	    return "/user/" + url;
		}
	
		
	
          //회원가입이 등록이 눌렸을때 받는 변수
		
		/*
		 * 요청   : /user/userInsert.do
		 * 뷰페이지: user/userJoin_ok.jsp
		 */
		@RequestMapping("userInsert.do")
		public ModelAndView UserInsert(MemberVO memberVO) { //입력값 얻어오는 것!
			 System.out.println(memberVO.getUserName());
			
			 int result = memberService.userInsert(memberVO);
			 String message = "가입되지 않았습니다";
			 if( result==1) message = memberVO.getUserName() + "님 가입을 축하합니다!";
			 //입력하지 않았으니까 1
			 
			 ModelAndView mv = new ModelAndView();
			 mv.setViewName("user/userJoin_ok"); //넘어갈 뷰페이지 이름 작성!!!
			 mv.addObject("message",message); //화면에 찍으려고 (userjoin_ok에)      
			 
			 return mv;
			
		}
		
		//로그인 요청받기!!
		//****************************
		//세션 사용 -> 인자에 HttpSession 변수 선언
		@RequestMapping("login.do")
		public String login (MemberVO vo, HttpSession session) { //사용자가 입력한 값 받기, userLogin, memberVO NAME 같은지 확인
		  MemberVO result = memberService.idCheck_Login(vo);
		       //로그인 실패
			if(result==null || result.getUserId() == null) {
				return "/user/userLogin";
			}else {
				//로그인 성공
				//세션에 저장
				session.setAttribute("login", vo.getUserId());
				return "/user/login_ok";
			}
		}
		
		
		//****************************
		// 일반 요청 함수에서 String 리턴 : 뷰페이지 지정
		// 이 요청에 Ajax 통신에 의해 값을 전송해야 된당
		@ResponseBody  // 신호 보내기,,, > 화면 안 바꿀꺼니께 
		@RequestMapping(value= "idCheck.do" , produces = "application/text;charset=utf-8")
		public String CheckId(MemberVO vo) {
		
		 System.out.println("idCheck.do 요청 :" + vo.getUserId());
			
		 MemberVO result = memberService.idCheck_Login(vo);
		 String message = "사용가능한 아이디입니다~!";
		 if(result != null) message = "중복된 아이디가 존재합니다";
		 
		 System.out.println("message : " + message);
		 
		 return message;
		}
		
		
}
