
A Car sales web app that would demonstate Spring MVC, Spring Security, Spring DAO (JDBC), Spring form validation etc. 

 Examples of alternate (older) configuration methods are available in branches
 - pre-servlet-3.x : Initializing the web application with a web.xml
 - pre-annotation-config : Spring configurations though xml.
 - 
Authors
-------
* "Joseph Rajeev Motha" <joerajeev@gmail.com>

 Setup
 ------
* Build the project with mvn clean install
* The application expects a datasource named "jdbc/carsalesdb". Configure this in your application/web server.
For example: 
```
       <Resource name="jdbc/carsalesdb" auth="Container" type="javax.sql.DataSource"
               maxActive="100" maxIdle="30" maxWait="10000"
               username="javauser" password="javadude" driverClassName="com.mysql.jdbc.Driver"
               url="jdbc:mysql://localhost:3306/carsales"/>
```
* Create the database using the scripts provided in resources/create_db.sql. It was created with MySQL workbench and may need tweaking to work with other DB's. 
* Deploy the application to the application/web server.
