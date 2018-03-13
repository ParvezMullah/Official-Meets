package myJavaClasses;

import java.io.InputStream;
import java.util.Base64;

public class Event {
	private int eventId;
	private String organiserEmailId;
	private String Title;
	private String Description;
	private String Date;
	private String Time;
	private String Category;
	private String fees;
	private String otherInfo;
	private String Venue;
	private int goingCount;
	private int interestedCount;
	private byte[] Picture=null;
	private String base64img;
	public Event(String organiserEmailId, String title, String description, String date, String time, String category,
			String fees, String otherInfo, String venue, int goingCount, int interestedCount, byte[] picture) {
		super();
		this.organiserEmailId = organiserEmailId;
		Title = title;
		Description = description;
		Date = date;
		Time = time;
		Category = category;
		this.fees = fees;
		this.otherInfo = otherInfo;
		Venue = venue;
		this.goingCount = goingCount;
		this.interestedCount = interestedCount;
		Picture = picture;
	}
	public Event(int eventId, String organiserEmailId, String title, String description, String date, String time,
			String category, String fees, String otherInfo, String venue, int goingCount, int interestedCount,
			byte[] picture) {
		super();
		this.eventId = eventId;
		this.organiserEmailId = organiserEmailId;
		Title = title;
		Description = description;
		Date = date;
		Time = time;
		Category = category;
		this.fees = fees;
		this.otherInfo = otherInfo;
		Venue = venue;
		this.goingCount = goingCount;
		this.interestedCount = interestedCount;
		Picture = picture;
	}
	public int getEventId() {
		return eventId;
	}
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
	public String getOrganiserEmailId() {
		return organiserEmailId;
	}
	public void setOrganiserEmailId(String organiserEmailId) {
		this.organiserEmailId = organiserEmailId;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public String getTime() {
		return Time;
	}
	public void setTime(String time) {
		Time = time;
	}
	public String getCategory() {
		return Category;
	}
	public void setCategory(String category) {
		Category = category;
	}
	public String getFees() {
		return fees;
	}
	public void setFees(String fees) {
		this.fees = fees;
	}
	public String getOtherInfo() {
		return otherInfo;
	}
	public void setOtherInfo(String otherInfo) {
		this.otherInfo = otherInfo;
	}
	public String getVenue() {
		return Venue;
	}
	public void setVenue(String venue) {
		Venue = venue;
	}
	public int getGoingCount() {
		return goingCount;
	}
	public void setGoingCount(int goingCount) {
		this.goingCount = goingCount;
	}
	public int getInterestedCount() {
		return interestedCount;
	}
	public void setInterestedCount(int interestedCount) {
		this.interestedCount = interestedCount;
	}
	public byte[] getPicture() {
		return Picture;
	}
	public void setPicture(byte[] picture) {
		Picture = picture;
	}
	public String getBase64Image()
	{
		return base64img;
	}
	public void setBase64Image(String picture)
	{
		this.base64img=picture;
	}
	@Override
	public String toString() {
		return "Event [eventId=" + eventId + ", organiserEmailId=" + organiserEmailId + ", Title=" + Title
				+ ", Description=" + Description + ", Date=" + Date + ", Time=" + Time + ", Category=" + Category
				+ ", fees=" + fees + ", otherInfo=" + otherInfo + ", Venue=" + Venue + ", goingCount=" + goingCount
				+ ", interestedCount=" + interestedCount + ", Picture=" + Picture + "]";
	}
	
	
	
}
