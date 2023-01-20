package com.crime.CriminalUseCases;

import java.util.List;

import com.crime.Bean.Criminal;
import com.crime.Exception.CriminalException;
import com.crime.dao.CriminalDao;
import com.crime.dao.CriminalDaoImpl;

public class GetAllCriminalRecords {

	public static void getAllRecords() {
		CriminalDao cd=new CriminalDaoImpl();
		try {
//			calling required method
			List<Criminal>list=cd.getAllCriminalRecords();
			for(Criminal c:list)
			{
				System.out.println(c);
			}
		} catch (CriminalException e) {
			System.out.println(e.getMessage());
		}

	}

}
