package com.sn.librarymanagement.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sn.librarymanagement.model.Book;
import com.sn.librarymanagement.service.BookService;

@Service
@FacesConverter(value = "bookConverter")
public class BookConverter implements Converter {

	@Autowired
	private BookService bookService;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {

		Book b = bookService.getBook(Long.valueOf(value));
		return b;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {

		Book b = (Book) value;
		return new Long(b.getId()).toString();
	}
}
