package org.hackamarte.solidarize.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hackamarte.solidarize.enumerator.SolicitationStatus;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Solicitation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "soliciter_id",nullable = false)
    private User soliciter;

    @ManyToOne
    @JoinColumn(name = "organization_soliciter_id")
    private Organization organizationSoliciter;

    @Column(nullable = false, length = 80)
    private String title;

    @Column(nullable = false)
    private String descrition;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany
    private List<Image> images;

    @Column(length = 8)
    private String cep;

    @Column(nullable = false)
    private ZonedDateTime date;

    @Enumerated(EnumType.STRING)
    private SolicitationStatus status;

    @OneToMany
    private List<IntentionOfGiver> intentions;

}
