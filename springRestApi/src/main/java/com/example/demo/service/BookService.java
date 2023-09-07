package com.example.demo.service;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.Dao.BookRepositry;
import com.example.demo.Entity.Books;
@Service
public class BookService {
	@Autowired
	private BookRepositry bookRepositry;
//	public static List<Books> list= new ArrayList();
//	static {
//		list.add(new Books(101,"java programming","Som prakash"));
//		list.add(new Books(102,"c++ programming ","jesh"));
//		list.add(new Books(103,"C programming","Som prakash"));
//		list.add(new Books(104,"Python programming ","Rahul"));
//		list.add(new Books(105,"PHP programming","Kundan"));
//		list.add(new Books(106,"BOOT programming ","Bajrangi"));
	//}
	
	public List<Books> getAllBooks(){
		return bookRepositry.findAll();
	}
	public Books findById(int id){
		Books book=null;
		try {
		//book=list.stream().filter(e->e.getId()==id).findAny().orElse(null);
			 book = bookRepositry.findById(id).get();
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		 
		return book;
	}
	//Add book
	public Books addBook(Books b) {
		Books book=bookRepositry.save(b);
		return book;
	}
	// delete book
	public void deletBook(int id) {
		//list.stream().filter(book->book.getId()!=id).collect(Collectors.toList());
		bookRepositry.deleteById(id);
	}
	//Update Books
	public void updateBook(Books book, int bookId) {
//		list.stream().map(b->{
//			if(b.getId()==bookId) {
//				b.setAuthor(book.getAuthor());
//				b.setTitle(book.getTitle());
//			}
//			return b;
//		}).collect(Collectors.toList());
		book.setId(bookId);
		bookRepositry.save(book);
	}
	
	public ResponseEntity<?> getBookById(int id){
		List <Books> list = new ArrayList<>();
		list.addAll(bookRepositry.test(id));
		return new ResponseEntity(list,HttpStatus.OK);
	}
	public ResponseEntity<?> getBookByAutherName(String  authName){
		List <Books> list = new ArrayList<>();
		list.addAll(bookRepositry.findAllByAuthor(authName));
		return new ResponseEntity(list,HttpStatus.OK);
	}

}
