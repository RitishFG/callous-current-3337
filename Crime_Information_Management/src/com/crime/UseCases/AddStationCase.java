package com.crime.UseCases;

import java.util.Scanner;

import com.crime.Bean.Station;
import com.crime.Exception.StationException;
import com.crime.dao.AdminDao;
import com.crime.dao.AdminDaoImpl;

public class AddStationCase {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Staion Name     : ");
		String name=sc.nextLine();
		System.out.println("Enter Station Address : ");
		String address=sc.nextLine();

		Station s=new Station();
		s.setStation_address(address);
		s.setStation_name(name);
		AdminDao ad=new AdminDaoImpl();
		try {
			String message=ad.addStation(s);
			System.out.println(message);
		} catch (StationException e) {
			System.out.println(e.getMessage());
		}
	}
}
