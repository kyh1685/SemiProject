package kh.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.spring.dao.PurchaseListDAO;
import kh.spring.dto.BuyTradeDTO;
import kh.spring.dto.PurchaseListDTO;
import kh.spring.dto.SalesListDTO;
import kh.spring.statics.MypageConfigurator;
import kh.spring.util.UtilTime;

@Service
public class PurchaseListService {
	
	@Autowired
	private PurchaseListDAO dao;
	
	public int insert(PurchaseListDTO dto) {
		return dao.insert(dto);
	}
	
	public int delete(int seq) {
		return dao.delete(seq);
	}
	
	public int insertPurchase(BuyTradeDTO dto) {
		return dao.insertPurchase(dto);
	}
	public int deletePurchaseList(PurchaseListDTO dto) {
		return dao.deletePurchaseList(dto);
	}
	//---------------------------------------------------------------
	
	
	public List<PurchaseListDTO> select(int page,PurchaseListDTO dto){
		return dao.select(page,dto);
	}
	public int totalCount(PurchaseListDTO dto) throws Exception{
		return dao.totalCount(dto);
	}
	public String navi(int currentPage,PurchaseListDTO dto) throws Exception {
		int recordTotalCount = totalCount(dto); 
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
			sb.append("<a href='/mypage/purchaseList.mp?page="+(startNavi-1)+"'> < </a>");
		}
		for(int i = startNavi; i<=endNavi; i++) {
			sb.append("<a href='/mypage/purchaseList.mp?page="+i+"'>"+i+" "+"</a>");
		}
		if(needNext) {
			sb.append("<a href='/mypage/purchaseList.mp?page="+(endNavi+1)+"'> > </a>");
		}
		return sb.toString();
	}
	public List<PurchaseListDTO> search(int page, String startDate, String endDate,PurchaseListDTO dto) {
		String arr[] = endDate.split("-");
		int day = Integer.parseInt(arr[2])+1;
		int month = Integer.parseInt(arr[1]);
		int year = Integer.parseInt(arr[0]);
		endDate = UtilTime.Check(year, month, day);
		return dao.search(page,startDate,endDate,dto);
	}
	public int searchTotalCount(String startDate, String endDate,PurchaseListDTO dto) throws Exception{
		String arr[] = endDate.split("-");
		int day = Integer.parseInt(arr[2])+1;
		int month = Integer.parseInt(arr[1]);
		int year = Integer.parseInt(arr[0]);
		endDate = UtilTime.Check(year, month, day);
		return dao.searchTotalCount(startDate, endDate,dto);
	}
	public String searchNavi(int currentPage,String startDate,String endDate,PurchaseListDTO dto) throws Exception {
		String arr[] = endDate.split("-");
		int day = Integer.parseInt(arr[2]);
		int month = Integer.parseInt(arr[1]);
		int year = Integer.parseInt(arr[0]);
		endDate = UtilTime.Check(year, month, day);
		int recordTotalCount = searchTotalCount(startDate, endDate,dto); 
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
			sb.append("<a href='/mypage/searchPurchaseList.mp?page="+(startNavi-1)+"&startDate="+startDate+"&endDate="+endDate+"'> < </a>");
		}
		for(int i = startNavi; i<=endNavi; i++) {
			sb.append("<a href='/mypage/searchPurchaseList.mp?page="+i+"&startDate="+startDate+"&endDate="+endDate+"'>"+i+" "+"</a>");
		}
		if(needNext) {
			sb.append("<a href='/mypage/searchPurchaseList.mp?page="+(endNavi+1)+"&startDate="+startDate+"&endDate="+endDate+"'> > </a>");
		}
		return sb.toString();
	}
}
