A School maintenance application (Designed for MC2 STEM HIGH SCHOOL)

If you are looking for Spring Web MVC Rest Application with JDBC Role based security clone security-initial branch.
- Security implemented by using Spring UserDataService and spring-data-jpa.
- User Rest Controller implemented with GET,PUT,POST,DELETE (Complies with Richardson Maturity Model Level - 2 Standards) 
- Sample Spring Unit Test cases and Web Integration Test cases provided in this branch.


Technologies Used
-----------------
JDK 1.7.0
Maven 3.2.3
Spring Development Tool Suite 3.6.4 (IDE)
Spring 4
  Spring Boot
  Spring Boot CLI
  Spring Data JPA
  Hibernate
  Spring Test
  Spring Security
  Spring Web MVC (Restful Webservices)
MySQL 5.6
MySQL Workbench
GIT
Bootstrap
Angular JS
Pencil 2.* (Design and Wire-frames) 
ArgoUML
Swagger


Downloads
---------
JDK 1.7.0            (http://download.oracle.com/otn-pub/java/jdk/7u75-b13/jdk-7u75-windows-x64.exe)
Maven 3.2.3          (http://www.trieuvan.com/apache/maven/maven-3/3.2.5/binaries/apache-maven-3.2.5-bin.zip)
Spring STS 3.6.4     (http://dist.springsource.com/release/STS/3.6.4.RELEASE/dist/e4.4/spring-tool-suite-3.6.4.RELEASE-e4.4.2-win32-x86_64.zip)
Spring Boot CLI      (http://repo.spring.io/release/org/springframework/boot/spring-boot-cli/1.1.4.RELEASE/spring-boot-cli-1.1.4.RELEASE-bin.zip)
MySQL 5.6            (http://dev.mysql.com/downloads/)
MySQL Workbench      (http://dev.mysql.com/downloads/)
Pencil 2.*           (http://evoluspencil.googlecode.com/files/Pencil-2.0.5.win32.installer.exe)
ArgoUML              (http://sourceforge.net/projects/argouml.mirror/)
AngularJS Plugin     (http://marketplace.eclipse.org/content/angularjs-eclipse)



Modules
-------
mc2-sms-rest          (contains web servics secured with role based basic authentication and ssl) 
mc2-sms-uibs-web-gui  (Bootstrap,AngularJS based MVC GUI consuming mc2-sms-rest)  
                      (in design phase)
       
       
How to Run mc2-sms-rest 
-------------------------
Install JAVA and MAVEN
Install MySQL and import DB Scripts (./db/v0.2/sms_create_insert.sql)
Go to '/src/mc2-sms-rest' DIR
  Build sources using (mvn package) 
  Run application from JAR (java -jar target/mc2-sms-rest-0.1.0.jar)  
        OR
  Run command (mvn spring-boot:run)

  
How to Run mc2-sms-uibs-web-gui
-------------------------------
Install Spring Boot CLI
Go to '/src/mc2-sms-uibs-web-gui' DIR
Run command 'spring run app.groovy'


Notes
-----
Refer : https://spring.io/guides/gs/spring-boot/
Please find more detailed documentation in ./docs directory
Please find restful web service documentation at https://{ROOT}/swagger/index.html
Please find sources in ./src directory.
Change Server Configurations and Database Connection properties in '${MODULE}/src/main/resources/application.properties' file. 
For GUI Module Change Server Configurations in '${MODULE}/application.properties' file.

Spring prefixes role names with 'ROLE_'

No need to install any web server for any module.
All Spring Dependencies are automatically downloaded by using mvn package.
AngularJS and Bootstrap libraries are provided with gui module source files.
Spring Boot CLI is needed to host AngualrJS Bootstrap static content.
eclipse project can be generated from pom.xml using (mvn eclipse:eclipse)
You are not restricted to use Spring STS.
