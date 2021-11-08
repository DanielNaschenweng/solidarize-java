package org.hackamarte.solidarize.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, length = 80)
    private String name;

    @Column(nullable = false, length = 80)
    private String corporateName;

    @Column(nullable = false, length = 15)
    private String cnpj;

    @Column(nullable = false, length = 80)
    private String phone;

    @Column(nullable = false, length = 50, unique = true)
    private String email;

    @ManyToMany
    private List<Person> persons;

}
