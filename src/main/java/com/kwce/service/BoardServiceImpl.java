package com.kwce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kwce.dao.BoardDAO;
import com.kwce.domain.BoardVO;
import com.kwce.paging.*;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardDAO dao;
	
	@Override
	public void regist(BoardVO board) throws Exception {
		dao.create(board);
	}

	@Override
	public BoardVO read(Integer bno) throws Exception {
		dao.increaseViewCnt(bno);
		return dao.read(bno);
	}

	@Override
	public void modify(BoardVO board) throws Exception {
		dao.update(board);
	}

	@Override
	public void remove(Integer bno) throws Exception {
		dao.delete(bno);
	}
	
	@Override
	public void removeall(BoardVO board) throws Exception {
		dao.deleteall(board);
	}

	@Override
	public List<BoardVO> listAll() throws Exception {
		return dao.listAll();
	}
	
	@Override
	public List<BoardVO> list_SEOUL() throws Exception {
		return dao.list_SEOUL();
	}
	
	@Override
	public List<BoardVO> list_GYEONGGI() throws Exception {
		return dao.list_GYEONGGI();
	}
	
	@Override
	public List<BoardVO> list_INCHEON() throws Exception {
		return dao.list_INCHEON();
	}
	
	@Override
	public List<BoardVO> list_DAEJEON() throws Exception {
		return dao.list_DAEJEON();
	}
	
	@Override
	public List<BoardVO> list_CHUNGCHEONG() throws Exception {
		return dao.list_CHUNGCHEONG();
	}
	
	@Override
	public List<BoardVO> list_KANGWON() throws Exception {
		return dao.list_KANGWON();
	}
	
	@Override
	public List<BoardVO> list_DAEGU() throws Exception {
		return dao.list_DAEGU();
	}
	
	@Override
	public List<BoardVO> list_JEOLLA() throws Exception {
		return dao.list_JEOLLA();
	}
	
	@Override
	public List<BoardVO> list_BUSAN() throws Exception {
		return dao.list_BUSAN();
	}
	
	@Override
	public List<BoardVO> list_GYEONGSANG() throws Exception {
		return dao.list_GYEONGSANG();
	}
	
	@Override
	public List<BoardVO> list_JEJU() throws Exception {
		return dao.list_JEJU();
	}
	
	@Override
	   public void like(Integer bno) throws Exception {
	      dao.updateLikeCnt(bno);
	   }   
	   
	   @Override
	   public void hate(Integer bno) throws Exception {
	      dao.updateHateCnt(bno);
	   }
	
	   @Override
		public List<BoardVO> listCriteria(Criteria criteria) throws Exception {
			return dao.listCriteria(criteria);
		}
		
		@Override
		public int countBoard(Criteria criteria) throws Exception {
			return dao.countBoard(criteria);
		}

}
