package com.example.lba.LibraryBookManagement.model;

public class Book {
	private int id;
	private String title;
	private String author;
	private String pubication_year;
	
	private BookGenre bookGenre;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getPubication_year() {
		return pubication_year;
	}

	public void setPubication_year(String pubication_year) {
		this.pubication_year = pubication_year;
	}

	public BookGenre getBookGenre() {
		return bookGenre;
	}

	public void setBookGenre(BookGenre bookGenre) {
		this.bookGenre = bookGenre;
	}
	
	
	
}
