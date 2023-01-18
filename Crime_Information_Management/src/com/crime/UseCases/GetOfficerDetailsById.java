package com.crime.UseCases;

import java.util.List;
import java.util.Scanner;

import com.crime.Bean.Officer;
import com.crime.Exception.OfficerException;
import com.crime.dao.AdminDao;
import com.crime.dao.AdminDaoImpl;

public class GetOfficerDetailsById {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Officer ID : ");
		int id=sc.nextInt();
		
		AdminDao ad=new AdminDaoImpl();
		try {
			Officer o=ad.getOfficerDetailsById(id);
			System.out.println(o); 
		} catch (OfficerException e) {
			System.out.println(e.getMessage());
		}
	}

}
