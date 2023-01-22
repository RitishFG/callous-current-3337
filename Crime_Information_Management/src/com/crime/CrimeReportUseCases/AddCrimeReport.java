package com.crime.CrimeReportUseCases;

import java.time.LocalDate;
import java.util.Scanner;

import com.crime.Bean.Crime_Record;
import com.crime.Exception.CaseException;
import com.crime.colors.ConsoleColors;
import com.crime.dao.CrimeReportDao;
import com.crime.dao.CrimeReportDaoImpl;

public class AddCrimeReport {

	public static void addReport() {
		Scanner sc=new Scanner(System.in);
//		Taking input from user
		System.out.println("Enter Crime Type ID : ");
		int type=sc.nextInt();
		System.out.println("Enter Date : ");
		String date=sc.next();
		LocalDate ld=LocalDate.parse(date);
		System.out.println("Enter Victim Name : ");
		String name=sc.next();
		System.out.println("Enter Victime Mobile Number : ");
		String mobile=sc.next();
		System.out.println("Enter Suspect Name : ");
		String suspect=sc.next();
		sc.nextLine();
		System.out.println("Enter Description : ");
		String desc=sc.nextLine();
		
//		Creating object of crime record and setting values
		Crime_Record cr=new Crime_Record();
		cr.setDate(ld);
		cr.setDescription(desc);
		cr.setSuspect(suspect);
		cr.setType(type);
		cr.setVictim(name);
		cr.setVictim_mobile(mobile);
		
		CrimeReportDao crd=new CrimeReportDaoImpl();
		try {
//			calling required method
			String message=crd.addCrimeRecord(cr);
			System.out.println(ConsoleColors.GREEN_BACKGROUND_BRIGHT+ConsoleColors.WHITE_BOLD_BRIGHT+message+ConsoleColors.RESET);
		} catch (CaseException e) {
			System.out.println(ConsoleColors.RED_BACKGROUND_BRIGHT+ConsoleColors.WHITE_BOLD_BRIGHT+e.getMessage()+ConsoleColors.RESET);
		}

	}

}
