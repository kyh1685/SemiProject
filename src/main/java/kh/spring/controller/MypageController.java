package kh.spring.controller;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import kh.spring.dao.MembersDAO;
import kh.spring.dto.BasketDTO;
import kh.spring.dto.CancelListDTO;
import kh.spring.dto.Customer_ServiceDTO;
import kh.spring.dto.EndList_ClearDTO;
import kh.spring.dto.EndList_PayDTO;
import kh.spring.dto.GoodsDTO;
import kh.spring.dto.MembersDTO;
import kh.spring.dto.MessagesDTO;
import kh.spring.dto.PurchaseListDTO;
import kh.spring.dto.SalesListDTO;
import kh.spring.service.CancelListService;
import kh.spring.service.Customer_ServiceService;
import kh.spring.service.EndList_ClearService;
import kh.spring.service.EndList_PayService;
import kh.spring.service.GoodsService;
import kh.spring.service.MembersService;
import kh.spring.service.MessagesService;
import kh.spring.service.PurchaseListService;
import kh.spring.service.SalesListService;
import kh.spring.service.SemiProjectService;
import kh.spring.util.EncryptUtils;
import kh.spring.util.UtilTime;

@Controller
@RequestMapping("/mypage")
public class MypageController {
	

	@Autowired
	private HttpSession session;
	
	@Autowired
	private MembersService memService;
	@Autowired
	private SemiProjectService service;

	@Autowired
	private MessagesService mService;
	@Autowired
	private GoodsService gService;
	@Autowired
	private CancelListService clService;
	@Autowired
	private PurchaseListService plService;
	@Autowired
	private EndList_ClearService elcService;
	@Autowired
	private EndList_PayService elpService;
	@Autowired
	private SalesListService slService;
	@Autowired
	private Customer_ServiceService csService;

	
	@RequestMapping(value="idCheck.my", produces="text/plain; charset=UTF8")
	@ResponseBody
	public String idcheck(String id)throws Exception{
		int result = service.checkId(id);
		if(result>0) {
			return "이미 사용중인 아이디입니다.";
		}else {
			return "사용 가능한 아이디입니다.";
		}
		
	}

	//-----------------------------------------------------
	@RequestMapping("myPageCheck.mp")
	public String myPageCheck(Model model){
		String id = (String)session.getAttribute("login");
		model.addAttribute("id",id);
		return "mypage/myPageCheck";
	}
	@RequestMapping("myPageCheckPro.mp")
	public String myPageCheckPro(HttpServletRequest request,Model model){
		MembersDTO dto = new MembersDTO();
		String id = (String)session.getAttribute("login");
		String pw = request.getParameter("pw");
		if(pw.length()<64) {
			pw = EncryptUtils.getSHA256(pw);
		}
		dto.setId(id);
		dto.setPw(pw);
		int count = memService.myPageCheck(dto);
		if(count > 0) {
			MembersDTO mdto = service.getList(id);
			model.addAttribute("dto",mdto);
			return "member/myPage";
		}else {
			model.addAttribute("Type","check");
			return "mypage/failedCheck";
		}
	}
	@RequestMapping("myUpdateCheck.mp")
	public String myUpdateCheck(Model model){
		String id = (String)session.getAttribute("login");
		model.addAttribute("id",id);
		return "mypage/myUpdateCheck";
	}
	@RequestMapping("myUpdateCheckPro.mp")
	public String myUpdateCheckPro(HttpServletRequest request,Model model){
		MembersDTO dto = new MembersDTO();
		String id = (String)session.getAttribute("login");
		String pw = request.getParameter("pw");
		if(pw.length()<64) {
			pw = EncryptUtils.getSHA256(pw);
		}
		dto.setId(id);
		dto.setPw(pw);
		int count = memService.myPageCheck(dto);
		if(count > 0) {
			MembersDTO mdto = service.getList(id);
			model.addAttribute("dto",mdto);
			return "member/upDate";
		}else {
			model.addAttribute("Type","update");
			return "mypage/failedCheck";
		}
	}
	@RequestMapping("okupdate.my")
	public String okupdate(MembersDTO dto,HttpServletRequest request, Model model){
		String id = (String)session.getAttribute("login");
		String pw = request.getParameter("pw");
		dto.setId(id);
		if(pw.length()<64) {
			pw = EncryptUtils.getSHA256(pw);
		}
		dto.setPw(pw);
		memService.okupdate(dto);
		model.addAttribute("id",id);
		return "mypage/myPageCheck";
	}
	@RequestMapping("myDelCheck.mp")
	public String myDelCheck(Model model){
		String id = (String)session.getAttribute("login");
		model.addAttribute("id",id);
		return "mypage/myDelCheck";
	}
	@RequestMapping("myDelCheckPro.mp")
	public String myDelCheckPro(HttpServletRequest request,Model model){
		MembersDTO dto = new MembersDTO();
		String id = (String)session.getAttribute("login");
		String pw = request.getParameter("pw");
		if(pw.length()<64) {
			pw = EncryptUtils.getSHA256(pw);
		}
		dto.setId(id);
		dto.setPw(pw);
		int count = memService.myPageCheck(dto);
		if(count > 0) {
			int result = memService.delMember(dto);
			session.invalidate();
			return "redirect:/";
		}else {
			model.addAttribute("Type","failed");
			return "mypage/failedCheck";
		}
	}
	
