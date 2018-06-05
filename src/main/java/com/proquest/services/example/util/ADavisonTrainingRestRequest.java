package com.proquest.services.example.util;

import org.restlet.Request;
import org.restlet.data.Form;
import org.restlet.representation.Representation;

import com.proquest.services.restlet.RestHttpRequest;
import com.proquest.services.utilities.CastorMarshaller;
import com.proquest.services.utilities.xml.Marshaller;

public class ADavisonTrainingRestRequest extends RestHttpRequest {

	public ADavisonTrainingRestRequest(Request request, Form query, Representation entity, Marshaller marshaller) {
		super(request, query, entity, marshaller);
	}

	public ADavisonTrainingRestRequest(Request request, Form query, Representation entity) {
		this(request, query, entity, new CastorMarshaller());
	}

}
