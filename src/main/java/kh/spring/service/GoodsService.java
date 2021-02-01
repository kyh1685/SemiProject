package kh.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.spring.dao.GoodsDAO;
import kh.spring.dao.ReviewDAO;
import kh.spring.dto.BasketDTO;
import kh.spring.dto.GoodsDTO;
import kh.spring.dto.ReviewDTO;
import kh.spring.statics.ProductConfigurator;
import kh.spring.statics.MypageConfigurator;
import kh.spring.util.UtilTime;

@Service
public class GoodsService {
   @Autowired
   private GoodsDAO dao;
   
   @Autowired
   ReviewDAO rdao;

   public int checkGoodName(String goodname) {
       return dao.checkGoodName(goodname);
    }
   public int selectSeq(String title) {
	   return dao.selectSeq(title);
   }
   // 페이지별 상품 게시글
   public List<GoodsDTO> listByCpage(int cpage) throws Exception{
      return dao.listByCpage(cpage);
   }
   
   // 상품 게시글 총합
   public int getDataCount() throws Exception{
      return dao.getDataCount();
   }
   
   // 검색
   public List<GoodsDTO> searchTitle(String goodName,String cateCode) throws Exception{
      return dao.searchTitle(goodName,cateCode);
   }
   
   // 카테고리 클릭
   public List<GoodsDTO> category(String cateCode) throws Exception{
      return dao.category(cateCode);
   }
   
   // 네비게이션
   public String getNavi(int currentPage) throws Exception {
      int recordTotalCount = getDataCount();
      int pageTotalCount;
      if(recordTotalCount % ProductConfigurator.recordCountPerPage > 0) {
         pageTotalCount = recordTotalCount / ProductConfigurator.recordCountPerPage + 1;
      }else {
         pageTotalCount = recordTotalCount / ProductConfigurator.recordCountPerPage; 
      }
      // 보안 처리 코드
      if(currentPage < 1) {
         currentPage = 1;
      }else if(currentPage > pageTotalCount) {
         currentPage = pageTotalCount;
      }
      //-----------------------------------------------------------------------------------------
      int startNavi = (currentPage-1) / ProductConfigurator.naviCountPerPage * ProductConfigurator.naviCountPerPage + 1;
      int endNavi = startNavi + ProductConfigurator.naviCountPerPage - 1;

      if(endNavi>pageTotalCount) {
         endNavi = pageTotalCount;
      }

      boolean needPrev = true;
      boolean needNext = true;

      if(startNavi == 1) {
         needPrev = false;
      }
      if(endNavi == pageTotalCount ) {
         needNext = false;
      }

      StringBuilder sb = new StringBuilder(); // 메모리 효율성과 코드의 가독성에 좋음

      if(needPrev) {
         sb.append("<a href= '/?cpage="+(startNavi-1)+"'> < </a>");
      }
      for(int i=startNavi; i <= endNavi; i++) {
         sb.append("<a href= '/?cpage="+i+"'>"+i+" </a>");
      }
      if(needNext) {
         sb.append("<a href='/?cpage="+(endNavi+1)+"'> > </a>");
      }
      
      return sb.toString();
   }
   
   //-----------------------------------------------------------------------------
   
   
   public int insert(GoodsDTO dto) {
      return dao.insert(dto);
   }
   
   public GoodsDTO select(int goodSeq) {
      return dao.select(goodSeq);
   }
   
   public int viewCount(int goodSeq) {
      return dao.viewCount(goodSeq);
   }
   
   public int update(GoodsDTO dto) {
      return dao.update(dto);
   }
   
   public int delete(int goodSeq) {
      return dao.delete(goodSeq);
   }
   
   public List<ReviewDTO> selectAll(int goodSeq,int page) {
      return rdao.selectAll(goodSeq,page);
   }
   public int updateBasket(GoodsDTO dto) {
       return dao.updateBasket(dto);
    }

   public int insertBasket(BasketDTO dto) {
	   return dao.insertBasket(dto);
   }
   //--------------------------------------------------------------
   
