package com.proquest.services.example.util;

import java.io.IOException;

public class MockADavisonTrainingProperties extends ADavisonTrainingProperties {

	@Override
	protected void loadProperties(String filename) throws IOException {
		// Dont load anything
	}

	@Override
	public String getDefaultLanguage() {
		return "english";
	}
}
