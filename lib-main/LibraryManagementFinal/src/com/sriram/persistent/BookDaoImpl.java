package com.sriram.persistent;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.time.*;
import com.sriram.bean.Book;

import com.sriram.bean.Employee;
import com.sriram.helper.MySQLConnection;

public class BookDaoImpl implements BookDao{	

	LocalDate today=LocalDate.now(ZoneId.of("Asia/Kolkata"));
	
	@Override
	public ArrayList<Book> showAvailableDataAnalytics() throws SQLException, ClassNotFoundException{
		ArrayList<Book> books = null;
		Connection connection = MySQLConnection.getConnection();

		PreparedStatement statement = connection.prepareStatement("select * from BOOKS where category=? and quantity>?");
		statement.setString(1, "DATA ANALYTICS");
		statement.setInt(2, 0);
		ResultSet resultset = statement.executeQuery();

		Book book = null;
		books = new ArrayList<Book>();
		
		while(resultset.next()) {
			book=new Book();
			book.setBookID(resultset.getInt("id"));
			book.setBookCategory(resultset.getString("category"));
			book.setTitle(resultset.getString("title"));
			book.setAuthor(resultset.getString("author"));
			book.setQuantity(resultset.getInt("quantity"));
			
			books.add(book);
		}
		connection.close();
		return books;
	}


	@Override
	public ArrayList<Book> showAvailableTechnology() throws SQLException, ClassNotFoundException {
		ArrayList<Book> books = null;
		Connection connection = MySQLConnection.getConnection();

		PreparedStatement statement = connection.prepareStatement("select * from BOOKS where category=? and quantity>?");
		statement.setString(1, "TECHNOLOGY");
		statement.setInt(2, 0);
		ResultSet resultset = statement.executeQuery();

		Book book = null;
		books = new ArrayList<Book>();
		
		while(resultset.next()) {
			book=new Book();
			book.setBookID(resultset.getInt("id"));
			book.setBookCategory(resultset.getString("category"));
			book.setTitle(resultset.getString("title"));
			book.setAuthor(resultset.getString("author"));
			book.setQuantity(resultset.getInt("quantity"));
			
			books.add(book);
		}
		connection.close();
		return books;
	}
	
	@Override
	public ArrayList<Book> showAvailableManagement() throws SQLException, ClassNotFoundException {
		ArrayList<Book> books = null;
		Connection connection = MySQLConnection.getConnection();

		PreparedStatement statement = connection.prepareStatement("select * from BOOKS where category=? and quantity>?");
		statement.setString(1, "MANAGEMENT");
		statement.setInt(2, 0);
		ResultSet resultset = statement.executeQuery();

		Book book = null;
		books = new ArrayList<Book>();
		
		while(resultset.next()) {
			book=new Book();
			book.setBookID(resultset.getInt("id"));
			book.setBookCategory(resultset.getString("category"));
			book.setTitle(resultset.getString("title"));
			book.setAuthor(resultset.getString("author"));
			book.setQuantity(resultset.getInt("quantity"));
			books.add(book);
		}
		connection.close();
		return books;
	}


	@Override
	public boolean selectDataAnalytics(int id) throws SQLException, ClassNotFoundException {
		Connection connection = MySQLConnection.getConnection();
		
		PreparedStatement statement = connection.prepareStatement("update books set quantity=quantity-? where id=?");
		statement.setInt(1, 1);
		statement.setInt(2, id);
		
		int rows = statement.executeUpdate();

		if (rows > 0)
			return true;

		connection.close();
		return false;
	}


	@Override
	public boolean selectTechnology(int id) throws SQLException, ClassNotFoundException {
		
		Connection connection = MySQLConnection.getConnection();
		
		PreparedStatement statement = connection.prepareStatement("update books set quantity=quantity-? where id=?");
		statement.setInt(1, 1);
		statement.setInt(2, id);
		
		int rows = statement.executeUpdate();

		if (rows > 0)
			return true;

		connection.close();
		return false;
	}


	@Override
	public boolean selectManagement(int id) throws SQLException, ClassNotFoundException {
		
		Connection connection = MySQLConnection.getConnection();
		
		PreparedStatement statement = connection.prepareStatement("update books set quantity=quantity-? where id=?");
		statement.setInt(1, 1);
		statement.setInt(2, id);
		
		int rows = statement.executeUpdate();

		if (rows > 0)
			return true;

		connection.close();
		return false;
	}


	@Override
	public ArrayList<Book> viewAllBooks() throws ClassNotFoundException, SQLException {
		Connection connection = MySQLConnection.getConnection();
		
		PreparedStatement statement = connection.prepareStatement("select * from books");
		
		ResultSet resultSet = statement.executeQuery();
		
		Book book = null;
		
		ArrayList<Book> books = null;
		
		books = new ArrayList<Book>();
		while(resultSet.next()) {
			book=new Book();
			book.setBookID(resultSet.getInt("id"));
			book.setBookCategory(resultSet.getString("category"));
			book.setTitle(resultSet.getString("title"));
			book.setAuthor(resultSet.getString("author"));
			book.setQuantity(resultSet.getInt("quantity"));
			
			books.add(book);
		}
		connection.close();
		return books;
		
	}


	@Override
	public String getBookType(int bookId) throws ClassNotFoundException, SQLException {
		
		Connection connection = MySQLConnection.getConnection();
		
		PreparedStatement statement = connection.prepareStatement("select category from books where id=?");
		
		statement.setInt(1, bookId);
		
		ResultSet resultSet = statement.executeQuery();
		if(resultSet.next()) {
			String cat=resultSet.getString("category");
			
			return cat;
		}
		return "-1";
	}





	@Override
	public boolean increaseQuantity(int bookId) throws ClassNotFoundException, SQLException {
		
		Connection connection = MySQLConnection.getConnection();
		
		PreparedStatement statement = connection.prepareStatement("update books set quantity=quantity+? where id=?");
		statement.setInt(1, 1);
		statement.setInt(2, bookId);
		
		int rows = statement.executeUpdate();
		
		if (rows > 0) {
			
			return true;
		}
		else {
			
			return false;
		}
		
	}


	@Override
	public Book printBookDetails(int bookId) throws ClassNotFoundException, SQLException {
		Connection connection = MySQLConnection.getConnection();

		PreparedStatement statement = connection.prepareStatement("select * from books where id=?");
		statement.setInt(1, bookId);
		
		ResultSet resultset = statement.executeQuery();
		
		Book book=null;
		book=new Book();
		while(resultset.next()) {
			book.setBookID(resultset.getInt("id"));
			book.setBookCategory(resultset.getString("category"));
			book.setTitle(resultset.getString("title"));
			book.setAuthor(resultset.getString("author"));
		}
		return book;
	}






	
}