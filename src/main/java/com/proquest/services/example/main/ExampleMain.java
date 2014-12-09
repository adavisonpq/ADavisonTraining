package com.proquest.services.example.main;

import com.proquest.services.ServiceMain;
import com.proquest.services.guice.injection.main.GuiceInitializer;

public class ExampleMain extends ServiceMain {

	public static void main(String[] args) {
		instantiate(args, GuiceInitializer.getInstance());
	}

}
