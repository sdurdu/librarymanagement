package com.sn.librarymanagement.service;

import java.util.List;

import com.sn.librarymanagement.model.Category;

public interface CategoryService {
	
	List<Category> listCategories();
	List<Category> listRootCategories();
	void addCategory(Category category);
	void updateCategory(Category category);
	void deleteCategory(Category category);
	Category getCategory(long categoryId);
	
}
