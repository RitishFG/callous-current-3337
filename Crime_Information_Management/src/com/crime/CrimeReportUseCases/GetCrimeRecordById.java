package com.crime.CrimeReportUseCases;

import java.util.Scanner;

import com.crime.Bean.Crime_Record;
import com.crime.Exception.CaseException;
import com.crime.dao.CrimeReportDao;
import com.crime.dao.CrimeReportDaoImpl;

public class GetCrimeRecordById {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
//		Taking input from user
		System.out.println("Enter Record ID : ");
		int id=sc.nextInt();
		
		CrimeReportDao crd=new CrimeReportDaoImpl();
		try {
//			calling required method
			Crime_Record cr=crd.getCrimeRecordByID(id);
			System.out.println(cr);
		} catch (CaseException e) {
			System.out.println(e.getMessage());
		}

	}

}
