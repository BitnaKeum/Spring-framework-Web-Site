package com.kwce.dao;

import java.util.List;


import com.kwce.domain.BoardVO;
import com.kwce.paging.*;

public interface BoardDAO {
	public void create(BoardVO vo) throws Exception;
	
	public BoardVO read(Integer bno) throws Exception;

	public void update(BoardVO vo) throws Exception;

	public void delete(Integer bno) throws Exception;
	
	public void increaseViewCnt(Integer bno) throws Exception;
	
	public void deleteall(BoardVO vo) throws Exception;
	
	public List<BoardVO> listAll() throws Exception;
	
	public List<BoardVO> list_SEOUL() throws Exception;
	
	public List<BoardVO> list_GYEONGGI() throws Exception;
	
	public List<BoardVO> list_INCHEON() throws Exception;
	
	public List<BoardVO> list_DAEJEON() throws Exception;
	
	public List<BoardVO> list_CHUNGCHEONG() throws Exception;
	
	public List<BoardVO> list_KANGWON() throws Exception;
	
	public List<BoardVO> list_DAEGU() throws Exception;
	
	public List<BoardVO> list_JEOLLA() throws Exception;
	
	public List<BoardVO> list_BUSAN() throws Exception;
	
	public List<BoardVO> list_GYEONGSANG() throws Exception;
	
	public List<BoardVO> list_JEJU() throws Exception;
	
	public void updateLikeCnt(Integer bno) throws Exception;

	public void updateHateCnt(Integer bno) throws Exception;

	public List<BoardVO> listPaging(int page) throws Exception;
	public List<BoardVO> listCriteria(Criteria criteria) throws Exception;
	public int countBoard(Criteria criteria) throws Exception;
}
