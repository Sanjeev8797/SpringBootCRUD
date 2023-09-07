package com.example.demo.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Books;

@Repository
public interface BookRepositry extends JpaRepository<Books, Integer> {
	
@Query(nativeQuery = true,value = "select * from books where book_id = :id")
 public List<Books> test(int id);
  
public List<Books> findAllByAuthor(String auth);


}
