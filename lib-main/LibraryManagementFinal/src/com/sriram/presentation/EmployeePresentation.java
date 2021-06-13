package com.sriram.presentation;

public interface EmployeePresentation {
	void showMenuEmp();
	void performMenuEmp(int choice);
	boolean authenticate(String username,String password);
}