package myclass.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import myclass.model.MemberVO;

@Controller         //컨트롤 역할 클래스
public class paramConroller {
 
	@RequestMapping("param.do") 
	public void test(MemberVO vo) {
		System.out.println("param.do 실행");
	}
}
