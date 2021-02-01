package kh.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.spring.dao.CustomerRequestDAO;
import kh.spring.dto.CustomerRequestDTO;

@Service
public class CustomerRequestService {

	
	@Autowired CustomerRequestDAO dao;
	
	public int insert(CustomerRequestDTO dto) {
		return dao.insert(dto);
	}
	
	public int delete(List<CustomerRequestDTO> list) {
		return dao.delete(list);
		
	}
	
	public int update(CustomerRequestDTO dto) {
		return dao.update(dto);
	}
	
	public List<CustomerRequestDTO> select() {
		return dao.select();
	}
}
