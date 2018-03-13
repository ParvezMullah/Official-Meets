package myJavaClasses;

import java.io.InputStream;

public class Organiser {
	
	private String emailId;
	private String firstName;
	private String lastName;
	private String Password;
	private String organizationName;
	private String contactNumber;
	private int isLoginable=0;
	private InputStream profilePicture=null;
	private String Designation;
	
	public Organiser(String firstName, String lastName, String password, String organizationName, String contactNumber,
			int isLoginable, InputStream profilePicture, String designation) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		Password = password;
		this.organizationName = organizationName;
		this.contactNumber = contactNumber;
		this.isLoginable = isLoginable;
		this.profilePicture = profilePicture;
		Designation = designation;
	}

	public Organiser(String email, String firstName, String lastName, String password, String organizationName,
			String contactNumber, int isLoginable, InputStream profilePicture, String designation) {
		super();
		this.emailId = email;
		this.firstName = firstName;
		this.lastName = lastName;
		Password = password;
		this.organizationName = organizationName;
		this.contactNumber = contactNumber;
		this.isLoginable = isLoginable;
		this.profilePicture = profilePicture;
		Designation = designation;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public int getIsLoginable() {
		return isLoginable;
	}

	public void setIsLoginable(int isLoginable) {
		this.isLoginable = isLoginable;
	}

	public InputStream getProfilePicture() {
		return profilePicture;
	}

	public void setProfilePicture(InputStream profilePicture) {
		this.profilePicture = profilePicture;
	}

	public String getDesignation() {
		return Designation;
	}

	public void setDesignation(String designation) {
		Designation = designation;
	}

	@Override
	public String toString() {
		return "Organiser [emailId=" + emailId + ", firstName=" + firstName + ", lastName=" + lastName + ", Password="
				+ Password + ", organizationName=" + organizationName + ", contactNumber=" + contactNumber
				+ ", isLoginable=" + isLoginable + ", profilePicture=" + profilePicture + ", Designation=" + Designation
				+ "]";
	}
	

}
