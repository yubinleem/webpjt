package com.example.demo.Controller;

import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.Service.BoardService;
import com.example.demo.dto.BoardDto;

@Controller
public class BoardController {
	
    @Autowired
    private BoardService boardService;

    @RequestMapping("/board/Mainpage.do")
    public ModelAndView mainpage(HttpServletRequest request) throws Exception{
    	
    	HttpSession session = request.getSession();
    	
        ModelAndView mv = new ModelAndView();
        mv.addObject("userSession", session.getAttribute("userSessionInfo"));
        mv.setViewName("board/mainpage");
        
        return mv;
	}
    
    @RequestMapping("/board/Mypage.do")
    public ModelAndView mypage(HttpServletRequest request) throws Exception{
    	
    	HttpSession session = request.getSession();
    	List<BoardDto> list = boardService.selectBoardList();
        ModelAndView mv = new ModelAndView();
        mv.addObject("list", list);
        mv.addObject("userSession", session.getAttribute("userSessionInfo"));
        mv.setViewName("board/Mypage");
        
        return mv;
	}
    
    @RequestMapping("/board/boardWrite.do")
    public ModelAndView boardwrite(HttpServletRequest request) throws Exception{
    	
    	HttpSession session = request.getSession();
    	
        ModelAndView mv = new ModelAndView();
        mv.addObject("userSession", session.getAttribute("userSessionInfo"));
        mv.setViewName("board/boardWrite");
        
        return mv;
	}
    
    @RequestMapping("/board/insertBoard.do")
    public String insertBoard(BoardDto board) throws Exception{
    	System.out.println("111111111111111111111111111111111111111111111");
        boardService.insertBoard(board);
        //mypage -> insertboard -> mypage,
        //mainpage -> insertboard -> mainpage 조건식 추가.
        return "redirect:/board/Mypage.do";
    }
    
    @RequestMapping("/board/updateBoard.do")
    public String updateBoard(BoardDto board) throws Exception{
        boardService.updateBoard(board);
        return "redirect:/board/Mainpage.do";
    }
    
    @RequestMapping("/board/deleteBoard.do")
    public String deleteBoard(int boardseq) throws Exception{
        boardService.deleteBoard(boardseq);
        return "redirect:/board/Mainpage.do";
    }


	
}
