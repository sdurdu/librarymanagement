package com.sn.librarymanagement.dao;

import java.util.List;

import com.sn.librarymanagement.model.Category;

public interface CategoryDAO {
	
	Category getCategory(long categoryId);
	List<Category> listCategories();
	List<Category> listRootCategories();
	void addCategory(Category category);
	void updateCategory(Category category);
	void deleteCategory(Category category);

}
