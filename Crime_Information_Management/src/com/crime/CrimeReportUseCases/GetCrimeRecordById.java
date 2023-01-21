package com.crime.CrimeReportUseCases;

import java.util.Scanner;

import com.crime.Bean.Crime_Record;
import com.crime.Exception.CaseException;
import com.crime.dao.CrimeReportDao;
import com.crime.dao.CrimeReportDaoImpl;

public class GetCrimeRecordById {

	public static void getReport() {
		Scanner sc=new Scanner(System.in);
//		Taking input from user
		System.out.println("Enter Record ID : ");
		int id=sc.nextInt();
		
		CrimeReportDao crd=new CrimeReportDaoImpl();
		try {
//			calling required method
			Crime_Record cr=crd.getCrimeRecordByID(id);
			System.out.println();
			System.out.println("*-----------------------------------------*");
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
		} catch (CaseException e) {
			System.out.println(e.getMessage());
		}

	}

}
