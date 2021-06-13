package com.sriram.service;

import java.sql.SQLException;
import java.util.ArrayList;

public interface TransactionService {
	boolean updateTransaction(int empId,int bookId) throws ClassNotFoundException, SQLException;
	boolean removeTransaction(int empId, int bookId) throws ClassNotFoundException, SQLException;
	int returnBook(int empId, int bookId) throws ClassNotFoundException, SQLException;
	boolean authenticate(String username, String password) throws ClassNotFoundException, SQLException;
	ArrayList<Integer> getAllBooksIssued(int empId) throws ClassNotFoundException, SQLException;
	boolean checkAlreadyIssued(int empId, int id) throws ClassNotFoundException, SQLException;
}
