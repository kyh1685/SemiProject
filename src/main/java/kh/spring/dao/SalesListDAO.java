package kh.spring.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.spring.dto.BuyTradeDTO;
import kh.spring.dto.GoodsDTO;
import kh.spring.dto.SalesListDTO;
import kh.spring.statics.MypageConfigurator;

@Repository
public class SalesListDAO {

	@Autowired
	private SqlSession session;
	public int delete(int goodSeq) {
		return session.delete("Mypage.deleteSalesList",goodSeq);
	}
	public List<SalesListDTO> select(int page,SalesListDTO dto){
		int startRowNum = (page-1)*MypageConfigurator.recordCountPerPage +1;
		int endRowNum = startRowNum + MypageConfigurator.recordCountPerPage -1;
		Map<String,Object> param = new HashMap<>();
		param.put("startRowNum", startRowNum);
		param.put("endRowNum", endRowNum);
		param.put("dto", dto);
		return session.selectList("Mypage.selectSalesList",param);
	}
	public int totalCount(SalesListDTO dto) throws Exception{
		return session.selectOne("Mypage.totalCountSalesList",dto);
	}
	public List<SalesListDTO> search(int page, String startDate, String endDate,SalesListDTO dto){
		int startRowNum = (page-1)*MypageConfigurator.recordCountPerPage +1;
		int endRowNum = startRowNum + MypageConfigurator.recordCountPerPage -1;
		Map<String,Object> param = new HashMap<>();
		param.put("startRowNum", startRowNum);
		param.put("endRowNum", endRowNum);
		param.put("startDate",startDate);
		param.put("endDate",endDate);
		param.put("dto", dto);
		return session.selectList("Mypage.searchSalesList",param);
	}
	public int searchTotalCount(String startDate, String endDate,SalesListDTO dto) throws Exception{
		Map<String,Object> param = new HashMap<>();
		param.put("startDate",startDate);
		param.put("endDate",endDate);
		param.put("dto", dto);
		return session.selectOne("Mypage.searchTotalCountSalesList",param);
	}
	public int insert(GoodsDTO dto) {
		return session.insert("SalesList.insert",dto);
	}
	public int insertSalesList(BuyTradeDTO dto) {
		return session.insert("SalesList.insertSales",dto);
	}
	public int deleteSalesList(SalesListDTO dto) {
		return session.delete("SalesList.deleteSalesList",dto);
	}
}
