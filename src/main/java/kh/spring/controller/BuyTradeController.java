package kh.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import kh.spring.dto.BuyTradeDTO;
import kh.spring.dto.CancelListDTO;
import kh.spring.dto.EndList_ClearDTO;
import kh.spring.dto.EndList_PayDTO;
import kh.spring.dto.GoodsDTO;
import kh.spring.dto.MembersDTO;
import kh.spring.dto.PurchaseListDTO;
import kh.spring.dto.SalesListDTO;
import kh.spring.dto.TradeDTO;
import kh.spring.service.BuyTradeService;
import kh.spring.service.CancelListService;
import kh.spring.service.EndList_ClearService;
import kh.spring.service.EndList_PayService;
import kh.spring.service.GoodsService;
import kh.spring.service.MembersService;
import kh.spring.service.PurchaseListService;
import kh.spring.service.SalesListService;
import kh.spring.service.TradeService;


@Controller
@RequestMapping("/trade")
public class BuyTradeController {
	@Autowired
	private BuyTradeService btService;
	@Autowired
	private TradeService tService;
	@Autowired
	private HttpSession session;
	@Autowired
	private GoodsService gService;
	@Autowired
	private MembersService mService;
	@Autowired
	private PurchaseListService plService;
	@Autowired
	private SalesListService slService;
	@Autowired
	private CancelListService clService;
	@Autowired
	private EndList_ClearService elcService;
	@Autowired
	private EndList_PayService elpService;
	@RequestMapping("buyer.pg")
	public String Buy(HttpServletRequest request ,Model model) {
		String id = (String)session.getAttribute("login");
		model.addAttribute("id",id);
		int goodSeq = Integer.parseInt(request.getParameter("seq")); //상품번호
		GoodsDTO gdto = gService.select(goodSeq);
		System.out.println("코드:" + gdto.getCateCode());
		if(gdto.getCateCode()==1) {
		model.addAttribute("dto",gdto);
		BuyTradeDTO dto = new BuyTradeDTO();
		dto.setGoodSeq(goodSeq);
		dto.setGoodWriter(gdto.getGoodWriter());
		dto.setBuyer(id);
		dto.setGoodName(gdto.getGoodName());
		dto.setPrice(gdto.getGoodPrice());
		dto.setCateCode(gdto.getCateCode());
		int count = btService.countTrade(dto);
		if(count == 0) {
			btService.insertTrade(dto);
		}
			//req 가져오기
			String req = btService.tradeReq(dto);
			model.addAttribute("req",req);
			//Member정보
			MembersDTO mdto = new MembersDTO();
			mdto.setId(id);
			mdto = mService.getMember(mdto);
			model.addAttribute("mdto",mdto);
		     //cf확인
				dto = btService.selectTrade(dto); //buyer writer GoodSeq
				String cf =	dto.getCf();
				model.addAttribute("cf",cf);
				//checkTrade
			    BuyTradeDTO btdto = new BuyTradeDTO();
			    btdto.setGoodWriter(id);
			    int BuycheckTrade = btService.checkTrade(btdto);
			    int checkTrade = tService.checkTrade(id);
			    checkTrade =BuycheckTrade + checkTrade;
			    model.addAttribute("checkTrade",checkTrade);
			 //
			//req확인
				req = "";
				String buyer_req="";
				System.out.println("거래리스트 : "+tService.selectBuyerList(id));
			    if(!btService.selectBuyerList(id).isEmpty()) {
			    	 req = "Y";	//buyer writer GoodSeq				
			    }else {
			    	req = "N";
			    }
			    if(!tService.selectBuyerList(id).isEmpty()) {
			    	buyer_req="Y"; 
			    }else {
			    	buyer_req="N";
			    }
				if(req.contentEquals("Y") || buyer_req.contentEquals("Y") ) {
						model.addAttribute("allReq", "Y");
					}else {
						model.addAttribute("allReq","N");
					}	
			    return "trade/buyer";
		}else {		
		      String buyerId = (String)session.getAttribute("login");   // 로그인된아이디 불러오기
		      String goodName = (String)request.getParameter("title");   //jsp페이지에서 상품명 불러오기
		      String goodWriter = (String)request.getParameter("goodWriter");   // jsp페이지에서 작성자 불러오기
		      String goodPrice = (String)request.getParameter("goodPrice");   // jsp 페이지에서 가격 불러오기
		      
		      String goodSeqs = Integer.toString(goodSeq);

		      //상품명, 작성자, 가격은 인서트할때 필요한 정보라 불러오는게 맞음

		      try{// 시도하기 케이스 나누기 (만약 trade 테이블이 생성 되었었다면) 또만들면 안되니까
		         int seqi = tService.selectSeqFromTilte(goodName);   //상품명을 통해 seq int형으로 불러오기
		         String seq = Integer.toString(seqi);   //seq String형으로 바꿔주기
		         TradeDTO dto = tService.selectTradeWant3(seq);   // seq에 해당하는 dto불러오기
		         	

		         String contact = mService.getListContact(dto.getSeller());   // 작성자에 정보의 연락처 불러오기
		         String email = mService.getListEmail(dto.getSeller());   //작성자에 정보의 email 불러오기
		         String buyer_req = tService.selectBuyerReq(seq);
		         String img = gService.getImg(dto.getTitle());   // 상품명으로 이미지 불러오기
		         String seller_cfm= tService.selectSellerCfm(seq);   //seq에 해당하는 trade 데이터에서 seller_cfm 불러오기

		         // jsp로 보내기
		         model.addAttribute("seller",dto.getSeller());   
		         model.addAttribute("contact",contact);
		         model.addAttribute("email",email);
		         model.addAttribute("price",dto.getPrice());
		         model.addAttribute("buyer_req",buyer_req);
		         model.addAttribute("seller_cfm",seller_cfm);
		         model.addAttribute("img",img);

		      }catch(java.lang.NullPointerException e){// 만약 trade테이블이 만들어지지 않았다면


		         tService.insertTrade2(buyerId,goodSeqs, goodName, goodPrice, goodWriter);// trade table에 정보를 바탕으로 인서트

		         int seqi = tService.selectSeqFromTilte(goodName);   //상품명을 통해 seq int형으로 불러오기
		         String seq = Integer.toString(seqi);            //seq String형으로 바꿔주기 
		         TradeDTO dto = tService.selectTradeWant3(seq);      // seq에 해당하는 dto불러오기

		         
		         String seller_cfm= tService.selectSellerCfm(seq);   //seq에 해당하는 trade 데이터에서 seller_cfm 불러오기
		         System.out.println(seller_cfm);
		         String title = dto.getTitle();
		         String img = gService.getImg(title);
		         String contact = mService.getListContact(goodWriter);   // 작성자에 정보의 연락처 불러오기
		         String email = mService.getListEmail(goodWriter);      //작성자에 정보의 email 불러오기
		         String buyer_req = tService.selectBuyerReq(seq);
		         
		         model.addAttribute("seller",goodWriter);   
		         model.addAttribute("contact",contact);
		         model.addAttribute("email",email);
		         model.addAttribute("price",goodPrice);
		         model.addAttribute("buyer_req",buyer_req);
		         model.addAttribute("seller_cfm",seller_cfm);
		         model.addAttribute("img",img);
		         
		      }
		      session.setAttribute("title", goodName); //상품명 세션에 저장(seq를 보낼수도 있지만 session에 겹칠확률이 보다 적은 title을 그냥 보냄)
			//checkTrade
			    BuyTradeDTO btdto = new BuyTradeDTO();
			    btdto.setGoodWriter(id);
			    int BuycheckTrade = btService.checkTrade(btdto);
			    int checkTrade = tService.checkTrade(id);
			    checkTrade =BuycheckTrade + checkTrade;
			    model.addAttribute("checkTrade",checkTrade);
			 //
			//req확인
				String req = "";
				String buyer_req = "";
				System.out.println("거래리스트 : "+tService.selectBuyerList(id));
			    if(!btService.selectBuyerList(id).isEmpty()) {
			    	 req = "Y";	//buyer writer GoodSeq				
			    }else {
			    	req = "N";
			    }
			    if(!tService.selectBuyerList(id).isEmpty()) {
			    	buyer_req="Y"; 
			    }else {
			    	buyer_req="N";
			    }
				if(req.contentEquals("Y") || buyer_req.contentEquals("Y") ) {
						model.addAttribute("allReq", "Y");
					}else {
						model.addAttribute("allReq","N");
					}						
			return "buyer";
		}
	}
	@RequestMapping("req_trade.pg")
	public String req_trade(HttpServletRequest request, Model model) {
		String id = (String)session.getAttribute("login");
		model.addAttribute("id",id);
		int goodSeq = Integer.parseInt(request.getParameter("seq"));
		GoodsDTO gdto = gService.select(goodSeq);
		model.addAttribute("dto",gdto);
		BuyTradeDTO dto = new BuyTradeDTO();		
		dto.setBuyer(id);
		dto.setGoodSeq(goodSeq);
		dto.setGoodWriter(gdto.getGoodWriter());
		btService.updateReqTrade(dto);			
		//req 가져오기
		String req = btService.tradeReq(dto);
		model.addAttribute("req",req);
		//Member정보
		MembersDTO mdto = new MembersDTO();
		mdto.setId(id);
		mdto = mService.getMember(mdto);
		model.addAttribute("mdto",mdto);
		//checkTrade
	    BuyTradeDTO btdto = new BuyTradeDTO();
	    btdto.setGoodWriter(id);
	    int BuycheckTrade = btService.checkTrade(btdto);
	    int checkTrade = tService.checkTrade(id);
	    checkTrade =BuycheckTrade + checkTrade;
	    model.addAttribute("checkTrade",checkTrade);
	    
		//req확인  Nullpointer 체크
		req = "";
		String buyer_req="";
	    if(!btService.selectBuyerList(id).isEmpty() ) {
	    	 req = "Y";			
	    }else {
	    	req = "N";
	    }
	    if(!tService.selectBuyerList(id).isEmpty()) {
	    	buyer_req="Y"; 
	    }else {
	    	buyer_req="N";
	    }
		if(req.contentEquals("Y") || buyer_req.contentEquals("Y") ) {
				model.addAttribute("allReq", "Y");
			}else {
				model.addAttribute("allReq","N");
			}

		return "trade/buyer";
	}
	@RequestMapping("cancelReq_trade.pg")
	public String cancelReq_trade(HttpServletRequest request, Model model) throws Exception {
		String id = (String)session.getAttribute("login");
		String buyer = request.getParameter("buyer");
		int goodSeq = Integer.parseInt(request.getParameter("seq"));
		GoodsDTO gdto = gService.select(goodSeq);
		
		model.addAttribute("dto",gdto);
		BuyTradeDTO dto = new BuyTradeDTO();		
		dto.setBuyer(buyer);
		dto.setGoodSeq(goodSeq);
		dto.setGoodWriter(gdto.getGoodWriter());
		dto = btService.selectTrade(dto); 	//buyer writer GoodSeq로 trade정보가져와서 seq값 가져옴
		if(dto.getCf().contentEquals("Y")) {
			clService.insertCancelList(dto);
		}
		 //구매내역 삭제
	      PurchaseListDTO pldto =new PurchaseListDTO();
	      pldto.setGoodSeq(dto.getGoodSeq());
	      plService.deletePurchaseList(pldto);   //현재 구매중인 상품 리스트에서 삭제해주기
	      //판매내역 삭제
	      SalesListDTO sldto = new SalesListDTO();
	      sldto.setGoodSeq(dto.getGoodSeq());
	      slService.deleteSalesList(sldto);
		//trade 삭제
		  btService.cancelReqTrade(dto);
		//checkTrade
	      BuyTradeDTO btdto = new BuyTradeDTO();
	      btdto.setGoodWriter(id);
	      int BuycheckTrade = btService.checkTrade(btdto);
	      int checkTrade = tService.checkTrade(id);
	      checkTrade =BuycheckTrade + checkTrade;
	      model.addAttribute("checkTrade",checkTrade);
		//req확인 - Nullpointer 체크
	    dto = btService.selectTrade(dto); 	//trade가 삭제되서 다시 buyer writer GoodSeq로 trade정보가져와서 seq값 가져옴  
		String req = "";
		String buyer_req="";
		if(dto != null) {
	    if(!btService.selectBuyerList(id).isEmpty() ) {	//요청이 없을경우
	    	 req = "Y";	//buyer writer GoodSeq				
	    }else {
	    	req = "N";
	    }
	    if(!tService.selectBuyerList(id).isEmpty()) {
	    	buyer_req="Y"; 
	    }else {
	    	buyer_req="N";
	    }
		}
		if(req.contentEquals("Y") || buyer_req.contentEquals("Y")) {
				model.addAttribute("allReq","Y");
			}else {
				model.addAttribute("allReq","N");
			}
		
		//home으로 갈 준비//
		int currentPage =1;
		List<GoodsDTO> list = gService.listByCpage(currentPage);   
		String navi = gService.getNavi(currentPage);
     
		model.addAttribute("list", list);
		model.addAttribute("navi", navi);
		return "home";
	}
	
