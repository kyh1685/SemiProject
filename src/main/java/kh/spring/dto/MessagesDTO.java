package kh.spring.dto;

public class MessagesDTO {

	private int seq;
	private int rn;
	private String sender;
	private String receiver;
	private String title;
	private String contents;
	private String read;
	private String admin;
	private String write_date;
	public MessagesDTO() {}
	public MessagesDTO(int seq, int rn, String sender, String receiver, String title, String contents, String read,
			String admin, String write_date) {
		this.seq = seq;
		this.rn = rn;
		this.sender = sender;
		this.receiver = receiver;
		this.title = title;
		this.contents = contents;
		this.read = read;
		this.admin = admin;
		this.write_date = write_date;
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
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
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
	public String getRead() {
		return read;
	}
	public void setRead(String read) {
		this.read = read;
	}
	public String getAdmin() {
		return admin;
	}
	public void setAdmin(String admin) {
		this.admin = admin;
	}
	public String getWrite_date() {
		return write_date;
	}
	public void setWrite_date(String write_date) {
		this.write_date = write_date;
	}
	
	
}
