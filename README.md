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

<h4>Unit Testing</h4>
<p>The main objective of unit testing is to isolate written code to test and determine if it works as intended.</p>
<p>In this project, testing has been done on two layers. Controller and service layer</p>
