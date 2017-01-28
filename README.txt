
Requirements: Java 1.8, Maven, Postgre

1.Create empty database with name zipcode in PosgreSql. 
  In application.properties: 
  username=postgres 
  password=root 

2.mvn clean install 
  java -jar target\zip-code-rest-1.0.jar

3.Open http://localhost:8080 in browser