package com.proquest.services.example.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.proquest.services.Defect;
import com.proquest.services.utilities.ServiceUtils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ADavisonTrainingProperties {

	private Properties properties;
	protected static String fileName = "example.properties";

	private static final String DEFAULT_LANGUAGE = "default.language";

	protected static Log log = LogFactory.getLog(ADavisonTrainingProperties.class);

	public ADavisonTrainingProperties() {
		try {
			loadProperties(fileName);
		} catch (IOException e) {
			throw new Defect(e);
		}
	}

	protected void loadProperties(String filename) throws IOException {
		log.info("Load ADavisonTraining properties ..");
		properties = new Properties();
		InputStream inputStream = null;

		try {
			inputStream = new FileInputStream(ServiceUtils.getConfigDir() + filename);
			properties.load(inputStream);
			log.info("ADavisonTrainingProperties#loadProperties  example.properties is loaded..");
		} finally {
			if (inputStream != null)
				inputStream.close();
		}
	}

	protected void setProperties(Properties properties) {
		this.properties = properties;
	}

	protected String getProperty(final String propertyName) {
		final String propertyValue = properties.getProperty(propertyName);
		if (propertyValue == null)
			log.error("Property " + propertyName + " is not defined in configuration file");
		if (log.isDebugEnabled())
			log.debug(propertyName + " = " + propertyValue);
		return propertyValue;
	}

	public String getDefaultLanguage() {
		return getProperty(DEFAULT_LANGUAGE);
	}
}
