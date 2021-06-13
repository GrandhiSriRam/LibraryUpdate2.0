package com.sriram.persistent;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.time.*;
import com.sriram.bean.Book;

import com.sriram.bean.Employee;
import com.sriram.helper.MySQLConnection;

public class TransactionDaoImpl implements TransactionDao{	

	LocalDate today=LocalDate.now(ZoneId.of("Asia/Kolkata"));
	
		@Override
	public boolean updateTransaction(int empId,int bookId) throws SQLException,ClassNotFoundException {
		Connection connection = MySQLConnection.getConnection();
		
		PreparedStatement statement = connection.prepareStatement("insert into transaction values(?,?,?)");
		statement.setInt(1, empId);
		statement.setInt(2, bookId);
		statement.setObject(3, today);
		
		int rows=statement.executeUpdate();
		if (rows > 0)
			return true;

		connection.close();

		return false;
		
	}


	@Override
	public boolean authenticate(String username, String password) throws ClassNotFoundException, SQLException {
		Connection connection = MySQLConnection.getConnection();
		
		PreparedStatement statement = connection.prepareStatement("select * from auth");
		
		ResultSet resultSet = statement.executeQuery();
		
		while(resultSet.next()){
			if(username.equals(resultSet.getString(1)) && password.equals(resultSet.getString(2))) {
				return true;
			}
		}
		
		return false;
	}
	@Override
	public boolean removeTransaction(int empId, int bookId) throws ClassNotFoundException, SQLException {
		Connection connection = MySQLConnection.getConnection();
		
		PreparedStatement statement = connection.prepareStatement("delete from transaction where empid=? and bookid=?");
		
		statement.setInt(1, empId);
		statement.setInt(2, bookId);
		int resultSet = statement.executeUpdate();	
		if(resultSet>0) return true;
		return false;
		
	}
	
	@Override
	public ArrayList<Integer> getAllBooksIssued(int empId) throws ClassNotFoundException, SQLException{
		ArrayList<Integer>arr=new ArrayList<>();
		Connection connection = MySQLConnection.getConnection();

		PreparedStatement statement = connection.prepareStatement("select bookid from transaction where empid=? ");
		statement.setInt(1, empId);
		
		ResultSet resultset = statement.executeQuery();
		while(resultset.next()) {
			arr.add(resultset.getInt("bookid"));
		}
		return arr;
	}
	@Override
	public int returnBook(int empId, int bookId) throws ClassNotFoundException, SQLException {
		
		Connection connection = MySQLConnection.getConnection();
		
		PreparedStatement statement = connection.prepareStatement("select date_lent from transaction where empid=? and bookid=?");
		
		statement.setInt(1,empId);
		
		statement.setInt(2, bookId);
		
		ResultSet resultSet = statement.executeQuery();
		if(resultSet.next()) {
			
			LocalDate lent=resultSet.getObject(1,LocalDate.class);
			
			Period period=Period.between(lent, today);
			
			return period.getDays();
		}
		else return -1;
		
	}


	@Override
	public boolean checkAlreadyIssued(int empId, int id) throws ClassNotFoundException, SQLException {
		Connection connection = MySQLConnection.getConnection();
		
		PreparedStatement statement = connection.prepareStatement("select empid,bookid from transaction where empid=? and bookid=?");
		
		statement.setInt(1,empId);
		
		statement.setInt(2, id);
		ResultSet resultSet = statement.executeQuery();
		if(resultSet.next()) {
			return true;
		}
		return false;
	}

	
}