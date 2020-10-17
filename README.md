# Spring Boot School Portal Rest APIS

## Purpose
Rest APIS developed in spring boot to demonstrate access to multiple database on the same application

## Setup
Create two mysql databases `mbiruri_school` and `kyeni_school`.

Configure your `database credentials` in `application.properties`

## Installation
Run the command below to install maven dependencies

 ```bash
 mvn install -DskipTests.
  ```
    
## Testing
To test, you can insert some dummy data in the tables created in the two databases, then test using the endpoints below.

```bash
http://localhost:8083/api/v1/mbiruri/students.
```
and 

 ```bash
 http://localhost:8083/api/v1/kyeni/students
  ```
