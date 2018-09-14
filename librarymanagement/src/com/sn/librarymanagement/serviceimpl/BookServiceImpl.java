package com.sn.librarymanagement.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.sn.librarymanagement.dao.BookDAO;
import com.sn.librarymanagement.model.Book;

@Service
@Repository
public class BookServiceImpl implements com.sn.librarymanagement.service.BookService {
   
   @Autowired
   private BookDAO bookDAO;
	
	
	@Override
	public List<Book> listBooks() {

		return bookDAO.listBooks();
	}

	@Override
	public void addBook(Book book) {
		 bookDAO.addBook(book);
	}

	@Override
	public void updateBook(Book book) {
		 bookDAO.updateBook(book);
	}

	@Override
	public void deleteBook(Book book) {
	
		 bookDAO.deleteBook(book);
	}

	@Override
	public List<Book> getLatestActiveBooks(long count) {
		
		return bookDAO.getLatestActiveBooks(count);
	}

	@Override
	public Book getBook(long id) {
		
		return bookDAO.getBook(id);
	}

}
