package kh.spring.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartRequest;

import kh.spring.dto.BasketDTO;
import kh.spring.dto.BuyTradeDTO;
import kh.spring.dto.EndList_PayDTO;
import kh.spring.dto.GoodsDTO;
import kh.spring.dto.MembersDTO;
import kh.spring.dto.ReviewDTO;
import kh.spring.dto.TradeDTO;
import kh.spring.service.BuyTradeService;
import kh.spring.service.EndList_PayService;
import kh.spring.service.GoodsService;
import kh.spring.service.MembersService;
import kh.spring.service.ReviewService;
import kh.spring.service.SalesListService;
import kh.spring.service.TradeService;

@Controller
@RequestMapping("/good")
public class GoodsController {

   @Autowired
   private MembersService mService;
   @Autowired
   private GoodsService service;
   @Autowired
   private ReviewService rService;
   @Autowired
   private TradeService tservice;
   @Autowired
   private SalesListService sService;
   @Autowired
   private EndList_PayService epService;
   @Autowired
   private HttpSession session;
   @Autowired
   private BuyTradeService btService;
   
// 메인페이지 검색
	@RequestMapping("search.pro")
	public String search(HttpServletRequest request,Model model) throws Exception{
		String id = (String) session.getAttribute("login");
		String goodName = request.getParameter("goodName");
		String cateCode = request.getParameter("cateCode");
		List<GoodsDTO> list = service.searchTitle(goodName,cateCode);

		model.addAttribute("list", list);
		return "home";
	}

	// 카테고리 클릭
	@RequestMapping("category.pro")
	public String category(String cateCode,Model model) throws Exception{
		List<GoodsDTO> list = service.category(cateCode);
		model.addAttribute("list", list);
		return "home";
	}
   
   @RequestMapping("write.good")
   public String write(Model model) {
      String id = (String)session.getAttribute("login");
      model.addAttribute("id",id);
    //checkTrade    	
	    BuyTradeDTO btdto = new BuyTradeDTO();
	    btdto.setGoodWriter(id);
	    int BuycheckTrade = btService.checkTrade(btdto);
	    int checkTrade = tservice.checkTrade(id);
	    checkTrade =BuycheckTrade + checkTrade;
	    model.addAttribute("checkTrade",checkTrade);
	 //
	//req확인
		String req = "";
		String buyer_req="";
	    if(!btService.selectBuyerList(id).isEmpty()) {
	    	 req = "Y";	//buyer writer GoodSeq				
	    }else {
	    	req = "N";
	    }
	    if(!tservice.selectBuyerList(id).isEmpty()) {
	    	buyer_req="Y"; 
	    }else {
	    	buyer_req="N";
	    }
		if(req.contentEquals("Y") || buyer_req.contentEquals("Y") ) {
			model.addAttribute("allReq", "Y");
		}else {
			model.addAttribute("allReq","N");
		}     

      return "good/insertGood";
   }

   @RequestMapping(value="insert.good", method=RequestMethod.POST)
   public String insert(GoodsDTO dto,MultipartHttpServletRequest request, MultipartFile file,Model model)  {
      System.out.println("insert 확인 ");
      System.out.println(dto.getGoodName());
      String id = (String)session.getAttribute("login");
      
      model.addAttribute("id",id);
      int myMileage = mService.checkMileage(id);
      if(service.checkGoodName(dto.getGoodName())>0) {
         model.addAttribute("error","x");
         return "/good/insertGood";
      }	
      //추가한 사항
      if(dto.getCateCode() == 1) {
    	  if(dto.getGoodPrice() > myMileage ) {
    	    	 model.addAttribute("error","number");
    	    	 return "/good/insertGood";
    	      }
    	String realPath = session.getServletContext().getRealPath("resources/files");
   	       File filesPath = new File(realPath); 
   	       System.out.println(realPath);
   	         
   	       String fileName=file.getOriginalFilename();//원래 파일이름
   	       String uid = UUID.randomUUID().toString().replaceAll("-", ""); //해쉬암호화 String화하기
   	       String newFileName=uid+"_"+fileName; // 새로저장할 이름
   	       dto.setGoodImg(newFileName);
   	         int result = service.insert(dto);
   	         
   	          if(result > 0) {
   	             File image = new File(filesPath.getAbsolutePath()+"/"+newFileName);
   	             try {
   	               FileCopyUtils.copy(file.getBytes(), image);
   	            } catch (IOException e) {
   	               e.printStackTrace();
   	            }
   	          }	  
    		  MembersDTO mdto = new MembersDTO();
    		  int mileage = myMileage - dto.getGoodPrice();
    		  mdto.setMileage(mileage);
    		  mdto.setId(id);
    		  mService.updateMileage(mdto);
    		  EndList_PayDTO epdto = new EndList_PayDTO();
    		  epdto.setId(id);
    		  epdto.setGoodName(dto.getGoodName());
    		  epdto.setMileage(mileage);
    		  epdto.setValue(-dto.getGoodPrice());
    		  int goodSeq = service.selectSeq(dto.getGoodName());
    		  epdto.setGoodSeq(goodSeq);
    		  epService.insert(epdto);
      }else {
          String realPath = session.getServletContext().getRealPath("resources/files");
          File filesPath = new File(realPath); 
          System.out.println(realPath);
                    
          String fileName=file.getOriginalFilename();//원래 파일이름
          String uid = UUID.randomUUID().toString().replaceAll("-", ""); //해쉬암호화 String화하기
          String newFileName=uid+"_"+fileName; // 새로저장할 이름
          dto.setGoodImg(newFileName);

            int result = service.insert(dto);
            
             if(result > 0) {
                File image = new File(filesPath.getAbsolutePath()+"/"+newFileName);
                try {
                  FileCopyUtils.copy(file.getBytes(), image);
               } catch (IOException e) {
                  e.printStackTrace();
               }
             }
        //cateCode 상품번호 부족

        int goodSeq = service.selectSeq(dto.getGoodName());
		dto.setGoodSeq(goodSeq);
		dto.setCateCode(2);
        sService.insert(dto);
      }
      return "redirect:/";
   }

