package com.touhou.maven.dao;

import java.util.List;

import org.hibernate.Session;

import com.touhou.maven.entity.Book;



public interface BookDao {

	public void deleteBook(int id);
	
	public Book getBookById(int id);
	
	public List<Book> getBooks();
	
	public Session getSession();
	
	public int saveOrUpdateBook(Book book);
}
