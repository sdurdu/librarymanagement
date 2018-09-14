package com.sn.librarymanagement.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sn.librarymanagement.model.Book;
import com.sn.librarymanagement.model.Category;
import com.sn.librarymanagement.service.BookService;
import com.sn.librarymanagement.service.CategoryService;
import java.io.Serializable;

@Named("categoryBean")
@ViewScoped
@Component
public class CategoryBean implements Serializable {

	@Autowired
	private BookService bookService;
	@Autowired
	private CategoryService categoryService;

	private Category category;
	private Category selectedCategory;
	private List<Category> categoryList;
	private List<Category> categoryTempList;
	private List<Category> subCategory;
	private Map<Integer, List<Category>> categoryMap;
	private Category lastCategory;

	private Book book;
	private Book selectedBook;
	private List<Book> bookList;
	private List<Book> lastAddedBooks;

	@PostConstruct
	public void load() {

		category = new Category();
		categoryTempList = categoryService.listRootCategories();
		categoryList = categoryService.listCategories();

		book = new Book();
		selectedBook = new Book();
		bookList = bookService.listBooks();
		lastAddedBooks = bookService.getLatestActiveBooks(5L);

		subCategory = new ArrayList<Category>();
		subCategory.add(new Category());
		categoryMap = new HashMap<Integer, List<Category>>();
		categoryMap.put(0, categoryTempList);
		lastCategory = new Category();

	}

	// Add book
	public void addBook() {
		book.setCategory(lastCategory);
		bookService.addBook(book);
		load();
	}

	// Update book
	public void updateBook(Book book) {
		book.setCategory(lastCategory);
		bookService.updateBook(book);
		load();
	}

	// Save selected book to edit
	public void saveSelectedBook(Book book) {
		selectedBook = book;

	}

	// Soft delete of book
	public void deleteBook(Book book) {

		bookService.deleteBook(book);
		load();

	}

	// Add category into database.
	public void addCategory(Category category) {

		category.setCategory(lastCategory);
		categoryService.addCategory(category);
		load();
	}

	// Save selected category to edit
	public void saveSelectedCategory(Category category) {
		
		selectedCategory = category;
	}

	// Update category
	public void updateCategory(Category category) {
		
		category.setCategory(lastCategory);
		categoryService.updateCategory(category);
		load();
	}

	// Soft delete of category
	public void deleteCategory(Category category) {
		
		categoryService.deleteCategory(category);
		load();
	}

	// Get current subcategory list
	public List<Category> getSubList(int id) {

		return categoryMap.get(id);
	}

	// Create subcategory list based on selection
	public void handleCategoryChange(Category parent, int row) {

		lastCategory = parent;
		if (categoryMap.get(row) != null) {
			for (int i = categoryMap.size() - 1; row < i; i--) {
				categoryMap.remove(i);
				subCategory.remove(i);
			}
		}

		if (parent.getId() != 0 && parent.getId() != 1) {
			categoryTempList = new ArrayList<>();

			for (Category c : categoryList) {
				if (c.getCategory().getId() == parent.getId()) {
					categoryTempList.add(c);
				}
			}

			if (categoryTempList != null && !categoryTempList.isEmpty()) {
				subCategory.add(new Category());

				categoryMap.put(row + 1, categoryTempList);
			}

		} else {
			categoryTempList = new ArrayList<Category>();
		}
	}

	// Getters and Setters of fields.
	public BookService getBookService() {
		return bookService;
	}

	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

	public CategoryService getCategoryService() {
		return categoryService;
	}

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Category> getCategoryTempList() {
		return categoryTempList;
	}

	public void setCategoryTempList(List<Category> categoryTempList) {
		this.categoryTempList = categoryTempList;
	}

	public List<Category> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(List<Category> categoryList) {
		this.categoryList = categoryList;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Book getSelectedBook() {
		return selectedBook;
	}

	public void setSelectedBook(Book selectedBook) {
		this.selectedBook = selectedBook;
	}

	public List<Book> getBookList() {
		return bookList;
	}

	public void setBookList(List<Book> bookList) {
		this.bookList = bookList;
	}

	public Category getSelectedCategory() {
		return selectedCategory;
	}

	public void setSelectedCategory(Category selectedCategory) {
		this.selectedCategory = selectedCategory;
	}

	public List<Category> getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(List<Category> subCategory) {
		this.subCategory = subCategory;
	}

	public Map<Integer, List<Category>> getCategoryMap() {
		return categoryMap;
	}

	public void setCategoryMap(Map<Integer, List<Category>> categoryMap) {
		this.categoryMap = categoryMap;
	}

	public Category getLastCategory() {
		return lastCategory;
	}

	public void setLastCategory(Category lastCategory) {
		this.lastCategory = lastCategory;
	}

	public List<Book> getLastAddedBooks() {
		return lastAddedBooks;
	}

	public void setLastAddedBooks(List<Book> lastAddedBooks) {
		this.lastAddedBooks = lastAddedBooks;
	}

}
