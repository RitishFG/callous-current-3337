package com.crime.main;

import java.util.List;
import java.util.Scanner;

import com.crime.Bean.Officer;
import com.crime.Bean.Station;
import com.crime.CrimeReportUseCases.AddCrimeReport;
import com.crime.CrimeReportUseCases.CloseCrimeRecordById;
import com.crime.CrimeReportUseCases.ClosedRecordsByOfficerId;
import com.crime.CrimeReportUseCases.GetAllClosedRecords;
import com.crime.CrimeReportUseCases.GetAllCrimeRecords;
import com.crime.CrimeReportUseCases.GetAllCrimeRecordsByCrimeType;
import com.crime.CrimeReportUseCases.GetAllOpenCrimeRecords;
import com.crime.CrimeReportUseCases.GetCrimeRecordById;
import com.crime.CrimeReportUseCases.OpenRecordsByOfficerId;
import com.crime.CrimeReportUseCases.RecordsClosedBeforeDate;
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
import com.crime.colors.ConsoleColors;
import com.crime.dao.AdminDao;
import com.crime.dao.AdminDaoImpl;
public class Main {
	public static Scanner sc=new Scanner(System.in);
	public static void displayCriminalSwitchCases()
	{
//		Displaying Criminal data menu to user
		System.out.println();
		System.out.println(ConsoleColors.BLACK_UNDERLINED+"Menu Options For Criminal Data"+ConsoleColors.RESET);
		System.out.println(ConsoleColors.PURPLE+"\n+---------------------------------------------------+");
		System.out.println("| 1. Add New Criminal Data                          |");
		System.out.println("| 2. Delete Existing Criminal Data By ID            |");
		System.out.println("| 3. View List of All Criminal Data                 |");
		System.out.println("| 4. View Criminal Data by ID                       |");
		System.out.println("| 5. View List of Criminals Data By Crime Type ID   |");
		System.out.println("| 6. Exit                                           |");
		System.out.println("+---------------------------------------------------+"+ConsoleColors.RESET);
	}
	public static void addCriminalData()
	{
//		Calling method in criminal use case package to perform the required operation
		AddNewCriminalRecord.addCriminal();
	}
	public static void deleteCriminalData()
	{
//		Calling method in criminal use case package to perform the required operation
		DeleteCrimalByID.deleteCriminal();
	}
	public static void viewAllCriminalData()
	{
//		Calling method in criminal use case package to perform the required operation
		GetAllCriminalRecords.getAllRecords();
	}
	public static void viewCriminalById()
	{
//		Calling method in criminal use case package to perform the required operation
		GetCriminalRecordById.viewCriminalById();
	}
	public static void viewCriminalByCrimeType()
	{
//		Calling method in criminal use case package to perform the required operation
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
					default:System.out.println(ConsoleColors.RED_BACKGROUND_BRIGHT+ConsoleColors.WHITE_BOLD_BRIGHT+"Invalid Choice"+ConsoleColors.RESET);
				}
				if(loop==false)
				{
					System.out.println(ConsoleColors.YELLOW_BACKGROUND_BRIGHT+ConsoleColors.WHITE_BOLD_BRIGHT+"Quiting Application");
					System.out.println("Thank You!"+ConsoleColors.RESET);
					System.exit(0);
				}
			}
			catch(Exception e)
			{
				System.out.println(ConsoleColors.RED_BACKGROUND_BRIGHT+ConsoleColors.WHITE_BOLD_BRIGHT+"Invalid Choice, Stopping the Application"+ConsoleColors.RESET);
				System.exit(0);
			}
		}
		
	}
	public static void displayCrimeRecordSwitchCases()
	{
//		Displaying crime record menu to user
		System.out.println();
		System.out.println(ConsoleColors.BLACK_UNDERLINED+"Menu Options For Crime Records"+ConsoleColors.RESET);
		System.out.println(ConsoleColors.PURPLE+"\n+-----------------------------------------------------+");
		System.out.println("| 1. Add New Crime Record                             |");
		System.out.println("| 2. View Crime Record By ID                          |");
		System.out.println("| 3. Close Crime Record                               |");
		System.out.println("| 4. View All Crime Record                            |");
		System.out.println("| 5. View All Open Crime Record                       |");
		System.out.println("| 6. View All Closed Crime Record                     |");
		System.out.println("| 7. View All Crime Record By Crime Type              |");
		System.out.println("| 8. View All Open Crime Record With Officer ID       |");
		System.out.println("| 9. View All Closed Crime Record With Officer ID     |");
		System.out.println("| 10.View All Closed Crime Record Before Date         |");
		System.out.println("| 11.Exit                                             |");
		System.out.println("+-----------------------------------------------------+"+ConsoleColors.RESET);
	}
	public static void addCrimeReport()
	{
//		calling method in Crime Report use case package to perform required operation
		AddCrimeReport.addReport();
	}
	public static void getCrimeReportById()
	{
//		calling method in Crime Report use case package to perform required operation
		GetCrimeRecordById.getReport();
	}
	public static void closeCrimeReport()
	{
//		calling method in Crime Report use case package to perform required operation
		CloseCrimeRecordById.closeReport();
	}
	public static void getAllCrimeReports()
	{
//		calling method in Crime Report use case package to perform required operation
		GetAllCrimeRecords.getAllReports();
	}
	public static void getAllOpenCrimeReports()
	{
//		calling method in Crime Report use case package to perform required operation
		GetAllOpenCrimeRecords.getOpenReports();
	}
	public static void getAllClosedCrimeReports()
	{
//		calling method in Crime Report use case package to perform required operation
		GetAllClosedRecords.getClosedCrimeReports();
	}
	public static void getCrimeReportsByCrimeType()
	{
//		calling method in Crime Report use case package to perform required operation
		GetAllCrimeRecordsByCrimeType.reportsByCrimeType();
	}
	public static void getAllOpenCrimeReportsByOfficerId()
	{
//		calling method in Crime Report use case package to perform required operation
		OpenRecordsByOfficerId.openReportsWithOfficerId();
	}
	public static void getAllClosedCrimeReportsByOfficerId()
	{
//		calling method in Crime Report use case package to perform required operation
		ClosedRecordsByOfficerId.closedReportsWithOfficerId();
	}
	public static void getAllClosedCrimeReportsBeforeDate()
	{
//		calling method in Crime Report use case package to perform required operation
		RecordsClosedBeforeDate.reportsBeforeDate();
	}
	public static void opsOnCrimeReport() {
//		user choose option to perform operations on crime reports
		boolean loop=true;
		while(loop)
		{
//			calling method to display required menu
			displayCrimeRecordSwitchCases();
			try
			{
				System.out.println(ConsoleColors.BLUE_BACKGROUND_BRIGHT+"Enter Your choice : "+ConsoleColors.RESET);
				int choice=sc.nextInt();
//				taking user input to call required method
				switch(choice)
				{
					case 1:addCrimeReport();
							break;
					case 2:getCrimeReportById();
							break;
					case 3:closeCrimeReport();
							break;
					case 4:getAllCrimeReports();
							break;
					case 5:getAllOpenCrimeReports();
							break;
					case 6:getAllClosedCrimeReports();
							break;
					case 7:getCrimeReportsByCrimeType();
							break;
					case 8:getAllOpenCrimeReportsByOfficerId();
							break;
					case 9:getAllClosedCrimeReportsByOfficerId();
							break;
					case 10:getAllClosedCrimeReportsBeforeDate();
							break;
					case 11:loop=false;
							break;
					default:System.out.println(ConsoleColors.RED_BACKGROUND_BRIGHT+ConsoleColors.WHITE_BOLD_BRIGHT+"Invalid Choice"+ConsoleColors.RESET);
				}
				if(loop==false)
				{
					System.out.println(ConsoleColors.YELLOW_BACKGROUND_BRIGHT+ConsoleColors.BLUE_BOLD_BRIGHT+"Quiting Application");
					System.out.println("Thank You!"+ConsoleColors.RESET);
					System.exit(0);
				}
			}
			catch(Exception e)
			{
				System.out.println(ConsoleColors.RED_BACKGROUND_BRIGHT+ConsoleColors.WHITE_BOLD_BRIGHT+"Invalid Choice, Stopping the Application"+ConsoleColors.RESET);
				System.exit(0);
			}
		}
		
	}
	public static void adminMenuDisplay()
	{
//		admin menu display
		System.out.println();
		System.out.println(ConsoleColors.BLACK_UNDERLINED+"Admin Menu"+ConsoleColors.RESET);
		System.out.println(ConsoleColors.PURPLE+"\n+----------------------------------------------+");
		System.out.println("| 1. Add New Station                           |");
		System.out.println("| 2. Add New Officer                           |");
		System.out.println("| 3. View List of All Officers                 |");
		System.out.println("| 4. View Officer by ID                        |");
		System.out.println("| 5. Assign Case To Officer                    |");
		System.out.println("| 6. View List of All Officers by Station ID   |");
		System.out.println("| 7. Exit                                      |");
		System.out.println("+----------------------------------------------+"+ConsoleColors.RESET);
	}
	public static void addNewStation()
	{
//		Asking user for input to add new station
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
//			new station added successfully
			System.out.println(ConsoleColors.GREEN_BACKGROUND_BRIGHT+ConsoleColors.WHITE_BOLD_BRIGHT+message+ConsoleColors.RESET);
		} catch (StationException e) {
//			exception raised due to incorrect details
			System.out.println(ConsoleColors.RED_BACKGROUND_BRIGHT+ConsoleColors.WHITE_BOLD_BRIGHT+e.getMessage()+ConsoleColors.RESET);
		}
	}
	public static void addNewOfficer()
	{
//		taking user input for new officer detials
		AdminDao ad=new AdminDaoImpl();
		System.out.println("Enter First Name    : ");
		String fname=sc.next();
		System.out.println("Enter Last Name     : ");
		String lname=sc.next();
		System.out.println("Enter Gender        : ");
		String gen=sc.next();
		System.out.println("Enter Mobile Number : ");
		String mobile=sc.next();
		System.out.println("Enter Station ID    : ");
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
//			new officer added
			System.out.println(ConsoleColors.GREEN_BACKGROUND_BRIGHT+ConsoleColors.WHITE_BOLD_BRIGHT+message+ConsoleColors.RESET);
		}
		catch(Exception e)
		{
//			exception raised due to incorrect data
			System.out.println(ConsoleColors.RED_BACKGROUND_BRIGHT+ConsoleColors.WHITE_BOLD_BRIGHT+e.getMessage()+ConsoleColors.RESET);
		}
	}
	public static void getListOfAllOfficers()
	{
		AdminDao ad=new AdminDaoImpl();
		try {
			List<Officer>list=ad.getAllOfficerDetails();
			System.out.println();
//			if table not empty then printing all the officer records
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
//			table is empty
			System.out.println(ConsoleColors.RED_BACKGROUND_BRIGHT+ConsoleColors.WHITE_BOLD_BRIGHT+e.getMessage()+ConsoleColors.RESET);
		}
	}
	public static void getOfficerById()
	{
//		Getting offficer id from user
		System.out.println("Enter Officer ID : ");
		int id=sc.nextInt();
		
		AdminDao ad=new AdminDaoImpl();
		try {
			Officer o=ad.getOfficerDetailsById(id);
//			printing officer details if id exists
			System.out.println();
			System.out.println("*------------------------------------*");
			System.out.println("ID         : "+o.getOfficer_id());
			System.out.println("Name       : "+o.getFirst_name()+" "+o.getLast_name());
			System.out.println("Gender     : "+o.getGender());
			System.out.println("Mobile     : "+o.getMobile());
			System.out.println("Station ID : "+o.getStation_id());
			System.out.println("*------------------------------------*");
		} catch (OfficerException e) {
//			exceptions
			System.out.println(ConsoleColors.RED_BACKGROUND_BRIGHT+ConsoleColors.WHITE_BOLD_BRIGHT+e.getMessage()+ConsoleColors.RESET);
		}
	}
	public static void assigncaseToOfficer()
	{
//		Calling method in package useCases
		AssignCase.assignCase();
	}
	public static void getListOfOfficerByStation()
	{
//		Calling method in package useCases
		GetOfficersByStationId.getOfficerByStation();
	}
	public static void adminSwitchCase()
	{
//		Control moves here after user enters correct admin details
		System.out.println();
		System.out.println(ConsoleColors.GREEN_BACKGROUND_BRIGHT+ConsoleColors.WHITE_BOLD_BRIGHT+"Login Successfull!"+ConsoleColors.RESET);
		boolean loop=true;
		while(loop)
		{
//			calling adminMenuDisplay method to show AdminMenu options
			adminMenuDisplay();
			try 
			{
//				asking user for choice to call respective functionality
				System.out.println(ConsoleColors.BLUE_BACKGROUND_BRIGHT+"Enter Your choice : "+ConsoleColors.RESET);
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
					default:System.out.println(ConsoleColors.RED_BACKGROUND_BRIGHT+ConsoleColors.WHITE_BOLD_BRIGHT+"Invalid Choice"+ConsoleColors.RESET);
				}
				if(loop==false)
				{
					System.out.println(ConsoleColors.YELLOW_BACKGROUND_BRIGHT+ConsoleColors.BLUE_BOLD_BRIGHT+"Quiting Application");
					System.out.println("Thank You!"+ConsoleColors.RESET);
					System.exit(0);
				}
			}
			catch(Exception e)
			{
				System.out.println(ConsoleColors.RED_BACKGROUND_BRIGHT+ConsoleColors.WHITE_BOLD_BRIGHT+"Invalid Choice, Stopping the Application"+ConsoleColors.RESET);
				System.exit(0);
			}
			
		}
	}
	public static void adminLogin() {
		boolean res=false;
		while(!res)
		{
//			Getting user input for login 
			System.out.println();
			System.out.println(ConsoleColors.BLACK_BACKGROUND_BRIGHT+ConsoleColors.WHITE_BOLD_BRIGHT+"Enter Admin UserName : "+ConsoleColors.RESET);
			String username=sc.next();
			System.out.println(ConsoleColors.BLACK_BACKGROUND_BRIGHT+ConsoleColors.WHITE_BOLD_BRIGHT+"Enter Admin Password : "+ConsoleColors.RESET);
			String password=sc.next();
			AdminDao ad=new AdminDaoImpl();
			try {
//				calling function adminLogin to validate users input
				res=ad.adminLogin(username, password);
//				correct details, printing Admin Menu and asking again for user input
				adminSwitchCase();
			} catch (AdminException e) {
				System.out.println(ConsoleColors.RED_BACKGROUND_BRIGHT+ConsoleColors.WHITE_BOLD_BRIGHT+e.getMessage()+ConsoleColors.RESET);
//				incorrect details, asking user if want to try again
				System.out.println("\nTry Again ? (y/n)");
				String again=sc.next();
				if(again.equalsIgnoreCase("y"))
				{
					
				}
				else if(again.equalsIgnoreCase("n"))
				{
					System.out.println();
					System.out.println("Back To Main Menu");
					break;
				}
				else
				{
					System.out.println();
					System.out.println(ConsoleColors.RED_BACKGROUND_BRIGHT+ConsoleColors.WHITE_BOLD_BRIGHT+"Invalid Choice"+ConsoleColors.RESET);
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
//			displayMenu function will display the main menu to user
			Main.displayMenu();
//			use of try catch so that exception can be caught if user select a character instead of number
			try
			{
				System.out.println(ConsoleColors.BLUE_BACKGROUND_BRIGHT+"Enter Your choice : "+ConsoleColors.RESET);
				int choice=sc.nextInt();
//				User will input choice and control will move accordingly
				switch(choice)
				{
				case 1:adminLogin();
						break;
				case 2:opsOnCrimeReport();
						break;
				case 3:opsOnCriminalData();
						break;
//						if user chooses 4 then loop will be broken and user will exit from application
				case 4:loop=false;
						break;
				default:System.out.println(ConsoleColors.RED_BACKGROUND_BRIGHT+ConsoleColors.WHITE_BOLD_BRIGHT+"Invalid Choice"+ConsoleColors.RESET);
				}
				
				if(loop==false)
				{
					System.out.println(ConsoleColors.YELLOW_BACKGROUND_BRIGHT+ConsoleColors.BLUE_BOLD_BRIGHT+"Quiting Application");
					System.out.println("Thank You!"+ConsoleColors.RESET);
				}
			}
			catch(Exception e)
			{
				System.out.println(ConsoleColors.RED_BACKGROUND_BRIGHT+ConsoleColors.WHITE_BOLD_BRIGHT+"Invalid Choice, Stopping the Application"+ConsoleColors.RESET);
				System.exit(0);
			}
		}
	}
	
	public static void displayMenu()
	{
//		Main menu display for user to choose from
		System.out.println(ConsoleColors.PURPLE+"\n+-----------------------------------------+");
		System.out.println("| 1. Admin Login                          |");
		System.out.println("| 2. General Operation on Crime Record    |");
		System.out.println("| 3. General Operation on Criminal Data   |");
		System.out.println("| 4. Exit                                 |");
		System.out.println("+-----------------------------------------+"+ConsoleColors.RESET);
	}
	public static void main(String[] args) {
		System.out.println(ConsoleColors.YELLOW_BACKGROUND_BRIGHT+ConsoleColors.BLUE_BOLD_BRIGHT+ConsoleColors.BLUE_UNDERLINED+"********** Welcome to Crime Information Management System **********"+ConsoleColors.RESET);
//		Called Function switchCase which will display the main menu to user and ask for choice 
		Main.switchCase();
	}

}
