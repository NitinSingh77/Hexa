package com.example.lba.LibraryBookManagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lba.LibraryBookManagement.exception.InvalidCredentialsException;
import com.example.lba.LibraryBookManagement.model.Book;
import com.example.lba.LibraryBookManagement.model.User;
import com.example.lba.LibraryBookManagement.repository.BookRepository;

@Service
public class BookService {

	
	@Autowired
	private BookRepository bookRepository;
public User authenticate(String username, String password) throws InvalidCredentialsException {
		
		return bookRepository.authenticate(username, password);
	}


	public void addBook(String username, Book book, String genre) {
		int user_id= bookRepository.getUserId(username);
		System.out.println(user_id);
		
		int genre_id= bookRepository.getgenreId(genre);
		bookRepository.addBook(user_id, genre_id, book);
		
		
	}


	public List<Book> fetchBook(String username) {
		
		return bookRepository.fetchExpense(username);
	}
}
