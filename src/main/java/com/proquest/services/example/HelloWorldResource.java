package com.proquest.services.example;

import java.io.StringWriter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.ValidationException;
import org.restlet.representation.Representation;
import org.restlet.representation.Variant;
import org.restlet.resource.ResourceException;

import com.proquest.services.example.util.ADavisonTrainingAbstractResource;
import com.proquest.services.example.xml.HelloMessage;
import com.proquest.services.example.xml.HelloMessageRequest;
import com.proquest.services.exceptions.DtoValidationException;
import com.proquest.services.exceptions.ResourceAlreadyExistsException;
import com.proquest.services.exceptions.ResourceDoesNotExistException;
import com.proquest.services.restlet.GetHandler;
import com.proquest.services.restlet.PostHandler;

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
	
	@Override
	protected PostHandler createPostHandler() {
		return new PostHandler() {

			@Override
			public void acceptRepresentation(Representation entity) throws ResourceException, ResourceDoesNotExistException, ResourceAlreadyExistsException, DtoValidationException {
				logger.debug("POST hello called");
				HelloMessageRequest messageRequest = request.getHelloMessageRequest();
				String language = messageRequest.getLanguage();
				HelloMessage hello = exampleService.get().getHelloMessage(language);
		        StringWriter out = new StringWriter();
		       
		        try {
					hello.marshal(out);
				} catch (MarshalException | ValidationException e) {
					e.printStackTrace();
				}
		        System.out.println(out.toString());

		        response.respondSuccess(hello);
			}

		};
	}

}

