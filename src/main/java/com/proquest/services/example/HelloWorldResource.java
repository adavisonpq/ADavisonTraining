package com.proquest.services.example;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.restlet.representation.Representation;
import org.restlet.representation.Variant;
import org.restlet.resource.ResourceException;

import com.google.inject.Inject;
import com.proquest.services.example.service.ADavisonTrainingService;
import com.proquest.services.example.util.ADavisonTrainingAbstractResource;
import com.proquest.services.example.xml.HelloMessage;
import com.proquest.services.exceptions.ResourceDoesNotExistException;
import com.proquest.services.restlet.GetHandler;

public class HelloWorldResource extends ADavisonTrainingAbstractResource {

	private static final Log logger = LogFactory.getLog( HelloWorldResource.class );
		
	public HelloWorldResource() {
		super();
	}
	
	@Override
	protected GetHandler createGetHandler() {
		return new GetHandler() {

			@Override
			public Representation represent(Variant variant) throws ResourceDoesNotExistException, ResourceException {
				logger.debug("GET hello called");
				String language = request.getLanguage();
				HelloMessage hello = exampleService.get().getHelloMessage(language);
				return response.respondSuccess(hello);
			}

		};
	}

}

