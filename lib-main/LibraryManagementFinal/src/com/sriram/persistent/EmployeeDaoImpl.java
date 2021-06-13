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

public class EmployeeDaoImpl implements EmployeeDao{	

	LocalDate today=LocalDate.now(ZoneId.of("Asia/Kolkata"));
	
	

	@Override
	public Employee printDetails(int empId, int bookId) throws ClassNotFoundException, SQLException {
		Connection connection = MySQLConnection.getConnection();

		PreparedStatement statement = connection.prepareStatement("select * from employee where id=?");
		statement.setInt(1, empId);
		
		ResultSet resultset = statement.executeQuery();
		
		Employee emp=null;
		emp=new Employee();
		while(resultset.next()) {
			emp.setEmpId(resultset.getInt("ID"));
			emp.setEmployeeFirstName(resultset.getString("FIRST_NAME"));
			emp.setEmployeeLastName(resultset.getString("LAST_NAME"));
			emp.setDepartment(resultset.getString("department"));
			emp.setEmail(resultset.getString("email"));
		}
		return emp;
	}


		@Override
		public boolean isValidEmployee(int empId) throws ClassNotFoundException, SQLException {
			Connection connection = MySQLConnection.getConnection();
			
			PreparedStatement statement = connection.prepareStatement("select id from employee");
			
			ResultSet resultSet = statement.executeQuery();
			
			while(resultSet.next()){
				if(empId == Integer.parseInt(resultSet.getString(1))) {
					return true;
				}
			}
			return false;
		}


		@Override
		public int getNoOfBooksIssued(int empId) throws ClassNotFoundException, SQLException {
			Connection connection = MySQLConnection.getConnection();
			
			PreparedStatement statement = connection.prepareStatement("select count from employee where id=?");
			statement.setInt(1,empId);
			ResultSet resultSet = statement.executeQuery();
			int result=0;
			if(resultSet.next()) {
				
				result=resultSet.getInt("count");
			}
			return result;
		}


		@Override
		public boolean increaseCount(int empId) throws ClassNotFoundException, SQLException {
			Connection connection = MySQLConnection.getConnection();
			
			PreparedStatement statement = connection.prepareStatement("update employee set count=count+? where id=?");
			statement.setInt(1, 1);
			statement.setInt(2, empId);
			
			int rows = statement.executeUpdate();

			if (rows > 0)
				return true;

			connection.close();
			return false;
		}


		@Override
		public boolean decreaseCount(int empId) throws ClassNotFoundException, SQLException {
			Connection connection = MySQLConnection.getConnection();
			
			PreparedStatement statement = connection.prepareStatement("update employee set count=count-? where id=?");
			statement.setInt(1, 1);
			statement.setInt(2, empId);
			
			int rows = statement.executeUpdate();

			if (rows > 0)
				return true;

			connection.close();
			return false;
		}





	
}