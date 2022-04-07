package kz.one.tech.prac.one.onetechpracone.model;

import java.time.LocalDate;

public class Student {
    private String firstName;
    private String lastName;
    private LocalDate lastSubmissionDate;
    private Double gpa;
    private String city;
    private Boolean isHaveScholarship;

    public Student() {}

    public static StudentBuilder studentBuilder() {
        return new Student().new StudentBuilder();
    }

    // builder
    public class StudentBuilder {

        private StudentBuilder() {}

        public StudentBuilder firstName(String firstName) {
            Student.this.firstName = firstName;
            return this;
        }

        public StudentBuilder lastName(String lastName) {
            Student.this.lastName = lastName;
            return this;
        }

        public StudentBuilder lastSubmissionDate(LocalDate lastSubmissionDate) {
            Student.this.lastSubmissionDate = lastSubmissionDate;
            return this;
        }

        public StudentBuilder gpa(Double gpa) {
            Student.this.gpa = gpa;
            return this;
        }

        public StudentBuilder city(String city) {
            Student.this.city = city;
            return this;
        }

        public StudentBuilder isHaveScholarship(Boolean isHaveScholarship) {
            Student.this.isHaveScholarship = isHaveScholarship;
            return this;
        }

        public Student build() {
            return Student.this;
        }
    }

    // setters
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setLastSubmissionDate(LocalDate lastSubmissionDate) {
        this.lastSubmissionDate = lastSubmissionDate;
    }

    public void setGpa(Double gpa) {
        this.gpa = gpa;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setHaveScholarship(Boolean haveScholarship) {
        isHaveScholarship = haveScholarship;
    }

    //getters
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getLastSubmissionDate() {
        return lastSubmissionDate;
    }

    public Double getGpa() {
        return gpa;
    }

    public String getCity() {
        return city;
    }

    public Boolean getHaveScholarship() {
        return isHaveScholarship;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", lastSubmissionDate=" + lastSubmissionDate +
                ", gpa=" + gpa +
                ", city='" + city + '\'' +
                ", isHaveScholarship=" + isHaveScholarship +
                '}';
    }
}
