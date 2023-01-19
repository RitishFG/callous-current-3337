package com.crime.dao;

import java.util.List;

import com.crime.Bean.Criminal;
import com.crime.Exception.CriminalException;

public interface CriminalDao {
	public String addCriminalRecord(Criminal c) throws CriminalException;
	public String deleteCriminalRecord(int id) throws CriminalException;
	public List<Criminal> getAllCriminalRecords() throws CriminalException;
	public Criminal getCriminalById(int id) throws CriminalException;
	public List<Criminal> getCriminalRecordsCrimeTypeWise(int type) throws CriminalException;
}
