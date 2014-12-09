package com.proquest.services.example.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.google.inject.Inject;
import com.proquest.services.example.util.ExampleProperties;
import com.proquest.services.example.xml.HelloMessage;
import com.proquest.services.guice.injection.binding.TimingLog;
import com.proquest.services.guice.injection.main.Bootstrap;

public class ExampleServiceImpl implements ExampleService {

	private static final Log LOG = LogFactory.getLog(ExampleServiceImpl.class);
	private ExampleProperties props;
	
    private static final Map<String, String> hellos;
    static
    {
        hellos = new HashMap<String, String>();
        hellos.put("dutch", "Hello wereld");
        hellos.put("english", "Hello world");
        hellos.put("french", "Bonjour monde");
        hellos.put("german", "Hallo Welt");
        hellos.put("greek", "γειά σου κόσμος");
        hellos.put("italian", "Ciao mondo");
        hellos.put("japanese", "こんにちは世界");
        hellos.put("korean", "여보세요 세계");
        hellos.put("polish", "Witaj świecie");
        hellos.put("portuguese", "Olá mundo");
        hellos.put("russian", "Здравствулте мир");
        hellos.put("spanish", "Hola mundo");
    }	
	
    @Inject
	public ExampleServiceImpl(ExampleProperties props) {
		super();
		this.props = props;
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
	
}
