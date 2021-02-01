package kh.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nexacro.uiadapter17.spring.core.annotation.ParamDataSet;
import com.nexacro.uiadapter17.spring.core.annotation.ParamVariable;
import com.nexacro.uiadapter17.spring.core.data.NexacroResult;

import kh.spring.dto.GoodsDTO;
import kh.spring.dto.MembersDTO;
import kh.spring.dto.MessagesDTO;
import kh.spring.service.AdminService;

@Controller
public class AdminController {
	@Autowired
	private AdminService aService;
	@RequestMapping("login.nex")
	public NexacroResult login(@ParamVariable(name="id")String id, @ParamVariable(name="pw")String pw) {
		NexacroResult nr = new NexacroResult();
		MembersDTO dto = new MembersDTO();
		dto.setId(id);
		dto.setPw(pw);
		MembersDTO mdto = aService.login(dto);
		nr.addDataSet("out_ds",mdto);

		return nr;
	}
	@RequestMapping("blackList.nex")
	public NexacroResult blackList() {
		NexacroResult nr = new NexacroResult();
		List<MembersDTO> list = aService.blackList();
		nr.addDataSet("out_ds",list);
		return nr;
	}
	@RequestMapping("blackListUpd.nex")
	public NexacroResult blackListUpd(@ParamDataSet(name="in_ds")MembersDTO dto) {
		NexacroResult nr = new NexacroResult();
		aService.blackListUpd(dto);
		return nr;
	}
	@RequestMapping("memberList.nex")
	public NexacroResult memberList() {
		NexacroResult nr = new NexacroResult();
		List<MembersDTO> list = aService.memberList();
		nr.addDataSet("out_ds",list);
		return nr;
	}
	@RequestMapping("sendMsg.nex")
	public NexacroResult chkList(@ParamDataSet(name="in_ds")List<MessagesDTO> list) {
		NexacroResult nr = new NexacroResult();
		
		aService.sendMsg(list);
		return nr;
	}
	
	@RequestMapping("goodsList.nex")
	public NexacroResult goodsList() {
		NexacroResult nr = new NexacroResult();
		System.out.println("goodsList");
		List<GoodsDTO> list = aService.goodsList();
		nr.addDataSet("out_ds",list);
		return nr;
	}
	@RequestMapping("goodsListDel.nex")
	public NexacroResult goodsListDel(@ParamDataSet(name="in_ds")List<GoodsDTO> list) {
		NexacroResult nr = new NexacroResult();
		aService.goodsListDel(list);
		return nr;
	}
	@RequestMapping("goodsListUpd.nex")
	public NexacroResult goodsListUpd(@ParamDataSet(name="in_ds")GoodsDTO dto) {
		NexacroResult nr = new NexacroResult();
		aService.goodsListUpd(dto);
		return nr;
	}
	@ExceptionHandler
	public String exceptionhandler(Exception e){
		return "error";
	}
}
