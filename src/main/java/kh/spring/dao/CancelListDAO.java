package kh.spring.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.spring.dto.BuyTradeDTO;
import kh.spring.dto.CancelListDTO;
import kh.spring.dto.TradeDTO;
import kh.spring.statics.MypageConfigurator;


@Repository
public class CancelListDAO {

	@Autowired
	private SqlSession session;
	
	public int insert(CancelListDTO dto) {
		return session.insert("CancelList.insert",dto);
	}
	public int insertCancelList(BuyTradeDTO dto) {
		return session.insert("CancelList.insertCancel",dto);
	}
	
	//----------------------------------------------------------------
	
	public List<CancelListDTO> select(int page,CancelListDTO dto){
		int startRowNum = (page-1)*MypageConfigurator.recordCountPerPage +1;
		int endRowNum = startRowNum + MypageConfigurator.recordCountPerPage -1;
		Map<String,Object> param = new HashMap<>();
		param.put("startRowNum", startRowNum);
		param.put("endRowNum", endRowNum);
		param.put("dto", dto);
		return session.selectList("Mypage.selectCancelList",param);
	}
	public int totalCount(CancelListDTO dto) throws Exception{
		return session.selectOne("Mypage.totalCountCancelList",dto);
	}
	public List<CancelListDTO> search(int page, String startDate, String endDate,CancelListDTO dto){
		int startRowNum = (page-1)*MypageConfigurator.recordCountPerPage +1;
		int endRowNum = startRowNum + MypageConfigurator.recordCountPerPage -1;
		Map<String,Object> param = new HashMap<>();
		param.put("startRowNum", startRowNum);
		param.put("endRowNum", endRowNum);
		param.put("startDate",startDate);
		param.put("endDate",endDate);
		param.put("dto", dto);
		return session.selectList("Mypage.searchCancelList",param);
	}
	public int searchTotalCount(String startDate, String endDate,CancelListDTO dto) throws Exception{
		Map<String,Object> param = new HashMap<>();
		param.put("startDate",startDate);
		param.put("endDate",endDate);
		param.put("dto", dto);
		return session.selectOne("Mypage.searchTotalCountCancelList",param);
	}
	
}
