package kh.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.spring.dao.AdminDAO;
import kh.spring.dto.GoodsDTO;
import kh.spring.dto.MembersDTO;
import kh.spring.dto.MessagesDTO;

@Service
public class AdminService {
	@Autowired
	private AdminDAO adao;
	
	public MembersDTO login(MembersDTO dto) {
		return adao.login(dto);
	}
	public List<MembersDTO> blackList(){
		return adao.blackList();
	}
	public int blackListUpd(MembersDTO dto){
		return adao.blackListUpd(dto);
	}
	public List<MembersDTO> memberList(){
		return adao.memberList();
	}
	public int sendMsg(List<MessagesDTO> list) {
		return adao.sendMsg(list);
	}
	public List<GoodsDTO> goodsList(){
		return adao.goodsList();
	}
	public int goodsListDel(List<GoodsDTO> list) {
		return adao.goodsListDel(list);
	}
	public int goodsListUpd(GoodsDTO dto){
		return adao.goodsListUpd(dto);
	}
}