   @RequestMapping("view.good")
   public String view(HttpServletRequest request, Model model) throws Exception{
      String id = (String)session.getAttribute("login");
      model.addAttribute("id",id);
      int goodSeq = Integer.parseInt(request.getParameter("goodSeq"));   
      System.out.println("view.good 요청");               
      GoodsDTO dto = service.select(goodSeq);
      if(id == null) {
          return "/member/login";
       } 
      
     //checkTrade
      BuyTradeDTO btdto = new BuyTradeDTO();
      btdto.setGoodWriter(id);
      btdto.setGoodSeq(goodSeq);
      int BuycheckTrade = btService.checkTrade(btdto);
      int checkTrade = tservice.checkTrade(id);
      checkTrade =BuycheckTrade + checkTrade;
      model.addAttribute("checkTrade",checkTrade);
      String req = "";
		String buyer_req="";
	    if(!btService.selectBuyerList(id).isEmpty()) {
	    	 req = "Y";	//buyer writer GoodSeq				
	    }else {
	    	req = "N";
	    }
	    if(!tservice.selectBuyerList(id).isEmpty()) {
	    	buyer_req="Y"; 
	    }else {
	    	buyer_req="N";
	    }
		if(req.contentEquals("Y") || buyer_req.contentEquals("Y") ) {
				model.addAttribute("req", "Y");
			}else {
				model.addAttribute("req","N");
			}
      int gViewCount = service.viewCount(goodSeq);
      int page = Integer.parseInt(request.getParameter("page"));
      model.addAttribute("dto", dto);
      List<ReviewDTO> revList=service.selectAll(goodSeq,page);
      model.addAttribute("list",revList);
      String navi = rService.navi(page, goodSeq);
      model.addAttribute("navi",navi);     
      int count = service.basketCount(goodSeq,id);
      model.addAttribute("count",count);;
      //req확인
      
      return "good/view";
   }   

   
   @RequestMapping("updateGood.good")
   public String updateGood(@RequestParam("n")int goodSeq, Model model) {
      String id = (String)session.getAttribute("login");
      model.addAttribute("id",id);
      int checkTrade = tservice.checkTrade(id);
      model.addAttribute("checkTrade",checkTrade);
      GoodsDTO dto = service.select(goodSeq);
      model.addAttribute("dto",dto);
      return "good/updateGood";
   }

   @RequestMapping("update.good")
   public String update(GoodsDTO dto,Model model) {
	  String id = (String)session.getAttribute("login");
	  model.addAttribute("id",id);
      System.out.println("업데이트확인");
      int goodSeq = dto.getGoodSeq();
      GoodsDTO dto2 = service.select(goodSeq);
      model.addAttribute("dto",dto2);
      if(service.checkGoodName(dto.getGoodName())>1) { //기존 변경되기전에 1개 있기 때문에 
          model.addAttribute("error","x");
          return "/good/updateGood";
       }	
      int myMileage = mService.selectMileage(id);
      System.out.println("삽니다 :" +dto.getCateCode());
      if(dto.getCateCode() == 1) {
    	  if(dto.getGoodPrice() > myMileage ) {
 	    	 model.addAttribute("error","number");
 	    	 return "/good/updateGood";
    	  }else {  		 
    		  GoodsDTO gdto = service.select(goodSeq);
    		  System.out.println("변경 전 :"+gdto.getGoodPrice());
    		  System.out.println("변경 후 :"+dto.getGoodPrice());
    		  MembersDTO mdto = new MembersDTO();
    		  int mileage = myMileage - dto.getGoodPrice()+gdto.getGoodPrice();
    		  mdto.setMileage(mileage);
    		  mdto.setId(id);
		  	mService.updateMileage(mdto);
		  	EndList_PayDTO epdto = new EndList_PayDTO();
		  	epdto.setId(id);
		  	epdto.setGoodName(dto.getGoodName());
		  	epdto.setMileage(mileage);
		  	epdto.setValue(gdto.getGoodPrice() - dto.getGoodPrice());	
		  	epdto.setGoodSeq(goodSeq);
		  	if(gdto.getGoodPrice() - dto.getGoodPrice() != 0) {
		  		epService.insert(epdto);
		  	}
	  	}
      }
      int result = service.update(dto);
      if (result>0) {
         System.out.println("수정 성공");
      } else {
         System.out.println("오류확인");
      }
      return "redirect:/";
   }

