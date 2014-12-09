package com.proquest.services.example.module;

import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.inject.name.Names;
import com.proquest.services.example.ExampleStatusReporter;
import com.proquest.services.example.service.ExampleService;
import com.proquest.services.example.service.ExampleServiceImpl;
import com.proquest.services.example.util.ExampleConstants;
import com.proquest.services.guice.injection.binding.Service;
import com.proquest.services.guice.injection.binding.TimingLogScope;
import com.proquest.services.log.ExtendedTimingMessage;
import com.proquest.services.log.ITimingMessage;
import com.proquest.services.log.TimingLogConstants;
import com.proquest.services.statuspage.reporter.StatusReporter;
import com.proquest.services.utilities.ServiceUtils;

@Service
public class ServiceModule extends AbstractModule {

	@Override
	protected void configure() {
		Names.bindProperties(binder(), getContentProperties());
		bind(StatusReporter.class).to(ExampleStatusReporter.class);
		bind(ExampleService.class).to(ExampleServiceImpl.class);
		bind(ITimingMessage.class).to(ExtendedTimingMessage.class).in(TimingLogScope.class);
	}

	@Provides
	@Singleton
	public Properties getContentProperties() {
		return ServiceUtils.loadProperties(null, ExampleConstants.FILE_EXAMPLE_PROPERTIES);
	}
	
	@Provides
	@Singleton
	public Log getTimingLog() {
		return LogFactory.getLog(TimingLogConstants.TIMING_LOG);
	}

}
