package kh.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.spring.dao.Customer_ServiceDAO;
import kh.spring.dto.Customer_ServiceDTO;

@Service
public class Customer_ServiceService {
	@Autowired
	private Customer_ServiceDAO csdao;
	
	public int countCustomResp(Customer_ServiceDTO dto) {
		return csdao.countCustomResp(dto);
	}
}
