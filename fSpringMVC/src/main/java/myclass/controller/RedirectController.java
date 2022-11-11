package myclass.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class RedirectController {

	@RequestMapping("insert.do")
	public String test1() {
		System.out.println("insert.do 출력");
		//****************** 
		//데이터 안 넣었으니까 안 들어가징
		//return "select"; 뷰페이지만 지정
		//*************************
		//redirecting 
		return "redirect:select.do";
	}
	
	@RequestMapping("select.do")
	public void test2(Model m) {
		System.out.println("select.do 출력");
		m.addAttribute("info","디비에서 넘어온 값"); 
	}
}
