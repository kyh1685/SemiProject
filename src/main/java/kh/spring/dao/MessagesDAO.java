package kh.spring.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.spring.dto.MessagesDTO;
import kh.spring.statics.MypageConfigurator;

@Repository
public class MessagesDAO {

	@Autowired
	private SqlSession session;
	
	public List<MessagesDTO> listMessages(int page,MessagesDTO dto){
		int startRowNum = (page-1)*MypageConfigurator.recordCountPerPage +1;
		int endRowNum = startRowNum + MypageConfigurator.recordCountPerPage -1;
		Map<String,Object> param = new HashMap<>();
		param.put("startRowNum", startRowNum);
		param.put("endRowNum", endRowNum);
		param.put("dto", dto);
		return session.selectList("Mypage.listMessages",param);
	}
	public int totalCountMessages(MessagesDTO dto) throws Exception{
		return session.selectOne("Mypage.totalCountMessages",dto);
	}
	public int deleteMessages(MessagesDTO dto) {
		return session.delete("Mypage.deleteMessages",dto);
	}
	public List<MessagesDTO> selectMessages(MessagesDTO dto) {
		return session.selectList("Mypage.selectMessages",dto);
	}
	public List<MessagesDTO> ajaxMessages(MessagesDTO dto){
		return session.selectList("Mypage.ajaxMessages",dto);
	}
	public int updateRead(MessagesDTO dto) {
		return session.update("Mypage.updateRead",dto);
	}
	public int readAll(MessagesDTO dto) {
		return session.update("Mypage.readAll",dto);
	}
	public int insertMessages(MessagesDTO dto) {
		return session.insert("Mypage.insertMessages",dto);
	}
	public List<MessagesDTO> searchMessages(int page,MessagesDTO dto,String searchText,String category){
		int startRowNum = (page-1)*MypageConfigurator.recordCountPerPage +1;
		int endRowNum = startRowNum + MypageConfigurator.recordCountPerPage -1;
		Map<String,Object> param = new HashMap<>();
		param.put("startRowNum", startRowNum);
		param.put("endRowNum", endRowNum);
		param.put("dto", dto);
		param.put("searchText", searchText);
		param.put("category", category);
		return session.selectList("Mypage.searchMessages",param);
	}
	public int totalSearchCountMessages(MessagesDTO dto,String searchText,String category) {
		Map<String,Object> param = new HashMap<>();
		param.put("dto", dto);
		param.put("searchText", searchText);
		param.put("category", category);
		return session.selectOne("Mypage.totalSearchCountMessages",param);
	}

}
