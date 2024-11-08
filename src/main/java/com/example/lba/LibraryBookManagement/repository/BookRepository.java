package com.example.lba.LibraryBookManagement.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.lba.LibraryBookManagement.model.Book;

@Repository
public class BookRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Book> fetchAllBooks() {
        String sql = "SELECT * FROM book";
        return jdbcTemplate.query(sql, new RowMapper<Book>() {

            @Override
            public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
                Book book = new Book();
                book.setId(rs.getInt("id"));
                book.setTitle(rs.getString("title"));
                book.setAuthor(rs.getString("author"));
                book.setPubication_year(rs.getString("publication_year"));
                book.setBookGenre(rs.getString("genre"));
                return book;
            }
        });
    }

    

    public void addBook(Book book) {
        String sql = "INSERT INTO book (title, author, publication_year, genre) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, book.getTitle(), book.getAuthor(), book.getPubication_year(), book.getGenre());
    }

    public void deleteBook(int bookId) {
        String sql = "DELETE FROM book WHERE id = ?";
        jdbcTemplate.update(sql, bookId);
    }



}
