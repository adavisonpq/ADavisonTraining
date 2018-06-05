package com.proquest.services.example.service;

import com.proquest.services.example.xml.HelloMessage;
import com.proquest.services.exceptions.ResourceDoesNotExistException;

public interface ADavisonTrainingService {

	HelloMessage getHelloMessage(String language) throws ResourceDoesNotExistException;

}