	@RequestMapping("messages.mp")
	public String listMessages(HttpServletRequest request, Model model)throws Exception {
		MessagesDTO dto = new MessagesDTO();
		String id = (String)session.getAttribute("login");
		int page = Integer.parseInt(request.getParameter("page"));
		dto.setReceiver(id);
		model.addAttribute("id",id);
		List<MessagesDTO> list = mService.listMessages(page, dto);
		model.addAttribute("list",list);
		String navi = mService.naviMessages(page, dto);
		model.addAttribute("navi",navi);
		return "mypage/messages";
	}
	@RequestMapping("writePage.mp")
	public String writePage(Model model) {
		String id = (String)session.getAttribute("login");
		model.addAttribute("id",id);
		return "mypage/writeMessage";
	}
	@RequestMapping("responsePage.mp")
	public String responsePage(HttpServletRequest request,Model model) {
		String id = (String)session.getAttribute("login");
		model.addAttribute("id",id);
		String seq = request.getParameter("seq");
		seq = seq.substring(0,seq.length()-1);
		String[] arr = seq.split("/");
		List<String> list = new ArrayList<>();
		for(int i=0; i<arr.length; i++) {
			list.add(arr[i]);
		}
		TreeSet<String> list2 = new TreeSet<String>(list);
		List<String> list3 = new ArrayList<>(list2);
		String sender = "";
		for(int i=0; i<list3.size(); i++) {
		sender += list3.get(i) +",";
		}
		sender = sender.substring(0,sender.length()-1);
		System.out.println(sender);
		model.addAttribute("list", sender);
		return "mypage/writeMessage";
	}
	@RequestMapping("viewMsg.mp")
	public String viewMsg(HttpServletRequest request, Model model) {
		MessagesDTO dto = new MessagesDTO();
		String id = (String)session.getAttribute("login");
		int seq = Integer.parseInt(request.getParameter("seq"));
		dto.setReceiver(id);
		dto.setSeq(seq);
		model.addAttribute("id",id);
		List<MessagesDTO> list = mService.selectMessages(dto);
		model.addAttribute("list",list);
		mService.updateRead(dto);
		return "mypage/viewMsg";
	}
	@RequestMapping("readUpdate.mp")
	@ResponseBody
	public String readUpdate(HttpServletRequest request) {
		MessagesDTO dto = new MessagesDTO();
		String id = (String)session.getAttribute("login");
		int seq = Integer.parseInt(request.getParameter("seq"));
		dto.setReceiver(id);
		dto.setSeq(seq);
		int result = mService.updateRead(dto);
		if(result > 0) {
			return "true";
		}
		return "false";
	}
	@RequestMapping("readAll.mp")
	@ResponseBody
	public String readAll(HttpServletRequest request) {
		MessagesDTO dto = new MessagesDTO();
		String id = (String)session.getAttribute("login");
		dto.setReceiver(id);
		int result = mService.readAll(dto);
		if(result > 0) {
			return "true";
		}
		return "false";
	}

