package kh.spring.dto;

import java.sql.Date;

public class EndList_ClearDTO {

	private int seq;
	private int rn;
	private int cateCode;
	private String buyer;
	private String goodWriter;
	private String title;
	private int price;
	private String write_date;
	private int goodSeq;
	public EndList_ClearDTO() {}
	public EndList_ClearDTO(int seq, int rn, int cateCode, String buyer, String goodWriter, String title, int price,
			String write_date, int goodSeq) {
		super();
		this.seq = seq;
		this.rn = rn;
		this.cateCode = cateCode;
		this.buyer = buyer;
		this.goodWriter = goodWriter;
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
	public String getBuyer() {
		return buyer;
	}
	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}
	public String getGoodWriter() {
		return goodWriter;
	}
	public void setGoodWriter(String goodWriter) {
		this.goodWriter = goodWriter;
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
