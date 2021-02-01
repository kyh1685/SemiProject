package kh.spring.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.spring.dto.ReportDTO;


@Repository
public class ReportDAO {

	@Autowired
	SqlSession session;
	
	public int insert(ReportDTO dto) {
		return session.insert("Report.insert", dto);
	}
	
	public List<ReportDTO> selectAll(){
		System.out.println("dao쪽 repotSelecetAll 요청");
		
		return session.selectList("Report.selectAll");
	}
	
	public int update(ReportDTO dto) {
		return session.update("Report.update", dto);
	}
}
