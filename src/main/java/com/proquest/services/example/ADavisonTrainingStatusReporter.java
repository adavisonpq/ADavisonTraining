package com.proquest.services.example;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import com.proquest.services.statuspage.reporter.StatusReporter;

public class ADavisonTrainingStatusReporter implements StatusReporter {
	
	@Inject
	public ADavisonTrainingStatusReporter() { }
	
	@Override
	public List<String> getFailureMessages() {
		List<String> result = new ArrayList<String>();
		//exampleDatabaseConnectivityCheck(result);
		return result;
	}
			
}

