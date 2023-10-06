package com.amdocs.dao;

import java.util.List;

import com.amdocs.pojos.Doctor;

 public interface DoctorDAO {
	
	int addDoctor(Doctor doctor);

	int deleteDoctor(int doctorId);

	boolean updateDoctorFees(int doctorId, double fees);

	List<Doctor> showAllDoctors();

	List<Doctor> searchBySpecialization(String specialization);

	List<Doctor> searchByFeesAndShift(String availableShift,double fees);

	int countDoctorsByShift(String availableShift);

	
}
