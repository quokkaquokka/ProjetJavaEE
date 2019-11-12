# Projet JavaEE



## Authors
Camille Moutte and Théo Abdmeziem

## Link to github respository


## IDE
NetBeans 8.2

## Version 1
Name : **se.abdmezien-moutte**
To start:
- configure Java database, 2 choices
    - There is **no** database with the configuration (name :JEEPRJ, user: jee, password: jee)
        - create a database (name :JEEPRJ, user: jee, password: jee)
        - execute the script in (se.abdmezien-moutte/employees_jdbc.sql)
    - There is a database with the configuration (name :JEEPRJ, user: jee, password: jee)
- build the project
- run the project

### Environmental specification
#### Java version
java version 1.8.0
#### Server
GlassFish Server 4.1.1
#### Database
JDBC

## Version 2
Name : **se.abdmeziem-moutte.part2**
To start:
- start Wamp, or other application to manage MySql databases
    - If there is **no** database (name :JEEPRJ, user: jee, password: jee)
        - create a database (name :JEEPRJ, user: jee, password: jee)
        - execute the script in (se.abdmeziem-moutte.part2/employees_mysql.sql)
    - If there is a database with the configuration (name :JEEPRJ, user: jee, password: jee)
- build your project
- run

### Environmental specification
#### Java version
java version 1.8.0
#### Server
GlassFish Server 4.1.1
#### Database
MySql

## Version 3
Name : **se.abdmeziem-moutte.part3**
To start:
- connect to the internet to communicate with the database
- build the project
- run the project


### Environmental specification
#### Java version
java version 1.8.0
#### Server
GlassFish Server 4.1.1
#### DataBase
Algolia, a databse in NOSQL

### Technologies
**Front** : html and Jquery
**Back** : Java with RESTful Web services 

### Testing
For example to test API directly:
run the project, open your browser and copy/paste the link

**GET ALL EMPLOYEES**
http://localhost:8080/se.abdmeziem-moutte.part3/api/v1/employees/getAll

**GET EMPLOYEES**
http://localhost:8080/se.abdmeziem-moutte.part3/api/v1/employees/get/593273962

**DELETE EMPLOYEES**
http://localhost:8080/se.abdmeziem-moutte.part3/api/v1/employees/delete/b20eba7d-b995-4821-abac-ea1bbedd9e33