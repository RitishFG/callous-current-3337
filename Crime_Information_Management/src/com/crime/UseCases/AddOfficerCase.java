package com.crime.UseCases;

import java.util.Scanner;
import com.crime.Bean.Officer;
import com.crime.dao.AdminDao;
import com.crime.dao.AdminDaoImpl;

public class AddOfficerCase {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter First Name : ");
		String fname=sc.next();
		System.out.println("Enter Last Name : ");
		String lname=sc.next();
		System.out.println("Enter Gender : ");
		String gen=sc.next();
		System.out.println("Enter Mobile Number : ");
		String mobile=sc.next();
		System.out.println("Enter Station ID : ");
		int id=sc.nextInt();
		
		Officer o=new Officer();
		o.setFirst_name(fname);
		o.setGender(gen);
		o.setLast_name(lname);
		o.setMobile(mobile);
		o.setStation_id(id);
		
		AdminDao ad=new AdminDaoImpl();
		try
		{
			String message=ad.addOfficer(o);
			System.out.println(message);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

}
