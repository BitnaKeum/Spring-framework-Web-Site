package com.kwce.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kwce.domain.BoardVO;
import com.kwce.paging.*;

@Repository
public class BoardDAOImpl implements BoardDAO{

	@Autowired
	private SqlSession session;
	private static String namespace="com.kwce.mapper.BoardMapper";
	
	@Override
	public void create(BoardVO vo) throws Exception {
		session.insert(namespace+".create",vo);
	}

	@Override
	public BoardVO read(Integer bno) throws Exception {
		return session.selectOne(namespace+".read",bno);
		
	}

	@Override
	public void update(BoardVO vo) throws Exception {
		session.update(namespace+".update",vo);
	}

	@Override
	public void delete(Integer bno) throws Exception {
		session.delete(namespace+".delete", bno);
	}

	@Override
	public List<BoardVO> listAll() throws Exception {
		return session.selectList(namespace+".listAll");
	}
	
	@Override
	public List<BoardVO> list_SEOUL() throws Exception {
		return session.selectList(namespace+".list_SEOUL");
	}
	
	@Override
	public List<BoardVO> list_GYEONGGI() throws Exception {
		return session.selectList(namespace+".list_GYEONGGI");
	}
	
	@Override
	public List<BoardVO> list_INCHEON() throws Exception {
		return session.selectList(namespace+".list_INCHEON");
	}
	
	@Override
	public List<BoardVO> list_DAEJEON() throws Exception {
		return session.selectList(namespace+".list_DAEJEON");
	}
	
	@Override
	public List<BoardVO> list_CHUNGCHEONG() throws Exception {
		return session.selectList(namespace+".list_CHUNGCHEONG");
	}
	
	@Override
	public List<BoardVO> list_KANGWON() throws Exception {
		return session.selectList(namespace+".list_KANGWON");
	}
	
	@Override
	public List<BoardVO> list_DAEGU() throws Exception {
		return session.selectList(namespace+".list_DAEGU");
	}
	
	@Override
	public List<BoardVO> list_JEOLLA() throws Exception {
		return session.selectList(namespace+".list_JEOLLA");
	}
	
	@Override
	public List<BoardVO> list_BUSAN() throws Exception {
		return session.selectList(namespace+".list_BUSAN");
	}
	
	@Override
	public List<BoardVO> list_GYEONGSANG() throws Exception {
		return session.selectList(namespace+".list_GYEONGSANG");
	}
	
	@Override
	public List<BoardVO> list_JEJU() throws Exception {
		return session.selectList(namespace+".list_JEJU");
	}
	
	@Override
	public void increaseViewCnt(Integer bno) throws Exception{
		session.update(namespace+".increaseViewCnt",bno);
	}
	
	@Override
	public void deleteall(BoardVO vo) throws Exception{
		session.delete(namespace+".deleteall",vo);
	}
	
	@Override
	   public void updateLikeCnt(Integer bno) throws Exception {
	      session.update(namespace + ".updatelike", bno);
	   }
	   

	   @Override
	   public void updateHateCnt(Integer bno) throws Exception {
	      session.update(namespace + ".updatehate", bno);
	   }
	   @Override
		public List<BoardVO> listPaging(int page) throws Exception {
			if(page <= 0) page = 1;
			
			page = (page - 1) * 10;
			return session.selectList(namespace + ".listPaging", page);
		}
		
		
		@Override
		public List<BoardVO> listCriteria(Criteria criteria) throws Exception {
			return session.selectList(namespace + ".listCriteria", criteria);
		}
		
		@Override
		public int countBoard(Criteria criteria) throws Exception {
			return session.selectOne(namespace + ".countBoard", criteria);
		}
}