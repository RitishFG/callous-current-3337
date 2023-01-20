package com.crime.main;

import java.util.List;
import java.util.Scanner;

import com.crime.Bean.Officer;
import com.crime.Bean.Station;
import com.crime.CriminalUseCases.AddNewCriminalRecord;
import com.crime.CriminalUseCases.DeleteCrimalByID;
import com.crime.CriminalUseCases.GetAllCriminalRecords;
import com.crime.CriminalUseCases.GetAllCriminalsByCrimeType;
import com.crime.CriminalUseCases.GetCriminalRecordById;
import com.crime.Exception.AdminException;
import com.crime.Exception.OfficerException;
import com.crime.Exception.StationException;
import com.crime.UseCases.AssignCase;
import com.crime.UseCases.GetOfficerDetailsById;
import com.crime.UseCases.GetOfficersByStationId;
import com.crime.dao.AdminDao;
import com.crime.dao.AdminDaoImpl;

public class Main {
	public static Scanner sc=new Scanner(System.in);
	public static void displayCriminalSwitchCases()
	{
		System.out.println("\n+---------------------------------------------------+");
		System.out.println("| 1. Add New Criminal Data                          |");
		System.out.println("| 2. Delete Existing Criminal Data By ID            |");
		System.out.println("| 3. View List of All Criminal Data                 |");
		System.out.println("| 4. View Criminal Data by ID                       |");
		System.out.println("| 5. View List of Criminals Data By Crime Type ID   |");
		System.out.println("| 6. Exit                                           |");
		System.out.println("+---------------------------------------------------+");
	}
	public static void addCriminalData()
	{
		AddNewCriminalRecord.addCriminal();
	}
	public static void deleteCriminalData()
	{
		DeleteCrimalByID.deleteCriminal();
	}
	public static void viewAllCriminalData()
	{
		GetAllCriminalRecords.getAllRecords();
	}
	public static void viewCriminalById()
	{
		GetCriminalRecordById.viewCriminalById();
	}
	public static void viewCriminalByCrimeType()
	{
		GetAllCriminalsByCrimeType.viewCriminalsByCrimeType();
	}
	public static void opsOnCriminalData() {
		boolean loop=true;
		while(loop)
		{
			displayCriminalSwitchCases();
			try {
				System.out.println("Enter Your choice : ");
				int choice=sc.nextInt();
				switch(choice)
				{
					case 1:addCriminalData();
							break;
					case 2:deleteCriminalData();
							break;
					case 3:viewAllCriminalData();
							break;
					case 4:viewCriminalById();
							break;
					case 5:viewCriminalByCrimeType();
							break;
					case 6:loop=false;
							break;
					default:System.out.println("Invalid Choice");
				}
				if(loop==false)
				{
					System.out.println("Quiting Application");
					System.out.println("Thank You!");
					System.exit(0);
				}
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
		
	}
	public static void opsOnCrimeReport() {
		System.out.println("in ops on crime record");
		
	}
	public static void adminMenuDisplay()
	{
		System.out.println("\n+----------------------------------------------+");
		System.out.println("| 1. Add New Station                           |");
		System.out.println("| 2. Add New Officer                           |");
		System.out.println("| 3. View List of All Officers                 |");
		System.out.println("| 4. View Officer by ID                        |");
		System.out.println("| 5. Assign Case To Officer                    |");
		System.out.println("| 6. View List of All Officers by Station ID   |");
		System.out.println("| 7. Exit                                      |");
		System.out.println("+----------------------------------------------+");
	}
	public static void addNewStation()
	{
		AdminDao ad=new AdminDaoImpl();
		sc.nextLine();
		System.out.println("Enter Staion Name : ");
		String name=sc.nextLine();
		System.out.println("Enter Station Address : ");
		String address=sc.nextLine();

		Station s=new Station();
		s.setStation_address(address);
		s.setStation_name(name);
		try {
			String message=ad.addStation(s);
			System.out.println(message);
		} catch (StationException e) {
			System.out.println(e.getMessage());
		}
	}
	public static void addNewOfficer()
	{
		AdminDao ad=new AdminDaoImpl();
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
	public static void getListOfAllOfficers()
	{
		AdminDao ad=new AdminDaoImpl();
		try {
			List<Officer>list=ad.getAllOfficerDetails();
			System.out.println("+-----------------------------------+");
			list.forEach(o->{
				System.out.println(o);
//				System.out.println("| "+o.getOfficer_id()+"\t| "+o.getFirst_name()+"\t\t| "+o.getLast_name()+"\t\t| "+o.getMobile()+"\t| "+o.getStation_id()+"\t|");
			});
			System.out.println("+-----------------------------------+");
		} catch (OfficerException e) {
			System.out.println(e.getMessage());
		}
	}
	public static void getOfficerById()
	{
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
	public static void assigncaseToOfficer()
	{
		AssignCase.assignCase();
	}
	public static void getListOfOfficerByStation()
	{
		GetOfficersByStationId.getOfficerByStation();
	}
	public static void adminSwitchCase()
	{
		System.out.println("Welcome Admin!!");
		boolean loop=true;
		while(loop)
		{
			adminMenuDisplay();
			try 
			{
				System.out.println("Enter Your choice : ");
				int choice=sc.nextInt();
				switch(choice)
				{
					case 1:addNewStation();
							break;
					case 2:addNewOfficer();
							break;
					case 3:getListOfAllOfficers();
							break;
					case 4:getOfficerById();
							break;
					case 5:assigncaseToOfficer();
							break;
					case 6:getListOfOfficerByStation();
							break;
					case 7:loop=false;
							break;
					default:System.out.println("Invalid Choice");
				}
				if(loop==false)
				{
					System.out.println("Quiting Application");
					System.out.println("Thank You!");
					System.exit(0);
				}
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
			
		}
	}
	public static void adminLogin() {
		boolean res=false;
		while(!res)
		{
			System.out.println("Enter Admin UserName : ");
			String username=sc.next();
			System.out.println("Enter Admin Password : ");
			String password=sc.next();
			AdminDao ad=new AdminDaoImpl();
			try {
				res=ad.adminLogin(username, password);
				adminSwitchCase();
			} catch (AdminException e) {
				System.out.println(e.getMessage());
				System.out.println("\nTry Again ? (y/n)");
				String again=sc.next();
				if(again.equalsIgnoreCase("y"))
				{
					
				}
				else if(again.equalsIgnoreCase("n"))
				{
					System.out.println("Back To Main Menu");
					break;
				}
				else
				{
					System.out.println("Invalid Choice");
					System.out.println("Back To Main Menu");
					break;
				}
			}
			
		}
	}
	public static void switchCase()
	{
		boolean loop=true;
		while(loop)
		{
			Main.displayMenu();
			try
			{
				System.out.println("Enter Your choice : ");
				int choice=sc.nextInt();
				switch(choice)
				{
				case 1:adminLogin();
						break;
				case 2:opsOnCrimeReport();
						break;
				case 3:opsOnCriminalData();
						break;
				case 4:loop=false;
						break;
				default:System.out.println("Invalid Choice");
				}
				
				if(loop==false)
				{
					System.out.println("Quiting Application");
					System.out.println("Thank You!");
				}
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
	}
	
	public static void displayMenu()
	{
		
		System.out.println("\n+-----------------------------------------+");
		System.out.println("| 1. Admin Login                          |");
		System.out.println("| 2. General Operation on Crime Reports   |");
		System.out.println("| 3. General Operation on Criminal Data   |");
		System.out.println("| 4. Exit                                 |");
		System.out.println("+-----------------------------------------+");
	}
	public static void main(String[] args) {
//		Main.displayMenu();
		System.out.println("********** Welcome to Crime Information Management System **********");
		Main.switchCase();
	}

}
