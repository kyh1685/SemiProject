package kh.spring.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.scribejava.core.model.OAuth2AccessToken;
import com.google.gson.JsonObject;
import com.nexacro.uiadapter17.spring.core.annotation.ParamDataSet;
import com.nexacro.uiadapter17.spring.core.data.NexacroResult;

import kh.spring.dao.MembersDAO;
import kh.spring.dto.BuyTradeDTO;
import kh.spring.dto.EndList_PayDTO;
import kh.spring.dto.GoodsDTO;
import kh.spring.dto.MembersDTO;
import kh.spring.dto.NaverLoginBO;
import kh.spring.service.BuyTradeService;
import kh.spring.service.EndList_PayService;
import kh.spring.service.GoodsService;
import kh.spring.service.MembersService;
import kh.spring.service.TradeService;
import kh.spring.util.EncryptUtils;


@Controller
@RequestMapping("/members")
public class MemberController {

	@Autowired
	private MembersDAO dao;
	@Autowired
	private BuyTradeService btService;
	@Autowired
	private GoodsService gservice;

	@Autowired
	private MembersService service;

	@Autowired
	HttpSession session;

	@Autowired
	private EndList_PayService epService;
	
	@Autowired
	private TradeService tservice;
	
	@RequestMapping("payment.pg")
	public String payment(HttpSession session,HttpServletRequest request ,Model model) {
		String id = (String)session.getAttribute("login");
		String name= (String)request.getParameter("name");
		String email = (String)request.getParameter("email");
		String phone = (String)request.getParameter("phone");
		String address = (String)request.getParameter("address");
		String totalPrice1 = (String)request.getParameter("totalPrice");
		int totalPrice = Integer.parseInt(totalPrice1);

		System.out.println("=======================페이먼트까지 넘어간 사항========================");
		System.out.println("id : "+id);
		System.out.println("name : "+name);
		System.out.println("email : "+email);
		System.out.println("phone : "+phone);
		System.out.println("address : "+address);
		System.out.println("totalPrice : "+totalPrice);
		System.out.println("=================================================================");

		model.addAttribute("id",id);
		model.addAttribute("name","1");
		model.addAttribute("email","1");
		model.addAttribute("phone","1");
		model.addAttribute("address","1");
		model.addAttribute("totalPrice",totalPrice);

		return "payment";
	}

	@RequestMapping("failed.pg")
	public String failed() {
		return "failed";
	}

	@RequestMapping("sucess.pg")
	   public String sucess(HttpSession session,HttpServletRequest request ,Model model) {
	      System.out.println("===================석세스 요청==============================");

	      String totalPrice1 = (String)request.getParameter("totalPrice");
	      int totalPrice = Integer.parseInt(totalPrice1);
	      String id = (String)request.getParameter("id");
	      System.out.println("===================예전 마일리지 요청==============================");
	      int passed_mileage = service.selectMileage(id);
	          
	      service.update(id,passed_mileage);
	      
	      int now_mileage=service.selectMileage(id);
   
	      EndList_PayDTO dto = new EndList_PayDTO();	      
	      dto.setId(id);
	      dto.setMileage(now_mileage);
	      dto.setGoodName("마일리지 충전");
	      dto.setValue(totalPrice); 
	      epService.insert(dto);
	      
	      return "sucess";
	   }
	
	@RequestMapping("sucess1.pg")
	   public String sucess1(HttpSession session,HttpServletRequest request ,Model model) {
	      String id = (String)session.getAttribute("login");
	      int mileage = service.selectMileage(id);
	      model.addAttribute("id",id);
	      model.addAttribute("mileage",mileage);
	      return "sucess1";
	}

	@RequestMapping("insert.pg")
	public String insert(Model model) {
		String id = (String)session.getAttribute("login");
		model.addAttribute("id",id);
		return "insert";
	}

	//====================================================================================================

	private NaverLoginBO naverLoginBO;
	private String apiResult = null;

