package kz.one.tech.prac.one.onetechpracone;

import kz.one.tech.prac.one.onetechpracone.config.MySpringConfig;
import kz.one.tech.prac.one.onetechpracone.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//@SpringBootApplication
public class OneTechPracOneApplication {

    public static void main(String[] args) {
//        SpringApplication.run(OneTechPracOneApplication.class, args);

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MySpringConfig.class);

        UserService userService = context.getBean("userService", UserService.class);
        userService.runApp();

        context.close();
    }
}
