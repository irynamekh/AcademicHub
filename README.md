# AcademicHub
___

This is a simple Spring Boot java project with the console interface for university, which consists of departments and lectors.
The lectors work in more than one department. A lector have one degree (assistant, associate professor, professor).
The university has four departments: `Gryffindor, Slytherin, Hufflepuff, Ravenclaw`, each department has a head.
All data is stored in the relational database (MySql) which is created using Liquibase.

>The app implement such commands:

1. User Input: `Who is head of department {department_name}`

   Answer: `Head of {department_name} department is {head_of_department_name}`


2. User Input: `Show {department_name} statistics`

   Answer: `assistants - {assistants_count}, associate professors - {associate_professors_count}, professors - {professors_count}`


3. User Input: `Show the average salary for the department {department_name}`

   Answer: `The average salary of {department_name} is {average_salary}`


4. User Input: `Show count of employee for {department_name}`

   Answer: `{employee_count}`


5. User Input: `Global search by {template}`  
   Example: `Global search by Sl`

   Answer: `[Salazar Slytherin, Horace Slughorn]`
