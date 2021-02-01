package kh.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.spring.dao.MessagesDAO;
import kh.spring.dto.MessagesDTO;
import kh.spring.statics.MypageConfigurator;

@Service
public class MessagesService {
	@Autowired
	private MessagesDAO mdao;
	
	public List<MessagesDTO> listMessages(int page,MessagesDTO dto){
		return mdao.listMessages(page,dto);
	}
	public int deleteMessages(MessagesDTO dto) {
		return mdao.deleteMessages(dto);
	}
	public int totalCountMessages(MessagesDTO dto) throws Exception{
		return mdao.totalCountMessages(dto);
	}
	public List<MessagesDTO> selectMessages(MessagesDTO dto) {
		return mdao.selectMessages(dto);
	}
	public List<MessagesDTO> ajaxMessages(MessagesDTO dto){
		return mdao.ajaxMessages(dto);
	}
	public int updateRead(MessagesDTO dto) {
		return mdao.updateRead(dto);
	}
	public int readAll(MessagesDTO dto) {
		return mdao.readAll(dto);
	}
	public int insertMessages(MessagesDTO dto) {
		return mdao.insertMessages(dto);
	}
	public List<MessagesDTO> searchMessages(int page,MessagesDTO dto,String searchText,String category){
		return mdao.searchMessages(page,dto,searchText,category);
	}
	public String naviMessages(int currentPage,MessagesDTO dto) throws Exception {
		int recordTotalCount = totalCountMessages(dto); 
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
			sb.append("<a href='/mypage/messages.mp?page="+(startNavi-1)+"'> < </a>");
		}
		for(int i = startNavi; i<=endNavi; i++) {
			sb.append("<a href='/mypage/messages.mp?page="+i+"'>"+i+" "+"</a>");
		}
		if(needNext) {
			sb.append("<a href='/mypage/messages.mp?page="+(endNavi+1)+"'> > </a>");
		}
		return sb.toString();
	}
	public int totalSearchCountMessages(MessagesDTO dto,String searchText,String category) throws Exception{
		return mdao.totalSearchCountMessages(dto,searchText,category);
	}
	public String searchNaviMessage(int currentPage,MessagesDTO dto, String searchText,String category) throws Exception{
			int recordTotalCount = totalSearchCountMessages(dto,searchText,category); 
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
				sb.append("<a href='/mypage/searchMessages.mp?page="+(startNavi-1)+"&searchText="+searchText+"&category="+category+"'> < </a>");
			}
			for(int i = startNavi; i<=endNavi; i++) {
				sb.append("<a href='/mypage/searchMessages.mp?page="+i+"&searchText="+searchText+"&category="+category+"'>"+i+" "+"</a>");
			}
			if(needNext) {
				sb.append("<a href='/mypage/searchMessages.mp?page="+(startNavi-1)+"&searchText="+searchText+"&category="+category+"'> > </a>");
			}
			return sb.toString();		
	}
}
