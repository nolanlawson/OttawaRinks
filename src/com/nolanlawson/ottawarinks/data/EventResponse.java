package com.nolanlawson.ottawarinks.data;

public class EventResponse {

	private int dayNumber;
	private String endDate;
	private String endTime;
	private String sessionType;
	private String location;
	private String alternativeLocation;
	private String locationMap;
	private String startDate;
	private String startTime;
	public int getDayNumber() {
		return dayNumber;
	}
	public void setDayNumber(int dayNumber) {
		this.dayNumber = dayNumber;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getSessionType() {
		return sessionType;
	}
	public void setSessionType(String sessionType) {
		this.sessionType = sessionType;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getAlternativeLocation() {
		return alternativeLocation;
	}
	public void setAlternativeLocation(String alternativeLocation) {
		this.alternativeLocation = alternativeLocation;
	}
	public String getLocationMap() {
		return locationMap;
	}
	public void setLocationMap(String locationMap) {
		this.locationMap = locationMap;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	@Override
	public String toString() {
		return "EventResponse [dayNumber=" + dayNumber + ", endDate=" + endDate
				+ ", endTime=" + endTime + ", sessionType=" + sessionType
				+ ", location=" + location + ", alternativeLocation="
				+ alternativeLocation + ", locationMap=" + locationMap
				+ ", startDate=" + startDate + ", startTime=" + startTime + "]";
	}
}
