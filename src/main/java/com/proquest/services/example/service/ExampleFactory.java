package com.proquest.services.example.service;

import com.proquest.services.example.service.ExampleService;
import com.proquest.services.example.service.ExampleServiceImpl;

public class ExampleFactory {

	private final ExampleService service;

	public ExampleFactory() {
		super();		
		service = makeService();
	}

	private ExampleService makeService() {
		final ExampleServiceImpl exampleServiceImpl = new ExampleServiceImpl();
		return exampleServiceImpl;
	}

	public ExampleService getService() {
		return this.service;
	}
	
}
