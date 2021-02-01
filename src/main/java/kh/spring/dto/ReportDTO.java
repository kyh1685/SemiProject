package kh.spring.dto;

public class ReportDTO {
	private int reportSeq;
	private int goodSeq;
	private String reportedUser;
	private int reportCode;
	private String reportContents;
	private String reportWriter;
	private String reportDate;
	private String reportMemo;
	public ReportDTO() {}
	public ReportDTO(int reportSeq, int goodSeq, String reportedUser, int reportCode, String reportContents,
			String reportWriter, String reportDate, String reportMemo) {
		super();
		this.reportSeq = reportSeq;
		this.goodSeq = goodSeq;
		this.reportedUser = reportedUser;
		this.reportCode = reportCode;
		this.reportContents = reportContents;
		this.reportWriter = reportWriter;
		this.reportDate = reportDate;
		this.reportMemo = reportMemo;
	}
	public int getReportSeq() {
		return reportSeq;
	}
	public void setReportSeq(int reportSeq) {
		this.reportSeq = reportSeq;
	}
	public int getGoodSeq() {
		return goodSeq;
	}
	public void setGoodSeq(int goodSeq) {
		this.goodSeq = goodSeq;
	}
	public String getReportedUser() {
		return reportedUser;
	}
	public void setReportedUser(String reportedUser) {
		this.reportedUser = reportedUser;
	}
	public int getReportCode() {
		return reportCode;
	}
	public void setReportCode(int reportCode) {
		this.reportCode = reportCode;
	}
	public String getReportContents() {
		return reportContents;
	}
	public void setReportContents(String reportContents) {
		this.reportContents = reportContents;
	}
	public String getReportWriter() {
		return reportWriter;
	}
	public void setReportWriter(String reportWriter) {
		this.reportWriter = reportWriter;
	}
	public String getReportDate() {
		return reportDate;
	}
	public void setReportDate(String reportDate) {
		this.reportDate = reportDate;
	}
	public String getReportMemo() {
		return reportMemo;
	}
	public void setReportMemo(String reportMemo) {
		this.reportMemo = reportMemo;
	}

	
	
}
