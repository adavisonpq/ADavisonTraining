package com.proquest.services.example;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.restlet.representation.Representation;
import org.restlet.representation.Variant;
import org.restlet.resource.ResourceException;

import com.google.inject.Inject;
import com.proquest.services.example.service.ExampleService;
import com.proquest.services.example.util.ExampleAbstractResource;
import com.proquest.services.example.xml.HelloMessage;
import com.proquest.services.exceptions.ResourceDoesNotExistException;
import com.proquest.services.restlet.GetHandler;

public class HelloWorldResource extends ExampleAbstractResource {

	private static final Log logger = LogFactory.getLog( HelloWorldResource.class );
		
	public HelloWorldResource() {
		super();
	}
	
	@Inject
	public HelloWorldResource(ExampleService exampleService) {
		super(exampleService);
	}

	@Override
	protected GetHandler createGetHandler() {
		return new GetHandler() {

			@Override
			public Representation represent(Variant variant) throws ResourceDoesNotExistException, ResourceException {
				logger.debug("GET hello called");
				String language = request.getLanguage();
				HelloMessage hello = exampleService.getHelloMessage(language);
				return response.respondSuccess(hello);
			}

		};
	}

}

