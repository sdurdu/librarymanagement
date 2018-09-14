package com.sn.librarymanagement.service;

import java.util.List;

import com.sn.librarymanagement.model.Category;

public interface CategoryService {
		
	Category getCategory(long categoryId);
	void addCategory(Category category);
	void updateCategory(Category category);
	void deleteCategory(Category category);
	List<Category> listCategories();
	List<Category> listRootCategories();		
}
