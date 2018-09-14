package com.sn.librarymanagement.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sn.librarymanagement.model.Category;
import com.sn.librarymanagement.service.CategoryService;

@Service
@FacesConverter(value = "categoryConverter")

public class CategoryConverter implements Converter {

	@Autowired
	private CategoryService categoryService;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Category c = categoryService.getCategory(Long.valueOf(value));
		return c;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {

		Category c = (Category) value;
		return new Long(c.getId()).toString();
	}
}
