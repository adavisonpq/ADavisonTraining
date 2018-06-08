package com.proquest.services.example.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.google.inject.Inject;
import com.proquest.services.example.repository.ADavisonTrainingRepository;
import com.proquest.services.example.repository.DatabaseException;
import com.proquest.services.example.util.ADavisonTrainingProperties;
import com.proquest.services.example.xml.DatabaseResultList;
import com.proquest.services.example.xml.HelloMessage;
import com.proquest.services.example.xml.HelloMessageList;
import com.proquest.services.exceptions.ResourceDoesNotExistException;
import com.proquest.services.guice.injection.binding.TimingLog;

public class ADavisonTrainingServiceImpl implements ADavisonTrainingService {

	private static final Log LOG = LogFactory.getLog(ADavisonTrainingServiceImpl.class);
	private ADavisonTrainingProperties props;
	private ADavisonTrainingRepository repository;
	
    private static final Map<String, String> hellos;
    static
    {
        hellos = new HashMap<String, String>();
        hellos.put("dutch", "Hello wereld");
        hellos.put("english", "Hello world");
        hellos.put("french", "Bonjour monde");
        hellos.put("german", "Hallo Welt");
        hellos.put("greek", "Î³ÎµÎ¹Î¬ ÏƒÎ¿Ï… ÎºÏŒÏƒÎ¼Î¿Ï‚");
        hellos.put("italian", "Ciao mondo");
        hellos.put("japanese", "ã�“ã‚“ã�«ã�¡ã�¯ä¸–ç•Œ");
        hellos.put("korean", "ì—¬ë³´ì„¸ìš” ì„¸ê³„");
        hellos.put("polish", "Witaj Å›wiecie");
        hellos.put("portuguese", "OlÃ¡ mundo");
        hellos.put("russian", "Ð—Ð´Ñ€Ð°Ð²Ñ�Ñ‚Ð²ÑƒÐ»Ñ‚Ðµ Ð¼Ð¸Ñ€");
        hellos.put("spanish", "Hola mundo");
    }	
	
    @Inject
	public ADavisonTrainingServiceImpl(ADavisonTrainingProperties props, ADavisonTrainingRepository repository) {
		super();
		this.props = props;
		this.repository = repository;
	}

	@Override
	@TimingLog("HELLO-MESSAGE")
	public HelloMessage getHelloMessage(String language) {

		HelloMessage msg = new HelloMessage();

		if (StringUtils.isEmpty(language)) {
			language = props.getDefaultLanguage();
		}
		
		LOG.debug(String.format("GET request for hello message in %s language", language));
		
		msg.setLanguage(language);

		if ( hellos.containsKey(language.toLowerCase()) ) {
			msg.setMessage(hellos.get(language.toLowerCase()));
		} else {
			msg.setMessage("I don't know the language - " + language);
		}
		
		return msg;
	}

	@Override
	@TimingLog("HELLO-MESSAGE-LIST")
	public HelloMessageList getAllHelloMessages(String languageExclusions) throws ResourceDoesNotExistException {
		HelloMessageList msg_list = new HelloMessageList();
		Set<String> exclusionSet;
		if (!StringUtils.isEmpty(languageExclusions)) {
			exclusionSet = new HashSet<>(Arrays.asList(languageExclusions.split(",")));
		} else {
			exclusionSet = new HashSet<>();
		}
		
		for (Entry<String,String> hello : hellos.entrySet()) {
			if (exclusionSet.contains(hello.getKey())) continue;
			
			HelloMessage msg = new HelloMessage();
			msg.setLanguage(hello.getKey());
			msg.setMessage(hello.getValue());
			msg_list.addHelloMessage(msg);
		}
		
		return msg_list;
	}

	@Override
	public DatabaseResultList getDatabaseResults() {
		DatabaseResultList result = new DatabaseResultList();
		
		try {
			Map<String, List<Long>> repo_results = repository.getSiteAccounts();
			
			for (Entry<String, List<Long>> repo_entry : repo_results.entrySet()) {
				for (Long site_account_number : repo_entry.getValue()) {
					result.addResults(repo_entry.getKey() + " - " + site_account_number);
				}
			}
			
		} catch (DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
}
