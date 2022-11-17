package com.javassem.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javassem.domain.SampleVO;


//@Controller + @ResponseBody 같은 역할
@RestController //ajax 쓸때만 사용
public class SampleController {

	@GetMapping(value= "getText", produces = "text/plain;charset=utf-8")
	public String getText () {
		return "컨트롤러에서 보냄"; //값으로 처리
	}
	
	@GetMapping(value= "getObject")
	public SampleVO getObject () {
      	SampleVO vo = new SampleVO("홍길동",22,"화이팅");
	    return vo;
	}
	
	@GetMapping(value="getList")
	public List<SampleVO> getList () {
		List<SampleVO> list = new ArrayList<SampleVO>();
		list.add(new SampleVO("홍길자",22, "오늘도화이팅1!!"));
		list.add(new SampleVO("홍길국",32, "오늘도화이팅2!!"));
		list.add(new SampleVO("홍길문",42, "오늘도화이팅3!!"));
        return list;	
	}
 	
	
	@GetMapping("sample/{cate}/{cno}")
    public String[] sample(@PathVariable String cate, @PathVariable String cno) {
		return new String[] {"카테고리:" + cate,"상품번호:" + cno};
		
	}
	
	@PostMapping(value= "sample/data")
	public SampleVO submit (SampleVO vo) { //사용자 입력값 받기 -> samplevo 내용이랑 똑같으니께
		System.out.println("sample/data 요청");
		return vo;
	}
	
}
