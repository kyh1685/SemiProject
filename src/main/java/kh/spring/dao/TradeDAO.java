package kh.spring.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.spring.dto.BuyTradeDTO;
import kh.spring.dto.TradeDTO;

@Repository
public class TradeDAO {
	@Autowired
	private SqlSession session;
	
	public int selectSeqFromTilte(String title) {
	      return session.selectOne("Trade.selectSeqFromTilte",title);
	   }
	public int checkReq(String goodName) {
		return session.selectOne("Trade.checkReq",goodName);
	}
	public String selectRequest(String buyerId, String goodWriter, String goodName) {
		Map<String,String>param = new HashMap<>();
		param.put("buyer", buyerId);
		param.put("seller",goodWriter);
		param.put("title", goodName);
		return session.selectOne("Trade.selectRequest",param);
	}
	public String selectConfirm(String buyerId, String goodWriter, String goodName) {
		Map<String,String>param = new HashMap<>();
		param.put("buyer", buyerId);
		param.put("seller",goodWriter);
		param.put("title", goodName);
		return session.selectOne("Trade.selectConfirm",param);
	}
	
	public int updateRequest(String buyerId, String goodWriter, String goodName) {
		Map<String,String>param = new HashMap<>();
		param.put("buyer", buyerId);
		param.put("seller",goodWriter);
		param.put("title", goodName);
		return session.update("Trade.updateRequest",param);
	}
	
	public int updateRequestDel(String buyerId, String goodWriter, String goodName) {
		Map<String,String>param = new HashMap<>();
		param.put("buyer", buyerId);
		param.put("seller",goodWriter);
		param.put("title", goodName);
		return session.update("Trade.updateRequestDel",param);
	}
	
	
	public int updateConfirm(String seq) {
		
		return session.update("Trade.updateConfirm",seq);
	}
	public int insertTrade(TradeDTO dto) {
		return session.insert("Trade.insert",dto);
	}
	

	public int selectSeq(String buyerId, String goodWriter, String goodName) {
		Map<String,String>param = new HashMap<>();
		param.put("buyer", buyerId);
		param.put("seller",goodWriter);
		param.put("title", goodName);
		
		return session.selectOne("Trade.selectSeq",param);
	}
	
	public int checkTrade(String sellerId) {
		return session.selectOne("Trade.checkTrade",sellerId);
	}
	
	public String selectBuyer(String sellerId, String title) {
		Map<String,String> param = new HashMap<>();
		param.put("seller", sellerId);
		param.put("title", title);
		return session.selectOne("Trade.selectBuyer",param);
	}
	
	public String selectGoods(String sellerId) {
		return session.selectOne("Trade.selectGoods",sellerId);
	}
	
	public int selectPrice(String title) {
		return session.selectOne("Trade.selectPrice",title);
	}
	
	public List<TradeDTO> selectConfirmList(String seller){
		return session.selectList("Trade.selectConfirmList",seller);
	}
	
	public List<TradeDTO> selectConfirmListB(String buyer){
		return session.selectList("Trade.selectConfirmListB",buyer);
	}
	
	public TradeDTO selectList(String seller){
		return session.selectOne("Trade.selectList",seller);
	}
	
	public TradeDTO selectTradeWant(String seq){
		return session.selectOne("Trade.selectTradeWant",seq);
	}
	
	public TradeDTO selectTradeWant2(String seq){
		return session.selectOne("Trade.selectTradeWant2",seq);
	}
	
	public TradeDTO selectTradeWant3(String seq){
		return session.selectOne("Trade.selectTradeWant3",seq);
	}
	public String selectBuyerReq(String seq) {
		return session.selectOne("Trade.selectBuyerReq",seq);
	}
	
	public String selectSellerCfm(String seq) {
		return session.selectOne("Trade.selectSellerCfm",seq);
	}
	
	public TradeDTO selectCheckTable(String seq) {
		return session.selectOne("Trade.selectCheckTable",seq);
	}
	public int deleteTrade(int seq) {
		return session.delete("Trade.deleteTrade",seq);
	}

	public int insertTrade2(String buyerId,String goodSeq, String goodName, String goodPrice, String goodWriter) {
		Map<String, String> param = new HashMap<>();
		param.put("buyer", buyerId);
		param.put("title",goodName );
		param.put("seller", goodWriter);
		param.put("price", goodPrice);
		param.put("goodSeq", goodSeq);

		return session.insert("Trade.insert",param);
	}
	
	public List<TradeDTO> selectBuyerList(String id){
		return session.selectList("Trade.selectBuyerList",id);
	}
	
	public List<TradeDTO> selectReqList(String seller){
		return session.selectList("Trade.selectReqList",seller);
	}
}
