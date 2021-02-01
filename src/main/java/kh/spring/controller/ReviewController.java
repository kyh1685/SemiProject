package kh.spring.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.JsonArray;

import kh.spring.dto.ReviewDTO;
import kh.spring.service.ReviewService;


@Controller
@RequestMapping("/review")
public class ReviewController {

   
   @Autowired
   ReviewService service;
   @Autowired
   private HttpSession session;
   @RequestMapping("insert.review")
   @ResponseBody
   public String insert(HttpServletRequest request) {
      int gSeq = Integer.parseInt(request.getParameter("gSeq"));
      String revWriter = (String)session.getAttribute("login");
      String rContents = request.getParameter("rContents");
      System.out.println("insert.review요청 확인");
      System.out.println("현재 상품 페이지 : "+gSeq);
      System.out.println("내용확인 : " +rContents);
      int result = service.insert(gSeq,revWriter,rContents);
      int page = 1;
      if(result > 0) {
         Gson gson=new Gson();
         List <ReviewDTO> list = service.selectAll(gSeq,page);
         return gson.toJson(list);
      }
      return "false" ;
   }
   
   @RequestMapping(value="printAll.review",produces="application/text; charset=UTF-8")
   @ResponseBody
   public String printAll(HttpServletRequest request) throws Exception {
      int gSeq=Integer.parseInt(request.getParameter("goodSeq"));
      System.out.println("select 요청 확인");
      int page =1;
      Gson gson=new Gson();
      List <ReviewDTO> list = service.selectAll(gSeq,page);
      String navi = service.navi(page, gSeq);
      
      return gson.toJson(list);
   }
   
   
   @RequestMapping("delete.review")
   @ResponseBody
   public String delete(HttpServletRequest request) {
      System.out.println("delete.review 요청 확인");
      int rSeq=Integer.parseInt(request.getParameter("revSeq"));

      System.out.println("goodSeq : "+rSeq);
      String result = Integer.toString(service.delete(rSeq));
            
      return result;
   }
   
   @RequestMapping("update.review")
   @ResponseBody
   public String update(HttpServletRequest request) {
      int gSeq = Integer.parseInt(request.getParameter("gSeq"));
      System.out.println("update.review 요청확인");
      String rSeq =  request.getParameter("revSeq");
      String rCon =  request.getParameter("revContents");
      System.out.println(rSeq +":"+rCon);
      int result = service.update(rSeq,rCon);
      int page =1;
      if(result > 0) {
         Gson gson=new Gson();
         List <ReviewDTO> list = service.selectAll(gSeq,page);
         return gson.toJson(list);
      }
      return "false";
   }
   
   @RequestMapping("getNavi.review")
   @ResponseBody
   public String getNavi(HttpServletRequest request) throws Exception {
      int gSeq = Integer.parseInt(request.getParameter("gSeq"));
      int page =1;
      String navi = service.navi(page, gSeq);
      int count = service.getDataCount(gSeq);

      if(count == 1){
         return "<a href='view.good?page=1"+"&goodSeq="+gSeq+"'>"+1+" "+"</a>";
      }else if(count == 0){
         return null;
      }else {
         return navi;
      }
   }
	@ExceptionHandler
	public String exceptionhandler(Exception e){
		return "error";
	}

}