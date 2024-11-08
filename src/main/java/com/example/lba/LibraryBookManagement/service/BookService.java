package com.example.lba.LibraryBookManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lba.LibraryBookManagement.model.Book;
import com.example.lba.LibraryBookManagement.repository.BookRepository;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    // Fetch all books from the repository
    public List<Book> fetchAllBooks() {
        return bookRepository.fetchAllBooks();
    }

    // Save a book into the database
    public void saveBook(Book book) {
        bookRepository.addBook(book);
    }

    // Delete a book by its ID
    public void deleteBookById(int id) {
        bookRepository.deleteBook(id);
    }
}
