package com.crime.Bean;

public class Station {
	private int station_id;
	private String station_name;
	private String station_address;
	public Station()
	{
		
	}
	public Station(String station_name,String station_address)
	{
		this.station_name=station_name;
		this.station_address=station_address;
	}
	public int getStation_id() {
		return station_id;
	}
	public void setStation_id(int station_id) {
		this.station_id = station_id;
	}
	public String getStation_name() {
		return station_name;
	}
	public void setStation_name(String station_name) {
		this.station_name = station_name;
	}
	public String getStation_address() {
		return station_address;
	}
	public void setStation_address(String station_address) {
		this.station_address = station_address;
	}
	@Override
	public String toString() {
		return "Station [station_id=" + station_id + ", station_name=" + station_name + ", station_address="
				+ station_address + "]";
	}
	
}
