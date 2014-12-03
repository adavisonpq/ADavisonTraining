package com.proquest.services.example.main;

import com.proquest.services.ServiceMain;
import com.proquest.services.guice.injection.main.Bootstrap;
import com.proquest.services.guice.injection.main.GuiceInitializer;
import com.proquest.services.statuspage.reporter.StatusReporter;

public class ExampleMain extends ServiceMain {

	public static void main(String[] args) {
		instantiate(args, GuiceInitializer.getInstance());
		ServiceMain.setStatusReporter(Bootstrap.getInstance(StatusReporter.class));
	}

}
