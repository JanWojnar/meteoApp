meteoApp for recruitment in Lingventa :)

I have used Java 11.

1. Start MeteoappApplication
2. Example success call:
http://localhost:8080/meteoapp/rest/52.23/21.01

Due to regexp params:

First param: <-180.00,180.00> longitude

Second param: <-90.00,90.00> latitude

For bad inputs proper warning will be prompted in logs and Respone.BadRequest returned.

H2 Database available at:
http://localhost:8080/meteoapp/h2-console/

Driver Class: org.h2.Driver
JDBC URL: jdbc:h2:mem:mydb
User Name: sa
Password: password