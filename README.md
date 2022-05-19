### **The Assignment Technical Documentation**

This is technical documentation to understand how it works the projects.

**1. Installation**

The assignment contains two projects that are frontend and api.
Projects can be installed using Docker containers that include Redis, MySQL, Spring Boot backend and VueJS 3 frontend projects. 
To build and run containers should run the command below:

`./init.sh`

or

``docker-compose up --build -d``

**2. Endpoints**

To check api and frontend projects the links below can be used.

Frontend: http://localhost:8086

Swagger API Documentation: http://localhost:8085/api/documentation

API Base URL: http://localhost:8085/api

Also, To list all the contacts the endpoint below should be used: 

http://localhost:8085/api/contacts

**3. Testing**

Tests are written for both projects. 

Component and integrations tests were written for the frontend project. Unit and integration tests were written for the backend projects. To run frontend tests the commands below can be run:

`cd example-frontend`

After entering the frontend project,

to run integration test:

`npm run test:integration`

to run component test:

`npm run test:component`

Tests will be running on docker containers. Cypress is used on the frontend, Junit, Mockito and Rest Assured are used on the backend side.

**4. About the Project**

**Frontend:**

As the written on the technical documentation, the design should be done on the frontend project was avoided.

The search input works when any character is written but a character limit would be added for better performance. 

Integrated a feature that provides 1,5 sn delayed binding when a character is written for better performance in the search input. If a character is written then the return(enter button) action is performed, the search results are going to be shown.

**Backend:**

A caching mechanism that is used Redis is implemented for 1 hour for every request to earn better performance.

To be able to add a filter to the search endpoint Specification Argument Resolver was used. With this implementation, to add a filter to the search endpoint anyone doesn't have to write any custom implementation, class, etc.

people.csv file was converted to a SQL file to load all the data when the backend project is initiated.