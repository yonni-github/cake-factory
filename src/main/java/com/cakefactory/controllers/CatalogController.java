package com.cakefactory.controllers;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cakefactory.model.Catalog;

@Controller
@RequestMapping("/catalog")
public class CatalogController {

	
	private Catalog catalog;
	
	public CatalogController(Catalog catalog) {
		this.catalog = catalog;
	}
	
	
	
	@GetMapping("")
	public ModelAndView getIndex() {
		
		return new ModelAndView("home", Map.of("items", catalog.getAll()));
		
	}
}
