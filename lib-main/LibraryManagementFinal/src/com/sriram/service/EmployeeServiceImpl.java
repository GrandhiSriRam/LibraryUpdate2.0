package com.sriram.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.sriram.bean.Book;
import com.sriram.bean.Employee;
import com.sriram.persistent.BookDao;
import com.sriram.persistent.BookDaoImpl;
import com.sriram.persistent.EmployeeDao;
import com.sriram.persistent.EmployeeDaoImpl;
import com.sriram.persistent.TransactionDao;
import com.sriram.persistent.TransactionDaoImpl;

public class EmployeeServiceImpl implements EmployeeService{

	private EmployeeDao employeeDao=new EmployeeDaoImpl();
	
	@Override
	public boolean isValidEmployee(int empId) throws ClassNotFoundException, SQLException {
		
		return employeeDao.isValidEmployee(empId);
	}
	
	@Override
	public Employee printDetails(int empId, int bookId) throws ClassNotFoundException, SQLException {
		
		return employeeDao.printDetails(empId,bookId);
	}

	@Override
	public int getNoOfBooksIssued(int empId) throws ClassNotFoundException, SQLException {
		
		return employeeDao.getNoOfBooksIssued(empId);
	}

	@Override
	public boolean increaseCount(int empId) throws ClassNotFoundException, SQLException {
		
		return employeeDao.increaseCount(empId);
		
	}

	@Override
	public boolean decreaseCount(int empId) throws ClassNotFoundException, SQLException {
	
		return employeeDao.decreaseCount(empId);
	}
	
}