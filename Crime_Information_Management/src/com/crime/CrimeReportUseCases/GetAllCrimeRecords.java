package com.crime.CrimeReportUseCases;

import java.util.List;

import com.crime.Bean.Crime_Record;
import com.crime.Exception.CaseException;
import com.crime.dao.CrimeReportDao;
import com.crime.dao.CrimeReportDaoImpl;

public class GetAllCrimeRecords {

	public static void main(String[] args) {
		CrimeReportDao crd=new CrimeReportDaoImpl();
		try {
//			Calling required method
			List<Crime_Record>list=crd.getAllCrimeRecords();
			for(Crime_Record cr:list)
			{
				System.out.println(cr);
			}
		} catch (CaseException e) {
			System.out.println(e.getMessage());
		}

	}

}
