package com.proquest.services.example.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.google.inject.Inject;
import com.proquest.services.Defect;
import com.proquest.services.utilities.ServiceUtils;

public class ExampleProperties {

	private static Properties properties;
	
	private static final String DEFAULT_LANGUAGE = "default.language";

	public String getDefaultLanguage() {
		return getStringProperty(DEFAULT_LANGUAGE,null);
	}
	
	@Inject
	private ExampleProperties() throws IOException {
	}

	private static Properties getInstance() {
		try {
			properties = getExampleProperties();
		} catch (IOException e) {
			throw new Defect(e);
		}
		return properties;
	}

	public static synchronized Properties getExampleProperties() throws IOException {
		FileInputStream fis = null;
		if (properties == null) {
			properties = new Properties();
			try {
				fis = new FileInputStream(ServiceUtils.getConfigDir() + "example.properties");
				properties.load(fis);
			} finally {
				if (fis != null) {
					fis.close();
				}
			}
		}
		return properties;
	}

	public static int getIntegerProperty(String propertyName, String defaultValue) {
		int propertyValueReturn = 0;
		String propertyValueString = getInstance().getProperty(propertyName, defaultValue);
		try {
			propertyValueReturn = Integer.parseInt(propertyValueString);
		} catch (NumberFormatException nfe) {
			// Silently discard.
		}
		return propertyValueReturn;
	}

	public static boolean getBooleanProperty(String propertyName, String defaultValue) {
		boolean propertyValueReturn = false;
		String propertyValueString = getInstance().getProperty(propertyName, defaultValue);
		try {
			propertyValueReturn = Boolean.parseBoolean(propertyValueString);
		} catch (NumberFormatException nfe) {
			// Silently discard.
		}
		return propertyValueReturn;
	}

	public static String getStringProperty(String propertyName, String defaultValue) {
		return getInstance().getProperty(propertyName,defaultValue);
	}
}
