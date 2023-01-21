package com.crime.CriminalUseCases;

import java.time.LocalDate;
import java.util.Scanner;

import com.crime.Bean.Criminal;
import com.crime.Exception.CriminalException;
import com.crime.dao.CriminalDao;
import com.crime.dao.CriminalDaoImpl;

public class AddNewCriminalRecord {

	public static void addCriminal() {
		Scanner sc=new Scanner(System.in);
//		Taking input from user
		System.out.println("Enter Criminal Name        : ");
		String name=sc.next();
		System.out.println("Enter Mobile Number        : ");
		String mobile=sc.next();
		System.out.println("Enter Date of Birth        : ");
		String date=sc.next();
		LocalDate ld=LocalDate.parse(date);
		sc.nextLine();
		System.out.println("Enter Identification marks : ");
		String marks=sc.nextLine();
		System.out.println("Enter City                 : ");
		String city=sc.next();
		System.out.println("Enter Crime ID             : ");
		int id=sc.nextInt();
		
//		Creating criminal object and assigning values
		Criminal cr=new Criminal();
		cr.setCity(city);
		cr.setCrime_id(id);
		cr.setDob(ld);
		cr.setIdentification_marks(marks);
		cr.setMobile(mobile);
		cr.setName(name);
		
		CriminalDao cd=new CriminalDaoImpl();
		try {
//			calling required object
			String message=cd.addCriminalRecord(cr);
			System.out.println(message);
		} catch (CriminalException e) {
			System.out.println(e.getMessage());
		}

	}

}
