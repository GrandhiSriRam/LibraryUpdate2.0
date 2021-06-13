package com.sriram.persistent;

import java.sql.SQLException;
import java.util.ArrayList;

import com.sriram.bean.Book;
import com.sriram.bean.Employee;

public interface EmployeeDao {
	boolean isValidEmployee(int empId) throws ClassNotFoundException,SQLException;
	Employee printDetails(int empId, int bookId)throws ClassNotFoundException, SQLException;
	int getNoOfBooksIssued(int empId)throws ClassNotFoundException, SQLException;
	boolean increaseCount(int empId) throws ClassNotFoundException, SQLException;
	boolean decreaseCount(int empId) throws ClassNotFoundException, SQLException;
	

}