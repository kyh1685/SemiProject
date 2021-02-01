package kh.spring.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nexacro.uiadapter17.spring.core.annotation.ParamDataSet;
import com.nexacro.uiadapter17.spring.core.data.NexacroResult;

import kh.spring.dao.ReportDAO;
import kh.spring.dto.GoodsDTO;
import kh.spring.dto.ReportDTO;
import kh.spring.service.ReportService;


@Controller
@RequestMapping("/report")
public class ReportContoroller {
	
	@Autowired
	ReportDAO rdao;
	@Autowired
	ReportService service;
	@Autowired
	private HttpSession session;
	@RequestMapping("insert.report")
	public String insertReport(HttpServletRequest request) {
		String id = (String)session.getAttribute("login");
		System.out.println("insert.report 요청 완료");
		int gSeq=Integer.parseInt(request.getParameter("reportPage"));
		String rTxt=request.getParameter("reportTxt");
		int codeReport=Integer.parseInt(request.getParameter("selectReport"));
		String reportedUser = request.getParameter("reportedUser");
		ReportDTO dto = new ReportDTO();
		dto.setReportedUser(reportedUser);
		dto.setReportWriter(id);
		dto.setGoodSeq(gSeq);
		dto.setReportCode(codeReport);
		dto.setReportContents(rTxt);
		int result=service.insert(dto);
			
		return "redirect:/good/view.good?goodSeq="+gSeq+"&page=1";
	}
	
	@RequestMapping("reportList.nex")
	public NexacroResult reportList() {
		NexacroResult nr = new NexacroResult();
		
		List<ReportDTO> list = service.selectAll();
		nr.addDataSet("out_ds", list);
		
		return nr;
	}
	
	@RequestMapping("updateMemo.nex")
	public NexacroResult updateMemo(@ParamDataSet(name="in_ds")ReportDTO dto) {
		System.out.println("updateMemo 확인");
		System.out.println(dto.getReportMemo());
		NexacroResult nr = new NexacroResult();
		int result = service.update(dto);		
		return nr;
	}
	
	@ExceptionHandler
	public String exceptionhandler(Exception e){
		return "error";
	}
	
}
