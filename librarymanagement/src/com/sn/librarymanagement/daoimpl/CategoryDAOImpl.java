package com.sn.librarymanagement.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sn.librarymanagement.dao.CategoryDAO;
import com.sn.librarymanagement.model.Category;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Category> listCategories() {

		return sessionFactory.getCurrentSession()
				.createQuery("SELECT cat FROM Category cat WHERE cat.id != :id ", Category.class)
					.setParameter("id", 1L)
						.getResultList();
	}

	@Override
	public void addCategory(Category category) {

		try {
			sessionFactory.getCurrentSession().persist(category);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void updateCategory(Category category) {

		try {
			sessionFactory.getCurrentSession().update(category);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void deleteCategory(Category category) {

		category.setActive(false);
		try {
			sessionFactory.getCurrentSession().update(category);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public Category getCategory(long categoryId) {

		return sessionFactory.getCurrentSession().get(Category.class, categoryId);
	}

	@Override
	public List<Category> listRootCategories() {

		return sessionFactory.getCurrentSession()
				.createQuery("SELECT cat FROM Category cat WHERE cat.category.id = :pid OR cat.id = :cid",
						Category.class)
				.setParameter("pid", 1L).setParameter("cid", 1L).getResultList();
	}
}
