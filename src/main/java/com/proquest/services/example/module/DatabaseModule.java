package com.proquest.services.example.module;

import java.sql.Connection;

import javax.persistence.EntityManager;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.throwingproviders.CheckedProvides;
import com.google.inject.throwingproviders.ThrowingProviderBinder;
import com.proquest.services.guice.injection.binding.EMTransactionScope;
import com.proquest.services.guice.injection.binding.Service;
import com.proquest.services.guice.injection.binding.TransactionScope;
import com.proquest.services.guice.injection.factories.ConnectionFactory;
import com.proquest.services.guice.injection.factories.EMFactory;
import com.proquest.services.guice.injection.providers.ConnectionProvider;

/**
 * @author Murali Jampani
 *
 */
@Service
public class DatabaseModule extends AbstractModule {
	
	private static final String	MSTAR_JNDI_NAME	= "java:comp/env/jdbc/MorningStarUCP";
	private static final String PROPERTY_SQL_TYPE_COMPATIBILITY = "oracle.jdbc.J2EE13Compliant";
	private static final String PERSISTENCE_UNIT = "Svcs-ADavisonTraining";

	/* (non-Javadoc)
	 * @see com.google.inject.AbstractModule#configure()
	 */
	@Override
	protected void configure() {
		System.setProperty(PROPERTY_SQL_TYPE_COMPATIBILITY, "true");
		install(ThrowingProviderBinder.forModule(this));
	}
	
	@EMTransactionScope
	@Provides
	public EntityManager getEntityManager(EMFactory f) {
		return f.get(PERSISTENCE_UNIT, MSTAR_JNDI_NAME);
	}
	
	@TransactionScope
	@CheckedProvides(ConnectionProvider.class)
	public Connection getConnection(ConnectionFactory f) throws Exception   {
		return f.getConnection(MSTAR_JNDI_NAME);
	}
}
