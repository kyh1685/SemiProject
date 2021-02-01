package kh.spring.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.spring.dto.TradeDTO;

@Repository
public class EndlistPayDAO {

	
	@Autowired
	private SqlSession session;
	
	public int insert(TradeDTO dto) {
		return session.insert("EndlistPay.insert",dto);
	}
}