	@RequestMapping("delMessages.mp")
	@ResponseBody
	public String delMessages(HttpServletRequest request) {
		MessagesDTO dto = new MessagesDTO();
		int seq = Integer.parseInt(request.getParameter("seq"));
		dto.setSeq(seq);
		String id = (String)session.getAttribute("login");
		dto.setReceiver(id);
		int result = mService.deleteMessages(dto);
		if(result >0) {
			return "true";
		}
		return "false";
	}
	@RequestMapping("insertMessage.mp")
	public String insertMessages(HttpServletRequest request,Model model) {
		MessagesDTO dto = new MessagesDTO();
		String receiver = request.getParameter("receiver");
		String sender = (String)session.getAttribute("login");
		String title = request.getParameter("title");
		String contents = request.getParameter("contents");
		String[] receivers = receiver.split(",");
		for(int i=0; i<receivers.length; i++) {
		dto.setReceiver(receivers[i]);
		dto.setSender(sender);
		dto.setTitle(title);
		dto.setContents(contents);
		int result = mService.insertMessages(dto);
		model.addAttribute("result",result);
		}
		return "mypage/insertResult";
	}
	@RequestMapping(value="ajaxMessages",produces="text/plain; charset=UTF8")
	@ResponseBody()
	public String ajaxMessages() {
		MessagesDTO dto = new MessagesDTO();
		String id = (String)session.getAttribute("login");
		dto.setReceiver(id);
		List<MessagesDTO> list = mService.ajaxMessages(dto);
		Gson gson = new Gson();
		String result = gson.toJson(list);
		return result;
	}
	@RequestMapping("searchMessages.mp")
	public String searchMessage(HttpServletRequest request,Model model) throws Exception {
		MessagesDTO dto = new MessagesDTO();
		String id = (String)session.getAttribute("login");
		dto.setReceiver(id);
		model.addAttribute("id",id);
		int page = 1;
		String searchText = request.getParameter("searchText");
		String category = request.getParameter("category");
		System.out.println(searchText+":"+category);
		List<MessagesDTO> list = mService.searchMessages(page,dto,searchText,category);
		model.addAttribute("list",list);
		String navi = mService.searchNaviMessage(page,dto,searchText,category);
		model.addAttribute("navi",navi);
		return "mypage/messages";
	}
	@RequestMapping("customCount.mp")
	@ResponseBody
	public String customCount() {
		Customer_ServiceDTO dto = new Customer_ServiceDTO();
		String id = (String)session.getAttribute("login");
		dto.setWriter(id);
		int result = csService.countCustomResp(dto);
		String count = Integer.toString(result);
		return count;
	}
	@RequestMapping("delBasket.mp")
	public String delMark(HttpServletRequest request, Model model) throws Exception {
		BasketDTO dto = new BasketDTO();
		String id = (String)session.getAttribute("login");
		int seq = Integer.parseInt(request.getParameter("seq"));
		int page= Integer.parseInt(request.getParameter("page"));
		System.out.println(seq+":"+page);
		dto.setSeq(seq);
		dto.setId(id);
		model.addAttribute("id",id);
		int result = gService.deleteBasket(dto);
		if(result > 0) {
			String endDate = UtilTime.endDate();
			String startDate = UtilTime.startDate();	
			model.addAttribute("startDate",startDate);
			model.addAttribute("endDate",endDate);	
			List<BasketDTO> list = gService.selectBasket(page, dto); 
			model.addAttribute("list",list);
			String navi = gService.naviBasket(page, dto);
			model.addAttribute("navi",navi);
			return "mypage/basket";
		}
		return "redirect:/";
	}
	@RequestMapping("getBasketNavi.mp")
	@ResponseBody
	public String getBasketNavi() throws Exception {
		BasketDTO dto = new BasketDTO(); 
		String id = (String)session.getAttribute("login");
		dto.setId(id);
		int page = 1;
		String navi = gService.naviBasket(page, dto);
		int count = gService.totalCountBasket(dto);
		System.out.println(count);
		if(count <= 1) {
			return null;
		}else {	
			return navi;
		}
	}
	@RequestMapping("basket.mp")
	public String basket(HttpServletRequest request,Model model) throws Exception {
		BasketDTO dto = new BasketDTO(); 
		String id = (String)session.getAttribute("login");
		dto.setId(id);
		int page =Integer.parseInt(request.getParameter("page"));
		String endDate = UtilTime.endDate();
		String startDate = UtilTime.startDate();
		model.addAttribute("id",id);
		model.addAttribute("startDate",startDate);
		model.addAttribute("endDate",endDate);	
		List<BasketDTO> list = gService.selectBasket(page, dto); 
		model.addAttribute("list",list);
		String navi = gService.naviBasket(page, dto);
		model.addAttribute("navi",navi);
		return "mypage/basket";
	}
	@RequestMapping("searchBasket.mp")
	public String searchBasket(HttpServletRequest request,Model model) throws Exception {
		BasketDTO dto = new BasketDTO(); 
		String id = (String)session.getAttribute("login");
		dto.setId(id);
		int page =Integer.parseInt(request.getParameter("page"));
		String endDate = request.getParameter("endDate");
		String startDate = request.getParameter("startDate");
		model.addAttribute("id",id);
		model.addAttribute("endDate",endDate);
		model.addAttribute("startDate",startDate);
		List<BasketDTO> list = gService.searchBasket(page, startDate, endDate, dto);
		model.addAttribute("list",list);
		String navi = gService.searchNaviBasket(page, startDate, endDate, dto);
		model.addAttribute("navi",navi);
		return "mypage/basket";
	}
	@RequestMapping("myBuy.mp")
	public String MyBuy(HttpServletRequest request,Model model) throws Exception {
		GoodsDTO dto = new GoodsDTO(); 
		String id = (String)session.getAttribute("login");
		dto.setGoodWriter(id);
		int page =Integer.parseInt(request.getParameter("page"));
		String endDate = UtilTime.endDate();
		String startDate = UtilTime.startDate();
		System.out.println(endDate +":"+startDate);
		model.addAttribute("id",id);
		model.addAttribute("endDate",endDate);
		model.addAttribute("startDate",startDate);
		List<GoodsDTO> list = gService.selectMyBuy(page, dto);
		model.addAttribute("list",list);
		String navi = gService.naviMyBuy(page, dto);
		model.addAttribute("navi",navi);
		return "mypage/myBuy";
	}
	@RequestMapping("searchMyBuy.mp")
	public String searchMyBuy(HttpServletRequest request,Model model) throws Exception {
		GoodsDTO dto = new GoodsDTO(); 
		String id = (String)session.getAttribute("login");
		dto.setGoodWriter(id);
		int page =Integer.parseInt(request.getParameter("page"));
		String endDate = request.getParameter("endDate");
		String startDate = request.getParameter("startDate");
		model.addAttribute("id",id);
		model.addAttribute("endDate",endDate);
		model.addAttribute("startDate",startDate);
		List<GoodsDTO> list = gService.searchMyBuy(page, startDate, endDate, dto);
		model.addAttribute("list",list);
		String navi = gService.searchNaviMyBuy(page, startDate, endDate, dto);
		model.addAttribute("navi",navi);
		return "mypage/myBuy";
	}
	@RequestMapping("mySell.mp")
	public String MySell(HttpServletRequest request,Model model) throws Exception {
		GoodsDTO dto = new GoodsDTO(); 
		String id = (String)session.getAttribute("login");
		dto.setGoodWriter(id);
		int page =Integer.parseInt(request.getParameter("page"));
		String endDate = UtilTime.endDate();
		String startDate = UtilTime.startDate();
		model.addAttribute("id",id);
		model.addAttribute("endDate",endDate);
		model.addAttribute("startDate",startDate);
		List<GoodsDTO> list = gService.selectMySell(page, dto);
		model.addAttribute("list",list);
		String navi = gService.naviMySell(page, dto);
		model.addAttribute("navi",navi);
		return "mypage/mySell";
	}
	@RequestMapping("searchMySell.mp")
	public String searchMySell(HttpServletRequest request,Model model) throws Exception {
		GoodsDTO dto = new GoodsDTO(); 
		String id = (String)session.getAttribute("login");
		dto.setGoodWriter(id);
		int page =Integer.parseInt(request.getParameter("page"));
		String endDate = request.getParameter("endDate");
		String startDate = request.getParameter("startDate");
		model.addAttribute("id",id);
		model.addAttribute("endDate",endDate);
		model.addAttribute("startDate",startDate);
		List<GoodsDTO> list = gService.searchMySell(page, startDate, endDate, dto);
		model.addAttribute("list",list);
		String navi = gService.searchNaviMySell(page, startDate, endDate, dto);
		model.addAttribute("navi",navi);
		return "mypage/mySell";
	}
	
