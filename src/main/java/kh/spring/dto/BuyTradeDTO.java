package kh.spring.dto;

public class BuyTradeDTO {
	private int seq;
	private int cateCode;
	private String goodWriter;
	private String buyer;
	private String goodName;
	private String req;
	private String cf;
	private int price;	
	private int goodSeq;
	public BuyTradeDTO() {}
	public BuyTradeDTO(int seq, int cateCode, String goodWriter, String buyer, String goodName, String req, String cf,
			int price, int goodSeq) {
		super();
		this.seq = seq;
		this.cateCode = cateCode;
		this.goodWriter = goodWriter;
		this.buyer = buyer;
		this.goodName = goodName;
		this.req = req;
		this.cf = cf;
		this.price = price;
		this.goodSeq = goodSeq;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public int getCateCode() {
		return cateCode;
	}
	public void setCateCode(int cateCode) {
		this.cateCode = cateCode;
	}
	public String getGoodWriter() {
		return goodWriter;
	}
	public void setGoodWriter(String goodWriter) {
		this.goodWriter = goodWriter;
	}
	public String getBuyer() {
		return buyer;
	}
	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}
	public String getGoodName() {
		return goodName;
	}
	public void setGoodName(String goodName) {
		this.goodName = goodName;
	}
	public String getReq() {
		return req;
	}
	public void setReq(String req) {
		this.req = req;
	}
	public String getCf() {
		return cf;
	}
	public void setCf(String cf) {
		this.cf = cf;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getGoodSeq() {
		return goodSeq;
	}
	public void setGoodSeq(int goodSeq) {
		this.goodSeq = goodSeq;
	}
	
	
}
