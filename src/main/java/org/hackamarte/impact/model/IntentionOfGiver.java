package org.hackamarte.impact.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hackamarte.impact.enumerator.DonationStatus;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class IntentionOfGiver {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "giver_id")
    private User giver;

    @ManyToOne
    @JoinColumn(name = "organization_giver_id")
    private Organization organizationGiver;

    @ManyToOne(optional = false)
    @JoinColumn(name = "solicitation_id")
    private Solicitation solicitation;


    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DonationStatus status;



}