	@Autowired
	private void setNaverLoginBO(NaverLoginBO naverLoginBO) {
		this.naverLoginBO = naverLoginBO;
	}

	// 로그인 페이지
	@RequestMapping("loginPage.mem")
	public String loginPage(Model model) {
		/* 네이버아이디로 인증 URL을 생성하기 위하여 naverLoginBO클래스의 getAuthorizationUrl메소드 호출 */
		String naverAuthUrl = naverLoginBO.getAuthorizationUrl(session);

		System.out.println("네이버:" + naverAuthUrl);

		//네이버 
		model.addAttribute("url", naverAuthUrl);

		/* 생성한 인증 URL을 View로 전달 */
		return "/member/login";
	}

	// 로그인
	@RequestMapping("login.mem")
	public String toLogin(String id,String Spw,Model model) throws Exception {
		int result = 0;

		if(Spw.length()<64) {
			String pw = EncryptUtils.getSHA256(Spw);
			result = service.login(id,pw);
		}else {
			result = service.login(id,Spw);
		}

		model.addAttribute("result", result);

		if(result > 0) {
			session.setAttribute("login", id);
			int currentPage = 1;
			List<GoodsDTO> list = gservice.listByCpage(currentPage);	
			String navi = gservice.getNavi(currentPage);
			
			model.addAttribute("list", list);
			model.addAttribute("navi", navi);
			
			return "home";
		}else {
			return "/member/loginFail";
		}
	}
	@RequestMapping("checkTrade.mem")
	@ResponseBody
	public String chekcTrade() {
		String id = (String)session.getAttribute("login");
		if(id != null) {
		     //checkTrade 
		      BuyTradeDTO btdto = new BuyTradeDTO();
		      btdto.setGoodWriter(id);
		      int BuycheckTrade = btService.checkTrade(btdto);
		      System.out.println("Buy"+BuycheckTrade);
		      int checkTrade = tservice.checkTrade(id);
		      checkTrade =BuycheckTrade + checkTrade;
		      return Integer.toString(checkTrade);
		}else {
			return "0";
		}
	}
	@RequestMapping("checkReq.mem")
	@ResponseBody
	public String checkReq() {
		String id = (String)session.getAttribute("login");
		if(id !=null) {
			//req
			String req = "";
			String buyer_req="";
		    if(!btService.selectBuyerList(id).isEmpty()) {
		    	 req = "Y";	
		    }else {
		    	req = "N";
		    }
		    if(!tservice.selectBuyerList(id).isEmpty()) {
		    	buyer_req = "Y";
		    }else {
		    	buyer_req="N";
		    }
			System.out.println("id :" + id);
			
			if(req.contentEquals("Y") || buyer_req.contentEquals("Y") ) {
				return "Y";
			}else {
				return "N";
			}
		}else {
			return "N";
		}
	}
	@RequestMapping("blackListCheck.mem")
	@ResponseBody
	public String blackListCheck() {
		String id = (String)session.getAttribute("login");
		if(id != null) {
			int blackListCheck = service.blackListCheck(id);
			return Integer.toString(blackListCheck);
		}else {
			return "0";
		}
	}
	// 회원가입 페이지 요청(네이버)
	@RequestMapping("signupView.mem")
	public String toSignUpView(Model model, @RequestParam String code, @RequestParam String state) throws Exception {
		//네이버 로그인 성공시 callback호출 메소드
		System.out.println("여기는 callback");
		OAuth2AccessToken oauthToken;
		oauthToken = naverLoginBO.getAccessToken(session, code, state);
		//로그인 사용자 정보를 읽어온다.
		apiResult = naverLoginBO.getUserProfile(oauthToken);

		// String형식인 apiResult를 json형태로 바꿈
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(apiResult);
		JSONObject jsonObj = (JSONObject) obj;
		// 데이터 파싱
		JSONObject response_obj = (JSONObject)jsonObj.get("response");
		//response의 nickname값 파싱
		String name = (String)response_obj.get("name");
		String defaultEmail = (String)response_obj.get("email");
		String[] email = defaultEmail.split("@");

		// 회원가입 여부 확인
		MembersDTO dto = service.naverEmailCk(email[0]);
		System.out.println("네이버 로그인 조회 결과 : " + dto);

		if(dto != null) {
			return toLogin(dto.getId(),dto.getPw(),model);
		}else {
			session.setAttribute("sessionName",name);
			session.setAttribute("sessionEmail", email[0]);

			model.addAttribute("result", apiResult);
			/* 네이버 로그인 성공 페이지 View 호출 */
			return "/member/signupView";
		}
	}

