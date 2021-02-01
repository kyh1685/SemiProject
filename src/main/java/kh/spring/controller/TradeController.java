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
import kh.spring.dto.PurchaseListDTO;
import kh.spring.dto.TradeDTO;
import kh.spring.service.BuyTradeService;
import kh.spring.service.CancelListService;
import kh.spring.service.EndList_ClearService;
import kh.spring.service.EndList_PayService;
import kh.spring.service.EndlistPayService;
import kh.spring.service.GoodsService;
import kh.spring.service.MembersService;
import kh.spring.service.PurchaseListService;
import kh.spring.service.TradeService;



@Controller
@RequestMapping("/trade")
public class TradeController {
	
	 @Autowired
	 private TradeService service;
	 @Autowired
	 private BuyTradeService btService;

   @Autowired
   private CancelListService cservice;

   @Autowired
   private PurchaseListService pservice;

   @Autowired
   private MembersService mservice;

   @Autowired
   private EndList_ClearService ecservice;

   @Autowired
   private EndlistPayService epservice;

   @Autowired
   private GoodsService gsservice;

   @Autowired
   private EndList_PayService EPservice;


   @RequestMapping("buyer_cfmDelete.pg")
   public String toConfirmDelete(HttpSession session,HttpServletRequest request ,Model model) throws Exception {
      String buyerId=(String)session.getAttribute("login");   //id받고
      String title = (String)session.getAttribute("title");   //title받고
      int seqi = service.selectSeqFromTilte(title);   //seq 가져오기
      String seq = Integer.toString(seqi);   //밑에 구문에 넣을 스트링형으로 바꾸기
      TradeDTO dto = service.selectTradeWant3(seq);   // seq에 해당하는 trade 데이터 갖고오기

      String sellerId = dto.getSeller();

//      service.updateRequestDel(buyerId, sellerId, title);//buyer_req = 'N'으로 업데이트 하기 -삭제하는 굳이?
//      int price = dto.getPrice();
//      int passed_mileage = mservice.selectMileage(buyerId); // 증가시키기전 해당 아이디에 마일리지 가져오기
//      mservice.plus(buyerId, passed_mileage, price);   // 해당 아이디에 마일리지 증가 시키기

//      int goodSeq = gsservice.selectSeq(title);
//      
//      CancelListDTO dto3 = new CancelListDTO();
//      
//      dto3.setWriter(dto.getBuyer());
//      dto3.setTitle(dto.getTitle());
//      dto3.setPrice(dto.getPrice());
//      dto3.setGoodSeq(gsservice.selectSeq(title));
//      cservice.insert(dto3);   // 취소 리스트에 인서트 하기
       

//      EndList_PayDTO dto2 = new EndList_PayDTO();
//      
//      dto2.setId(dto.getBuyer());
//      dto2.setMileage(mservice.selectMileage(dto.getSeller()));
//      dto2.setGoodName(dto.getTitle());
//      dto2.setValue(dto.getPrice());
//      dto2.setGoodSeq(gsservice.selectSeq(title));
//      
//      EPservice.insert(dto2);   // 마일리지의 변화가 있었으니 endlist_pay에 인서트
      //구매내역 삭제(타이밍 버그 때문에)
      PurchaseListDTO pldto =new PurchaseListDTO();
      pldto.setGoodSeq(dto.getGoodSeq());
      pservice.deletePurchaseList(pldto);   //현재 구매중인 상품 리스트에서 삭제해주기  
      
      
      try {
    	  service.deleteTrade(dto.getSeq());
      }catch(Exception e) {
    	  
      }
      	// 태이블 지워주기
      session.removeAttribute("title");   // session 지워주기

      //---------------------------------홈쪽에 상품 띄우기 위한 코드-----------------------------------------
      String cpage = null;
      int currentPage = 0;
      if(request.getParameter("cpage")==null) {
         currentPage= 1;
      }else {
         cpage = request.getParameter("cpage");
         currentPage = Integer.parseInt(cpage);
      }
      List<GoodsDTO> list = gsservice.listByCpage(currentPage);   
      String navi = gsservice.getNavi(currentPage);

      model.addAttribute("list", list);
      model.addAttribute("navi", navi);
      return "home";
   }

