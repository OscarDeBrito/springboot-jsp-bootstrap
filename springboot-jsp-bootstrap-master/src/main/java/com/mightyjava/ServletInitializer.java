package com.mightyjava;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(@org.jetbrains.annotations.NotNull SpringApplicationBuilder application) {
		return application.sources(Application.class);
	}

}
