package kh.spring.dto;

import java.sql.Date;

import org.apache.ibatis.session.SqlSession;

public class GoodsDTO {
	
private SqlSession session;
	private String chk;
	private int goodSeq;
	private int rn;
	private String goodWriter;
	private String goodName;
	private int cateCode;
	private int goodPrice;
	private String goodDes;
	private String goodImg;
	private String goodDate;
	private int goodViewCount;
	private String goodLike;
	public GoodsDTO() {}
	public GoodsDTO(SqlSession session, String chk, int goodSeq, int rn, String goodWriter, String goodName,
			int cateCode, int goodPrice, String goodDes, String goodImg, String goodDate, int goodViewCount,
			String goodLike) {
		this.session = session;
		this.chk = chk;
		this.goodSeq = goodSeq;
		this.rn = rn;
		this.goodWriter = goodWriter;
		this.goodName = goodName;
		this.cateCode = cateCode;
		this.goodPrice = goodPrice;
		this.goodDes = goodDes;
		this.goodImg = goodImg;
		this.goodDate = goodDate;
		this.goodViewCount = goodViewCount;
		this.goodLike = goodLike;
	}
	public SqlSession getSession() {
		return session;
	}
	public void setSession(SqlSession session) {
		this.session = session;
	}
	public String getChk() {
		return chk;
	}
	public void setChk(String chk) {
		this.chk = chk;
	}
	public int getGoodSeq() {
		return goodSeq;
	}
	public void setGoodSeq(int goodSeq) {
		this.goodSeq = goodSeq;
	}
	public int getRn() {
		return rn;
	}
	public void setRn(int rn) {
		this.rn = rn;
	}
	public String getGoodWriter() {
		return goodWriter;
	}
	public void setGoodWriter(String goodWriter) {
		this.goodWriter = goodWriter;
	}
	public String getGoodName() {
		return goodName;
	}
	public void setGoodName(String goodName) {
		this.goodName = goodName;
	}
	public int getCateCode() {
		return cateCode;
	}
	public void setCateCode(int cateCode) {
		this.cateCode = cateCode;
	}
	public int getGoodPrice() {
		return goodPrice;
	}
	public void setGoodPrice(int goodPrice) {
		this.goodPrice = goodPrice;
	}
	public String getGoodDes() {
		return goodDes;
	}
	public void setGoodDes(String goodDes) {
		this.goodDes = goodDes;
	}
	public String getGoodImg() {
		return goodImg;
	}
	public void setGoodImg(String goodImg) {
		this.goodImg = goodImg;
	}
	public String getGoodDate() {
		return goodDate;
	}
	public void setGoodDate(String goodDate) {
		this.goodDate = goodDate;
	}
	public int getGoodViewCount() {
		return goodViewCount;
	}
	public void setGoodViewCount(int goodViewCount) {
		this.goodViewCount = goodViewCount;
	}
	public String getGoodLike() {
		return goodLike;
	}
	public void setGoodLike(String goodLike) {
		this.goodLike = goodLike;
	}
	

	
	
}
