package kh.spring.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.spring.dao.ReviewDAO;
import kh.spring.dto.ReviewDTO;
import kh.spring.statics.MypageConfigurator;


@Service
public class ReviewService {

   @Autowired
   ReviewDAO rdao;
   
   public int insert(int gSeq,String revWriter,String rContents) {
      return rdao.insert(gSeq,revWriter,rContents);
   }
   
   public List<ReviewDTO> selectAll(int gSeq,int page) {
      
      return rdao.selectAll(gSeq,page);
   }
   
   public int delete(int rSeq) {
      return rdao.delete(rSeq);
   }
   
   public int update(String rSeq, String rContents) {
      return rdao.update(rSeq,rContents);
   }
   
   public int getDataCount(int gSeq) throws Exception{
      return rdao.getDataCount(gSeq);
   }
   public String navi(int currentPage,int gSeq) throws Exception {
      int recordTotalCount = getDataCount(gSeq); 
      int pageTotalCount = 0;
      if(recordTotalCount % MypageConfigurator.recordCountPerPage > 0) {
         pageTotalCount = recordTotalCount / MypageConfigurator.recordCountPerPage+ 1;
      }else {
         pageTotalCount = recordTotalCount/ MypageConfigurator.recordCountPerPage;
      }
      if(currentPage < 1) {
         currentPage = 1;
      }else if (currentPage > pageTotalCount) {
         currentPage = pageTotalCount;
      }
      int startNavi = (currentPage-1) / MypageConfigurator.naviCountPerPage * MypageConfigurator.naviCountPerPage  +1;
      int endNavi = startNavi + MypageConfigurator.naviCountPerPage  - 1;

      if(endNavi > pageTotalCount) {
         endNavi = pageTotalCount;
      }
      boolean needPrev = true;
      boolean needNext = true;

      if(startNavi == 1) {needPrev = false;}
      if(endNavi == pageTotalCount) {needNext = false;}
      StringBuilder sb = new StringBuilder();

      if(needPrev) {
         sb.append("<a href='view.good?page="+(startNavi-1)+"&goodSeq="+gSeq+"'> < </a>");
      }
      for(int i = startNavi; i<=endNavi; i++) {
         sb.append("<a href='view.good?page="+i+"&goodSeq="+gSeq+"'>"+i+" "+"</a>");
      }
      if(needNext) {
         sb.append("<a href='view.good?page="+(endNavi+1)+"&goodSeq="+gSeq+"'> > </a>");
      }
      return sb.toString();
   }
}