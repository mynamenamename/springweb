package com.javassem.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jca.cci.object.MappingCommAreaOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javassem.domain.BoardVO;
import com.javassem.service.BoardService;

@Controller
public class BoardController {
   @Autowired
   private BoardService boardService;
   
   //목록보기
   @RequestMapping("getBoardList.do")
   public void getBoardList(String searchCondition, String searchKeyword, Model m) {
       System.out.println("searchCondition: " + searchCondition);
       System.out.println("searchKeyword: " + searchKeyword);
       
       HashMap map = new HashMap();
       map.put("searchCondition", searchCondition);
       map.put("searchKeyword", searchKeyword);
       
       
	   List<BoardVO> list = boardService.getBoardList(map);
       m.addAttribute("boardList", list);
   }
   
   //입력
   @RequestMapping("insertBoard.do")
   public void insertBoard() {
	   
   }
   
   //글쓰기 버튼 눌럿을때 글 저장되는거 
   @RequestMapping("saveBoard.do")
   public String saveBoard(BoardVO boardVO) {
      System.out.println(boardVO.getContent());	   
      boardService.insertBoard(boardVO);
      return "redirect:getBoardList.do"; //글 쓰고 목록으로 나가버리게!!seq를 못받아서 목록으로 갈 수 밖에 없숨
   }
   
   //제목 눌렀을때 상세보기 뜨게끔
   @RequestMapping("getBoard.do") //getboard.list에서 따오는거
   public void getBoard(BoardVO boardVO, Model m) { //boardVO 안에있는 int seq 호출하는거임
   m.addAttribute("board", boardService.getBoard(boardVO));
  // BoardVO resultVO = boardService.getBoard(boardVO);
  // m.addAttribute("board", resultVO); //화면(getboard.jsp)에서 받는 이름 지정
	   }
   
    //수정
   @RequestMapping("updateBoard.do")
   public String updateBoard(BoardVO vo) {
	   boardService.updateBoard(vo);
	    return "redirect:getBoard.do?seq="+vo.getSeq(); //이렇게 해야 수정된 화면에서 멈춤
   }
   
   //삭제
   @RequestMapping("deleteBoard.do")
   public String deleteBoard(BoardVO vo) {
	      boardService.deleteBoard(vo);
	   return "redirect:getBoardList.do";
	   }
   
   //컨트롤러 테스트 함수
   @RequestMapping("test.do")
   public void test() {
	   System.out.println("test.do 요청 확인");
   }
   
   
}