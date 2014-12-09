package com.proquest.services.example.util;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.restlet.representation.Representation;

import com.proquest.services.restlet.AbstractResource;
import com.proquest.services.restlet.RestHttpResponse;
import com.proquest.services.restlet.WadlSchema;
import com.proquest.services.utilities.CastorMarshaller;
import com.proquest.services.example.service.ExampleService;
import com.proquest.services.guice.injection.main.Bootstrap;

public abstract class ExampleAbstractResource extends AbstractResource {

	private static final Log logger = LogFactory.getLog(ExampleAbstractResource.class);
	public final ExampleService exampleService;
	protected ExampleHttpRequest request;
	protected RestHttpResponse response;
	protected String cacheTimeout;
   
	public ExampleAbstractResource() {
		this(Bootstrap.getInstance(ExampleService.class));
	}

	public ExampleAbstractResource(ExampleService exampleService) {
		super();
		this.exampleService = exampleService;
	}

	protected void configureHandler(Object handler, Representation entity) {
		try {
			cacheTimeout = ExampleProperties.getExampleProperties().getProperty(ExampleConstants.HTTP_CACHE_MAX_AGE);
		} catch (IOException e) {
			cacheTimeout = "120";
			logger.warn("We are using 'max-age=120', 'max-age' property needs to be added to the example.properties file", e);
		}

		request = new ExampleHttpRequest(getRequest(), getQuery(), entity);
		response = new RestHttpResponse(getResponse(), getRequest().getClientInfo().getAcceptedMediaTypes(), new CastorMarshaller(), 
				request, WadlSchema.getInstance().getTransformer(), WadlSchema.getInstance().getAcceptedVariantsList());
						
	}

}
