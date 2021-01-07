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


	
}
