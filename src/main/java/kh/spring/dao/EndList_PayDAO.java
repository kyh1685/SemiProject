package kh.spring.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.spring.dto.EndList_PayDTO;
import kh.spring.statics.MypageConfigurator;

@Repository
public class EndList_PayDAO {
	@Autowired
	private SqlSession session;
	
	public int insert(EndList_PayDTO dto) {
		return session.insert("EndlistPay.insert",dto);
	}
	public List<EndList_PayDTO> select(int page,EndList_PayDTO dto){
		int startRowNum = (page-1)*MypageConfigurator.recordCountPerPage +1;
		int endRowNum = startRowNum + MypageConfigurator.recordCountPerPage -1;
		Map<String,Object> param = new HashMap<>();
		param.put("startRowNum", startRowNum);
		param.put("endRowNum", endRowNum);
		param.put("dto", dto);
		return session.selectList("Mypage.selectEndList_Pay",param);
	}
	public int totalCount(EndList_PayDTO dto) throws Exception{
		return session.selectOne("Mypage.totalCountEndList_Pay",dto);
	}
	public List<EndList_PayDTO> search(int page, String startDate, String endDate,EndList_PayDTO dto){
		int startRowNum = (page-1)*MypageConfigurator.recordCountPerPage +1;
		int endRowNum = startRowNum + MypageConfigurator.recordCountPerPage -1;
		Map<String,Object> param = new HashMap<>();
		param.put("startRowNum", startRowNum);
		param.put("endRowNum", endRowNum);
		param.put("startDate",startDate);
		param.put("endDate",endDate);
		param.put("dto", dto);
		return session.selectList("Mypage.searchEndList_Pay",param);
	}
	public int searchTotalCount(String startDate, String endDate,EndList_PayDTO dto) throws Exception{
		Map<String,Object> param = new HashMap<>();
		param.put("startDate",startDate);
		param.put("endDate",endDate);
		param.put("dto", dto);
		return session.selectOne("Mypage.searchTotalCountEndList_Pay",param);
	}
}
