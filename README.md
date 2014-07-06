SpringDemo
==========

A Car sales web app that would demonstate Spring MVC, Spring Security, Spring DAO (JDBC), Spring form validation etc. 

 
Authors
-------
* "Joseph Rajeev Motha" <joerajeev@gmail.com>

 Setup
 ------
The sql required to create the DB is in resources/create_db.sql. It was created with MySQL workbench and may need tweaking to work with other DB's. 
Also the datasource info will need to be created in your appication server with the name 'jdbc/carsalesdb'. 
For example: 
```
       <Resource name="jdbc/carsalesdb" auth="Container" type="javax.sql.DataSource"
               maxActive="100" maxIdle="30" maxWait="10000"
               username="javauser" password="javadude" driverClassName="com.mysql.jdbc.Driver"
               url="jdbc:mysql://localhost:3306/carsales"/>
```
