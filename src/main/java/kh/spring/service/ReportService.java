package kh.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.spring.dao.ReportDAO;
import kh.spring.dto.ReportDTO;


@Service
public class ReportService {

	@Autowired
	ReportDAO rdao;
	
	public int insert(ReportDTO dto) {
		return rdao.insert(dto);
	}
	
	public List<ReportDTO> selectAll(){
		return rdao.selectAll();
	}
	
	public int update(ReportDTO dto) {
		return rdao.update(dto);
	}
	
}
