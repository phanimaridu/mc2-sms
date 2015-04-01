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
MySQL 5.6
MySQL Workbench
GIT
Bootstrap
Angular JS
Pencil 2.* (Design and Wire-frames) 
ArgoUML

Note : you can also use eclipse by generating eclipse project from pom.xml (mvn eclipse:eclipse)



Downloads
---------
JDK 1.7.0            (http://download.oracle.com/otn-pub/java/jdk/7u75-b13/jdk-7u75-windows-x64.exe)
Maven 3.2.3          (http://www.trieuvan.com/apache/maven/maven-3/3.2.5/binaries/apache-maven-3.2.5-bin.zip)
Spring STS 3.6.4     (http://dist.springsource.com/release/STS/3.6.4.RELEASE/dist/e4.4/spring-tool-suite-3.6.4.RELEASE-e4.4.2-win32-x86_64.zip)
MySQL 5.6            (http://dev.mysql.com/downloads/)
MySQL Workbench      (http://dev.mysql.com/downloads/)
Pencil 2.*           (http://evoluspencil.googlecode.com/files/Pencil-2.0.5.win32.installer.exe)
ArgoUML              (http://sourceforge.net/projects/argouml.mirror/)

All Spring Dependencies are automatically downloaded by using mvn package.
AngularJS and Bootstrap libraries are provided with gui module source files.



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
       No need to install any web server. Just start the jar using command



Note : Please find more detailed documetaion in ./docs directory
       Please find sources in ./src directory
