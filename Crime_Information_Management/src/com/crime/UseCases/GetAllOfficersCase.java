package com.crime.UseCases;

import java.util.List;

import com.crime.Bean.Officer;
import com.crime.Exception.OfficerException;
import com.crime.dao.AdminDao;
import com.crime.dao.AdminDaoImpl;

public class GetAllOfficersCase {

	public static void main(String[] args) {
		AdminDao ad=new AdminDaoImpl();
		try {
			List<Officer>list=ad.getAllOfficerDetails();
			list.forEach(o->{
				System.out.println(o);
			});
		} catch (OfficerException e) {
			System.out.println(e.getMessage());
		}

	}

}
