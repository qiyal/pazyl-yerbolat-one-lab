package kz.one.tech.prac.one.onetechpracone.service;

import kz.one.tech.prac.one.onetechpracone.model.Group;
import kz.one.tech.prac.one.onetechpracone.model.Professor;
import kz.one.tech.prac.one.onetechpracone.model.Student;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;

@Service
public class UserService {
    private AdministrationService administrationService;
    private BufferedReader bufferedReader;
    private boolean isRun;

    @Autowired
    public UserService(AdministrationService administrationService, BufferedReader bufferedReader) {
        this.administrationService = administrationService;
        this.bufferedReader = bufferedReader;
    }

    public void runApp() {
        String input;
        isRun = true;

        System.out.println("\n ***** START APP *****");
        try {
            while (isRun) {
                showMainMenu();

                System.out.print("input: ");

                input = bufferedReader.readLine().trim();

                switch (input) {
                    case "1":
                        createNewStudent();
                        break;
                    case "2":
                        createNewProfessor();
                        break;
                    case "3":
                        createNewGroup();
                    case "4":
                        showStudentList();
                        break;
                    case "5":
                        showProfessorList();
                        break;
                    case "6":
                        showGroupList();
                        break;
                    case "0":
                        stop();
                        System.out.println("\n*** APP EXIT ***");
                        break;
                    default:
                        System.out.println("Unavailable option!!!");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void stop() {
        this.isRun = false;
    }

    public void showMainMenu() {
        System.out.println("\n1 - creat new Student");
        System.out.println("2 - creat new Professors");
        System.out.println("3 - create new Group");
        System.out.println("4 - show list of Students");
        System.out.println("5 - show list of Professors");
        System.out.println("6 - show list of Groups");
        System.out.println("0 - EXIT");
    }

    public void createNewStudent() throws IOException {
        String firstName, lastName, city;
        double gpa;
        boolean isHaveScholarship;

        System.out.println("\n**** CREATE NEW STUDENT *****");
        System.out.print("FirstName: ");
        firstName = bufferedReader.readLine().trim();

        System.out.print("LastName: ");
        lastName = bufferedReader.readLine().trim();

        System.out.print("City: ");
        city = bufferedReader.readLine().trim();

        System.out.print("GPA: ");
        gpa = Double.parseDouble(bufferedReader.readLine().trim());

        System.out.print("Is have scholarship (true or false): ");
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

    public void createNewProfessor() throws IOException {
        String firstName, lastName, email, departmentName;

        System.out.println("\n**** CREATE NEW PROFESSOR *****");
        System.out.print("First Name: ");
        firstName = bufferedReader.readLine().trim();

        System.out.print("Last Name: ");
        lastName = bufferedReader.readLine().trim();

        System.out.print("Email: ");
        email = bufferedReader.readLine().trim();

        System.out.print("Department Name: ");
        departmentName =  bufferedReader.readLine().trim();

        Professor professor = administrationService.createNewProfessor(
                firstName,
                lastName,
                email,
                departmentName);

        administrationService.addProfessorToList(professor);
    }

    public void createNewGroup() throws IOException {
        String name;
        int membersCount;
        Professor professor = null;

        System.out.println("\n**** CREATE NEW GROUP *****");
        System.out.print("Name: ");
        name = bufferedReader.readLine().trim();

        System.out.print("Members count: ");
        membersCount = Integer.parseInt(bufferedReader.readLine().trim());

        // shows list of professors
        String input = "-";
        if (administrationService.getAllProfessors().size() > 0) {
            showProfessorList();
            System.out.println("-) none");
            System.out.print("input (- or index): ");
            input = bufferedReader.readLine().trim();
        }

        // set professor
        if (!input.equals("-")) {
            professor = administrationService.getAllProfessors().get(Integer.parseInt(input));
        }

        Group group = administrationService.createNewGroup(
                name,
                membersCount,
                professor);

        administrationService.addGroupToList(group);
    }

    public void showStudentList() {
        int i = 0;
        System.out.println("\n*** List of Student ***");
        administrationService.getAllStudents()
                .forEach(
                        item -> System.out.println(i + ") " + item)
                );
    }

    public void showProfessorList() {
        int i = 0;
        System.out.println("\n*** List of Professor ***");
        administrationService.getAllProfessors()
                .forEach(
                        item -> System.out.println(i + ") " + item)
                );
    }

    public void showGroupList() {
        int i = 0;
        System.out.println("\n*** List of Group ***");
        administrationService.getAllGroups()
                .forEach(
                        item -> System.out.println(i + ") " + item)
                );
    }
}
