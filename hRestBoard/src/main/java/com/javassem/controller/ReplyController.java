package com.javassem.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javassem.domain.ReplyVO;
import com.javassem.service.ReplyService;

@RestController
public class ReplyController {

	@Autowired
	private ReplyService replyService;
	 
	//댓글 목록
	@GetMapping("replies") 
	public List<ReplyVO> selectAll() { 
		return replyService.selectAllReply();
	}
	
	//댓글 삭제
	@DeleteMapping("replies/{rno}") //댓글번호
	public int delete(@PathVariable Integer rno) {
		System.out.println(rno + "삭제");
		return replyService.deleteReply(rno);
	} 
	
	
	//댓글 입력
	@PostMapping("replies/new")  //타입이 post니까 --> reply.js에서
	public String insert(ReplyVO vo) { //입력값 받기
	  System.out.println("입력요청:" + vo);
	  int result = replyService.insertReply(vo); 
	  if(result == 1) return "success";
	  else return "fail";
	 
	}
}  
  