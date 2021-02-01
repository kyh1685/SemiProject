package kh.spring.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.spring.dto.GoodsDTO;
import kh.spring.dto.MembersDTO;

@Repository
public class MembersDAO {
	@Autowired
	private SqlSession session;
	
	public MembersDTO getMember(MembersDTO dto) {
		return session.selectOne("Members.getMember",dto);
	}
	public int checkMileage(String id) {
		return session.selectOne("Members.checkMileage",id);
	}
	public int updateMileage(MembersDTO dto) {
		return session.update("Members.updateMileage",dto);
	}
	public int blackListCheck(String id) {
		return session.selectOne("Members.blackListCheck",id);
	}
	public int myPageCheck(MembersDTO dto) {
		return session.selectOne("Members.myPageCheck",dto);
	}
	// 결제후 마일리지 증가
	public int update(String id, int passed_mileage) {
		passed_mileage += 10000;
		String mileage = Integer.toString(passed_mileage);
		Map<String, String> param = new HashMap<String, String>();
		param.put("id", id);
		param.put("mileage",mileage);
		return session.update("Members.updateMileage",param);
	}
	// 마일리지 감소
	public int minus(String id, int passed_mileage, int price) {
		passed_mileage -= price;
		String mileage = Integer.toString(passed_mileage);
		Map<String, String> param = new HashMap<String, String>();
		param.put("id", id);
		param.put("mileage",mileage);
		return session.update("Members.updateMileage",param);
	}
	// 마일리지 증가
	public int plus(String id, int passed_mileage, int price) {
		passed_mileage += price;
		String mileage = Integer.toString(passed_mileage);
		Map<String, String> param = new HashMap<String, String>();
		param.put("id", id);
		param.put("mileage",mileage);
		return session.update("Members.updateMileage",param);
	}
	//현 아이디 마일리지 가져오기
	public int selectMileage(String id) {
		return session.selectOne("Members.selectMileage",id);
	}
	
	// 로그인
		public int login(String id,String pw)throws Exception{
			Map<String, String> param = new HashMap<>();
			param.put("id", id);
			param.put("pw", pw);
			return session.selectOne("Members.login",param);
		}
		
		// 네이버 회원가입 여부 확인
		public MembersDTO naverEmailCk(String email) {
			return session.selectOne("Members.naverCk",email);
		}
		
		// 회원가입
		public int signUp(String id,String pw,String name,String contact,String email) throws Exception {
			Map<String, String> param = new HashMap<>();
			param.put("id", id);
			param.put("pw", pw);
			param.put("name", name);
			param.put("contact", contact);
			param.put("email", email);
			return session.insert("Members.signup",param);
		}
		
		// 아이디 중복체크
		public int isIdExist(String id) throws Exception {
			return session.selectOne("Members.idcheck",id);
		}
		
		// 이메일 중복체크
		public int isEmailExist(String email) throws Exception{
			return session.selectOne("Members.emailcheck",email);
		}
		
		// 넥사크로 회원관리 조회
		public List<MembersDTO> selectMembers(){
			return session.selectList("Members.selectMembers");
		}
		
		// 넥사크로 회원탈퇴
		public int delete(List<MembersDTO> list) {
			return session.delete("Members.delete",list);
		}
		
		//-------------------------------------------------------------------------------------------
		
		public MembersDTO getList(String id) {
			return session.selectOne("Members.SelectById",id);
		}
		public String getListEmail(String id) {
			return session.selectOne("Members.SelectEmailById",id);
		}
		public String getListContact(String id) {
			return session.selectOne("Members.SelectContactById",id);
		}
		
		public int okupdate(MembersDTO dto) {
			return session.update("Members.okupdate", dto);
		}
		public int delMember(MembersDTO dto) {
			return session.delete("Members.Delete", dto);
		}
		public int checkId(String id) {
			return session.selectOne("Members.checkId", id);
		}

		
}
