package com.example.demo.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.demo.dto.UserDto;

public interface UserService {
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
