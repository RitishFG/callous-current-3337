package com.crime.Bean;

public class Officer {
	private int officer_id;
	private String first_name;
	private String last_name;
	private String gender;
	private String mobile;
	private int station_id;
	public Officer()
	{
		
	}
	public Officer(String first_name,String last_name,String gender,String mobile,int station_id)
	{
		this.first_name=first_name;
		this.last_name=last_name;
		this.gender=gender;
		this.mobile=mobile;
		this.station_id=station_id;
	}
	public int getOfficer_id() {
		return officer_id;
	}
	public void setOfficer_id(int officer_id) {
		this.officer_id = officer_id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public int getStation_id() {
		return station_id;
	}
	public void setStation_id(int station_id) {
		this.station_id = station_id;
	}
	@Override
	public String toString() {
		return "Officer [officer_id=" + officer_id + ", first_name=" + first_name + ", last_name=" + last_name
				+ ", gender=" + gender + ", mobile=" + mobile + ", station_id=" + station_id + "]";
	}
	
}
