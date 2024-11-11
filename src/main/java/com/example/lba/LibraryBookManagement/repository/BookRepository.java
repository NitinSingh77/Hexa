package com.example.lba.LibraryBookManagement.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.swing.tree.RowMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Repository;

import com.example.lba.LibraryBookManagement.exception.InvalidCredentialsException;
import com.example.lba.LibraryBookManagement.model.Book;
import com.example.lba.LibraryBookManagement.model.BookGenre;
import com.example.lba.LibraryBookManagement.model.User;

@Repository
public class BookRepository {

	@Autowired
	private JdbcTemplate jdbc;
	
	
	public User authenticate(String username, String password) throws InvalidCredentialsException {
		String sql= "select * from user where username= ? and password= ?";
		
		PreparedStatementCreator psc= new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException{
				PreparedStatement pstmt= con.prepareStatement(sql);
				pstmt.setString(1,  username);
				pstmt.setString(2, password);
				return pstmt;
				
			}
		};
		RowMapper<User>  rm = new RowMapper<User>(){

			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User user = new User();
				user.setId(rs.getInt("user_id"));
				user.setUsername(username);
				user.setPassword(password);
				return user;
			}
			
		};
		List<User> list = jdbc.query(psc, rm);
		 if(list.isEmpty()) {
			 throw new InvalidCredentialsException("Invalid Credentials");
		 }
		 else
		 return list.get(0);
	}
	
	public int getUserId(String username) {
		String sql = "select user_id from users where username=?";
		PreparedStatementCreator psc = new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, username);
				return pstmt;	
			}
			
		};
		
		RowMapper<User>  rm = new RowMapper<User>(){

			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User user = new User();
				user.setId(rs.getInt("user_id"));
				
				return user;				
				
			}
			
		};	
		List<User> user = jdbc.query(psc, rm);
		
		User obj = user.get(0);
		return obj.getId();
	
	}
	
	
	
	public int getgenreId(String category) {
		String sql = " select category_id from expensecategories where category_name =?";
		PreparedStatementCreator psc = new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, category);
				return pstmt;	
			}
			
		};
		
		RowMapper<BookGenre>  rm = new RowMapper<BookGenre>(){

			@Override
			public ExpenseCategory mapRow(ResultSet rs, int rowNum) throws SQLException {
				ExpenseCategory ec = new ExpenseCategory();
				ec.setId(rs.getInt("category_id"));
				
				return ec;				
				
			}
			
		};	
		List<BookGenre> ec = jdbc.query(psc, rm);
		
		BookGenre obj = ec.get(0);
		return obj.getId();
		
	}

	public List<Book> fetchExpense(String username) {
		String sql = "select e.* ,ec.category_name from users u join expenses e on u.user_id = e.user_id join expensecategories ec on e.category_id= ec.category_id where u.username =? and e.is_active=true";
		PreparedStatementCreator psc = new PreparedStatementCreator(){

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, username);
				return pstmt;
				
			}
			
		};
		RowMapper<Book>  rm = new RowMapper<Book>(){

			@Override
			public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
				Book book = new Book();
				book.setExpense_id(rs.getInt("id"));
				book.set
				book.setDate(rs.getDate("date"));
				book.setDescription(rs.getString("description"));
				BookGenre bookgenre = new BookGenre();
				bookgenre.setExpenseCategory(rs.getString("category_name"));
				bookgenre.setExpenseCategory(expenseCategory);
				return expense;
				
				
			}
			
		};	
		List<Book> expenses = jdbc.query(psc, rm);
		return expenses;
	}


}
