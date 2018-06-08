package com.proquest.services.example.module;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Scopes;
import com.google.inject.Singleton;
import com.proquest.services.example.ADavisonTrainingStatusReporter;
import com.proquest.services.example.repository.ADavisonTrainingRepository;
import com.proquest.services.example.repository.ADavisonTrainingRepositoryImpl;
import com.proquest.services.example.service.ADavisonTrainingService;
import com.proquest.services.example.service.ADavisonTrainingServiceImpl;
import com.proquest.services.example.util.ADavisonTrainingProperties;
import com.proquest.services.guice.injection.binding.Service;
import com.proquest.services.guice.injection.binding.TimingLogScope;
import com.proquest.services.log.ExtendedTimingMessage;
import com.proquest.services.log.ITimingMessage;
import com.proquest.services.log.TimingLogConstants;
import com.proquest.services.statuspage.reporter.StatusReporter;

@Service
public class ServiceModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(ADavisonTrainingProperties.class).in(Scopes.SINGLETON);
		bind(StatusReporter.class).to(ADavisonTrainingStatusReporter.class);
		bind(ADavisonTrainingService.class).to(ADavisonTrainingServiceImpl.class);
		bind(ITimingMessage.class).to(ExtendedTimingMessage.class).in(TimingLogScope.class);
		bind(ADavisonTrainingRepository.class).to(ADavisonTrainingRepositoryImpl.class);
	}

	@Provides
	@Singleton
	public Log getTimingLog() {
		return LogFactory.getLog(TimingLogConstants.TIMING_LOG);
	}

}
