package com.crime.UseCases;

import java.util.Scanner;
import com.crime.dao.AdminDao;
import com.crime.dao.AdminDaoImpl;

public class AdminLoginCase {
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter UserName : ");
		String username=sc.next();
		System.out.println("Enter Password : ");
		String password=sc.next();
		
		AdminDao ad=new AdminDaoImpl();
		try {
			ad.adminLogin(username, password);
			System.out.println("Login Successfull!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		finally
		{
			sc.close();
		}
	}
}
