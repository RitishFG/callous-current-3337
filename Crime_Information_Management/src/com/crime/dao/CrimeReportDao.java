package com.crime.dao;

import java.time.LocalDate;
import java.util.List;
import com.crime.Bean.Crime_Record;
import com.crime.Exception.CaseException;
import com.crime.Exception.OfficerException;

public interface CrimeReportDao {
	public String addCrimeRecord(Crime_Record cr) throws CaseException;
	public Crime_Record getCrimeRecordByID(int id) throws CaseException;
	public String closeCrimeRecord(int id) throws CaseException;
	public List<Crime_Record> getAllCrimeRecords() throws CaseException;
	public List<Crime_Record> getAllOpenCrimeRecords() throws CaseException;
	public List<Crime_Record> getAllClosedCrimeRecords() throws CaseException;
	public List<Crime_Record> getAllCrimeRecordsOfCrimeType(int type) throws CaseException;
	public List<Crime_Record> getAllOpenRecordsByOfficerID(int officer_id) throws CaseException;
	public List<Crime_Record> getAllClosedRecordsByOfficerID(int officer_id) throws CaseException;
	public List<Crime_Record> getAllClosedRecordsBeforeDate(LocalDate d) throws CaseException;
}
