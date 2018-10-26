package com.touhou.maven.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.touhou.maven.dao.BookDaoImpl;
import com.touhou.maven.entity.Book;

@Service
@Transactional
public class BookServiceImpl implements BookService{

	@Autowired
	private BookDaoImpl bookDao;
	
	public List<Book> getBooks(){
		return bookDao.getBooks();
	}
	
	public Book getBookById(String bookId){
		
		return bookDao.getBookById(Integer.parseInt(bookId));
	}
	public int addOrUpdate(Book book){
		
		int i = bookDao.saveOrUpdateBook(book);
		return i;
		
	}
	public void deleteBook(int bookId){
		bookDao.deleteBook(bookId);
	}
	
	public String hello(){
		return "dasdasdqweqead幻想乡";
	}



	
}
