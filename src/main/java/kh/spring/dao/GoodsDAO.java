package kh.spring.dao;

import java.util.HashMap;
import kh.spring.statics.MypageConfigurator;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.spring.dto.BasketDTO;
import kh.spring.dto.GoodsDTO;
import kh.spring.statics.ProductConfigurator;

@Repository
public class GoodsDAO {
   @Autowired
   private SqlSession session;
   
   public int selectSeq(String goodName) {
	   return session.selectOne("Goods.selectSeq",goodName);
   }
   public int checkGoodName(String goodname) {
	      return session.selectOne("Goods.checkGoodName",goodname);
	   }
   // 페이지별 상품 게시글
   public List<GoodsDTO> listByCpage(int cpage) throws Exception{
      int startRowNum = (cpage-1) * ProductConfigurator.recordCountPerPage + 1;
      int endRowNum = startRowNum + ProductConfigurator.recordCountPerPage - 1;

      Map<String, Integer> param = new HashMap<>();
      param.put("startRowNum", startRowNum);
      param.put("endRowNum", endRowNum);
      return session.selectList("Goods.listByCpage",param);
   }
   
   // 상품 게시글 총합
   public int getDataCount() throws Exception{
      return session.selectOne("Goods.getDataCount");
   }
   
   // 상품 검색
   public List<GoodsDTO> searchTitle(String goodName,String cateCode) throws Exception{
      Map<String, String> param = new HashMap<>();
      param.put("goodName", goodName);
      param.put("cateCode", cateCode);
      return session.selectList("Goods.searchTitle",param);
   }
   
   // 상품 클릭
   public List<GoodsDTO> category(String cateCode) throws Exception{
      return session.selectList("Goods.category",cateCode);
   }
   
   
   //-------------------------------------------------------------------------------
   
   
   public int insert(GoodsDTO dto) {
      System.out.println("insert 확인");
      System.out.println(dto.getGoodImg()+"이미지");
      return session.insert("Goods.insert", dto);
   }
   
   public List<GoodsDTO> selectAll() {
      return session.selectList("Goods.selectAll");
   }
   
   public GoodsDTO select(int goodSeq) {
      System.out.println("select확인");
      System.out.println(goodSeq);
      return session.selectOne("Goods.select", goodSeq);
   }
   
   public int viewCount(int goodSeq) {
      return session.update("Goods.viewCount", goodSeq);
   }
   
   public int update(GoodsDTO dto) {
      System.out.println("Goood update확인");
      System.out.println("수정된 내용 :"+dto.getGoodDes() + "게시물 번호 : "+dto.getGoodSeq());
      return session.update("Goods.update", dto);
   }
   
   public int delete(int goodSeq) {
      System.out.println("DAO 삭제  요청");
      return session.delete("Goods.delete", goodSeq);
   }
   
      public int updateBasket(GoodsDTO dto) {
            return session.update("Goods.updateBasket",dto);
         }
      public int insertBasket(BasketDTO dto) {
   	   return session.insert("Goods.insertBasket",dto);
   			   
      }
      public int basketCount(int goodSeq,String id) {
   	   Map<String,Object> param = new HashMap<>();
   	   param.put("goodSeq", goodSeq);
   	   param.put("id", id);
   	   return session.selectOne("Mypage.basketCount",param);
      }
      //----------------------------------------------------
      public int deleteBasket(BasketDTO dto) {
         return session.delete("Mypage.deleteBasket",dto);
      }
      public int deleteViewBasket(BasketDTO dto) {
    	  return session.delete("Mypage.deleteViewBasket",dto);
      }
      public List<BasketDTO> selectBasket(int page, BasketDTO dto) {
         int startRowNum = (page-1)*MypageConfigurator.recordCountPerPage +1;
         int endRowNum = startRowNum + MypageConfigurator.recordCountPerPage -1;
         Map<String,Object> param = new HashMap<>();
         param.put("startRowNum", startRowNum);
         param.put("endRowNum", endRowNum);
         param.put("dto",dto);
         return session.selectList("Mypage.selectBasket",param);
      }
      public int totalCountBasket(BasketDTO dto) {
         return session.selectOne("totalCountBasket",dto);
      }
      public List<BasketDTO> searchBasket(int page, String startDate, String endDate,BasketDTO dto){
         int startRowNum = (page-1)*MypageConfigurator.recordCountPerPage +1;
         int endRowNum = startRowNum + MypageConfigurator.recordCountPerPage -1;
         Map<String,Object> param = new HashMap<>();
         param.put("startRowNum", startRowNum);
         param.put("endRowNum", endRowNum);
         param.put("startDate",startDate);
         param.put("endDate",endDate);
         param.put("dto", dto);
         return session.selectList("Mypage.searchBasket",param);
      }
      public int searchTotalCountBasket(String startDate, String endDate,BasketDTO dto) throws Exception{
         Map<String,Object> param = new HashMap<>();
         param.put("startDate",startDate);
         param.put("endDate",endDate);
         param.put("dto", dto);
         return session.selectOne("Mypage.searchTotalCountBasket",param);
      }
   
