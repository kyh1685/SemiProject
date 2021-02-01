package kh.spring.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.spring.dto.BuyTradeDTO;
import kh.spring.dto.PurchaseListDTO;
import kh.spring.statics.MypageConfigurator;


@Repository
public class PurchaseListDAO {

	@Autowired
	private SqlSession session;
	

	public int insert(PurchaseListDTO dto) {

		return session.insert("PurchaseList.insert",dto);
	}
	
	public int delete(int seq) {
		return session.delete("PurchaseList.delete",seq);
	}
	public int insertPurchase(BuyTradeDTO dto) {
		return session.insert("PurchaseList.insertPurchase",dto);
	}
	public int deletePurchaseList(PurchaseListDTO dto) {
		return session.delete("PurchaseList.deletePurchaseList",dto);
	}
	//-----------------------------------------------------------------
	
	public List<PurchaseListDTO> select(int page,PurchaseListDTO dto){
		int startRowNum = (page-1)*MypageConfigurator.recordCountPerPage +1;
		int endRowNum = startRowNum + MypageConfigurator.recordCountPerPage -1;
		Map<String,Object> param = new HashMap<>();
		param.put("startRowNum", startRowNum);
		param.put("endRowNum", endRowNum);
		param.put("dto", dto);
		return session.selectList("Mypage.selectPurchaseList",param);
	}
	public int totalCount(PurchaseListDTO dto) throws Exception{
		return session.selectOne("Mypage.totalCountPurchaseList",dto);
	}
	public List<PurchaseListDTO> search(int page, String startDate, String endDate,PurchaseListDTO dto){
		int startRowNum = (page-1)*MypageConfigurator.recordCountPerPage +1;
		int endRowNum = startRowNum + MypageConfigurator.recordCountPerPage -1;
		Map<String,Object> param = new HashMap<>();
		param.put("startRowNum", startRowNum);
		param.put("endRowNum", endRowNum);
		param.put("startDate",startDate);
		param.put("endDate",endDate);
		param.put("dto", dto);
		return session.selectList("Mypage.searchPurchaseList",param);
	}
	public int searchTotalCount(String startDate, String endDate,PurchaseListDTO dto) throws Exception{
		Map<String,Object> param = new HashMap<>();
		param.put("startDate",startDate);
		param.put("endDate",endDate);
		param.put("dto", dto);
		return session.selectOne("Mypage.searchTotalCountPurchaseList",param);
	}
	
}
