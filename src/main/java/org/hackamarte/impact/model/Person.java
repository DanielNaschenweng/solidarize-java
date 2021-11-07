package org.hackamarte.impact.model;

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
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, length = 80)
    private String name;

    @Column(nullable = false, length = 80)
    private String cpf;

    @Column(nullable = false, length = 80)
    private String phone;

    @Column(nullable = false, length = 50, unique = true)
    private String email;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(length = 8, nullable = false)
    private String cep;

    @ManyToMany
    List<Organization> organizations;

}
