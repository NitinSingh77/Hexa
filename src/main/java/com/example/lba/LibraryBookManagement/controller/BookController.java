package com.example.lba.LibraryBookManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.lba.LibraryBookManagement.exception.InvalidCredentialsException;
import com.example.lba.LibraryBookManagement.model.Book;
import com.example.lba.LibraryBookManagement.model.User;
import com.example.lba.LibraryBookManagement.service.BookService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private BookGenreService bookgenreService;

    // Display login page
    @GetMapping("/")
    public String showLogin() {
        return "login";
    }

    // Handle login form submission
    @GetMapping("/login-form")
    public String handleLogin(HttpServletRequest req, HttpSession session) {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        try {
            User user = userService.verifyLogin(username, password);
            if (user.getRole().equalsIgnoreCase("librarian")) {
                session.setAttribute("username", username);
                List<Book> allBooks = bookService.fetchAllBooks();
                req.setAttribute("allBooks", allBooks);

                return "book_dashboard"; // Redirect to dashboard after login
            }
        } catch (InvalidCredentialsException e) {
            req.setAttribute("msg", e.getMessage());
            return "login";
        }
        return "login"; // If login fails, stay on login page
    }

    // Show all books on the dashboard
    @GetMapping("/book_dashboard")
    public String showDashboard(HttpServletRequest req, HttpSession session) {
        List<Book> books = bookService.fetchAllBooks();
        req.setAttribute("listBooks", books);
        return "book_dashboard";
    }

    // Add a new book
    @GetMapping("/add-book")
    public String addExpense(HttpServletRequest req, HttpSession session) {
    	Book book = new Book();
    	book.setAuthor(req.getParameter("author"));
    	book.setTitle(req.getParameter("title"));
    	book.setGenre(req.getParameter("genre"));
    	book.setPubication_year(req.getParameter("publication_year"));
    	
    	bookService.addBook(author)
    }

    // Delete a book
    @GetMapping("/delete-book")
    public String deleteBook(HttpServletRequest req) {
        int bookId = Integer.parseInt(req.getParameter("id"));
        bookService.deleteBookById(bookId);
        return "redirect:/book_dashboard"; // Redirect to dashboard after deleting a book
    }
}
