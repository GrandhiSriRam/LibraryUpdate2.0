package com.sriram.bean;

public class Transaction {
	int empId;
	int bookID;
	public Transaction(int empId, int bookID) {
		super();
		this.empId = empId;
		this.bookID = bookID;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public int getBookID() {
		return bookID;
	}
	public void setBookID(int bookID) {
		this.bookID = bookID;
	}

}