package kh.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.spring.dao.TradeDAO;
import kh.spring.dto.BuyTradeDTO;
import kh.spring.dto.TradeDTO;

@Service
public class TradeService {

	@Autowired
	private TradeDAO dao;
	
	public int checkReq(String goodName){
		return dao.checkReq(goodName);
	}
	public String selectRequest(String buyerId, String goodWriter, String goodName) {
		return dao.selectRequest(buyerId,goodWriter,goodName);
	}
	
	public String selectConfirm(String buyerId, String goodWriter, String goodName) {
		return dao.selectConfirm(buyerId,goodWriter,goodName);
	}
	
	public int updateRequest(String buyerId, String goodWriter, String goodName) {
		return dao.updateRequest(buyerId,goodWriter,goodName);
	}
	
	public int updateRequestDel(String buyerId, String goodWriter, String goodName) {
		return dao.updateRequestDel(buyerId,goodWriter,goodName);
	}
	
	public int updateConfirm(String seq) {
		return dao.updateConfirm(seq);
	}
	
	public int insertTrade(TradeDTO dto) {
		return dao.insertTrade(dto);
	}
	
	public int selectSeq(String buyerId, String goodWriter, String goodName) {
		return dao.selectSeq(buyerId, goodWriter, goodName);
	}
	
	public int checkTrade(String sellerId) {
		return dao.checkTrade(sellerId);
	}
	
	public String selectBuyer(String sellerId, String goods) {
		return dao.selectBuyer(sellerId, goods);
	}
	
	public String selectGoods(String sellerId) {
		return dao.selectGoods(sellerId);
	}
	public int selectPrice(String goods) {
		return dao.selectPrice(goods);
	}
	
	public List<TradeDTO> selectConfirmList(String seller){
		return dao.selectConfirmList(seller);
	}
	
	public TradeDTO selectList(String seller){
		return dao.selectList(seller);
	}
	
	public TradeDTO selectTradeWant(String seq){
		return dao.selectTradeWant(seq);
	}
	
	public TradeDTO selectTradeWant2(String seq){
		return dao.selectTradeWant2(seq);
	}
	
	public TradeDTO selectTradeWant3(String seq){
		return dao.selectTradeWant3(seq);
	}
	
	public String selectBuyerReq(String seq) {
		return dao.selectBuyerReq(seq);
		
	}
	
	public String selectSellerCfm(String seq) {
		return dao.selectSellerCfm(seq);
	}
	
	public TradeDTO selectCheckTable(String seq) {
		return dao.selectCheckTable(seq);
	}

	public int deleteTrade(int seq) {
		return dao.deleteTrade(seq);
	}
	public int selectSeqFromTilte(String title) {
	      return dao.selectSeqFromTilte(title);
	   }
	
	public int insertTrade2(String buyerId,String goodSeq, String goodName, String goodPrice, String goodWriter) {
		return dao.insertTrade2(buyerId,goodSeq, goodName, goodPrice, goodWriter);
	}
	
	public List<TradeDTO> selectConfirmListB(String buyer){
		return dao.selectConfirmListB(buyer);
	}
	
	public List<TradeDTO> selectBuyerList(String id){
		return dao.selectBuyerList(id);
	}
	
	public List<TradeDTO> selectReqList(String id){
		return dao.selectReqList(id);
	}
}