	@RequestMapping("salesList.mp")
	public String salesList(HttpServletRequest request,Model model) throws Exception {
		SalesListDTO dto = new SalesListDTO(); 
		String id = (String)session.getAttribute("login");
		dto.setWriter(id);
		int page =Integer.parseInt(request.getParameter("page"));
		String endDate = UtilTime.endDate();
		String startDate = UtilTime.startDate();
		model.addAttribute("id",id);
		model.addAttribute("endDate",endDate);
		model.addAttribute("startDate",startDate);
		List<SalesListDTO> list = slService.select(page, dto);
		model.addAttribute("list",list);
		String navi = slService.navi(page, dto);
		model.addAttribute("navi",navi);
		return "mypage/salesList";
	}
	
	@RequestMapping("searchSalesList.mp")
	public String searchSalesList(HttpServletRequest request,Model model) throws Exception {
		SalesListDTO dto = new SalesListDTO(); 
		String id = (String)session.getAttribute("login");
		dto.setWriter(id);
		int page =Integer.parseInt(request.getParameter("page"));
		String endDate = request.getParameter("endDate");
		String startDate = request.getParameter("startDate");
		model.addAttribute("id",id);
		model.addAttribute("endDate",endDate);
		model.addAttribute("startDate",startDate);
		List<SalesListDTO> list = slService.search(page, startDate, endDate, dto);
		model.addAttribute("list",list);
		String navi = slService.searchNavi(page, startDate, endDate, dto);
		model.addAttribute("navi",navi);
		return "mypage/salesList";
	}
	
