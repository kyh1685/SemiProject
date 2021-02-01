package kh.spring.dto;

import java.sql.Date;

public class BasketDTO {
	private int seq;
	private int rn;
	private int location;
	private String id;
	private String title;
	private int price;
	private Date reg_date;
	
	public BasketDTO() {}

	public BasketDTO(int seq, int rn, int location, String id, String title, int price, Date reg_date) {
		this.seq = seq;
		this.rn = rn;
		this.location = location;
		this.id = id;
		this.title = title;
		this.price = price;
		this.reg_date = reg_date;
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

	public int getLocation() {
		return location;
	}

	public void setLocation(int location) {
		this.location = location;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public Date getReg_date() {
		return reg_date;
	}

	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}

	
}
