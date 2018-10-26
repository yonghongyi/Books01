package com.touhou.maven.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.touhou.maven.entity.Book;



@Repository
public class BookDaoImpl implements BookDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession(){
		
		return sessionFactory.getCurrentSession();
		//return sessionFactory.openSession();
	}
	
	public int saveOrUpdateBook(Book book){
		int i=0;
		getSession().saveOrUpdate(book);
		i=1;
		return i;
	}
	
	public void deleteBook(int bookId){
		
		
		getSession().delete(new Book(bookId,null,null,0,0));
	}
	
	public Book getBookById(int bookId){
		
		return (Book) getSession().get(Book.class,bookId);
	}
	
	@SuppressWarnings("unchecked")
	public List<Book> getBooks(){
		return getSession().createQuery("from Book").list();
	}
	
}
