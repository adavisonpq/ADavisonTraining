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
import com.proquest.services.example.service.ADavisonTrainingService;

public abstract class ADavisonTrainingAbstractResource extends AbstractResource {

	private static final Log logger = LogFactory.getLog(ADavisonTrainingAbstractResource.class);
	protected ADavisonTrainingHttpRequest request;
	protected RestHttpResponse response;
	protected String cacheTimeout;
	protected Provider<ADavisonTrainingService> exampleService;

	@Inject
	public void setADavisonTrainingService(Provider<ADavisonTrainingService> exampleService) {
		this.exampleService = exampleService;
	}
	
	protected void configureHandler(Object handler, Representation entity) {

		request = new ADavisonTrainingHttpRequest(getRequest(), getQuery(), entity);
		response = new RestHttpResponse(getResponse(), getRequest().getClientInfo().getAcceptedMediaTypes(), new CastorMarshaller(), 
				request, WadlSchema.getInstance().getTransformer(), WadlSchema.getInstance().getAcceptedVariantsList());
						
	}

}
