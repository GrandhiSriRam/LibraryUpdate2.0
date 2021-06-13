package com.sriram.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.sriram.bean.Book;
import com.sriram.persistent.BookDao;
import com.sriram.persistent.BookDaoImpl;

public class BookServiceImpl implements BookService{
	private BookDao bookDao=new BookDaoImpl();
	@Override
	public ArrayList<Book> showDataAnalytics() throws SQLException, ClassNotFoundException {
		
		return bookDao.showAvailableDataAnalytics();
		
	}

	@Override
	public ArrayList<Book> showTechnology() throws SQLException, ClassNotFoundException{
		
		 return bookDao.showAvailableTechnology();
	}
	
	@Override
	public ArrayList<Book> showManagement() throws ClassNotFoundException, SQLException {
	
		return bookDao.showAvailableManagement();
	}
	@Override
	public boolean selectDataAnalytics(int id) throws ClassNotFoundException, SQLException {
	
		return bookDao.selectDataAnalytics(id);
	}

	@Override
	public boolean selectTechnology(int id) throws ClassNotFoundException, SQLException {
		return bookDao.selectTechnology(id);
	}

	@Override
	public boolean selectManagement(int id) throws ClassNotFoundException, SQLException {
		return bookDao.selectDataAnalytics(id);
	}
	
	@Override
	public ArrayList<Book> viewAllBooks() throws ClassNotFoundException, SQLException {
		
		 return bookDao.viewAllBooks();
		
	}
	@Override
	public String getBookType(int bookId) throws ClassNotFoundException, SQLException {
		
		return bookDao.getBookType(bookId);
	}
	
	@Override
	public boolean increaseQuantity(int bookId) throws ClassNotFoundException, SQLException {
		
		return bookDao.increaseQuantity(bookId);
	}
	@Override
	public Book printBookDetails(int bookId) throws ClassNotFoundException, SQLException {
		
		return bookDao.printBookDetails(bookId);
	}

}