	@RequestMapping("purchaseList.mp")
	public String purchaseList(HttpServletRequest request,Model model) throws Exception {
		PurchaseListDTO dto = new PurchaseListDTO(); 
		String id = (String)session.getAttribute("login");
		dto.setWriter(id);
		int page =Integer.parseInt(request.getParameter("page"));
		String endDate = UtilTime.endDate();
		String startDate = UtilTime.startDate();
		model.addAttribute("id",id);
		model.addAttribute("endDate",endDate);
		model.addAttribute("startDate",startDate);
		List<PurchaseListDTO> list = plService.select(page, dto);
		model.addAttribute("list",list);
		String navi = plService.navi(page, dto);
		model.addAttribute("navi",navi);
		return "mypage/purchaseList";
	}
	@RequestMapping("searchPurchaseList.mp")
	public String searchPurchaseList(HttpServletRequest request,Model model) throws Exception {
		PurchaseListDTO dto = new PurchaseListDTO(); 
		String id = (String)session.getAttribute("login");
		dto.setWriter(id);
		int page =Integer.parseInt(request.getParameter("page"));
		String endDate = request.getParameter("endDate");
		String startDate = request.getParameter("startDate");
		model.addAttribute("id",id);
		model.addAttribute("endDate",endDate);
		model.addAttribute("startDate",startDate);
		List<PurchaseListDTO> list = plService.search(page, startDate, endDate, dto);
		model.addAttribute("list",list);
		String navi = plService.searchNavi(page, startDate, endDate, dto);
		model.addAttribute("navi",navi);
		return "mypage/purchaseList";
	}
	
