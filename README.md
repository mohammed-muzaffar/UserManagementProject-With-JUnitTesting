<h1>UserManagementProject With JUnit Testing</h1>

<h3>Spring Boot Restful Application</h3>
<p>User management application have various functionality for user. This application have functionality such as user registration, updating user details, find a user by user ID, finding all users and deleting the user using user ID.</p>

<h3>Application have used several spring boot modules</h3>
<h4>Code Structure of the Project</h4>
<p>1. There is no specific layout or code structure for Spring Boot Projects. However, there are some best practices followed by developers that will help us too. I was divided project into layers like service layer, entity layer, repository layer, controller layer etc. You can also divide the project into modules. </p>
<p>2.<b>Controller Layer:</b> This layer have different endpoints to deals with different requests from users such as POST, GET, PATCH, DELETE, PUT.</p>
<p>3. <b>Entity Layer:</b> DTO stands for Data Transfer Object, these are the objects that move from one layer to another layer. DTO can be also used to hide the implementation detail of database layer objects</p>
<p>4. <b>Repository Layer:</b>The repository includes, annotation that is required to perform actions on the object. We can use crud repository or JPA repository to perform any operations like add, delete, save, find etc.</p>
<p>5. <b>Service Layer:</b> The service layer consists of a collection of Java classes that implement business logic (data retrieval, updates, deletions, and so on) through one or more high-level methods. In other words, the service layer controls the workflow.</p>
<p>6. <b>Exception:</b>This Layer is used for handling the exceptions, that occurs in the application. It might be custom and predefined.</p>

<h3>Following Spring Boot Modules Used in Project</h3>

<h3>Unit Testing</h3>
<p>The main objective of unit testing is to isolate written code to test and determine if it works as intended.</p>
<p>In this project, testing has been done on two layers. Controller and service layer</p>


<h3>Exception Handling</h3>
<p>In this layer, I have written Global Exception and Custom Exception</p>
<p><b>1.EmailAlreadyExistsException:</b>This class is used to make the Exception message for delivery the Customize Exception</p>
<p><b>2.ErrorDetails:</b> ErrorDetails is used for displaying custom Exception details. In this project, I have shown four parameter info such as timestamp, message, path, and errorcode.</p>
<p><b>3.GlobalExceptionHandling:</b> This particular class will handle all exceptions at global level.</p>
<p><b>4.UserNotFoundException:</b>This class is for particular Exception user not found exception.</p>

<h3>Validation</h3>
<p>Hibernate validator, which is prefer implementation of java bean validation API</p>
<p><b>Steps for validation</b></p>
<p>1. Add validation Dependency</p>
<p>2. Add Validation Annotations to UserDto class</p>
<p>3. Enable validation using @valid annotation on create and update RestAPI.</p>
<P>4. Customise validation error response can be created using ResponseEntityExceptionHandler class, which have method called handleMethodArgumentNotValid, used for validation exception.</P>

<h3>Actuator</h3>
<p>Spring Boot Actuator module provides production ready features such as monitoring, metrics and health checks.</p>
<p>Actuator which I have used in this project.</p>
<p>/info, /health, /beans, /conditions, /mappings, /configprops, /matrics, /env, /threaddump and /loggers.</p>


<h3>Swagger</h3>
<p>Springdoc-openapi java library helps to automate the generation of API documentation.</p>
<P>Springdoc-openapi library provides integration between spring-boot and swagger-ui.</P>