	// 회원가입 페이지 요청(nomal)
	@RequestMapping("signupViewNomal.mem")
	public String toSignUpView() {
		return "/member/signupView";
	}

	// 회원가입
	@RequestMapping("signup.mem")
	public String toSignUp(String id,String pw,String name, String contact,String email1,String email2,Model model) throws Exception{
		if(pw==null) {
			pw = service.getRandomPassword(8);
		}
		String email = email1 + "@" + email2;
		String Spw = EncryptUtils.getSHA256(pw);
		int result = service.signUp(id,Spw,name,contact,email);
		model.addAttribute("result",result);
		return "/member/signupResultView";
	}

	// 이메일 인증
	@RequestMapping(value="emailCheck.mem",produces="text/plain; charset=UTF8")
	public void emailCheck(String email1,String email2,ServletResponse response)throws Exception{
		System.out.println("이메일 인증요청 도착!");
		response.setCharacterEncoding("UTF-8");
		String email = email1 + "@" + email2;

		// 이메일 중복체크
		int result = service.isEmailExist(email);

		if(result>0) {
			PrintWriter pw = response.getWriter();
			JsonObject obj = new JsonObject();
			obj.addProperty("msg", "이미 사용중인 이메일입니다.");
			obj.addProperty("value", "");
			pw.append(obj.toString());
		}else {
			String authNum = service.connectEmail(email);
			PrintWriter pw = response.getWriter();
			JsonObject obj = new JsonObject();
			obj.addProperty("msg", "인증번호를 보냈습니다.");
			obj.addProperty("value", authNum);
			pw.append(obj.toString());
		}
	}

	// 아이디 중복 체크
	@RequestMapping(value="idCheck.mem",produces="text/plain; charset=UTF8")
	public void idDuplCheck(String id, ServletResponse response) throws Exception{
		response.setCharacterEncoding("UTF-8");
		int result = service.isIdExist(id);
		PrintWriter pw = response.getWriter();
		if(result>0) {
			JsonObject obj = new JsonObject();
			obj.addProperty("msg", "이미 사용중인 아이디 입니다.");
			obj.addProperty("value", "");
			pw.append(obj.toString());
		}else {
			JsonObject obj = new JsonObject();
			obj.addProperty("msg", "사용 가능한 아이디 입니다.");
			obj.addProperty("value", id);
			pw.append(obj.toString());
		}
	}

	// 로그아웃
	@RequestMapping("logout.mem")
	public String toLogOut() {
		session.invalidate();
		return "forward:/";
	}

	// 넥사크로 회원관리 조회
	@RequestMapping("selectMembers.mem")
	public NexacroResult selectMembers() {
		System.out.println("넥사크로 회원조회 요청 도착!");
		NexacroResult nr = new NexacroResult();
		List<MembersDTO> list = service.selectMembers();
		nr.addDataSet("out_ds", list);
		return nr;
	}

	// 넥사크로 회원 탈퇴
	@RequestMapping("dsDel.mem")
	public NexacroResult dsDel(@ParamDataSet(name="in_ds") List<MembersDTO> list) {
		int result = service.delete(list);
		return new NexacroResult();
	}

	// 예외 처리
	@ExceptionHandler
	public String ExceptionHandler(Exception e) {
		e.printStackTrace();
		return "error";
	}
}
