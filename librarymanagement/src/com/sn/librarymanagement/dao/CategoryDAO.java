package com.sn.librarymanagement.dao;

import java.util.List;

import com.sn.librarymanagement.model.Category;

public interface CategoryDAO {
	
	Category getCategory(long categoryId);
	void addCategory(Category category);
	void updateCategory(Category category);
	void deleteCategory(Category category);
	List<Category> listCategories();
	List<Category> listRootCategories();

}
