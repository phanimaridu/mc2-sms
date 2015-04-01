package edu.mc2.sms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
http://localhost:8081/admin
http://localhost:8081/staff
http://localhost:8081/student
http://localhost:8081/anonymous
 */
@SpringBootApplication
//@ImportResource("classpath:spring-data-source-config.xml")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
