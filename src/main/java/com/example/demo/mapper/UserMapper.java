package com.example.demo.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.dto.UserDto;

@Mapper
public interface UserMapper {
	
	List<UserDto> selectUserList() throws Exception;
	void userSignUp(UserDto user) throws Exception;
	void signupUser(UserDto user) throws Exception;
	Integer doubleChk(UserDto user) throws Exception;
	Integer Login(UserDto user) throws Exception;
	String foundid(UserDto user) throws Exception;
	Integer emaildoubleChk(UserDto user) throws Exception;
	String foundpwd(UserDto user) throws Exception;
	List<HashMap<String, Object>> userLoginSession(Map vParam) throws Exception;
}

