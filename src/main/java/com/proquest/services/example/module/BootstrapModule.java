package com.proquest.services.example.module;

import com.google.inject.AbstractModule;
import com.proquest.services.guice.injection.binding.ServiceBootstrap;
import com.proquest.services.guice.injection.modules.CommonModule;
import com.proquest.services.guice.injection.modules.DatabaseModule;

@ServiceBootstrap
public class BootstrapModule extends AbstractModule {
	@Override
	protected void configure() {
		install(new CommonModule());
		install(new DatabaseModule());
		
		/* The modules below are not currently required by this service and should not be installed */
		//install(new QuartzModule());
	}
}
