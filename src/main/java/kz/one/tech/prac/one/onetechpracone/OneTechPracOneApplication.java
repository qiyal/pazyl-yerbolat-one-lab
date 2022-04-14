package kz.one.tech.prac.one.onetechpracone;

import kz.one.tech.prac.one.onetechpracone.config.MySpringConfig;
import kz.one.tech.prac.one.onetechpracone.repository.StudentRepository;
import kz.one.tech.prac.one.onetechpracone.repository.impl.StudentRepositoryImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//@SpringBootApplication
public class OneTechPracOneApplication {

    public static void main(String[] args) {
//        SpringApplication.run(OneTechPracOneApplication.class, args);

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MySpringConfig.class);

//        GroupRepository userService = context.getBean("groupRepositoryImpl", GroupRepositoryImpl.class);
//        userService.insert("test_name1", 0, null);
//        System.out.println("********** after insert");
//        userService.selectAll().forEach(System.out::println);
//        userService.delete(1);
////        System.out.println("kdjfkdsfsjkl");
//        System.out.println("after delete");
//        userService.selectAll().forEach(System.out::println);
//        System.out.println("************ ****");
//        userService.findByNameLike("%IS%").forEach(System.out::println);

//        ProfessorRepository professorRepository = context.getBean("professorRepositoryImpl", ProfessorRepositoryImpl.class);
//        professorRepository.insert("PNEW", "PNEW", "email", "IS");
//        System.out.println("********** after insert");
//        professorRepository.selectAll().forEach(System.out::println);
//        professorRepository.delete(1);
////        System.out.println("kdjfkdsfsjkl");
//        System.out.println("after delete");
//        professorRepository.selectAll().forEach(System.out::println);
//        System.out.println("************ ****");
//        professorRepository.findByDepartmentName("IS").forEach(System.out::println);

        StudentRepository studentRepository = context.getBean("studentRepositoryImpl", StudentRepositoryImpl.class);
        studentRepository.insert(1, "SNEW", "SNEW", "Almaty");
        System.out.println("********** after insert");
        studentRepository.selectAll().forEach(System.out::println);
        studentRepository.delete(1);
//        System.out.println("kdjfkdsfsjkl");
        System.out.println("after delete");
        studentRepository.selectAll().forEach(System.out::println);
        System.out.println("************ ****");
        studentRepository.findByFirstNameLikeOrLastNameLike("%Yer%").forEach(System.out::println);

        context.close();
    }
}
