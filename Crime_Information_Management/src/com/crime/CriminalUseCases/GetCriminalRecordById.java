package com.crime.CriminalUseCases;

import java.util.Scanner;

import com.crime.Bean.Criminal;
import com.crime.Exception.CriminalException;
import com.crime.dao.CriminalDao;
import com.crime.dao.CriminalDaoImpl;

public class GetCriminalRecordById {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
//		Taking input from user
		System.out.println("Enter Criminal ID : ");
		int id=sc.nextInt();
		
		CriminalDao cd=new CriminalDaoImpl();
		try {
//			Calling required method
			Criminal c=cd.getCriminalById(id);
			System.out.println(c);
		} catch (CriminalException e) {
			System.out.println(e.getMessage());
		}
	}

}
