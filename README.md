Intro
==================

This project is made to pack columns in a box.

Following requirements must be met:

	1. Objects have the same size. 
	2. Most optimal packaging algorithm will be used.
	3. There are 2 types of boxes. The most optimal distribution will be used.
    4. Packaging must be visualized.

Deployment (Developers)
==================

If you want to run the project: 

	1. Make sure you have jre1.8 installed. 
	2. Download the latest rest client .jar file. (Location: ./rest_service/release_builds/rest_service-X.X.jar)
	3. Run the jar file:
		3.1 Open your CMD.
		3.2 execute: "java -version" without quotes. If you get java version"1.8.X", go to step 3.5 .
		3.3 This is actually optional, but otherwise you must type the absolute path when you call java, which is too much work.
		Go to This computer (rightclick in folder view on "my computer", choose properties) -> advanced system settings -> environment variables -> select PATH variables -> edit -> new -> browse -> select java folder .
		3.4 Open CMD again. (reloads path variables)
		3.5 execute following command: java -jar "PATH\TO\JAR\FILE.JAR".
	4. Open the "binPackingVisualisation" folder in your file explorer.
	5. open the .html file, the javascript will be loaded automatically.

Keep in mind, these steps are basically the complete setup for developers. If you want to deploy this in an environment, a .war file must be deployed to a web server (a.e. a Glassfish web server). Then everyone in the same network can access this service.

Extra: 

	1. Code is written as extensible as possible. New algorithms can easily be implemented.
	2. REST service allows lots of applications to interact directly with the backend (mobile application / website / desktop application / even Excel)

Flaws:

	1. Right now, we only allow 2 boxes passed through parameters.

Bugs: 

	1. Copying a Box containing items, copies the items in random order. which results in floating objects, though the calculations are right
