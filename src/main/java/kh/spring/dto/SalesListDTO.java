package kh.spring.dto;

import java.sql.Date;

public class SalesListDTO {

	private int seq;
	private int rn;
	private int cateCode;
	private String writer;
	private String title;
	private int price;
	private String write_date;
	private int goodSeq;
	public SalesListDTO() {}
	public SalesListDTO(int seq, int rn, int cateCode, String writer, String title, int price, String write_date,
			int goodSeq) {
		super();
		this.seq = seq;
		this.rn = rn;
		this.cateCode = cateCode;
		this.writer = writer;
		this.title = title;
		this.price = price;
		this.write_date = write_date;
		this.goodSeq = goodSeq;
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
	public int getCateCode() {
		return cateCode;
	}
	public void setCateCode(int cateCode) {
		this.cateCode = cateCode;
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getWrite_date() {
		return write_date;
	}
	public void setWrite_date(String write_date) {
		this.write_date = write_date;
	}
	public int getGoodSeq() {
		return goodSeq;
	}
	public void setGoodSeq(int goodSeq) {
		this.goodSeq = goodSeq;
	}
	
	
}
