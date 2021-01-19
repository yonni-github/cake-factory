package com.cakefactory;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.cakefactory.controllers.CatalogController;
import com.cakefactory.model.Cake;
import com.cakefactory.model.Catalog;

@WebMvcTest(controllers= CatalogController.class)
class CatalogControllerTest {
	
	@MockBean
	Catalog catalog;
	
	@Autowired
	MockMvc mockMvc;

	@Test
	void titleOfCakeTest() throws Exception {
		
		//- Given    ---- setup
		// have cake with title red velvet
		Cake cake = new Cake();
		cake.setTitle("Red Velvet");
		cake.setPrice(BigDecimal.valueOf(11.50));
		
		when(catalog.getAll()).thenReturn(List.of(cake));//when
		
		this.mockMvc.perform(get("/catalog"))
		.andExpect(content().string(containsString("Red Velvet")))
		.andExpect(content().string(containsString("$11.5"))); //then
		
		
		
	}

}
