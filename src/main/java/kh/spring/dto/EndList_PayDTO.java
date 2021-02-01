package kh.spring.dto;

import java.sql.Date;

public class EndList_PayDTO {

	private int seq;
	private int rn;
	private String id;
	private int mileage;
	private String goodName;
	private int value;
	private Date reg_date;
	private int goodSeq;
	public EndList_PayDTO() {}
	public EndList_PayDTO(int seq, int rn, String id, int mileage, String goodName, int value, Date reg_date,
			int goodSeq) {
		super();
		this.seq = seq;
		this.rn = rn;
		this.id = id;
		this.mileage = mileage;
		this.goodName = goodName;
		this.value = value;
		this.reg_date = reg_date;
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getMileage() {
		return mileage;
	}
	public void setMileage(int mileage) {
		this.mileage = mileage;
	}
	public String getGoodName() {
		return goodName;
	}
	public void setGoodName(String goodName) {
		this.goodName = goodName;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public Date getReg_date() {
		return reg_date;
	}
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
	public int getGoodSeq() {
		return goodSeq;
	}
	public void setGoodSeq(int goodSeq) {
		this.goodSeq = goodSeq;
	}
	
	
	
}
