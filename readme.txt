A School maintenance application (Designed for MC2 STEM HIGH SCHOOL)

If you are looking for Spring Web MVC Rest Application with JDBC Role based security clone initial branch.
Sample Spring Unit Test cases and Web Intigration Test cases provided in initial branch.
clone link : https://github.com/phanimaridu/mc2-sms.git


Technologies Used
-----------------
JDK 1.7.0
Maven 3.2.3
Spring Development Tool Suite 3.6.4 (IDE)
Spring 4
  Spring Boot
  Spring Data
  Spring Test
  Spring Security
  Spring Web MVC (Restful Webservices)
MySQL 5.5
MySQL Workbench
GIT
Bootstrap
Angular JS
Pencil 2.* (Design and Wire-frames) 
ArgoUML

Note : you can also use eclipse by generating eclipse project from pom.xml (mvn eclipse:eclipse)


Modules
-------
mc2-sms-rest (contaims web servics secured with role based basic authentication)
mc2-sms-web-gui (Bootstrap,AngularJS based MVC GUI consuming mc2-sms-rest) 

Note : mc2-sms-rest    (implemnetation in progress)
       mc2-sms-web-gui (in design phase)
       
       
       
How to Run mc2-sms-rest 
-------------------------
Install JAVA and MAVEN
Install MySQL and import DB Scripts (./db/sms.sql)
Build sources using (mvn package) 
Run application from JAR (java -jar target/mc2-sms-rest-0.1.0.jar)


Refer : https://spring.io/guides/gs/spring-boot/
Note : Change Server Configurations and Database Connection properties in '${MODULE}/src/main/resources/application.properties' file. 
       No need to install any web server . Just start the jar using command



Note : Please find more detailed documetaion in ./docs directory
       Please find sources in ./src directory
