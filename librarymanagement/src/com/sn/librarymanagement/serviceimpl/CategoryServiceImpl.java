package com.sn.librarymanagement.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.sn.librarymanagement.dao.CategoryDAO;
import com.sn.librarymanagement.model.Category;
import com.sn.librarymanagement.service.CategoryService;

@Service
@Repository
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDAO categoryDAO;

	@Override
	public List<Category> listCategories() {

		return categoryDAO.listCategories();
	}

	@Override
	public void addCategory(Category category) {

		categoryDAO.addCategory(category);
	}

	@Override
	public void updateCategory(Category category) {

		categoryDAO.updateCategory(category);
	}

	@Override
	public void deleteCategory(Category category) {

		categoryDAO.deleteCategory(category);
	}

	@Override
	public Category getCategory(long categoryId) {

		return categoryDAO.getCategory(categoryId);
	}

	@Override
	public List<Category> listRootCategories() {

		return categoryDAO.listRootCategories();
	}

}
