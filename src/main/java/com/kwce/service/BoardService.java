package com.kwce.service;

import java.util.List;


import com.kwce.domain.BoardVO;
import com.kwce.paging.*;

public interface BoardService {
	public void regist(BoardVO board) throws Exception;
	
	public BoardVO read(Integer bno) throws Exception;

	public void modify(BoardVO board) throws Exception;

	public void remove(Integer bno) throws Exception;
	
	public void removeall(BoardVO board) throws Exception;
	
	public List<BoardVO> listAll() throws Exception;
	
	public List<BoardVO> list_SEOUL() throws Exception;
	
	public List<BoardVO> list_GYEONGGI () throws Exception;
	
	public List<BoardVO> list_INCHEON() throws Exception;
	
	public List<BoardVO> list_DAEJEON() throws Exception;
	
	public List<BoardVO> list_CHUNGCHEONG() throws Exception;
	
	public List<BoardVO> list_KANGWON() throws Exception;
	
	public List<BoardVO> list_DAEGU() throws Exception;
	
	public List<BoardVO> list_JEOLLA() throws Exception;
	
	public List<BoardVO> list_BUSAN() throws Exception;
	
	public List<BoardVO> list_GYEONGSANG() throws Exception;
	
	public List<BoardVO> list_JEJU() throws Exception;
	
	 public void like(Integer bno) throws Exception;
	   
	 public void hate(Integer bno) throws Exception;
	
	 public List<BoardVO> listCriteria(Criteria criteria) throws Exception;

		public int countBoard(Criteria criteria) throws Exception;
}
