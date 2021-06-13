package com.sriram.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.sriram.bean.Book;
import com.sriram.bean.Employee;

public interface EmployeeService {
	Employee printDetails(int empId, int bookId)throws ClassNotFoundException, SQLException;
	boolean isValidEmployee(int empId) throws ClassNotFoundException, SQLException;
	int getNoOfBooksIssued(int empId) throws ClassNotFoundException, SQLException;
	boolean increaseCount(int empId) throws ClassNotFoundException, SQLException;
	boolean decreaseCount(int empId)throws ClassNotFoundException, SQLException;
}