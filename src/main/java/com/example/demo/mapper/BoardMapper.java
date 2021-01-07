package com.example.demo.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.dto.BoardDto;

@Mapper
public interface BoardMapper {
	List<BoardDto> selectBoardList() throws Exception;
	void insertBoard(BoardDto board) throws Exception;
    BoardDto selectBoardDetail(int boardseq) throws Exception;
    void updateHitCount(int boardseq) throws Exception;
    void updateBoard(BoardDto board) throws Exception;
    void deleteBoard(int boardseq) throws Exception;
    List<HashMap<String, Object>> selectBoardList2() throws Exception;
}