   public int deleteViewBasket(BasketDTO dto) {
	   return dao.deleteViewBasket(dto);
   }
   public int basketCount(int goodSeq,String id) {
	   return dao.basketCount(goodSeq,id);
   }
   public int deleteBasket(BasketDTO dto) {
      return dao.deleteBasket(dto);
   }
      public List<BasketDTO> selectBasket(int page,BasketDTO dto){
         return dao.selectBasket(page,dto);
      }
      public int totalCountBasket(BasketDTO dto) throws Exception{
         return dao.totalCountBasket(dto);
      }
      public String naviBasket(int currentPage,BasketDTO dto) throws Exception {
         int recordTotalCount = totalCountBasket(dto); 
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
            sb.append("<a href='/mypage/basket.mp?page="+(startNavi-1)+"'> < </a>");
         }
         for(int i = startNavi; i<=endNavi; i++) {
            sb.append("<a href='/mypage/basket.mp?page="+i+"'>"+i+" "+"</a>");
         }
         if(needNext) {
            sb.append("<a href='/mypage/basket.mp?page="+(endNavi+1)+"'> > </a>");
         }
         return sb.toString();
      }
      public List<BasketDTO> searchBasket(int page, String startDate, String endDate,BasketDTO dto) {
         String arr[] = endDate.split("-");
         int day = Integer.parseInt(arr[2])+1;
         int month = Integer.parseInt(arr[1]);
         int year = Integer.parseInt(arr[0]);
         endDate = UtilTime.Check(year, month, day);
         return dao.searchBasket(page,startDate,endDate,dto);
      }
      public int searchTotalCountBasket(String startDate, String endDate,BasketDTO dto) throws Exception{
         String arr[] = endDate.split("-");
         int day = Integer.parseInt(arr[2])+1;
         int month = Integer.parseInt(arr[1]);
         int year = Integer.parseInt(arr[0]);
         endDate = UtilTime.Check(year, month, day);
         return dao.searchTotalCountBasket(startDate, endDate,dto);
      }
      public String searchNaviBasket(int currentPage,String startDate,String endDate,BasketDTO dto) throws Exception {
         String arr[] = endDate.split("-");
         int day = Integer.parseInt(arr[2]);
         int month = Integer.parseInt(arr[1]);
         int year = Integer.parseInt(arr[0]);
         endDate = UtilTime.Check(year, month, day);
         int recordTotalCount = searchTotalCountBasket(startDate, endDate,dto); 
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
            sb.append("<a href='/mypage/searchBasekt.mp?page="+(startNavi-1)+"&startDate="+startDate+"&endDate="+endDate+"'> < </a>");
         }
         for(int i = startNavi; i<=endNavi; i++) {
            sb.append("<a href='/mypage/searchBasket.mp?page="+i+"&startDate="+startDate+"&endDate="+endDate+"'>"+i+" "+"</a>");
         }
         if(needNext) {
            sb.append("<a href='/mypage/searchBasket.mp?page="+(endNavi+1)+"&startDate="+startDate+"&endDate="+endDate+"'> > </a>");
         }
         return sb.toString();
      }
      
      public List<GoodsDTO> selectMyBuy(int page,GoodsDTO dto){
         return dao.selectMyBuy(page,dto);
      }
      public int totalCountMyBuy(GoodsDTO dto) throws Exception{
         return dao.totalCountMyBuy(dto);
      }
      public String naviMyBuy(int currentPage,GoodsDTO dto) throws Exception {
         int recordTotalCount = totalCountMyBuy(dto); 
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
            sb.append("<a href='/mypage/myBuy.mp?page="+(startNavi-1)+"'> < </a>");
         }
         for(int i = startNavi; i<=endNavi; i++) {
            sb.append("<a href='/mypage/myBuy.mp?page="+i+"'>"+i+" "+"</a>");
         }
         if(needNext) {
            sb.append("<a href='/mypage/myBuy.mp?page="+(endNavi+1)+"'> > </a>");
         }
         return sb.toString();
      }
      public List<GoodsDTO> searchMyBuy(int page, String startDate, String endDate,GoodsDTO dto) {
         String arr[] = endDate.split("-");
         int day = Integer.parseInt(arr[2])+1;
         int month = Integer.parseInt(arr[1]);
         int year = Integer.parseInt(arr[0]);
         endDate = UtilTime.Check(year, month, day);
         return dao.searchMyBuy(page,startDate,endDate,dto);
      }
      public int searchTotalCountMyBuy(String startDate, String endDate,GoodsDTO dto) throws Exception{
         String arr[] = endDate.split("-");
         int day = Integer.parseInt(arr[2])+1;
         int month = Integer.parseInt(arr[1]);
         int year = Integer.parseInt(arr[0]);
         endDate = UtilTime.Check(year, month, day);
         return dao.searchTotalCountMyBuy(startDate, endDate,dto);
      }
      public String searchNaviMyBuy(int currentPage,String startDate,String endDate,GoodsDTO dto) throws Exception {
         String arr[] = endDate.split("-");
         int day = Integer.parseInt(arr[2]);
         int month = Integer.parseInt(arr[1]);
         int year = Integer.parseInt(arr[0]);
         endDate = UtilTime.Check(year, month, day);
         int recordTotalCount = searchTotalCountMyBuy(startDate, endDate,dto); 
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
            sb.append("<a href='/mypage/searchMyBuy.mp?page="+(startNavi-1)+"&startDate="+startDate+"&endDate="+endDate+"'> < </a>");
         }
         for(int i = startNavi; i<=endNavi; i++) {
            sb.append("<a href='/mypage/searchMyBuy.mp?page="+i+"&startDate="+startDate+"&endDate="+endDate+"'>"+i+" "+"</a>");
         }
         if(needNext) {
            sb.append("<a href='/mypage/searchMyBuy.mp?page="+(endNavi+1)+"&startDate="+startDate+"&endDate="+endDate+"'> > </a>");
         }
         return sb.toString();
      }
      public List<GoodsDTO> selectMySell(int page,GoodsDTO dto){
         return dao.selectMySell(page,dto);
      }
      public int totalCountMySell(GoodsDTO dto) throws Exception{
         return dao.totalCountMySell(dto);
      }
      public String naviMySell(int currentPage,GoodsDTO dto) throws Exception {
         int recordTotalCount = totalCountMyBuy(dto); 
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
            sb.append("<a href='/mypage/mySell.mp?page="+(startNavi-1)+"'> < </a>");
         }
         for(int i = startNavi; i<=endNavi; i++) {
            sb.append("<a href='/mypage/mySell.mp?page="+i+"'>"+i+" "+"</a>");
         }
         if(needNext) {
            sb.append("<a href='/mypage/mySell.mp?page="+(endNavi+1)+"'> > </a>");
         }
         return sb.toString();
      }
      public List<GoodsDTO> searchMySell(int page, String startDate, String endDate,GoodsDTO dto) {
         String arr[] = endDate.split("-");
         int day = Integer.parseInt(arr[2])+1;
         int month = Integer.parseInt(arr[1]);
         int year = Integer.parseInt(arr[0]);
         endDate = UtilTime.Check(year, month, day);
         return dao.searchMySell(page,startDate,endDate,dto);
      }
      public int searchTotalCountMySell(String startDate, String endDate,GoodsDTO dto) throws Exception{
         String arr[] = endDate.split("-");
         int day = Integer.parseInt(arr[2])+1;
         int month = Integer.parseInt(arr[1]);
         int year = Integer.parseInt(arr[0]);
         endDate = UtilTime.Check(year, month, day);
         return dao.searchTotalCountMySell(startDate, endDate,dto);
      }
      public String searchNaviMySell(int currentPage,String startDate,String endDate,GoodsDTO dto) throws Exception {
         String arr[] = endDate.split("-");
         int day = Integer.parseInt(arr[2]);
         int month = Integer.parseInt(arr[1]);
         int year = Integer.parseInt(arr[0]);
         endDate = UtilTime.Check(year, month, day);
         int recordTotalCount = searchTotalCountMySell(startDate, endDate,dto); 
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
            sb.append("<a href='/mypage/searchMySell.mp?page="+(startNavi-1)+"&startDate="+startDate+"&endDate="+endDate+"'> < </a>");
         }
         for(int i = startNavi; i<=endNavi; i++) {
            sb.append("<a href='/mypage/searchMySell.mp?page="+i+"&startDate="+startDate+"&endDate="+endDate+"'>"+i+" "+"</a>");
         }
         if(needNext) {
            sb.append("<a href='/mypage/searchMySell.mp?page="+(endNavi+1)+"&startDate="+startDate+"&endDate="+endDate+"'> > </a>");
         }
         return sb.toString();
      }
   
  	public String getImg(String title) {
		return dao.getImg(title);
	}
   
}