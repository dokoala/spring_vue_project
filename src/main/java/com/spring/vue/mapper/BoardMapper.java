package com.spring.vue.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.spring.vue.vo.BoardVO;

@Mapper
public interface BoardMapper {

	public List<BoardVO> getBoardList();

	public void registBoard(BoardVO vo);
	
}