package com.proquest.services.example.repository;

import java.util.List;
import java.util.Map;


/**
 * Interface for the calls to online database.
 * 
 * @author Murali Jampani
 *
 */
public interface ADavisonTrainingRepository {
	
	Map<String, List<Long>> getSiteAccounts() throws DatabaseException;
	
	//String getAccountSubscriptionChangeMessage() throws DatabaseException;
}
