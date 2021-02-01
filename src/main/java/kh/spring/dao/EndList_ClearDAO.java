package kh.spring.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.spring.dto.BuyTradeDTO;
import kh.spring.dto.EndList_ClearDTO;
import kh.spring.statics.MypageConfigurator;

@Repository
public class EndList_ClearDAO {
	@Autowired
	private SqlSession session;
	
	public List<EndList_ClearDTO> select(int page,EndList_ClearDTO dto){
		int startRowNum = (page-1)*MypageConfigurator.recordCountPerPage +1;
		int endRowNum = startRowNum + MypageConfigurator.recordCountPerPage -1;
		Map<String,Object> param = new HashMap<>();
		param.put("startRowNum", startRowNum);
		param.put("endRowNum", endRowNum);
		param.put("dto", dto);
		return session.selectList("Mypage.selectEndList_Clear",param);
	}
	public int totalCount(EndList_ClearDTO dto) throws Exception{
		return session.selectOne("Mypage.totalCountEndList_Clear",dto);
	}
	public List<EndList_ClearDTO> search(int page, String startDate, String endDate,EndList_ClearDTO dto){
		int startRowNum = (page-1)*MypageConfigurator.recordCountPerPage +1;
		int endRowNum = startRowNum + MypageConfigurator.recordCountPerPage -1;
		Map<String,Object> param = new HashMap<>();
		param.put("startRowNum", startRowNum);
		param.put("endRowNum", endRowNum);
		param.put("startDate",startDate);
		param.put("endDate",endDate);
		param.put("dto", dto);
		return session.selectList("Mypage.searchEndList_Clear",param);
	}
	public int searchTotalCount(String startDate, String endDate,EndList_ClearDTO dto) throws Exception{
		Map<String,Object> param = new HashMap<>();
		param.put("startDate",startDate);
		param.put("endDate",endDate);
		param.put("dto", dto);
		return session.selectOne("Mypage.searchTotalCountEndList_Clear",param);
	}
	
	
	//------------------------------------------------------------------------
	
	public int insert(EndList_ClearDTO dto) {

		return session.insert("EndlistClear.insert",dto);
	}
	public int insertEndList_Clear(BuyTradeDTO dto) {
		return session.insert("EndlistClear.insertEndList_Clear",dto);
	}
}
