package com.javassem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javassem.dao.ReplyDAO;
import com.javassem.domain.ReplyVO;

@Service("ReplyService")
public class ReplyServiceImpl implements ReplyService {
  
	@Autowired
	private ReplyDAO replyDAO;
	    
	// 댓글 등록
	public int insertReply(ReplyVO vo) {
		
		return replyDAO.insertReply(vo);
	}   
                
	// 댓글 목록 보기
	public List<ReplyVO> selectAllReply() {
		 return replyDAO.selectAllReply();
	}
 
	//댓글 삭제
	public int deleteReply(Integer rno) {
		return replyDAO.deleteReply(rno);
	}
 
}
