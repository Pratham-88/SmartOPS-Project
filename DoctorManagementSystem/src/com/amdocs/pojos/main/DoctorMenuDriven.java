package com.amdocs.pojos.main;
import java.util.*;
import java.util.List;
import java.util.Scanner;

import com.amdocs.dao.DoctorDAO;
import com.amdocs.dao.DoctorDAOImpl;
import com.amdocs.pojos.Doctor;

public class DoctorMenuDriven {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		DoctorDAO dao=new DoctorDAOImpl(); 
		do {
			
			System.out.println("1. Add new doctor\r\n"
					+ "2. Update doctor fees\r\n"
					+ "3. Delete doctor\r\n"
					+ "4. View all doctors\r\n"
					+ "5. Find doctor by specialization\r\n"
					+ "6. Find doctors whose fees is less than all doctors of given shift\r\n"
					+ "7. Count number of doctors by shift\r\n"
					+ "8. Exit\r\n"
					+ "");
			
			System.out.println("Enter your choice:");
			int choice=sc.nextInt();
			switch(choice)
			{
			case 1:
				
				System.out.println("Enter Doctor Id\n");
				int doctorId=sc.nextInt();
				System.out.println("Enter doctorName\n");
				String doctorName=sc.next();
				System.out.println("Enter mobileNumber\n");
				String mobileNumber=sc.next();
				System.out.println("Enter specialization\n");
				String specialization=sc.next();
				System.out.println("Enter availableShift\n");
				String availableShift=sc.next();
				System.out.println("Enter fees\n");
				double fees=sc.nextDouble();
				Doctor doctor=new Doctor(doctorId,doctorName,mobileNumber,specialization,availableShift,fees);
				int y = dao.addDoctor(doctor);
				System.out.println(y);
				System.out.println("Doctor Added Successfully");
				
				
				break;
				
			case 2:
				System.out.println("Enter Doctor's ID");
				 int doctorId1=sc.nextInt();
				// System.out.println("Enter doctorName");
				 System.out.println("Update fees");
				 double fees2=sc.nextDouble();
				 boolean flag=dao.updateDoctorFees(doctorId1, fees2);
				 if(flag)
					 System.out.println("Doctor fees updated");
				 else
					 System.out.println("Doctor Not Found");
				 
				break;
				
			case 3:
				System.out.println("Enter the doctor id you want to delete");
				int iddelete = sc.nextInt();
				int x = dao.deleteDoctor(iddelete);
				System.out.println("The doctor has been deleted");
				break;
				
			case 4:
				System.out.println("View All doctors");
				List<Doctor> doctorList=dao.showAllDoctors();
				for(Doctor doc:doctorList)
				{
					System.out.println(doc);
				}
				break;
				
			case 5:
				System.out.println("Enter the Specialization for which you want the doctor");
				String sp = sc.next();
				List<Doctor>doctemp = dao.searchBySpecialization(sp);
				for (Doctor doc:doctemp) {
					System.out.println(doc);
				}
			case 6:
				System.out.println("Enter the shift you want a doctor");
				String shift = sc.next();
				System.out.println("Enter your fees range");
				double fee = sc.nextInt();
				List<Doctor>docTemp = dao.searchByFeesAndShift(shift, fee);
				for(Doctor doc:docTemp) {
					System.out.println(doc);
				}
			case 7:
				System.out.println("Enter the shift you want the count of doctors");
				String shift1 = sc.next();
				int docCount = dao.countDoctorsByShift(shift1);
				System.out.println("The number of doctors currently available are :"+docCount);
				
			
			}
			
		}
		while(true);

	}

}
