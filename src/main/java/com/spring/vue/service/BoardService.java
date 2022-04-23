package com.spring.vue.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.vue.mapper.BoardMapper;
import com.spring.vue.vo.BoardVO;

@Service
public class BoardService implements BoardServiceImpl{

	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	@Override
	public List<BoardVO> getBoardList() {
		// TODO Auto-generated method stub
		List<BoardVO> boardList = new ArrayList<BoardVO>();

		try (SqlSession session = sqlSessionFactory.openSession()) {
			BoardMapper mapper = session.getMapper(BoardMapper.class);

			boardList = mapper.getBoardList();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return boardList;
	}
	
	public void registBoard(BoardVO vo) {
		// TODO Auto-generated method stub
		
		vo.setRegDate(new Date());
		vo.setWriter("user");
		
		try (SqlSession session = sqlSessionFactory.openSession()) {
			BoardMapper mapper = session.getMapper(BoardMapper.class);

			mapper.registBoard(vo);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}


}
