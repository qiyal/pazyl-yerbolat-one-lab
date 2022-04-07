package kz.one.tech.prac.one.onetechpracone.service;

import kz.one.tech.prac.one.onetechpracone.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

@Service
public class UserService {
    private AdministrationService administrationService;
    private BufferedReader bufferedReader;

    @Autowired
    public UserService(AdministrationService administrationService, BufferedReader bufferedReader) {
        this.administrationService = administrationService;
        this.bufferedReader = bufferedReader;
    }

    public void runApp() {
        String input;
        boolean stop = false;

        try {
            while (!stop) {
                showMainMenu();

                System.out.println("input: ");

                input = bufferedReader.readLine().trim();

                switch (input) {
                    case "1":
                        createNewStudent();
                        break;
                    case "2":
                        break;
                    case "3":
                        break;
                    case "4":
                        showStudentList();
                        break;
                    case "0":
                        stop = true;
                        break;
                    default:
                        System.out.println("Unavailable option!!!");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void showMainMenu() {
        System.out.println("1 - creat new student");
        System.out.println("2 - creat new teacher");
        System.out.println("3 - create new Group");
        System.out.println("4 - show list of students");
        System.out.println("0 - EXIT");
    }

    public void createNewStudent() throws IOException {
        String firstName, lastName, city;
        double gpa;
        boolean isHaveScholarship;

        System.out.println("FirstName: ");
        firstName = bufferedReader.readLine().trim();

        System.out.println("LastName: ");
        lastName = bufferedReader.readLine().trim();

        System.out.println("City: ");
        city = bufferedReader.readLine().trim();

        System.out.println("GPA: ");
        gpa = Double.parseDouble(bufferedReader.readLine().trim());

        System.out.println("Is have scholarship (true or false): ");
        isHaveScholarship = Boolean.parseBoolean(bufferedReader.readLine().trim());

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
