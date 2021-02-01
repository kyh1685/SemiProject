package kh.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import kh.spring.dao.GoodsDAO;
import kh.spring.dao.ReviewDAO;
import kh.spring.dto.GoodsDTO;
import kh.spring.service.GoodsService;


@Controller
public class HomeController {
	
	
	@Autowired
	GoodsService service;
	@Autowired
	HttpSession session;

	@Autowired
	GoodsDAO gdao;
	@Autowired
	ReviewDAO rdao;
	
	@RequestMapping("/")
	public String home(HttpServletRequest request,Model model) throws Exception{
		String cpage = null;
		int currentPage = 0;
		if(request.getParameter("cpage")==null) {
			currentPage= 1;
		}else {
			cpage = request.getParameter("cpage");
			currentPage = Integer.parseInt(cpage);
		}
		List<GoodsDTO> list = service.listByCpage(currentPage);	
		String navi = service.getNavi(currentPage);
		
		model.addAttribute("list", list);
		model.addAttribute("navi", navi);

		return "home";
	}
	
	// 예외 처리
		@ExceptionHandler
		public String ExceptionHandler(Exception e) {
			e.printStackTrace();
			return "error";
		}
	
		@RequestMapping("/admin")
		public String admin(){
			return "redirect:/nex/index.htm";
		}
	
}