	@RequestMapping("writerCancelReq_trade.pg")
	public String writerCancelReq_trade(HttpServletRequest request, Model model) throws Exception {
		String id = (String)session.getAttribute("login");
		String buyer = request.getParameter("buyer");
		int goodSeq = Integer.parseInt(request.getParameter("seq"));
		GoodsDTO gdto = gService.select(goodSeq);
		
		model.addAttribute("dto",gdto);
		BuyTradeDTO dto = new BuyTradeDTO();		
		dto.setBuyer(buyer);
		dto.setGoodSeq(goodSeq);
		dto.setGoodWriter(gdto.getGoodWriter());
		//거래 중일 경우 취소 시 취소내역으로
		dto = btService.selectTrade(dto); 	//buyer writer GoodSeq로 trade정보가져와서 seq값 가져옴
		if(dto.getCf().contentEquals("Y")) {
			//취소내역 추가	  
			clService.insertCancelList(dto); //trade정보로 cancelList에 추가
			
			 //구매내역 삭제
		      PurchaseListDTO pldto =new PurchaseListDTO();
		      pldto.setGoodSeq(dto.getGoodSeq());
		      plService.deletePurchaseList(pldto);   //현재 구매중인 상품 리스트에서 삭제해주기  
		      //판매내역 삭제
		      SalesListDTO sldto = new SalesListDTO();
		      sldto.setGoodSeq(dto.getGoodSeq());
		      slService.deleteSalesList(sldto);
		}
		//trade 삭제
		  btService.cancelReqTrade(dto);
		//checkTrade
	      BuyTradeDTO btdto = new BuyTradeDTO();
	      btdto.setGoodWriter(id);
	      int BuycheckTrade = btService.checkTrade(btdto);
	      int checkTrade = tService.checkTrade(id);
	      checkTrade =BuycheckTrade + checkTrade;
	      model.addAttribute("checkTrade",checkTrade);
	     
		//req확인 - Nullpointer 체크
	    dto = btService.selectTrade(dto); 	//trade가 삭제되서 다시 buyer writer GoodSeq로 trade정보가져와서 seq값 가져옴  
		String req = "";
		String buyer_req="";
		if(dto != null) {
	    if(!btService.selectBuyerList(id).isEmpty() ) {	//요청이 없을경우
	    	 req = "Y";	//buyer writer GoodSeq				
	    }else {
	    	req = "N";
	    }
	    if(!tService.selectBuyerList(id).isEmpty()) {
	    	buyer_req="Y"; 
	    }else {
	    	buyer_req="N";
	    }
		}
		if(req.contentEquals("Y") || buyer_req.contentEquals("Y")) {
				model.addAttribute("allReq","Y");
			}else {
				model.addAttribute("allReq","N");
			}
		
		//home으로 갈 준비//
		int currentPage =1;
		List<GoodsDTO> list = gService.listByCpage(currentPage);   
		String navi = gService.getNavi(currentPage);
     
		model.addAttribute("list", list);
		model.addAttribute("navi", navi);
		return "home";
	}
	
	
	@RequestMapping("writerFocus.pg")
	public String writeFocus(HttpServletRequest request, Model model) {
		String id = (String)session.getAttribute("login");
		int seq = Integer.parseInt(request.getParameter("goodSeq")); //tradeSeq
		//memberList, TradeDTO
		BuyTradeDTO dto = new BuyTradeDTO();
		dto.setSeq(seq);
		dto = btService.selectTradeSeq(dto); //tradeSeq로 검색
		int goodSeq = dto.getGoodSeq();
		model.addAttribute("dto",dto);
		GoodsDTO gdto = gService.select(goodSeq);
		model.addAttribute("gdto",gdto);
		MembersDTO mdto = new MembersDTO();
		mdto.setId(dto.getBuyer());
		mdto = mService.getMember(mdto);
		model.addAttribute("mdto",mdto);
		
		//cf확인	
		String cf =	dto.getCf();
		model.addAttribute("cf",cf);
		//checkTrade
	      BuyTradeDTO btdto = new BuyTradeDTO();
	      btdto.setGoodWriter(id);
	      int BuycheckTrade = btService.checkTrade(btdto);
	      int checkTrade = tService.checkTrade(id);
	      checkTrade =BuycheckTrade + checkTrade;
	      model.addAttribute("checkTrade",checkTrade);
	     //	
	    //req확인  Nullpointer 체크
	    btdto.setBuyer(id);
		String req = "";
		String buyer_req="";
	    if(!btService.selectBuyerList(id).isEmpty() ) {
	    	 req = "Y";	//buyer writer GoodSeq				
	    }else {
	    	req = "N";
	    }
	    if(!tService.selectBuyerList(id).isEmpty()) {
	    	buyer_req= "Y";
	    }else {
	    	buyer_req="N";
	    }
		if(req.contentEquals("Y") || buyer_req.contentEquals("Y") ) {
				model.addAttribute("allReq", "Y");
			}else {
				model.addAttribute("allReq","N");
			}
	     return "trade/writerFocus";
	}
	@RequestMapping("confirm.pg")
	public String confirm(HttpServletRequest request, Model model) throws Exception{
		String id = (String)session.getAttribute("login");
		int seq = Integer.parseInt(request.getParameter("goodSeq")); //tradeSeq
		//memberList, TradeDTO
		BuyTradeDTO dto = new BuyTradeDTO();
		dto.setSeq(seq);
		dto = btService.selectTradeSeq(dto); //tradeSeq로 검색
		int goodSeq = dto.getGoodSeq();
		model.addAttribute("dto",dto);
		GoodsDTO gdto = gService.select(goodSeq);
		model.addAttribute("gdto",gdto);
		MembersDTO mdto = new MembersDTO();
		mdto.setId(dto.getBuyer());
		mdto = mService.getMember(mdto);
		model.addAttribute("mdto",mdto);
		
		//checkTrade
	      BuyTradeDTO btdto = new BuyTradeDTO();
	      btdto.setGoodWriter(id);
	      int BuycheckTrade = btService.checkTrade(btdto);
	      int checkTrade = tService.checkTrade(id);
	      checkTrade =BuycheckTrade + checkTrade;
	      model.addAttribute("checkTrade",checkTrade);
	     //
	    //req확인  Nullpointer 체크
		String req = "";
		String buyer_req="";
		System.out.println("Test:"+btService.selectReqList(id));
	    if(!btService.selectBuyerList(id).isEmpty() ) {
	    	 req = "Y";	//buyer writer GoodSeq				
	    }else {
	    	req = "N";
	    }
	    if(!tService.selectBuyerList(id).isEmpty()) {
	    	buyer_req= "Y";
	    }else {
	    	buyer_req="N";
	    }
		if(req.contentEquals("Y") || buyer_req.contentEquals("Y") ) {
				model.addAttribute("allReq", "Y");
		}else {
				model.addAttribute("allReq","N");
		}
		
		//cf update하기 전에 마일리지 확인 후 모자르면 return update되지 않음
		int myMileage = mService.checkMileage(id);
		if(myMileage < gdto.getGoodPrice()) {
			int currentPage =1;
			List<GoodsDTO> list = gService.listByCpage(currentPage);   
			String navi = gService.getNavi(currentPage);
	   
			model.addAttribute("list", list);
			model.addAttribute("navi", navi);
			return "home";
		}
		//cf update
		btService.updateCf(dto); //
//		구매내역 추가(goodWriter)
		plService.insertPurchase(dto); //거래정보로 추가하기
//		//판매내역 추가(buyer)
		slService.insertSalesList(dto); //거래정보로 추가하기
//		cf확인	
		dto = btService.selectTradeSeq(dto); //tradeSeq로 검색
		String cf =	dto.getCf();
		model.addAttribute("cf",cf);	
	    return "trade/writerFocus";
	}
	@RequestMapping("complete_trade.pg")
	public String complete_trade(HttpServletRequest request,Model model) throws Exception {
		String id = (String)session.getAttribute("login");
		int goodSeq = Integer.parseInt(request.getParameter("seq")); //상품번호
		GoodsDTO gdto = gService.select(goodSeq); //상품번호로 상품정보 가져옴
		BuyTradeDTO dto = new BuyTradeDTO();		//dto에 상품정보를 Trade에 담음
		dto.setBuyer(id);
		dto.setGoodSeq(goodSeq);
		dto.setGoodWriter(gdto.getGoodWriter());
		dto = btService.selectTrade(dto);
		//Trade 삭제
		btService.deleteTrade(dto);
		//마일리지 변동
		//-구매자(상품 가격만큼 마일리지 추가)  + 결제내역
		int myMileage = mService.checkMileage(id);
		myMileage = myMileage + gdto.getGoodPrice();
		MembersDTO mdto = new MembersDTO();		
		mdto.setId(id);
		mdto.setMileage(myMileage);
		mService.updateMileage(mdto);
		EndList_PayDTO elpdto = new EndList_PayDTO();
		elpdto.setGoodName(gdto.getGoodName());
		elpdto.setId(id);
		elpdto.setMileage(myMileage);
		elpdto.setValue(gdto.getGoodPrice());
		elpdto.setGoodSeq(goodSeq);
		elpService.insert(elpdto);
		//-판매자(상품 가격만큼 마일리지 감소) + 결제내역
		System.out.println(gdto.getGoodWriter());
		myMileage = mService.checkMileage(gdto.getGoodWriter());
		myMileage = myMileage - gdto.getGoodPrice();
		mdto.setId(gdto.getGoodWriter());
		mdto.setMileage(myMileage);
		mService.updateMileage(mdto);
		elpdto.setMileage(myMileage);
		elpdto.setId(gdto.getGoodWriter());
		elpdto.setValue(-gdto.getGoodPrice());
		elpService.insert(elpdto);
		//구매,판매 내역 삭제
		PurchaseListDTO pldto = new PurchaseListDTO();
		pldto.setGoodSeq(goodSeq);
		plService.deletePurchaseList(pldto);
		SalesListDTO sldto = new SalesListDTO();
		sldto.setGoodSeq(goodSeq);
		slService.deleteSalesList(sldto);
		//거래 완료
		elcService.insertEndList_Clear(dto); //trade정보로 완료내역 입력
		
		//홈 이동
		//checkTrade
	      BuyTradeDTO btdto = new BuyTradeDTO();
	      btdto.setGoodWriter(id);
	      int BuycheckTrade = btService.checkTrade(btdto);
	      int checkTrade = tService.checkTrade(id);
	      checkTrade =BuycheckTrade + checkTrade;
	      model.addAttribute("checkTrade",checkTrade);
	    //req확인  Nullpointer 체크
		String req = "";
		String buyer_req="";
	    if(!btService.selectBuyerList(id).isEmpty()) {
	    	 req = "Y";	//buyer writer GoodSeq				
	    }else {
	    	req = "N";
	    }
	    if(!tService.selectBuyerList(id).isEmpty()) {
		    	buyer_req= "Y";
	    }else {
	    	buyer_req="N";
		}
		if(req.contentEquals("Y") || buyer_req.contentEquals("Y") ) {
				model.addAttribute("allReq", "Y");
			}else {
				model.addAttribute("allReq","N");
			}
		//home으로 갈 준비//
		int currentPage =1;
		List<GoodsDTO> list = gService.listByCpage(currentPage);   
		String navi = gService.getNavi(currentPage);
   
		model.addAttribute("list", list);
		model.addAttribute("navi", navi);
		return "home";
	}
	@ExceptionHandler
	public String exceptionhandler(Exception e){
		return "error";
	}
	
}
