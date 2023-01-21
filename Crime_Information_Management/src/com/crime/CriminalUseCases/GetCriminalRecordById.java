package com.crime.CriminalUseCases;

import java.util.Scanner;

import com.crime.Bean.Criminal;
import com.crime.Exception.CriminalException;
import com.crime.dao.CriminalDao;
import com.crime.dao.CriminalDaoImpl;

public class GetCriminalRecordById {

	public static void viewCriminalById() {
		Scanner sc=new Scanner(System.in);
//		Taking input from user
		System.out.println("Enter Criminal ID : ");
		int id=sc.nextInt();
		
		CriminalDao cd=new CriminalDaoImpl();
		try {
//			Calling required method
			Criminal c=cd.getCriminalById(id);
			System.out.println();
			System.out.println("*----------------------------------------------*");
			System.out.println("ID                   : "+c.getCriminal_id());
			System.out.println("Name                 : "+c.getName());
			System.out.println("Mobile               : "+c.getMobile());
			System.out.println("Identification Marks : "+c.getIdentification_marks());
			System.out.println("City                 : "+c.getCity());
			System.out.println("Crime Report ID      : "+c.getCrime_id());
			System.out.println("*----------------------------------------------*");
		} catch (CriminalException e) {
			System.out.println(e.getMessage());
		}
	}

}
