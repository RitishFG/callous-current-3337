package com.crime.CriminalUseCases;

import java.util.List;

import com.crime.Bean.Criminal;
import com.crime.Exception.CriminalException;
import com.crime.colors.ConsoleColors;
import com.crime.dao.CriminalDao;
import com.crime.dao.CriminalDaoImpl;

public class GetAllCriminalRecords {

	public static void getAllRecords() {
		CriminalDao cd=new CriminalDaoImpl();
		try {
//			calling required method
			List<Criminal>list=cd.getAllCriminalRecords();
			System.out.println();
			System.out.println(ConsoleColors.BLACK_UNDERLINED+"List of All Criminal Records"+ConsoleColors.RESET);
			System.out.println("*----------------------------------------------*");
			for(Criminal c:list)
			{
					System.out.println("ID                   : "+c.getCriminal_id());
					System.out.println("Name                 : "+c.getName());
					System.out.println("Mobile               : "+c.getMobile());
					System.out.println("Identification Marks : "+c.getIdentification_marks());
					System.out.println("City                 : "+c.getCity());
					System.out.println("Crime Report ID      : "+c.getCrime_id());
					System.out.println("*----------------------------------------------*");
			}
		} catch (CriminalException e) {
			System.out.println(ConsoleColors.RED_BACKGROUND_BRIGHT+ConsoleColors.WHITE_BOLD_BRIGHT+e.getMessage()+ConsoleColors.RESET);
		}

	}

}
