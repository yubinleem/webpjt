package com.example.demo.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.BoardDto;
import com.example.demo.dto.UserDto;
import com.example.demo.mapper.UserMapper;


@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<UserDto> selectUserList() throws Exception{
    	return userMapper.selectUserList();
    }
    @Override
    public void userSignUp(UserDto user) throws Exception{
      userMapper.userSignUp(user);
    }

    @Override
    public void signupUser(UserDto user) throws Exception{
    	userMapper.signupUser(user);
    }
    
    @Override
    public Integer doubleChk(UserDto user) throws Exception{
    	return userMapper.doubleChk(user);
    }
    
    @Override
    public Integer Login(UserDto user) throws Exception{
    	return userMapper.Login(user);
    }
    
    @Override
    public String foundid(UserDto user) throws Exception{
    	return userMapper.foundid(user);
    }
    
    @Override
    public Integer emaildoubleChk(UserDto user) throws Exception{
    	return userMapper.emaildoubleChk(user);
    }
    
    @Override
    public String foundpwd(UserDto user) throws Exception{
    	return userMapper.foundpwd(user);
    }
    
    @Override
    public List<HashMap<String, Object>> userLoginSession(Map vParam) throws Exception{
    	return userMapper.userLoginSession(vParam);
    }
    
}