package kh.spring.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.spring.dto.Customer_ServiceDTO;
import kh.spring.statics.ClientConfigurator;

@Repository
public class Customer_ServiceDAO {
	@Autowired
	private SqlSession session;
	
	public List<Customer_ServiceDTO> listByCpage(int cpage) throws Exception{
		int startRowNum = (cpage-1) * ClientConfigurator.recordCountPerPage+1;
		int endRowNum = startRowNum + ClientConfigurator.recordCountPerPage -1;
		Map<String,Integer> param = new HashMap<>();
		param.put("startRowNum", startRowNum);
		param.put("endRowNum", endRowNum);
		return session.selectList("Customer.listByCpage", param);
	}
	public List<Customer_ServiceDTO> mylist(int cpage,String id)throws Exception{
		int startRowNum = (cpage-1) * ClientConfigurator.recordCountPerPage+1;
		int endRowNum = startRowNum + ClientConfigurator.recordCountPerPage -1;
		Map<String,Object> param = new HashMap<>();
		param.put("startRowNum", startRowNum);
		param.put("endRowNum", endRowNum);
		param.put("id", id);
		return session.selectList("Customer.mylist",param);
	}
	public int getDataCount() throws Exception{
		return session.selectOne("Customer.getCount");
	}
	public int insert(Customer_ServiceDTO dto) throws Exception{
		return session.insert("Customer.insert", dto);
	}
	public Customer_ServiceDTO getList(String seq)throws Exception{
		return session.selectOne("Customer.selectBySeq",seq);
	}
	public int update(Customer_ServiceDTO dto) throws Exception{
		return session.update("Customer.update",dto);
	}
	public int readUpdate(String seq) {
		return session.update("Customer.readUpdate",seq);
	}
	public int delete(int seq) {
		return session.delete("Customer.delete",seq);
	}
	public int getMyDataCount(String id) throws Exception{
		return session.selectOne("Customer.getMyCount",id);
	}
	//-----------------------------------------------------------------
	
	public int countCustomResp(Customer_ServiceDTO dto) {
		return session.selectOne("Mypage.countCustomResp",dto);
	}

	
}
