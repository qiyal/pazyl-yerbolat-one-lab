package kz.one.tech.prac.one.onetechpracone.model;

public class Professor {
    private String firstName;
    private String lastName;
    private String email;
    private String departmentName;

    public Professor() {}

    public static ProfessorBuilder professorBuilder() {
        return new Professor().new ProfessorBuilder();
    }

    // builder
    public class ProfessorBuilder {

        private ProfessorBuilder() {}

        public ProfessorBuilder firstName(String firstName) {
            Professor.this.firstName = firstName;
            return this;
        }

        public ProfessorBuilder lastName(String lastName) {
            Professor.this.lastName = lastName;
            return this;
        }

        public ProfessorBuilder email(String email) {
            Professor.this.email = email;
            return this;
        }

        public ProfessorBuilder departmentName(String departmentName) {
            Professor.this.departmentName = departmentName;
            return this;
        }

        public Professor build() {
            return Professor.this;
        }
    }

    // getters
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    //setters
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
