package com.spring.vue.controller;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.vue.service.BoardService;
import com.spring.vue.vo.BoardVO;
import com.spring.vue.vo.ResultVO;

@CrossOrigin(origins = "*")
@Controller
@RequestMapping("board/")
public class BoardController {

	private static final Logger LOG = LoggerFactory.getLogger(BoardController.class);

	@Autowired
	BoardService service;

	@ResponseBody
	@RequestMapping(value = "get-board-list.do", method = RequestMethod.GET)
	public ResultVO getBoardList() 
	{	
		// 호출 시 찍히게 될 로그
		LOG.info("[GET] getBoardList");
		// 결과 값을 담을 ResultVO를 선언한 생성자를 통해서 만드는데 기본값은 success는 false, result는 null로 세팅
		ResultVO result = new ResultVO(false, null);

		try {
			result.setResult(service.getBoardList());
			result.setSuccess(true);
		} catch (Exception e) {
			// TODO: handle exception
			LOG.error("[Board] getBoardList : " + e.getMessage(), e);
		}

		return result;

	}
	
	@ResponseBody
	@RequestMapping(value = "regist-board.do", method = RequestMethod.POST)
	public ResultVO registBoard(@RequestBody BoardVO vo) 
	{	
		// 호출 시 찍히게 될 로그
		LOG.info("[POST] registBoard");
		// 결과 값을 담을 ResultVO를 선언한 생성자를 통해서 만드는데 기본값은 success는 false, result는 null로 세팅
		ResultVO result = new ResultVO(false, null);

		try {
			service.registBoard(vo);
			result.setSuccess(true);
		} catch (Exception e) {
			// TODO: handle exception
			LOG.error("[Board] getBoardList : " + e.getMessage(), e);
		}

		return result;

	}
}