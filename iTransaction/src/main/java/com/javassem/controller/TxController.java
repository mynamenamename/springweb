
package com.javassem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.javassem.service.ServiceTx;
import com.javassem.vo.CustomerVO;
import com.javassem.vo.MemberVO;


@Controller
public class TxController {
	@Autowired
	private ServiceTx service;
	
	@RequestMapping(value="/form.do")
	public String txForm(){
		return "form";
	}
	
	@RequestMapping(value="/transfer.do",method=RequestMethod.POST)
	public ModelAndView addAll(CustomerVO cvo,MemberVO mvo) throws Exception{
		service.addAll(cvo, mvo);
		
		ModelAndView ma = new ModelAndView();
		ma.addObject("msg","성공적으로 입력되었습니다.");
	    ma.setViewName("result");
		return ma;
	}
}
