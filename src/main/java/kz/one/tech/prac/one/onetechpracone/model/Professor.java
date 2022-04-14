package kz.one.tech.prac.one.onetechpracone.model;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Professor {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String departmentName;
}