	@RequestMapping("endList_Clear.mp")
	public String endList_Clear(HttpServletRequest request,Model model) throws Exception {
		EndList_ClearDTO dto = new EndList_ClearDTO(); 
		String id = (String)session.getAttribute("login");
		dto.setGoodWriter(id);
		dto.setBuyer(id);
		int page =Integer.parseInt(request.getParameter("page"));
		String endDate = UtilTime.endDate();
		String startDate = UtilTime.startDate();
		model.addAttribute("id",id);
		model.addAttribute("endDate",endDate);
		model.addAttribute("startDate",startDate);
		List<EndList_ClearDTO> list = elcService.select(page, dto);
		model.addAttribute("list",list);
		String navi = elcService.navi(page, dto);
		model.addAttribute("navi",navi);
		return "mypage/endList_Clear";
	}
	@RequestMapping("searchEndList_Clear.mp")
	public String searchEndList_Clear(HttpServletRequest request,Model model) throws Exception {
		EndList_ClearDTO dto = new EndList_ClearDTO(); 
		String id = (String)session.getAttribute("login");
		dto.setGoodWriter(id);
		dto.setBuyer(id);
		int page =Integer.parseInt(request.getParameter("page"));
		String endDate = request.getParameter("endDate");
		String startDate = request.getParameter("startDate");
		model.addAttribute("id",id);
		model.addAttribute("endDate",endDate);
		model.addAttribute("startDate",startDate);
		List<EndList_ClearDTO> list = elcService.search(page, startDate, endDate, dto);
		model.addAttribute("list",list);
		String navi = elcService.searchNavi(page, startDate, endDate, dto);
		model.addAttribute("navi",navi);
		return "mypage/endList_Clear";
	}
	@RequestMapping("endList_Pay.mp")
	public String endList_Pay(HttpServletRequest request,Model model) throws Exception {
		EndList_PayDTO dto = new EndList_PayDTO(); 
		String id = (String)session.getAttribute("login");
		int page =Integer.parseInt(request.getParameter("page"));
		dto.setId(id);
		String endDate = UtilTime.endDate();
		String startDate = UtilTime.startDate();
		model.addAttribute("id",id);
		model.addAttribute("endDate",endDate);
		model.addAttribute("startDate",startDate);
		List<EndList_PayDTO> list = elpService.select(page, dto);
		
		model.addAttribute("list",list);
		String navi = elpService.navi(page, dto);
		model.addAttribute("navi",navi);
		return "mypage/endList_Pay";
	}
	@RequestMapping("searchEndList_Pay.mp")
	public String searchEndList_Pay(HttpServletRequest request,Model model) throws Exception {
		EndList_PayDTO dto = new EndList_PayDTO(); 
		String id = (String)session.getAttribute("login");
		int page =Integer.parseInt(request.getParameter("page"));
		dto.setId(id);
		String endDate = request.getParameter("endDate");
		String startDate = request.getParameter("startDate");
		model.addAttribute("id",id);
		model.addAttribute("endDate",endDate);
		model.addAttribute("startDate",startDate);
		List<EndList_PayDTO> list = elpService.search(page, startDate, endDate, dto);
		model.addAttribute("list",list);
		String navi = elpService.searchNavi(page, startDate, endDate, dto);
		model.addAttribute("navi",navi);
		return "mypage/endList_Pay";
	}
	@RequestMapping("cancelList.mp")
	public String cancelList(HttpServletRequest request,Model model) throws Exception {
		CancelListDTO dto = new CancelListDTO(); 
		String id = (String)session.getAttribute("login");
		dto.setWriter(id);
		int page =Integer.parseInt(request.getParameter("page"));
		String endDate = UtilTime.endDate();
		String startDate = UtilTime.startDate();
		model.addAttribute("id",id);
		model.addAttribute("endDate",endDate);
		model.addAttribute("startDate",startDate);
		List<CancelListDTO> list = clService.select(page, dto);
		model.addAttribute("list",list);
		String navi = clService.navi(page, dto);
		model.addAttribute("navi",navi);
		return "mypage/cancelList";
	}
	@RequestMapping("searchCancelList.mp")
	public String searchCancelList(HttpServletRequest request,Model model) throws Exception {
		CancelListDTO dto = new CancelListDTO(); 
		String id = (String)session.getAttribute("login");
		dto.setWriter(id);
		int page =Integer.parseInt(request.getParameter("page"));
		String endDate = request.getParameter("endDate");
		String startDate = request.getParameter("startDate");
		model.addAttribute("id",id);
		model.addAttribute("endDate",endDate);
		model.addAttribute("startDate",startDate);
		List<CancelListDTO> list = clService.search(page, startDate, endDate, dto);
		model.addAttribute("list",list);
		String navi = clService.searchNavi(page, startDate, endDate, dto);
		model.addAttribute("navi",navi);
		return "mypage/cancelList";
	}
	@RequestMapping("notYet.mp")
	public String notYet() {
		return "notYet";
	}
	@ExceptionHandler
	public String exceptionhandler(Exception e){
		return "error";
	}
}