   @RequestMapping("buyer_cfmComplete.pg")
   public String toConfirmComplete(HttpSession session,HttpServletRequest request ,Model model) throws Exception {
      System.out.println("구매자가 거래완료 누름!");
      String title = (String)session.getAttribute("title");
      
      int seqi = service.selectSeqFromTilte(title);   //seq 가져오기
      String seq = Integer.toString(seqi);   //밑에 구문에 넣을 스트링형으로 바꾸기
      TradeDTO dto = service.selectTradeWant3(seq);   // seq에 해당하는 trade 데이터 갖고오기
      int price = dto.getPrice();//물품값 가져오기
      String sellerId = dto.getSeller();   //판매자 불러오기
      String buyerId = (String)session.getAttribute("login");
      
      //판매자 플러스
      int passed_mileage = mservice.selectMileage(sellerId);//거래완료 눌렀으니 판매자 마일리지 올리기 위한 올리기전 마일리지 가져오기
      mservice.plus(sellerId, passed_mileage, price);   //이전 마일리지 에서 가격만큼 마일리지 더해주기
      EndList_ClearDTO dto3 = new EndList_ClearDTO();
      dto3.setBuyer(dto.getBuyer());
      dto3.setGoodWriter(dto.getSeller());
      dto3.setTitle(dto.getTitle());
      dto3.setPrice(dto.getPrice());
      dto3.setGoodSeq(gsservice.selectSeq(dto.getTitle()));
      ecservice.insert(dto3);   //거래가 완료되었으니 거래완료 페이지 인서트        
      EndList_PayDTO dto2 = new EndList_PayDTO();
      
      dto2.setId(dto.getSeller());
      dto2.setMileage(mservice.selectMileage(dto.getSeller()));
      dto2.setGoodName(dto.getTitle());
      dto2.setValue(dto.getPrice());
      dto2.setGoodSeq(gsservice.selectSeq(title));      
      EPservice.insert(dto2);   // 마일리지의 변화가 있었으니 endlist_pay에 인서트
      
      //구매자 마이너스
      passed_mileage = mservice.selectMileage(buyerId);   // 변동전 마일리지 갖고오기
      mservice.minus(buyerId, passed_mileage, price);   // 구매자 샀으니 감소
   
      dto2 = new EndList_PayDTO();
    
      dto2.setId(dto.getBuyer());
      dto2.setMileage(mservice.selectMileage(buyerId));
      dto2.setGoodName(dto.getTitle());
      dto2.setValue(dto.getPrice()*-1);
      dto2.setGoodSeq(gsservice.selectSeq(title));
   
      EPservice.insert(dto2);   // 마일리지의 변화가 있었으니 endlist_pay에 인서트
      //구매내역 삭제
      PurchaseListDTO pldto =new PurchaseListDTO();
      pldto.setGoodSeq(dto.getGoodSeq());
      pservice.deletePurchaseList(pldto);   //현재 구매중인 상품 리스트에서 삭제해주기
      
      try {// 디비에 저장 다되고 잘작동하는데 에러가 나길래 쓴 코드
         service.deleteTrade(seqi);   // 거래완료 되었으니 seq에 해당하는 trade지우기 이녀석이 작동 잘하면서 에러나서 try catch문 씀
      }catch(Exception e) {

         //------------홈에 상품페이지 나오는 코드---------------------------------
         String cpage = null;
         int currentPage = 0;
         if(request.getParameter("cpage")==null) {
            currentPage= 1;
         }else {
            cpage = request.getParameter("cpage");
            currentPage = Integer.parseInt(cpage);
         }
         List<GoodsDTO> list = gsservice.listByCpage(currentPage);   
         String navi = gsservice.getNavi(currentPage);

         String img = gsservice.getImg(title);


         model.addAttribute("img",img);
      }
      	session.removeAttribute("title");    //거래 완료 했으니 session 삭제
	//checkTrade    	
	    BuyTradeDTO btdto = new BuyTradeDTO();
	   
	    btdto.setGoodWriter(buyerId);
	    int BuycheckTrade = btService.checkTrade(btdto);
	    int checkTrade = service.checkTrade(buyerId);
	    checkTrade =BuycheckTrade + checkTrade;
	    model.addAttribute("checkTrade",checkTrade);
	 //
	//req확인
		String req = "";
		String buyer_req="";
	    if(!btService.selectBuyerList(buyerId).isEmpty()) {
	    	 req = "Y";	//buyer writer GoodSeq				
	    }else {
	    	req = "N";
	    }
	    if(!service.selectBuyerList(buyerId).isEmpty()) {
	    	buyer_req="Y"; 
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
	 		List<GoodsDTO> list = gsservice.listByCpage(currentPage);   
	 		String navi = gsservice.getNavi(currentPage);
	      
	 		model.addAttribute("list", list);
	 		model.addAttribute("navi", navi);     
      
      return "home";
   }

   @RequestMapping("buyer_cfming.pg")
   public String toBuyerConfirming(HttpSession session,HttpServletRequest request ,Model model) {
      String buyerId=(String)session.getAttribute("login");
      String title = (String)session.getAttribute("title");

      int seqi = service.selectSeqFromTilte(title);   //seq 가져오기
      String seq = Integer.toString(seqi);         //밑에 구문에 넣을 스트링형으로 바꾸기


      TradeDTO dto = service.selectTradeWant3(seq);   // seq에 해당하는 trade불러오기
      String sellerId = dto.getSeller();
      String contact = mservice.getListContact(sellerId);
      String email = mservice.getListEmail(sellerId);
      int price = dto.getPrice();
      String img = gsservice.getImg(title);

      if(price>mservice.selectMileage(buyerId)) {//만약 거래신청을 눌렀는데 현 보유액이 가격보다 작으면 충전페이지로 보내버리기
         model.addAttribute("error","x");
         return "insert";
      }
      service.updateRequest(buyerId, sellerId, title);   //거래 요청을 누른거니가 buyer_req = 'Y'로 변화 시키기
      String buyer_req=service.selectRequest(buyerId, sellerId, title);   //'Y'로 변화된 buyer_req 저장
      String seller_cfm= service.selectConfirm(buyerId, sellerId, title);   // 변화는 없지만 저장

//      int passed_mileage = mservice.selectMileage(buyerId);   // 변동전 마일리지 갖고오기
//      mservice.minus(buyerId, passed_mileage, price);   // 구매자 샀으니 감소

      int goodSeq = gsservice.selectSeq(title);   //상품 번호 가져오기

//      EndList_PayDTO dto2 = new EndList_PayDTO();
      
//      dto2.setId(dto.getBuyer());
//      dto2.setMileage(mservice.selectMileage(buyerId));
//      dto2.setGoodName(dto.getTitle());
//      dto2.setValue(dto.getPrice()*-1);
//      dto2.setGoodSeq(gsservice.selectSeq(title));
//      
//      EPservice.insert(dto2);   // 마일리지의 변화가 있었으니 endlist_pay에 인서트
      
//      PurchaseListDTO dto3 = new PurchaseListDTO();
      
//      dto3.setWriter(dto.getBuyer());
//      dto3.setTitle(dto.getTitle());
//      dto3.setPrice(dto.getPrice());
//      dto3.setGoodSeq(gsservice.selectSeq(title));
//        
//      pservice.insert(dto3);   //구매 요청 눌럿으니 구매 리스트에 올라감
      System.out.println("sellet_cfm :" + seller_cfm);
      model.addAttribute("seller",dto.getSeller());   
      model.addAttribute("contact",contact);
      model.addAttribute("email",email);
      model.addAttribute("price",dto.getPrice());
      model.addAttribute("buyer_req",buyer_req);
      model.addAttribute("seller_cfm",seller_cfm);
      model.addAttribute("img",img);
      
		//checkTrade    	
	    BuyTradeDTO btdto = new BuyTradeDTO();
	    btdto.setGoodWriter(buyerId);
	    int BuycheckTrade = btService.checkTrade(btdto);
	    int checkTrade = service.checkTrade(buyerId);
	    checkTrade =BuycheckTrade + checkTrade;
	    model.addAttribute("checkTrade",checkTrade);
	 //
	//req확인
		String req = "";
		buyer_req="";
	    if(!btService.selectBuyerList(buyerId).isEmpty()) {
	    	 req = "Y";	//buyer writer GoodSeq				
	    }else {
	    	req = "N";
	    }
	    if(!service.selectBuyerList(buyerId).isEmpty()) {
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

	   @RequestMapping("sellerList.pg")
	   public String toList(HttpSession session,HttpServletRequest request ,Model model) {
	      String id = (String)session.getAttribute("login");
	      List<TradeDTO> list = service.selectReqList(id);   //거래요청들어온 서비스 리스트로 뽑아내기
	      model.addAttribute("list",list);
	      List<BuyTradeDTO> list2 = btService.selectReqList(id);
	      model.addAttribute("list2",list2);
	      return "list";
	   }
	   @RequestMapping("buyerlist.pg")
	   public String toReqList(HttpSession session,HttpServletRequest request ,Model model) {
	      String id = (String)session.getAttribute("login");
	      List<TradeDTO> list = service.selectBuyerList(id);    //거래요청들어온 서비스 리스트로 뽑아내기
	      model.addAttribute("list",list);
	      List<BuyTradeDTO> list2 = btService.selectBuyerList(id); 
	      model.addAttribute("list2",list2);
	      return "trade/reqList";
	   }

   @RequestMapping("seller.pg")
   public String toCell(HttpSession session,HttpServletRequest request ,Model model) {
      String seq = (String)request.getParameter("seq");   //넘긴 시퀀스 받기
      TradeDTO dto = service.selectTradeWant3(seq);   //시퀀스에 해당하는 dto뽑기

      String title = dto.getTitle();   
      String img = gsservice.getImg(title);   
      System.out.println("이미지 이름은 " + img);

      session.setAttribute("seq",seq);   // seq 날리기 (타이틀로 날릴까 하다 일단 그냥 썼음)

      String buyer = dto.getBuyer();
      String buyer_req=dto.getBuyer_req();
      String seller_cfm= dto.getSeller_cfm();
      String contact = mservice.getListContact(buyer);
      String email = mservice.getListEmail(buyer);
      int price = dto.getPrice();

      model.addAttribute("price",price);
      model.addAttribute("buyer",buyer);
      model.addAttribute("email",email);
      model.addAttribute("contact",contact);
      model.addAttribute("buyer_req",buyer_req);
      model.addAttribute("seller_cfm",seller_cfm);
      model.addAttribute("img",img);
      
		//checkTrade    	
      	String buyerId = (String)session.getAttribute("login");
	    BuyTradeDTO btdto = new BuyTradeDTO();
	    btdto.setGoodWriter(buyerId);
	    int BuycheckTrade = btService.checkTrade(btdto);
	    int checkTrade = service.checkTrade(buyerId);
	    checkTrade =BuycheckTrade + checkTrade;
	    model.addAttribute("checkTrade",checkTrade);
	 //
	//req확인
		String req = "";
		buyer_req="";
	    if(!btService.selectBuyerList(buyerId).isEmpty()) {
	    	 req = "Y";	//buyer writer GoodSeq				
	    }else {
	    	req = "N";
	    }
	    if(!service.selectBuyerList(buyerId).isEmpty()) {
	    	buyer_req="Y"; 
	    }else {
	    	buyer_req="N";
	    }
		if(req.contentEquals("Y") || buyer_req.contentEquals("Y") ) {
			model.addAttribute("allReq", "Y");
		}else {
			model.addAttribute("allReq","N");
		}     

      return "seller";
   }

   @RequestMapping("seller_cfm.pg")
   public String toCellConfirming(HttpSession session,HttpServletRequest request ,Model model) {
	  System.out.println("판매자가 확정 누름");
      String seq = (String)session.getAttribute("seq");//시퀀스 받고
      TradeDTO dto = service.selectTradeWant3(seq);
      String title = dto.getTitle();
      String buyerId=dto.getBuyer();
      String sellerId = dto.getSeller();
      String goods = dto.getTitle();
      String img = gsservice.getImg(title);
      int price = dto.getPrice();

       service.updateConfirm(seq);   // 확인 눌렀으니 seller_cfm='Y'만들기

//      int passed_mileage = mservice.selectMileage(sellerId);   //확인 눌렀으니 핀매자 변경전 마일리지 불러오기
//      mservice.plus(sellerId, passed_mileage, price);   //마일리지 증가 시켜 주기

//      EndList_PayDTO dto2 = new EndList_PayDTO();
//      
//      dto2.setId(dto.getBuyer());
//      dto2.setMileage(mservice.selectMileage(dto.getSeller()));
//      dto2.setGoodName(dto.getTitle());
//      dto2.setValue(dto.getPrice());
//      dto2.setGoodSeq(gsservice.selectSeq(title));
//      
//      EPservice.insert(dto2);   // 마일리지의 변화가 있었으니 endlist_pay에 인서트
      
    //거래가 확정되었으니 구매내역 추가
    PurchaseListDTO dto3 = new PurchaseListDTO();
      
    dto3.setWriter(dto.getBuyer());
    dto3.setTitle(dto.getTitle());    
    dto3.setPrice(dto.getPrice());
    dto3.setGoodSeq(gsservice.selectSeq(title));
      
    pservice.insert(dto3);   //구매 요청 눌럿으니 구매 리스트에 올라감
      dto = service.selectTradeWant3(seq); //update 했기 때문에 trade정보를 다시 가져와야함
      String seller_cfm= dto.getSeller_cfm();
      String buyer_req=dto.getBuyer_req();

      String contact = mservice.getListContact(buyerId);
      String email = mservice.getListEmail(buyerId);

      model.addAttribute("img",img);
      model.addAttribute("price",price);
      model.addAttribute("buyer",buyerId);
      model.addAttribute("goods",goods);
      model.addAttribute("email",email);
      model.addAttribute("contact",contact);
      model.addAttribute("buyer_req",buyer_req);
      model.addAttribute("seller_cfm",seller_cfm);
      
		//checkTrade    	
	    BuyTradeDTO btdto = new BuyTradeDTO();
	    btdto.setGoodWriter(buyerId);
	    int BuycheckTrade = btService.checkTrade(btdto);
	    int checkTrade = service.checkTrade(buyerId);
	    checkTrade =BuycheckTrade + checkTrade;
	    model.addAttribute("checkTrade",checkTrade);
	 //
	//req확인
		String req = "";
		buyer_req="";
	    if(!btService.selectBuyerList(buyerId).isEmpty()) {
	    	 req = "Y";	//buyer writer GoodSeq				
	    }else {
	    	req = "N";
	    }
	    if(!service.selectBuyerList(buyerId).isEmpty()) {
	    	buyer_req="Y"; 
	    }else {
	    	buyer_req="N";
	    }
		if(req.contentEquals("Y") || buyer_req.contentEquals("Y") ) {
			model.addAttribute("allReq", "Y");
		}else {
			model.addAttribute("allReq","N");
		}  

      return "seller";
   }

   @RequestMapping("confirm_cancel")
   public String cancel(HttpSession session,HttpServletRequest request ,Model model) throws Exception {
	   String title = request.getParameter("title");
	   String buyerId = (String)request.getParameter("buyer");
	   int goodSeq = service.selectSeqFromTilte(title); //상품번호
	   GoodsDTO gdto = gsservice.select(goodSeq);
	   String seqs = (String)request.getParameter("seq");
	   int seq = Integer.parseInt(seqs); //trade번호
	   TradeDTO dto = service.selectTradeWant3(seqs);
	   
	   String id = (String)session.getAttribute("login");
	      if(dto.getSeller_cfm().contentEquals("Y")) {
	   	   CancelListDTO dto3 = new CancelListDTO();
		      dto3.setWriter(dto.getSeller());
		      dto3.setTitle(dto.getTitle());
		      dto3.setPrice(dto.getPrice());
		      dto3.setGoodSeq(goodSeq);
	    	  cservice.insert(dto3);   // 취소 리스트에 인서트 하기
	    	  //구매내역 삭제
		      PurchaseListDTO pldto =new PurchaseListDTO();
		      pldto.setGoodSeq(dto.getGoodSeq());
		      pservice.deletePurchaseList(pldto);   //현재 구매중인 상품 리스트에서 삭제해주기  
	      }
		
		//trade 삭제
	    System.out.println("Trade번호 :" + seq);
	    service.deleteTrade(seq);
	    
		//checkTrade    	
	    BuyTradeDTO btdto = new BuyTradeDTO();
	    btdto.setGoodWriter(buyerId);
	    int BuycheckTrade = btService.checkTrade(btdto);
	    int checkTrade = service.checkTrade(buyerId);
	    checkTrade =BuycheckTrade + checkTrade;
	    model.addAttribute("checkTrade",checkTrade);
	 //
	//req확인
		String req = "";
		String buyer_req="";
	    if(!btService.selectBuyerList(buyerId).isEmpty()) {
	    	 req = "Y";	//buyer writer GoodSeq				
	    }else {
	    	req = "N";
	    }
	    if(!service.selectBuyerList(buyerId).isEmpty()) {
	    	buyer_req="Y"; 
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
	 		List<GoodsDTO> list = gsservice.listByCpage(currentPage);   
	 		String navi = gsservice.getNavi(currentPage);
	      
	 		model.addAttribute("list", list);
	 		model.addAttribute("navi", navi);
	 		return "home";
			}
	@ExceptionHandler
	public String exceptionhandler(Exception e){
		return "error";
	}

}