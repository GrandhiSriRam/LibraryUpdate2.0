package com.sriram.presentation;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;
import com.sriram.bean.Book;
import com.sriram.bean.Employee;
import com.sriram.service.BookService;
import com.sriram.service.BookServiceImpl;
import com.sriram.service.EmployeeService;
import com.sriram.service.EmployeeServiceImpl;
import com.sriram.service.TransactionService;
import com.sriram.service.TransactionServiceImpl;


public class EmployeePresentationImpl implements EmployeePresentation{
	
	Scanner sc=new Scanner(System.in);
	
	private EmployeeService employeeService=new EmployeeServiceImpl();
	private BookService bookService=new BookServiceImpl();
	private TransactionService transactionService=new TransactionServiceImpl();
	private int empId;
	boolean success1,success2,success3;
	LocalDate today=LocalDate.now(ZoneId.of("Asia/Kolkata"));
	LocalDate due=today.plusDays(7);

	@Override
	public void showMenuEmp() {
		
		System.out.println("=============================================================================");
		System.out.println("1. Issue a book");
		System.out.println("2. Return a book");
		System.out.println("3. View all books");
		System.out.println("4. Exit");
		System.out.println("=============================================================================");
	}
	
	@Override
	public boolean authenticate(String username, String password) {
		this.empId=Integer.parseInt(username);
		try {
			if(transactionService.authenticate(username,password)) {
				
				System.out.println("=============================================================================");
				System.out.println("Login successful");
				System.out.println("=============================================================================");
				return true;
			}
				
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void performMenuEmp(int choice) {
		try {
			if(employeeService.isValidEmployee(empId)) {
				switch(choice) {
				case 1:
					int issued = employeeService.getNoOfBooksIssued(empId);
					if(issued>=5) {System.out.println("You have exceeded the maximum limit.");break;}
					System.out.println("Please enter the type of book you want:\n\na. DATA ANALYTICS\nb. TECHNOLOGY\nc. MANAGEMENT\n\n");
					String s=sc.next();
					if(!s.equals("a") && !s.equals("b") && !s.equals("c")) {System.out.println("Please enter valid input");break;}
					if(s.equals("a")) {
						ArrayList<Book>books=null;
						try {
							books = bookService.showDataAnalytics();
						} catch (ClassNotFoundException | SQLException e) {
							
							e.printStackTrace();
						}
						
						for(Book b:books) {
							System.out.println(b);
						}
						System.out.println("=============================================================================");
						System.out.println("Please select the book id from the above available books");
						System.out.println("=============================================================================");
						
						int id=sc.nextInt();
						boolean already=transactionService.checkAlreadyIssued(empId,id);
						if(already) {System.out.println("The selected book has already been issued to the employee...");break;}
						try {
							success1=bookService.selectDataAnalytics(id);
							
						} catch (ClassNotFoundException | SQLException e) {
							e.printStackTrace();
						}
						if(success1) {
							System.out.println("=============================================================================");
							System.out.println("Book issued successfully!!");
							System.out.println("Return Date : "+due);
							System.out.println("=============================================================================");
							try {
								transactionService.updateTransaction(empId,id);
							} catch (ClassNotFoundException | SQLException e) {
								e.printStackTrace();
							}
						}
						else {
							System.out.println("=============================================================================");
							System.out.println("Book issue failed!! Please select valid ID");
							System.out.println("=============================================================================");
						}
					}
					else if(s.equals("b")) {
						ArrayList<Book>books=null;
						try {
							books = bookService.showTechnology();
						} catch (ClassNotFoundException | SQLException e) {
							
							e.printStackTrace();
						}
						
						for(Book b:books) {
							System.out.println(b);
						}
						System.out.println("=============================================================================");
						System.out.println("Please select the book id from the above available books");
						System.out.println("=============================================================================");
						int id=sc.nextInt();
						boolean already=transactionService.checkAlreadyIssued(empId,id);
						if(already) {System.out.println("The selected book has already been issued to the employee...");break;}
						try {
							success2=bookService.selectDataAnalytics(id);
						} catch (ClassNotFoundException | SQLException e) {
							e.printStackTrace();
						}
						if(success2) {
							System.out.println("=============================================================================");
							System.out.println("Book issued successfully!!");
							System.out.println("Return Date : "+due);
							System.out.println("=============================================================================");
							try {
								transactionService.updateTransaction(empId,id);
							} catch (ClassNotFoundException | SQLException e) {
								e.printStackTrace();
							}
						}
						else {
							System.out.println("Book issue failed!! Please select valid ID");
						}
					}
					else if(s.equals("c")) {
						ArrayList<Book>books=null;
						try {
							books = bookService.showManagement();
						} catch (ClassNotFoundException | SQLException e) {
							
							e.printStackTrace();
						}
						
						for(Book b:books) {
							System.out.println(b);
						}
						System.out.println("=============================================================================");
						System.out.println("Please select the book id from the above available books");
						System.out.println("=============================================================================");
						int id=sc.nextInt();
						boolean already=transactionService.checkAlreadyIssued(empId,id);
						if(already) {System.out.println("The selected book has already been issued to the employee...");break;}
						try {
							success3=bookService.selectDataAnalytics(id);
						} catch (ClassNotFoundException | SQLException e) {
							e.printStackTrace();
						}
						if(success3) {
							System.out.println("=============================================================================");
							System.out.println("Book issued successfully!! Return Date is "+due);
							System.out.println("=============================================================================");
							try {
								transactionService.updateTransaction(empId,id);
							} catch (ClassNotFoundException | SQLException e) {
								e.printStackTrace();
							}
						}
						else {
							System.out.println("=============================================================================");
							System.out.println("Book issue failed!! Please select valid ID");
							System.out.println("=============================================================================");
						}
					}
					if(success1 || success2 || success3) {
						employeeService.increaseCount(empId);
					}
						break;
				case 2:
					ArrayList<Integer>arr=transactionService.getAllBooksIssued(empId);
					if(arr.size()==0) {System.out.println("No nooks are issued for you to return!!");break;}
					else {
						System.out.println("The books issued to the employee with id : "+empId+" are :");
						for(int i:arr) {
							System.out.println(i);
						}
					}
					System.out.println("=============================================================================");
					System.out.println("Please enter the bookId to return");
					System.out.println("=============================================================================");
					int bookId=sc.nextInt();
					int days=transactionService.returnBook(empId,bookId);
					if(transactionService.removeTransaction(empId,bookId) && bookService.increaseQuantity(bookId)){
						Employee e=employeeService.printDetails(empId,bookId);
						Book b= bookService.printBookDetails(bookId);
						//System.out.print("Welcome.. ");
	
						System.out.println(e);
						System.out.println(b);

						
						String bookType=bookService.getBookType(bookId);
						boolean flag=employeeService.decreaseCount(empId);
						if(bookType.equalsIgnoreCase("data analytics")) {
							if(days>7) {
								days-=7;
								System.out.println("=============================================================================");
								System.out.println("You are late by "+days+" days so,");
								System.out.println("Please pay the fine of Rs. "+days*5);
								System.out.println("=============================================================================");
							}
							else {
								System.out.println("=============================================================================");
								System.out.println("Returned successfully with no fine");
								System.out.println("=============================================================================");
							}
						}
						if(bookType.equalsIgnoreCase("technology")) {
							if(days>7) {
								
								days-=7;
								System.out.println("=============================================================================");
								System.out.println("You are late by "+days+" days so,");
								System.out.println("Please pay the fine of Rs. "+days*6);
								System.out.println("=============================================================================");
							}
							else {
								System.out.println("Returned successfully with no fine");
							}
						}
						if(bookType.equalsIgnoreCase("management")) {
							if(days>7) {
								
								days-=7;
								System.out.println("=============================================================================");
								System.out.println("You are late by "+days+" days so,");
								System.out.println("Please pay the fine of Rs. "+days*7);
								System.out.println("=============================================================================");
							}
							else {
								System.out.println("=============================================================================");
								System.out.println("Returned successfully with no fine");
								System.out.println("=============================================================================");
							}
						}
					}else {
						System.out.println("EROR 404!!! TRANSACTION NOT FOUND");
					}
					break;
				case 3:
					ArrayList<Book>books = bookService.viewAllBooks();
					for(Book b1:books) {
						System.out.println(b1);
					}
					break;
				case 4:
					System.exit(0);
				default:
					System.out.println("Please enter valid option");
					break;
				}
			}
			else {
				System.out.println("Please enter valid ID");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}