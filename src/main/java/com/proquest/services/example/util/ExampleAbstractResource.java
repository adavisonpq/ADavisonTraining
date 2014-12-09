package com.proquest.services.example.util;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.restlet.representation.Representation;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.proquest.services.restlet.AbstractResource;
import com.proquest.services.restlet.RestHttpResponse;
import com.proquest.services.restlet.WadlSchema;
import com.proquest.services.utilities.CastorMarshaller;
import com.proquest.services.example.service.ExampleService;

public abstract class ExampleAbstractResource extends AbstractResource {

	private static final Log logger = LogFactory.getLog(ExampleAbstractResource.class);
	protected ExampleHttpRequest request;
	protected RestHttpResponse response;
	protected String cacheTimeout;
	protected Provider<ExampleService> exampleService;

	@Inject
	public void setExampleService(Provider<ExampleService> exampleService) {
		this.exampleService = exampleService;
	}
	
	protected void configureHandler(Object handler, Representation entity) {

		request = new ExampleHttpRequest(getRequest(), getQuery(), entity);
		response = new RestHttpResponse(getResponse(), getRequest().getClientInfo().getAcceptedMediaTypes(), new CastorMarshaller(), 
				request, WadlSchema.getInstance().getTransformer(), WadlSchema.getInstance().getAcceptedVariantsList());
						
	}

}
