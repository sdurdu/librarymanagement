package com.sn.librarymanagement.service;

import java.util.List;

import com.sn.librarymanagement.model.Book;

public interface BookService {

	List<Book> listBooks();
	void addBook(Book book);
	void updateBook(Book book);
    void deleteBook(Book book);
    List<Book> getLatestActiveBooks(long count);
    Book getBook(long id);
	
}
