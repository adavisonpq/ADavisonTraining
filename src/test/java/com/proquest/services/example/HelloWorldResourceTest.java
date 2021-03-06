package com.proquest.services.example;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.restlet.Request;
import org.restlet.Response;
import org.restlet.data.Method;
import org.restlet.data.Status;
import org.restlet.ext.wadl.WadlComponent;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import com.google.inject.Stage;
import com.proquest.services.example.HelloWorldResourceTest.HelloWorldResourceTestModule;
import com.proquest.services.example.util.ADavisonTrainingProperties;
import com.proquest.services.example.util.MockADavisonTrainingProperties;
import com.proquest.services.example.xml.HelloMessage;
import com.proquest.services.example.xml.HelloMessageList;
import com.proquest.services.testutility.injection.runner.GuiceRunner;
import com.proquest.services.testutility.injection.runner.GuiceRunner.GuiceModules;
import com.proquest.services.testutility.injection.runner.GuiceRunner.GuiceStage;
import com.proquest.services.testutility.restlet.TestGuiceInitializer;
import com.proquest.services.utilities.CastorMarshaller;

@RunWith(GuiceRunner.class)
@GuiceStage(Stage.DEVELOPMENT)
@GuiceModules({HelloWorldResourceTestModule.class})
public class HelloWorldResourceTest {
	@Inject CastorMarshaller marshaller;
	
	@Test
	public void exampleHelloEnglish() throws Exception {
		WadlComponent component=TestGuiceInitializer.getTestInstance().createInternalComponent("ADavisonTraining.wadl.xml");	
		String uri = "riap://component/example/hello?lang=english";
		Request request = new Request(Method.GET, uri);		
		Response response = component.getContext().getClientDispatcher().handle(request);
		Status status=response.getStatus();
		Assert.assertNotNull(status);
		Assert.assertEquals(200, status.getCode());
		
		String xml=response.getEntityAsText();
		Assert.assertNotNull(xml);
		
		HelloMessage message = marshaller.unmarshall(xml, HelloMessage.class);
		Assert.assertNotNull(message);
		Assert.assertEquals("Hello world", message.getMessage());
	}
	
	@Test
	public void exampleHelloAll() throws Exception {
		WadlComponent component=TestGuiceInitializer.getTestInstance().createInternalComponent("ADavisonTraining.wadl.xml");	
		String uri = "riap://component/example/hellos?languageExclusions=english,german";
		Request request = new Request(Method.GET, uri);		
		Response response = component.getContext().getClientDispatcher().handle(request);
		Status status=response.getStatus();
		Assert.assertNotNull(status);
		Assert.assertEquals(200, status.getCode());
		
		String xml=response.getEntityAsText();
		Assert.assertNotNull(xml);
		
		HelloMessageList messages = marshaller.unmarshall(xml, HelloMessageList.class);
		Assert.assertNotNull(messages);
		Assert.assertEquals(messages.getHelloMessage().length, 10); //12 - 2
	}
	
	public static class HelloWorldResourceTestModule extends AbstractModule {
		@Override
		protected void configure() {
			bind(ADavisonTrainingProperties.class).to(MockADavisonTrainingProperties.class).in(Scopes.SINGLETON);
		}	
	}
}
