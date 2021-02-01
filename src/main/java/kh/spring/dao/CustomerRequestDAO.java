package kh.spring.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.spring.dto.CustomerRequestDTO;

@Repository
public class CustomerRequestDAO {

	@Autowired SqlSession session;
	
	public int insert(CustomerRequestDTO dto) {
		return session.insert("CustomerRequest.insert",dto);
	}

	public int delete(List<CustomerRequestDTO> list) {
		return session.delete("CustomerRequest.delete",list);
	}
	public int update(CustomerRequestDTO dto) {
		return session.update("CustomerRequest.update",dto);
	}
	
	public List<CustomerRequestDTO> select(){
		return session.selectList("CustomerRequest.selectAll");
	}
	
	
}
