package kz.one.tech.prac.one.onetechpracone;

import kz.one.tech.prac.one.onetechpracone.model.Student;
import kz.one.tech.prac.one.onetechpracone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Scanner;

@SpringBootApplication
public class OneTechPracOneApplication {

    public static void main(String[] args) {
        SpringApplication.run(OneTechPracOneApplication.class, args);
//        ApplicationContext applicationContext = new AnnotationConfigApplicationContext();
//        UserService userService = (UserService) applicationContext.getBean("userService");
//        userService.runApp();
    }

    @Bean
    public Scanner scanner() {
        return new Scanner(System.in);
    }
}
