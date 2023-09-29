                                                                                                                Raghu Medarametla
                                                                                                                A20386265
ReadMe File:                       

Database: 
1. Download and Install MySQL workbench 8.0 CE. 
2. Open “SQL-Query.sql” file and execute all queries, which creates tables, Views, Triggers and Stored Procedures.

Backend:
1.	Install Java JDK, Install visual studio code IDE, or Spring suite tool. Import the folder/project “pharmacy” in IDE.
2.	In the project folder path
src/main/resources a file named: application.properties
check for below properties and change the username and password according to your SQL credentials.
spring.datasource.url = jdbc:mysql://localhost:3306/pharmacy.
spring.datasource.username = root
spring.datasource.password = {{ your password }}
3.	Run the code in visual studio code: check terminal button: Run without debugging. If it is a spring suite tool run as a spring boot application.
4.	Start the server which creates a local tomcat server for port: 8083.

Frontend:
1.	Install Node.js 
2.	Run the npm install commands to setup the angular framework paths.
3.	Run the command “npm install” to download any dependencies.
4.	Use the visual studio code to import the project.
5.	Import the folder/ project “pharmacy-management” in IDE.
6.	 Run the “ng serve” command to start the frontend server in cmd (command prompt) in the project path. 
7.	The server will start with the url “http://localhost:4200”. Hit the url in browser to access the web application. 

Procedure to Access the Application:
1.	When you access the web application, one first page you can see the options login as employee, login as customer, new employee, new customer.
2.	If you are a new user either employee or customer, then a form will be displayed, and the new employee/customer can fill the details and login their username and password.
3.	Click on login as employee and use your credentials so that we can get other options such as add medicine, get medicines, create prescription, create prescribed drugs, create order, ordered drugs, getexpiringMedicines etc.
4.	Click on login as customer and like the employee use your credentials to login into the system. We will be able to see all the orders, ordered drugs, bills for the respective customer.

