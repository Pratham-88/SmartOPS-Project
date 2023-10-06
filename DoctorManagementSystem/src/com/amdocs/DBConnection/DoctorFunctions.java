package com.amdocs.DBConnection;

import  com.amdocs.DBConnection.DbConnection;
import  com.amdocs.DBConnection.DoctorFunctions;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DoctorFunctions 
{
	
	 public static void addDoctor(Connection con1 ,Scanner scanner) throws SQLException
	 {
	      
		 
		 System.out.print("Enter doctor's name: ");
	        String name = scanner.nextLine();
	        System.out.print("Enter doctor's specialization: ");
	        String specialization = scanner.nextLine();
	        System.out.print("Enter doctor's availability: ");
	        String availability = scanner.nextLine();
	        System.out.print("Enter doctor's consultation fees: ");
	        double fees = scanner.nextDouble();
	       
	        
	        PreparedStatement preparedStatement = con1.prepareStatement("INSERT INTO DoctorInfo (name, specialization, consultation_fees, availability) VALUES (?, ?, ?, ?)");
	        preparedStatement.setString(1, name);
	        preparedStatement.setString(2, specialization);
	        preparedStatement.setDouble(3, fees);
	        preparedStatement.setString(4, availability);
	        
	        int rowsAffected = preparedStatement.executeUpdate();
	        if (rowsAffected > 0) {
	            System.out.println("Doctor added successfully!");
	        } else {
	            System.out.println("Failed to add doctor.");
	        }
	    }
	 
	 public static void viewALLDoctors(Connection con1) throws SQLException
	 {	
		 String sql = "SELECT * FROM DoctorInfo";
		 PreparedStatement st = con1.prepareStatement(sql);
		 try {
			 
			  System.out.println("after select");
	            // Execute the query
	            ResultSet resultSet = st.executeQuery(sql);

	            // Process and display the query results
	            while (resultSet.next()) {
	                // Retrieve data from the result set
	                int id = resultSet.getInt("id"); // Replace "id" with your column name
	                String name = resultSet.getString("name"); 
	                String specialization= resultSet.getString("SPECIALIZATION");// Replace "name" with your column name
	                double fees = resultSet.getDouble("CONSULTATION_FEES");
	                String availability = resultSet.getString("AVAILABILITY");
	                		// Add more columns as needed

	                // Display the data
	                System.out.println("ID: " + id + "  Name: " + name +" SPECIALIZATION : " + specialization + " CONSULTATION_FEES : " + fees + " AVAILABILITY : " + availability);
	                // Print additional columns here as needed
	            }
		 }
	            
	      catch(Exception e)
	      {
	    	  System.out.println(e);
	      }
		 }
	 
	 public static void deleteDoctor(Connection con1 , Scanner scanner)
	 {
		 String delete = "Delete from DoctorInfo where NAME = ?";
		 try {
			 
		 System.out.println("Write full name of Doctor : ");
		 String name = scanner.nextLine();
		 PreparedStatement st = con1.prepareStatement(delete);
		 st.setString(1, name);
		 int rows = st.executeUpdate();
		 if(rows>0)
		 {
			 System.out.println("Record Deleted Successfully");
		 }
		 else {
			 System.out.println("Delete Failed/No such Record found");
		 }
		 
		 }
		 catch(Exception e)
		 {
			 System.out.println(e);
		 }
	 }
		 
	 public static void updateDoctorFees(Connection con1 , Scanner scanner)
	 {
		 String update = "UPDATE TABLE DoctorInfo where id = ?";
		 try {
			 
		// System.out.println("Write full name of Doctor : ");
		 String name = scanner.nextLine();
		 PreparedStatement st = con1.prepareStatement(update);
		 st.setString(1, name);
		 int rows = st.executeUpdate();
		 if(rows>0)
		 {
			 System.out.println("Record Updated Successfully");
		 }
		 else {
			 System.out.println("Failed/No such Record found");
		 }
		 
		 }
		 catch(Exception e)
		 {
			 System.out.println(e);
		 }
	 }
	 
	 
	 
	 public static void searchDoctorsByAvailability(Connection con1, Scanner scanner)
	 {
		 String search = "Select * from DoctorInfo where availability = ?";
		 try {
			 System.out.println("Please type Yes/No to check Availability ");
			 String bool = scanner.nextLine();
			 PreparedStatement st = con1.prepareStatement(search);
			
			 st.setString(1, bool); // Set the availability parameter

			 ResultSet resultSet = st.executeQuery();
			 while (resultSet.next()) {
	                // Retrieve data from the result set
	                int id = resultSet.getInt("id"); // Replace "id" with your column name
	                String name = resultSet.getString("name"); 
	                String specialization= resultSet.getString("SPECIALIZATION");// Replace "name" with your column name
	                double fees = resultSet.getDouble("CONSULTATION_FEES");
	                String availability = resultSet.getString("AVAILABILITY");
	                
	                System.out.println("ID: " + id + "  Name: " + name +" SPECIALIZATION : " + specialization + " CONSULTATION_FEES : " + fees + " AVAILABILITY : " + availability);

			 }
			 
			 
		 }
		 catch(Exception e)
		 {
			 System.out.println(e);
		 }
	 }
}

