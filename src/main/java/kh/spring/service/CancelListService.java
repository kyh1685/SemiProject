package kh.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.spring.dao.CancelListDAO;
import kh.spring.dto.BuyTradeDTO;
import kh.spring.dto.CancelListDTO;
import kh.spring.dto.TradeDTO;
import kh.spring.statics.MypageConfigurator;
import kh.spring.util.UtilTime;

@Service
public class CancelListService {
	
	@Autowired
	private CancelListDAO cldao;
	
	public int insert(CancelListDTO dto) {
		return cldao.insert(dto);
	}
	public int insertCancelList(BuyTradeDTO dto) {
		return cldao.insertCancelList(dto);
	}
	//--------------------------------------------------------------
	
	public List<CancelListDTO> select(int page,CancelListDTO dto){
		return cldao.select(page,dto);
	}
	public int totalCount(CancelListDTO dto) throws Exception{
		return cldao.totalCount(dto);
	}
	public String navi(int currentPage,CancelListDTO dto) throws Exception {
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
			sb.append("<a href='/mypage/cancelList.mp?page="+(startNavi-1)+"'> < </a>");
		}
		for(int i = startNavi; i<=endNavi; i++) {
			sb.append("<a href='/mypage/cancelList.mp?page="+i+"'>"+i+" "+"</a>");
		}
		if(needNext) {
			sb.append("<a href='/mypage/cancelList.mp?page="+(endNavi+1)+"'> > </a>");
		}
		return sb.toString();
	}
	public List<CancelListDTO> search(int page, String startDate, String endDate,CancelListDTO dto) {
		String arr[] = endDate.split("-");
		int day = Integer.parseInt(arr[2])+1;
		int month = Integer.parseInt(arr[1]);
		int year = Integer.parseInt(arr[0]);
		endDate = UtilTime.Check(year, month, day);
		return cldao.search(page,startDate,endDate,dto);
	}
	public int searchTotalCount(String startDate, String endDate,CancelListDTO dto) throws Exception{
		String arr[] = endDate.split("-");
		int day = Integer.parseInt(arr[2])+1;
		int month = Integer.parseInt(arr[1]);
		int year = Integer.parseInt(arr[0]);
		endDate = UtilTime.Check(year, month, day);
		return cldao.searchTotalCount(startDate, endDate,dto);
	}
	public String searchNavi(int currentPage,String startDate,String endDate,CancelListDTO dto) throws Exception {
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
			sb.append("<a href='/mypage/searchCancelList.mp?page="+(startNavi-1)+"&startDate="+startDate+"&endDate="+endDate+"'> < </a>");
		}
		for(int i = startNavi; i<=endNavi; i++) {
			sb.append("<a href='/mypage/searchCancelList.mp?page="+i+"&startDate="+startDate+"&endDate="+endDate+"'>"+i+" "+"</a>");
		}
		if(needNext) {
			sb.append("<a href='/mypage/searchCancelList.mp?page="+(endNavi+1)+"&startDate="+startDate+"&endDate="+endDate+"'> > </a>");
		}
		return sb.toString();
	}
}
