Svcs-Example
============

Example service to provide a "stub" of code for starting new services based on the 
enterprise service architecture.

Notes:

	Includes use of the Svcs-Utility project as a base
	Includes a sample REST resource serviced by the restlet base architecture
	
	Uses Google Guice for dependency injection of service object, properties, etc.
	
To Use:

	1) Clone project into your own new project
	
	2) Edit wadl and schema to describe what the service is to provide (and how)
	
	3) Run Castor to produce the xml wrapper classes 
	
		3a) right-click the build.xml file and run as Ant build...
		3b) select castor-project-local target
		3c) after successful completion of the castor build, refresh the eclipse project
		
	4) Add/Modify the resource classes that will provide the services you described in your wadl
	
		Note: in the wadl it has the class names of the resources that will be invoked when each 
		of the described URL targets is received.
		
	5) Add/Modify the service implementation class to process and respond to the requests outlined
		in #4 above. Add/Modify utility classes as necessary to support the implementation of the
		actual work being performed by the service.
		
	6) The ...HttpRequest class provides getters for all the parameters (both template and query 
		parameters) passed to the service with the request.
		


 
	 
