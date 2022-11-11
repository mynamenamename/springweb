package myclass.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import myclass.model.MemberVO;

@Controller         //컨트롤 역할 클래스
public class ModelValueController {
 
	@Autowired 
	private MemberVO memberVO;
	
	@RequestMapping("modelValue.do")
	 public ModelAndView test() {
		System.out.println("modelValue.do 요청됨!");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("01_modelValue");
		mv.addObject("vo",memberVO);
		return mv;
	}
	 
	
	
}
