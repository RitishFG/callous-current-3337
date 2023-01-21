package com.crime.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.crime.Bean.Officer;
import com.crime.Bean.Station;
import com.crime.Exception.AdminException;
import com.crime.Exception.CaseException;
import com.crime.Exception.OfficerException;
import com.crime.Exception.StationException;
import com.crime.Util.DBUtil;

public class AdminDaoImpl implements AdminDao{

	@Override
	public boolean adminLogin(String username, String password) throws AdminException {
		boolean message=false;
//		checking username and password with final parameters defined in AdminDao
		if(username.equals(AdminDao.username) && password.equals(AdminDao.password))
		{
			message=true;
		}
		else
		{
//			throwing exception as username or password is incorrect
			throw new AdminException("Invalid Username and Password");
		}
		return message;
	}

	@Override
	public String addStation(Station s) throws StationException {
		String message="";
//		Getting connection from DBUtil Class
		Connection conn=DBUtil.getConnection();
//		Query which will perform specific operation
		String query="insert into station values(null,?,?)";
		try {
			PreparedStatement ps=conn.prepareStatement(query);
//			setting parameter values to query
			ps.setString(1, s.getStation_name());
			ps.setString(2, s.getStation_address());
//			executing the query and getting int value as return
			int x=ps.executeUpdate();
			if(x>0)
			{
//				x>0 means data was inserted without any issue
				message="Data Inserted to Station Table Successfully!";
			}
			else
			{
//				data inconsistent to store in the station table
				throw new StationException("Station data cannot be inserted with currect inconsistent values");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new StationException("Station data cannot be inserted with currect inconsistent values");
		}
		finally {
			try {
//				closing connection
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return message;
	}

	@Override
	public String addOfficer(Officer o) throws OfficerException {
		String message="";
		Connection conn=DBUtil.getConnection();
//		Getting connection from DBUtil Class
		String query="insert into officer values(null,?,?,?,?,?)";
//		Query which will perform specific operation
//		id has been passed as null because table has auto increment for officer id
		try {
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setString(1, o.getFirst_name());
			ps.setString(2, o.getLast_name());
			ps.setString(3, o.getGender());
			ps.setString(4, o.getMobile());
			ps.setInt(5, o.getStation_id());
//			setting values for query
			int x=ps.executeUpdate();
			if(x>0)
			{
//				x>0 means data has been inserted
				message="Data added successfully in Officer Records";
			}
			else
			{
//				need to throw exception
				throw new OfficerException("Officer data cannot be inserted with currect inconsistent values");
			}
		} catch (SQLException e) {
			throw new OfficerException("Officer data cannot be inserted with currect inconsistent values");
		}
		finally
		{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return message;
	}

	@Override
	public List<Officer> getAllOfficerDetails() throws OfficerException {
//		initializing list as all officer details need to be stored
		List<Officer>list=new ArrayList<>();
		Connection conn=DBUtil.getConnection();
//		Query which will perform specific operation
		String query="select * from officer";
		try {
			PreparedStatement ps=conn.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
//				creating empty officer object and setting values
				Officer o=new Officer();
//				o.setOfficer_id(rs.getInt("officer_id"));
				o.setFirst_name(rs.getString("first_name"));
				o.setGender(rs.getString("gender"));
				o.setLast_name(rs.getString("last_name"));
				o.setMobile(rs.getString("mobile"));
				o.setOfficer_id(rs.getInt("officer_id"));
				o.setStation_id(rs.getInt("station_id"));
//				adding officer object to list
				list.add(o);
			}
			if(list.isEmpty())
			{
//				if list is empty then need to throw exception
				throw new OfficerException("No Data Currently available in Officer Records");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new OfficerException("No Data Currently available in Officer Records");
		}
		finally
		{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public List<Officer> getOfficerByStationId(int id) throws OfficerException {
//		initializing list as there can be multiple officers from one station
		List<Officer>list=new ArrayList<>();
		Connection conn=DBUtil.getConnection();
//		Query which will perform specific operation
		String query="select * from officer where station_id=?";
		try {
			PreparedStatement ps=conn.prepareStatement(query);
//			setting value to query
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
//				initializing empty officer object
				Officer o=new Officer();
//				setting values to the officer object
				o.setFirst_name(rs.getString("first_name"));
				o.setGender(rs.getString("gender"));
				o.setLast_name(rs.getString("last_name"));
				o.setMobile(rs.getString("mobile"));
				o.setOfficer_id(rs.getInt("officer_id"));
				o.setStation_id(rs.getInt("station_id"));
//				adding officer object to list
				list.add(o);
			}
			if(list.isEmpty())
			{
//				if list is empty then need to throw exception
				throw new OfficerException("No Data Currently available in Officer Records with Station ID "+id);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new OfficerException("No Data Currently available in Officer Records with Station ID "+id);
		}
		finally
		{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public Officer getOfficerDetailsById(int id) throws OfficerException {
//		initializing officer object to null incase no officer available
		Officer o=null;
		Connection conn=DBUtil.getConnection();
//		Query which will perform specific operation
		String query="select * from officer where officer_id=?";
		try {
			PreparedStatement ps=conn.prepareStatement(query);
//			setting value to the query
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
//				if query returns a value then need to create officer object and set values accordingly
				o=new Officer();
				o.setFirst_name(rs.getString("first_name"));
				o.setGender(rs.getString("gender"));
				o.setLast_name(rs.getString("last_name"));
				o.setMobile(rs.getString("mobile"));
				o.setOfficer_id(rs.getInt("officer_id"));
				o.setStation_id(rs.getInt("station_id"));
			}
			else
			{
//				need to throw exception if no record is available
				throw new OfficerException("No Officer available with Officer ID: "+id);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new OfficerException("No Officer available with Officer ID: "+id);
		}
		finally
		{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return o;
	}

	@Override
	public String assignCaseToOfficer(int case_id, int officer_id) throws OfficerException, CaseException {
		String message="";
		Connection conn=DBUtil.getConnection();
//		Parent query to check if correct crime_record id is passed or not
		String query1="select * from crime_record where cid=?";
		try {
			PreparedStatement ps=conn.prepareStatement(query1);
//			setting crime_record id
			ps.setInt(1, case_id);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
//				if value is returned that means crime_record id is correct and now only case of invalid entry is if officer id is incorrect
				try
				{
					String query2="update crime_record set officer_alloted=? where cid=?";
//					Main query which will perform specific operation
					PreparedStatement ps2=conn.prepareStatement(query2);
					ps2.setInt(1, officer_id);
					ps2.setInt(2, case_id);
					int x=ps2.executeUpdate();
					if(x>0)
					{
//						if query return non zero int value that means officer id was also correct and need to return success message
						message="Officer with ID : "+officer_id+" has been alloted to Case with ID : "+case_id;
					}
					else
					{
//						officer id was incorrect
						throw new OfficerException("Invalid Officer ID : "+officer_id);
					}
				}
				catch(SQLException e)
				{
					throw new OfficerException("Invalid Officer ID : "+officer_id);
				}
			}
			else
			{
//				crime_record id was incorrect
				throw new CaseException("Invalid Case ID : "+case_id);
			}
		} catch (SQLException e) {
			throw new CaseException("Invalid Case ID : "+case_id);
		}
		finally
		{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return message;
		
	}

}
