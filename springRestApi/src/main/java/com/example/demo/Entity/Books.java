package com.example.demo.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="books")
public class Books {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="bookId")
private int bookId;
private String title;
private String author;
public Books() {
	super();
	// TODO Auto-generated constructor stub
}
public Books(int id, String title, String author) {
	super();
	this.bookId = id;
	this.title = title;
	this.author = author;
}
public int getId() {
	return bookId;
}
public void setId(int id) {
	this.bookId = id;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getAuthor() {
	return author;
}
public void setAuthor(String author) {
	this.author = author;
}
@Override
public String toString() {
	return "Books [id=" + bookId + ", title=" + title + ", author=" + author + "]";
}

}
