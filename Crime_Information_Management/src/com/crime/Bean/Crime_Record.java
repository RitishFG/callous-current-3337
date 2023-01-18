package com.crime.Bean;
import java.util.Date;

public class Crime_Record {
	private int cid;
	private int type;
	private Date date;
	private String victim;
	private String victim_mobile;
	private String status;
	private int officer_alloted;
	private String suspect;
	private String description;
	public Crime_Record()
	{
		
	}
	public Crime_Record(int type,Date date,String victim,String victim_mobile,String suspect,String description)
	{
		this.type=type;
		this.date=date;
		this.victim=victim;
		this.victim_mobile=victim_mobile;
		this.status="open";
		this.suspect=suspect;
		this.description=description;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getVictim() {
		return victim;
	}
	public void setVictim(String victim) {
		this.victim = victim;
	}
	public String getVictim_mobile() {
		return victim_mobile;
	}
	public void setVictim_mobile(String victim_mobile) {
		this.victim_mobile = victim_mobile;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getOfficer_alloted() {
		return officer_alloted;
	}
	public void setOfficer_alloted(int officer_alloted) {
		this.officer_alloted = officer_alloted;
	}
	public String getSuspect() {
		return suspect;
	}
	public void setSuspect(String suspect) {
		this.suspect = suspect;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Crime_Record [cid=" + cid + ", type=" + type + ", date=" + date + ", victim=" + victim
				+ ", victim_mobile=" + victim_mobile + ", status=" + status + ", officer_alloted=" + officer_alloted
				+ ", suspect=" + suspect + ", description=" + description + "]";
	}
	
}
