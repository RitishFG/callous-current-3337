package com.crime.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.crime.Bean.Criminal;
import com.crime.Exception.CriminalException;
import com.crime.Util.DBUtil;

public class CriminalDaoImpl implements CriminalDao{

	@Override
	public String addCriminalRecord(Criminal c) throws CriminalException {
		String message="";
		Connection conn=DBUtil.getConnection();
//		query to perform required operation
		String query="insert into criminal_record values(null,?,?,?,?,?,?)";
		try {
			PreparedStatement ps=conn.prepareStatement(query);
//			assigning values
			ps.setString(1, c.getName());
			ps.setString(2, c.getMobile());
			ps.setDate(3, java.sql.Date.valueOf(c.getDob()));
			ps.setString(4, c.getIdentification_marks());
			ps.setString(5, c.getCity());
			ps.setInt(6, c.getCrime_id());
			int x=ps.executeUpdate();
			if(x>0)
			{
//				record inserted
				message="Criminal Record has been added Successfully";
			}
			else
			{
//				need to throw exception
				throw new CriminalException("Criminal data cannot be inserted with currect inconsistent values");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new CriminalException("Criminal data cannot be inserted with currect inconsistent values");
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

	@Override
	public String deleteCriminalRecord(int id) throws CriminalException {
		String message="";
		Connection conn=DBUtil.getConnection();
//		query to perform required operation
		String query="delete from criminal_record where criminal_id=?";
		try {
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setInt(1, id);
			int x=ps.executeUpdate();
			if(x>0)
			{
//				successful
				message="Criminal with ID "+id+" has been deleted from Records";
			}
			else
			{
//				need to throw exception
				throw new CriminalException("No Criminal with ID "+id+" available in Records");
			}
		} catch (SQLException e) {
			throw new CriminalException("No Criminal with ID "+id+" available in Records");
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

	@Override
	public List<Criminal> getAllCriminalRecords() throws CriminalException {
		List<Criminal>list=new ArrayList<>();
		Connection conn=DBUtil.getConnection();
//		query to perfrom requried operation
		String query="select * from criminal_record";
		try {
			PreparedStatement ps=conn.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
//				storing values in list
				Criminal c=new Criminal();
				c.setCity(rs.getString("city"));
				c.setCrime_id(rs.getInt("crime_id"));
				c.setCriminal_id(rs.getInt("criminal_id"));
				c.setDob(rs.getDate("dob").toLocalDate());
				c.setIdentification_marks(rs.getString("identification_marks"));
				c.setMobile(rs.getString("mobile"));
				c.setName(rs.getString("name"));
				list.add(c);
			}
			if(list.isEmpty())
			{
//				unsuccessful
				throw new CriminalException("No Criminal Record Available");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new CriminalException("No Criminal Record Available");
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
	public Criminal getCriminalById(int id) throws CriminalException {
		Criminal c=null;
		Connection conn=DBUtil.getConnection();
//		query to perfrom required operation
		String query="select * from criminal_record where criminal_id=?";
		try {
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
//				storing criminal object to list
				c=new Criminal();
				c.setCity(rs.getString("city"));
				c.setCrime_id(rs.getInt("crime_id"));
				c.setCriminal_id(rs.getInt("criminal_id"));
				c.setDob(rs.getDate("dob").toLocalDate());
				c.setIdentification_marks(rs.getString("identification_marks"));
				c.setMobile(rs.getString("mobile"));
				c.setName(rs.getString("name"));
				
			}
			else
			{
//				need to throw exception
				throw new CriminalException("No Criminal Record Available with ID "+id);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new CriminalException("No Criminal Record Available with ID "+id);
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
		return c;
	}

	@Override
	public List<Criminal> getCriminalRecordsCrimeTypeWise(int type) throws CriminalException {
		List<Criminal>list=new ArrayList<>();
		Connection conn=DBUtil.getConnection();
//		query to perform required operation
		String query="select c.criminal_id,c.name,c.mobile,c.dob,c.identification_marks,c.city,c.crime_id from criminal_record c inner join crime_record cr on c.crime_id=cr.cid where cr.type=?";
		try {
			PreparedStatement ps=conn.prepareStatement(query);
//			setting values
			ps.setInt(1, type);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
//				storing criminal object in list
				Criminal c=new Criminal();
				c.setCity(rs.getString("city"));
				c.setCrime_id(rs.getInt("crime_id"));
				c.setCriminal_id(rs.getInt("criminal_id"));
				c.setDob(rs.getDate("dob").toLocalDate());
				c.setIdentification_marks(rs.getString("identification_marks"));
				c.setMobile(rs.getString("mobile"));
				c.setName(rs.getString("name"));
				list.add(c);
			}
			if(list.isEmpty())
			{
//				need to throw exception
				throw new CriminalException("No Record Available of Criminals With Crime Type "+type);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new CriminalException("No Record Available of Criminals With Crime Type "+type);
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

}
