package com.crime.UseCases;

import java.util.List;
import java.util.Scanner;

import com.crime.Bean.Officer;
import com.crime.Exception.OfficerException;
import com.crime.Exception.StationException;
import com.crime.dao.AdminDao;
import com.crime.dao.AdminDaoImpl;

public class GetOfficersByStationId {

	public static void getOfficerByStation() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Station ID : ");
		int id=sc.nextInt();
		
		AdminDao ad=new AdminDaoImpl();
		try {
			List<Officer>list=ad.getOfficerByStationId(id);
			list.forEach(o->System.out.println(o));
		} catch (OfficerException e) {
			System.out.println(e.getMessage());
		}
	}

}
