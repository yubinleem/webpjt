package com.example.demo.Controller;

import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.Service.MailSend;
import com.example.demo.Service.UserService;
import com.example.demo.dto.UserDto;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private MailSend mailsend;
	
    @RequestMapping("/user/userLogin.do")
    public ModelAndView userlogin() throws Exception{
        ModelAndView mv = new ModelAndView("user/userLogin");
        return mv;
	}
    
    @RequestMapping("/user/Myinfo.do")
    public ModelAndView myinfo() throws Exception{
        ModelAndView mv = new ModelAndView("user/Myinfo");
        return mv;
	}
    
    @RequestMapping("/user/userFoundinfo.do")
    public ModelAndView userFoundinfo() throws Exception{
        ModelAndView mv = new ModelAndView("user/userFoundinfo");
        return mv;
	}
    
    @RequestMapping("/user/userSignUp.do")
    public ModelAndView usersignup() throws Exception{
        ModelAndView mv = new ModelAndView("user/Signup");
        return mv;	
	}
    
    @RequestMapping("/user/signupUser.do")
    public String signupUser(UserDto user) throws Exception{
    	userService.signupUser(user);
        return "redirect:/board/Mainpage.do";
    }
    
    @RequestMapping("/user/doubleChk.do")
    @ResponseBody
    public Map doubleChk(UserDto user) throws Exception{
    	
    	Map vParm = new HashMap();
    	
    	vParm.put("result", userService.doubleChk(user));
        return vParm;
   }
        
    
    @RequestMapping("/mail")
    @ResponseBody
    public Map mail(HttpServletRequest request) throws MessagingException, IOException {
    	Map vMap = new HashMap();
    	String email = request.getParameter("email");
    	String type = request.getParameter("type");
    	if (type=="sighup") {
    		vMap.put("authkey",mailsend.sendMail(email,type));
    	}else {
    		vMap.put("temporary",mailsend.sendMail(email,type));
    	}
    	//String temporary = request.getParameter(temporary);
       	return vMap;
    }


    
    @RequestMapping("/authKey")
    @ResponseBody
    public void authKey(MailSend mail ,HttpServletRequest request) throws MessagingException, IOException {
    	String authKey = request.getParameter("userauthKey");
    	
    }
        
    @RequestMapping("/user/Login.do")
    @ResponseBody
    public Map Login(UserDto user,HttpServletRequest request,HttpServletResponse response) throws Exception{
    	Map vParm = new HashMap();
    	Map vParm2 = new HashMap();
    	List<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>(); 
    	
    	int loginChk =  userService.Login(user);
    	
    	if(loginChk > 0) {
    		
    		vParm2.put("userid", user.getUserid());
    		
    		result = userService.userLoginSession(vParm2);
    		HttpSession httpSession = request.getSession();
    		
    		httpSession.setAttribute("userSessionInfo", result);
    	}
    	
    	vParm.put("result", loginChk);
    	
        return vParm;
    }
    
    @RequestMapping("/user/Logout.do")
    public String Logout(HttpServletRequest request,HttpServletResponse response) throws Exception{
    	
    	HttpSession httpSession = request.getSession();
    	httpSession.invalidate();
    	
    	return "redirect:/board/Mainpage.do";
    }
    
    @RequestMapping("/user/foundid.do")
    @ResponseBody
    public Map foundid(UserDto user) throws Exception{
    	
    	Map vParm = new HashMap();
    	
    	vParm.put("result", userService.foundid(user));
    	
        return vParm;
    }
    
    @RequestMapping("/user/foundemail.do")
    @ResponseBody
    public Map foundemail(UserDto user,HttpServletRequest request) throws Exception{
    	
    	Map vParm = new HashMap();
    	String email = request.getParameter("email");
    	user.setUseremail(email);
    	
    	vParm.put("result", userService.emaildoubleChk(user));
    	
        return vParm;
    }
    
}



