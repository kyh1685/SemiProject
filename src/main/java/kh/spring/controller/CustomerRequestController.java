package kh.spring.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nexacro.uiadapter17.spring.core.annotation.ParamDataSet;
import com.nexacro.uiadapter17.spring.core.data.NexacroResult;

import kh.spring.dto.CustomerRequestDTO;
import kh.spring.service.CustomerRequestService;


@Controller
@RequestMapping("/cr")
public class CustomerRequestController {

	@Autowired CustomerRequestService service;
	
	
	@RequestMapping("home.pg")
	public String home(Locale locale, Model model) {
		
		return "redirect:/nex/index.html";
	}

	
	@RequestMapping("dsLoad.nex")
	public NexacroResult dsResp() {
		NexacroResult nr = new NexacroResult();
		
		List<CustomerRequestDTO>  list = service.select();
		
		nr.addDataSet("out_ds", list);
		return nr;
	}
	
	@RequestMapping("dsDel.nex")
	public NexacroResult dsDel(@ParamDataSet(name="in_ds")List<CustomerRequestDTO> list) {
		NexacroResult nr = new NexacroResult();
		int result = service.delete(list);
		return nr;
	}
	
	@RequestMapping("dsUpd.nex")
	public NexacroResult upd(@ParamDataSet(name="in_ds")CustomerRequestDTO dto) {
		System.out.println("update 요청 도착");
		NexacroResult nr = new NexacroResult();
		int result = service.update(dto);
		return nr;
	}
	@ExceptionHandler
	public String exceptionhandler(Exception e){
		return "error";
	}
}