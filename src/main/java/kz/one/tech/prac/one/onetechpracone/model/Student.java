package kz.one.tech.prac.one.onetechpracone.model;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private Integer id;
    private Integer groupId;
    private String firstName;
    private String lastName;
    private LocalDate lastSubmissionDate;
    private Double gpa;
    private String city;
    private Boolean isHaveScholarship;
}
