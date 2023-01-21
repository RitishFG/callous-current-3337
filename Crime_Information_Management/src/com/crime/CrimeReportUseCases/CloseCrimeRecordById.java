package com.crime.CrimeReportUseCases;

import java.util.Scanner;

import com.crime.Exception.CaseException;
import com.crime.dao.CrimeReportDao;
import com.crime.dao.CrimeReportDaoImpl;

public class CloseCrimeRecordById {

	public static void closeReport() {
		Scanner sc=new Scanner(System.in);
//		Taking input from user
		System.out.println("Enter Record ID : ");
		int id=sc.nextInt();
		
		
		CrimeReportDao crd=new CrimeReportDaoImpl();
		try {
//			Calling required method
			String message=crd.closeCrimeRecord(id);
			System.out.println(message);
		} catch (CaseException e) {
			System.out.println(e.getMessage());
		}

	}

}
