package com.crime.CrimeReportUseCases;

import java.util.List;
import java.util.Scanner;

import com.crime.Bean.Crime_Record;
import com.crime.Exception.CaseException;
import com.crime.dao.CrimeReportDao;
import com.crime.dao.CrimeReportDaoImpl;

public class ClosedRecordsByOfficerId {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
//		Taking input from user
		System.out.println("Enter Officer ID : ");
		int id=sc.nextInt();
		
		CrimeReportDao crd=new CrimeReportDaoImpl();
		try {
//			Calling required method
			List<Crime_Record> list=crd.getAllClosedRecordsByOfficerID(id);
			for(Crime_Record cr:list)
			{
				System.out.println(cr);
			}
		} catch (CaseException e) {
			System.out.println(e.getMessage());
		}

	}

}
