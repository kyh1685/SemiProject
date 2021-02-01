package kh.spring.service;

import java.util.List;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.spring.dao.MembersDAO;
import kh.spring.dto.MembersDTO;
import kh.spring.dto.MembersDTO;
import kh.spring.dto.GoodsDTO;
@Service
public class MembersService {

	@Autowired
	private MembersDAO dao;
	
	public MembersDTO getMember(MembersDTO dto) { 
		return dao.getMember(dto);
	}
	public int checkMileage(String id) {
		return dao.checkMileage(id);
	}
	public int updateMileage(MembersDTO dto) {
		return dao.updateMileage(dto);
	}
	public int blackListCheck(String id) {
		return dao.blackListCheck(id);
	}
	public int myPageCheck(MembersDTO dto) {
		return dao.myPageCheck(dto);
	}
	public int okupdate(MembersDTO dto) {
		return dao.okupdate(dto);
	}
	public int delMember(MembersDTO dto) {
		return dao.delMember(dto);
	}
	// 결제후 마일리지 증가 시키기
	public int update(String id, int passed_mileage) {
		return dao.update(id, passed_mileage);
	}
	// 마일리지 감소
	public int minus(String id, int passed_mileage, int price) {
		return dao.minus(id, passed_mileage, price);
	}
	// 마일리지 증가
	public int plus(String id, int passed_mileage, int price) {
		return dao.plus(id, passed_mileage, price);
	}
	// 현재 마일리지 조회
	public int selectMileage(String id) {
		return dao.selectMileage(id);
	}
	
	// 로그인
		public int login(String id,String pw) throws Exception {
			return dao.login(id,pw);
		}
		
		// 네이버 회원가입 여부 확인
		public MembersDTO naverEmailCk(String email) {
			return dao.naverEmailCk(email);
		}
				
		// 회원가입
		public int signUp(String id,String pw,String name,String contact,String email) throws Exception {
			return dao.signUp(id,pw,name,contact,email);
		}
		
		// 아이디 중복체크
		public int isIdExist(String id) throws Exception {
			return dao.isIdExist(id);
		}
		
		// 이메일 중복체크
		public int isEmailExist(String email) throws Exception {
			return dao.isEmailExist(email);
		}
		
		// 이메일 인증
		public String connectEmail(String email){
			String to1=email; // 인증을 위해 사용자가 입력한 이메일주소
			String host="smtp.gmail.com"; // smtp 서버
			String subject="인증번호 전달"; // 보내는 제목 설정
			String fromName="재능판매 장터"; // 보내는 이름 설정
			String from="talentmarket08@gmail.com"; // 보내는 사람(구글계정)
			String authNum=authNum(); // 인증번호 위한 난수 발생부분
			String content="인증번호 ["+authNum+"]"; // 이메일 내용 설정
			
	        // SMTP 이용하기 위해 설정해주는 설정값들
			try{
			Properties props=new Properties();
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.transport.protocol", "smtp");
			props.put("mail.smtp.host", host);
			props.setProperty("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
			props.put("mail.smtp.port","465");
			props.put("mail.smtp.user",from);
			props.put("mail.smtp.auth","true");
			
			Session mailSession 
	           = Session.getInstance(props,new javax.mail.Authenticator(){
				    protected PasswordAuthentication getPasswordAuthentication(){
					    return new PasswordAuthentication("talentmarket08","dhdhkd@0311"); // gmail계정
				}
			});
			
			Message msg = new MimeMessage(mailSession);
			InternetAddress []address1 = {new InternetAddress(to1)};
			msg.setFrom(new InternetAddress
	                      (from, MimeUtility.encodeText(fromName,"utf-8","B")));
			msg.setRecipients(Message.RecipientType.TO, address1); // 받는사람 설정
			msg.setSubject(subject); // 제목설정
			msg.setSentDate(new java.util.Date()); // 보내는 날짜 설정
			msg.setContent(content,"text/html; charset=utf-8"); // 내용설정
			
			Transport.send(msg); // 메일보내기
			}catch(MessagingException e){
				e.printStackTrace();
			}catch(Exception e){
				e.printStackTrace();
			}
			return authNum;
		}

	    // 난수 생성
		public static String authNum(){
			StringBuffer buffer=new StringBuffer();
			for(int i=0;i<=4;i++){
				int num=(int)(Math.random()*9+1);
				buffer.append(num);
			}
			return buffer.toString();
		}
		
		// 임시 비밀번호 생성
		public static String getRandomPassword( int length ){
			char[] charaters = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','0','1','2','3','4','5','6','7','8','9'};
			StringBuilder sb = new StringBuilder("");
			Random rn = new Random();
			for( int i = 0 ; i < length ; i++ ){
				sb.append( charaters[ rn.nextInt( charaters.length ) ] );
			}
			return sb.toString();
		}
		
		// 넥사크로 회원관리 조회
		public List<MembersDTO> selectMembers(){
			return dao.selectMembers();
		}
		
		// 넥사크로 회원탈퇴
		public int delete(List<MembersDTO> list) {
			return dao.delete(list);
		}
		
		public String getListContact(String id) {
			return dao.getListContact(id);
		}
		
		public String getListEmail(String id) {
			return dao.getListEmail(id);
		}
	
}
