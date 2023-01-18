package com.crime.UseCases;

import java.util.Scanner;

import com.crime.Exception.CaseException;
import com.crime.Exception.OfficerException;
import com.crime.dao.AdminDao;
import com.crime.dao.AdminDaoImpl;

public class AssignCase {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Case ID : ");
		int case_id=sc.nextInt();
		System.out.println("Enter Officer ID : ");
		int officer_id=sc.nextInt();
		
		AdminDao ad=new AdminDaoImpl();
		try {
			String message=ad.assignCaseToOfficer(case_id, officer_id);
			System.out.println(message);
		} catch (OfficerException | CaseException e) {
			System.out.println(e.getMessage()); 
		}
	}

}