   public List<GoodsDTO> selectMyBuy(int page,GoodsDTO dto) {
      int startRowNum = (page-1)*MypageConfigurator.recordCountPerPage +1;
      int endRowNum = startRowNum + MypageConfigurator.recordCountPerPage -1;
      Map<String,Object> param = new HashMap<>();
      param.put("startRowNum", startRowNum);
      param.put("endRowNum", endRowNum);
      param.put("dto",dto);
      return session.selectList("Mypage.selectMyBuy",param);
   }
   public int totalCountMyBuy(GoodsDTO dto) {
      return session.selectOne("totalCountMyBuy",dto);
   }
   public List<GoodsDTO> searchMyBuy(int page, String startDate, String endDate,GoodsDTO dto){
      int startRowNum = (page-1)*MypageConfigurator.recordCountPerPage +1;
      int endRowNum = startRowNum + MypageConfigurator.recordCountPerPage -1;
      Map<String,Object> param = new HashMap<>();
      param.put("startRowNum", startRowNum);
      param.put("endRowNum", endRowNum);
      param.put("startDate",startDate);
      param.put("endDate",endDate);
      param.put("dto", dto);
      return session.selectList("Mypage.searchMyBuy",param);
   }
   public int searchTotalCountMyBuy(String startDate, String endDate,GoodsDTO dto) throws Exception{
      Map<String,Object> param = new HashMap<>();
      param.put("startDate",startDate);
      param.put("endDate",endDate);
      param.put("dto", dto);
      return session.selectOne("Mypage.searchTotalCountMyBuy",param);
   }
   
   public List<GoodsDTO> selectMySell(int page,GoodsDTO dto) {
      int startRowNum = (page-1)*MypageConfigurator.recordCountPerPage +1;
      int endRowNum = startRowNum + MypageConfigurator.recordCountPerPage -1;
      Map<String,Object> param = new HashMap<>();
      param.put("startRowNum", startRowNum);
      param.put("endRowNum", endRowNum);
      param.put("dto",dto);
      return session.selectList("Mypage.selectMySell",param);
   }
   public int totalCountMySell(GoodsDTO dto) {
      return session.selectOne("totalCountMySell",dto);
   }
   public List<GoodsDTO> searchMySell(int page, String startDate, String endDate,GoodsDTO dto){
      int startRowNum = (page-1)*MypageConfigurator.recordCountPerPage +1;
      int endRowNum = startRowNum + MypageConfigurator.recordCountPerPage -1;
      Map<String,Object> param = new HashMap<>();
      param.put("startRowNum", startRowNum);
      param.put("endRowNum", endRowNum);
      param.put("startDate",startDate);
      param.put("endDate",endDate);
      param.put("dto", dto);
      return session.selectList("Mypage.searchMySell",param);
   }
   public int searchTotalCountMySell(String startDate, String endDate,GoodsDTO dto) throws Exception{
      Map<String,Object> param = new HashMap<>();
      param.put("startDate",startDate);
      param.put("endDate",endDate);
      param.put("dto", dto);
      return session.selectOne("Mypage.searchTotalCountMySell",param);
   }
   
	public String getImg(String title) {
		return session.selectOne("Goods.getImg",title);
	}
}