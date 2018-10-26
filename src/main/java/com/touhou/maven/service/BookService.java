package com.touhou.maven.service;

import java.util.List;

import com.touhou.maven.entity.Book;


public interface BookService {

	public void deleteBook(int id);
	
	public Book getBookById(String id);
	
	public List<Book> getBooks();
	
	public int addOrUpdate(Book book);
}
