package com.proquest.services.example;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.restlet.representation.Representation;
import org.restlet.representation.Variant;
import org.restlet.resource.ResourceException;

import com.proquest.services.example.util.ADavisonTrainingAbstractResource;
import com.proquest.services.example.xml.DatabaseResultList;
import com.proquest.services.example.xml.HelloMessageList;
import com.proquest.services.exceptions.ResourceDoesNotExistException;
import com.proquest.services.restlet.GetHandler;

public class DatabaseTestResource extends ADavisonTrainingAbstractResource{

	private static final Log logger = LogFactory.getLog( HelloWorldResource.class );
		
	public DatabaseTestResource() {
		super();
	}
	
	@Override
	protected GetHandler createGetHandler() {
		return new GetHandler() {

			@Override
			public Representation represent(Variant variant) throws ResourceDoesNotExistException, ResourceException {
				logger.debug("GET database test called");
				DatabaseResultList result = exampleService.get().getDatabaseResults();
				return response.respondSuccess(result);
			}

		};
	}

}
