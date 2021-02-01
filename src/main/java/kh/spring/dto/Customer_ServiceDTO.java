package kh.spring.dto;

import java.sql.Date;

public class Customer_ServiceDTO {

	private int seq;
	private int rn;
	private String writer;
	private String title;
	private String contents;
	private String answer;
	private Date write_date;
	private String read;
	
	public Customer_ServiceDTO() {}

	public Customer_ServiceDTO(int seq, int rn, String writer, String title, String contents, String answer,
			Date write_date, String read) {
		this.seq = seq;
		this.rn = rn;
		this.writer = writer;
		this.title = title;
		this.contents = contents;
		this.answer = answer;
		this.write_date = write_date;
		this.read = read;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public int getRn() {
		return rn;
	}

	public void setRn(int rn) {
		this.rn = rn;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Date getWrite_date() {
		return write_date;
	}

	public void setWrite_date(Date write_date) {
		this.write_date = write_date;
	}

	public String getRead() {
		return read;
	}

	public void setRead(String read) {
		this.read = read;
	}
	
}
