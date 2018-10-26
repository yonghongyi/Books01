package com.touhou.maven.entity;

public class Book {

	private Integer bookId;
	private String bookName;
	private String author;
	private int stock;
	private double price;
	
	public Book(Integer bookId, String bookName, String author, int stock, double price) {
	super();
	this.bookId = bookId;
	this.bookName = bookName;
	this.author = author;
	this.stock = stock;
	this.price = price;
}
public Book() {
	super();
}
public Integer getBookId() {
	return bookId;
}
public void setBookId(Integer bookId) {
	this.bookId = bookId;
}
public String getBookName() {
	return bookName;
}
public void setBookName(String bookName) {
	this.bookName = bookName;
}
public String getAuthor() {
	return author;
}
public void setAuthor(String author) {
	this.author = author;
}
public int getStock() {
	return stock;
}
public void setStock(int stock) {
	this.stock = stock;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
@Override
public String toString() {
	return "Book [bookId=" + bookId + ", bookName=" + bookName + ", author=" + author + ", stock=" + stock + ", price="
			+ price + "]";
};
	
	
	
}
