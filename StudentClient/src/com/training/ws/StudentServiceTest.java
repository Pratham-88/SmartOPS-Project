package com.training.ws;

public class StudentServiceTest {

	public static void main(String[] args) {
		
		StudentServiceImplService service = new StudentServiceImplService();
		StudentServiceImpl obj =service.getStudentServiceImpl();
		
		System.out.println(obj.getStudentInfo());

	}

}
