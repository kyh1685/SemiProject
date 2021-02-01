package kh.spring.dto;

public class MembersDTO {
	private String chk;
	private String id;
	private String pw;
	private String email;
	private String black_list;
	private String admin;
	private int mileage;
	private String name;
	private String contact;
	
	public MembersDTO() {}

	public MembersDTO(String chk, String id, String pw, String email, String black_list, String admin, int mileage,
			String name, String contact) {
		this.chk = chk;
		this.id = id;
		this.pw = pw;
		this.email = email;
		this.black_list = black_list;
		this.admin = admin;
		this.mileage = mileage;
		this.name = name;
		this.contact = contact;
	}

	public String getChk() {
		return chk;
	}

	public void setChk(String chk) {
		this.chk = chk;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBlack_list() {
		return black_list;
	}

	public void setBlack_list(String black_list) {
		this.black_list = black_list;
	}

	public String getAdmin() {
		return admin;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
	}

	public int getMileage() {
		return mileage;
	}

	public void setMileage(int mileage) {
		this.mileage = mileage;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}
	
	
	
	
}
