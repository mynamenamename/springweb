package myclass.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import myclass.model.MemberVO;

/*
 * 모델(데이터)를 뷰페이지로 전송
 * 
 * 1. ModelAndView 리턵 
 *     -addObject()
 * 2. Model (호출 함수의 인자에 선언만하기)
 *     -setAttribute()
 *     
 */


@Controller
@RequestMapping("/review") //05_review.jsp에 review가 다 붙엉있응께
public class ReviewController {

	@RequestMapping("/modelandview.do")
	 public ModelAndView test() {
		 //1. ModelAndView 뷰페이지 지정
		ModelAndView mv = new ModelAndView();
		mv.setViewName("review/void");
		mv.addObject("greeting", "오늘행복"); //이름, value값 지정
		mv.addObject("test", "테스트입니당"); //이름, value값 지정
		return mv;
	 } 
	
	@RequestMapping("/string.do")
	//************************
	//model: view단으로 데이터 전송하는 객체
	//            >>>> 인자에 지정
	 public String test2(Model m) { //모델이 밖으로 찍혀서 나감!
		 //2. 문자열 리턴 뷰페이지 지정
		m.addAttribute("greeting", "오늘행복");
		m.addAttribute("test", "테스트입니당");
		return "review/void"; 
		
    }
	
	
	@RequestMapping("/void.do")  //이렇게만 하면 끝,,,
	 public void test3(Model m) {
		 //3. void 리턴 뷰페이지 지정
		 //      >>요청명과 동일한 뷰페이지로 자동 지정됨
		m.addAttribute("greeting", "오늘행복");
		m.addAttribute("test", "테스트입니당");
		
		
	 }
	 
}
