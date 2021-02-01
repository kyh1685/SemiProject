package kh.spring.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.spring.dto.ReviewDTO;
import kh.spring.statics.MypageConfigurator;


@Repository
public class ReviewDAO {

   @Autowired
   SqlSession session;
   
   public int insert(int gSeq,String revWriter,String rContents) {
      Map<String,Object> param = new HashMap<>();
      param.put("goodSeq", gSeq);
      param.put("revContents", rContents);
      param.put("revWriter", revWriter);
      System.out.println("insertDAO 확인 : "+gSeq+rContents);
      return session.insert("Review.insert", param);
   }
   
   public List<ReviewDTO> selectAll(int goodSeq,int page) {
      int startRowNum = (page-1)*MypageConfigurator.recordCountPerPage +1;
      int endRowNum = startRowNum + MypageConfigurator.recordCountPerPage -1;
      Map<String,Object> param = new HashMap<>();
      param.put("startRowNum", startRowNum);
      param.put("endRowNum", endRowNum);
      param.put("goodSeq", goodSeq);
      return session.selectList("Review.selectAll", param);
   }
   
   public int delete(int revSeq) {
      return session.delete("Review.delete", revSeq);
   }
   
   public int update(String rSeq, String rContents) {
      Map<String,Object> param = new HashMap<>();
      param.put("revSeq", rSeq);
      param.put("revContents", rContents);
      System.out.println("updateDAO 확인 : "+rSeq+rContents);
      return session.update("Review.update", param);
   }
   
   public List<ReviewDTO> listByCpage(int cpage,int gSeq) throws Exception{
      int startRowNum = (cpage-1) * 10 + 1;
      int endRowNum = startRowNum + 10 - 1;

      Map<String, Integer> param = new HashMap<>();
      param.put("startRowNum", startRowNum);
      param.put("endRowNum", endRowNum);
      param.put("goodSeq", gSeq);
      return session.selectList("Review.listByCpage",param);
   }
   

   public int getDataCount(int gSeq) throws Exception{
      return session.selectOne("Review.getDataCount",gSeq);
   }
   
   
}