package com.javassem.service;

import java.util.List;

import com.javassem.domain.BoardVO;
import com.javassem.domain.ReplyVO;

public interface ReplyService {

	// 댓글 등록
	int insertReply(ReplyVO vo);

	// 댓글 목록
	List<ReplyVO> selectAllReply();
 
	// 댓글 삭제
	int deleteReply(Integer rno);
}

