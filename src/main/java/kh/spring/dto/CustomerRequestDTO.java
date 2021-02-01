package kh.spring.dto;

public class CustomerRequestDTO {

	private int chk = 0;
	private int seq;
	private String writer;
	private String title;
	private String contents;
	private String answer;
	private String write_date;
	public int getChk() {
		return chk;
	}
	public void setChk(int chk) {
		this.chk = chk;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
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
	public String getWrite_date() {
		return write_date;
	}
	public void setWrite_date(String write_date) {
		this.write_date = write_date;
	}
	public CustomerRequestDTO(int chk, int seq, String writer, String title, String contents, String answer,
			String write_date) {
		super();
		this.chk = chk;
		this.seq = seq;
		this.writer = writer;
		this.title = title;
		this.contents = contents;
		this.answer = answer;
		this.write_date = write_date;
	}
	public CustomerRequestDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
