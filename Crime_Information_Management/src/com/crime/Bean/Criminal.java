package com.crime.Bean;
import java.time.LocalDate;
import java.util.Date;

public class Criminal {
	private int criminal_id;
	private String name;
	private String mobile;
	private LocalDate dob;
	private String identification_marks;
	private String city;
	private int crime_id;
	public Criminal()
	{
		
	}
	public Criminal(String name,String mobile,LocalDate dob,String identification_marks,String city,int crime_id)
	{
		this.name=name;
		this.mobile=mobile;
		this.dob=dob;
		this.identification_marks=identification_marks;
		this.city=city;
		this.crime_id=crime_id;
	}
	public int getCriminal_id() {
		return criminal_id;
	}
	public void setCriminal_id(int criminal_id) {
		this.criminal_id = criminal_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public String getIdentification_marks() {
		return identification_marks;
	}
	public void setIdentification_marks(String identification_marks) {
		this.identification_marks = identification_marks;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getCrime_id() {
		return crime_id;
	}
	public void setCrime_id(int crime_id) {
		this.crime_id = crime_id;
	}
	@Override
	public String toString() {
		return "Criminal [criminal_id=" + criminal_id + ", name=" + name + ", mobile=" + mobile + ", dob=" + dob
				+ ", identification_marks=" + identification_marks + ", city=" + city + ", crime_id=" + crime_id + "]";
	}
	
}
