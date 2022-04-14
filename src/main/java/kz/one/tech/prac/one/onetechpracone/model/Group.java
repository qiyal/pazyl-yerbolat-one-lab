package kz.one.tech.prac.one.onetechpracone.model;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Group {
    private Integer id;
    private String name;
    private Integer memberCount;
    private Integer supervisorId;
}
