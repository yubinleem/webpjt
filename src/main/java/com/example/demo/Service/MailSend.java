package com.example.demo.Service;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Random;
import java.util.UUID;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import com.example.demo.dto.UserDto;

@Component
public class MailSend {
///////////////////////////////////////////////////////////////
	@Autowired
	private JavaMailSender javaMailSender;
	@Autowired
	private UserService userService;
	
    //인증키 생성
	private int size;
	
    private String getKey(int size) {
        this.size = size;
        return getAuthCode();
    }

    //인증코드 난수 발생
    private String getAuthCode() {
        Random random = new Random();
        StringBuffer buffer = new StringBuffer();
        int num = 0;

        while(buffer.length() < size) {
            num = random.nextInt(10);
            buffer.append(num);
        }

        return buffer.toString();
    }
//////////////////////////////////////////////////////////////////

    private String getTemporary() {
    	String uuid = UUID.randomUUID().toString();
    	String[] array = uuid.split("-");
    	
    	return array[0];
    }
    
//////////////////////////////////////////////////////////////////
	@Autowired
	private SpringTemplateEngine templateEngine;

	
	public String sendMail(String email,String type) throws MessagingException, IOException {
		String authKey = getKey(6);
		String temporary = getTemporary();
		UserDto user = new UserDto();
		
		
		try {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        
        //메일 제목 설정
        if(type.equals("signup")) {
        	helper.setSubject("회원가입 이메일 인증");
        }else {
        	helper.setSubject("임시 비밀번호 전송");
        }
        //수신자 설정
        helper.setTo(email);
        //템플릿에 전달할 데이터 설정
        Context context = new Context();
        context.setVariable("test_key", "test_value");
        if(type.equals("signup")) {
        	helper.setText("회원가입 인증키 입니다."+authKey+"를 인증번호란에 입력해주세요.");
        }else {
        	helper.setText("임시 비밀번호 : "+temporary);
        	user.settemporary(temporary);
        	user.setUseremail(email);
        	userService.pwdchange(user);
        }
        
        //메일 보내기
        javaMailSender.send(message);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return authKey;
	}
}
