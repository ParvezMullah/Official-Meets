package myJavaClasses;

public class User {
	
	private String name;
	private String email;
	private String profileUrl;
	
	
	public User(String name, String email,String profileUrl) {
		super();
		this.name = name;
		this.email = email;
		this.profileUrl=profileUrl;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getProfileUrl()
	{
		return profileUrl;
	}
	
	public void setProfileUrl(String profileUrl)
	{
		this.profileUrl=profileUrl;
	}


	@Override
	public String toString() {
		return "User [name=" + name + ", email=" + email + ", profileUrl=" + profileUrl + "]";
	}

	
}
