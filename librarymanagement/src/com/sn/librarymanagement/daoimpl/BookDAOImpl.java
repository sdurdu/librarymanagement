package com.sn.librarymanagement.daoimpl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sn.librarymanagement.dao.BookDAO;
import com.sn.librarymanagement.model.Book;
import com.sn.librarymanagement.model.Category;

@Repository("bookDAO")
@Transactional
public class BookDAOImpl implements BookDAO {
    @Autowired
	private SessionFactory sessionFactory;
	
    
	@Override
	public List<Book> listBooks() {
	
		return sessionFactory
				.getCurrentSession()
					.createQuery("FROM Book WHERE active = :active",Book.class).setParameter("active", true)
						.getResultList();
	}

	@Override
	public void addBook(Book book) {
		
		try {
				sessionFactory.getCurrentSession().persist(book);
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}	
	}

	@Override
	public void updateBook(Book book) {
		
		try {
				sessionFactory.getCurrentSession().update(book);
				
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void deleteBook(Book book) {
		book.setActive(false);
		
		try {
			sessionFactory.getCurrentSession().update(book);
		
	} catch (Exception ex) {
		ex.printStackTrace();
	}
	
		
	}

	@Override
	public List<Book> getLatestActiveBooks(long count) {
		return sessionFactory
				.getCurrentSession()
					.createQuery("FROM Book WHERE active = :active ORDER BY id DESC", Book.class)
						.setParameter("active", true)
							.setFirstResult(0)
							.setMaxResults((int)count)
								.getResultList();	
	}

	@Override
	public Book getBook(long id) {
		
	return sessionFactory.getCurrentSession().get(Book.class, id);
	
	}

}
