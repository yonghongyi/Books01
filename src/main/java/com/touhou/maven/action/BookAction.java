package com.touhou.maven.action;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.touhou.maven.entity.Book;
import com.touhou.maven.service.BookService;

@Controller
public class BookAction {

	@Autowired
	private BookService bsi;

	//获取所有图书
	@RequestMapping("getList")
	public String getList(@RequestParam(value="bookId",required=false) String id,Map<String,Object> map){
		List<Book> books = bsi.getBooks();
		map.put("books", books);
		if(id==null||"".equals(id)){
			map.put("book",new Book());
		}
		System.out.println(books);
		return "index";
	}
	@RequestMapping("getBookById")
	public String getBookById(@RequestParam("bookId") String id,Map<String,Object> map){
		Book book = bsi.getBookById(id);
		map.put("book", book);
		if(id==null||"".equals(id)){
			map.put("book",new Book());
		}
		List<Book> books = bsi.getBooks();
		map.put("books", books);
		return "index";
	}
	@RequestMapping("addOrUpdate")
	public String addOrUpdate(Book book){
		System.out.println(book);
		bsi.addOrUpdate(book);
		return "redirect:/getList";
	}
	@RequestMapping("deleteBook")
	public String deleteBook(@RequestParam(value="bookId") int id){
		
		bsi.deleteBook(id);
		return "redirect:/getList";
	}
	@ModelAttribute
	public void book(@RequestParam(value="bookId",required=false) String id,Map<String,Object> map){
		
		if(id!=null&&!"".equals(id)){
			Book book = bsi.getBookById(id);
			map.put("book", book);
		}
	}
}
