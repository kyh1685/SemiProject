package kh.spring.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.spring.dao.EndList_PayDAO;
import kh.spring.dto.EndList_PayDTO;
import kh.spring.statics.MypageConfigurator;
import kh.spring.util.UtilTime;

@Service
public class EndList_PayService {

	@Autowired
	private EndList_PayDAO elpdao;
	public int insert(EndList_PayDTO dto) {
		return elpdao.insert(dto);
	}
	public List<EndList_PayDTO> select(int page,EndList_PayDTO dto){
		return elpdao.select(page,dto);
	}
	public int totalCount(EndList_PayDTO dto) throws Exception{
		return elpdao.totalCount(dto);
	}
	public String navi(int currentPage,EndList_PayDTO dto) throws Exception {
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
			sb.append("<a href='/mypage/endList_Pay.mp?page="+(startNavi-1)+"'> < </a>");
		}
		for(int i = startNavi; i<=endNavi; i++) {
			sb.append("<a href='/mypage/endList_Pay.mp?page="+i+"'>"+i+" "+"</a>");
		}
		if(needNext) {
			sb.append("<a href='/mypage/endList_Pay.mp?page="+(endNavi+1)+"'> > </a>");
		}
		return sb.toString();
	}
	public List<EndList_PayDTO> search(int page, String startDate, String endDate,EndList_PayDTO dto) {
		String arr[] = endDate.split("-");
		int day = Integer.parseInt(arr[2])+1;
		int month = Integer.parseInt(arr[1]);
		int year = Integer.parseInt(arr[0]);
		endDate = UtilTime.Check(year, month, day);
		return elpdao.search(page,startDate,endDate,dto);
	}
	public int searchTotalCount(String startDate, String endDate,EndList_PayDTO dto) throws Exception{
		String arr[] = endDate.split("-");
		int day = Integer.parseInt(arr[2])+1;
		int month = Integer.parseInt(arr[1]);
		int year = Integer.parseInt(arr[0]);
		endDate = UtilTime.Check(year, month, day);
		return elpdao.searchTotalCount(startDate, endDate,dto);
	}
	public String searchNavi(int currentPage,String startDate,String endDate,EndList_PayDTO dto) throws Exception {
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
			sb.append("<a href='/mypage/searchEndList_Pay.mp?page="+(startNavi-1)+"&startDate="+startDate+"&endDate="+endDate+"'> < </a>");
		}
		for(int i = startNavi; i<=endNavi; i++) {
			sb.append("<a href='/mypage/searchEndList_Pay.mp?page="+i+"&startDate="+startDate+"&endDate="+endDate+"'>"+i+" "+"</a>");
		}
		if(needNext) {
			sb.append("<a href='/mypage/searchEndList_Pay.mp?page="+(endNavi+1)+"&startDate="+startDate+"&endDate="+endDate+"'> > </a>");
		}
		return sb.toString();
	}
}
