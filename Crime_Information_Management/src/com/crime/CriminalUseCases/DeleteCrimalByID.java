package com.crime.CriminalUseCases;

import java.util.Scanner;

import com.crime.Exception.CriminalException;
import com.crime.colors.ConsoleColors;
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
			System.out.println(ConsoleColors.GREEN_BACKGROUND_BRIGHT+ConsoleColors.WHITE_BOLD_BRIGHT+message+ConsoleColors.RESET);
		} catch (CriminalException e) {
			System.out.println(ConsoleColors.RED_BACKGROUND_BRIGHT+ConsoleColors.WHITE_BOLD_BRIGHT+e.getMessage()+ConsoleColors.RESET);
		}

	}

}
