package com.crime.UseCases;

import java.util.List;
import java.util.Scanner;

import com.crime.Bean.Officer;
import com.crime.Exception.OfficerException;
import com.crime.Exception.StationException;
import com.crime.colors.ConsoleColors;
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
			System.out.println();
			System.out.println(ConsoleColors.BLACK_UNDERLINED+"List of Officers By Station ID"+ConsoleColors.RESET);
			System.out.println("*------------------------------------*");
			list.forEach(o->{
				System.out.println("ID         : "+o.getOfficer_id());
				System.out.println("Name       : "+o.getFirst_name()+" "+o.getLast_name());
				System.out.println("Gender     : "+o.getGender());
				System.out.println("Mobile     : "+o.getMobile());
				System.out.println("Station ID : "+o.getStation_id());
				System.out.println("*------------------------------------*");
			});
		} catch (OfficerException e) {
			System.out.println(ConsoleColors.RED_BACKGROUND_BRIGHT+ConsoleColors.WHITE_BOLD_BRIGHT+e.getMessage()+ConsoleColors.RESET);
		}
	}

}
