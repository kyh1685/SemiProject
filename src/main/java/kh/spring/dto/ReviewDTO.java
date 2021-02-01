package kh.spring.dto;

public class ReviewDTO {
	private int goodSeq;
    private int revSeq;
    private String revWriter;
    private String revContents;
    private String revDate;
	public ReviewDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ReviewDTO(int goodSeq, int revSeq, String revWriter, String revContents, String revDate) {
		super();
		this.goodSeq = goodSeq;
		this.revSeq = revSeq;
		this.revWriter = revWriter;
		this.revContents = revContents;
		this.revDate = revDate;
	}
	public int getGoodSeq() {
		return goodSeq;
	}
	public void setGoodSeq(int goodSeq) {
		this.goodSeq = goodSeq;
	}
	public int getRevSeq() {
		return revSeq;
	}
	public void setRevSeq(int revSeq) {
		this.revSeq = revSeq;
	}
	public String getRevWriter() {
		return revWriter;
	}
	public void setRevWriter(String revWriter) {
		this.revWriter = revWriter;
	}
	public String getRevContents() {
		return revContents;
	}
	public void setRevContents(String revContents) {
		this.revContents = revContents;
	}
	public String getRevDate() {
		return revDate;
	}
	public void setRevDate(String revDate) {
		this.revDate = revDate;
	}
    
    
}
