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
import com.proquest.services.example.util.ExampleProperties;
import com.proquest.services.example.util.MockExampleProperties;
import com.proquest.services.example.xml.HelloMessage;
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
		WadlComponent component=TestGuiceInitializer.getTestInstance().createInternalComponent("Example.wadl.xml");	
		String uri = "riap://component/example/hello?lang=english";
		Request request = new Request(Method.GET, uri);		
		Response response = component.getContext().getClientDispatcher().handle(request);
		Status status=response.getStatus();
		Assert.assertNotNull(status);
		Assert.assertEquals(200, status.getCode());
		
		String xml=response.getEntityAsText();
		Assert.assertNotNull(xml);
		
		HelloMessage message=marshaller.unmarshall(xml, HelloMessage.class);
		Assert.assertNotNull(message);
		Assert.assertEquals("Hello world", message.getMessage());
	}
	
	public static class HelloWorldResourceTestModule extends AbstractModule {
		@Override
		protected void configure() {
			bind(ExampleProperties.class).to(MockExampleProperties.class).in(Scopes.SINGLETON);
		}	
	}
}
