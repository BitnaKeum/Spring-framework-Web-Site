package com.kwce.controller;

import java.util.List;


import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kwce.dao.BoardDAO;
import com.kwce.domain.BoardVO;
import com.kwce.paging.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class BoardDAOTest {
	@Autowired
	private BoardDAO dao;
	
	private static final Logger logger = LoggerFactory.getLogger(BoardDAOTest.class);
	
	@Test @Ignore
	public void testCreate() throws Exception{
		BoardVO board = new BoardVO();
		board.setTitle("새로운 글을 넣습니다.");
		board.setContent("새로운 글을 넣습니다.");
		board.setWriter("2017202039");
		dao.create(board);
	}
	
	@Test @Ignore
	public void testRead() throws Exception{
		logger.info(dao.read(1).toString());
	}
	
	@Test @Ignore
	public void testUpdate() throws Exception{
		BoardVO board = new BoardVO();
		board.setBno(1);
		board.setTitle("수정된 글입니다.");
		board.setContent("수정 테스트");
		dao.update(board);
	}
	
	@Test @Ignore
	public void testDelete() throws Exception{
		dao.delete(1);
	}
	
	@Before
	public void testTenCreate() throws Exception{
		BoardVO board = new BoardVO();
		for(int i=0;i<10;i++){
			board.setTitle(i+"번째 글을 넣었습니다.");
			board.setContent("새로운 글을 넣습니다.");
			board.setWriter("2017202039");
			dao.create(board);
		}
	}
	
	@Test
	public void testListAll() throws Exception{
		List<BoardVO> list = dao.listAll();
		for(BoardVO boardVO : list) {
			logger.info(boardVO.getBno()+":"+boardVO.getTitle());
		}
	}
	
	
	@Test
	public void testListPaging() throws Exception{
		int page = 3;
		List<BoardVO> list = dao.listPaging(page);
		for(BoardVO boardVO : list) {
			logger.info(boardVO.getBno()+":"+boardVO.getTitle());
		}
	} 
	
	@Test @Ignore
	public void testListCriteria() throws Exception{
		Criteria criteria = new Criteria();
		criteria.setPage(3);
		criteria.setPerPageNum(5);
		
		List<BoardVO> list = dao.listCriteria(criteria);
		for(BoardVO boardVO : list) {
			logger.info(boardVO.getBno()+":"+boardVO.getTitle());
		}
	}
}
