package com.crime.CrimeReportUseCases;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import com.crime.Bean.Crime_Record;
import com.crime.Exception.CaseException;
import com.crime.dao.CrimeReportDao;
import com.crime.dao.CrimeReportDaoImpl;

public class RecordsClosedBeforeDate {

	public static void reportsBeforeDate() {
		Scanner sc=new Scanner(System.in);
//		Taking input from user
		System.out.println("Enter Date : ");
		String date=sc.next();
		LocalDate ld=LocalDate.parse(date);
		
		CrimeReportDao crd=new CrimeReportDaoImpl();
		try {
//			Calling required method
			List<Crime_Record>list=crd.getAllClosedRecordsBeforeDate(ld);
			System.out.println();
			System.out.println("*-----------------------------------------*");
			for(Crime_Record cr:list)
			{
				System.out.println("ID              : "+cr.getCid());
				System.out.println("Type            : "+cr.getType());
				System.out.println("Date            : "+cr.getDate());
				System.out.println("Victim Name     : "+cr.getVictim());
				System.out.println("Victim Contact  : "+cr.getVictim_mobile());
				System.out.println("Status          : "+cr.getStatus());
				System.out.println("Officer Alloted : "+cr.getOfficer_alloted());
				System.out.println("Suspect Name    : "+cr.getSuspect());
				System.out.println("Description     : "+cr.getDescription());
				System.out.println("*-----------------------------------------*");
			}
		} catch (CaseException e) {
			System.out.println(e.getMessage());
		}
	}

}
