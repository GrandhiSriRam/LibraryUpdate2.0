package com.sriram.bean;

public class Book {
	private int bookID;
	private String title;
	private String author;
	private String category;
	private int quantity;
	
	
	public Book(int bookID, String title, String author, String category, int quantity) {
		super();
		this.bookID = bookID;
		this.title = title;
		this.author = author;
		this.category = category;
		this.quantity = quantity;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Book() {
		
	}
	public int getBookID() {
		return bookID;
	}
	public void setBookID(int bookID) {
		this.bookID = bookID;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBookCategory() {
		return category;
	}
	public void setBookCategory(String category) {
		this.category = category;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "" + bookID + " | " + category + " | " + author + "  -   " + title+ " (" + quantity + ")";
		
	}
	
	
	
}