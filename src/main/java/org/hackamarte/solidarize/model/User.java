package org.hackamarte.solidarize.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, length = 50, unique = true)
    private String login;

    @Column(nullable = false, length = 50)
    private String password;

    @OneToOne
    @JoinColumn(name = "person_id")
    private Person person;

}
