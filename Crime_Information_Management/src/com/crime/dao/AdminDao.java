package com.crime.dao;
import java.util.List;
import com.crime.Bean.Officer;
import com.crime.Bean.Station;
import com.crime.Exception.AdminException;
import com.crime.Exception.CaseException;
import com.crime.Exception.OfficerException;
import com.crime.Exception.StationException;

public interface AdminDao {
	public final static String username="Admin";
	public final static String password="Admin@123";
	public boolean adminLogin(String username,String password) throws AdminException;
	public String addStation(Station s) throws StationException;
	public String addOfficer(Officer o) throws OfficerException;
	public List<Officer> getAllOfficerDetails() throws OfficerException;
	public List<Officer> getOfficerByStationId(int id) throws OfficerException;
	public Officer getOfficerDetailsById(int id) throws OfficerException;
	public String assignCaseToOfficer(int case_id,int officer_id) throws OfficerException, CaseException;
	
}
