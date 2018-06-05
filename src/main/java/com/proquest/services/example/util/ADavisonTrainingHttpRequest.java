package com.proquest.services.example.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.restlet.Request;
import org.restlet.data.Form;
import org.restlet.representation.Representation;
import org.restlet.resource.ResourceException;

import com.proquest.services.restlet.RestHttpRequest;
import com.proquest.services.utilities.CastorMarshaller;

public class ADavisonTrainingHttpRequest extends RestHttpRequest {

	private static final Log logger = LogFactory.getLog("example.http.request");
	
	public static final String ENCODING = "utf-8";
	public static final String LANGUAGE = "lang";

	private String uri = "";
	
	public ADavisonTrainingHttpRequest(Request request, Form query, Representation entity) {
		super(request, query, entity, new CastorMarshaller());
		uri = request.getOriginalRef().getPath() + "?" + request.getOriginalRef().getQuery(); 
	}
	
	public String getUri() {
		return uri;
	}
	
	public String getLanguage() throws ResourceException {
		return getQueryParameter(LANGUAGE);
	}
		
}
