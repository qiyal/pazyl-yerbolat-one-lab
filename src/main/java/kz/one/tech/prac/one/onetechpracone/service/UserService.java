package kz.one.tech.prac.one.onetechpracone.service;

import kz.one.tech.prac.one.onetechpracone.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Scanner;

@Service
public class UserService {
    private AdministrationService administrationService;
    private Scanner scanner;

    @Autowired
    public UserService(AdministrationService administrationService, Scanner scanner) {
        this.administrationService = administrationService;
        this.scanner = scanner;
    }

    public void runApp() {
        int input;

        while (true) {
            showMainMenu();
            input = scanner.nextShort();

            switch (input) {
                case 1:
                    createNewStudent();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    showStudentList();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Unavailable option!!!");
            }
        }
    }

    public void showMainMenu() {
        System.out.println("1 - creat new student");
        System.out.println("2 - creat new teacher");
        System.out.println("3 - create new Group");
        System.out.println("4 - show list of students");
        System.out.println("0 - EXIT");
    }

    public void createNewStudent() {
        String firstName, lastName, city;
        double gpa;
        boolean isHaveScholarship;

        System.out.print("FirstName: ");
        firstName = scanner.nextLine();

        System.out.print("LastName: ");
        lastName = scanner.nextLine();

        System.out.print("City: ");
        city = scanner.nextLine();

        System.out.print("GPA: ");
        gpa = scanner.nextDouble();

        System.out.print("Is have scholarship (true or false): ");
        isHaveScholarship = scanner.nextBoolean();

        Student student = administrationService.createNewUser(
                firstName,
                lastName,
                null,
                gpa,
                city,
                isHaveScholarship);

        administrationService.addUserToList(student);
    }

    public void showStudentList() {
        int i = 0;
        System.out.println("List of Student");
        administrationService.getAllStudents()
                .forEach(
                        item -> System.out.println(i + ") " + item)
                );
    }
}
