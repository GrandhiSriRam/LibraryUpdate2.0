package com.sriram.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.sriram.persistent.TransactionDao;
import com.sriram.persistent.TransactionDaoImpl;

public class TransactionServiceImpl implements TransactionService{
	
	private TransactionDao transactionDao=new TransactionDaoImpl();
	
	@Override
	public boolean updateTransaction(int empId,int bookId) throws ClassNotFoundException, SQLException{
		return transactionDao.updateTransaction(empId,bookId);
		
	}

	@Override
	public boolean authenticate(String username, String password) throws ClassNotFoundException, SQLException {
		
		return transactionDao.authenticate(username,password);
	}
	@Override
	public int returnBook(int empId, int bookId) throws ClassNotFoundException, SQLException {
		
		return transactionDao.returnBook(empId,bookId);
		
	}
	@Override
	public boolean removeTransaction(int empId, int bookId) throws ClassNotFoundException, SQLException {
		
		return transactionDao.removeTransaction(empId,bookId);
		
	}
	@Override
	public ArrayList<Integer> getAllBooksIssued(int empId) throws ClassNotFoundException, SQLException {
		
		return transactionDao.getAllBooksIssued(empId);
		
	}

	@Override
	public boolean checkAlreadyIssued(int empId, int id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return transactionDao.checkAlreadyIssued(empId,id);
	}
}
