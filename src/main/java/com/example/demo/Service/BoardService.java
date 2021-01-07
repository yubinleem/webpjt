package com.example.demo.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.mail.MessagingException;

import com.example.demo.dto.BoardDto;

public interface BoardService {
	List<BoardDto> selectBoardList() throws Exception;
	void insertBoard(BoardDto board) throws Exception;
	BoardDto selectBoardDetail(int boardseq) throws Exception;
    void updateBoard(BoardDto board) throws Exception;
    void deleteBoard(int boardseq) throws Exception;
    List<HashMap<String, Object>> selectBoardList2() throws Exception;
}
