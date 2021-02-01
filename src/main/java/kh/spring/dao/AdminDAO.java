package kh.spring.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.spring.dto.GoodsDTO;
import kh.spring.dto.MembersDTO;
import kh.spring.dto.MessagesDTO;

@Repository
public class AdminDAO {
	@Autowired
	private SqlSession session;
	
	public MembersDTO login(MembersDTO dto) {
		return session.selectOne("Admin.login",dto);
	}
	public List<MembersDTO> blackList(){
		return session.selectList("Admin.blackList");
	}
	public int blackListUpd(MembersDTO dto){
		return session.update("Admin.blackListUpd",dto);
	}
	public List<MembersDTO>	memberList(){
		return session.selectList("Admin.memberList");
	}
	public int sendMsg(List<MessagesDTO> list) {
		return session.insert("Admin.sendMsg",list);
	}
	
	public List<GoodsDTO> goodsList(){
		return session.selectList("Admin.goodsList");
	}
	public int goodsListDel(List<GoodsDTO> list) {
		return session.delete("Admin.goodsListDel",list);
	}
	public int goodsListUpd(GoodsDTO dto){
		return session.update("Admin.goodsListUpd",dto);
	}
}
