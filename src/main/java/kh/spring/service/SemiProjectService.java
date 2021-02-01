package kh.spring.service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.spring.dao.Customer_ServiceDAO;
import kh.spring.dao.MembersDAO;
import kh.spring.dto.Customer_ServiceDTO;
import kh.spring.dto.MembersDTO;
import kh.spring.statics.ClientConfigurator;

@Service
public class SemiProjectService {
	
	@Autowired
	private MembersDAO mdao;
	@Autowired
	private Customer_ServiceDAO cdao;
	
	public MembersDTO getList(String id) {
		return mdao.getList(id);
	}
	public int checkId(String id) {
		return mdao.checkId(id);
	}
	public List<Customer_ServiceDTO> listByCpage(int cpage) throws Exception{
		return cdao.listByCpage(cpage);	
	}
	public String getNavi(int cpage) throws Exception{
		int recordTotalCount = getDataCount();
		int pageTotalCount;
		if(recordTotalCount % ClientConfigurator.recordCountPerPage>0) {
			pageTotalCount = recordTotalCount / ClientConfigurator.recordCountPerPage +1;
		}else {
			pageTotalCount = recordTotalCount / ClientConfigurator.recordCountPerPage;
		}
		if(cpage < 1) {
			cpage =1;
		} else if(cpage>pageTotalCount) {
			cpage = pageTotalCount;
		}
		int startNavi =(cpage-1)/ClientConfigurator.naviCountPerPage * ClientConfigurator.naviCountPerPage +1;
		int endNavi = startNavi + ClientConfigurator.naviCountPerPage-1;
		
		if(endNavi > pageTotalCount) {
			endNavi = pageTotalCount;
		}
		boolean needPrev = true;
		boolean needNext = true;
		
		if (startNavi == 1) {
			needPrev = false;
		}
		if(endNavi == pageTotalCount) {
			needNext = false;
		}
		StringBuilder sb = new StringBuilder();
		
		if(needPrev) {
			sb.append("<a href ='clientCenter.center?cpage=" + (startNavi - 1) +  "'> < </a>");
			
		}
		for(int i = startNavi; i <=endNavi; i++) {
			sb.append("<a href= 'clientCenter.center?cpage=" + i + "'>" + i +" "+"</a>");
		}
		if(needNext) {
			sb.append("<a href='clientCenter.center?cpage="+ (endNavi + 1) + "'> > </a>");
		}
		
		return sb.toString();
	}
	public String getMyNavi(int cpage,String id) throws Exception{
		int recordTotalCount = getMyDataCount(id);
		int pageTotalCount;
		if(recordTotalCount % ClientConfigurator.recordCountPerPage>0) {
			pageTotalCount = recordTotalCount / ClientConfigurator.recordCountPerPage +1;
		}else {
			pageTotalCount = recordTotalCount / ClientConfigurator.recordCountPerPage;
		}
		if(cpage < 1) {
			cpage =1;
		} else if(cpage>pageTotalCount) {
			cpage = pageTotalCount;
		}
		int startNavi =(cpage-1)/ClientConfigurator.naviCountPerPage * ClientConfigurator.naviCountPerPage +1;
		int endNavi = startNavi + ClientConfigurator.naviCountPerPage-1;
		
		if(endNavi > pageTotalCount) {
			endNavi = pageTotalCount;
		}
		boolean needPrev = true;
		boolean needNext = true;
		
		if (startNavi == 1) {
			needPrev = false;
		}
		if(endNavi == pageTotalCount) {
			needNext = false;
		}
		StringBuilder sb = new StringBuilder();
		
		if(needPrev) {
			sb.append("<a href = 'mylist.center?cpage=" + (startNavi - 1) +  "'> < </a>");
			
		}
		for(int i = startNavi; i <=endNavi; i++) {
			sb.append("<a href= 'mylist.center?cpage=" + i + "'>" +i+" "+"</a>");
		}
		if(needNext) {
			sb.append("<a href='mylist.center?cpage="+ (endNavi + 1) + "'> > </a>");
		}
		
		return sb.toString();
	}
	public int getDataCount() throws Exception{
		return cdao.getDataCount();
	}
	public int getMyDataCount(String id) throws Exception{
		return cdao.getMyDataCount(id);
	}
	public List<Customer_ServiceDTO> mylist(int cpage,String id) throws Exception{
		return cdao.mylist(cpage,id);
	}
	public Customer_ServiceDTO getList2(String seq) throws Exception{
		return cdao.getList(seq);
	}
	public int readUpdate(String seq) {
		return cdao.readUpdate(seq);
	}
	public int delete(int seq) {
		return cdao.delete(seq);
	}

}
