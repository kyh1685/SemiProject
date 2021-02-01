package kh.spring.dto;

public class TradeDTO {
	private int seq;
	private int cateCode;
	private String buyer;
	private String seller;
	private String title;
	private String buyer_req;
	private String seller_cfm;
	private int price;
	private int goodSeq;
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
	public String getBuyer() {
		return buyer;
	}
	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}
	public String getSeller() {
		return seller;
	}
	public void setSeller(String seller) {
		this.seller = seller;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBuyer_req() {
		return buyer_req;
	}
	public void setBuyer_req(String buyer_req) {
		this.buyer_req = buyer_req;
	}
	public String getSeller_cfm() {
		return seller_cfm;
	}
	public void setSeller_cfm(String seller_cfm) {
		this.seller_cfm = seller_cfm;
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
	public TradeDTO(int seq, int cateCode, String buyer, String seller, String title, String buyer_req,
			String seller_cfm, int price, int goodSeq) {
		super();
		this.seq = seq;
		this.cateCode = cateCode;
		this.buyer = buyer;
		this.seller = seller;
		this.title = title;
		this.buyer_req = buyer_req;
		this.seller_cfm = seller_cfm;
		this.price = price;
		this.goodSeq = goodSeq;
	}
	public TradeDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
}
