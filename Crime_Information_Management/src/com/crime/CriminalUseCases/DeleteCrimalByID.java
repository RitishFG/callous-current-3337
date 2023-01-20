package com.crime.CriminalUseCases;

import java.util.Scanner;

import com.crime.Exception.CriminalException;
import com.crime.dao.CriminalDao;
import com.crime.dao.CriminalDaoImpl;

public class DeleteCrimalByID {

	public static void deleteCriminal() {
		Scanner sc=new Scanner(System.in);
//		taking input from user
		System.out.println("Enter Criminal ID : ");
		int id=sc.nextInt();
		
		CriminalDao cd=new CriminalDaoImpl();
		try {
//			calling required method
			String message=cd.deleteCriminalRecord(id);
			System.out.println(message);
		} catch (CriminalException e) {
			System.out.println(e.getMessage());
		}

	}

}
