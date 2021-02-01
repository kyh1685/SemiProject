package kh.spring.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.spring.dto.BuyTradeDTO;

@Repository
public class BuyTradeDAO {

	@Autowired
	private SqlSession session;
	public int checkReq(BuyTradeDTO dto) {
		return session.selectOne("BuyTrade.checkReq",dto);
	}
	public int deleteTrade(BuyTradeDTO dto) {
		return session.delete("BuyTrade.deleteTrade",dto);
	}
	public String tradeReq(BuyTradeDTO dto) {
		return session.selectOne("BuyTrade.tradeReq",dto);
	}
	public int checkTrade(BuyTradeDTO dto) {
		return session.selectOne("BuyTrade.checkTrade",dto);
	}
	public int insertTrade(BuyTradeDTO dto) {
		return session.insert("BuyTrade.insertTrade",dto);
	}
	public int updateReqTrade(BuyTradeDTO dto) {
		return session.update("BuyTrade.updateReqTrade",dto);
	}
	public int countTrade(BuyTradeDTO dto) {
		return session.selectOne("BuyTrade.countTrade",dto);
	}
	public int cancelReqTrade(BuyTradeDTO dto) {
		return session.delete("BuyTrade.cancelReqTrade",dto);
	}
	public List<BuyTradeDTO> selectReqList(String id){
		return session.selectList("BuyTrade.selectReqList",id);
	}
	public BuyTradeDTO selectTradeSeq(BuyTradeDTO dto) {
		return session.selectOne("BuyTrade.selectTradeSeq",dto);
	}
	public int updateCf(BuyTradeDTO dto) {
		return session.update("BuyTrade.updateCf",dto);
	}
	public BuyTradeDTO selectTrade(BuyTradeDTO dto) {
		return session.selectOne("BuyTrade.selectTrade",dto);
	}
	public List<BuyTradeDTO> selectBuyerList(String id){
		return session.selectList("BuyTrade.selectBuyerList",id);
	}
}
