package kh.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.spring.dao.BuyTradeDAO;
import kh.spring.dto.BuyTradeDTO;

@Service
public class BuyTradeService {

	@Autowired
	private BuyTradeDAO dao;
	public int checkReq(BuyTradeDTO dto) {
		return dao.checkReq(dto);
	}
	public int deleteTrade(BuyTradeDTO dto) {
		return dao.deleteTrade(dto);
	}
	public String tradeReq(BuyTradeDTO dto) {
		return dao.tradeReq(dto);
	}
	public int checkTrade(BuyTradeDTO dto) {
		return dao.checkTrade(dto);
	}
	public int insertTrade(BuyTradeDTO dto) {
		return dao.insertTrade(dto);
	}
	public int updateReqTrade(BuyTradeDTO dto) {
		return dao.updateReqTrade(dto);
	}
	public int countTrade(BuyTradeDTO dto) {
		return dao.countTrade(dto);
	}
	public int cancelReqTrade(BuyTradeDTO dto) {
		return dao.cancelReqTrade(dto);
	}
	public List<BuyTradeDTO> selectReqList(String id){
		return dao.selectReqList(id);
	}
	public BuyTradeDTO selectTradeSeq(BuyTradeDTO dto) {
		return dao.selectTradeSeq(dto);
	}
	public int updateCf(BuyTradeDTO dto) {
		return dao.updateCf(dto);
	}
	public BuyTradeDTO selectTrade(BuyTradeDTO dto) {
		return dao.selectTrade(dto);
	}
	public List<BuyTradeDTO> selectBuyerList(String id){
		return dao.selectBuyerList(id);
	}
}
