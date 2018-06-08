package com.proquest.services.example.repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.inject.Inject;

import org.apache.commons.lang.StringUtils;

import com.proquest.services.guice.db.DBUtils;
import com.proquest.services.guice.injection.binding.TimingLog;
import com.proquest.services.guice.injection.factories.ExtendedTimingMessageProxy;
import com.proquest.services.guice.injection.providers.ConnectionProvider;

public class ADavisonTrainingRepositoryImpl implements ADavisonTrainingRepository {
	
	private static final String QUERY_SITE_ACCOUNTS = "BEGIN :1 := CACHE_PKG.GET_ACNT_EBC_INFO(:2, :3, :4); END;";
	//private static final String QUERY_ACCOUNT_SUBSCRIPTOIN_CHANGE_QUEUE = "BEGIN :1 := MSTKMQDQ_NO_COMMIT(:2, :3, :4, :5, :6); END;";
	//private static final String QUEUE_NAME_ACCOUNT_SUBSCRIPTION = "EBC_ACNT_ID_Q";
	public static final String TIMING_MESSAGE = "MESSAGE";
	public static final String TIMING_SITE_SIZE = "NUM_SITES";
	public static final String TIMING_ACCOUNT_ID = "ACNT_ID";
    
	private final ExtendedTimingMessageProxy timingMessage;
	private ConnectionProvider connectionProvider;
    
    @Inject
    public ADavisonTrainingRepositoryImpl(ConnectionProvider connectionProvider, ExtendedTimingMessageProxy timingMessage) {
		this.connectionProvider = connectionProvider;
		this.timingMessage = timingMessage;
	}

	/* (non-Javadoc)
	 * @see com.proquest.services.accountholdings.repository.AccountHoldingsRepository#getSiteAccounts()
	 */
	@Override
	@TimingLog("SITE_ACCOUNTS")
	public Map<String, List<Long>> getSiteAccounts() throws DatabaseException {
		//final String accountIdParam = forAccountId == null ? null : String.valueOf(forAccountId);
		final Map<String, List<Long>> results = new ConcurrentHashMap<>();
		CallableStatement statement = null;
		Connection connection = null;
		ResultSet resultSet = null;
		try {
			connection = connectionProvider.get();
			statement = connection.prepareCall(QUERY_SITE_ACCOUNTS, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			statement.registerOutParameter(1, java.sql.Types.INTEGER);
			
			statement.setString(2, "");
			statement.registerOutParameter(3, oracle.jdbc.OracleTypes.CURSOR);
			statement.registerOutParameter(4, java.sql.Types.INTEGER);
			statement.execute();

			int status = statement.getInt(1);
			if (status != 0) {
				throw new SQLException("Error while fetching sites and accounts.");
			}
			resultSet = (ResultSet) statement.getObject(3);
			while(resultSet.next()) {
				long accountId = resultSet.getLong(1);
				String siteName = resultSet.getString(2);
				if(results.containsKey(siteName)) {
					List<Long> accountList = results.get(siteName);
					accountList.add(accountId);
				}
				else {
					List<Long> accounts = new ArrayList<>();
					accounts.add(accountId);
					results.put(siteName, accounts);
				}
			}
		}
		catch(Exception ex) {
			throw new DatabaseException(ex);
		}
		finally {
			timingMessage.addFieldMessage(TIMING_ACCOUNT_ID, StringUtils.EMPTY);
			timingMessage.addFieldMessage(TIMING_SITE_SIZE, results.keySet().size());
			DBUtils.close(resultSet, statement, connection);
		}
		return results;
	}

	
	
}
