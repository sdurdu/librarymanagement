package com.sn.librarymanagement.service;

import java.util.List;

import com.sn.librarymanagement.model.Book;

public interface BookService {

	Book getBook(long id);
	void addBook(Book book);
	void updateBook(Book book);
    void deleteBook(Book book);
    List<Book> listBooks();
    List<Book> getLatestActiveBooks(long count);	
}
