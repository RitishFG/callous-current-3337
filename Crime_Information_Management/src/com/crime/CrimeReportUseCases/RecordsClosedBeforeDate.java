package com.crime.CrimeReportUseCases;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import com.crime.Bean.Crime_Record;
import com.crime.Exception.CaseException;
import com.crime.dao.CrimeReportDao;
import com.crime.dao.CrimeReportDaoImpl;

public class RecordsClosedBeforeDate {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
//		Taking input from user
		System.out.println("Enter Date : ");
		String date=sc.next();
		LocalDate ld=LocalDate.parse(date);
		
		CrimeReportDao crd=new CrimeReportDaoImpl();
		try {
//			Calling required method
			List<Crime_Record>list=crd.getAllClosedRecordsBeforeDate(ld);
			for(Crime_Record cr:list)
			{
				System.out.println(cr);
			}
		} catch (CaseException e) {
			System.out.println(e.getMessage());
		}
	}

}