   @RequestMapping("deleteGood.good")
   public String delete(@RequestParam("n")int goodSeq,GoodsDTO dto,Model model) throws Exception {
      System.out.println("삭제 요청");
      String id = (String)session.getAttribute("login");
      System.out.println(dto.getGoodImg());
      model.addAttribute("id",id);
      dto = service.select(goodSeq);
      model.addAttribute("dto",dto);
      //거래정보 가져오기
      String goodName = dto.getGoodName();
      //마일리지 담보 복구
      int myMileage = mService.selectMileage(id);
      if(dto.getCateCode() == 1) {
		  MembersDTO mdto = new MembersDTO();
		  int mileage = myMileage +dto.getGoodPrice();
		  mdto.setMileage(mileage);
		  mdto.setId(id);
    	  mService.updateMileage(mdto);
		  	EndList_PayDTO epdto = new EndList_PayDTO();
		  	epdto.setId(id);
		  	epdto.setGoodName(dto.getGoodName());
		  	epdto.setMileage(mileage);
		  	epdto.setValue(dto.getGoodPrice());	
		  	epdto.setGoodSeq(goodSeq);
		  	epService.insert(epdto);
      }else {
    	  //판매내역 삭제
    	  sService.delete(goodSeq);
      }
      //checkTrade
      BuyTradeDTO btdto = new BuyTradeDTO();
      btdto.setGoodWriter(id);
      btdto.setGoodName(goodName);
      int BuycheckTrade = btService.checkTrade(btdto);
      int checkTrade = tservice.checkTrade(id);
      checkTrade =BuycheckTrade + checkTrade;
      model.addAttribute("checkTrade",checkTrade);
      //req
      String req = "";
		String buyer_req="";
	    if(!btService.selectBuyerList(id).isEmpty()) {
	    	 req = "Y";	//buyer writer GoodSeq				
	    }else {
	    	req = "N";
	    }
	    if(!tservice.selectBuyerList(id).isEmpty()) {
	    	buyer_req="Y"; 
	    }else {
	    	buyer_req="N";
	    }
		if(req.contentEquals("Y") || buyer_req.contentEquals("Y") ) {
				model.addAttribute("req", "Y");
			}else {
				model.addAttribute("req","N");
			}
		//댓글 가져오기
	  int page = 1;
	  model.addAttribute("dto", dto);
	  List<ReviewDTO> revList=service.selectAll(goodSeq,page);
	  model.addAttribute("list",revList);
	  String navi = rService.navi(page, goodSeq);
	  model.addAttribute("navi",navi);
	    //찜 가져오기
	  int count = service.basketCount(goodSeq,id);
	  model.addAttribute("count",count);;
      int tReq = tservice.checkReq(goodName);
      int btreq = btService.checkReq(btdto);
      System.out.println("tReq :" + tReq + " btreq :" + btreq);
      int allReq = tReq + btreq;
      if( allReq > 0|| checkTrade > 0) {
    	 model.addAttribute("error","error");
         return "/good/view";
      }else {
          service.delete(goodSeq);
          sService.delete(goodSeq);
          return "redirect:/";

      }
   }
   
   @RequestMapping("updateBasket.good")
   @ResponseBody
   public String updateBasket(HttpServletRequest request) {
      GoodsDTO dto = new GoodsDTO();
      int gSeq = Integer.parseInt(request.getParameter("gSeq"));
      String goodLike = request.getParameter("goodLike");
      System.out.println("goodsUpdate");
      String title = request.getParameter("title");
      String id = (String)session.getAttribute("login");
      int price = Integer.parseInt(request.getParameter("price"));
      BasketDTO bdto = new BasketDTO();
      
      bdto.setTitle(title);
      bdto.setPrice(price);
      bdto.setId(id);
      bdto.setLocation(gSeq);
      if(goodLike.contentEquals("N")) {
     	service.insertBasket(bdto);
         dto.setGoodLike("Y");
      }else {
        dto.setGoodLike("N");
        service.deleteViewBasket(bdto);
      }
      dto.setGoodSeq(gSeq);   
      int result= service.updateBasket(dto);
      if(result > 0) {
         GoodsDTO gdto = service.select(gSeq);
         goodLike = gdto.getGoodLike(); 
         return goodLike;
      }
      return "true";
   }
	@ExceptionHandler
	public String exceptionhandler(Exception e){
		e.printStackTrace();
		return "error";
	}




}