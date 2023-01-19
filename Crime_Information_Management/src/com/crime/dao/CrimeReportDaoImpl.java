package com.crime.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import com.crime.Bean.Crime_Record;
import com.crime.Exception.CaseException;
import com.crime.Exception.OfficerException;
import com.crime.Util.DBUtil;

public class CrimeReportDaoImpl implements CrimeReportDao{

	@Override
	public String addCrimeRecord(Crime_Record cr) throws CaseException {
		String message="";
		Connection conn=DBUtil.getConnection();
		String query="insert into crime_record values(null,?,?,?,?,?,null,?,?)";
		try {
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setInt(1, cr.getType());
			ps.setDate(2, java.sql.Date.valueOf(cr.getDate()));
			ps.setString(3,cr.getVictim());
			ps.setString(4, cr.getVictim_mobile());
			ps.setString(5, "open");
			ps.setString(6, cr.getSuspect());
			ps.setString(7, cr.getDescription());
			int x=ps.executeUpdate();
			if(x>0)
			{
				message="Crime Report has been added Successfully!";
			}
			else
			{
				throw new CaseException("Crime Report cannot be added with current inconsistent data");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new CaseException("Crime Report cannot be added with current inconsistent data");
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
	public Crime_Record getCrimeRecordByID(int id) throws CaseException {
		Crime_Record cr=null;
		Connection conn=DBUtil.getConnection();
		String query="select * from crime_record where cid=?";
		try {
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				cr=new Crime_Record();
				cr.setCid(rs.getInt("cid"));
				cr.setDate(rs.getDate("date").toLocalDate());
				cr.setDescription(rs.getString("description"));
				cr.setOfficer_alloted(rs.getInt("officer_alloted"));
				cr.setStatus(rs.getString("status"));
				cr.setSuspect(rs.getString("suspect"));
				cr.setType(rs.getInt("type"));
				cr.setVictim(rs.getString("victim"));
				cr.setVictim_mobile(rs.getString("victim_mobile"));
			}
			else
			{
				throw new CaseException("No Crime Record Available with Case ID : "+id);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new CaseException("No Crime Record Available with Case ID : "+id);
		}
		finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return cr;
	}

	@Override
	public String closeCrimeRecord(int id) throws CaseException {
		String message="";
		Connection conn=DBUtil.getConnection();
		String query="update crime_record set status=? where cid=?";
		try {
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setString(1, "closed");
			ps.setInt(2, id);
			int x=ps.executeUpdate();
			if(x>0)
			{
				message="Crime Record with ID : "+id+" has been closed";
			}
			else
			{
				throw new CaseException("Invalid Crime Report ID : "+id);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new CaseException("Invalid Crime Report ID : "+id);
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
	public List<Crime_Record> getAllCrimeRecords() throws CaseException {
		List<Crime_Record>list=new ArrayList<>();
		Connection conn=DBUtil.getConnection();
		String query="select * from crime_record";
		try {
			PreparedStatement ps=conn.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Crime_Record cr=new Crime_Record();
				cr.setCid(rs.getInt("cid"));
				cr.setDate(rs.getDate("date").toLocalDate());
				cr.setDescription(rs.getString("description"));
				cr.setOfficer_alloted(rs.getInt("officer_alloted"));
				cr.setStatus(rs.getString("status"));
				cr.setSuspect(rs.getString("suspect"));
				cr.setType(rs.getInt("type"));
				cr.setVictim(rs.getString("victim"));
				cr.setVictim_mobile(rs.getString("victim_mobile"));
				list.add(cr);
			}
			if(list.isEmpty())
			{
				throw new CaseException("No Crime Reports Available in Records");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new CaseException("No Crime Reports Available in Records");
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
	public List<Crime_Record> getAllOpenCrimeRecords() throws CaseException {
		List<Crime_Record>list=new ArrayList<>();
		Connection conn=DBUtil.getConnection();
		String query="select * from crime_record where status=?";
		try {
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setString(1, "open");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Crime_Record cr=new Crime_Record();
				cr.setCid(rs.getInt("cid"));
				cr.setDate(rs.getDate("date").toLocalDate());
				cr.setDescription(rs.getString("description"));
				cr.setOfficer_alloted(rs.getInt("officer_alloted"));
				cr.setStatus(rs.getString("status"));
				cr.setSuspect(rs.getString("suspect"));
				cr.setType(rs.getInt("type"));
				cr.setVictim(rs.getString("victim"));
				cr.setVictim_mobile(rs.getString("victim_mobile"));
				list.add(cr);
			}
			if(list.isEmpty())
			{
				throw new CaseException("No Open record available");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new CaseException("No Open record available");
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
	public List<Crime_Record> getAllClosedCrimeRecords() throws CaseException {
		List<Crime_Record>list=new ArrayList<>();
		Connection conn=DBUtil.getConnection();
		String query="select * from crime_record where status=?";
		try {
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setString(1, "closed");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Crime_Record cr=new Crime_Record();
				cr.setCid(rs.getInt("cid"));
				cr.setDate(rs.getDate("date").toLocalDate());
				cr.setDescription(rs.getString("description"));
				cr.setOfficer_alloted(rs.getInt("officer_alloted"));
				cr.setStatus(rs.getString("status"));
				cr.setSuspect(rs.getString("suspect"));
				cr.setType(rs.getInt("type"));
				cr.setVictim(rs.getString("victim"));
				cr.setVictim_mobile(rs.getString("victim_mobile"));
				list.add(cr);
			}
			if(list.isEmpty())
			{
				throw new CaseException("No Closed record available");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new CaseException("No Closed record available");
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
	public List<Crime_Record> getAllCrimeRecordsOfCrimeType(int type) throws CaseException {
		List<Crime_Record>list=new ArrayList<>();
		Connection conn=DBUtil.getConnection();
		String query="select * from crime_record where type=?";
		try {
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setInt(1, type);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Crime_Record cr=new Crime_Record();
				cr.setCid(rs.getInt("cid"));
				cr.setDate(rs.getDate("date").toLocalDate());
				cr.setDescription(rs.getString("description"));
				cr.setOfficer_alloted(rs.getInt("officer_alloted"));
				cr.setStatus(rs.getString("status"));
				cr.setSuspect(rs.getString("suspect"));
				cr.setType(rs.getInt("type"));
				cr.setVictim(rs.getString("victim"));
				cr.setVictim_mobile(rs.getString("victim_mobile"));
				list.add(cr);
			}
			if(list.isEmpty())
			{
				throw new CaseException("No Record Available for Crime Type : "+type);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new CaseException("No Record Available for Crime Type : "+type);
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
	public List<Crime_Record> getAllOpenRecordsByOfficerID(int officer_id) throws CaseException {
		List<Crime_Record>list=new ArrayList<>();
		Connection conn=DBUtil.getConnection();
		String query="select * from crime_record where officer_alloted=? and status=?";
		try {
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setInt(1, officer_id);
			ps.setString(2, "open");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Crime_Record cr=new Crime_Record();
				cr.setCid(rs.getInt("cid"));
				cr.setDate(rs.getDate("date").toLocalDate());
				cr.setDescription(rs.getString("description"));
				cr.setOfficer_alloted(rs.getInt("officer_alloted"));
				cr.setStatus(rs.getString("status"));
				cr.setSuspect(rs.getString("suspect"));
				cr.setType(rs.getInt("type"));
				cr.setVictim(rs.getString("victim"));
				cr.setVictim_mobile(rs.getString("victim_mobile"));
				list.add(cr);
			}
			if(list.isEmpty())
			{
				throw new CaseException("No Open Record Available alloted to Officer ID : "+officer_id);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new CaseException("No Open Record Available alloted to Officer ID : "+officer_id);
		}
		finally {
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
	public List<Crime_Record> getAllClosedRecordsByOfficerID(int officer_id) throws CaseException {
		List<Crime_Record>list=new ArrayList<>();
		Connection conn=DBUtil.getConnection();
		String query="select * from crime_record where officer_alloted=? and status=?";
		try {
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setInt(1, officer_id);
			ps.setString(2, "closed");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Crime_Record cr=new Crime_Record();
				cr.setCid(rs.getInt("cid"));
				cr.setDate(rs.getDate("date").toLocalDate());
				cr.setDescription(rs.getString("description"));
				cr.setOfficer_alloted(rs.getInt("officer_alloted"));
				cr.setStatus(rs.getString("status"));
				cr.setSuspect(rs.getString("suspect"));
				cr.setType(rs.getInt("type"));
				cr.setVictim(rs.getString("victim"));
				cr.setVictim_mobile(rs.getString("victim_mobile"));
				list.add(cr);
			}
			if(list.isEmpty())
			{
				throw new CaseException("No Open Record Available alloted to Officer ID : "+officer_id);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new CaseException("No Open Record Available alloted to Officer ID : "+officer_id);
		}
		finally
		{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public List<Crime_Record> getAllClosedRecordsBeforeDate(LocalDate d) throws CaseException {
		List<Crime_Record>list=new ArrayList<>();
		Connection conn=DBUtil.getConnection();
		String query="select * from crime_record where date<? and status=?";
		try {
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setDate(1, java.sql.Date.valueOf(d));
			ps.setString(2, "closed");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Crime_Record cr=new Crime_Record();
				cr.setCid(rs.getInt("cid"));
				cr.setDate(rs.getDate("date").toLocalDate());
				cr.setDescription(rs.getString("description"));
				cr.setOfficer_alloted(rs.getInt("officer_alloted"));
				cr.setStatus(rs.getString("status"));
				cr.setSuspect(rs.getString("suspect"));
				cr.setType(rs.getInt("type"));
				cr.setVictim(rs.getString("victim"));
				cr.setVictim_mobile(rs.getString("victim_mobile"));
				list.add(cr);
			}
			if(list.isEmpty())
			{
				throw new CaseException("No Record Available");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new CaseException("No Record Available");
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
