package pack_Organiser;

public class OrganiserLogin {
	String emailId;
	String Password;
	public OrganiserLogin(String emailId, String password) {
		super();
		this.emailId = emailId;
		Password = password;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	
	
}
