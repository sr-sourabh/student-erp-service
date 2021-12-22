# Student ERP Service

### Use cases

* Allow the employee of the admin department to login
* Ask them to register students with details such as name, email address, roll number, domain, specialization,
  photograph and others.
* Assign unique roll numbers based on patterns like (MT20xxxxx, MS20xxxxx, IMT20xxxxx).
* Keep in check the capacity of the domain.
* An employee of the admin department can view, delete and modify all students based details.

### Steps to run

1. copy resources/sql/0001.sql and paste in your mysql terminal
2. change erp.student.image.path property in application.properties to your path
3. change spring.datasource.username and spring.datasource.password in application.properties
