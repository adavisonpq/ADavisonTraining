package com.proquest.services.example.repository;

import static org.easymock.EasyMock.anyInt;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.isA;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

import org.easymock.EasyMock;
import org.easymock.IMocksControl;
import org.junit.Test;

import com.proquest.services.guice.db.DBUtils;
import com.proquest.services.guice.injection.factories.ExtendedTimingMessageProxy;
import com.proquest.services.guice.injection.providers.ConnectionProvider;

public class ADavisonTrainingRepositoryTest {
	
	private ADavisonTrainingRepository aDavisonTrainingRepository;
	private ConnectionProvider connectionProvider;
	private ExtendedTimingMessageProxy timingMessage;
	private IMocksControl ctrl = EasyMock.createControl();
	
	private static final String SITE_NAME = "testsite";
	private static final Long ACCOUNT_ID  = 12345L;

	@Test
	public void testA() throws Exception {
		connectionProvider = ctrl.createMock(ConnectionProvider.class);
		Connection connection = ctrl.createMock(Connection.class);
		CallableStatement callableStatement = ctrl.createMock(CallableStatement.class);
		expect(connection.prepareCall(isA(String.class), anyInt(), anyInt())).andReturn(callableStatement);
		callableStatement.registerOutParameter(1, java.sql.Types.INTEGER);
		callableStatement.setString(2,  "");
		callableStatement.registerOutParameter(3, oracle.jdbc.OracleTypes.CURSOR);
		callableStatement.registerOutParameter(4, java.sql.Types.INTEGER);
		expect(callableStatement.execute()).andReturn(true);
		ResultSet resultSet = ctrl.createMock(ResultSet.class);
		expect(callableStatement.getObject(3)).andReturn(resultSet);
		expect(callableStatement.getInt(1)).andReturn(0);
		expect(resultSet.getLong(1)).andReturn(ACCOUNT_ID);
		expect(resultSet.getString(2)).andReturn(SITE_NAME);
		expect(resultSet.next()).andReturn(true);
		expect(resultSet.next()).andReturn(false);
		expect(connectionProvider.get()).andReturn(connection);
		timingMessage = ctrl.createMock(ExtendedTimingMessageProxy.class);
		timingMessage.addFieldMessage(ADavisonTrainingRepositoryImpl.TIMING_SITE_SIZE, 1);
		timingMessage.addFieldMessage(ADavisonTrainingRepositoryImpl.TIMING_ACCOUNT_ID, "");
		DBUtils.close(resultSet, callableStatement, connection);
		ctrl.replay();
		aDavisonTrainingRepository = new ADavisonTrainingRepositoryImpl(connectionProvider, timingMessage);
		Map<String, List<Long>> siteAccountMap = aDavisonTrainingRepository.getSiteAccounts();
		ctrl.verify();
		assertFalse(siteAccountMap.isEmpty());
		assertTrue(siteAccountMap.size() ==  1);
		assertTrue(siteAccountMap.get(SITE_NAME).size() == 1);
		assertEquals(ACCOUNT_ID, siteAccountMap.get(SITE_NAME).get(0));
		
		
		/*
		 * JSON Application data
		 * curl --header "Accept: application/json" 127.0.0.1/example/databaseTest
		 *
		 * Request via XML with XML/JSON results, then Request via JSON with XML/JSON results
		 * echo '<?xml version="1.0" encoding="UTF-8"?><HelloMessageRequest><Language>german</Language></HelloMessageRequest>' | curl -d @- --header "Content-type: text/xml" 127.0.0.1/example/hello
		 * echo '<?xml version="1.0" encoding="UTF-8"?><HelloMessageRequest><Language>german</Language></HelloMessageRequest>' | curl -d @- --header "Content-type: text/xml" --header "Accept: application/json" 127.0.0.1/example/hello
		 * echo '{"HelloMessageRequest":{"Language":"english"}}' | curl -d @- --header "Content-type: application/json" 127.0.0.1/example/hello
		 * echo '{"HelloMessageRequest":{"Language":"english"}}' | curl -d @- --header "Content-type: application/json" --header "Accept: application/json" 127.0.0.1/example/hello
		 * 
		 * Version 1 request (Comes back with "Message", but not "Language")
		 * $ echo '<?xml version="1.0" encoding="UTF-8"?><HelloMessageRequest><Language>german</Language></HelloMessageRequest>' | curl -d @- --header "Content-type: text/xml" --header "Accept: ADavisonTraining_v1/json" 127.0.0.1/example/hello
		 */
	}
}
