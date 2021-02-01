package kh.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.spring.dao.EndlistPayDAO;
import kh.spring.dto.TradeDTO;

@Service
public class EndlistPayService {

	
	@Autowired
	private EndlistPayDAO dao;
	
	public int insert(TradeDTO dto) {
		return dao.insert(dto);
	}
}
