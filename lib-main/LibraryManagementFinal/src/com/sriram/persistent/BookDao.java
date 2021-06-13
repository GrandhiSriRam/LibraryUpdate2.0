package com.sriram.persistent;

import java.sql.SQLException;
import java.util.ArrayList;

import com.sriram.bean.Book;
import com.sriram.bean.Employee;

public interface BookDao {
	ArrayList<Book> showAvailableDataAnalytics() throws SQLException, ClassNotFoundException;
	ArrayList<Book> showAvailableTechnology() throws SQLException, ClassNotFoundException;
	ArrayList<Book> showAvailableManagement() throws SQLException, ClassNotFoundException;
	String getBookType(int bookId) throws ClassNotFoundException, SQLException;	
	boolean selectDataAnalytics(int id) throws SQLException, ClassNotFoundException;
	boolean selectTechnology(int id) throws SQLException, ClassNotFoundException;
	boolean selectManagement(int id) throws SQLException, ClassNotFoundException;
	ArrayList<Book> viewAllBooks() throws ClassNotFoundException,SQLException;
	Book printBookDetails(int bookId)throws ClassNotFoundException, SQLException;
	
	boolean increaseQuantity(int bookId) throws ClassNotFoundException, SQLException;
	

}