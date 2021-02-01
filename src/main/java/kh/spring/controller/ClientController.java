package kh.spring.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import kh.spring.dao.Customer_ServiceDAO;
import kh.spring.dto.Customer_ServiceDTO;
import kh.spring.service.SemiProjectService;

@Controller
@RequestMapping("/client")
public class ClientController {
	@Autowired
	private HttpSession session;
	@Autowired
	private Customer_ServiceDAO cdao;
	@Autowired
	private SemiProjectService service;
	
	@RequestMapping("clientCenter.center")
	public String clientCenter(String cpage,Model model)throws Exception {
		String id = (String)session.getAttribute("login");
		if(id == null) {
	         return "/member/login";
	      }
		List<Customer_ServiceDTO> cdto = service.listByCpage(Integer.parseInt(cpage));
		String navi = service.getNavi(Integer.parseInt(cpage));
		model.addAttribute("list",cdto);
		model.addAttribute("navi",navi);
		
		return "client/ClientCenter";
	}
	@RequestMapping("mylist.center")
	public String mylist(String cpage,Model model) throws Exception{
		String id =(String) session.getAttribute("login");
		List<Customer_ServiceDTO> cdto = service.mylist(Integer.parseInt(cpage),id);
		String navi = service.getMyNavi(Integer.parseInt(cpage), id);
		model.addAttribute("navi",navi);
		model.addAttribute("list",cdto);
		return "client/MyList";
	}@RequestMapping("select.center")
	public String selectByseq(Customer_ServiceDTO dto,String seq,Model model)throws Exception{
		String id = (String) session.getAttribute("login");
		model.addAttribute("id",id);
		Customer_ServiceDTO cdto = service.getList2(seq);
		String answer = cdto.getAnswer();	
		if(answer != null) {
			service.readUpdate(seq);
		}
		model.addAttribute("dto",cdto);
		return "client/WriteView";
	}
@RequestMapping("okupdatewrite.center")
	public String okupdatewrite(HttpServletRequest request,Model model)throws Exception{
		System.out.println("수정");
		Customer_ServiceDTO dto = new Customer_ServiceDTO();
		int seq = Integer.parseInt(request.getParameter("seq"));
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String contents = request.getParameter("contents");
		System.out.println(seq +":" +writer +":"+contents+":"+title);
		dto.setSeq(seq);
		dto.setWriter(writer);
		dto.setContents(contents);
		dto.setTitle(title);
		int result = cdao.update(dto);
		if(result>0) {
			int cpage=1;
			List<Customer_ServiceDTO> cdto = service.listByCpage(cpage);
			String navi = service.getNavi(cpage);
			model.addAttribute("list",cdto);
			model.addAttribute("navi",navi);
			return"client/ClientCenter";
	}else {
		return "error";
	}
			
	}
	@RequestMapping("mylistselect.center")
	public String myselectByseq(Customer_ServiceDTO dto,String seq,Model model)throws Exception{
		Customer_ServiceDTO cdto = service.getList2(seq);
		model.addAttribute("dto",cdto);
		return "client/upDate";
	}
	@RequestMapping("write.center")
	public String write(Model model) {
		String id =(String)session.getAttribute("login");
		model.addAttribute("id",id);
		return "client/Write";
	}
	@RequestMapping(value="writefocus.center", produces="text/plain; charset=UTF8")
	public String writeok(Customer_ServiceDTO dto,HttpServletRequest request,Model model) throws Exception {
		int result = cdao.insert(dto);
		int cpage = Integer.parseInt(request.getParameter("cpage"));
		if(result>0) {
			List<Customer_ServiceDTO> cdto = service.listByCpage(cpage);
			String navi = service.getNavi(cpage);
			model.addAttribute("list",cdto);
			model.addAttribute("navi",navi);
			return"client/ClientCenter";
		}else {
			return "error";
		}
	}
	@RequestMapping("delete.center")
	public String delete(HttpServletRequest request,Model model) throws Exception {
		int seq = Integer.parseInt(request.getParameter("seq"));
		int cpage= 1;
		int result = service.delete(seq);
		System.out.println(result);
		if(result > 0) {
			List<Customer_ServiceDTO> cdto = service.listByCpage(cpage);
			String navi = service.getNavi(cpage);
			model.addAttribute("list",cdto);
			model.addAttribute("navi",navi);
			return"client/ClientCenter";
		}else {
			return "error";
		}
		
	}
	@ExceptionHandler
	public String exceptionhandler(Exception e){
		return "error";
	}

}
